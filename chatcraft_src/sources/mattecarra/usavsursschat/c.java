package mattecarra.usavsursschat;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: CircularFifoQueue.java */
/* loaded from: classes.dex */
public class c<E> extends AbstractCollection<E> implements Serializable, Queue<E> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4932a;

    /* renamed from: b, reason: collision with root package name */
    private transient E[] f4933b;
    private transient int c;
    private transient int d;
    private transient boolean e;

    public c() {
        this(32);
    }

    public c(int i) {
        this.c = 0;
        this.d = 0;
        this.e = false;
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.f4933b = (E[]) new Object[i];
        this.f4932a = this.f4933b.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        if (this.d < this.c) {
            return (this.f4932a - this.c) + this.d;
        }
        if (this.d == this.c) {
            if (this.e) {
                return this.f4932a;
            }
            return 0;
        }
        return this.d - this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean a() {
        return size() == this.f4932a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.e = false;
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.f4933b, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (a()) {
            remove();
        }
        E[] eArr = this.f4933b;
        int i = this.d;
        this.d = i + 1;
        eArr[i] = e;
        if (this.d >= this.f4932a) {
            this.d = 0;
        }
        if (this.d == this.c) {
            this.e = true;
        }
        return true;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f4933b[this.c];
    }

    @Override // java.util.Queue
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E e = this.f4933b[this.c];
        if (e != null) {
            E[] eArr = this.f4933b;
            int i = this.c;
            this.c = i + 1;
            eArr[i] = null;
            if (this.c >= this.f4932a) {
                this.c = 0;
            }
            this.e = false;
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        int i2 = i + 1;
        if (i2 >= this.f4932a) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.f4932a - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: mattecarra.usavsursschat.c.1

            /* renamed from: b, reason: collision with root package name */
            private int f4935b;
            private int c = -1;
            private boolean d;

            {
                this.f4935b = c.this.c;
                this.d = c.this.e;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.d || this.f4935b != c.this.d;
            }

            @Override // java.util.Iterator
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.d = false;
                this.c = this.f4935b;
                this.f4935b = c.this.a(this.f4935b);
                return (E) c.this.f4933b[this.c];
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.c != -1) {
                    if (this.c == c.this.c) {
                        c.this.remove();
                        this.c = -1;
                        return;
                    }
                    int iA = this.c + 1;
                    if (c.this.c >= this.c || iA >= c.this.d) {
                        while (iA != c.this.d) {
                            if (iA >= c.this.f4932a) {
                                c.this.f4933b[iA - 1] = c.this.f4933b[0];
                                iA = 0;
                            } else {
                                c.this.f4933b[c.this.b(iA)] = c.this.f4933b[iA];
                                iA = c.this.a(iA);
                            }
                        }
                    } else {
                        System.arraycopy(c.this.f4933b, iA, c.this.f4933b, this.c, c.this.d - iA);
                    }
                    this.c = -1;
                    c.this.d = c.this.b(c.this.d);
                    c.this.f4933b[c.this.d] = null;
                    c.this.e = false;
                    this.f4935b = c.this.b(this.f4935b);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
