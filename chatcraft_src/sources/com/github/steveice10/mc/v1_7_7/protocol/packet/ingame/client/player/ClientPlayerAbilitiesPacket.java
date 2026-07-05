package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerAbilitiesPacket implements Packet {
    private boolean canFly;
    private boolean creative;
    private float flySpeed;
    private boolean flying;
    private boolean invincible;
    private float walkSpeed;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerAbilitiesPacket() {
    }

    public ClientPlayerAbilitiesPacket(boolean z, boolean z2, boolean z3, boolean z4, float f, float f2) {
        this.invincible = z;
        this.canFly = z2;
        this.flying = z3;
        this.creative = z4;
        this.flySpeed = f;
        this.walkSpeed = f2;
    }

    public boolean getInvincible() {
        return this.invincible;
    }

    public boolean getCanFly() {
        return this.canFly;
    }

    public boolean getFlying() {
        return this.flying;
    }

    public boolean getCreative() {
        return this.creative;
    }

    public float getFlySpeed() {
        return this.flySpeed;
    }

    public float getWalkSpeed() {
        return this.walkSpeed;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        byte b2 = netInput.readByte();
        this.invincible = (b2 & 1) > 0;
        this.canFly = (b2 & 2) > 0;
        this.flying = (b2 & 4) > 0;
        this.creative = (b2 & 8) > 0;
        this.flySpeed = netInput.readFloat();
        this.walkSpeed = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        byte b2 = this.invincible ? (byte) 1 : (byte) 0;
        if (this.canFly) {
            b2 = (byte) (b2 | 2);
        }
        if (this.flying) {
            b2 = (byte) (b2 | 4);
        }
        if (this.creative) {
            b2 = (byte) (b2 | 8);
        }
        netOutput.writeByte(b2);
        netOutput.writeFloat(this.flySpeed);
        netOutput.writeFloat(this.walkSpeed);
    }
}
