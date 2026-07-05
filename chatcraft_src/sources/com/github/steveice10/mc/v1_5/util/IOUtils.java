package com.github.steveice10.mc.v1_5.util;

import com.github.steveice10.mc.v1_5.data.Coordinates;
import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.data.WatchableObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class IOUtils {
    private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    private IOUtils() {
    }

    public static void writeString(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null!");
        }
        int length = str.length();
        if (length > 65536) {
            throw new IOException("String too big (was " + str.length() + " bytes encoded, max 65536)");
        }
        dataOutputStream.writeShort(length);
        for (int i = 0; i < length; i++) {
            dataOutputStream.writeChar(str.charAt(i));
        }
    }

    public static void writeUtf8String(DataOutputStream dataOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(CHARSET_UTF8);
        if (bytes.length >= 65536) {
            throw new IllegalArgumentException("Encoded UTF-8 string too long.");
        }
        dataOutputStream.writeShort(bytes.length);
        dataOutputStream.write(bytes);
    }

    public static String readString(DataInputStream dataInputStream) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        char[] cArr = new char[unsignedShort];
        for (int i = 0; i < unsignedShort; i++) {
            cArr[i] = dataInputStream.readChar();
        }
        return new String(cArr);
    }

    public static String readUtf8String(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
        dataInputStream.readFully(bArr);
        return new String(bArr, CHARSET_UTF8);
    }

    public static WatchableObject[] readMetadata(DataInputStream dataInputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte b2 = dataInputStream.readByte();
            if (b2 != 127) {
                int i = (b2 & 224) >> 5;
                int i2 = b2 & 31;
                WatchableObject watchableObject = null;
                switch (i) {
                    case 0:
                        watchableObject = new WatchableObject(i, i2, Byte.valueOf(dataInputStream.readByte()));
                        break;
                    case 1:
                        watchableObject = new WatchableObject(i, i2, Short.valueOf(dataInputStream.readShort()));
                        break;
                    case 2:
                        watchableObject = new WatchableObject(i, i2, Integer.valueOf(dataInputStream.readInt()));
                        break;
                    case 3:
                        watchableObject = new WatchableObject(i, i2, Float.valueOf(dataInputStream.readFloat()));
                        break;
                    case 4:
                        watchableObject = new WatchableObject(i, i2, readString(dataInputStream));
                        break;
                    case 5:
                        ItemStack itemStack = new ItemStack();
                        itemStack.read(dataInputStream);
                        watchableObject = new WatchableObject(i, i2, itemStack);
                        break;
                    case 6:
                        watchableObject = new WatchableObject(i, i2, new Coordinates(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt()));
                        break;
                }
                arrayList.add(watchableObject);
            } else {
                return (WatchableObject[]) arrayList.toArray(new WatchableObject[arrayList.size()]);
            }
        }
    }

    public static void writeMetadata(DataOutputStream dataOutputStream, WatchableObject[] watchableObjectArr) throws IOException {
        for (WatchableObject watchableObject : watchableObjectArr) {
            dataOutputStream.writeByte(((watchableObject.getType() << 5) | (watchableObject.getType() & 31)) & 255);
            switch (watchableObject.getType()) {
                case 0:
                    dataOutputStream.writeByte(((Byte) watchableObject.getValue()).byteValue());
                    break;
                case 1:
                    dataOutputStream.writeShort(((Short) watchableObject.getValue()).shortValue());
                    break;
                case 2:
                    dataOutputStream.writeInt(((Integer) watchableObject.getValue()).intValue());
                    break;
                case 3:
                    dataOutputStream.writeFloat(((Float) watchableObject.getValue()).floatValue());
                    break;
                case 4:
                    writeString(dataOutputStream, (String) watchableObject.getValue());
                    break;
                case 5:
                    ((ItemStack) watchableObject.getValue()).write(dataOutputStream);
                    break;
                case 6:
                    Coordinates coordinates = (Coordinates) watchableObject.getValue();
                    dataOutputStream.writeInt(coordinates.getX());
                    dataOutputStream.writeInt(coordinates.getY());
                    dataOutputStream.writeInt(coordinates.getZ());
                    break;
            }
        }
        dataOutputStream.writeByte(127);
    }
}
