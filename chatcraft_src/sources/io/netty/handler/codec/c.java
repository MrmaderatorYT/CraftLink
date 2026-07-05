package io.netty.handler.codec;

import io.netty.util.a.j;
import io.netty.util.l;
import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: CodecOutputList.java */
/* loaded from: classes.dex */
final class c extends AbstractList<Object> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final l<c> f4570a = new l<c>() { // from class: io.netty.handler.codec.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b(l.b<c> bVar) {
            return new c(bVar);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final l.b<c> f4571b;
    private int c;
    private Object[] d;
    private boolean e;

    static c a() {
        return f4570a.a();
    }

    private c(l.b<c> bVar) {
        this.d = new Object[16];
        this.f4571b = bVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        b(i);
        return this.d[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        j.a(obj, "element");
        try {
            a(this.c, obj);
        } catch (IndexOutOfBoundsException unused) {
            d();
            a(this.c, obj);
        }
        this.c++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        j.a(obj, "element");
        b(i);
        Object obj2 = this.d[i];
        a(i, obj);
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        j.a(obj, "element");
        b(i);
        if (this.c == this.d.length) {
            d();
        }
        if (i != this.c - 1) {
            System.arraycopy(this.d, i, this.d, i + 1, this.c - i);
        }
        a(i, obj);
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        b(i);
        Object obj = this.d[i];
        int i2 = (this.c - i) - 1;
        if (i2 > 0) {
            System.arraycopy(this.d, i + 1, this.d, i, i2);
        }
        Object[] objArr = this.d;
        int i3 = this.c - 1;
        this.c = i3;
        objArr[i3] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.c = 0;
    }

    boolean b() {
        return this.e;
    }

    void c() {
        for (int i = 0; i < this.c; i++) {
            this.d[i] = null;
        }
        clear();
        this.e = false;
        this.f4571b.a(this);
    }

    Object a(int i) {
        return this.d[i];
    }

    private void b(int i) {
        if (i >= this.c) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void a(int i, Object obj) {
        this.d[i] = obj;
        this.e = true;
    }

    private void d() {
        int length = this.d.length << 1;
        if (length < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = new Object[length];
        System.arraycopy(this.d, 0, objArr, 0, this.d.length);
        this.d = objArr;
    }
}
