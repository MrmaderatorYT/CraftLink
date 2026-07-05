package io.fabric.sdk.android.services.d;

import android.content.Context;
import io.fabric.sdk.android.h;
import java.io.File;

/* compiled from: FileStoreImpl.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4289a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4290b;
    private final String c;

    public b(h hVar) {
        if (hVar.r() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f4289a = hVar.r();
        this.f4290b = hVar.t();
        this.c = "Android/" + this.f4289a.getPackageName();
    }

    @Override // io.fabric.sdk.android.services.d.a
    public File a() {
        return a(this.f4289a.getFilesDir());
    }

    File a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            io.fabric.sdk.android.c.g().d("Fabric", "Couldn't create file");
            return null;
        }
        io.fabric.sdk.android.c.g().a("Fabric", "Null File");
        return null;
    }
}
