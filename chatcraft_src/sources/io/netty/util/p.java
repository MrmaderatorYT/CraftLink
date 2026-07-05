package io.netty.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ResourceLeakDetector.java */
/* loaded from: classes.dex */
public class p<T> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f4784b;
    private static b c;
    private static final String[] p;
    private final p<T>.a e;
    private final p<T>.a f;
    private final ReferenceQueue<Object> g;
    private final ConcurrentMap<String, Boolean> h;
    private final String i;
    private final int j;
    private final int k;
    private final long l;
    private long m;
    private final AtomicBoolean n;
    private long o;

    /* renamed from: a, reason: collision with root package name */
    private static final b f4783a = b.SIMPLE;
    private static final io.netty.util.a.b.c d = io.netty.util.a.b.d.a((Class<?>) p.class);

    /* compiled from: ResourceLeakDetector.java */
    public enum b {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID
    }

    static /* synthetic */ long c(p pVar) {
        long j = pVar.m;
        pVar.m = 1 + j;
        return j;
    }

    static /* synthetic */ long d(p pVar) {
        long j = pVar.m;
        pVar.m = j - 1;
        return j;
    }

    static {
        boolean zA;
        if (io.netty.util.a.q.b("io.netty.noResourceLeakDetection") != null) {
            zA = io.netty.util.a.q.a("io.netty.noResourceLeakDetection", false);
            d.b("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(zA));
            d.c("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", "io.netty.leakDetection.level", f4783a.name().toLowerCase());
        } else {
            zA = false;
        }
        String upperCase = io.netty.util.a.q.a("io.netty.leakDetection.level", io.netty.util.a.q.a("io.netty.leakDetectionLevel", (zA ? b.DISABLED : f4783a).name()).trim().toUpperCase()).trim().toUpperCase();
        b bVar = f4783a;
        Iterator it = EnumSet.allOf(b.class).iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (upperCase.equals(bVar2.name()) || upperCase.equals(String.valueOf(bVar2.ordinal()))) {
                bVar = bVar2;
            }
        }
        f4784b = io.netty.util.a.q.a("io.netty.leakDetection.maxRecords", 4);
        c = bVar;
        if (d.b()) {
            d.b("-D{}: {}", "io.netty.leakDetection.level", bVar.name().toLowerCase());
            d.b("-D{}: {}", "io.netty.leakDetection.maxRecords", Integer.valueOf(f4784b));
        }
        p = new String[]{"io.netty.util.ReferenceCountUtil.touch(", "io.netty.buffer.AdvancedLeakAwareByteBuf.touch(", "io.netty.buffer.AbstractByteBufAllocator.toLeakAwareBuffer(", "io.netty.buffer.AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation("};
    }

    public static boolean a() {
        return b().ordinal() > b.DISABLED.ordinal();
    }

    public static b b() {
        return c;
    }

    public p(Class<?> cls, int i, long j) {
        this(io.netty.util.a.p.a(cls), i, j);
    }

    @Deprecated
    public p(String str, int i, long j) {
        this.e = new a(null);
        this.f = new a(null);
        this.g = new ReferenceQueue<>();
        this.h = io.netty.util.a.l.k();
        this.n = new AtomicBoolean();
        if (str == null) {
            throw new NullPointerException("resourceType");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("maxActive: " + j + " (expected: 1+)");
        }
        this.i = str;
        this.j = io.netty.util.a.h.b(i);
        this.k = this.j - 1;
        this.l = j;
        ((a) this.e).f = this.f;
        ((a) this.f).e = this.e;
    }

    public final o a(T t) {
        b bVar = c;
        if (bVar == b.DISABLED) {
            return null;
        }
        if (bVar.ordinal() < b.PARANOID.ordinal()) {
            long j = this.o + 1;
            this.o = j;
            if ((j & this.k) != 0) {
                return null;
            }
            a(bVar);
            return new a(t);
        }
        a(bVar);
        return new a(t);
    }

    private void a(b bVar) {
        if (d.d()) {
            if (this.m * (bVar == b.PARANOID ? 1 : this.j) > this.l && this.n.compareAndSet(false, true)) {
                b(this.i);
            }
            while (true) {
                a aVar = (a) this.g.poll();
                if (aVar == null) {
                    return;
                }
                aVar.clear();
                if (aVar.b()) {
                    String string = aVar.toString();
                    if (this.h.putIfAbsent(string, Boolean.TRUE) == null) {
                        if (string.isEmpty()) {
                            a(this.i);
                        } else {
                            a(this.i, string);
                        }
                    }
                }
            }
        } else {
            while (true) {
                a aVar2 = (a) this.g.poll();
                if (aVar2 == null) {
                    return;
                } else {
                    aVar2.b();
                }
            }
        }
    }

    protected void a(String str, String str2) {
        d.d("LEAK: {}.release() was not called before it's garbage-collected. See http://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void a(String str) {
        d.c("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See http://netty.io/wiki/reference-counted-objects.html for more information.", str, "io.netty.leakDetection.level", b.ADVANCED.name().toLowerCase(), io.netty.util.a.p.a(this));
    }

    protected void b(String str) {
        d.d("LEAK: You are creating too many " + str + " instances.  " + str + " is a shared resource that must be reused across the JVM,so that only a few instances are created.");
    }

    /* compiled from: ResourceLeakDetector.java */
    private final class a extends PhantomReference<Object> implements o {

        /* renamed from: b, reason: collision with root package name */
        private final String f4786b;
        private final Deque<String> c;
        private final AtomicBoolean d;
        private p<T>.a e;
        private p<T>.a f;
        private int g;

        a(Object obj) {
            super(obj, obj != null ? p.this.g : null);
            this.c = new ArrayDeque();
            if (obj != null) {
                if (p.b().ordinal() >= b.ADVANCED.ordinal()) {
                    this.f4786b = p.a((Object) null, 3);
                } else {
                    this.f4786b = null;
                }
                synchronized (p.this.e) {
                    this.e = p.this.e;
                    this.f = p.this.e.f;
                    p.this.e.f.e = this;
                    p.this.e.f = this;
                    p.c(p.this);
                }
                this.d = new AtomicBoolean();
                return;
            }
            this.f4786b = null;
            this.d = new AtomicBoolean(true);
        }

        @Override // io.netty.util.o
        public void a() {
            a((Object) null, 3);
        }

        @Override // io.netty.util.o
        public void a(Object obj) {
            a(obj, 3);
        }

        private void a(Object obj, int i) {
            if (this.f4786b != null) {
                String strA = p.a(obj, i);
                synchronized (this.c) {
                    int size = this.c.size();
                    if (size == 0 || !this.c.getLast().equals(strA)) {
                        this.c.add(strA);
                    }
                    if (size > p.f4784b) {
                        this.c.removeFirst();
                        this.g++;
                    }
                }
            }
        }

        @Override // io.netty.util.o
        public boolean b() {
            if (!this.d.compareAndSet(false, true)) {
                return false;
            }
            synchronized (p.this.e) {
                p.d(p.this);
                this.e.f = this.f;
                this.f.e = this.e;
                this.e = null;
                this.f = null;
            }
            return true;
        }

        public String toString() {
            Object[] array;
            int i;
            if (this.f4786b == null) {
                return BuildConfig.FLAVOR;
            }
            synchronized (this.c) {
                array = this.c.toArray();
                i = this.g;
            }
            StringBuilder sb = new StringBuilder(16384);
            sb.append(io.netty.util.a.p.f4696a);
            if (i > 0) {
                sb.append("WARNING: ");
                sb.append(i);
                sb.append(" leak records were discarded because the leak record count is limited to ");
                sb.append(p.f4784b);
                sb.append(". Use system property ");
                sb.append("io.netty.leakDetection.maxRecords");
                sb.append(" to increase the limit.");
                sb.append(io.netty.util.a.p.f4696a);
            }
            sb.append("Recent access records: ");
            sb.append(array.length);
            sb.append(io.netty.util.a.p.f4696a);
            if (array.length > 0) {
                for (int length = array.length - 1; length >= 0; length--) {
                    sb.append('#');
                    sb.append(length + 1);
                    sb.append(':');
                    sb.append(io.netty.util.a.p.f4696a);
                    sb.append(array[length]);
                }
            }
            sb.append("Created at:");
            sb.append(io.netty.util.a.p.f4696a);
            sb.append(this.f4786b);
            sb.setLength(sb.length() - io.netty.util.a.p.f4696a.length());
            return sb.toString();
        }
    }

    static String a(Object obj, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder(4096);
        if (obj != null) {
            sb.append("\tHint: ");
            if (obj instanceof r) {
                sb.append(((r) obj).u());
            } else {
                sb.append(obj);
            }
            sb.append(io.netty.util.a.p.f4696a);
        }
        int i2 = i;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (i2 > 0) {
                i2--;
            } else {
                String string = stackTraceElement.toString();
                String[] strArr = p;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    if (string.startsWith(strArr[i3])) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    sb.append('\t');
                    sb.append(string);
                    sb.append(io.netty.util.a.p.f4696a);
                }
            }
        }
        return sb.toString();
    }
}
