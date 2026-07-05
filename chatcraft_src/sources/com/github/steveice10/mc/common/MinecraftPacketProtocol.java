package com.github.steveice10.mc.common;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.packetlib.packet.PacketProtocol;

/* loaded from: classes.dex */
public abstract class MinecraftPacketProtocol extends PacketProtocol {
    public abstract GameProfile getProfile();
}
