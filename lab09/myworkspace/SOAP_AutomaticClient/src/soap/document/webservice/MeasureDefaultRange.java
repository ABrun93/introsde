
package soap.document.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per measureDefaultRange complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="measureDefaultRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idRange" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rangeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measureDefaultRange", propOrder = {
    "alarmLevel",
    "endValue",
    "idRange",
    "rangeName",
    "startValue"
})
public class MeasureDefaultRange {

    protected String alarmLevel;
    protected String endValue;
    protected int idRange;
    protected String rangeName;
    protected String startValue;

    /**
     * Recupera il valore della proprietà alarmLevel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * Imposta il valore della proprietà alarmLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmLevel(String value) {
        this.alarmLevel = value;
    }

    /**
     * Recupera il valore della proprietà endValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndValue() {
        return endValue;
    }

    /**
     * Imposta il valore della proprietà endValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndValue(String value) {
        this.endValue = value;
    }

    /**
     * Recupera il valore della proprietà idRange.
     * 
     */
    public int getIdRange() {
        return idRange;
    }

    /**
     * Imposta il valore della proprietà idRange.
     * 
     */
    public void setIdRange(int value) {
        this.idRange = value;
    }

    /**
     * Recupera il valore della proprietà rangeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRangeName() {
        return rangeName;
    }

    /**
     * Imposta il valore della proprietà rangeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRangeName(String value) {
        this.rangeName = value;
    }

    /**
     * Recupera il valore della proprietà startValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartValue() {
        return startValue;
    }

    /**
     * Imposta il valore della proprietà startValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartValue(String value) {
        this.startValue = value;
    }

}
