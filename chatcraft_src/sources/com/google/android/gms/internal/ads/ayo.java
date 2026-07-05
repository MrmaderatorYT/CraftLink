package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class ayo implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final axt f2408a;

    /* renamed from: b, reason: collision with root package name */
    private final akp f2409b;

    public ayo(axt axtVar, akp akpVar) {
        this.f2408a = axtVar;
        this.f2409b = akpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Void call() throws ExecutionException, InterruptedException {
        if (this.f2408a.l() != null) {
            this.f2408a.l().get();
        }
        akp akpVarK = this.f2408a.k();
        if (akpVarK == null) {
            return null;
        }
        try {
            synchronized (this.f2409b) {
                aus.a(this.f2409b, aus.a(akpVarK));
            }
            return null;
        } catch (zzbuy unused) {
            return null;
        }
    }
}
