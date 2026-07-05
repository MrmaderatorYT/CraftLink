package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetworkChunkData;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.ParsedChunkData;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerMultiChunkDataPacket implements Packet {
    private byte[][] biomeData;
    private Chunk[][] chunks;
    private int[] x;
    private int[] z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerMultiChunkDataPacket() {
    }

    public ServerMultiChunkDataPacket(int[] iArr, int[] iArr2, Chunk[][] chunkArr, byte[][] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("BiomeData cannot be null.");
        }
        if (iArr.length != chunkArr.length || iArr2.length != chunkArr.length) {
            throw new IllegalArgumentException("X, Z, and Chunk arrays must be equal in length.");
        }
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < chunkArr.length) {
            Chunk[] chunkArr2 = chunkArr[i];
            if (chunkArr2.length != 16) {
                throw new IllegalArgumentException("Chunk columns must contain 16 chunks each.");
            }
            boolean z3 = z;
            for (int i2 = 0; i2 < chunkArr2.length; i2++) {
                if (chunkArr2[i2] != null) {
                    if (chunkArr2[i2].getSkyLight() == null) {
                        z3 = true;
                    } else {
                        z2 = true;
                    }
                }
            }
            i++;
            z = z3;
        }
        if (z && z2) {
            throw new IllegalArgumentException("Either all chunks must have skylight values or none must have them.");
        }
        this.x = iArr;
        this.z = iArr2;
        this.chunks = chunkArr;
        this.biomeData = bArr;
    }

    public int getColumns() {
        return this.chunks.length;
    }

    public int getX(int i) {
        return this.x[i];
    }

    public int getZ(int i) {
        return this.z[i];
    }

    public Chunk[] getChunks(int i) {
        return this.chunks[i];
    }

    public byte[] getBiomeData(int i) {
        return this.biomeData[i];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        boolean z = netInput.readBoolean();
        int varInt = netInput.readVarInt();
        this.x = new int[varInt];
        this.z = new int[varInt];
        this.chunks = new Chunk[varInt][];
        this.biomeData = new byte[varInt][];
        NetworkChunkData[] networkChunkDataArr = new NetworkChunkData[varInt];
        for (int i = 0; i < varInt; i++) {
            this.x[i] = netInput.readInt();
            this.z[i] = netInput.readInt();
            int unsignedShort = netInput.readUnsignedShort();
            int iBitCount = Integer.bitCount(unsignedShort);
            networkChunkDataArr[i] = new NetworkChunkData(unsignedShort, true, z, new byte[(iBitCount * 10240) + (z ? iBitCount * 2048 : 0) + 256]);
        }
        for (int i2 = 0; i2 < varInt; i2++) {
            netInput.readBytes(networkChunkDataArr[i2].getData());
            ParsedChunkData parsedChunkDataDataToChunks = NetUtil.dataToChunks(networkChunkDataArr[i2], false);
            this.chunks[i2] = parsedChunkDataDataToChunks.getChunks();
            this.biomeData[i2] = parsedChunkDataDataToChunks.getBiomes();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetworkChunkData[] networkChunkDataArr = new NetworkChunkData[this.chunks.length];
        boolean z = false;
        for (int i = 0; i < this.chunks.length; i++) {
            networkChunkDataArr[i] = NetUtil.chunksToData(new ParsedChunkData(this.chunks[i], this.biomeData[i]));
            if (networkChunkDataArr[i].hasSkyLight()) {
                z = true;
            }
        }
        netOutput.writeBoolean(z);
        netOutput.writeVarInt(this.chunks.length);
        for (int i2 = 0; i2 < this.x.length; i2++) {
            netOutput.writeInt(this.x[i2]);
            netOutput.writeInt(this.z[i2]);
            netOutput.writeShort(networkChunkDataArr[i2].getMask());
        }
        for (int i3 = 0; i3 < this.x.length; i3++) {
            netOutput.writeBytes(networkChunkDataArr[i3].getData());
        }
    }
}
