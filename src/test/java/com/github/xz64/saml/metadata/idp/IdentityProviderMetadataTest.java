package com.github.xz64.saml.metadata.idp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class IdentityProviderMetadataTest {

  @Test
  void keycloakMetadata() throws IOException {
    try (InputStream metadataXmlInputStream =
        this.getClass().getResourceAsStream("/metadata/idp/keycloak.xml")) {
      IdentityProvider idp = new IdentityProvider(metadataXmlInputStream);
      assertEquals("http://localhost:8080/auth/realms/master", idp.getEntityId());
    }
  }
}
