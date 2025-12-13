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
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Redu��o Base de C�lculo
 * 
 * <p>Classe Java de TRed complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TRed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pRedAliq" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302_04RTC"/>
 *         &lt;element name="pAliqEfet" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302_04RTC"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRed", propOrder = {
    "pRedAliq",
    "pAliqEfet"
})
public class TRed {

    @XmlElement(required = true)
    protected String pRedAliq;
    @XmlElement(required = true)
    protected String pAliqEfet;

    /**
     * Obt�m o valor da propriedade pRedAliq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRedAliq() {
        return pRedAliq;
    }

    /**
     * Define o valor da propriedade pRedAliq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRedAliq(String value) {
        this.pRedAliq = value;
    }

    /**
     * Obt�m o valor da propriedade pAliqEfet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAliqEfet() {
        return pAliqEfet;
    }

    /**
     * Define o valor da propriedade pAliqEfet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAliqEfet(String value) {
        this.pAliqEfet = value;
    }

}
