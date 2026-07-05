package com.github.steveice10.packetlib.crypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes.dex */
public class AESEncryption implements PacketEncryption {
    private Cipher inCipher = Cipher.getInstance("AES/CFB8/NoPadding");
    private Cipher outCipher;

    public AESEncryption(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.inCipher.init(2, key, new IvParameterSpec(key.getEncoded()));
        this.outCipher = Cipher.getInstance("AES/CFB8/NoPadding");
        this.outCipher.init(1, key, new IvParameterSpec(key.getEncoded()));
    }

    @Override // com.github.steveice10.packetlib.crypt.PacketEncryption
    public int getDecryptOutputSize(int i) {
        return this.inCipher.getOutputSize(i);
    }

    @Override // com.github.steveice10.packetlib.crypt.PacketEncryption
    public int getEncryptOutputSize(int i) {
        return this.outCipher.getOutputSize(i);
    }

    @Override // com.github.steveice10.packetlib.crypt.PacketEncryption
    public int decrypt(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return this.inCipher.update(bArr, i, i2, bArr2, i3);
    }

    @Override // com.github.steveice10.packetlib.crypt.PacketEncryption
    public int encrypt(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return this.outCipher.update(bArr, i, i2, bArr2, i3);
    }
}
