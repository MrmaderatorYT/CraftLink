package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.map.MapData;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.map.MapPlayer;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerMapDataPacket implements Packet {
    private MapData data;
    private int mapId;
    private MapPlayer[] players;
    private byte scale;
    private boolean trackingPosition;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerMapDataPacket() {
    }

    public ServerMapDataPacket(int i, byte b2, boolean z, MapPlayer[] mapPlayerArr) {
        this(i, b2, z, mapPlayerArr, null);
    }

    public ServerMapDataPacket(int i, byte b2, boolean z, MapPlayer[] mapPlayerArr, MapData mapData) {
        this.mapId = i;
        this.scale = b2;
        this.trackingPosition = z;
        this.players = mapPlayerArr;
        this.data = mapData;
    }

    public int getMapId() {
        return this.mapId;
    }

    public byte getScale() {
        return this.scale;
    }

    public boolean getTrackingPosition() {
        return this.trackingPosition;
    }

    public MapPlayer[] getPlayers() {
        return this.players;
    }

    public MapData getData() {
        return this.data;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.mapId = netInput.readVarInt();
        this.scale = netInput.readByte();
        this.trackingPosition = netInput.readBoolean();
        this.players = new MapPlayer[netInput.readVarInt()];
        for (int i = 0; i < this.players.length; i++) {
            int unsignedByte = netInput.readUnsignedByte();
            this.players[i] = new MapPlayer(netInput.readUnsignedByte(), netInput.readUnsignedByte(), (unsignedByte >> 4) & 15, unsignedByte & 15);
        }
        int unsignedByte2 = netInput.readUnsignedByte();
        if (unsignedByte2 > 0) {
            this.data = new MapData(unsignedByte2, netInput.readUnsignedByte(), netInput.readUnsignedByte(), netInput.readUnsignedByte(), netInput.readBytes(netInput.readVarInt()));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.mapId);
        netOutput.writeByte(this.scale);
        netOutput.writeBoolean(this.trackingPosition);
        netOutput.writeVarInt(this.players.length);
        for (int i = 0; i < this.players.length; i++) {
            MapPlayer mapPlayer = this.players[i];
            netOutput.writeByte(((mapPlayer.getIconSize() & 15) << 4) | (mapPlayer.getIconRotation() & 15));
            netOutput.writeByte(mapPlayer.getCenterX());
            netOutput.writeByte(mapPlayer.getCenterZ());
        }
        if (this.data != null && this.data.getColumns() != 0) {
            netOutput.writeByte(this.data.getColumns());
            netOutput.writeByte(this.data.getRows());
            netOutput.writeByte(this.data.getX());
            netOutput.writeByte(this.data.getY());
            netOutput.writeVarInt(this.data.getData().length);
            netOutput.writeBytes(this.data.getData());
            return;
        }
        netOutput.writeByte(0);
    }
}
