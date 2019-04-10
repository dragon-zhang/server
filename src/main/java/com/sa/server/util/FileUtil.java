package com.sa.server.util;

import java.util.Base64;

public class FileUtil {

    public static String bytesToBase64(byte[] bytes) {
        String base64 = null;
        try {
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }

}
