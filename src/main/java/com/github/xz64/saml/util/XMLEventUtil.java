package com.github.xz64.saml.util;

import javax.xml.namespace.QName;
import javax.xml.stream.events.XMLEvent;

public class XMLEventUtil {
  public static boolean startsTag(XMLEvent event, QName qname) {
    return event.isStartElement() && event.asStartElement().getName().equals(qname);
  }

  public static boolean endsTag(XMLEvent event, QName qname) {
    return event.isEndElement() && event.asEndElement().getName().equals(qname);
  }

  public static String getTagAttribute(XMLEvent event, QName qname) {
    return event.asStartElement().getAttributeByName(qname).getValue();
  }
}
