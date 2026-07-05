package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerBlockBreakAnimPacket implements Packet {
    private int breakerEntityId;
    private Stage stage;
    private int x;
    private int y;
    private int z;

    public enum Stage {
        STAGE_1,
        STAGE_2,
        STAGE_3,
        STAGE_4,
        STAGE_5,
        STAGE_6,
        STAGE_7,
        STAGE_8,
        STAGE_9,
        STAGE_10,
        RESET
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBlockBreakAnimPacket() {
    }

    public ServerBlockBreakAnimPacket(int i, int i2, int i3, int i4, Stage stage) {
        this.breakerEntityId = i;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.stage = stage;
    }

    public int getBreakerEntityId() {
        return this.breakerEntityId;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public Stage getStage() {
        return this.stage;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.breakerEntityId = netInput.readVarInt();
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        try {
            this.stage = Stage.values()[netInput.readUnsignedByte()];
        } catch (ArrayIndexOutOfBoundsException unused) {
            this.stage = Stage.RESET;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.breakerEntityId);
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.stage == Stage.RESET ? -1 : this.stage.ordinal());
    }
}
