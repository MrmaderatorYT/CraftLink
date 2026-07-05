package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.b;
import io.fabric.sdk.android.services.concurrency.i;
import io.fabric.sdk.android.services.concurrency.l;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue.java */
/* loaded from: classes.dex */
public class c<E extends b & l & i> extends PriorityBlockingQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    final Queue<E> f4275a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantLock f4276b = new ReentrantLock();

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public E take() {
        return (E) b(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public E peek() {
        try {
            return (E) b(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public E poll(long j, TimeUnit timeUnit) {
        return (E) b(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public E poll() {
        try {
            return (E) b(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.f4276b.lock();
            return this.f4275a.size() + super.size();
        } finally {
            this.f4276b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.f4276b.lock();
            return (T[]) a(super.toArray(tArr), this.f4275a.toArray(tArr));
        } finally {
            this.f4276b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.f4276b.lock();
            return a(super.toArray(), this.f4275a.toArray());
        } finally {
            this.f4276b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.f4276b.lock();
            int iDrainTo = super.drainTo(collection) + this.f4275a.size();
            while (!this.f4275a.isEmpty()) {
                collection.add(this.f4275a.poll());
            }
            return iDrainTo;
        } finally {
            this.f4276b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f4276b.lock();
            int iDrainTo = super.drainTo(collection, i);
            while (!this.f4275a.isEmpty() && iDrainTo <= i) {
                collection.add(this.f4275a.poll());
                iDrainTo++;
            }
            return iDrainTo;
        } finally {
            this.f4276b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean contains(java.lang.Object r2) {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b     // Catch: java.lang.Throwable -> L1d
            r0.lock()     // Catch: java.lang.Throwable -> L1d
            boolean r0 = super.contains(r2)     // Catch: java.lang.Throwable -> L1d
            if (r0 != 0) goto L16
            java.util.Queue<E extends io.fabric.sdk.android.services.concurrency.b & io.fabric.sdk.android.services.concurrency.l & io.fabric.sdk.android.services.concurrency.i> r0 = r1.f4275a     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L14
            goto L16
        L14:
            r2 = 0
            goto L17
        L16:
            r2 = 1
        L17:
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b
            r0.unlock()
            return r2
        L1d:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.c.contains(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.f4276b.lock();
            this.f4275a.clear();
            super.clear();
        } finally {
            this.f4276b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.Object r2) {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b     // Catch: java.lang.Throwable -> L1d
            r0.lock()     // Catch: java.lang.Throwable -> L1d
            boolean r0 = super.remove(r2)     // Catch: java.lang.Throwable -> L1d
            if (r0 != 0) goto L16
            java.util.Queue<E extends io.fabric.sdk.android.services.concurrency.b & io.fabric.sdk.android.services.concurrency.l & io.fabric.sdk.android.services.concurrency.i> r0 = r1.f4275a     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r0.remove(r2)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L14
            goto L16
        L14:
            r2 = 0
            goto L17
        L16:
            r2 = 1
        L17:
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b
            r0.unlock()
            return r2
        L1d:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantLock r0 = r1.f4276b
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.c.remove(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.f4276b.lock();
            return this.f4275a.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.f4276b.unlock();
        }
    }

    E a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (E) ((b) super.take());
            case 1:
                return (E) ((b) super.peek());
            case 2:
                return (E) ((b) super.poll());
            case 3:
                return (E) ((b) super.poll(l.longValue(), timeUnit));
            default:
                return null;
        }
    }

    boolean a(int i, E e) {
        try {
            this.f4276b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.f4275a.offer(e);
        } finally {
            this.f4276b.unlock();
        }
    }

    E b(int i, Long l, TimeUnit timeUnit) {
        E e;
        while (true) {
            e = (E) a(i, l, timeUnit);
            if (e == null || a(e)) {
                break;
            }
            a(i, (int) e);
        }
        return e;
    }

    boolean a(E e) {
        return e.d();
    }

    public void d() {
        try {
            this.f4276b.lock();
            Iterator<E> it = this.f4275a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.f4276b.unlock();
        }
    }

    <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
