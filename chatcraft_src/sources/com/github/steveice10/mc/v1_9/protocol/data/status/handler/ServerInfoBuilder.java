package com.github.steveice10.mc.v1_9.protocol.data.status.handler;

import com.github.steveice10.mc.v1_9.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.packetlib.Session;

/* loaded from: classes.dex */
public interface ServerInfoBuilder {
    ServerStatusInfo buildInfo(Session session);
}
