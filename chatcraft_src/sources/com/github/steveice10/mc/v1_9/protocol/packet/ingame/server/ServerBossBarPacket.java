package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.BossBarAction;
import com.github.steveice10.mc.v1_9.protocol.data.game.BossBarColor;
import com.github.steveice10.mc.v1_9.protocol.data.game.BossBarDivision;
import com.github.steveice10.mc.v1_9.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerBossBarPacket implements Packet {
    private BossBarAction action;
    private BossBarColor color;
    private boolean darkenSky;
    private BossBarDivision division;
    private boolean dragonBar;
    private float health;
    private Message title;
    private UUID uuid;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBossBarPacket() {
    }

    public ServerBossBarPacket(UUID uuid, BossBarAction bossBarAction, Message message, float f, BossBarColor bossBarColor, BossBarDivision bossBarDivision, boolean z, boolean z2) {
        this.uuid = uuid;
        this.action = BossBarAction.ADD;
        this.title = message;
        this.health = f;
        this.color = bossBarColor;
        this.division = bossBarDivision;
        this.darkenSky = z;
        this.dragonBar = z2;
    }

    public ServerBossBarPacket(UUID uuid) {
        this.uuid = uuid;
        this.action = BossBarAction.REMOVE;
    }

    public ServerBossBarPacket(UUID uuid, BossBarAction bossBarAction, float f) {
        this.uuid = uuid;
        this.action = BossBarAction.UPDATE_HEALTH;
        this.health = f;
    }

    public ServerBossBarPacket(UUID uuid, BossBarAction bossBarAction, Message message) {
        this.uuid = uuid;
        this.action = BossBarAction.UPDATE_TITLE;
        this.title = message;
    }

    public ServerBossBarPacket(UUID uuid, BossBarAction bossBarAction, BossBarColor bossBarColor, BossBarDivision bossBarDivision) {
        this.uuid = uuid;
        this.action = BossBarAction.UPDATE_STYLE;
        this.color = bossBarColor;
        this.division = bossBarDivision;
    }

    public ServerBossBarPacket(UUID uuid, BossBarAction bossBarAction, boolean z, boolean z2) {
        this.uuid = uuid;
        this.action = BossBarAction.UPDATE_FLAGS;
        this.darkenSky = z;
        this.dragonBar = z2;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public BossBarAction getAction() {
        return this.action;
    }

    public Message getTitle() {
        return this.title;
    }

    public float getHealth() {
        return this.health;
    }

    public BossBarColor getColor() {
        return this.color;
    }

    public BossBarDivision getDivision() {
        return this.division;
    }

    public boolean getDarkenSky() {
        return this.darkenSky;
    }

    public boolean isDragonBar() {
        return this.dragonBar;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.uuid = netInput.readUUID();
        this.action = (BossBarAction) MagicValues.key(BossBarAction.class, Integer.valueOf(netInput.readVarInt()));
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_TITLE) {
            this.title = Message.fromString(netInput.readString());
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_HEALTH) {
            this.health = netInput.readFloat();
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_STYLE) {
            this.color = (BossBarColor) MagicValues.key(BossBarColor.class, Integer.valueOf(netInput.readVarInt()));
            this.division = (BossBarDivision) MagicValues.key(BossBarDivision.class, Integer.valueOf(netInput.readVarInt()));
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_FLAGS) {
            int unsignedByte = netInput.readUnsignedByte();
            this.darkenSky = (unsignedByte & 1) == 1;
            this.dragonBar = (unsignedByte & 2) == 2;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeUUID(this.uuid);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_TITLE) {
            netOutput.writeString(this.title.toJsonString());
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_HEALTH) {
            netOutput.writeFloat(this.health);
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_STYLE) {
            netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.color)).intValue());
            netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.division)).intValue());
        }
        if (this.action == BossBarAction.ADD || this.action == BossBarAction.UPDATE_FLAGS) {
            int i = this.darkenSky ? 1 : 0;
            if (this.dragonBar) {
                i |= 2;
            }
            netOutput.writeByte(i);
        }
    }
}
