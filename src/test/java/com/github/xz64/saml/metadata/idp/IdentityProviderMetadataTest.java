package com.github.xz64.saml.metadata.idp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.xz64.saml.idp.IdentityProvider;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class IdentityProviderMetadataTest {

  @Test
  void keycloakMetadata() throws Exception {
    IdentityProvider idp = loadFile("keycloak.xml");
    assertEquals("http://localhost:8080/auth/realms/master", idp.getEntityID());
    assertTrue(idp.wantAuthnRequestsSigned());
  }

  @Test
  void samltestIdMetadata() throws Exception {
    IdentityProvider idp = loadFile("samltest.id.xml");
    assertEquals("https://samltest.id/saml/idp", idp.getEntityID());
    assertFalse(idp.wantAuthnRequestsSigned());
  }

  IdentityProvider loadFile(String filename) throws Exception {
    try (InputStream metadataXmlInputStream =
        this.getClass().getResourceAsStream("/metadata/idp/" + filename)) {
      IdentityProviderMetadata idpMetadata = new IdentityProviderMetadata(metadataXmlInputStream);
      return idpMetadata.getIdentityProviders().get(0);
    }
  }
}
