package com.github.steveice10.packetlib;

import com.github.steveice10.packetlib.event.server.ServerBoundEvent;
import com.github.steveice10.packetlib.event.server.ServerClosedEvent;
import com.github.steveice10.packetlib.event.server.ServerClosingEvent;
import com.github.steveice10.packetlib.event.server.ServerEvent;
import com.github.steveice10.packetlib.event.server.ServerListener;
import com.github.steveice10.packetlib.event.server.SessionAddedEvent;
import com.github.steveice10.packetlib.event.server.SessionRemovedEvent;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Server {
    private SessionFactory factory;
    private String host;
    private ConnectionListener listener;
    private int port;
    private Class<? extends PacketProtocol> protocol;
    private List<Session> sessions = new ArrayList();
    private Map<String, Object> flags = new HashMap();
    private List<ServerListener> listeners = new ArrayList();

    public Server(String str, int i, Class<? extends PacketProtocol> cls, SessionFactory sessionFactory) {
        this.host = str;
        this.port = i;
        this.protocol = cls;
        this.factory = sessionFactory;
    }

    public Server bind() {
        return bind(true);
    }

    public Server bind(boolean z) {
        this.listener = this.factory.createServerListener(this);
        this.listener.bind(z, new Runnable() { // from class: com.github.steveice10.packetlib.Server.1
            @Override // java.lang.Runnable
            public void run() {
                Server.this.callEvent(new ServerBoundEvent(Server.this));
            }
        });
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public Class<? extends PacketProtocol> getPacketProtocol() {
        return this.protocol;
    }

    public PacketProtocol createPacketProtocol() throws NoSuchMethodException, SecurityException {
        try {
            Constructor<? extends PacketProtocol> declaredConstructor = this.protocol.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate PacketProtocol " + this.protocol.getName() + ".", e);
        } catch (NoSuchMethodError unused) {
            throw new IllegalStateException("PacketProtocol \"" + this.protocol.getName() + "\" does not have a no-params constructor for instantiation.");
        }
    }

    public Map<String, Object> getGlobalFlags() {
        return new HashMap(this.flags);
    }

    public boolean hasGlobalFlag(String str) {
        return this.flags.containsKey(str);
    }

    public <T> T getGlobalFlag(String str) {
        T t = (T) this.flags.get(str);
        if (t == null) {
            return null;
        }
        return t;
    }

    public void setGlobalFlag(String str, Object obj) {
        this.flags.put(str, obj);
    }

    public List<ServerListener> getListeners() {
        return new ArrayList(this.listeners);
    }

    public void addListener(ServerListener serverListener) {
        this.listeners.add(serverListener);
    }

    public void removeListener(ServerListener serverListener) {
        this.listeners.remove(serverListener);
    }

    public void callEvent(ServerEvent serverEvent) {
        Iterator<ServerListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            serverEvent.call(it.next());
        }
    }

    public List<Session> getSessions() {
        return new ArrayList(this.sessions);
    }

    public void addSession(Session session) {
        this.sessions.add(session);
        callEvent(new SessionAddedEvent(this, session));
    }

    public void removeSession(Session session) {
        this.sessions.remove(session);
        if (session.isConnected()) {
            session.disconnect("Connection closed.");
        }
        callEvent(new SessionRemovedEvent(this, session));
    }

    public boolean isListening() {
        return this.listener != null && this.listener.isListening();
    }

    public void close() {
        close(true);
    }

    public void close(boolean z) {
        callEvent(new ServerClosingEvent(this));
        for (Session session : getSessions()) {
            if (session.isConnected()) {
                session.disconnect("Server closed.");
            }
        }
        this.listener.close(z, new Runnable() { // from class: com.github.steveice10.packetlib.Server.2
            @Override // java.lang.Runnable
            public void run() {
                Server.this.callEvent(new ServerClosedEvent(Server.this));
            }
        });
    }
}
