
package mypackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Footer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Footer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="summationWithoutDDV"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="summationWithDDV"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="summation"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
 *               &lt;minInclusive value="0"/&gt;
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
@XmlType(name = "Footer", propOrder = {
    "summationWithoutDDV",
    "summationWithDDV",
    "summation"
})
public class Footer {

    protected double summationWithoutDDV;
    protected double summationWithDDV;
    protected double summation;

    public Footer(){}
    @JsonCreator
    public Footer(
            @JsonProperty("summationWithoutDDV") double summationWithoutDDV,
            @JsonProperty("summationWithDDV") double summationWithDDV,
            @JsonProperty("summation") double summation) {
        this.summationWithoutDDV = summationWithoutDDV;
        this.summationWithDDV = summationWithDDV;
        this.summation = summation;
    }
    /**
     * Gets the value of the summationWithoutDDV property.
     *
     */
    public double getSummationWithoutDDV() {
        return summationWithoutDDV;
    }

    /**
     * Sets the value of the summationWithoutDDV property.
     *
     */
    public void setSummationWithoutDDV(double value) {
        this.summationWithoutDDV = value;
    }

    /**
     * Gets the value of the summationWithDDV property.
     *
     */
    public double getSummationWithDDV() {
        return summationWithDDV;
    }

    /**
     * Sets the value of the summationWithDDV property.
     *
     */
    public void setSummationWithDDV(double value) {
        this.summationWithDDV = value;
    }

    /**
     * Gets the value of the summation property.
     *
     */
    public double getSummation() {
        return summation;
    }

    /**
     * Sets the value of the summation property.
     *
     */
    public void setSummation(double value) {
        this.summation = value;
    }

    @Override
    public String toString() {
        return "Footer{" +
                "summationWithoutDDV=" + summationWithoutDDV +
                ", summationWithDDV=" + summationWithDDV +
                ", summation=" + summation +
                '}';
    }
}
