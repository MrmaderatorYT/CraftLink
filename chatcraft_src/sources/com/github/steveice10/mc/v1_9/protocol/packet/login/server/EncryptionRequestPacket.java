package com.github.steveice10.mc.v1_9.protocol.packet.login.server;

import com.github.steveice10.mc.v1_9.protocol.util.CryptUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.security.PublicKey;

/* loaded from: classes.dex */
public class EncryptionRequestPacket implements Packet {
    private PublicKey publicKey;
    private String serverId;
    private byte[] verifyToken;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private EncryptionRequestPacket() {
    }

    public EncryptionRequestPacket(String str, PublicKey publicKey, byte[] bArr) {
        this.serverId = str;
        this.publicKey = publicKey;
        this.verifyToken = bArr;
    }

    public String getServerId() {
        return this.serverId;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public byte[] getVerifyToken() {
        return this.verifyToken;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.serverId = netInput.readString();
        this.publicKey = CryptUtil.decodePublicKey(netInput.readBytes(netInput.readVarInt()));
        this.verifyToken = netInput.readBytes(netInput.readVarInt());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.serverId);
        byte[] encoded = this.publicKey.getEncoded();
        netOutput.writeVarInt(encoded.length);
        netOutput.writeBytes(encoded);
        netOutput.writeVarInt(this.verifyToken.length);
        netOutput.writeBytes(this.verifyToken);
    }
}
