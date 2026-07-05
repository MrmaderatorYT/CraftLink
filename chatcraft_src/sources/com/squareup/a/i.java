package com.squareup.a;

import android.os.Looper;

/* compiled from: ThreadEnforcer.java */
/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f4096a = new i() { // from class: com.squareup.a.i.1
        @Override // com.squareup.a.i
        public void a(b bVar) {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final i f4097b = new i() { // from class: com.squareup.a.i.2
        @Override // com.squareup.a.i
        public void a(b bVar) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            throw new IllegalStateException("Event bus " + bVar + " accessed from non-main thread " + Looper.myLooper());
        }
    };

    void a(b bVar);
}
