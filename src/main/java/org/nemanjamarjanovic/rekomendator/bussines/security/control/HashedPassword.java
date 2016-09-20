package org.nemanjamarjanovic.rekomendator.bussines.security.control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nemanja
 */
public class HashedPassword {

    private final String hashedPassword;

    public HashedPassword(String original) throws NoSuchAlgorithmException {

        this.hashedPassword = doHash(original);
    }

    private String doHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public String getValue() {
        return hashedPassword;
    }

}
