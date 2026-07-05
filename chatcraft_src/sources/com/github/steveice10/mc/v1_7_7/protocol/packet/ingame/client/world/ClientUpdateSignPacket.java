package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientUpdateSignPacket implements Packet {
    private String[] lines;
    private int x;
    private int y;
    private int z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientUpdateSignPacket() {
    }

    public ClientUpdateSignPacket(int i, int i2, int i3, String[] strArr) {
        if (strArr.length != 4) {
            throw new IllegalArgumentException("Lines must contain exactly 4 strings!");
        }
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.lines = strArr;
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

    public String[] getLines() {
        return this.lines;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        this.lines = new String[4];
        for (int i = 0; i < this.lines.length; i++) {
            this.lines[i] = netInput.readString();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        for (String str : this.lines) {
            netOutput.writeString(str);
        }
    }
}
