package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_8.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.MobType;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
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
    private MobType type;
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

    public ServerSpawnMobPacket(int i, MobType mobType, double d, double d2, double d3, float f, float f2, float f3, double d4, double d5, double d6, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
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
        this.type = (MobType) MagicValues.key(MobType.class, Byte.valueOf(netInput.readByte()));
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
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
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
