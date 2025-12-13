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
 * Tipo Estorno de Cr�dito
 * 
 * <p>Classe Java de TEstornoCred complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TEstornoCred">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vIBSEstCred" type="{http://www.portalfiscal.inf.br/nfe}TDec1302RTC"/>
 *         &lt;element name="vCBSEstCred" type="{http://www.portalfiscal.inf.br/nfe}TDec1302RTC"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEstornoCred", propOrder = {
    "vibsEstCred",
    "vcbsEstCred"
})
public class TEstornoCred {

    @XmlElement(name = "vIBSEstCred", required = true)
    protected String vibsEstCred;
    @XmlElement(name = "vCBSEstCred", required = true)
    protected String vcbsEstCred;

    /**
     * Obt�m o valor da propriedade vibsEstCred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVIBSEstCred() {
        return vibsEstCred;
    }

    /**
     * Define o valor da propriedade vibsEstCred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVIBSEstCred(String value) {
        this.vibsEstCred = value;
    }

    /**
     * Obt�m o valor da propriedade vcbsEstCred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCBSEstCred() {
        return vcbsEstCred;
    }

    /**
     * Define o valor da propriedade vcbsEstCred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCBSEstCred(String value) {
        this.vcbsEstCred = value;
    }

}
