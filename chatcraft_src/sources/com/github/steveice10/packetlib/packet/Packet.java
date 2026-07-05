package com.github.steveice10.packetlib.packet;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public interface Packet {
    boolean isPriority();

    void read(NetInput netInput);

    void write(NetOutput netOutput);
}
