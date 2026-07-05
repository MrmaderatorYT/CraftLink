package com.github.steveice10.mc.v1_12.protocol.ingame.server.windows;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerAdvancementTabPacket implements Packet {
    private String tabId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerAdvancementTabPacket() {
    }

    public ServerAdvancementTabPacket(String str) {
        this.tabId = str;
    }

    public String getTabId() {
        return this.tabId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        if (netInput.readBoolean()) {
            this.tabId = netInput.readString();
        } else {
            this.tabId = null;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        if (this.tabId != null) {
            netOutput.writeBoolean(true);
            netOutput.writeString(this.tabId);
        } else {
            netOutput.writeBoolean(false);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
