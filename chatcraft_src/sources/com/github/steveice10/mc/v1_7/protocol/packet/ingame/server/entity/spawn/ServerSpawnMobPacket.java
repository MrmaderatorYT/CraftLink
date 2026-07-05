package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_7.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_7.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerSpawnMobPacket implements Packet {
    private int entityId;
    private float headYaw;
    private EntityMetadata[] metadata;
    private double motX;
    private double motY;
    private double motZ;
    private float pitch;
    private Type type;
    private double x;
    private double y;
    private float yaw;
    private double z;

    public enum Type {
        CREEPER,
        SKELETON,
        SPIDER,
        GIANT_ZOMBIE,
        ZOMBIE,
        SLIME,
        GHAST,
        ZOMBIE_PIGMAN,
        ENDERMAN,
        CAVE_SPIDER,
        SILVERFISH,
        BLAZE,
        MAGMA_CUBE,
        ENDER_DRAGON,
        WITHER,
        BAT,
        WITCH,
        PIG,
        SHEEP,
        COW,
        CHICKEN,
        SQUID,
        WOLF,
        MOOSHROOM,
        SNOWMAN,
        OCELOT,
        IRON_GOLEM,
        HORSE,
        VILLAGER
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnMobPacket() {
    }

    public ServerSpawnMobPacket(int i, Type type, double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
        this.type = type;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.headYaw = f3;
        this.motX = d4;
        this.motY = d5;
        this.motZ = d6;
        this.metadata = entityMetadataArr;
    }

    private static Type idToType(byte b2) throws IOException {
        if (b2 != 120) {
            switch (b2) {
                case 50:
                    return Type.CREEPER;
                case 51:
                    return Type.SKELETON;
                case 52:
                    return Type.SPIDER;
                case 53:
                    return Type.GIANT_ZOMBIE;
                case 54:
                    return Type.ZOMBIE;
                case 55:
                    return Type.SLIME;
                case 56:
                    return Type.GHAST;
                case 57:
                    return Type.ZOMBIE_PIGMAN;
                case 58:
                    return Type.ENDERMAN;
                case 59:
                    return Type.CAVE_SPIDER;
                case 60:
                    return Type.SILVERFISH;
                case 61:
                    return Type.BLAZE;
                case 62:
                    return Type.MAGMA_CUBE;
                case 63:
                    return Type.ENDER_DRAGON;
                case 64:
                    return Type.WITHER;
                case 65:
                    return Type.BAT;
                case 66:
                    return Type.WITCH;
                default:
                    switch (b2) {
                        case 90:
                            return Type.PIG;
                        case 91:
                            return Type.SHEEP;
                        case 92:
                            return Type.COW;
                        case 93:
                            return Type.CHICKEN;
                        case 94:
                            return Type.SQUID;
                        case 95:
                            return Type.WOLF;
                        case 96:
                            return Type.MOOSHROOM;
                        case 97:
                            return Type.SNOWMAN;
                        case 98:
                            return Type.OCELOT;
                        case 99:
                            return Type.IRON_GOLEM;
                        case 100:
                            return Type.HORSE;
                        default:
                            throw new IOException("Unknown mob type id: " + ((int) b2));
                    }
            }
        }
        return Type.VILLAGER;
    }

    private static byte typeToId(Type type) throws IOException {
        switch (type) {
            case CREEPER:
                return (byte) 50;
            case SKELETON:
                return (byte) 51;
            case SPIDER:
                return Constants.MobIds.SPIDER;
            case GIANT_ZOMBIE:
                return Constants.MobIds.GIANT_ZOMBIE;
            case ZOMBIE:
                return Constants.MobIds.ZOMBIE;
            case SLIME:
                return Constants.MobIds.SLIME;
            case GHAST:
                return Constants.MobIds.GHAST;
            case ZOMBIE_PIGMAN:
                return Constants.MobIds.ZOMBIE_PIGMAN;
            case ENDERMAN:
                return Constants.MobIds.ENDERMAN;
            case CAVE_SPIDER:
                return Constants.MobIds.CAVE_SPIDER;
            case SILVERFISH:
                return (byte) 60;
            case BLAZE:
                return (byte) 61;
            case MAGMA_CUBE:
                return (byte) 62;
            case ENDER_DRAGON:
                return Constants.MobIds.ENDER_DRAGON;
            case WITHER:
                return Constants.MobIds.WITHER;
            case BAT:
                return (byte) 65;
            case WITCH:
                return (byte) 66;
            case PIG:
                return (byte) 90;
            case SHEEP:
                return Constants.MobIds.SHEEP;
            case COW:
                return Constants.MobIds.COW;
            case CHICKEN:
                return Constants.MobIds.CHICKEN;
            case SQUID:
                return Constants.MobIds.SQUID;
            case WOLF:
                return Constants.MobIds.WOLF;
            case MOOSHROOM:
                return Constants.MobIds.MOOSHROOM;
            case SNOWMAN:
                return Constants.MobIds.SNOWMAN;
            case OCELOT:
                return Constants.MobIds.OCELOT;
            case IRON_GOLEM:
                return Constants.MobIds.IRON_GOLEM;
            case HORSE:
                return (byte) 100;
            case VILLAGER:
                return Constants.MobIds.VILLAGER;
            default:
                throw new IOException("Unmapped mob type: " + type);
        }
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Type getType() {
        return this.type;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getHeadYaw() {
        return this.headYaw;
    }

    public double getMotionX() {
        return this.motX;
    }

    public double getMotionY() {
        return this.motY;
    }

    public double getMotionZ() {
        return this.motZ;
    }

    public EntityMetadata[] getMetadata() {
        return this.metadata;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.type = idToType(netInput.readByte());
        double d = netInput.readInt();
        Double.isNaN(d);
        this.x = d / 32.0d;
        double d2 = netInput.readInt();
        Double.isNaN(d2);
        this.y = d2 / 32.0d;
        double d3 = netInput.readInt();
        Double.isNaN(d3);
        this.z = d3 / 32.0d;
        this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.headYaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        double d4 = netInput.readShort();
        Double.isNaN(d4);
        this.motX = d4 / 8000.0d;
        double d5 = netInput.readShort();
        Double.isNaN(d5);
        this.motY = d5 / 8000.0d;
        double d6 = netInput.readShort();
        Double.isNaN(d6);
        this.motZ = d6 / 8000.0d;
        this.metadata = NetUtil.readEntityMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(typeToId(this.type));
        netOutput.writeInt((int) (this.x * 32.0d));
        netOutput.writeInt((int) (this.y * 32.0d));
        netOutput.writeInt((int) (this.z * 32.0d));
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.headYaw * 256.0f) / 360.0f));
        netOutput.writeShort((int) (this.motX * 8000.0d));
        netOutput.writeShort((int) (this.motY * 8000.0d));
        netOutput.writeShort((int) (this.motZ * 8000.0d));
        NetUtil.writeEntityMetadata(netOutput, this.metadata);
    }
}
