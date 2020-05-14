package com.github.xz64.saml.metadata.idp;

import java.io.InputStream;

public class IdentityProvider {

  public IdentityProvider(InputStream metadataXmlInputStream) {}

  public String getEntityId() {
    return "http://localhost:8080/auth/realms/master";
  }
}
