//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2025.12.13 �s 10:09:55 AM BRT 
//


package xsdobjects.enviNFe400;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Tipo Informa��es do cr�dito presumido de IBS para fornecimentos a partir da ZFM
 * 
 * <p>Classe Java de TCredPresIBSZFM complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCredPresIBSZFM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="competApur" type="{http://www.portalfiscal.inf.br/nfe}TCompetApur"/>
 *         &lt;element name="tpCredPresIBSZFM" type="{http://www.portalfiscal.inf.br/nfe}TTpCredPresIBSZFM"/>
 *         &lt;element name="vCredPresIBSZFM" type="{http://www.portalfiscal.inf.br/nfe}TDec1302RTC"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCredPresIBSZFM", propOrder = {
    "competApur",
    "tpCredPresIBSZFM",
    "vCredPresIBSZFM"
})
public class TCredPresIBSZFM {

    @XmlElement(required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar competApur;
    @XmlElement(required = true)
    protected String tpCredPresIBSZFM;
    @XmlElement(required = true)
    protected String vCredPresIBSZFM;

    /**
     * Obt�m o valor da propriedade competApur.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompetApur() {
        return competApur;
    }

    /**
     * Define o valor da propriedade competApur.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompetApur(XMLGregorianCalendar value) {
        this.competApur = value;
    }

    /**
     * Obt�m o valor da propriedade tpCredPresIBSZFM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpCredPresIBSZFM() {
        return tpCredPresIBSZFM;
    }

    /**
     * Define o valor da propriedade tpCredPresIBSZFM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpCredPresIBSZFM(String value) {
        this.tpCredPresIBSZFM = value;
    }

    /**
     * Obt�m o valor da propriedade vCredPresIBSZFM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCredPresIBSZFM() {
        return vCredPresIBSZFM;
    }

    /**
     * Define o valor da propriedade vCredPresIBSZFM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCredPresIBSZFM(String value) {
        this.vCredPresIBSZFM = value;
    }

}
