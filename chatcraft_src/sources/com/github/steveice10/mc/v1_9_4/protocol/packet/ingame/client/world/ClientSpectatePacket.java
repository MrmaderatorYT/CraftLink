package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.client.world;

import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.UUID;

/* loaded from: classes.dex */
public class ClientSpectatePacket implements Packet {
    private UUID target;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientSpectatePacket() {
    }

    public ClientSpectatePacket(UUID uuid) {
        this.target = uuid;
    }

    public UUID getTarget() {
        return this.target;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.target = netInput.readUUID();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeUUID(this.target);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
