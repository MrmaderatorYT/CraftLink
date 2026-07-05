package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.FallingBlockData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.HangingDirection;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.MinecartType;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ObjectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ObjectType;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ProjectileData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.SplashPotionData;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnObjectPacket implements Packet {
    private ObjectData data;
    private int entityId;
    private double motX;
    private double motY;
    private double motZ;
    private float pitch;
    private ObjectType type;
    private double x;
    private double y;
    private float yaw;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnObjectPacket() {
    }

    public ServerSpawnObjectPacket(int i, ObjectType objectType, double d, double d2, double d3, float f, float f2) {
        this(i, objectType, null, d, d2, d3, f, f2, 0.0d, 0.0d, 0.0d);
    }

    public ServerSpawnObjectPacket(int i, ObjectType objectType, ObjectData objectData, double d, double d2, double d3, float f, float f2) {
        this(i, objectType, objectData, d, d2, d3, f, f2, 0.0d, 0.0d, 0.0d);
    }

    public ServerSpawnObjectPacket(int i, ObjectType objectType, double d, double d2, double d3, float f, float f2, double d4, double d5, double d6) {
        this(i, objectType, new ObjectData() { // from class: com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket.1
        }, d, d2, d3, f, f2, d4, d5, d6);
    }

    public ServerSpawnObjectPacket(int i, ObjectType objectType, ObjectData objectData, double d, double d2, double d3, float f, float f2, double d4, double d5, double d6) {
        this.entityId = i;
        this.type = objectType;
        this.data = objectData;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.motX = d4;
        this.motY = d5;
        this.motZ = d6;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public ObjectType getType() {
        return this.type;
    }

    public ObjectData getData() {
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
        this.type = (ObjectType) MagicValues.key(ObjectType.class, Byte.valueOf(netInput.readByte()));
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
        int i = netInput.readInt();
        if (i > 0) {
            if (this.type == ObjectType.MINECART) {
                this.data = (ObjectData) MagicValues.key(MinecartType.class, Integer.valueOf(i));
            } else if (this.type == ObjectType.ITEM_FRAME) {
                this.data = (ObjectData) MagicValues.key(HangingDirection.class, Integer.valueOf(i));
            } else if (this.type == ObjectType.FALLING_BLOCK) {
                this.data = new FallingBlockData(65535 & i, i >> 16);
            } else if (this.type == ObjectType.POTION) {
                this.data = new SplashPotionData(i);
            } else if (this.type == ObjectType.ARROW || this.type == ObjectType.BLAZE_FIREBALL || this.type == ObjectType.FISH_HOOK || this.type == ObjectType.GHAST_FIREBALL || this.type == ObjectType.WITHER_HEAD_PROJECTILE) {
                this.data = new ProjectileData(i);
            } else {
                this.data = new ObjectData() { // from class: com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket.2
                };
            }
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
        int ownerId;
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        netOutput.writeInt((int) (this.x * 32.0d));
        netOutput.writeInt((int) (this.y * 32.0d));
        netOutput.writeInt((int) (this.z * 32.0d));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        if (this.data == null) {
            ownerId = 0;
        } else if ((this.data instanceof MinecartType) || (this.data instanceof HangingDirection)) {
            ownerId = ((Integer) MagicValues.value(Integer.class, (Enum) this.data)).intValue();
        } else if (this.data instanceof FallingBlockData) {
            ownerId = ((FallingBlockData) this.data).getId() | (((FallingBlockData) this.data).getMetadata() << 16);
        } else if (this.data instanceof SplashPotionData) {
            ownerId = ((SplashPotionData) this.data).getPotionData();
        } else {
            ownerId = this.data instanceof ProjectileData ? ((ProjectileData) this.data).getOwnerId() : 1;
        }
        netOutput.writeInt(ownerId);
        if (ownerId > 0) {
            netOutput.writeShort((int) (this.motX * 8000.0d));
            netOutput.writeShort((int) (this.motY * 8000.0d));
            netOutput.writeShort((int) (this.motZ * 8000.0d));
        }
    }
}
