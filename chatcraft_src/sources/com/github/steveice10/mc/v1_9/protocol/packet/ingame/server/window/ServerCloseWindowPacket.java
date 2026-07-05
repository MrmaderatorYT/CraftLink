package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerCloseWindowPacket implements Packet {
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerCloseWindowPacket() {
    }

    public ServerCloseWindowPacket(int i) {
        this.windowId = i;
    }

    public int getWindowId() {
        return this.windowId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
    }
}
