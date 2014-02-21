package com.onsalenext.base.util;

import org.apache.commons.net.util.Base64;

public class Crypto {

  public static String encrypt(String text_p) {
        return new String(Base64.encodeBase64(text_p.getBytes()));
    }

  public static String decrypt(String text_p) {
        return new String(Base64.decodeBase64(text_p.getBytes()));
    }
}
