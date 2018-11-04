package com.pandaria.farmland.toolkits.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptUtil {

    public static String sha1Hex(String... args) {
        if (args != null && args.length > 0) {
            StringBuffer result = new StringBuffer();
            for (String a : args) {
                result.append(a);
            }
            return DigestUtils.sha1Hex(result.toString());
        }
        return "";
    }
}
