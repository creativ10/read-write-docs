package buisness;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import gui.Gui;
import mypackage.Footer;
import mypackage.ObjectFactory;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

import org.apache.log4j.*;

public class BusinessLogic {
    private File file;
    public Boolean correctFormat;
    public String path;
    private mypackage.Bill bill;
    public BusinessLogic(File file, Boolean reading) throws IOException, JAXBException {
        this.file = file;
        this.path = "C:\\Users\\Mark\\Desktop\\job_trial\\presentation\\src\\main\\resources\\";
        if(reading){
            System.out.println("Branje dokumenta " + file.getName());
            gui.Gui.LOGGER.log(Level.INFO,"Branje dokumenta "+file.getName());
        }else{
            System.out.println("Sprejet dokument v poslovno logiko.");
            gui.Gui.LOGGER.log(Level.INFO,"Sprejet dokument v poslovno logiko.");
        }
        Optional<String> extention = getExtension(this.file.getName());
        if(extention.isPresent() && (!extention.get().equals("json") && !extention.get().equals("xml"))){
           correctFormat = false;
           System.out.println("Napacen format dokumenta.");
           gui.Gui.LOGGER.warn("Napacen format dokumenta.");
        }else{
            correctFormat = true;
            if(extention.isPresent() && extention.get().equals("json")){
                System.out.println("Parsanje json datoteke.");
                gui.Gui.LOGGER.log(Level.INFO,"Parsanje json datoteke.");
                bill = checkJSON(file);
                if(bill != null && !reading){
                   writeToFile(bill, true);
                   System.out.println("Uspešno kreirana JSON datoteka !");
                    gui.Gui.LOGGER.log(Level.INFO,"Uspešno kreirana JSON datoteka !");
                }
            }else{
                System.out.println("Parsanje xml datoteke.");
                gui.Gui.LOGGER.log(Level.INFO,"Parsanje xml datoteke.");
                bill = checkXML(file);
                if(bill != null && !reading){
                    writeToFile(bill, false);
                    System.out.println("Uspešno kreirana XML datoteka !");
                    gui.Gui.LOGGER.log(Level.INFO,"Uspešno kreirana XML datoteka !");
                }
            }
        }
    }

    public mypackage.Bill getBill(){
        return this.bill;
    }

    public Optional<String> getExtension(String filename) {
        return Optional.ofNullable(filename).filter(f -> f.contains(".")).map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    private mypackage.Bill checkJSON(File file){
        ObjectMapper om = new ObjectMapper();
        try {
            return om.reader(mypackage.Bill.class).readValue(file);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }

    private mypackage.Bill checkXML(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
        mypackage.Bill b = (mypackage.Bill) context.createUnmarshaller().unmarshal(file);
        double sum = 0.0;
        double sumWithoutDDV = 0.0;
        double ddvSum = 0.0;
        for (mypackage.Item r : b.getRate().getItem()) {
            sumWithoutDDV += r.getPrice();
            ddvSum += r.getDdv();
            sum += r.getValue();
        }
        b.setFooter(new Footer(sumWithoutDDV, ddvSum, sum));
        return b;
    }

    private void writeToFile(mypackage.Bill serializedObject,Boolean isJSON) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String rez = om.writeValueAsString(serializedObject);
        try {
            if(isJSON) {
                FileWriter writer = new FileWriter (this.path+"json/"+serializedObject.getHeader().getBillNumber()+".json");
                writer.write(rez);
                writer.close();
            } else{
                File writer = new File(this.path+"xml/"+serializedObject.getHeader().getBillNumber()+".xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(mypackage.Bill.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.marshal(serializedObject, writer);
            }


        } catch (IOException | JAXBException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
