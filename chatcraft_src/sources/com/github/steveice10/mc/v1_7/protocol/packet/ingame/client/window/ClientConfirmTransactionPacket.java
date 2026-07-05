package com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.window;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientConfirmTransactionPacket implements Packet {
    private boolean accepted;
    private int actionId;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientConfirmTransactionPacket() {
    }

    public ClientConfirmTransactionPacket(int i, int i2, boolean z) {
        this.windowId = i;
        this.actionId = i2;
        this.accepted = z;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getActionId() {
        return this.actionId;
    }

    public boolean getAccepted() {
        return this.accepted;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.actionId = netInput.readShort();
        this.accepted = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.actionId);
        netOutput.writeBoolean(this.accepted);
    }
}
