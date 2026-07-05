package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.ResourcePackStatus;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientResourcePackStatusPacket implements Packet {
    private String hash;
    private ResourcePackStatus status;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientResourcePackStatusPacket() {
    }

    public ClientResourcePackStatusPacket(String str, ResourcePackStatus resourcePackStatus) {
        this.hash = str;
        this.status = resourcePackStatus;
    }

    public String getHash() {
        return this.hash;
    }

    public ResourcePackStatus getStatus() {
        return this.status;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.hash = netInput.readString();
        this.status = (ResourcePackStatus) MagicValues.key(ResourcePackStatus.class, Integer.valueOf(netInput.readVarInt()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.hash);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.status)).intValue());
    }
}
