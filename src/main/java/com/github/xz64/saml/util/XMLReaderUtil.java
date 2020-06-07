package com.github.xz64.saml.util;

import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class XMLReaderUtil {
  private XMLReaderUtil() {}

  public static XMLEventReader getXMLEventReader(InputStream inputStream)
      throws XMLStreamException {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
    factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    return factory.createXMLEventReader(inputStream);
  }
}
