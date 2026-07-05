package okhttp3.internal.b;

import javax.annotation.Nullable;
import okhttp3.ab;

/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class h extends ab {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f5114a;

    /* renamed from: b, reason: collision with root package name */
    private final long f5115b;
    private final b.e c;

    public h(@Nullable String str, long j, b.e eVar) {
        this.f5114a = str;
        this.f5115b = j;
        this.c = eVar;
    }

    @Override // okhttp3.ab
    public long a() {
        return this.f5115b;
    }

    @Override // okhttp3.ab
    public b.e b() {
        return this.c;
    }
}
