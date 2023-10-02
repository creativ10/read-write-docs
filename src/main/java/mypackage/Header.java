
package mypackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Header complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Header"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Sender" type="{}Sender"/&gt;
 *         &lt;element name="Receiver" type="{}Receiver"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="billNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="docType" type="{}docType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header", propOrder = {
    "sender",
    "receiver",
    "date",
    "billNumber",
    "docType"
})
public class Header {

    @XmlElement(name = "Sender", required = true)
    protected Sender sender;
    @XmlElement(name = "Receiver", required = true)
    protected Receiver receiver;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger billNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DocType docType;


    public Header(){}

    @JsonCreator
    public Header(@JsonProperty("Sender") Sender sender,
                  @JsonProperty("Receiver") Receiver receiver,
                  @JsonProperty("date") XMLGregorianCalendar date,
                  @JsonProperty("billNumber") BigInteger billNumber,
                  @JsonProperty("docType") DocType docType) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.billNumber = billNumber;
        this.docType = docType;
    }

    /**
     * Gets the value of the sender property.
     *
     * @return
     *     possible object is
     *     {@link Sender }
     *
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     *
     * @param value
     *     allowed object is
     *     {@link Sender }
     *
     */
    public void setSender(Sender value) {
        this.sender = value;
    }

    /**
     * Gets the value of the receiver property.
     *
     * @return
     *     possible object is
     *     {@link Receiver }
     *
     */
    public Receiver getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     *
     * @param value
     *     allowed object is
     *     {@link Receiver }
     *
     */
    public void setReceiver(Receiver value) {
        this.receiver = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the billNumber property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getBillNumber() {
        return billNumber;
    }

    /**
     * Sets the value of the billNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setBillNumber(BigInteger value) {
        this.billNumber = value;
    }

    /**
     * Gets the value of the docType property.
     *
     * @return
     *     possible object is
     *     {@link DocType }
     *
     */
    public DocType getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     *
     * @param value
     *     allowed object is
     *     {@link DocType }
     *
     */
    public void setDocType(DocType value) {
        this.docType = value;
    }

    @Override
    public String toString() {
        return "Header{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", date=" + date +
                ", billNumber=" + billNumber +
                ", docType=" + docType +
                '}';
    }
}
