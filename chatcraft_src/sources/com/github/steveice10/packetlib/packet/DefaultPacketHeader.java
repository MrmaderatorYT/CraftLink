package com.github.steveice10.packetlib.packet;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class DefaultPacketHeader implements PacketHeader {
    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public int getLengthSize() {
        return 5;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public int getLengthSize(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public boolean isLengthVariable() {
        return true;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public int readLength(NetInput netInput, int i) {
        return netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public void writeLength(NetOutput netOutput, int i) {
        netOutput.writeVarInt(i);
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public int readPacketId(NetInput netInput) {
        return netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.PacketHeader
    public void writePacketId(NetOutput netOutput, int i) {
        netOutput.writeVarInt(i);
    }
}
