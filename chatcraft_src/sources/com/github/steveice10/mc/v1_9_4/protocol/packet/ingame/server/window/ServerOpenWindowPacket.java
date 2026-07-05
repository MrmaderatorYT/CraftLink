package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.window;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.WindowType;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerOpenWindowPacket implements Packet {
    private String name;
    private int ownerEntityId;
    private int slots;
    private WindowType type;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerOpenWindowPacket() {
    }

    public ServerOpenWindowPacket(int i, WindowType windowType, String str, int i2) {
        this(i, windowType, str, i2, 0);
    }

    public ServerOpenWindowPacket(int i, WindowType windowType, String str, int i2, int i3) {
        this.windowId = i;
        this.type = windowType;
        this.name = str;
        this.slots = i2;
        this.ownerEntityId = i3;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public WindowType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getSlots() {
        return this.slots;
    }

    public int getOwnerEntityId() {
        return this.ownerEntityId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.type = (WindowType) MagicValues.key(WindowType.class, netInput.readString());
        this.name = netInput.readString();
        this.slots = netInput.readUnsignedByte();
        if (this.type == WindowType.HORSE) {
            this.ownerEntityId = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeString((String) MagicValues.value(String.class, this.type));
        netOutput.writeString(this.name);
        netOutput.writeByte(this.slots);
        if (this.type == WindowType.HORSE) {
            netOutput.writeInt(this.ownerEntityId);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
