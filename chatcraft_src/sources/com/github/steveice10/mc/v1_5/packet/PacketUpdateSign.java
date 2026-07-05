package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUpdateSign extends Packet {
    public String[] lines;
    public int x;
    public short y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 130;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateSign() {
    }

    public PacketUpdateSign(int i, short s, int i2, String[] strArr) {
        this.x = i;
        this.y = s;
        this.z = i2;
        this.lines = strArr;
        if (this.lines == null || this.lines.length != 4) {
            throw new IllegalArgumentException("Line array size must be 4!");
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readShort();
        this.z = dataInputStream.readInt();
        this.lines = new String[4];
        this.lines[0] = IOUtils.readString(dataInputStream);
        this.lines[1] = IOUtils.readString(dataInputStream);
        this.lines[2] = IOUtils.readString(dataInputStream);
        this.lines[3] = IOUtils.readString(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeShort(this.y);
        dataOutputStream.writeInt(this.z);
        IOUtils.writeString(dataOutputStream, this.lines[0]);
        IOUtils.writeString(dataOutputStream, this.lines[1]);
        IOUtils.writeString(dataOutputStream, this.lines[2]);
        IOUtils.writeString(dataOutputStream, this.lines[3]);
    }
}
