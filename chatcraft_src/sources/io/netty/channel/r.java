package io.netty.channel;

import java.net.InetAddress;
import java.net.NetworkInterface;

/* compiled from: ChannelOption.java */
/* loaded from: classes.dex */
public class r<T> extends io.netty.util.a<r<T>> {
    private static final io.netty.util.h<r<Object>> C = new io.netty.util.h<r<Object>>() { // from class: io.netty.channel.r.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r<Object> b(int i2, String str) {
            return new r<>(i2, str);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static final r<io.netty.b.j> f4554a = a("ALLOCATOR");

    /* renamed from: b, reason: collision with root package name */
    public static final r<ar> f4555b = a("RCVBUF_ALLOCATOR");
    public static final r<ap> c = a("MESSAGE_SIZE_ESTIMATOR");
    public static final r<Integer> d = a("CONNECT_TIMEOUT_MILLIS");

    @Deprecated
    public static final r<Integer> e = a("MAX_MESSAGES_PER_READ");
    public static final r<Integer> f = a("WRITE_SPIN_COUNT");

    @Deprecated
    public static final r<Integer> g = a("WRITE_BUFFER_HIGH_WATER_MARK");

    @Deprecated
    public static final r<Integer> h = a("WRITE_BUFFER_LOW_WATER_MARK");
    public static final r<bc> i = a("WRITE_BUFFER_WATER_MARK");
    public static final r<Boolean> j = a("ALLOW_HALF_CLOSURE");
    public static final r<Boolean> k = a("AUTO_READ");

    @Deprecated
    public static final r<Boolean> l = a("AUTO_CLOSE");
    public static final r<Boolean> m = a("SO_BROADCAST");
    public static final r<Boolean> n = a("SO_KEEPALIVE");
    public static final r<Integer> o = a("SO_SNDBUF");
    public static final r<Integer> p = a("SO_RCVBUF");
    public static final r<Boolean> q = a("SO_REUSEADDR");
    public static final r<Integer> r = a("SO_LINGER");
    public static final r<Integer> s = a("SO_BACKLOG");
    public static final r<Integer> t = a("SO_TIMEOUT");
    public static final r<Integer> u = a("IP_TOS");
    public static final r<InetAddress> v = a("IP_MULTICAST_ADDR");
    public static final r<NetworkInterface> w = a("IP_MULTICAST_IF");
    public static final r<Integer> x = a("IP_MULTICAST_TTL");
    public static final r<Boolean> y = a("IP_MULTICAST_LOOP_DISABLED");
    public static final r<Boolean> z = a("TCP_NODELAY");

    @Deprecated
    public static final r<Boolean> A = a("DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION");
    public static final r<Boolean> B = a("SINGLE_EVENTEXECUTOR_PER_GROUP");

    public static <T> r<T> a(String str) {
        return (r) C.a(str);
    }

    private r(int i2, String str) {
        super(i2, str);
    }

    public void a(T t2) {
        if (t2 == null) {
            throw new NullPointerException("value");
        }
    }
}
