package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import buisness.BusinessLogic;
import mypackage.Footer;
import mypackage.Header;
import mypackage.Item;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Gui extends javax.swing.JFrame {
    public static final Logger LOGGER = LogManager.getLogger(BusinessLogic.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOGGER.log(Level.INFO,"Zacetek appa");
        Gui gui = new Gui( );
    }

    public ButtonGroup group;
    public JFormattedTextField amountField;

    public Gui() {
        JButton btn = new JButton("Dodaj dokument");
        JFrame frame = new JFrame("Dodajanje dokumentov");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton btn1 = new JButton("Pridobi dokument");
        panel.add(btn);
        panel.add(btn1);
        btn.addActionListener(e -> {
            try {
                if(selectFile()== -1){
                    JOptionPane.showMessageDialog(frame, "Please select xml or json file! ");
                    LOGGER.warn("Please select xml or json file!");
                }
            } catch (IOException | JAXBException ex) {
                ex.printStackTrace();
            }
        });
        JRadioButton xmlButton = new JRadioButton("XML");
        xmlButton.setActionCommand("xml");
        JRadioButton jsonButton = new JRadioButton("JSON");
        jsonButton.setActionCommand("json");
        group = new ButtonGroup();
        jsonButton.setSelected(true);
        NumberFormat amountFormat = NumberFormat.getNumberInstance();
        amountField = new JFormattedTextField(amountFormat);
        amountField.setValue(0);
        amountField.setColumns(10);
        panel.add(xmlButton);
        panel.add(jsonButton);
        panel.add(amountField);
        group.add(xmlButton);
        group.add(jsonButton);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        btn1.addActionListener(e->{
            BusinessLogic bs = getFile();
            if(bs != null){
                StringBuilder sb = new StringBuilder();
                Header header = bs.getBill().getHeader();
                Footer footer = bs.getBill().getFooter();
                sb.append("Header:\n  Sender:\n    Fiscal Code: ").append(header.getSender().getFiscalCode()).append("\n    Address: ").append(header.getSender().getAddress()).append("\n    CompanyName: ").append(header.getSender().getCompanyName());
                sb.append("\n  Receiver:\n    Fiscal Code: ").append(header.getReceiver().getFiscalCode()).append("\n    Address: ").append(header.getReceiver().getAddress()).append("\n    CompanyName: ").append(header.getReceiver().getCompanyName());
                sb.append("\n  Date: ").append(header.getDate());
                sb.append("\n  Bill number: ").append(header.getBillNumber());
                sb.append("\n  DocType: ").append(header.getDocType());
                sb.append("\nFooter:\n  Sum without DDV: ").append(footer.getSummationWithoutDDV()).append("\n  Sum of DDV: ").append(footer.getSummationWithDDV()).append("\n  Sum: ").append(footer.getSummation());
                for(Item i : bs.getBill().getRate().getItem()){
                    sb.append("\nRates:\n  Item:\n    Item name: ").append(i.getItemName()).append("\n    Quantity: ").append(i.getQuantity()).append("\n    price: ").append(i.getPrice()).append("\n    ddv: ").append(i.getDdv()).append("\n    discount: ").append(i.getDiscount());
                }
                JOptionPane.showMessageDialog(frame, sb.toString());
                LOGGER.warn("Please select xml or json file!");
            }
        });
    }

    public int selectFile() throws IOException, JAXBException {
        JFileChooser chooser = new JFileChooser("C:\\Users\\Mark\\Desktop\\job_trial\\presentation\\src\\main\\resources");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON and XML files", "xml", "json");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            BusinessLogic bs = new BusinessLogic(f, false);
            if(!bs.correctFormat){
                return -1;
            }
        }
        return 0;
    }

    public BusinessLogic getFile(){
        try{
            File f = new File("C:\\Users\\Mark\\Desktop\\job_trial\\presentation\\src\\main\\resources\\"
                    +this.group.getSelection().getActionCommand() +"\\"+this.amountField.getValue().toString()+"."
                    +this.group.getSelection().getActionCommand());
            BusinessLogic bs =  new BusinessLogic(f, true);
            if(bs.getBill()!= null){
                LOGGER.log(Level.INFO,"Prebrana datoteka: \n" + bs.getBill().toString());
                System.out.println("Prebrana datoteka:\n" + bs.getBill().toString());
                return bs;
            }else{
                LOGGER.log(Level.ERROR,"Datoteka ne obstaja!");
            }

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}