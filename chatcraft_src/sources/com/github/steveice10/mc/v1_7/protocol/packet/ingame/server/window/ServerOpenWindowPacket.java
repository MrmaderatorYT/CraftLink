package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.window;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerOpenWindowPacket implements Packet {
    private String name;
    private int ownerEntityId;
    private int slots;
    private Type type;
    private boolean useName;
    private int windowId;

    public enum Type {
        CHEST,
        CRAFTING_TABLE,
        FURNACE,
        DISPENSER,
        ENCHANTMENT_TABLE,
        BREWING_STAND,
        VILLAGER_TRADE,
        BEACON,
        ANVIL,
        HOPPER,
        DROPPER,
        HORSE_INVENTORY
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerOpenWindowPacket() {
    }

    public ServerOpenWindowPacket(int i, Type type, String str, int i2, boolean z) {
        this(i, type, str, i2, z, 0);
    }

    public ServerOpenWindowPacket(int i, Type type, String str, int i2, boolean z, int i3) {
        this.windowId = i;
        this.type = type;
        this.name = str;
        this.slots = i2;
        this.useName = z;
        this.ownerEntityId = i3;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public Type getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getSlots() {
        return this.slots;
    }

    public boolean getUseName() {
        return this.useName;
    }

    public int getOwnerEntityId() {
        return this.ownerEntityId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.type = Type.values()[netInput.readUnsignedByte()];
        this.name = netInput.readString();
        this.slots = netInput.readUnsignedByte();
        this.useName = netInput.readBoolean();
        if (this.type == Type.HORSE_INVENTORY) {
            this.ownerEntityId = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeByte(this.type.ordinal());
        netOutput.writeString(this.name);
        netOutput.writeByte(this.slots);
        netOutput.writeBoolean(this.useName);
        if (this.type == Type.HORSE_INVENTORY) {
            netOutput.writeInt(this.ownerEntityId);
        }
    }
}
