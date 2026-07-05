package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.Coordinates;
import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.data.WatchableObject;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class Packet implements com.github.steveice10.packetlib.packet.Packet {
    public static boolean getBit(int i, int i2) {
        return (i & i2) == i2;
    }

    public static byte setBit(byte b2, int i, boolean z) {
        return (byte) (z ? b2 | i : b2 & (i ^ (-1)));
    }

    protected void accept(PacketVisitor packetVisitor) {
    }

    public abstract int getId();

    protected void handleClient(Client client) {
    }

    protected void handleServer(ServerConnection serverConnection) {
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    public StandardItemStack readItem(NetInput netInput) {
        byte b2;
        short s;
        short s2 = netInput.readShort();
        byte[] bytes = null;
        if (s2 > -1) {
            b2 = netInput.readByte();
            s = netInput.readShort();
            short s3 = netInput.readShort();
            if (s3 > -1) {
                bytes = netInput.readBytes(s3);
            }
        } else {
            b2 = 1;
            s = 0;
        }
        return new StandardItemStack(s2, b2, s, bytes);
    }

    public void writeItem(NetOutput netOutput, StandardItemStack standardItemStack) {
        netOutput.writeShort(standardItemStack.getItem());
        if (standardItemStack.getItem() != -1) {
            netOutput.writeByte(standardItemStack.getStackSize());
            netOutput.writeShort(standardItemStack.getDamage());
            if (standardItemStack.getNBT() != null) {
                netOutput.writeShort(standardItemStack.getNBT().length);
                netOutput.writeBytes(standardItemStack.getNBT());
            } else {
                netOutput.writeShort(-1);
            }
        }
    }

    public void writeMetadata(NetOutput netOutput, WatchableObject[] watchableObjectArr) {
        for (WatchableObject watchableObject : watchableObjectArr) {
            netOutput.writeByte(((watchableObject.getType() << 5) | (watchableObject.getType() & 31)) & 255);
            switch (watchableObject.getType()) {
                case 0:
                    netOutput.writeByte(((Byte) watchableObject.getValue()).byteValue());
                    break;
                case 1:
                    netOutput.writeShort(((Short) watchableObject.getValue()).shortValue());
                    break;
                case 2:
                    netOutput.writeInt(((Integer) watchableObject.getValue()).intValue());
                    break;
                case 3:
                    netOutput.writeFloat(((Float) watchableObject.getValue()).floatValue());
                    break;
                case 4:
                    netOutput.writeString((String) watchableObject.getValue());
                    break;
                case 5:
                    writeItem(netOutput, (StandardItemStack) watchableObject.getValue());
                    break;
                case 6:
                    writeCoordinates(netOutput, (Coordinates) watchableObject.getValue());
                    break;
            }
        }
        netOutput.writeByte(127);
    }

    public void writeCoordinates(NetOutput netOutput, Coordinates coordinates) {
        netOutput.writeInt(coordinates.getX());
        netOutput.writeInt(coordinates.getY());
        netOutput.writeInt(coordinates.getZ());
    }

    public WatchableObject[] readMetadata(NetInput netInput) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte b2 = netInput.readByte();
            if (b2 != 127) {
                int i = (b2 & 224) >> 5;
                int i2 = b2 & 31;
                WatchableObject watchableObject = null;
                switch (i) {
                    case 0:
                        watchableObject = new WatchableObject(i, i2, Byte.valueOf(netInput.readByte()));
                        break;
                    case 1:
                        watchableObject = new WatchableObject(i, i2, Short.valueOf(netInput.readShort()));
                        break;
                    case 2:
                        watchableObject = new WatchableObject(i, i2, Integer.valueOf(netInput.readInt()));
                        break;
                    case 3:
                        watchableObject = new WatchableObject(i, i2, Float.valueOf(netInput.readFloat()));
                        break;
                    case 4:
                        watchableObject = new WatchableObject(i, i2, netInput.readString());
                        break;
                    case 5:
                        watchableObject = new WatchableObject(i, i2, readItem(netInput));
                        break;
                    case 6:
                        watchableObject = new WatchableObject(i, i2, readCoordinates(netInput));
                        break;
                }
                arrayList.add(watchableObject);
            } else {
                return (WatchableObject[]) arrayList.toArray(new WatchableObject[arrayList.size()]);
            }
        }
    }

    public Coordinates readCoordinates(NetInput netInput) {
        return new Coordinates(netInput.readInt(), netInput.readInt(), netInput.readInt());
    }
}
