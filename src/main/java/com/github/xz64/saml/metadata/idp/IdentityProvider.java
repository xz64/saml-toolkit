package com.github.xz64.saml.metadata.idp;

import java.io.InputStream;

public class IdentityProvider {

  private IdentityProvider() {}

  public static IdentityProvider fromMetadataXml(InputStream metadataXmlInputStream) {
    return new IdentityProvider();
  }

  public String getEntityId() {
    return "http://localhost:8080/auth/realms/master";
  }
}
