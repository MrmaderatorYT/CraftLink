package com.github.steveice10.packetlib;

/* loaded from: classes.dex */
public interface SessionFactory {
    Session createClientSession(Client client);

    ConnectionListener createServerListener(Server server);
}
