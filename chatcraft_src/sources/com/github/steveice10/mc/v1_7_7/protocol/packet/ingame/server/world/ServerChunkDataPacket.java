package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_7_7.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_7_7.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_7_7.protocol.util.NetworkChunkData;
import com.github.steveice10.mc.v1_7_7.protocol.util.ParsedChunkData;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
        boolean z = netInput.readBoolean();
        short s = netInput.readShort();
        short s2 = netInput.readShort();
        byte[] bytes = netInput.readBytes(netInput.readInt());
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            i += (s >> i2) & 1;
        }
        int i3 = i * 12288;
        if (z) {
            i3 += 256;
        }
        byte[] bArr = new byte[i3];
        Inflater inflater = new Inflater();
        inflater.setInput(bytes, 0, bytes.length);
        try {
            try {
                inflater.inflate(bArr);
                inflater.end();
                ParsedChunkData parsedChunkDataDataToChunks = NetUtil.dataToChunks(new NetworkChunkData(s, s2, z, false, bArr));
                this.chunks = parsedChunkDataDataToChunks.getChunks();
                this.biomeData = parsedChunkDataDataToChunks.getBiomes();
            } catch (DataFormatException unused) {
                throw new IOException("Bad compressed data format");
            }
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetworkChunkData networkChunkDataChunksToData = NetUtil.chunksToData(new ParsedChunkData(this.chunks, this.biomeData));
        Deflater deflater = new Deflater(-1);
        byte[] bArr = new byte[networkChunkDataChunksToData.getData().length];
        int length = networkChunkDataChunksToData.getData().length;
        try {
            deflater.setInput(networkChunkDataChunksToData.getData(), 0, networkChunkDataChunksToData.getData().length);
            deflater.finish();
            int iDeflate = deflater.deflate(bArr);
            deflater.end();
            netOutput.writeInt(this.x);
            netOutput.writeInt(this.z);
            netOutput.writeBoolean(networkChunkDataChunksToData.isFullChunk());
            netOutput.writeShort(networkChunkDataChunksToData.getMask());
            netOutput.writeShort(networkChunkDataChunksToData.getExtendedMask());
            netOutput.writeInt(iDeflate);
            netOutput.writeBytes(bArr, iDeflate);
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }
}
