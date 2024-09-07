package br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4;

/*
 *  CadConsultaCadastro4Stub java implementation
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class CadConsultaCadastro4Stub extends org.apache.axis2.client.Stub {
  protected org.apache.axis2.description.AxisOperation[] _operations;

  // hashmaps to keep the fault mapping
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String> faultExceptionNameMap = new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String> faultExceptionClassNameMap = new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, java.lang.String> faultMessageMap = new java.util.HashMap<org.apache.axis2.client.FaultMapKey, java.lang.String>();

  private static int counter = 0;

  private static synchronized java.lang.String getUniqueSuffix() {
    // reset the counter if it is greater than 99999
    if (counter > 99999) {
      counter = 0;
    }
    counter = counter + 1;
    return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
  }

  private void populateAxisService() throws org.apache.axis2.AxisFault {

    // creating the Service with a unique name
    _service = new org.apache.axis2.description.AxisService("CadConsultaCadastro4" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[1];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName(
            "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "consultaCadastro"));
    _service.addOperation(__operation);

    _operations[0] = __operation;
  }

  // populates the faults
  private void populateFaults() {
  }

  /** Constructor that takes in a configContext */
  public CadConsultaCadastro4Stub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public CadConsultaCadastro4Stub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint,
      boolean useSeparateListener)
      throws org.apache.axis2.AxisFault {
    // To populate AxisService
    populateAxisService();
    populateFaults();

    _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

    _serviceClient
        .getOptions()
        .setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    // Set the soap version
    _serviceClient
        .getOptions()
        .setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
  }

  /** Default Constructor */
  public CadConsultaCadastro4Stub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(configurationContext, "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx");
  }

  /** Default Constructor */
  public CadConsultaCadastro4Stub() throws org.apache.axis2.AxisFault {

    this("https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx");
  }

  /** Constructor taking the target endpoint */
  public CadConsultaCadastro4Stub(java.lang.String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  /**
   * Auto generated method signature Consulta Cadastro de Contribuintes do ICMS
   *
   * @see br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.CadConsultaCadastro4#consultaCadastro
   * @param nfeDadosMsg
   */
  public br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument consultaCadastro(
      br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument nfeDadosMsg)
      throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
      _operationClient
          .getOptions()
          .setAction(
              "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(
          getFactory(_operationClient.getOptions().getSoapVersionURI()),
          nfeDadosMsg,
          optimizeContent(
              new javax.xml.namespace.QName(
                  "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4",
                  "consultaCadastro")),
          new javax.xml.namespace.QName(
              "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", "nfeDadosMsg"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
          org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      java.lang.Object object = fromOM(
          _returnEnv.getBody().getFirstElement(),
          br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument.class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument) object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "consultaCadastro"))) {
          // make the fault by reflection
          try {
            java.lang.String exceptionClassName = faultExceptionClassNameMap.get(
                new org.apache.axis2.client.FaultMapKey(
                    faultElt.getQName(), "consultaCadastro"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
            java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
            // message class
            java.lang.String messageClassName = faultMessageMap.get(
                new org.apache.axis2.client.FaultMapKey(
                    faultElt.getQName(), "consultaCadastro"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (java.lang.ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  private javax.xml.namespace.QName[] opNameArray = null;

  private boolean optimizeContent(javax.xml.namespace.QName opName) {

    if (opNameArray == null) {
      return false;
    }
    for (int i = 0; i < opNameArray.length; i++) {
      if (opName.equals(opNameArray[i])) {
        return true;
      }
    }
    return false;
  }
  // https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro4.asmx

  private final org.apache.xmlbeans.XmlOptions _xmlOptions;

  {
    _xmlOptions = new org.apache.xmlbeans.XmlOptions();
    _xmlOptions.setSaveNoXmlDecl();
    _xmlOptions.setSaveAggressiveNamespaces();
    _xmlOptions.setSaveNamespacesFirst();
  }

  /**
   * Get the {@link org.apache.xmlbeans.XmlOptions} object that the stub uses when serializing objects to XML.
   *
   * @return the options used for serialization
   */
  public org.apache.xmlbeans.XmlOptions _getXmlOptions() {
    return _xmlOptions;
  }

  private org.apache.axiom.om.OMElement toOM(
      br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    return toOM(param);
  }

  private org.apache.axiom.om.OMElement toOM(
      final br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument param)
      throws org.apache.axis2.AxisFault {

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(
        new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param, _xmlOptions),
            new org.xml.sax.InputSource()));
    try {
      return builder.getDocumentElement(true);
    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    return toOM(param);
  }

  private org.apache.axiom.om.OMElement toOM(
      final br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument param)
      throws org.apache.axis2.AxisFault {

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(
        new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param, _xmlOptions),
            new org.xml.sax.InputSource()));
    try {
      return builder.getDocumentElement(true);
    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {
    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
    if (param != null) {
      envelope.getBody().addChild(toOM(param, optimizeContent));
    }
    return envelope;
  }

  /** get the default envelope */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  public org.apache.xmlbeans.XmlObject fromOM(
      org.apache.axiom.om.OMElement param, java.lang.Class type) throws org.apache.axis2.AxisFault {
    try {

      if (br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.class.equals(
          type)) {
        org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration = new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
        configuration.setPreserveNamespaceContext(true);
        return br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeDadosMsgDocument.Factory
            .parse(param.getXMLStreamReader(false, configuration));
      }

      if (br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument.class.equals(
          type)) {
        org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration = new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
        configuration.setPreserveNamespaceContext(true);
        return br.inf.portalfiscal.www.nfe.wsdl.cadconsultacadastro4.NfeResultMsgDocument.Factory
            .parse(param.getXMLStreamReader(false, configuration));
      }

    } catch (java.lang.Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}
