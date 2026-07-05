package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class app implements apv {

    /* renamed from: a, reason: collision with root package name */
    private int f2151a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final int f2152b;
    private final /* synthetic */ apo c;

    app(apo apoVar) {
        this.c = apoVar;
        this.f2152b = this.c.a();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2151a < this.f2152b;
    }

    @Override // com.google.android.gms.internal.ads.apv
    public final byte a() {
        try {
            apo apoVar = this.c;
            int i = this.f2151a;
            this.f2151a = i + 1;
            return apoVar.a(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Byte next() {
        return Byte.valueOf(a());
    }
}
