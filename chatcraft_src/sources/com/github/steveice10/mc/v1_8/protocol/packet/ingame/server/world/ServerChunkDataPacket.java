package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetworkChunkData;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.ParsedChunkData;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerChunkDataPacket implements Packet {
    private byte[] biomeData;
    private Chunk[] chunks;
    private int x;
    private int z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerChunkDataPacket() {
    }

    public ServerChunkDataPacket(int i, int i2) {
        this(i, i2, new Chunk[16], new byte[256]);
    }

    public ServerChunkDataPacket(int i, int i2, Chunk[] chunkArr) {
        this(i, i2, chunkArr, null);
    }

    public ServerChunkDataPacket(int i, int i2, Chunk[] chunkArr, byte[] bArr) {
        if (chunkArr.length != 16) {
            throw new IllegalArgumentException("Chunks length must be 16.");
        }
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < chunkArr.length; i3++) {
            if (chunkArr[i3] != null) {
                if (chunkArr[i3].getSkyLight() == null) {
                    z = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (z && z2) {
            throw new IllegalArgumentException("Either all chunks must have skylight values or none must have them.");
        }
        this.x = i;
        this.z = i2;
        this.chunks = chunkArr;
        this.biomeData = bArr;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public Chunk[] getChunks() {
        return this.chunks;
    }

    public byte[] getBiomeData() {
        return this.biomeData;
    }

    public boolean isFullChunk() {
        return this.biomeData != null;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.z = netInput.readInt();
        ParsedChunkData parsedChunkDataDataToChunks = NetUtil.dataToChunks(new NetworkChunkData(netInput.readUnsignedShort(), netInput.readBoolean(), false, netInput.readBytes(netInput.readVarInt())), true);
        this.chunks = parsedChunkDataDataToChunks.getChunks();
        this.biomeData = parsedChunkDataDataToChunks.getBiomes();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetworkChunkData networkChunkDataChunksToData = NetUtil.chunksToData(new ParsedChunkData(this.chunks, this.biomeData));
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.z);
        netOutput.writeBoolean(networkChunkDataChunksToData.isFullChunk());
        netOutput.writeShort(networkChunkDataChunksToData.getMask());
        netOutput.writeVarInt(networkChunkDataChunksToData.getData().length);
        netOutput.writeBytes(networkChunkDataChunksToData.getData(), networkChunkDataChunksToData.getData().length);
    }
}
