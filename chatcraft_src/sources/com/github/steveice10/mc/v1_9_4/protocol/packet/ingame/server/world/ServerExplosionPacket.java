package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.block.ExplodedBlockRecord;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ServerExplosionPacket implements Packet {
    private List<ExplodedBlockRecord> exploded;
    private float pushX;
    private float pushY;
    private float pushZ;
    private float radius;
    private float x;
    private float y;
    private float z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerExplosionPacket() {
    }

    public ServerExplosionPacket(float f, float f2, float f3, float f4, List<ExplodedBlockRecord> list, float f5, float f6, float f7) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.radius = f4;
        this.exploded = list;
        this.pushX = f5;
        this.pushY = f6;
        this.pushZ = f7;
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

    public float getRadius() {
        return this.radius;
    }

    public List<ExplodedBlockRecord> getExploded() {
        return this.exploded;
    }

    public float getPushX() {
        return this.pushX;
    }

    public float getPushY() {
        return this.pushY;
    }

    public float getPushZ() {
        return this.pushZ;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readFloat();
        this.y = netInput.readFloat();
        this.z = netInput.readFloat();
        this.radius = netInput.readFloat();
        this.exploded = new ArrayList();
        int i = netInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.exploded.add(new ExplodedBlockRecord(netInput.readByte(), netInput.readByte(), netInput.readByte()));
        }
        this.pushX = netInput.readFloat();
        this.pushY = netInput.readFloat();
        this.pushZ = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.x);
        netOutput.writeFloat(this.y);
        netOutput.writeFloat(this.z);
        netOutput.writeFloat(this.radius);
        netOutput.writeInt(this.exploded.size());
        for (ExplodedBlockRecord explodedBlockRecord : this.exploded) {
            netOutput.writeByte(explodedBlockRecord.getX());
            netOutput.writeByte(explodedBlockRecord.getY());
            netOutput.writeByte(explodedBlockRecord.getZ());
        }
        netOutput.writeFloat(this.pushX);
        netOutput.writeFloat(this.pushY);
        netOutput.writeFloat(this.pushZ);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
