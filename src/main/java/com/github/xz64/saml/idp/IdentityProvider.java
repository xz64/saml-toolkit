package com.github.xz64.saml.idp;

import com.github.xz64.saml.util.QNames;
import com.github.xz64.saml.util.XMLEventUtil;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class IdentityProvider {
  private String entityID;

  /**
   * Parses &lt;EntityDescriptor&gt; portion of idp xml
   *
   * @param reader XMLEventReader at &lt;EntityDescriptor&gt; element
   * @throws XMLStreamException
   */
  public IdentityProvider(XMLEventReader reader) throws XMLStreamException {
    while (reader.hasNext()) {
      XMLEvent event = reader.nextEvent();

      if (XMLEventUtil.endsTag(event, QNames.ENTITY_DESCRIPTOR)) {
        break;
      }

      if (XMLEventUtil.startsTag(event, QNames.ENTITY_DESCRIPTOR)) {
        entityID = XMLEventUtil.getTagAttribute(event, QNames.ENTITY_ID);
      }
    }
  }

  public String getEntityID() {
    return entityID;
  }
}
