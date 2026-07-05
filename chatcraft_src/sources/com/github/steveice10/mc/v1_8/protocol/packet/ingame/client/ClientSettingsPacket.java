package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.setting.ChatVisibility;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.setting.SkinPart;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ClientSettingsPacket implements Packet {
    private boolean chatColors;
    private ChatVisibility chatVisibility;
    private String locale;
    private int renderDistance;
    private List<SkinPart> visibleParts;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientSettingsPacket() {
    }

    public ClientSettingsPacket(String str, int i, ChatVisibility chatVisibility, boolean z, SkinPart... skinPartArr) {
        this.locale = str;
        this.renderDistance = i;
        this.chatVisibility = chatVisibility;
        this.chatColors = z;
        this.visibleParts = Arrays.asList(skinPartArr);
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

    public List<SkinPart> getVisibleParts() {
        return this.visibleParts;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.locale = netInput.readString();
        this.renderDistance = netInput.readByte();
        this.chatVisibility = (ChatVisibility) MagicValues.key(ChatVisibility.class, Byte.valueOf(netInput.readByte()));
        this.chatColors = netInput.readBoolean();
        this.visibleParts = new ArrayList();
        int unsignedByte = netInput.readUnsignedByte();
        for (SkinPart skinPart : SkinPart.values()) {
            int iOrdinal = 1 << skinPart.ordinal();
            if ((unsignedByte & iOrdinal) == iOrdinal) {
                this.visibleParts.add(skinPart);
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.locale);
        netOutput.writeByte(this.renderDistance);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.chatVisibility)).intValue());
        netOutput.writeBoolean(this.chatColors);
        Iterator<SkinPart> it = this.visibleParts.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << it.next().ordinal();
        }
        netOutput.writeByte(iOrdinal);
    }
}
