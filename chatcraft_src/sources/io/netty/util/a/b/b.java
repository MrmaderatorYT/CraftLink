package io.netty.util.a.b;

/* compiled from: FormattingTuple.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static final b f4646a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f4647b;
    private final Throwable c;
    private final Object[] d;

    b(String str) {
        this(str, null, null);
    }

    b(String str, Object[] objArr, Throwable th) {
        this.f4647b = str;
        this.c = th;
        if (th == null) {
            this.d = objArr;
        } else {
            this.d = a(objArr);
        }
    }

    static Object[] a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    public String a() {
        return this.f4647b;
    }

    public Throwable b() {
        return this.c;
    }
}
