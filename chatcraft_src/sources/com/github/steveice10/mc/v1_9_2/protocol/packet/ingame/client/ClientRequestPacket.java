package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.ClientRequest;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientRequestPacket implements Packet {
    private ClientRequest request;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientRequestPacket() {
    }

    public ClientRequestPacket(ClientRequest clientRequest) {
        this.request = clientRequest;
    }

    public ClientRequest getRequest() {
        return this.request;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.request = (ClientRequest) MagicValues.key(ClientRequest.class, Integer.valueOf(netInput.readVarInt()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.request)).intValue());
    }
}
