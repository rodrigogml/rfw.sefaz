/*
 * An XML document type.
 * Localname: nfeDadosMsgZip
 * Namespace: http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4
 * Java type: br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeDadosMsgZipDocument
 *
 * Automatically generated - do not modify.
 */
package br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.impl;
/**
 * A document containing one nfeDadosMsgZip(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4) element.
 *
 * This is a complex type.
 */
public class NfeDadosMsgZipDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeDadosMsgZipDocument
{
    private static final long serialVersionUID = 1L;
    
    public NfeDadosMsgZipDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NFEDADOSMSGZIP$0 = 
        new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "nfeDadosMsgZip");
    
    
    /**
     * Gets the "nfeDadosMsgZip" element
     */
    public java.lang.String getNfeDadosMsgZip()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NFEDADOSMSGZIP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nfeDadosMsgZip" element
     */
    public org.apache.xmlbeans.XmlString xgetNfeDadosMsgZip()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NFEDADOSMSGZIP$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "nfeDadosMsgZip" element
     */
    public void setNfeDadosMsgZip(java.lang.String nfeDadosMsgZip)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NFEDADOSMSGZIP$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NFEDADOSMSGZIP$0);
            }
            target.setStringValue(nfeDadosMsgZip);
        }
    }
    
    /**
     * Sets (as xml) the "nfeDadosMsgZip" element
     */
    public void xsetNfeDadosMsgZip(org.apache.xmlbeans.XmlString nfeDadosMsgZip)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NFEDADOSMSGZIP$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NFEDADOSMSGZIP$0);
            }
            target.set(nfeDadosMsgZip);
        }
    }
}
