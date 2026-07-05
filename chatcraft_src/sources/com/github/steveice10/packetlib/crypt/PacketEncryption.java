package com.github.steveice10.packetlib.crypt;

/* loaded from: classes.dex */
public interface PacketEncryption {
    int decrypt(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    int encrypt(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    int getDecryptOutputSize(int i);

    int getEncryptOutputSize(int i);
}
