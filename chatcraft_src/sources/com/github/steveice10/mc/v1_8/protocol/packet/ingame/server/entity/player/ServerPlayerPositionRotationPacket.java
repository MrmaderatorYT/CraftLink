package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.player;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.PositionElement;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ServerPlayerPositionRotationPacket implements Packet {
    private float pitch;
    private List<PositionElement> relative;
    private double x;
    private double y;
    private float yaw;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerPositionRotationPacket() {
    }

    public ServerPlayerPositionRotationPacket(double d, double d2, double d3, float f, float f2) {
        this(d, d2, d3, f, f2, new PositionElement[0]);
    }

    public ServerPlayerPositionRotationPacket(double d, double d2, double d3, float f, float f2, PositionElement... positionElementArr) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.relative = Arrays.asList(positionElementArr);
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

    public List<PositionElement> getRelativeElements() {
        return this.relative;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = netInput.readFloat();
        this.pitch = netInput.readFloat();
        this.relative = new ArrayList();
        int unsignedByte = netInput.readUnsignedByte();
        for (PositionElement positionElement : PositionElement.values()) {
            int iIntValue = 1 << ((Integer) MagicValues.value(Integer.class, positionElement)).intValue();
            if ((unsignedByte & iIntValue) == iIntValue) {
                this.relative.add(positionElement);
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeFloat(this.yaw);
        netOutput.writeFloat(this.pitch);
        Iterator<PositionElement> it = this.relative.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= 1 << ((Integer) MagicValues.value(Integer.class, it.next())).intValue();
        }
        netOutput.writeByte(iIntValue);
    }
}
