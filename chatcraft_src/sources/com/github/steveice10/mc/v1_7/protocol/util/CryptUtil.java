package com.github.steveice10.mc.v1_7.protocol.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class CryptUtil {
    public static SecretKey generateSharedKey() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new Error("Failed to generate shared key.", e);
        }
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new Error("Failed to generate key pair.", e);
        }
    }

    public static PublicKey decodePublicKey(byte[] bArr) throws IOException {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not decrypt public key.", e);
        }
    }

    public static SecretKey decryptSharedKey(PrivateKey privateKey, byte[] bArr) {
        return new SecretKeySpec(decryptData(privateKey, bArr), "AES");
    }

    public static byte[] encryptData(Key key, byte[] bArr) {
        return encryptDataRSA(key, bArr);
    }

    public static byte[] encryptDataRSA(Key key, byte[] bArr) {
        return runEncryption(1, key, bArr, "RSA/ECB/PKCS1Padding");
    }

    public static byte[] decryptData(Key key, byte[] bArr) {
        return runEncryption(2, key, bArr);
    }

    private static byte[] runEncryption(int i, Key key, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(i, key);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            throw new Error("Failed to run encryption.", e);
        }
    }

    private static byte[] runEncryption(int i, Key key, byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            System.out.println("KEY ALGORITHM = " + str);
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(i, key);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            throw new Error("Failed to run encryption.", e);
        }
    }

    public static byte[] getServerIdHash(String str, PublicKey publicKey, SecretKey secretKey) {
        try {
            return encrypt("SHA-1", str.getBytes("ISO_8859_1"), secretKey.getEncoded(), publicKey.getEncoded());
        } catch (UnsupportedEncodingException e) {
            throw new Error("Failed to generate server id hash.", e);
        }
    }

    private static byte[] encrypt(String str, byte[]... bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            for (byte[] bArr2 : bArr) {
                messageDigest.update(bArr2);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new Error("Failed to encrypt data.", e);
        }
    }
}
