package com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.Hand;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.InteractAction;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerInteractEntityPacket implements Packet {
    private InteractAction action;
    private int entityId;
    private Hand hand;
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
        this(i, interactAction, Hand.MAIN_HAND);
    }

    public ClientPlayerInteractEntityPacket(int i, InteractAction interactAction, Hand hand) {
        this(i, interactAction, 0.0f, 0.0f, 0.0f, hand);
    }

    public ClientPlayerInteractEntityPacket(int i, InteractAction interactAction, float f, float f2, float f3, Hand hand) {
        this.entityId = i;
        this.action = interactAction;
        this.targetX = f;
        this.targetY = f2;
        this.targetZ = f3;
        this.hand = hand;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public InteractAction getAction() {
        return this.action;
    }

    public float getTargetX() {
        return this.targetX;
    }

    public float getTargetY() {
        return this.targetY;
    }

    public float getTargetZ() {
        return this.targetZ;
    }

    public Hand getHand() {
        return this.hand;
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
        if (this.action == InteractAction.INTERACT || this.action == InteractAction.INTERACT_AT) {
            this.hand = (Hand) MagicValues.key(Hand.class, Integer.valueOf(netInput.readVarInt()));
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
        if (this.action == InteractAction.INTERACT || this.action == InteractAction.INTERACT_AT) {
            netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.hand)).intValue());
        }
    }
}
