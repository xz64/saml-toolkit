package com.github.xz64.saml.metadata.idp;

import com.github.xz64.saml.idp.IdentityProvider;
import com.github.xz64.saml.util.QNames;
import com.github.xz64.saml.util.XMLEventUtil;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class IdentityProviderMetadata {

  private List<IdentityProvider> identityProviders = new ArrayList<>();

  public IdentityProviderMetadata(InputStream metadataXmlInputStream) throws XMLStreamException {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLEventReader reader = factory.createXMLEventReader(metadataXmlInputStream);

    while (reader.hasNext()) {
      XMLEvent event = reader.peek();
      if (XMLEventUtil.startsTag(event, QNames.ENTITY_DESCRIPTOR)) {
        identityProviders.add(new IdentityProvider(reader));
      }
      reader.next();
    }
  }

  public List<IdentityProvider> getIdentityProviders() {
    return identityProviders;
  }
}
