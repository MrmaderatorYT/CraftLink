package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerDigPacket implements Packet {
    private Face face;
    private Status status;
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
        INVALID
    }

    public enum Status {
        START_DIGGING,
        CANCEL_DIGGING,
        FINISH_DIGGING,
        DROP_ITEM_STACK,
        DROP_ITEM,
        SHOOT_ARROW_OR_FINISH_EATING
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerDigPacket() {
    }

    public ClientPlayerDigPacket(Status status, int i, int i2, int i3, Face face) {
        this.status = status;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.face = face;
    }

    private static Face valueToFace(int i) {
        switch (i) {
            case 0:
                return Face.BOTTOM;
            case 1:
                return Face.TOP;
            case 2:
                return Face.EAST;
            case 3:
                return Face.WEST;
            case 4:
                return Face.NORTH;
            case 5:
                return Face.SOUTH;
            default:
                return Face.INVALID;
        }
    }

    private static int faceToValue(Face face) {
        switch (face) {
            case BOTTOM:
                return 0;
            case TOP:
                return 1;
            case EAST:
                return 2;
            case WEST:
                return 3;
            case NORTH:
                return 4;
            case SOUTH:
                return 5;
            default:
                return 255;
        }
    }

    public Status getStatus() {
        return this.status;
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.status = Status.values()[netInput.readUnsignedByte()];
        this.x = netInput.readInt();
        this.y = netInput.readUnsignedByte();
        this.z = netInput.readInt();
        this.face = valueToFace(netInput.readUnsignedByte());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.status.ordinal());
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(faceToValue(this.face));
    }
}
