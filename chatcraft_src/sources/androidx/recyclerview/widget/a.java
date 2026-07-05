package androidx.recyclerview.widget;

import androidx.core.f.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
class a implements k.a {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<b> f1069a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1070b;
    final InterfaceC0055a c;
    Runnable d;
    final boolean e;
    final k f;
    private d.a<b> g;
    private int h;

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0055a {
        RecyclerView.x a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    a(InterfaceC0055a interfaceC0055a) {
        this(interfaceC0055a, false);
    }

    a(InterfaceC0055a interfaceC0055a, boolean z) {
        this.g = new d.b(30);
        this.f1069a = new ArrayList<>();
        this.f1070b = new ArrayList<>();
        this.h = 0;
        this.c = interfaceC0055a;
        this.e = z;
        this.f = new k(this);
    }

    void a() {
        a(this.f1069a);
        a(this.f1070b);
        this.h = 0;
    }

    void b() {
        this.f.a(this.f1069a);
        int size = this.f1069a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1069a.get(i);
            int i2 = bVar.f1071a;
            if (i2 == 4) {
                d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.f1069a.clear();
    }

    void c() {
        int size = this.f1070b.size();
        for (int i = 0; i < size; i++) {
            this.c.b(this.f1070b.get(i));
        }
        a(this.f1070b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        char c;
        int i = bVar.f1072b;
        int i2 = bVar.f1072b + bVar.d;
        int i3 = bVar.f1072b;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.c.a(i3) != null || d(i3)) {
                if (c2 == 0) {
                    e(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    g(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.f1072b;
        int i2 = bVar.f1072b + bVar.d;
        char c = 65535;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.f1072b; i5 < i2; i5++) {
            if (this.c.a(i5) != null || d(i5)) {
                if (c == 0) {
                    e(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    g(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void e(b bVar) {
        int i;
        if (bVar.f1071a == 1 || bVar.f1071a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iD = d(bVar.f1072b, bVar.f1071a);
        int i2 = bVar.f1072b;
        int i3 = bVar.f1071a;
        if (i3 == 2) {
            i = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i4 = iD;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d; i7++) {
            int iD2 = d(bVar.f1072b + (i * i7), bVar.f1071a);
            int i8 = bVar.f1071a;
            if (i8 == 2 ? iD2 == i4 : i8 == 4 && iD2 == i4 + 1) {
                i6++;
            } else {
                b bVarA = a(bVar.f1071a, i4, i6, bVar.c);
                a(bVarA, i5);
                a(bVarA);
                if (bVar.f1071a == 4) {
                    i5 += i6;
                }
                i4 = iD2;
                i6 = 1;
            }
        }
        Object obj = bVar.c;
        a(bVar);
        if (i6 > 0) {
            b bVarA2 = a(bVar.f1071a, i4, i6, obj);
            a(bVarA2, i5);
            a(bVarA2);
        }
    }

    void a(b bVar, int i) {
        this.c.a(bVar);
        int i2 = bVar.f1071a;
        if (i2 == 2) {
            this.c.a(i, bVar.d);
        } else {
            if (i2 == 4) {
                this.c.a(i, bVar.d, bVar.c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int d(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f1070b.size() - 1; size >= 0; size--) {
            b bVar = this.f1070b.get(size);
            if (bVar.f1071a == 8) {
                if (bVar.f1072b < bVar.d) {
                    i3 = bVar.f1072b;
                    i4 = bVar.d;
                } else {
                    i3 = bVar.d;
                    i4 = bVar.f1072b;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.f1072b) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f1072b++;
                        } else if (i2 == 2) {
                            bVar.f1072b--;
                        }
                        i--;
                    }
                } else if (i < bVar.f1072b) {
                    if (i2 == 1) {
                        bVar.f1072b++;
                        bVar.d++;
                    } else if (i2 == 2) {
                        bVar.f1072b--;
                        bVar.d--;
                    }
                }
            } else if (bVar.f1072b <= i) {
                if (bVar.f1071a == 1) {
                    i -= bVar.d;
                } else if (bVar.f1071a == 2) {
                    i += bVar.d;
                }
            } else if (i2 == 1) {
                bVar.f1072b++;
            } else if (i2 == 2) {
                bVar.f1072b--;
            }
        }
        for (int size2 = this.f1070b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1070b.get(size2);
            if (bVar2.f1071a == 8) {
                if (bVar2.d == bVar2.f1072b || bVar2.d < 0) {
                    this.f1070b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.f1070b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.f1070b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1070b.get(i2);
            if (bVar.f1071a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f1071a == 1) {
                int i3 = bVar.f1072b + bVar.d;
                for (int i4 = bVar.f1072b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f1070b.add(bVar);
        int i = bVar.f1071a;
        if (i == 4) {
            this.c.a(bVar.f1072b, bVar.d, bVar.c);
            return;
        }
        if (i != 8) {
            switch (i) {
                case 1:
                    this.c.c(bVar.f1072b, bVar.d);
                    return;
                case 2:
                    this.c.b(bVar.f1072b, bVar.d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        }
        this.c.d(bVar.f1072b, bVar.d);
    }

    boolean d() {
        return this.f1069a.size() > 0;
    }

    boolean a(int i) {
        return (i & this.h) != 0;
    }

    int b(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.f1070b.size();
        while (i2 < size) {
            b bVar = this.f1070b.get(i2);
            if (bVar.f1071a == 8) {
                if (bVar.f1072b == i) {
                    i = bVar.d;
                } else {
                    if (bVar.f1072b < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f1072b > i) {
                continue;
            } else if (bVar.f1071a == 2) {
                if (i < bVar.f1072b + bVar.d) {
                    return -1;
                }
                i -= bVar.d;
            } else if (bVar.f1071a == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f1069a.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.f1069a.size() == 1;
    }

    boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1069a.add(a(1, i, i2, null));
        this.h |= 1;
        return this.f1069a.size() == 1;
    }

    boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1069a.add(a(2, i, i2, null));
        this.h |= 2;
        return this.f1069a.size() == 1;
    }

    boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f1069a.add(a(8, i, i2, null));
        this.h |= 8;
        return this.f1069a.size() == 1;
    }

    void e() {
        c();
        int size = this.f1069a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1069a.get(i);
            int i2 = bVar.f1071a;
            if (i2 == 4) {
                this.c.b(bVar);
                this.c.a(bVar.f1072b, bVar.d, bVar.c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.c.b(bVar);
                        this.c.c(bVar.f1072b, bVar.d);
                        break;
                    case 2:
                        this.c.b(bVar);
                        this.c.a(bVar.f1072b, bVar.d);
                        break;
                }
            } else {
                this.c.b(bVar);
                this.c.d(bVar.f1072b, bVar.d);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.f1069a);
        this.h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r0 = r5.f1069a
            int r0 = r0.size()
            r1 = 0
        L7:
            if (r1 >= r0) goto L4a
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r5.f1069a
            java.lang.Object r2 = r2.get(r1)
            androidx.recyclerview.widget.a$b r2 = (androidx.recyclerview.widget.a.b) r2
            int r3 = r2.f1071a
            r4 = 8
            if (r3 == r4) goto L34
            switch(r3) {
                case 1: goto L2c;
                case 2: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L47
        L1b:
            int r3 = r2.f1072b
            if (r3 > r6) goto L47
            int r3 = r2.f1072b
            int r4 = r2.d
            int r3 = r3 + r4
            if (r3 <= r6) goto L28
            r6 = -1
            return r6
        L28:
            int r2 = r2.d
            int r6 = r6 - r2
            goto L47
        L2c:
            int r3 = r2.f1072b
            if (r3 > r6) goto L47
            int r2 = r2.d
            int r6 = r6 + r2
            goto L47
        L34:
            int r3 = r2.f1072b
            if (r3 != r6) goto L3b
            int r6 = r2.d
            goto L47
        L3b:
            int r3 = r2.f1072b
            if (r3 >= r6) goto L41
            int r6 = r6 + (-1)
        L41:
            int r2 = r2.d
            if (r2 > r6) goto L47
            int r6 = r6 + 1
        L47:
            int r1 = r1 + 1
            goto L7
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.c(int):int");
    }

    boolean f() {
        return (this.f1070b.isEmpty() || this.f1069a.isEmpty()) ? false : true;
    }

    /* compiled from: AdapterHelper.java */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f1071a;

        /* renamed from: b, reason: collision with root package name */
        int f1072b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.f1071a = i;
            this.f1072b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.f1071a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1072b + "c:" + this.d + ",p:" + this.c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1071a != bVar.f1071a) {
                return false;
            }
            if (this.f1071a == 8 && Math.abs(this.d - this.f1072b) == 1 && this.d == bVar.f1072b && this.f1072b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f1072b != bVar.f1072b) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1071a * 31) + this.f1072b) * 31) + this.d;
        }
    }

    @Override // androidx.recyclerview.widget.k.a
    public b a(int i, int i2, int i3, Object obj) {
        b bVarA = this.g.a();
        if (bVarA == null) {
            return new b(i, i2, i3, obj);
        }
        bVarA.f1071a = i;
        bVarA.f1072b = i2;
        bVarA.d = i3;
        bVarA.c = obj;
        return bVarA;
    }

    @Override // androidx.recyclerview.widget.k.a
    public void a(b bVar) {
        if (this.e) {
            return;
        }
        bVar.c = null;
        this.g.a(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
