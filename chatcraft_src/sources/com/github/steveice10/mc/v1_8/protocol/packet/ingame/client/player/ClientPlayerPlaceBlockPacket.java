package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_8.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.Face;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerPlaceBlockPacket implements Packet {
    private float cursorX;
    private float cursorY;
    private float cursorZ;
    private Face face;
    private ItemStack held;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerPlaceBlockPacket() {
    }

    public ClientPlayerPlaceBlockPacket(Position position, Face face, ItemStack itemStack, float f, float f2, float f3) {
        this.position = position;
        this.face = face;
        this.held = itemStack;
        this.cursorX = f;
        this.cursorY = f2;
        this.cursorZ = f3;
    }

    public Position getPosition() {
        return this.position;
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
        this.position = NetUtil.readPosition(netInput);
        this.face = (Face) MagicValues.key(Face.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.held = NetUtil.readItem(netInput);
        this.cursorX = netInput.readByte() / 16.0f;
        this.cursorY = netInput.readByte() / 16.0f;
        this.cursorZ = netInput.readByte() / 16.0f;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.face)).intValue());
        NetUtil.writeItem(netOutput, this.held);
        netOutput.writeByte((int) (this.cursorX * 16.0f));
        netOutput.writeByte((int) (this.cursorY * 16.0f));
        netOutput.writeByte((int) (this.cursorZ * 16.0f));
    }
}
