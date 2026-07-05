package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerWindowPropertyPacket implements Packet {
    private int property;
    private int value;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerWindowPropertyPacket() {
    }

    public ServerWindowPropertyPacket(int i, int i2, int i3) {
        this.windowId = i;
        this.property = i2;
        this.value = i3;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lcom/github/steveice10/mc/v1_9/protocol/data/game/window/property/WindowProperty;>(ITT;I)V */
    public ServerWindowPropertyPacket(int i, Enum r2, int i2) {
        this.windowId = i;
        this.property = ((Integer) MagicValues.value(Integer.class, r2)).intValue();
        this.value = i2;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getRawProperty() {
        return this.property;
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Ljava/lang/Enum<TT;>;:Lcom/github/steveice10/mc/v1_9/protocol/data/game/window/property/WindowProperty;>(Ljava/lang/Class<TT;>;)TT; */
    public Enum getProperty(Class cls) {
        return (Enum) MagicValues.key(cls, Integer.valueOf(this.value));
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.property = netInput.readShort();
        this.value = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.property);
        netOutput.writeShort(this.value);
    }
}
