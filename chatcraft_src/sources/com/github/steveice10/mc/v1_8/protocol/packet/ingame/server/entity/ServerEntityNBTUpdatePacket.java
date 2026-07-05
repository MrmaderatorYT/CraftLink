package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityNBTUpdatePacket implements Packet {
    private int entityId;
    private CompoundTag tag;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityNBTUpdatePacket() {
    }

    public ServerEntityNBTUpdatePacket(int i, CompoundTag compoundTag) {
        this.entityId = i;
        this.tag = compoundTag;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public CompoundTag getTag() {
        return this.tag;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.tag = NetUtil.readNBT(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        NetUtil.writeNBT(netOutput, this.tag);
    }
}
