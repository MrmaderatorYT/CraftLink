package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_7.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_7.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_7.protocol.util.NetworkChunkData;
import com.github.steveice10.mc.v1_7.protocol.util.ParsedChunkData;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
        int i = netInput.readShort();
        int i2 = netInput.readInt();
        boolean z = netInput.readBoolean();
        byte[] bytes = netInput.readBytes(i2);
        byte[] bArr = new byte[196864 * i];
        Inflater inflater = new Inflater();
        inflater.setInput(bytes, 0, i2);
        try {
            try {
                inflater.inflate(bArr);
                inflater.end();
                this.x = new int[i];
                this.z = new int[i];
                this.chunks = new Chunk[i][];
                this.biomeData = new byte[i][];
                int i3 = 0;
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = netInput.readInt();
                    int i6 = netInput.readInt();
                    short s = netInput.readShort();
                    short s2 = netInput.readShort();
                    int i7 = 0;
                    int i8 = 0;
                    for (int i9 = 0; i9 < 16; i9++) {
                        i7 += (s >> i9) & 1;
                        i8 += (s2 >> i9) & 1;
                    }
                    int i10 = (i7 * 8192) + 256 + (i8 * 2048);
                    if (z) {
                        i10 += i7 * 2048;
                    }
                    int i11 = i10;
                    byte[] bArr2 = new byte[i11];
                    System.arraycopy(bArr, i3, bArr2, 0, i11);
                    ParsedChunkData parsedChunkDataDataToChunks = NetUtil.dataToChunks(new NetworkChunkData(s, s2, true, z, bArr2));
                    this.x[i4] = i5;
                    this.z[i4] = i6;
                    this.chunks[i4] = parsedChunkDataDataToChunks.getChunks();
                    this.biomeData[i4] = parsedChunkDataDataToChunks.getBiomes();
                    i3 += i11;
                }
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
        int[] iArr = new int[this.chunks.length];
        int[] iArr2 = new int[this.chunks.length];
        byte[] bArr = new byte[0];
        int length = 0;
        boolean z = false;
        for (int i = 0; i < this.chunks.length; i++) {
            NetworkChunkData networkChunkDataChunksToData = NetUtil.chunksToData(new ParsedChunkData(this.chunks[i], this.biomeData[i]));
            if (bArr.length < networkChunkDataChunksToData.getData().length + length) {
                byte[] bArr2 = new byte[networkChunkDataChunksToData.getData().length + length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            if (networkChunkDataChunksToData.hasSkyLight()) {
                z = true;
            }
            System.arraycopy(networkChunkDataChunksToData.getData(), 0, bArr, length, networkChunkDataChunksToData.getData().length);
            length += networkChunkDataChunksToData.getData().length;
            iArr[i] = networkChunkDataChunksToData.getMask();
            iArr2[i] = networkChunkDataChunksToData.getExtendedMask();
        }
        Deflater deflater = new Deflater(-1);
        byte[] bArr3 = new byte[length];
        try {
            deflater.setInput(bArr, 0, length);
            deflater.finish();
            int iDeflate = deflater.deflate(bArr3);
            deflater.end();
            netOutput.writeShort(this.chunks.length);
            netOutput.writeInt(iDeflate);
            netOutput.writeBoolean(z);
            netOutput.writeBytes(bArr3, iDeflate);
            for (int i2 = 0; i2 < this.chunks.length; i2++) {
                netOutput.writeInt(this.x[i2]);
                netOutput.writeInt(this.z[i2]);
                netOutput.writeShort((short) (iArr[i2] & 65535));
                netOutput.writeShort((short) (iArr2[i2] & 65535));
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }
}
