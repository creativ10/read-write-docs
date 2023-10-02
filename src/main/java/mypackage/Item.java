
package mypackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for item complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="item"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ddv"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="discount"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {
    "itemName",
    "quantity",
    "price",
    "ddv",
    "discount"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @XmlElement(required = true)
    protected String itemName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger quantity;
    protected double price;
    @XmlElement(defaultValue = "0.095")
    protected double ddv;
    @XmlElement(defaultValue = "0.0")
    protected double discount;

    public Item() {
    }

    @JsonCreator
    public Item( @JsonProperty("itemName") String itemName,
                 @JsonProperty("quantity") BigInteger quantity,
                 @JsonProperty("price") double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.discount = 0.0;
        this.ddv = 0.095;
    }

    /**
     * Gets the value of the itemName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the value of the itemName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the price property.
     *
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the ddv property.
     *
     */
    public double getDdv() {
        return ddv;
    }

    /**
     * Sets the value of the ddv property.
     *
     */
    @JsonSetter("ddv")
    public void setDdv(double value) {
        this.ddv = value;
    }

    /**
     * Gets the value of the discount property.
     *
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     *
     */
    @JsonSetter("discount")
    public void setDiscount(double value) {
        this.discount = value;
    }

    public double getValue() {
        return ((this.price * (1 - this.discount)) * (1 + this.ddv)) * this.quantity.doubleValue();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", ddv=" + ddv +
                ", discount=" + discount +
                '}';
    }
}
