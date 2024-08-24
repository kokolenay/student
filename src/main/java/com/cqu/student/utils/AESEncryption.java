package com.cqu.student.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.SecureRandom;

public class AESEncryption {

    // AES 加密方法
    public static String encrypt(String data, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // AES 解密方法
    public static String decrypt(String encryptedData, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(original);
    }

//    public static void main(String[] args) throws Exception {
//        // 生成密钥和IV
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(256);
//        SecretKey key = keyGen.generateKey();
//
//        byte[] ivBytes = new byte[16];
//        SecureRandom random = new SecureRandom();
//        random.nextBytes(ivBytes);
//        IvParameterSpec iv = new IvParameterSpec(ivBytes);
//
//        String idNumber = "123456789012345678";
//
//        // 加密身份证号码
//        String encryptedId = encrypt(idNumber, key, iv);
//        System.out.println("加密后的身份证号码: " + encryptedId);
//
//        // 解密身份证号码
//        String decryptedId = decrypt(encryptedId, key, iv);
//        System.out.println("解密后的身份证号码: " + decryptedId);
//    }
}

