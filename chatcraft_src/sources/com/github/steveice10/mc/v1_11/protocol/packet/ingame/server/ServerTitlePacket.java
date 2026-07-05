package com.github.steveice10.mc.v1_11.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.TitleAction;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerTitlePacket implements Packet {
    private TitleAction action;
    private Message actionBar;
    private int fadeIn;
    private int fadeOut;
    private int stay;
    private Message subtitle;
    private Message title;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerTitlePacket() {
    }

    public ServerTitlePacket(String str, boolean z) {
        this(Message.fromString(str), z);
    }

    public ServerTitlePacket(Message message, boolean z) {
        this(z ? TitleAction.SUBTITLE : TitleAction.TITLE, message);
    }

    public ServerTitlePacket(TitleAction titleAction, String str) {
        this(titleAction, Message.fromString(str));
    }

    public ServerTitlePacket(TitleAction titleAction, Message message) {
        this.action = titleAction;
        switch (titleAction) {
            case TITLE:
                this.title = message;
                return;
            case SUBTITLE:
                this.subtitle = message;
                return;
            case ACTION_BAR:
                this.actionBar = message;
                return;
            default:
                throw new IllegalArgumentException("action must be one of TITLE, SUBTITLE, ACTION_BAR");
        }
    }

    public ServerTitlePacket(int i, int i2, int i3) {
        this.action = TitleAction.TIMES;
        this.fadeIn = i;
        this.stay = i2;
        this.fadeOut = i3;
    }

    public ServerTitlePacket(boolean z) {
        if (z) {
            this.action = TitleAction.CLEAR;
        } else {
            this.action = TitleAction.RESET;
        }
    }

    public TitleAction getAction() {
        return this.action;
    }

    public Message getTitle() {
        return this.title;
    }

    public Message getSubtitle() {
        return this.subtitle;
    }

    public Message getActionBar() {
        return this.actionBar;
    }

    public int getFadeIn() {
        return this.fadeIn;
    }

    public int getStay() {
        return this.stay;
    }

    public int getFadeOut() {
        return this.fadeOut;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.action = (TitleAction) MagicValues.key(TitleAction.class, Integer.valueOf(netInput.readVarInt()));
        switch (this.action) {
            case TITLE:
                this.title = Message.fromString(netInput.readString());
                break;
            case SUBTITLE:
                this.subtitle = Message.fromString(netInput.readString());
                break;
            case ACTION_BAR:
                this.actionBar = Message.fromString(netInput.readString());
                break;
            case TIMES:
                this.fadeIn = netInput.readInt();
                this.stay = netInput.readInt();
                this.fadeOut = netInput.readInt();
                break;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        switch (this.action) {
            case TITLE:
                netOutput.writeString(this.title.toJsonString());
                break;
            case SUBTITLE:
                netOutput.writeString(this.subtitle.toJsonString());
                break;
            case ACTION_BAR:
                netOutput.writeString(this.actionBar.toJsonString());
                break;
            case TIMES:
                netOutput.writeInt(this.fadeIn);
                netOutput.writeInt(this.stay);
                netOutput.writeInt(this.fadeOut);
                break;
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
