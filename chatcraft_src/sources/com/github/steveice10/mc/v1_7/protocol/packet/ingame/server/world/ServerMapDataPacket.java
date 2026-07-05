package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ServerMapDataPacket implements Packet {
    private MapData data;
    private int mapId;
    private Type type;

    public interface MapData {
    }

    public enum Type {
        IMAGE,
        PLAYERS,
        SCALE
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerMapDataPacket() {
    }

    public ServerMapDataPacket(int i, Type type, MapData mapData) {
        this.mapId = i;
        this.type = type;
        this.data = mapData;
    }

    public int getMapId() {
        return this.mapId;
    }

    public Type getType() {
        return this.type;
    }

    public MapData getData() {
        return this.data;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.mapId = netInput.readVarInt();
        byte[] bytes = netInput.readBytes(netInput.readShort());
        int i = 0;
        this.type = Type.values()[bytes[0]];
        switch (this.type) {
            case IMAGE:
                int i2 = bytes[1] & Constants.DimensionIds.NETHER;
                int i3 = bytes[2] & Constants.DimensionIds.NETHER;
                int length = bytes.length - 3;
                byte[] bArr = new byte[length];
                while (i < length) {
                    bArr[i] = bytes[i + 3];
                    i++;
                }
                this.data = new MapColumnUpdate(i2, i3, length, bArr);
                break;
            case PLAYERS:
                ArrayList arrayList = new ArrayList();
                while (i < (bytes.length - 1) / 3) {
                    int i4 = i * 3;
                    int i5 = bytes[i4 + 1] & Constants.DimensionIds.NETHER;
                    arrayList.add(new MapPlayer((i5 >> 4) & 255, i5 & 15 & 255, bytes[i4 + 2] & Constants.DimensionIds.NETHER, bytes[i4 + 3] & Constants.DimensionIds.NETHER));
                    i++;
                }
                this.data = new MapPlayers(arrayList);
                break;
            case SCALE:
                this.data = new MapScale(bytes[1] & Constants.DimensionIds.NETHER);
                break;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        byte[] bArr;
        netOutput.writeVarInt(this.mapId);
        switch (this.type) {
            case IMAGE:
                MapColumnUpdate mapColumnUpdate = (MapColumnUpdate) this.data;
                byte[] bArr2 = new byte[mapColumnUpdate.getHeight() + 3];
                bArr2[0] = 0;
                bArr2[1] = (byte) mapColumnUpdate.getX();
                bArr2[2] = (byte) mapColumnUpdate.getY();
                for (int i = 3; i < bArr2.length; i++) {
                    bArr2[i] = mapColumnUpdate.getColors()[i - 3];
                }
                bArr = bArr2;
                break;
            case PLAYERS:
                MapPlayers mapPlayers = (MapPlayers) this.data;
                byte[] bArr3 = new byte[(mapPlayers.getPlayers().size() * 3) + 1];
                bArr3[0] = 1;
                for (int i2 = 0; i2 < mapPlayers.getPlayers().size(); i2++) {
                    MapPlayer mapPlayer = mapPlayers.getPlayers().get(i2);
                    int i3 = i2 * 3;
                    bArr3[i3 + 1] = (byte) ((((byte) mapPlayer.getIconSize()) << 4) | (((byte) mapPlayer.getIconRotation()) & 15));
                    bArr3[i3 + 2] = (byte) mapPlayer.getCenterX();
                    bArr3[i3 + 3] = (byte) mapPlayer.getCenterZ();
                }
                bArr = bArr3;
                break;
            case SCALE:
                bArr = new byte[]{2, (byte) ((MapScale) this.data).getScale()};
                break;
            default:
                bArr = null;
                break;
        }
        netOutput.writeShort(bArr.length);
        netOutput.writeBytes(bArr);
    }

    public static class MapColumnUpdate implements MapData {
        private byte[] colors;
        private int height;
        private int x;
        private int y;

        public MapColumnUpdate(int i, int i2, int i3, byte[] bArr) {
            this.x = i;
            this.y = i2;
            this.height = i3;
            this.colors = bArr;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getHeight() {
            return this.height;
        }

        public byte[] getColors() {
            return this.colors;
        }
    }

    public static class MapPlayers implements MapData {
        private List<MapPlayer> players;

        public MapPlayers(List<MapPlayer> list) {
            this.players = new ArrayList();
            this.players = list;
        }

        public List<MapPlayer> getPlayers() {
            return new ArrayList(this.players);
        }
    }

    public static class MapPlayer {
        private int centerX;
        private int centerZ;
        private int iconRotation;
        private int iconSize;

        public MapPlayer(int i, int i2, int i3, int i4) {
            this.iconSize = i;
            this.iconRotation = i2;
            this.centerX = i3;
            this.centerZ = i4;
        }

        public int getIconSize() {
            return this.iconSize;
        }

        public int getIconRotation() {
            return this.iconRotation;
        }

        public int getCenterX() {
            return this.centerX;
        }

        public int getCenterZ() {
            return this.centerZ;
        }
    }

    public static class MapScale implements MapData {
        private int scale;

        public MapScale(int i) {
            this.scale = i;
        }

        public int getScale() {
            return this.scale;
        }
    }
}
