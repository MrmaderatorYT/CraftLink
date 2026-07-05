package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import okhttp3.e;
import okhttp3.v;

/* compiled from: OkHttp3Downloader.java */
/* loaded from: classes.dex */
public final class s implements j {

    /* renamed from: a, reason: collision with root package name */
    final e.a f4149a;

    /* renamed from: b, reason: collision with root package name */
    private final okhttp3.c f4150b;
    private boolean c;

    public s(Context context) {
        this(ad.a(context));
    }

    public s(File file) {
        this(file, ad.a(file));
    }

    public s(File file, long j) {
        this(new v.a().a(new okhttp3.c(file, j)).a());
        this.c = false;
    }

    public s(okhttp3.v vVar) {
        this.c = true;
        this.f4149a = vVar;
        this.f4150b = vVar.h();
    }

    @Override // com.squareup.picasso.j
    public okhttp3.aa a(okhttp3.y yVar) {
        return this.f4149a.a(yVar).a();
    }
}
