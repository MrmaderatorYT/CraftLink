package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class g<E> extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f729a;

    /* renamed from: b, reason: collision with root package name */
    final i f730b;
    private final Context c;
    private final Handler d;
    private final int e;

    @Override // androidx.fragment.app.e
    public View a(int i) {
        return null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.e
    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    void b(Fragment fragment) {
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    g(d dVar) {
        this(dVar, dVar, dVar.f722a, 0);
    }

    g(Activity activity, Context context, Handler handler, int i) {
        this.f730b = new i();
        this.f729a = activity;
        this.c = (Context) androidx.core.f.e.a(context, "context == null");
        this.d = (Handler) androidx.core.f.e.a(handler, "handler == null");
        this.e = i;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.c);
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.c.startActivity(intent);
    }

    public int e() {
        return this.e;
    }

    Activity f() {
        return this.f729a;
    }

    Context g() {
        return this.c;
    }

    Handler h() {
        return this.d;
    }

    i i() {
        return this.f730b;
    }
}
