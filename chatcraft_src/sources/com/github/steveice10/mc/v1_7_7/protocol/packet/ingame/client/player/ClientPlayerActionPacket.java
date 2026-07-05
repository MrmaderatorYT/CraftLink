package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerActionPacket implements Packet {
    private Action action;
    private int entityId;
    private int jumpBoost;

    public enum Action {
        CROUCH,
        UNCROUCH,
        LEAVE_BED,
        START_SPRINTING,
        STOP_SPRINTING
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerActionPacket() {
    }

    public ClientPlayerActionPacket(int i, Action action) {
        this(i, action, 0);
    }

    public ClientPlayerActionPacket(int i, Action action, int i2) {
        this.entityId = i;
        this.action = action;
        this.jumpBoost = i2;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Action getAction() {
        return this.action;
    }

    public int getJumpBoost() {
        return this.jumpBoost;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.action = Action.values()[netInput.readByte() - 1];
        this.jumpBoost = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.action.ordinal() + 1);
        netOutput.writeInt(this.jumpBoost);
    }
}
