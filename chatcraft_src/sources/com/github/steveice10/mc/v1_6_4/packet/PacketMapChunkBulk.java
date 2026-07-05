package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class PacketMapChunkBulk extends Packet {
    public int[] add;
    public byte[][] chunks;
    public int[] columnX;
    public int[] columnZ;
    public byte[] compressed;
    public int length;
    public int[] primary;
    public boolean skylight;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 56;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketMapChunkBulk() {
    }

    public PacketMapChunkBulk(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, byte[] bArr, byte[][] bArr2, boolean z) {
        this.columnX = iArr;
        this.columnZ = iArr2;
        this.primary = iArr3;
        this.add = iArr4;
        this.skylight = z;
        Deflater deflater = new Deflater(-1);
        try {
            deflater.setInput(bArr, 0, bArr.length);
            deflater.finish();
            this.compressed = new byte[bArr.length];
            this.length = deflater.deflate(this.compressed);
            deflater.end();
            this.chunks = bArr2;
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        int i = netInput.readShort();
        this.length = netInput.readInt();
        this.skylight = netInput.readBoolean();
        this.columnX = new int[i];
        this.columnZ = new int[i];
        this.primary = new int[i];
        this.add = new int[i];
        this.chunks = new byte[i][];
        this.compressed = netInput.readBytes(this.length);
        byte[] bArr = new byte[196864 * i];
        Inflater inflater = new Inflater();
        inflater.setInput(this.compressed, 0, this.length);
        try {
            try {
                inflater.inflate(bArr);
                inflater.end();
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    this.columnX[i3] = netInput.readInt();
                    this.columnZ[i3] = netInput.readInt();
                    this.primary[i3] = netInput.readShort();
                    this.add[i3] = netInput.readShort();
                    int i4 = 0;
                    for (int i5 = 0; i5 < 16; i5++) {
                        i4 += (this.primary[i3] >> i5) & 1;
                    }
                    int i6 = (i4 * 5 * 2048) + 256;
                    this.chunks[i3] = new byte[i6];
                    System.arraycopy(bArr, i2, this.chunks[i3], 0, i6);
                    i2 += i6;
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
        netOutput.writeShort(this.columnX.length);
        netOutput.writeInt(this.length);
        netOutput.writeBoolean(this.skylight);
        netOutput.writeBytes(this.compressed, this.length);
        for (int i = 0; i < this.columnX.length; i++) {
            netOutput.writeInt(this.columnX[i]);
            netOutput.writeInt(this.columnZ[i]);
            netOutput.writeShort(this.primary[i]);
            netOutput.writeShort(this.add[i]);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
