package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.chunk.Column;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class ServerChunkDataPacket implements Packet {
    private Column column;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerChunkDataPacket() {
    }

    public ServerChunkDataPacket(Column column) {
        this.column = column;
    }

    public Column getColumn() {
        return this.column;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        int i = netInput.readInt();
        int i2 = netInput.readInt();
        boolean z = netInput.readBoolean();
        int varInt = netInput.readVarInt();
        byte[] bytes = netInput.readBytes(netInput.readVarInt());
        CompoundTag[] compoundTagArr = new CompoundTag[netInput.readVarInt()];
        for (int i3 = 0; i3 < compoundTagArr.length; i3++) {
            compoundTagArr[i3] = NetUtil.readNBT(netInput);
        }
        this.column = NetUtil.readColumn(bytes, i, i2, z, false, varInt, compoundTagArr);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iWriteColumn = NetUtil.writeColumn(new StreamNetOutput(byteArrayOutputStream), this.column, this.column.hasBiomeData(), this.column.hasSkylight());
        netOutput.writeInt(this.column.getX());
        netOutput.writeInt(this.column.getZ());
        netOutput.writeBoolean(this.column.hasBiomeData());
        netOutput.writeVarInt(iWriteColumn);
        netOutput.writeVarInt(byteArrayOutputStream.size());
        netOutput.writeBytes(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.size());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        StreamNetOutput streamNetOutput = new StreamNetOutput(byteArrayOutputStream2);
        for (CompoundTag compoundTag : this.column.getTileEntities()) {
            NetUtil.writeNBT(streamNetOutput, compoundTag);
        }
        netOutput.writeVarInt(this.column.getTileEntities().length);
        netOutput.writeBytes(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream2.size());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
