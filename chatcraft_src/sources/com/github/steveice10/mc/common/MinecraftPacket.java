package com.github.steveice10.mc.common;

import com.github.steveice10.mc.common.util.ObjectUtil;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public abstract class MinecraftPacket implements Packet {
    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    public String toString() {
        return ObjectUtil.toString(this);
    }
}
