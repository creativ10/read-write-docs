
package mypackage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="docType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SIMPLE"/&gt;
 *     &lt;enumeration value="COMPLEX"/&gt;
 *     &lt;enumeration value="DISCOUNTED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "docType")
@XmlEnum
public enum DocType {

    SIMPLE,
    COMPLEX,
    DISCOUNTED;

    public String value() {
        return name();
    }

    public static DocType fromValue(String v) {
        return valueOf(v);
    }

}
