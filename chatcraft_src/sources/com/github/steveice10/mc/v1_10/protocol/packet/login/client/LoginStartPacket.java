package com.github.steveice10.mc.v1_10.protocol.packet.login.client;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class LoginStartPacket implements Packet {
    private String username;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private LoginStartPacket() {
    }

    public LoginStartPacket(String str) {
        this.username = str;
    }

    public String getUsername() {
        return this.username;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.username = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.username);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
