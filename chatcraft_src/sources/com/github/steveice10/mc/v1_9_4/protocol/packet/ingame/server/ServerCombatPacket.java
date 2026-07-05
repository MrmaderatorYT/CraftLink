package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.player.CombatState;
import com.github.steveice10.mc.v1_9_4.protocol.data.message.Message;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerCombatPacket implements Packet {
    private int duration;
    private int entityId;
    private Message message;
    private int playerId;
    private CombatState state;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    public ServerCombatPacket() {
        this.state = CombatState.ENTER_COMBAT;
    }

    public ServerCombatPacket(int i, int i2) {
        this.state = CombatState.END_COMBAT;
        this.entityId = i;
        this.duration = i2;
    }

    public ServerCombatPacket(int i, int i2, Message message) {
        this.state = CombatState.ENTITY_DEAD;
        this.entityId = i;
        this.playerId = i2;
        this.message = message;
    }

    public CombatState getCombatState() {
        return this.state;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public Message getMessage() {
        return this.message;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.state = (CombatState) MagicValues.key(CombatState.class, Integer.valueOf(netInput.readVarInt()));
        if (this.state == CombatState.END_COMBAT) {
            this.duration = netInput.readVarInt();
            this.entityId = netInput.readInt();
        } else if (this.state == CombatState.ENTITY_DEAD) {
            this.playerId = netInput.readVarInt();
            this.entityId = netInput.readInt();
            this.message = Message.fromString(netInput.readString());
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.state)).intValue());
        if (this.state == CombatState.END_COMBAT) {
            netOutput.writeVarInt(this.duration);
            netOutput.writeInt(this.entityId);
        } else if (this.state == CombatState.ENTITY_DEAD) {
            netOutput.writeVarInt(this.playerId);
            netOutput.writeInt(this.entityId);
            netOutput.writeString(this.message.toJsonString());
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
