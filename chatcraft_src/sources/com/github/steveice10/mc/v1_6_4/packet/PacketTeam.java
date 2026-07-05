package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketTeam extends Packet {
    public byte action;
    public String displayName;
    public byte friendlyFire;
    public String name;
    public String[] players;
    public String prefix;
    public String suffix;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 209;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.action = netInput.readByte();
        int i = 0;
        switch (this.action) {
            case 0:
                this.displayName = netInput.readString();
                this.prefix = netInput.readString();
                this.suffix = netInput.readString();
                this.friendlyFire = netInput.readByte();
                this.players = new String[netInput.readShort()];
                while (i < this.players.length) {
                    this.players[i] = netInput.readString();
                    i++;
                }
                break;
            case 2:
                this.displayName = netInput.readString();
                this.prefix = netInput.readString();
                this.suffix = netInput.readString();
                this.friendlyFire = netInput.readByte();
                break;
            case 3:
            case 4:
                this.players = new String[netInput.readShort()];
                while (i < this.players.length) {
                    this.players[i] = netInput.readString();
                    i++;
                }
                break;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeByte(this.action);
        int i = 0;
        switch (this.action) {
            case 0:
                netOutput.writeString(this.displayName);
                netOutput.writeString(this.prefix);
                netOutput.writeString(this.suffix);
                netOutput.writeByte(this.friendlyFire);
                netOutput.writeShort(this.players.length);
                while (i < this.players.length) {
                    netOutput.writeString(this.players[i]);
                    i++;
                }
                break;
            case 2:
                netOutput.writeString(this.displayName);
                netOutput.writeString(this.prefix);
                netOutput.writeString(this.suffix);
                netOutput.writeByte(this.friendlyFire);
                break;
            case 3:
            case 4:
                netOutput.writeShort(this.players.length);
                while (i < this.players.length) {
                    netOutput.writeString(this.players[i]);
                    i++;
                }
                break;
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
