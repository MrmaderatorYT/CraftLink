package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerOpenTileEntityEditorPacket implements Packet {
    private int x;
    private int y;
    private int z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerOpenTileEntityEditorPacket() {
    }

    public ServerOpenTileEntityEditorPacket(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
    }
}
