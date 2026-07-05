package com.github.steveice10.mc.v1_7.protocol.packet.login.client;

import com.github.steveice10.mc.v1_7.protocol.util.CryptUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public class EncryptionResponsePacket implements Packet {
    private byte[] sharedKey;
    private byte[] verifyToken;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private EncryptionResponsePacket() {
    }

    public EncryptionResponsePacket(SecretKey secretKey, PublicKey publicKey, byte[] bArr) {
        this.sharedKey = CryptUtil.encryptData(publicKey, secretKey.getEncoded());
        this.verifyToken = CryptUtil.encryptData(publicKey, bArr);
    }

    public SecretKey getSecretKey(PrivateKey privateKey) {
        return CryptUtil.decryptSharedKey(privateKey, this.sharedKey);
    }

    public byte[] getVerifyToken(PrivateKey privateKey) {
        return CryptUtil.decryptData(privateKey, this.verifyToken);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.sharedKey = netInput.readPrefixedBytes();
        this.verifyToken = netInput.readPrefixedBytes();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writePrefixedBytes(this.sharedKey);
        netOutput.writePrefixedBytes(this.verifyToken);
    }
}
