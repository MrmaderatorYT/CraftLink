package com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerInteractEntityPacket implements Packet {
    private Action action;
    private int entityId;

    public enum Action {
        INTERACT,
        ATTACK
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerInteractEntityPacket() {
    }

    public ClientPlayerInteractEntityPacket(int i, Action action) {
        this.entityId = i;
        this.action = action;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Action getAction() {
        return this.action;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.action = Action.values()[netInput.readByte()];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.action.ordinal());
    }
}
