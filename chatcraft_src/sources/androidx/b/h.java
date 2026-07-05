package androidx.b;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f473a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f474b;
    private int[] c;
    private Object[] d;
    private int e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.f474b = false;
        if (i == 0) {
            this.c = c.f458a;
            this.d = c.c;
        } else {
            int iA = c.a(i);
            this.c = new int[iA];
            this.d = new Object[iA];
        }
        this.e = 0;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.c = (int[]) this.c.clone();
            hVar.d = (Object[]) this.d.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e) {
        int iA = c.a(this.c, this.e, i);
        return (iA < 0 || this.d[iA] == f473a) ? e : (E) this.d[iA];
    }

    public void b(int i) {
        int iA = c.a(this.c, this.e, i);
        if (iA < 0 || this.d[iA] == f473a) {
            return;
        }
        this.d[iA] = f473a;
        this.f474b = true;
    }

    public void c(int i) {
        b(i);
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f473a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f474b = false;
        this.e = i2;
    }

    public void b(int i, E e) {
        int iA = c.a(this.c, this.e, i);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == f473a) {
            this.c[iA2] = i;
            this.d[iA2] = e;
            return;
        }
        if (this.f474b && this.e >= this.c.length) {
            d();
            iA2 = c.a(this.c, this.e, i) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iA3 = c.a(this.e + 1);
            int[] iArr = new int[iA3];
            Object[] objArr = new Object[iA3];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            int i2 = iA2 + 1;
            System.arraycopy(this.c, iA2, this.c, i2, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, i2, this.e - iA2);
        }
        this.c[iA2] = i;
        this.d[iA2] = e;
        this.e++;
    }

    public int b() {
        if (this.f474b) {
            d();
        }
        return this.e;
    }

    public int d(int i) {
        if (this.f474b) {
            d();
        }
        return this.c[i];
    }

    public E e(int i) {
        if (this.f474b) {
            d();
        }
        return (E) this.d[i];
    }

    public int f(int i) {
        if (this.f474b) {
            d();
        }
        return c.a(this.c, this.e, i);
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f474b = false;
    }

    public void c(int i, E e) {
        if (this.e != 0 && i <= this.c[this.e - 1]) {
            b(i, e);
            return;
        }
        if (this.f474b && this.e >= this.c.length) {
            d();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int iA = c.a(i2 + 1);
            int[] iArr = new int[iA];
            Object[] objArr = new Object[iA];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e = i2 + 1;
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
            sb.append(d(i));
            sb.append('=');
            E e = e(i);
            if (e != this) {
                sb.append(e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
