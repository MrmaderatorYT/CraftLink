package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.EntityMetadata;
import com.github.steveice10.mc.v1_9_2.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerSpawnPlayerPacket implements Packet {
    private int entityId;
    private EntityMetadata[] metadata;
    private float pitch;
    private UUID uuid;
    private double x;
    private double y;
    private float yaw;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnPlayerPacket() {
    }

    public ServerSpawnPlayerPacket(int i, UUID uuid, double d, double d2, double d3, float f, float f2, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
        this.uuid = uuid;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.metadata = entityMetadataArr;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public UUID getUUID() {
        return this.uuid;
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

    public EntityMetadata[] getMetadata() {
        return this.metadata;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.uuid = netInput.readUUID();
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        this.metadata = NetUtil.readEntityMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeUUID(this.uuid);
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        NetUtil.writeEntityMetadata(netOutput, this.metadata);
    }
}
