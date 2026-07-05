package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntitySetPassengersPacket implements Packet {
    private int entityId;
    private int[] passengerIds;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntitySetPassengersPacket() {
    }

    public ServerEntitySetPassengersPacket(int i, int... iArr) {
        this.entityId = i;
        this.passengerIds = iArr;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int[] getPassengerIds() {
        return this.passengerIds;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.passengerIds = new int[netInput.readVarInt()];
        for (int i = 0; i < this.passengerIds.length; i++) {
            this.passengerIds[i] = netInput.readVarInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeVarInt(this.passengerIds.length);
        for (int i : this.passengerIds) {
            netOutput.writeVarInt(i);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
