package com.github.steveice10.mc.v1_9.protocol.data.game.chunk;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.util.Arrays;

/* loaded from: classes.dex */
public class NibbleArray3d {
    private byte[] data;

    public NibbleArray3d(int i) {
        this.data = new byte[i >> 1];
    }

    public NibbleArray3d(byte[] bArr) {
        this.data = bArr;
    }

    public NibbleArray3d(NetInput netInput, int i) {
        this.data = netInput.readBytes(i);
    }

    public void write(NetOutput netOutput) {
        netOutput.writeBytes(this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public int get(int i, int i2, int i3) {
        int i4 = i | (i2 << 8) | (i3 << 4);
        int i5 = i4 >> 1;
        return ((i4 & 1) == 0 ? this.data[i5] : this.data[i5] >> 4) & 15;
    }

    public void set(int i, int i2, int i3, int i4) {
        int i5 = i | (i2 << 8) | (i3 << 4);
        int i6 = i5 >> 1;
        if ((i5 & 1) == 0) {
            this.data[i6] = (byte) ((this.data[i6] & 240) | (i4 & 15));
        } else {
            this.data[i6] = (byte) ((this.data[i6] & 15) | ((i4 & 15) << 4));
        }
    }

    public void fill(int i) {
        for (int i2 = 0; i2 < (this.data.length << 1); i2++) {
            int i3 = i2 >> 1;
            if ((i2 & 1) == 0) {
                this.data[i3] = (byte) ((this.data[i3] & 240) | (i & 15));
            } else {
                this.data[i3] = (byte) ((this.data[i3] & 15) | ((i & 15) << 4));
            }
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof NibbleArray3d) && Arrays.equals(this.data, ((NibbleArray3d) obj).data));
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }
}
