package com.acesse.vcashadmin.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class HashUtil {
    public static String generateHash(String password, String salt) throws Exception {
        byte[] saltBytes = Base64.decodeBase64(salt);
        byte[] passwordBytes = password.getBytes("UTF-16LE");

        byte[] bytesToHash = new byte[saltBytes.length + passwordBytes.length];

        System.arraycopy(saltBytes, 0, bytesToHash, 0, saltBytes.length);
        System.arraycopy(passwordBytes, 0, bytesToHash, saltBytes.length, passwordBytes.length);

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(bytesToHash);
        String result = Base64.encodeBase64String(hash);

        return result;
    }
}
