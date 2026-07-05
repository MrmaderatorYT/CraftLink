package com.github.steveice10.mc.v1_9_4.protocol.data.status.handler;

import com.github.steveice10.mc.v1_9_4.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.packetlib.Session;

/* loaded from: classes.dex */
public interface ServerInfoHandler {
    void handle(Session session, ServerStatusInfo serverStatusInfo);
}
