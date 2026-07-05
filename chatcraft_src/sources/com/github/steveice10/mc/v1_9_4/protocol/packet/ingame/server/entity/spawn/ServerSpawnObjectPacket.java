package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.FallingBlockData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.HangingDirection;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.MinecartType;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.ObjectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.ObjectType;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.ProjectileData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.object.SplashPotionData;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerSpawnObjectPacket implements Packet {
    private ObjectData data;
    private int entityId;
    private double motX;
    private double motY;
    private double motZ;
    private float pitch;
    private ObjectType type;
    private UUID uuid;
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

    public ServerSpawnObjectPacket(int i, UUID uuid, ObjectType objectType, double d, double d2, double d3, float f, float f2) {
        this(i, uuid, objectType, null, d, d2, d3, f, f2, 0.0d, 0.0d, 0.0d);
    }

    public ServerSpawnObjectPacket(int i, UUID uuid, ObjectType objectType, ObjectData objectData, double d, double d2, double d3, float f, float f2) {
        this(i, uuid, objectType, objectData, d, d2, d3, f, f2, 0.0d, 0.0d, 0.0d);
    }

    public ServerSpawnObjectPacket(int i, UUID uuid, ObjectType objectType, double d, double d2, double d3, float f, float f2, double d4, double d5, double d6) {
        this(i, uuid, objectType, new ObjectData() { // from class: com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket.1
        }, d, d2, d3, f, f2, d4, d5, d6);
    }

    public ServerSpawnObjectPacket(int i, UUID uuid, ObjectType objectType, ObjectData objectData, double d, double d2, double d3, float f, float f2, double d4, double d5, double d6) {
        this.entityId = i;
        this.uuid = uuid;
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

    public UUID getUUID() {
        return this.uuid;
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
        this.uuid = netInput.readUUID();
        this.type = (ObjectType) MagicValues.key(ObjectType.class, Byte.valueOf(netInput.readByte()));
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
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
            } else if (this.type == ObjectType.ARROW || this.type == ObjectType.SPECTRAL_ARROW || this.type == ObjectType.TIPPED_ARROW || this.type == ObjectType.GHAST_FIREBALL || this.type == ObjectType.BLAZE_FIREBALL || this.type == ObjectType.DRAGON_FIREBALL || this.type == ObjectType.WITHER_HEAD_PROJECTILE || this.type == ObjectType.FISH_HOOK) {
                this.data = new ProjectileData(i);
            } else {
                this.data = new ObjectData() { // from class: com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket.2
                };
            }
        }
        double d = netInput.readShort();
        Double.isNaN(d);
        this.motX = d / 8000.0d;
        double d2 = netInput.readShort();
        Double.isNaN(d2);
        this.motY = d2 / 8000.0d;
        double d3 = netInput.readShort();
        Double.isNaN(d3);
        this.motZ = d3 / 8000.0d;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int ownerId;
        netOutput.writeVarInt(this.entityId);
        netOutput.writeUUID(this.uuid);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
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
        netOutput.writeShort((int) (this.motX * 8000.0d));
        netOutput.writeShort((int) (this.motY * 8000.0d));
        netOutput.writeShort((int) (this.motZ * 8000.0d));
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
