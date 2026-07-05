package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketNamedSound extends Packet {
    public int pitch;
    public String sound;
    public float volume;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 62;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketNamedSound() {
    }

    public PacketNamedSound(String str, int i, byte b2, int i2, float f, int i3) {
        this.sound = str;
        this.x = i;
        this.y = b2;
        this.z = i2;
        this.volume = f;
        this.pitch = i3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.sound = IOUtils.readString(dataInputStream);
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.volume = dataInputStream.readFloat();
        this.pitch = dataInputStream.readUnsignedByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.sound);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeInt(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeFloat(this.volume);
        dataOutputStream.writeByte(this.pitch);
    }
}
