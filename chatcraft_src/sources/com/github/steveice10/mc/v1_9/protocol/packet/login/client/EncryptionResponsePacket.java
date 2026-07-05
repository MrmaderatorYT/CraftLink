package com.github.steveice10.mc.v1_9.protocol.packet.login.client;

import com.github.steveice10.mc.v1_9.protocol.util.CryptUtil;
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
        this.sharedKey = CryptUtil.encryptDataRSA(publicKey, secretKey.getEncoded());
        this.verifyToken = CryptUtil.encryptDataRSA(publicKey, bArr);
    }

    public SecretKey getSecretKey(PrivateKey privateKey) {
        return CryptUtil.decryptSharedKey(privateKey, this.sharedKey);
    }

    public byte[] getVerifyToken(PrivateKey privateKey) {
        return CryptUtil.decryptData(privateKey, this.verifyToken);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.sharedKey = netInput.readBytes(netInput.readVarInt());
        this.verifyToken = netInput.readBytes(netInput.readVarInt());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.sharedKey.length);
        netOutput.writeBytes(this.sharedKey);
        netOutput.writeVarInt(this.verifyToken.length);
        netOutput.writeBytes(this.verifyToken);
    }
}
