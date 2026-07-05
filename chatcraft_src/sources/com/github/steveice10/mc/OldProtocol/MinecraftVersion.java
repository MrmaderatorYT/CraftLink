package com.github.steveice10.mc.OldProtocol;

import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.io.stream.StreamNetInput;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MinecraftVersion extends Client {
    public MinecraftVersion(String str, int i, PacketProtocol packetProtocol, Session session) {
        super(str, i, packetProtocol, session);
    }

    public static String readString(byte[] bArr) throws IOException {
        StreamNetInput streamNetInput = new StreamNetInput(new ByteArrayInputStream(bArr));
        try {
            int varInt = streamNetInput.readVarInt();
            int length = bArr.length - streamNetInput.available();
            return new String(Arrays.copyOfRange(bArr, length, varInt + length), "UTF-8");
        } finally {
            streamNetInput.close();
        }
    }

    protected ByteArrayOutputStream encodeString(String str) throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes("UTF-8");
        writeVarInt(bytes.length, byteArrayOutputStream);
        byteArrayOutputStream.write(bytes);
        return byteArrayOutputStream;
    }

    public void writeVarInt(int i, ByteArrayOutputStream byteArrayOutputStream) {
        while ((i & (-128)) != 0) {
            byteArrayOutputStream.write((i & 127) | 128);
            i >>>= 7;
        }
        byteArrayOutputStream.write(i);
    }
}
