package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.Particle;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnParticlePacket implements Packet {
    private int amount;
    private int[] data;
    private boolean longDistance;
    private float offsetX;
    private float offsetY;
    private float offsetZ;
    private Particle particle;
    private float velocityOffset;
    private float x;
    private float y;
    private float z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnParticlePacket() {
    }

    public ServerSpawnParticlePacket(Particle particle, boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int... iArr) {
        this.particle = particle;
        this.longDistance = z;
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.offsetX = f4;
        this.offsetY = f5;
        this.offsetZ = f6;
        this.velocityOffset = f7;
        this.amount = i;
        this.data = iArr;
        if (this.data.length != particle.getDataLength()) {
            throw new IllegalArgumentException("Data array length must be equal to particle's data length.");
        }
    }

    public Particle getParticle() {
        return this.particle;
    }

    public boolean isLongDistance() {
        return this.longDistance;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getOffsetZ() {
        return this.offsetZ;
    }

    public float getVelocityOffset() {
        return this.velocityOffset;
    }

    public int getAmount() {
        return this.amount;
    }

    public int[] getData() {
        return this.data;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.particle = (Particle) MagicValues.key(Particle.class, Integer.valueOf(netInput.readInt()));
        this.longDistance = netInput.readBoolean();
        this.x = netInput.readFloat();
        this.y = netInput.readFloat();
        this.z = netInput.readFloat();
        this.offsetX = netInput.readFloat();
        this.offsetY = netInput.readFloat();
        this.offsetZ = netInput.readFloat();
        this.velocityOffset = netInput.readFloat();
        this.amount = netInput.readInt();
        this.data = new int[this.particle.getDataLength()];
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = netInput.readVarInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(((Integer) MagicValues.value(Integer.class, this.particle)).intValue());
        netOutput.writeBoolean(this.longDistance);
        netOutput.writeFloat(this.x);
        netOutput.writeFloat(this.y);
        netOutput.writeFloat(this.z);
        netOutput.writeFloat(this.offsetX);
        netOutput.writeFloat(this.offsetY);
        netOutput.writeFloat(this.offsetZ);
        netOutput.writeFloat(this.velocityOffset);
        netOutput.writeInt(this.amount);
        for (int i = 0; i < this.particle.getDataLength(); i++) {
            netOutput.writeVarInt(this.data[i]);
        }
    }
}
