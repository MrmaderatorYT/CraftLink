package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketTeam extends Packet {
    public byte action;
    public String displayName;
    public byte friendlyFire;
    public String name;
    public String[] players;
    public String prefix;
    public String suffix;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 209;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketTeam() {
    }

    public PacketTeam(String str) {
        this.name = str;
        this.action = (byte) 1;
    }

    public PacketTeam(String str, String[] strArr, boolean z) {
        this.name = str;
        this.players = strArr;
        this.action = z ? (byte) 3 : (byte) 4;
    }

    public PacketTeam(String str, String str2, String str3, String str4, byte b2) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = b2;
        this.action = (byte) 2;
    }

    public PacketTeam(String str, String str2, String str3, String str4, byte b2, String[] strArr) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = b2;
        this.players = strArr;
        this.action = (byte) 0;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.name = IOUtils.readString(dataInputStream);
        this.action = dataInputStream.readByte();
        int i = 0;
        switch (this.action) {
            case 0:
                this.displayName = IOUtils.readString(dataInputStream);
                this.prefix = IOUtils.readString(dataInputStream);
                this.suffix = IOUtils.readString(dataInputStream);
                this.friendlyFire = dataInputStream.readByte();
                this.players = new String[dataInputStream.readShort()];
                while (i < this.players.length) {
                    this.players[i] = IOUtils.readString(dataInputStream);
                    i++;
                }
                break;
            case 2:
                this.displayName = IOUtils.readString(dataInputStream);
                this.prefix = IOUtils.readString(dataInputStream);
                this.suffix = IOUtils.readString(dataInputStream);
                this.friendlyFire = dataInputStream.readByte();
                break;
            case 3:
            case 4:
                this.players = new String[dataInputStream.readShort()];
                while (i < this.players.length) {
                    this.players[i] = IOUtils.readString(dataInputStream);
                    i++;
                }
                break;
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.name);
        dataOutputStream.writeByte(this.action);
        int i = 0;
        switch (this.action) {
            case 0:
                IOUtils.writeString(dataOutputStream, this.displayName);
                IOUtils.writeString(dataOutputStream, this.prefix);
                IOUtils.writeString(dataOutputStream, this.suffix);
                dataOutputStream.writeByte(this.friendlyFire);
                dataOutputStream.writeShort(this.players.length);
                while (i < this.players.length) {
                    IOUtils.writeString(dataOutputStream, this.players[i]);
                    i++;
                }
                break;
            case 2:
                IOUtils.writeString(dataOutputStream, this.displayName);
                IOUtils.writeString(dataOutputStream, this.prefix);
                IOUtils.writeString(dataOutputStream, this.suffix);
                dataOutputStream.writeByte(this.friendlyFire);
                break;
            case 3:
            case 4:
                dataOutputStream.writeShort(this.players.length);
                while (i < this.players.length) {
                    IOUtils.writeString(dataOutputStream, this.players[i]);
                    i++;
                }
                break;
        }
    }
}
