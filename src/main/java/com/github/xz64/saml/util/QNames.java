package com.github.xz64.saml.util;

import javax.xml.namespace.QName;

public class QNames {
  private QNames() {}

  public static final QName ENTITY_DESCRIPTOR =
      new QName("urn:oasis:names:tc:SAML:2.0:metadata", "EntityDescriptor");
  public static final QName IDP_SSO_DESCRIPTOR =
      new QName("urn:oasis:names:tc:SAML:2.0:metadata", "IDPSSODescriptor");
  public static final QName ENTITY_ID = new QName("entityID");
  public static final QName WANT_AUTHN_REQUESTS_SIGNED = new QName("WantAuthnRequestsSigned");
}
