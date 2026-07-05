package com.github.steveice10.packetlib.packet;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public interface PacketHeader {
    int getLengthSize();

    int getLengthSize(int i);

    boolean isLengthVariable();

    int readLength(NetInput netInput, int i);

    int readPacketId(NetInput netInput);

    void writeLength(NetOutput netOutput, int i);

    void writePacketId(NetOutput netOutput, int i);
}
