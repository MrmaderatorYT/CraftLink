package com.github.steveice10.packetlib;

import com.github.steveice10.packetlib.event.session.SessionEvent;
import com.github.steveice10.packetlib.event.session.SessionListener;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import java.net.SocketAddress;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface Session {
    void addListener(SessionListener sessionListener);

    void callEvent(SessionEvent sessionEvent);

    void connect();

    void connect(boolean z);

    void disconnect(String str);

    void disconnect(String str, Throwable th);

    void disconnect(String str, Throwable th, boolean z);

    void disconnect(String str, boolean z);

    int getCompressionThreshold();

    int getConnectTimeout();

    <T> T getFlag(String str);

    Map<String, Object> getFlags();

    String getHost();

    List<SessionListener> getListeners();

    SocketAddress getLocalAddress();

    PacketProtocol getPacketProtocol();

    int getPort();

    int getReadTimeout();

    SocketAddress getRemoteAddress();

    int getWriteTimeout();

    boolean hasFlag(String str);

    boolean isConnected();

    void removeListener(SessionListener sessionListener);

    void send(Packet packet);

    void setCompressionThreshold(int i);

    void setConnectTimeout(int i);

    void setFlag(String str, Object obj);

    void setReadTimeout(int i);

    void setWriteTimeout(int i);
}
