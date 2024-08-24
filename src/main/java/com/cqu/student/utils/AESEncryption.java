package com.cqu.student.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption {

    public static final String algorithm = "AES";
    // 使用AES/CBC/PKCS5Padding模式
    public static final String transformation = "AES/CBC/PKCS5Padding";
    public static final String key = "1234567812345678";

    /***
     * 加密
     * @param original 需要加密的参数
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encryptByAES(String original) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        // 指定模式(加密)和密钥
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        // 加密
        byte[] bytes = cipher.doFinal(original.getBytes());

        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 解密
     * @param encrypted 需要解密的参数
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decryptByAES(String encrypted) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        // 指定模式(解密)和密钥
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        // 解密
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));

        return new String(bytes);
    }
}
