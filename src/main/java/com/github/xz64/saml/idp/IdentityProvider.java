package com.github.xz64.saml.idp;

import com.github.xz64.saml.util.QNames;
import com.github.xz64.saml.util.XMLEventUtil;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class IdentityProvider {
  private String entityID;
  private boolean wantAuthnRequestsSigned;

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
        entityID = XMLEventUtil.getTagAttribute(event, QNames.ENTITY_ID).get();
      }

      if (XMLEventUtil.startsTag(event, QNames.IDP_SSO_DESCRIPTOR)) {
        String attr =
            XMLEventUtil.getTagAttribute(event, QNames.WANT_AUTHN_REQUESTS_SIGNED).orElse("false");
        wantAuthnRequestsSigned = "true".equals(attr);
      }
    }
  }

  public String getEntityID() {
    return entityID;
  }

  public boolean wantAuthnRequestsSigned() {
    return wantAuthnRequestsSigned;
  }
}
