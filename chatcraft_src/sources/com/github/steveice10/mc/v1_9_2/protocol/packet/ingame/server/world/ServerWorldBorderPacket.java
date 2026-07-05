package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.WorldBorderAction;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerWorldBorderPacket implements Packet {
    private WorldBorderAction action;
    private double centerX;
    private double centerY;
    private double newRadius;
    private double oldRadius;
    private int portalTeleportBoundary;
    private double radius;
    private long speed;
    private int warningBlocks;
    private int warningTime;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerWorldBorderPacket() {
    }

    public ServerWorldBorderPacket(double d) {
        this.action = WorldBorderAction.SET_SIZE;
        this.radius = d;
    }

    public ServerWorldBorderPacket(double d, double d2, long j) {
        this.action = WorldBorderAction.LERP_SIZE;
        this.oldRadius = d;
        this.newRadius = d2;
        this.speed = j;
    }

    public ServerWorldBorderPacket(double d, double d2) {
        this.action = WorldBorderAction.SET_CENTER;
        this.centerX = d;
        this.centerY = d2;
    }

    public ServerWorldBorderPacket(double d, double d2, double d3, double d4, long j, int i, int i2, int i3) {
        this.action = WorldBorderAction.INITIALIZE;
        this.centerX = d;
        this.centerY = d2;
        this.oldRadius = d3;
        this.newRadius = d4;
        this.speed = j;
        this.portalTeleportBoundary = i;
        this.warningTime = i2;
        this.warningBlocks = i3;
    }

    public ServerWorldBorderPacket(int i, boolean z) {
        if (z) {
            this.action = WorldBorderAction.SET_WARNING_TIME;
            this.warningTime = i;
        } else {
            this.action = WorldBorderAction.SET_WARNING_BLOCKS;
            this.warningBlocks = i;
        }
    }

    public WorldBorderAction getAction() {
        return this.action;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getOldRadius() {
        return this.oldRadius;
    }

    public double getNewRadius() {
        return this.newRadius;
    }

    public long getSpeed() {
        return this.speed;
    }

    public double getCenterX() {
        return this.centerX;
    }

    public double getCenterY() {
        return this.centerY;
    }

    public int getPortalTeleportBoundary() {
        return this.portalTeleportBoundary;
    }

    public int getWarningTime() {
        return this.warningTime;
    }

    public int getWarningBlocks() {
        return this.warningBlocks;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.action = (WorldBorderAction) MagicValues.key(WorldBorderAction.class, Integer.valueOf(netInput.readVarInt()));
        if (this.action == WorldBorderAction.SET_SIZE) {
            this.radius = netInput.readDouble();
            return;
        }
        if (this.action == WorldBorderAction.LERP_SIZE) {
            this.oldRadius = netInput.readDouble();
            this.newRadius = netInput.readDouble();
            this.speed = netInput.readVarLong();
            return;
        }
        if (this.action == WorldBorderAction.SET_CENTER) {
            this.centerX = netInput.readDouble();
            this.centerY = netInput.readDouble();
            return;
        }
        if (this.action == WorldBorderAction.INITIALIZE) {
            this.centerX = netInput.readDouble();
            this.centerY = netInput.readDouble();
            this.oldRadius = netInput.readDouble();
            this.newRadius = netInput.readDouble();
            this.speed = netInput.readVarLong();
            this.portalTeleportBoundary = netInput.readVarInt();
            this.warningTime = netInput.readVarInt();
            this.warningBlocks = netInput.readVarInt();
            return;
        }
        if (this.action == WorldBorderAction.SET_WARNING_TIME) {
            this.warningTime = netInput.readVarInt();
        } else if (this.action == WorldBorderAction.SET_WARNING_BLOCKS) {
            this.warningBlocks = netInput.readVarInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        if (this.action == WorldBorderAction.SET_SIZE) {
            netOutput.writeDouble(this.radius);
            return;
        }
        if (this.action == WorldBorderAction.LERP_SIZE) {
            netOutput.writeDouble(this.oldRadius);
            netOutput.writeDouble(this.newRadius);
            netOutput.writeVarLong(this.speed);
            return;
        }
        if (this.action == WorldBorderAction.SET_CENTER) {
            netOutput.writeDouble(this.centerX);
            netOutput.writeDouble(this.centerY);
            return;
        }
        if (this.action == WorldBorderAction.INITIALIZE) {
            netOutput.writeDouble(this.centerX);
            netOutput.writeDouble(this.centerY);
            netOutput.writeDouble(this.oldRadius);
            netOutput.writeDouble(this.newRadius);
            netOutput.writeVarLong(this.speed);
            netOutput.writeVarInt(this.portalTeleportBoundary);
            netOutput.writeVarInt(this.warningTime);
            netOutput.writeVarInt(this.warningBlocks);
            return;
        }
        if (this.action == WorldBorderAction.SET_WARNING_TIME) {
            netOutput.writeVarInt(this.warningTime);
        } else if (this.action == WorldBorderAction.SET_WARNING_BLOCKS) {
            netOutput.writeVarInt(this.warningBlocks);
        }
    }
}
