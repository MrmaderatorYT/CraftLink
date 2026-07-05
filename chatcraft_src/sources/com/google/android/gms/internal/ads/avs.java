package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class avs implements ack, Closeable, Iterator<abj> {
    private static final abj f = new avt("eof ");
    private static awb g = awb.a(avs.class);

    /* renamed from: a, reason: collision with root package name */
    protected yg f2325a;

    /* renamed from: b, reason: collision with root package name */
    protected avv f2326b;
    private abj h = null;
    long c = 0;
    long d = 0;
    long e = 0;
    private List<abj> i = new ArrayList();

    public final List<abj> b() {
        if (this.f2326b != null && this.h != f) {
            return new avz(this.i, this);
        }
        return this.i;
    }

    public void a(avv avvVar, long j, yg ygVar) {
        this.f2326b = avvVar;
        long jB = avvVar.b();
        this.d = jB;
        this.c = jB;
        avvVar.a(avvVar.b() + j);
        this.e = avvVar.b();
        this.f2325a = ygVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.h == f) {
            return false;
        }
        if (this.h != null) {
            return true;
        }
        try {
            this.h = (abj) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.h = f;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final abj next() {
        abj abjVarA;
        if (this.h != null && this.h != f) {
            abj abjVar = this.h;
            this.h = null;
            return abjVar;
        }
        if (this.f2326b == null || this.c >= this.e) {
            this.h = f;
            throw new NoSuchElementException();
        }
        try {
            synchronized (this.f2326b) {
                this.f2326b.a(this.c);
                abjVarA = this.f2325a.a(this.f2326b, this);
                this.c = this.f2326b.b();
            }
            return abjVarA;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.i.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.i.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2326b.close();
    }
}
