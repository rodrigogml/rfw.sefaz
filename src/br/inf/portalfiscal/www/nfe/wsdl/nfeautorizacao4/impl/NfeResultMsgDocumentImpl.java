/*
 * An XML document type.
 * Localname: nfeResultMsg
 * Namespace: http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4
 * Java type: br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument
 *
 * Automatically generated - do not modify.
 */
package br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.impl;
/**
 * A document containing one nfeResultMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4) element.
 *
 * This is a complex type.
 */
public class NfeResultMsgDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument
{
    private static final long serialVersionUID = 1L;
    
    public NfeResultMsgDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NFERESULTMSG$0 = 
        new javax.xml.namespace.QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", "nfeResultMsg");
    
    
    /**
     * Gets the "nfeResultMsg" element
     */
    public br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg getNfeResultMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg target = null;
            target = (br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg)get_store().find_element_user(NFERESULTMSG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "nfeResultMsg" element
     */
    public void setNfeResultMsg(br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg nfeResultMsg)
    {
        generatedSetterHelperImpl(nfeResultMsg, NFERESULTMSG$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "nfeResultMsg" element
     */
    public br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg addNewNfeResultMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg target = null;
            target = (br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg)get_store().add_element_user(NFERESULTMSG$0);
            return target;
        }
    }
    /**
     * An XML nfeResultMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4).
     *
     * This is a complex type.
     */
    public static class NfeResultMsgImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.inf.portalfiscal.www.nfe.wsdl.nfeautorizacao4.NfeResultMsgDocument.NfeResultMsg
    {
        private static final long serialVersionUID = 1L;
        
        public NfeResultMsgImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
