package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.map.MapData;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.map.MapIcon;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.map.MapIconType;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerMapDataPacket implements Packet {
    private MapData data;
    private MapIcon[] icons;
    private int mapId;
    private byte scale;
    private boolean trackingPosition;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerMapDataPacket() {
    }

    public ServerMapDataPacket(int i, byte b2, boolean z, MapIcon[] mapIconArr) {
        this(i, b2, z, mapIconArr, null);
    }

    public ServerMapDataPacket(int i, byte b2, boolean z, MapIcon[] mapIconArr, MapData mapData) {
        this.mapId = i;
        this.scale = b2;
        this.trackingPosition = z;
        this.icons = mapIconArr;
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

    public MapIcon[] getIcons() {
        return this.icons;
    }

    public MapData getData() {
        return this.data;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.mapId = netInput.readVarInt();
        this.scale = netInput.readByte();
        this.trackingPosition = netInput.readBoolean();
        this.icons = new MapIcon[netInput.readVarInt()];
        for (int i = 0; i < this.icons.length; i++) {
            int unsignedByte = netInput.readUnsignedByte();
            int unsignedByte2 = netInput.readUnsignedByte();
            int unsignedByte3 = netInput.readUnsignedByte();
            this.icons[i] = new MapIcon(unsignedByte2, unsignedByte3, (MapIconType) MagicValues.value(MapIconType.class, Integer.valueOf((unsignedByte >> 4) & 15)), unsignedByte & 15);
        }
        int unsignedByte4 = netInput.readUnsignedByte();
        if (unsignedByte4 > 0) {
            this.data = new MapData(unsignedByte4, netInput.readUnsignedByte(), netInput.readUnsignedByte(), netInput.readUnsignedByte(), netInput.readBytes(netInput.readVarInt()));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.mapId);
        netOutput.writeByte(this.scale);
        netOutput.writeBoolean(this.trackingPosition);
        netOutput.writeVarInt(this.icons.length);
        for (int i = 0; i < this.icons.length; i++) {
            MapIcon mapIcon = this.icons[i];
            netOutput.writeByte(((((Integer) MagicValues.key(Integer.class, mapIcon.getIconType())).intValue() & 15) << 4) | (mapIcon.getIconRotation() & 15));
            netOutput.writeByte(mapIcon.getCenterX());
            netOutput.writeByte(mapIcon.getCenterZ());
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

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
