package com.crashlytics.android.a;

import com.crashlytics.android.a.ab;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SamplingEventFilter.java */
/* loaded from: classes.dex */
class w implements n {

    /* renamed from: b, reason: collision with root package name */
    static final Set<ab.b> f1288b = new HashSet<ab.b>() { // from class: com.crashlytics.android.a.w.1
        {
            add(ab.b.START);
            add(ab.b.RESUME);
            add(ab.b.PAUSE);
            add(ab.b.STOP);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final int f1289a;

    public w(int i) {
        this.f1289a = i;
    }

    @Override // com.crashlytics.android.a.n
    public boolean a(ab abVar) {
        return (f1288b.contains(abVar.c) && abVar.f1241a.e == null) && (Math.abs(abVar.f1241a.c.hashCode() % this.f1289a) != 0);
    }
}
