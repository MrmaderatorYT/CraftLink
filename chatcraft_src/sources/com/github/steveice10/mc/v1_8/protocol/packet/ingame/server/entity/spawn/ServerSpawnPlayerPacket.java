package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_8.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerSpawnPlayerPacket implements Packet {
    private int currentItem;
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

    public ServerSpawnPlayerPacket(int i, UUID uuid, double d, double d2, double d3, float f, float f2, int i2, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
        this.uuid = uuid;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.currentItem = i2;
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

    public int getCurrentItem() {
        return this.currentItem;
    }

    public EntityMetadata[] getMetadata() {
        return this.metadata;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.uuid = netInput.readUUID();
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
        this.currentItem = netInput.readShort();
        this.metadata = NetUtil.readEntityMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeUUID(this.uuid);
        netOutput.writeInt((int) (this.x * 32.0d));
        netOutput.writeInt((int) (this.y * 32.0d));
        netOutput.writeInt((int) (this.z * 32.0d));
        netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
        netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        netOutput.writeShort(this.currentItem);
        NetUtil.writeEntityMetadata(netOutput, this.metadata);
    }
}
