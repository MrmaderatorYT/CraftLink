package com.github.steveice10.packetlib.packet;

import com.github.steveice10.mc.common.SilentException;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.crypt.PacketEncryption;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class PacketProtocol {
    private final Map<Integer, Class<? extends Packet>> incoming = new HashMap();
    private final Map<Class<? extends Packet>, Integer> outgoing = new HashMap();
    protected boolean SKIP_NON_REGISTERED_PACKETS = false;

    public abstract PacketEncryption getEncryption();

    public abstract PacketHeader getPacketHeader();

    public abstract String getSRVRecordPrefix();

    public abstract void newClientSession(Client client, Session session);

    public abstract void newServerSession(Server server, Session session);

    public final void clearPackets() {
        this.incoming.clear();
        this.outgoing.clear();
    }

    public final void register(int i, Class<? extends Packet> cls) throws NoSuchMethodException, SecurityException {
        registerIncoming(i, cls);
        registerOutgoing(i, cls);
    }

    public final void registerIncoming(int i, Class<? extends Packet> cls) throws NoSuchMethodException, SecurityException {
        this.incoming.put(Integer.valueOf(i), cls);
        try {
            createIncomingPacket(i);
        } catch (IllegalStateException e) {
            this.incoming.remove(Integer.valueOf(i));
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }

    public final void registerOutgoing(int i, Class<? extends Packet> cls) {
        this.outgoing.put(cls, Integer.valueOf(i));
    }

    public final Packet createIncomingPacket(int i) throws NoSuchMethodException, SecurityException {
        if (i < 0 || !this.incoming.containsKey(Integer.valueOf(i)) || this.incoming.get(Integer.valueOf(i)) == null) {
            throw new IllegalArgumentException("Invalid packet id: " + i);
        }
        Class<? extends Packet> cls = this.incoming.get(Integer.valueOf(i));
        try {
            Constructor<? extends Packet> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate packet \"" + i + ", " + cls.getName() + "\".", e);
        } catch (NoSuchMethodError unused) {
            throw new IllegalStateException("Packet \"" + i + ", " + cls.getName() + "\" does not have a no-params constructor for instantiation.");
        }
    }

    public final int getOutgoingId(Class<? extends Packet> cls) {
        Integer num;
        if (!this.outgoing.containsKey(cls) || (num = this.outgoing.get(cls)) == null) {
            if (this.SKIP_NON_REGISTERED_PACKETS) {
                throw new SilentException("Packet " + cls.getSimpleName() + " does not exists!");
            }
            throw new IllegalArgumentException("Unregistered outgoing packet class: " + cls.getName());
        }
        return num.intValue();
    }
}
