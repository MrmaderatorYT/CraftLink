package androidx.b;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f460a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f461b;
    private long[] c;
    private Object[] d;
    private int e;

    public d() {
        this(10);
    }

    public d(int i) {
        this.f461b = false;
        if (i == 0) {
            this.c = c.f459b;
            this.d = c.c;
        } else {
            int iB = c.b(i);
            this.c = new long[iB];
            this.d = new Object[iB];
        }
        this.e = 0;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.c = (long[]) this.c.clone();
            dVar.d = (Object[]) this.d.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E a(long j) {
        return a(j, null);
    }

    public E a(long j, E e) {
        int iA = c.a(this.c, this.e, j);
        return (iA < 0 || this.d[iA] == f460a) ? e : (E) this.d[iA];
    }

    public void b(long j) {
        int iA = c.a(this.c, this.e, j);
        if (iA < 0 || this.d[iA] == f460a) {
            return;
        }
        this.d[iA] = f460a;
        this.f461b = true;
    }

    public void a(int i) {
        if (this.d[i] != f460a) {
            this.d[i] = f460a;
            this.f461b = true;
        }
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f460a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f461b = false;
        this.e = i2;
    }

    public void b(long j, E e) {
        int iA = c.a(this.c, this.e, j);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == f460a) {
            this.c[iA2] = j;
            this.d[iA2] = e;
            return;
        }
        if (this.f461b && this.e >= this.c.length) {
            d();
            iA2 = c.a(this.c, this.e, j) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iB = c.b(this.e + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            int i = iA2 + 1;
            System.arraycopy(this.c, iA2, this.c, i, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, i, this.e - iA2);
        }
        this.c[iA2] = j;
        this.d[iA2] = e;
        this.e++;
    }

    public int b() {
        if (this.f461b) {
            d();
        }
        return this.e;
    }

    public long b(int i) {
        if (this.f461b) {
            d();
        }
        return this.c[i];
    }

    public E c(int i) {
        if (this.f461b) {
            d();
        }
        return (E) this.d[i];
    }

    public int c(long j) {
        if (this.f461b) {
            d();
        }
        return c.a(this.c, this.e, j);
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f461b = false;
    }

    public void c(long j, E e) {
        if (this.e != 0 && j <= this.c[this.e - 1]) {
            b(j, e);
            return;
        }
        if (this.f461b && this.e >= this.c.length) {
            d();
        }
        int i = this.e;
        if (i >= this.c.length) {
            int iB = c.b(i + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e = i + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            E eC = c(i);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
