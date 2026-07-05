package com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_7.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_7.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ClientPlayerPlaceBlockPacket implements Packet {
    private float cursorX;
    private float cursorY;
    private float cursorZ;
    private Face face;
    private ItemStack held;
    private int x;
    private int y;
    private int z;

    public enum Face {
        BOTTOM,
        TOP,
        EAST,
        WEST,
        NORTH,
        SOUTH,
        UNKNOWN
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerPlaceBlockPacket() {
    }

    public ClientPlayerPlaceBlockPacket(int i, int i2, int i3, Face face, ItemStack itemStack, float f, float f2, float f3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.face = face;
        this.held = itemStack;
        this.cursorX = f;
        this.cursorY = f2;
        this.cursorZ = f3;
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

    public Face getFace() {
        return this.face;
    }

    public ItemStack getHeldItem() {
        return this.held;
    }

    public float getCursorX() {
        return this.cursorX;
    }

    public float getCursorY() {
        return this.cursorY;
    }

    public float getCursorZ() {
        return this.cursorZ;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readUnsignedByte();
        this.z = netInput.readInt();
        int unsignedByte = netInput.readUnsignedByte();
        this.face = unsignedByte == 255 ? Face.UNKNOWN : Face.values()[unsignedByte];
        this.held = NetUtil.readItem(netInput);
        this.cursorX = netInput.readByte() / 16.0f;
        this.cursorY = netInput.readByte() / 16.0f;
        this.cursorZ = netInput.readByte() / 16.0f;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.face == Face.UNKNOWN ? 255 : this.face.ordinal());
        NetUtil.writeItem(netOutput, this.held);
        netOutput.writeByte((int) (this.cursorX * 16.0f));
        netOutput.writeByte((int) (this.cursorY * 16.0f));
        netOutput.writeByte((int) (this.cursorZ * 16.0f));
    }
}
