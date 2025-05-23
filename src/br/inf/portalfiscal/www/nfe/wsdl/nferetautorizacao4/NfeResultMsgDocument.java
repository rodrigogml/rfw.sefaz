/*
 * An XML document type.
 * Localname: nfeResultMsg
 * Namespace: http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4
 * Java type: br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument
 *
 * Automatically generated - do not modify.
 */
package br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4;


/**
 * A document containing one nfeResultMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4) element.
 *
 * This is a complex type.
 */
public interface NfeResultMsgDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NfeResultMsgDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8FF550395CBF4C1A36D21F2A5F1749A").resolveHandle("nferesultmsg6126doctype");
    
    /**
     * Gets the "nfeResultMsg" element
     */
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg getNfeResultMsg();
    
    /**
     * Sets the "nfeResultMsg" element
     */
    void setNfeResultMsg(br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg nfeResultMsg);
    
    /**
     * Appends and returns a new empty "nfeResultMsg" element
     */
    br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg addNewNfeResultMsg();
    
    /**
     * An XML nfeResultMsg(@http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4).
     *
     * This is a complex type.
     */
    public interface NfeResultMsg extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NfeResultMsg.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8FF550395CBF4C1A36D21F2A5F1749A").resolveHandle("nferesultmsgb0f9elemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg newInstance() {
              return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument.NfeResultMsg) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument newInstance() {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.inf.portalfiscal.www.nfe.wsdl.nferetautorizacao4.NfeResultMsgDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
