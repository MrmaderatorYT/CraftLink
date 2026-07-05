package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.internal.connection.f;
import okhttp3.j;
import okhttp3.k;
import okhttp3.r;

/* compiled from: Internal.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f5084a;

    public abstract int a(aa.a aVar);

    public abstract Socket a(j jVar, okhttp3.a aVar, f fVar);

    public abstract okhttp3.internal.connection.c a(j jVar, okhttp3.a aVar, f fVar, ac acVar);

    public abstract okhttp3.internal.connection.d a(j jVar);

    public abstract void a(k kVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(r.a aVar, String str);

    public abstract void a(r.a aVar, String str, String str2);

    public abstract boolean a(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract boolean a(j jVar, okhttp3.internal.connection.c cVar);

    public abstract void b(j jVar, okhttp3.internal.connection.c cVar);
}
