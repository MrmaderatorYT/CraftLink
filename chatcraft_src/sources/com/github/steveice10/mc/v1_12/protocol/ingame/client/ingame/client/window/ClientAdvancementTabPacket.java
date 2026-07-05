package com.github.steveice10.mc.v1_12.protocol.ingame.client.ingame.client.window;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.window.AdvancementTabAction;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ClientAdvancementTabPacket implements Packet {
    private AdvancementTabAction action;
    private String tabId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    public ClientAdvancementTabPacket() {
        this.action = AdvancementTabAction.CLOSED_SCREEN;
    }

    public ClientAdvancementTabPacket(String str) {
        this.action = AdvancementTabAction.OPENED_TAB;
        this.tabId = str;
    }

    public String getTabId() {
        if (this.action != AdvancementTabAction.OPENED_TAB) {
            throw new IllegalStateException("tabId is only set if action is " + AdvancementTabAction.OPENED_TAB + " but it was " + this.action);
        }
        return this.tabId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) throws IOException {
        int[] iArr = AnonymousClass1.$SwitchMap$com$github$steveice10$mc$v1_10$protocol$data$game$window$AdvancementTabAction;
        AdvancementTabAction advancementTabAction = (AdvancementTabAction) MagicValues.key(AdvancementTabAction.class, Integer.valueOf(netInput.readVarInt()));
        this.action = advancementTabAction;
        switch (iArr[advancementTabAction.ordinal()]) {
            case 1:
                return;
            case 2:
                this.tabId = netInput.readString();
                return;
            default:
                throw new IOException("Unknown advancement tab action: " + this.action);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        switch (this.action) {
            case CLOSED_SCREEN:
                return;
            case OPENED_TAB:
                netOutput.writeString(this.tabId);
                return;
            default:
                throw new IOException("Unknown advancement tab action: " + this.action);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
