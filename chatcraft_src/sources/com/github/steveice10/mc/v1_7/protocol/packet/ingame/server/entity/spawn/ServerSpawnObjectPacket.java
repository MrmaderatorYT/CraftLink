package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerSpawnObjectPacket implements Packet {
    private int data;
    private int entityId;
    private double motX;
    private double motY;
    private double motZ;
    private float pitch;
    private Type type;
    private double x;
    private double y;
    private float yaw;
    private double z;

    public static class ItemFrameDirection {
        public static final int EAST = 3;
        public static final int NORTH = 2;
        public static final int SOUTH = 0;
        public static final int WEST = 1;
    }

    public static class MinecartType {
        public static final int CHEST = 1;
        public static final int COMMAND_BLOCK = 6;
        public static final int HOPPER = 5;
        public static final int MOB_SPAWNER = 4;
        public static final int NORMAL = 0;
        public static final int POWERED = 2;
        public static final int TNT = 3;
    }

    public enum Type {
        BOAT,
        ITEM,
        MINECART,
        PRIMED_TNT,
        ENDER_CRYSTAL,
        ARROW,
        SNOWBALL,
        EGG,
        GHAST_FIREBALL,
        BLAZE_FIREBALL,
        ENDER_PEARL,
        WITHER_HEAD_PROJECTILE,
        FALLING_BLOCK,
        ITEM_FRAME,
        EYE_OF_ENDER,
        POTION,
        EXP_BOTTLE,
        FIREWORK_ROCKET,
        LEASH_KNOT,
        FISH_HOOK
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnObjectPacket() {
    }

    public ServerSpawnObjectPacket(int i, Type type, double d, double d2, double d3, float f, float f2) {
        this(i, type, 0, d, d2, d3, f, f2, 0.0d, 0.0d, 0.0d);
    }

    public ServerSpawnObjectPacket(int i, Type type, int i2, double d, double d2, double d3, float f, float f2, double d4, double d5, double d6) {
        this.entityId = i;
        this.type = type;
        this.data = i2;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.motX = d4;
        this.motY = d5;
        this.motZ = d6;
    }

    private static Type idToType(byte b2) throws IOException {
        if (b2 == 10) {
            return Type.MINECART;
        }
        if (b2 != 90) {
            switch (b2) {
                case 1:
                    return Type.BOAT;
                case 2:
                    return Type.ITEM;
                default:
                    switch (b2) {
                        case 50:
                            return Type.PRIMED_TNT;
                        case 51:
                            return Type.ENDER_CRYSTAL;
                        default:
                            switch (b2) {
                                case 60:
                                    return Type.ARROW;
                                case 61:
                                    return Type.SNOWBALL;
                                case 62:
                                    return Type.EGG;
                                case 63:
                                    return Type.GHAST_FIREBALL;
                                case 64:
                                    return Type.BLAZE_FIREBALL;
                                case 65:
                                    return Type.ENDER_PEARL;
                                case 66:
                                    return Type.WITHER_HEAD_PROJECTILE;
                                default:
                                    switch (b2) {
                                        case 70:
                                            return Type.FALLING_BLOCK;
                                        case 71:
                                            return Type.ITEM_FRAME;
                                        case 72:
                                            return Type.EYE_OF_ENDER;
                                        case 73:
                                            return Type.POTION;
                                        default:
                                            switch (b2) {
                                                case 75:
                                                    return Type.EXP_BOTTLE;
                                                case 76:
                                                    return Type.FIREWORK_ROCKET;
                                                case 77:
                                                    return Type.LEASH_KNOT;
                                                default:
                                                    throw new IOException("Unknown object type id: " + ((int) b2));
                                            }
                                    }
                            }
                    }
            }
        }
        return Type.FISH_HOOK;
    }

    private static byte typeToId(Type type) throws IOException {
        switch (type) {
            case BOAT:
                return (byte) 1;
            case ITEM:
                return (byte) 2;
            case MINECART:
                return (byte) 10;
            case PRIMED_TNT:
                return (byte) 50;
            case ENDER_CRYSTAL:
                return (byte) 51;
            case ARROW:
                return (byte) 60;
            case SNOWBALL:
                return (byte) 61;
            case EGG:
                return (byte) 62;
            case GHAST_FIREBALL:
                return Constants.MobIds.ENDER_DRAGON;
            case BLAZE_FIREBALL:
                return Constants.MobIds.WITHER;
            case ENDER_PEARL:
                return (byte) 65;
            case WITHER_HEAD_PROJECTILE:
                return (byte) 66;
            case FALLING_BLOCK:
                return Constants.ObjectIds.FALLING_OBJECT;
            case ITEM_FRAME:
                return Constants.ObjectIds.ITEM_FRAME;
            case EYE_OF_ENDER:
                return Constants.ObjectIds.EYE_OF_ENDER;
            case POTION:
                return Constants.ObjectIds.THROWN_POTION;
            case EXP_BOTTLE:
                return Constants.ObjectIds.XP_BOTTLE;
            case FIREWORK_ROCKET:
                return (byte) 76;
            case LEASH_KNOT:
                return (byte) 77;
            case FISH_HOOK:
                return (byte) 90;
            default:
                throw new IOException("Unmapped object type: " + type);
        }
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Type getType() {
        return this.type;
    }

    public int getData() {
        return this.data;
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

    public double getMotionX() {
        return this.motX;
    }

    public double getMotionY() {
        return this.motY;
    }

    public double getMotionZ() {
        return this.motZ;
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
        this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.data = netInput.readInt();
        if (this.data > 0) {
            double d4 = netInput.readShort();
            Double.isNaN(d4);
            this.motX = d4 / 8000.0d;
            double d5 = netInput.readShort();
            Double.isNaN(d5);
            this.motY = d5 / 8000.0d;
            double d6 = netInput.readShort();
            Double.isNaN(d6);
            this.motZ = d6 / 8000.0d;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(typeToId(this.type));
        netOutput.writeInt((int) (this.x * 32.0d));
        netOutput.writeInt((int) (this.y * 32.0d));
        netOutput.writeInt((int) (this.z * 32.0d));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        netOutput.writeInt(this.data);
        if (this.data > 0) {
            netOutput.writeShort((int) (this.motX * 8000.0d));
            netOutput.writeShort((int) (this.motY * 8000.0d));
            netOutput.writeShort((int) (this.motZ * 8000.0d));
        }
    }

    public static class FallingBlockData {
        public static final int BLOCK_TYPE_TO_DATA(int i, int i2) {
            return i | (i2 << 16);
        }

        public static final int BLOCK_TYPE_TO_DATA(FallingBlockType fallingBlockType) {
            return BLOCK_TYPE_TO_DATA(fallingBlockType.getId(), fallingBlockType.getMetadata());
        }

        public static final FallingBlockType DATA_TO_BLOCK_TYPE(int i) {
            return new FallingBlockType(65535 & i, i >> 16);
        }
    }

    public static class FallingBlockType {
        private int id;
        private int metadata;

        public FallingBlockType(int i, int i2) {
            this.id = i;
            this.metadata = i2;
        }

        public int getId() {
            return this.id;
        }

        public int getMetadata() {
            return this.metadata;
        }
    }
}
