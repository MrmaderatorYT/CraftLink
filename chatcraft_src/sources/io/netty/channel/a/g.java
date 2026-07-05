package io.netty.channel.a;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: SelectedSelectionKeySet.java */
/* loaded from: classes.dex */
final class g extends AbstractSet<SelectionKey> {

    /* renamed from: b, reason: collision with root package name */
    private int f4448b;
    private int d;
    private boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private SelectionKey[] f4447a = new SelectionKey[1024];
    private SelectionKey[] c = (SelectionKey[]) this.f4447a.clone();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return false;
    }

    g() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        if (this.e) {
            int i = this.f4448b;
            int i2 = i + 1;
            this.f4447a[i] = selectionKey;
            this.f4448b = i2;
            if (i2 != this.f4447a.length) {
                return true;
            }
            b();
            return true;
        }
        int i3 = this.d;
        int i4 = i3 + 1;
        this.c[i3] = selectionKey;
        this.d = i4;
        if (i4 != this.c.length) {
            return true;
        }
        c();
        return true;
    }

    private void b() {
        SelectionKey[] selectionKeyArr = new SelectionKey[this.f4447a.length << 1];
        System.arraycopy(this.f4447a, 0, selectionKeyArr, 0, this.f4448b);
        this.f4447a = selectionKeyArr;
    }

    private void c() {
        SelectionKey[] selectionKeyArr = new SelectionKey[this.c.length << 1];
        System.arraycopy(this.c, 0, selectionKeyArr, 0, this.d);
        this.c = selectionKeyArr;
    }

    SelectionKey[] a() {
        if (this.e) {
            this.e = false;
            this.f4447a[this.f4448b] = null;
            this.d = 0;
            return this.f4447a;
        }
        this.e = true;
        this.c[this.d] = null;
        this.f4448b = 0;
        return this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.e) {
            return this.f4448b;
        }
        return this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<SelectionKey> iterator() {
        throw new UnsupportedOperationException();
    }
}
