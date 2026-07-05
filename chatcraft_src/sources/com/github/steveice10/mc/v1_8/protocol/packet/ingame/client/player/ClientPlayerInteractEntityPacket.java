package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.InteractAction;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerInteractEntityPacket implements Packet {
    private InteractAction action;
    private int entityId;
    private float targetX;
    private float targetY;
    private float targetZ;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerInteractEntityPacket() {
    }

    public ClientPlayerInteractEntityPacket(int i, InteractAction interactAction) {
        this(i, interactAction, 0.0f, 0.0f, 0.0f);
    }

    public ClientPlayerInteractEntityPacket(int i, InteractAction interactAction, float f, float f2, float f3) {
        this.entityId = i;
        this.action = interactAction;
        this.targetX = f;
        this.targetY = f2;
        this.targetZ = f3;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public InteractAction getAction() {
        return this.action;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.action = (InteractAction) MagicValues.key(InteractAction.class, Integer.valueOf(netInput.readVarInt()));
        if (this.action == InteractAction.INTERACT_AT) {
            this.targetX = netInput.readFloat();
            this.targetY = netInput.readFloat();
            this.targetZ = netInput.readFloat();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        if (this.action == InteractAction.INTERACT_AT) {
            netOutput.writeFloat(this.targetX);
            netOutput.writeFloat(this.targetY);
            netOutput.writeFloat(this.targetZ);
        }
    }
}
