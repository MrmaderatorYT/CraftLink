package com.github.steveice10.mc.common;

import com.github.steveice10.packetlib.io.NetInput;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUtils {
    public static void skipItemStack(NetInput netInput) {
        if (netInput.readShort() >= 0) {
            netInput.readByte();
            netInput.readShort();
            skipNBTTagCompound(netInput);
        }
    }

    public static void skipNBTTagCompound(NetInput netInput) {
        short s = netInput.readShort();
        if (s >= 0) {
            netInput.readBytes(s);
        }
    }

    public static void skipMetadata(NetInput netInput) throws IOException {
        while (true) {
            byte b2 = netInput.readByte();
            if (b2 != 127) {
                int i = (b2 & 224) >> 5;
                switch (i) {
                    case 0:
                        netInput.readByte();
                        break;
                    case 1:
                        netInput.readShort();
                        break;
                    case 2:
                        netInput.readInt();
                        break;
                    case 3:
                        netInput.readFloat();
                        break;
                    case 4:
                        readString(netInput, 64);
                        break;
                    case 5:
                        skipItemStack(netInput);
                        break;
                    case 6:
                        netInput.readInt();
                        netInput.readInt();
                        netInput.readInt();
                        break;
                    default:
                        System.out.println("Error? " + i);
                        break;
                }
            } else {
                return;
            }
        }
    }

    public static String readString(NetInput netInput, int i) throws IOException {
        short s = netInput.readShort();
        if (s > i) {
            throw new IOException("Received string length longer than maximum allowed (" + ((int) s) + " > " + i + ")");
        }
        if (s < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < s; i2++) {
            sb.append(netInput.readChar());
        }
        return sb.toString();
    }
}
