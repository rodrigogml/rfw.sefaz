//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2025.02.12 �s 06:17:13 PM BRT 
//


package xsdobjects.inutNFe400;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Pedido de inutilza��o de n�mera��o de  NF-e processado
 * 
 * <p>Classe Java de TProcInutNFe complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TProcInutNFe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inutNFe" type="{http://www.portalfiscal.inf.br/nfe}TInutNFe"/>
 *         &lt;element name="retInutNFe" type="{http://www.portalfiscal.inf.br/nfe}TRetInutNFe"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerInutNFe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProcInutNFe", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = {
    "inutNFe",
    "retInutNFe"
})
public class TProcInutNFe {

    @XmlElement(required = true)
    protected TInutNFe inutNFe;
    @XmlElement(required = true)
    protected TRetInutNFe retInutNFe;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Obt�m o valor da propriedade inutNFe.
     * 
     * @return
     *     possible object is
     *     {@link TInutNFe }
     *     
     */
    public TInutNFe getInutNFe() {
        return inutNFe;
    }

    /**
     * Define o valor da propriedade inutNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TInutNFe }
     *     
     */
    public void setInutNFe(TInutNFe value) {
        this.inutNFe = value;
    }

    /**
     * Obt�m o valor da propriedade retInutNFe.
     * 
     * @return
     *     possible object is
     *     {@link TRetInutNFe }
     *     
     */
    public TRetInutNFe getRetInutNFe() {
        return retInutNFe;
    }

    /**
     * Define o valor da propriedade retInutNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetInutNFe }
     *     
     */
    public void setRetInutNFe(TRetInutNFe value) {
        this.retInutNFe = value;
    }

    /**
     * Obt�m o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

}
