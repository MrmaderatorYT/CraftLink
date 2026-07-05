package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import com.google.android.gms.internal.ads.aqy.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class aqy<MessageType extends aqy<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends apf<MessageType, BuilderType> {
    private static Map<Object, aqy<?, ?>> zzfpw = new ConcurrentHashMap();
    protected atp zzfpu = atp.a();
    private int zzfpv = -1;

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends aqy<MessageType, BuilderType> implements ash {
        protected aqo<Object> zzfqa = aqo.a();
    }

    public static class d<ContainingType extends asf, Type> extends aqi<ContainingType, Type> {
    }

    public enum e {

        /* renamed from: a, reason: collision with root package name */
        public static final int f2193a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f2194b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] l = {f2193a, f2194b, c, d, e, f, g};
        public static final int h = 1;
        public static final int i = 2;
        private static final /* synthetic */ int[] m = {h, i};
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    protected abstract Object a(int i, Object obj, Object obj2);

    public static class b<T extends aqy<T, ?>> extends aph<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f2192a;

        public b(T t) {
            this.f2192a = t;
        }

        @Override // com.google.android.gms.internal.ads.asq
        public final /* synthetic */ Object a(aqa aqaVar, aqk aqkVar) {
            return aqy.a(this.f2192a, aqaVar, aqkVar);
        }
    }

    public String toString() {
        return asi.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzfkx != 0) {
            return this.zzfkx;
        }
        this.zzfkx = ass.a().a((ass) this).a(this);
        return this.zzfkx;
    }

    public static abstract class a<MessageType extends aqy<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends apg<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        protected MessageType f2190a;

        /* renamed from: b, reason: collision with root package name */
        private final MessageType f2191b;
        private boolean c = false;

        protected a(MessageType messagetype) {
            this.f2191b = messagetype;
            this.f2190a = (MessageType) messagetype.a(e.d, null, null);
        }

        protected final void b() {
            if (this.c) {
                MessageType messagetype = (MessageType) this.f2190a.a(e.d, null, null);
                a(messagetype, this.f2190a);
                this.f2190a = messagetype;
                this.c = false;
            }
        }

        @Override // com.google.android.gms.internal.ads.ash
        public final boolean k() {
            return aqy.a(this.f2190a, false);
        }

        @Override // com.google.android.gms.internal.ads.asg
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public MessageType e() {
            if (this.c) {
                return this.f2190a;
            }
            MessageType messagetype = this.f2190a;
            ass.a().a((ass) messagetype).c(messagetype);
            this.c = true;
            return this.f2190a;
        }

        @Override // com.google.android.gms.internal.ads.asg
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final MessageType f() {
            MessageType messagetype = (MessageType) e();
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) messagetype.a(e.f2193a, null, null)).byteValue();
            boolean zD = true;
            if (bByteValue != 1) {
                if (bByteValue == 0) {
                    zD = false;
                } else {
                    zD = ass.a().a((ass) messagetype).d(messagetype);
                    if (zBooleanValue) {
                        messagetype.a(e.f2194b, zD ? messagetype : null, null);
                    }
                }
            }
            if (zD) {
                return messagetype;
            }
            throw new zzbtt(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.apg
        public final BuilderType a(MessageType messagetype) {
            b();
            a(this.f2190a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            ass.a().a((ass) messagetype).b(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.ads.apg
        /* renamed from: a */
        public final /* synthetic */ apg clone() {
            return (a) clone();
        }

        @Override // com.google.android.gms.internal.ads.ash
        public final /* synthetic */ asf q() {
            return this.f2191b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.apg
        public /* synthetic */ Object clone() {
            a aVar = (a) this.f2191b.a(e.e, null, null);
            aVar.a((a) e());
            return aVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((aqy) a(e.f, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return ass.a().a((ass) this).a(this, (aqy<MessageType, BuilderType>) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final boolean k() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) a(e.f2193a, (Object) null, (Object) null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = ass.a().a((ass) this).d(this);
        if (zBooleanValue) {
            a(e.f2194b, zD ? this : null, (Object) null);
        }
        return zD;
    }

    @Override // com.google.android.gms.internal.ads.apf
    final int j() {
        return this.zzfpv;
    }

    @Override // com.google.android.gms.internal.ads.apf
    final void a(int i) {
        this.zzfpv = i;
    }

    @Override // com.google.android.gms.internal.ads.asf
    public final void a(zzbqk zzbqkVar) {
        ass.a().a((Class) getClass()).a((asx) this, (auk) aqg.a(zzbqkVar));
    }

    @Override // com.google.android.gms.internal.ads.asf
    public final int l() {
        if (this.zzfpv == -1) {
            this.zzfpv = ass.a().a((ass) this).b(this);
        }
        return this.zzfpv;
    }

    static <T extends aqy<?, ?>> T a(Class<T> cls) throws ClassNotFoundException {
        T t = (T) zzfpw.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzfpw.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(strValueOf.length() != 0 ? "Unable to get default instance for: ".concat(strValueOf) : new String("Unable to get default instance for: "));
    }

    protected static <T extends aqy<?, ?>> void a(Class<T> cls, T t) {
        zzfpw.put(cls, t);
    }

    protected static Object a(asf asfVar, String str, Object[] objArr) {
        return new asv(asfVar, str, objArr);
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends aqy<T, ?>> boolean a(T t, boolean z) {
        byte bByteValue = ((Byte) t.a(e.f2193a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        return ass.a().a((ass) t).d(t);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.aqz, com.google.android.gms.internal.ads.are] */
    protected static are m() {
        return aqz.d();
    }

    protected static <E> arf<E> n() {
        return ast.d();
    }

    static <T extends aqy<T, ?>> T a(T t, aqa aqaVar, aqk aqkVar) throws zzbrl {
        T t2 = (T) t.a(e.d, null, null);
        try {
            ass.a().a((ass) t2).a(t2, aqd.a(aqaVar), aqkVar);
            ass.a().a((ass) t2).c(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzbrl) {
                throw ((zzbrl) e2.getCause());
            }
            throw new zzbrl(e2.getMessage()).a(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzbrl) {
                throw ((zzbrl) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends aqy<T, ?>> T b(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) t.a(e.d, null, null);
        try {
            ass.a().a((ass) t2).a(t2, bArr, 0, bArr.length, new apl());
            ass.a().a((ass) t2).c(t2);
            if (t2.zzfkx == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzbrl) {
                throw ((zzbrl) e2.getCause());
            }
            throw new zzbrl(e2.getMessage()).a(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzbrl.a().a(t2);
        }
    }

    protected static <T extends aqy<T, ?>> T a(T t, apo apoVar) throws zzbrl {
        boolean zD;
        T t2 = (T) a(t, apoVar, aqk.a());
        boolean zD2 = false;
        if (t2 != null) {
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) t2.a(e.f2193a, null, null)).byteValue();
            if (bByteValue == 1) {
                zD = true;
            } else if (bByteValue == 0) {
                zD = false;
            } else {
                zD = ass.a().a((ass) t2).d(t2);
                if (zBooleanValue) {
                    t2.a(e.f2194b, zD ? t2 : null, null);
                }
            }
            if (!zD) {
                throw new zzbtt(t2).a().a(t2);
            }
        }
        if (t2 != null) {
            boolean zBooleanValue2 = Boolean.TRUE.booleanValue();
            byte bByteValue2 = ((Byte) t2.a(e.f2193a, null, null)).byteValue();
            if (bByteValue2 == 1) {
                zD2 = true;
            } else if (bByteValue2 != 0) {
                zD2 = ass.a().a((ass) t2).d(t2);
                if (zBooleanValue2) {
                    t2.a(e.f2194b, zD2 ? t2 : null, null);
                }
            }
            if (!zD2) {
                throw new zzbtt(t2).a().a(t2);
            }
        }
        return t2;
    }

    private static <T extends aqy<T, ?>> T a(T t, apo apoVar, aqk aqkVar) throws zzbrl {
        try {
            aqa aqaVarE = apoVar.e();
            T t2 = (T) a(t, aqaVarE, aqkVar);
            try {
                aqaVarE.a(0);
                return t2;
            } catch (zzbrl e2) {
                throw e2.a(t2);
            }
        } catch (zzbrl e3) {
            throw e3;
        }
    }

    protected static <T extends aqy<T, ?>> T a(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) b(t, bArr);
        if (t2 != null) {
            boolean zBooleanValue = Boolean.TRUE.booleanValue();
            byte bByteValue = ((Byte) t2.a(e.f2193a, null, null)).byteValue();
            boolean zD = true;
            if (bByteValue != 1) {
                if (bByteValue == 0) {
                    zD = false;
                } else {
                    zD = ass.a().a((ass) t2).d(t2);
                    if (zBooleanValue) {
                        t2.a(e.f2194b, zD ? t2 : null, null);
                    }
                }
            }
            if (!zD) {
                throw new zzbtt(t2).a().a(t2);
            }
        }
        return t2;
    }

    @Override // com.google.android.gms.internal.ads.asf
    public final /* synthetic */ asg o() {
        a aVar = (a) a(e.e, (Object) null, (Object) null);
        aVar.a((a) this);
        return aVar;
    }

    @Override // com.google.android.gms.internal.ads.asf
    public final /* synthetic */ asg p() {
        return (a) a(e.e, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final /* synthetic */ asf q() {
        return (aqy) a(e.f, (Object) null, (Object) null);
    }
}
