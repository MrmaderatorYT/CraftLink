package com.github.steveice10.mc.v1_7.protocol.packet.login.server;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.util.UUIDSerializer;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class LoginSuccessPacket implements Packet {
    private GameProfile profile;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private LoginSuccessPacket() {
    }

    public LoginSuccessPacket(GameProfile gameProfile) {
        this.profile = gameProfile;
    }

    public GameProfile getProfile() {
        return this.profile;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.profile = new GameProfile(UUIDSerializer.fromString(netInput.readString()), netInput.readString());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(UUIDSerializer.fromUUID(this.profile.getId()));
        netOutput.writeString(this.profile.getName());
    }
}
