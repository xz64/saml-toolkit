package com.github.xz64.saml.metadata.idp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.xz64.saml.idp.IdentityProvider;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class IdentityProviderMetadataTest {

  @Test
  void keycloakMetadata() throws Exception {
    IdentityProvider idp = loadFile("keycloak.xml");
    assertEquals("http://localhost:8080/auth/realms/master", idp.getEntityID());
  }

  @Test
  void samltestIdMetadata() throws Exception {
    IdentityProvider idp = loadFile("samltest.id.xml");
    assertEquals("https://samltest.id/saml/idp", idp.getEntityID());
  }

  IdentityProvider loadFile(String filename) throws Exception {
    try (InputStream metadataXmlInputStream =
        this.getClass().getResourceAsStream("/metadata/idp/" + filename)) {
      IdentityProviderMetadata idpMetadata = new IdentityProviderMetadata(metadataXmlInputStream);
      return idpMetadata.getIdentityProviders().get(0);
    }
  }
}
