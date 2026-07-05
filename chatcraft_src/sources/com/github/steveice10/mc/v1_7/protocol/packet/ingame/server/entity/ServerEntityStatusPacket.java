package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerEntityStatusPacket implements Packet {
    protected int entityId;
    protected Status status;

    public enum Status {
        HURT_OR_MINECART_SPAWNER_DELAY_RESET,
        LIVING_HURT,
        DEAD,
        IRON_GOLEM_THROW,
        TAMING,
        TAMED,
        WOLF_SHAKING,
        FINISHED_EATING,
        SHEEP_GRAZING_OR_TNT_CART_EXPLODING,
        IRON_GOLEM_ROSE,
        VILLAGER_HEARTS,
        VILLAGER_ANGRY,
        VILLAGER_HAPPY,
        WITCH_MAGIC_PARTICLES,
        ZOMBIE_VILLAGER_SHAKING,
        FIREWORK_EXPLODING,
        ANIMAL_HEARTS
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityStatusPacket() {
    }

    public ServerEntityStatusPacket(int i, Status status) {
        this.entityId = i;
        this.status = status;
    }

    private static byte statusToValue(Status status) throws IOException {
        switch (status) {
            case HURT_OR_MINECART_SPAWNER_DELAY_RESET:
                return (byte) 1;
            case LIVING_HURT:
                return (byte) 2;
            case DEAD:
                return (byte) 3;
            case IRON_GOLEM_THROW:
                return (byte) 4;
            case TAMING:
                return (byte) 6;
            case TAMED:
                return (byte) 7;
            case WOLF_SHAKING:
                return (byte) 8;
            case FINISHED_EATING:
                return (byte) 9;
            case SHEEP_GRAZING_OR_TNT_CART_EXPLODING:
                return (byte) 10;
            case IRON_GOLEM_ROSE:
                return (byte) 11;
            case VILLAGER_HEARTS:
                return (byte) 12;
            case VILLAGER_ANGRY:
                return (byte) 13;
            case VILLAGER_HAPPY:
                return (byte) 14;
            case WITCH_MAGIC_PARTICLES:
                return (byte) 15;
            case ZOMBIE_VILLAGER_SHAKING:
                return (byte) 16;
            case FIREWORK_EXPLODING:
                return (byte) 17;
            case ANIMAL_HEARTS:
                return (byte) 18;
            default:
                throw new IOException("Unmapped entity status: " + status);
        }
    }

    private static Status valueToStatus(byte b2) throws IOException {
        switch (b2) {
            case 1:
                return Status.HURT_OR_MINECART_SPAWNER_DELAY_RESET;
            case 2:
                return Status.LIVING_HURT;
            case 3:
                return Status.DEAD;
            case 4:
                return Status.IRON_GOLEM_THROW;
            case 5:
            default:
                throw new IOException("Unknown entity status value: " + ((int) b2));
            case 6:
                return Status.TAMING;
            case 7:
                return Status.TAMED;
            case 8:
                return Status.WOLF_SHAKING;
            case 9:
                return Status.FINISHED_EATING;
            case 10:
                return Status.SHEEP_GRAZING_OR_TNT_CART_EXPLODING;
            case 11:
                return Status.IRON_GOLEM_ROSE;
            case 12:
                return Status.VILLAGER_HEARTS;
            case 13:
                return Status.VILLAGER_ANGRY;
            case 14:
                return Status.VILLAGER_HAPPY;
            case 15:
                return Status.WITCH_MAGIC_PARTICLES;
            case 16:
                return Status.ZOMBIE_VILLAGER_SHAKING;
            case 17:
                return Status.FIREWORK_EXPLODING;
            case 18:
                return Status.ANIMAL_HEARTS;
        }
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Status getStatus() {
        return this.status;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.status = valueToStatus(netInput.readByte());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(statusToValue(this.status));
    }
}
