package io.fabric.sdk.android.services.b;

/* compiled from: Crash.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private final String f4217a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4218b;

    public j(String str, String str2) {
        this.f4217a = str;
        this.f4218b = str2;
    }

    public String a() {
        return this.f4217a;
    }

    public String b() {
        return this.f4218b;
    }

    /* compiled from: Crash.java */
    public static class b extends j {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    /* compiled from: Crash.java */
    public static class a extends j {
        public a(String str, String str2) {
            super(str, str2);
        }
    }
}
