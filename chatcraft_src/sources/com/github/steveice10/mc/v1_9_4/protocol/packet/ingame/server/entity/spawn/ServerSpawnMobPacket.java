package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.EntityMetadata;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.type.MobType;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerSpawnMobPacket implements Packet {
    private int entityId;
    private float headYaw;
    private EntityMetadata[] metadata;
    private double motX;
    private double motY;
    private double motZ;
    private float pitch;
    private MobType type;
    private UUID uuid;
    private double x;
    private double y;
    private float yaw;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnMobPacket() {
    }

    public ServerSpawnMobPacket(int i, UUID uuid, MobType mobType, double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
        this.uuid = uuid;
        this.type = mobType;
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

    public int getEntityId() {
        return this.entityId;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public MobType getType() {
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
        this.uuid = netInput.readUUID();
        this.type = (MobType) MagicValues.key(MobType.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.headYaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        double d = netInput.readShort();
        Double.isNaN(d);
        this.motX = d / 8000.0d;
        double d2 = netInput.readShort();
        Double.isNaN(d2);
        this.motY = d2 / 8000.0d;
        double d3 = netInput.readShort();
        Double.isNaN(d3);
        this.motZ = d3 / 8000.0d;
        this.metadata = NetUtil.readEntityMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeUUID(this.uuid);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.headYaw * 256.0f) / 360.0f));
        netOutput.writeShort((int) (this.motX * 8000.0d));
        netOutput.writeShort((int) (this.motY * 8000.0d));
        netOutput.writeShort((int) (this.motZ * 8000.0d));
        NetUtil.writeEntityMetadata(netOutput, this.metadata);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
