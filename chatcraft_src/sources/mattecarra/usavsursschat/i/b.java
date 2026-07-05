package mattecarra.usavsursschat.i;

import android.util.Base64;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryptionUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5016a = {-37, -116, 6, -20, Constants.MobIds.ENDER_DRAGON, 19, Constants.ObjectIds.XP_BOTTLE, -65, -28, -98, -61, -55, -61, -9, 85, -111};

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f5017b = "error".getBytes();

    protected static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            System.arraycopy(MessageDigest.getInstance("SHA-256").digest(f5017b), 0, bArr2, 0, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(f5016a, 0, cipher.getBlockSize()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            try {
                System.out.println("Trying encryption key = error");
                if (f5017b != null && !new String(bArr, a.f5015a).equals("error")) {
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(MessageDigest.getInstance("SHA-256").digest("error".getBytes(a.f5015a)), 0, bArr3, 0, 16);
                    SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr3, "AES");
                    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher2.init(2, secretKeySpec2, new IvParameterSpec(f5016a, 0, cipher2.getBlockSize()));
                    System.out.println("Encryption key error worked");
                    return cipher2.doFinal(bArr);
                }
            } catch (Throwable unused) {
                System.out.println("Encryption key = error failed! WTF");
            }
            throw th;
        }
    }

    public static String a(String str) {
        try {
            return new String(a(c(str)), a.f5015a);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return c(b(str.getBytes(a.f5015a)));
    }

    protected static byte[] b(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[16];
        System.arraycopy(MessageDigest.getInstance("SHA-256").digest(f5017b), 0, bArr2, 0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(f5016a, 0, cipher.getBlockSize()));
        return cipher.doFinal(bArr);
    }

    public static String c(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    public static byte[] c(String str) {
        return Base64.decode(str.getBytes(a.f5015a), 0);
    }
}
