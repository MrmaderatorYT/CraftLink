package com.github.steveice10.mc.v1_11_2.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.v1_10.protocol.data.SubProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import java.net.Proxy;
import java.security.Key;

/* loaded from: classes.dex */
public class MinecraftProtocol extends com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol {
    public MinecraftProtocol(SubProtocol subProtocol) {
        super(subProtocol);
    }

    public MinecraftProtocol(String str) {
        super(str);
    }

    public MinecraftProtocol(String str, String str2) {
        super(str, str2);
    }

    public MinecraftProtocol(String str, String str2, boolean z) {
        super(str, str2, z);
    }

    public MinecraftProtocol(String str, String str2, boolean z, Proxy proxy) {
        super(str, str2, z, proxy);
    }

    public MinecraftProtocol(GameProfile gameProfile, String str) {
        super(gameProfile, str);
    }

    @Override // com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void setSubProtocol(SubProtocol subProtocol, boolean z, Session session) {
        super.setSubProtocol(subProtocol, z, session);
    }

    @Override // com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol, com.github.steveice10.packetlib.packet.PacketProtocol
    public void newClientSession(Client client, Session session) {
        if (this.profile != null) {
            session.setFlag("profile", this.profile);
            session.setFlag("access-token", this.accessToken);
        }
        setSubProtocol(this.subProtocol, true, session);
        session.addListener(new ClientListener());
    }

    @Override // com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void enableEncryption(Key key) {
        super.enableEncryption(key);
    }
}
