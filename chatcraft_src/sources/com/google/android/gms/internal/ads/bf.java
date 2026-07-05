package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public interface bf {
    View a(View.OnClickListener onClickListener, boolean z);

    void a(MotionEvent motionEvent);

    void a(View view);

    void a(View view, bd bdVar);

    void a(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2, boolean z);

    void a(View view, Map<String, WeakReference<View>> map);

    void a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2);

    void a(dv dvVar);

    boolean a();

    boolean a(Bundle bundle);

    void b(Bundle bundle);

    void b(View view);

    void b(View view, Map<String, WeakReference<View>> map);

    boolean b();

    void c(Bundle bundle);

    void c(View view);

    void c(View view, Map<String, WeakReference<View>> map);

    boolean c();

    void d();

    void e();

    void f();

    void g();

    void k();

    void l();

    void m();

    void n();

    View o();

    Context p();
}
