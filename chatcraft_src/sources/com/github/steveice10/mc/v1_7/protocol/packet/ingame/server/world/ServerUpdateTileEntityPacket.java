package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_7.protocol.util.NetUtil;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerUpdateTileEntityPacket implements Packet {
    private CompoundTag nbt;
    private Type type;
    private int x;
    private int y;
    private int z;

    public enum Type {
        MOB_SPAWNER,
        COMMAND_BLOCK,
        BEACON,
        SKULL,
        FLOWER_POT
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateTileEntityPacket() {
    }

    public ServerUpdateTileEntityPacket(int i, int i2, int i3, int i4, Type type, CompoundTag compoundTag) {
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.type = type;
        this.nbt = compoundTag;
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

    public Type getType() {
        return this.type;
    }

    public CompoundTag getNBT() {
        return this.nbt;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        try {
            this.type = Type.values()[netInput.readUnsignedByte() - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            this.type = Type.MOB_SPAWNER;
        }
        this.nbt = NetUtil.readNBT(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.type.ordinal() + 1);
        NetUtil.writeNBT(netOutput, this.nbt);
    }
}
