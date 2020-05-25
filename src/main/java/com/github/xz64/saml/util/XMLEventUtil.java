package com.github.xz64.saml.util;

import java.util.Optional;
import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

public class XMLEventUtil {
  public static boolean startsTag(XMLEvent event, QName qname) {
    return event.isStartElement() && event.asStartElement().getName().equals(qname);
  }

  public static boolean endsTag(XMLEvent event, QName qname) {
    return event.isEndElement() && event.asEndElement().getName().equals(qname);
  }

  public static Optional<String> getTagAttribute(XMLEvent event, QName qname) {
    Attribute attr = event.asStartElement().getAttributeByName(qname);
    return Optional.ofNullable(attr).map(Attribute::getValue);
  }
}
