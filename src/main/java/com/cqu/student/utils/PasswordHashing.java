package com.cqu.student.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHashing {

    // 哈希密码
    public static String hashPassword(String password) throws Exception {
        // 生成随机盐值
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        // 使用 SHA-256 进行哈希
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());

        // 返回盐值和哈希的组合（Base64 编码）
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hashedPassword);
    }

    // 验证密码
    public static boolean verifyPassword(String storedPassword, String providedPassword) throws Exception {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storedHash = Base64.getDecoder().decode(parts[1]);

        // 使用同样的盐值进行哈希
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] providedHash = md.digest(providedPassword.getBytes());

        // 比较哈希值
        return MessageDigest.isEqual(storedHash, providedHash);
    }

    public static void main(String[] args) throws Exception {
        String password = "mysecurepassword";

        // 哈希密码
        String hashedPassword = hashPassword(password);
        System.out.println("哈希后的密码: " + hashedPassword);

        // 验证密码
        boolean isCorrect = verifyPassword(hashedPassword, "mysecurepassword");
        System.out.println("密码验证结果: " + isCorrect);
    }
}
