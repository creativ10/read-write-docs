
package mypackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Header" type="{}Header"/&gt;
 *         &lt;element name="Footer" type="{}Footer"/&gt;
 *         &lt;element name="Rate" type="{}Rate"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "footer",
    "rate"
})
@XmlRootElement(name = "Bill")
public class Bill {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "Footer", required = true)
    protected Footer footer;
    @XmlElement(name = "Rate", required = true)
    protected Rate rate;

    @JsonCreator
    public Bill(@JsonProperty("Header") Header header, @JsonProperty("Rate") Rate rate) {
        this.header = header;
        this.rate = rate;
        double sum = 0.0;
        double sumWithoutDDV = 0.0;
        double ddvSum = 0.0;
        for (Item r : rate.getItem()) {
            sumWithoutDDV += r.getPrice();
            ddvSum += r.getDdv();
            sum += r.getValue();
        }
        this.footer = new Footer();
        this.footer.setSummation(sum);
        this.footer.setSummationWithDDV(sumWithoutDDV);
        this.footer.setSummationWithDDV(ddvSum);
    }
    public Bill(){}
    /**
     * Gets the value of the header property.
     *
     * @return
     *     possible object is
     *     {@link Header }
     *
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value
     *     allowed object is
     *     {@link Header }
     *
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the footer property.
     *
     * @return
     *     possible object is
     *     {@link Footer }
     *
     */
    public Footer getFooter() {
        return footer;
    }

    /**
     * Sets the value of the footer property.
     *
     * @param value
     *     allowed object is
     *     {@link Footer }
     *
     */
    public void setFooter(Footer value) {
        this.footer = value;
    }

    /**
     * Gets the value of the rate property.
     *
     * @return
     *     possible object is
     *     {@link Rate }
     *
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     *
     * @param rate
     *     allowed object is
     *     {@link Rate }
     *
     */
    @JsonSetter("Rate")
    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "header=" + header +
                ", footer=" + footer +
                ", rate=" + rate +
                '}';
    }
}
