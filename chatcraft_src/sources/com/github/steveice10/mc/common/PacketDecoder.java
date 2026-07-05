package com.github.steveice10.mc.common;

import com.github.steveice10.packetlib.io.stream.StreamNetInput;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

/* loaded from: classes.dex */
public class PacketDecoder {
    public StreamNetInput stream;

    public PacketDecoder(InputStream inputStream) {
        this.stream = new StreamNetInput(inputStream);
    }

    public void setDecryptor(Cipher cipher) {
        this.stream = new StreamNetInput(new CipherInputStream(this.stream.getInputStream(), cipher));
    }

    public int getPacketAvailable() {
        return this.stream.available();
    }

    public void close() throws IOException {
        this.stream.getInputStream().close();
    }

    public synchronized byte[] recievePacket() {
        return this.stream.readBytes(this.stream.readVarInt());
    }
}
