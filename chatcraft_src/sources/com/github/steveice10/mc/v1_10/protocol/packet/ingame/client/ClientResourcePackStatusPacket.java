package com.github.steveice10.mc.v1_10.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.ResourcePackStatus;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientResourcePackStatusPacket implements Packet {
    private ResourcePackStatus status;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientResourcePackStatusPacket() {
    }

    public ClientResourcePackStatusPacket(ResourcePackStatus resourcePackStatus) {
        this.status = resourcePackStatus;
    }

    public ResourcePackStatus getStatus() {
        return this.status;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.status = (ResourcePackStatus) MagicValues.key(ResourcePackStatus.class, Integer.valueOf(netInput.readVarInt()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.status)).intValue());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
