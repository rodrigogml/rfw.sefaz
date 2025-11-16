/*
 * An XML document type.
 * Localname: nfeDadosMsg
 * Namespace: http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4
 * Java type: br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument
 *
 * Automatically generated - do not modify.
 */
package br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.impl;

// Codificação UTF-8 – caracteres de exemplo: á, é, í, ó, ú, ç.

/**
 * A document containing one nfeDadosMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4) element.
 *
 * This is a complex type.
 */
public class NfeDadosMsgDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument
{
    private static final long serialVersionUID = 1L;
    
    public NfeDadosMsgDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NFEDADOSMSG$0 = 
        new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", "nfeDadosMsg");
    
    
    /**
     * Gets the "nfeDadosMsg" element
     */
    public br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg getNfeDadosMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg target = null;
            target = (br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg)get_store().find_element_user(NFEDADOSMSG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "nfeDadosMsg" element
     */
    public void setNfeDadosMsg(br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg nfeDadosMsg)
    {
        generatedSetterHelperImpl(nfeDadosMsg, NFEDADOSMSG$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "nfeDadosMsg" element
     */
    public br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg addNewNfeDadosMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg target = null;
            target = (br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg)get_store().add_element_user(NFEDADOSMSG$0);
            return target;
        }
    }
    /**
     * An XML nfeDadosMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4).
     *
     * This is a complex type.
     */
    public static class NfeDadosMsgImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico4.NfeDadosMsgDocument.NfeDadosMsg
    {
        private static final long serialVersionUID = 1L;
        
        public NfeDadosMsgImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
