package com.github.steveice10.mc.v1_5.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Random;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public class Util {
    private static final Logger logger = Logger.getLogger("mc-protocol-lib");
    private static final Random rand = new Random();

    public static boolean getBit(int i, int i2) {
        return (i & i2) == i2;
    }

    public static byte setBit(byte b2, int i, boolean z) {
        return (byte) (z ? b2 | i : b2 & (i ^ (-1)));
    }

    public static Logger logger() {
        return logger;
    }

    public static Random random() {
        return rand;
    }

    public static String stripColor(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == 167) {
                i++;
            } else {
                sb.append(str.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static byte[] encrypt(String str, PublicKey publicKey, SecretKey secretKey) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("ISO_8859_1"));
            messageDigest.update(secretKey.getEncoded());
            messageDigest.update(publicKey.getEncoded());
            return messageDigest.digest();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String formatPingResponse(String str, int i, int i2) {
        return "§1\u000060\u00001.5.1\u0000" + str + "\u0000" + i + "\u0000" + i2;
    }
}
