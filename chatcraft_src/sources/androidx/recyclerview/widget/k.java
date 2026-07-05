package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    final a f1126a;

    /* compiled from: OpReorderer.java */
    interface a {
        a.b a(int i, int i2, int i3, Object obj);

        void a(a.b bVar);
    }

    k(a aVar) {
        this.f1126a = aVar;
    }

    void a(List<a.b> list) {
        while (true) {
            int iB = b(list);
            if (iB == -1) {
                return;
            } else {
                a(list, iB, iB + 1);
            }
        }
    }

    private void a(List<a.b> list, int i, int i2) {
        a.b bVar = list.get(i);
        a.b bVar2 = list.get(i2);
        int i3 = bVar2.f1071a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    c(list, i, bVar, i2, bVar2);
                    break;
                case 2:
                    a(list, i, bVar, i2, bVar2);
                    break;
            }
        }
        b(list, i, bVar, i2, bVar2);
    }

    void a(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.f1072b < bVar.d) {
            if (bVar2.f1072b == bVar.f1072b && bVar2.d == bVar.d - bVar.f1072b) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f1072b == bVar.d + 1 && bVar2.d == bVar.f1072b - bVar.d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.d < bVar2.f1072b) {
            bVar2.f1072b--;
        } else if (bVar.d < bVar2.f1072b + bVar2.d) {
            bVar2.d--;
            bVar.f1071a = 2;
            bVar.d = 1;
            if (bVar2.d == 0) {
                list.remove(i2);
                this.f1126a.a(bVar2);
                return;
            }
            return;
        }
        a.b bVarA = null;
        if (bVar.f1072b <= bVar2.f1072b) {
            bVar2.f1072b++;
        } else if (bVar.f1072b < bVar2.f1072b + bVar2.d) {
            bVarA = this.f1126a.a(2, bVar.f1072b + 1, (bVar2.f1072b + bVar2.d) - bVar.f1072b, null);
            bVar2.d = bVar.f1072b - bVar2.f1072b;
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.f1126a.a(bVar);
            return;
        }
        if (z) {
            if (bVarA != null) {
                if (bVar.f1072b > bVarA.f1072b) {
                    bVar.f1072b -= bVarA.d;
                }
                if (bVar.d > bVarA.f1072b) {
                    bVar.d -= bVarA.d;
                }
            }
            if (bVar.f1072b > bVar2.f1072b) {
                bVar.f1072b -= bVar2.d;
            }
            if (bVar.d > bVar2.f1072b) {
                bVar.d -= bVar2.d;
            }
        } else {
            if (bVarA != null) {
                if (bVar.f1072b >= bVarA.f1072b) {
                    bVar.f1072b -= bVarA.d;
                }
                if (bVar.d >= bVarA.f1072b) {
                    bVar.d -= bVarA.d;
                }
            }
            if (bVar.f1072b >= bVar2.f1072b) {
                bVar.f1072b -= bVar2.d;
            }
            if (bVar.d >= bVar2.f1072b) {
                bVar.d -= bVar2.d;
            }
        }
        list.set(i, bVar2);
        if (bVar.f1072b != bVar.d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    private void c(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        int i3 = bVar.d < bVar2.f1072b ? -1 : 0;
        if (bVar.f1072b < bVar2.f1072b) {
            i3++;
        }
        if (bVar2.f1072b <= bVar.f1072b) {
            bVar.f1072b += bVar2.d;
        }
        if (bVar2.f1072b <= bVar.d) {
            bVar.d += bVar2.d;
        }
        bVar2.f1072b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b(java.util.List<androidx.recyclerview.widget.a.b> r8, int r9, androidx.recyclerview.widget.a.b r10, int r11, androidx.recyclerview.widget.a.b r12) {
        /*
            r7 = this;
            int r0 = r10.d
            int r1 = r12.f1072b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.f1072b
            int r0 = r0 - r4
            r12.f1072b = r0
            goto L28
        Lf:
            int r0 = r10.d
            int r1 = r12.f1072b
            int r5 = r12.d
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.d
            int r0 = r0 - r4
            r12.d = r0
            androidx.recyclerview.widget.k$a r0 = r7.f1126a
            int r1 = r10.f1072b
            java.lang.Object r5 = r12.c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.f1072b
            int r5 = r12.f1072b
            if (r1 > r5) goto L35
            int r1 = r12.f1072b
            int r1 = r1 + r4
            r12.f1072b = r1
            goto L56
        L35:
            int r1 = r10.f1072b
            int r5 = r12.f1072b
            int r6 = r12.d
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.f1072b
            int r3 = r12.d
            int r1 = r1 + r3
            int r3 = r10.f1072b
            int r1 = r1 - r3
            androidx.recyclerview.widget.k$a r3 = r7.f1126a
            int r5 = r10.f1072b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.c
            androidx.recyclerview.widget.a$b r3 = r3.a(r2, r5, r1, r4)
            int r2 = r12.d
            int r2 = r2 - r1
            r12.d = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.d
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            androidx.recyclerview.widget.k$a r10 = r7.f1126a
            r10.a(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.b(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    private int b(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1071a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
