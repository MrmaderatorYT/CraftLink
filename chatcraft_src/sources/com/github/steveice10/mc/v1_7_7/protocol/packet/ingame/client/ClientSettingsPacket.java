package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientSettingsPacket implements Packet {
    private boolean capes;
    private boolean chatColors;
    private ChatVisibility chatVisibility;
    private Difficulty difficulty;
    private String locale;
    private int renderDistance;

    public enum ChatVisibility {
        FULL,
        SYSTEM,
        HIDDEN
    }

    public enum Difficulty {
        PEACEFUL,
        EASY,
        NORMAL,
        HARD
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientSettingsPacket() {
    }

    public ClientSettingsPacket(String str, int i, ChatVisibility chatVisibility, boolean z, Difficulty difficulty, boolean z2) {
        this.locale = str;
        this.renderDistance = i;
        this.chatVisibility = chatVisibility;
        this.chatColors = z;
        this.difficulty = difficulty;
        this.capes = z2;
    }

    public String getLocale() {
        return this.locale;
    }

    public int getRenderDistance() {
        return this.renderDistance;
    }

    public ChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }

    public boolean getUseChatColors() {
        return this.chatColors;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public boolean getShowCapes() {
        return this.capes;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.locale = netInput.readString();
        this.renderDistance = netInput.readByte();
        this.chatVisibility = ChatVisibility.values()[netInput.readByte()];
        this.chatColors = netInput.readBoolean();
        this.difficulty = Difficulty.values()[netInput.readByte()];
        this.capes = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.locale);
        netOutput.writeByte(this.renderDistance);
        netOutput.writeByte(this.chatVisibility.ordinal());
        netOutput.writeBoolean(this.chatColors);
        netOutput.writeByte(this.difficulty.ordinal());
        netOutput.writeBoolean(this.capes);
    }
}
