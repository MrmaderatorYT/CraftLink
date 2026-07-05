package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.mc.v1_6_4.util.CryptUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.security.PublicKey;

/* loaded from: classes.dex */
public class PacketKeyRequest extends Packet {
    public PublicKey pubKey;
    public String serverId;
    public byte[] verifyToken;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 253;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketKeyRequest() {
    }

    public PacketKeyRequest(String str, PublicKey publicKey, byte[] bArr) {
        this.serverId = str;
        this.pubKey = publicKey;
        this.verifyToken = bArr;
    }

    public String getServerId() {
        return this.serverId;
    }

    public PublicKey getPublicKey() {
        return this.pubKey;
    }

    public byte[] getVerifyToken() {
        return this.verifyToken;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.serverId = netInput.readString();
        this.pubKey = CryptUtil.decodePublicKey(netInput.readBytes(netInput.readShort()));
        this.verifyToken = netInput.readBytes(netInput.readShort());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.serverId);
        byte[] encoded = this.pubKey.getEncoded();
        netOutput.writeShort(encoded.length);
        netOutput.writeBytes(encoded);
        netOutput.writeShort(this.verifyToken.length);
        netOutput.writeBytes(this.verifyToken);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
