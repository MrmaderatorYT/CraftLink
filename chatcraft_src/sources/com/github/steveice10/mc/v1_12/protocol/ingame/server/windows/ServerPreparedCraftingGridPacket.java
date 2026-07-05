package com.github.steveice10.mc.v1_12.protocol.ingame.server.windows;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPreparedCraftingGridPacket implements Packet {
    private int recipeId;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPreparedCraftingGridPacket() {
    }

    public ServerPreparedCraftingGridPacket(int i, int i2) {
        this.windowId = i;
        this.recipeId = i2;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.recipeId = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeVarInt(this.recipeId);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
