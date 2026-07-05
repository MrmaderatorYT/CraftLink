package com.github.steveice10.mc.v1_12_1.protocol.ingame.client.ingame.client.window;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPrepareCraftingGridPacket implements Packet {
    private boolean makeAll;
    private int recipeId;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPrepareCraftingGridPacket() {
    }

    public ClientPrepareCraftingGridPacket(int i, int i2, boolean z) {
        this.windowId = i;
        this.recipeId = i2;
        this.makeAll = z;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public boolean doesMakeAll() {
        return this.makeAll;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.recipeId = netInput.readVarInt();
        this.makeAll = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeVarInt(this.recipeId);
        netOutput.writeBoolean(this.makeAll);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
