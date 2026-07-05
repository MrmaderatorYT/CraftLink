package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<e> f1102a = new Comparator<e>() { // from class: androidx.recyclerview.widget.f.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            int i = eVar.f1109a - eVar2.f1109a;
            return i == 0 ? eVar.f1110b - eVar2.f1110b : i;
        }
    };

    /* compiled from: DiffUtil.java */
    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i, int i2);

        public abstract int b();

        public abstract boolean b(int i, int i2);

        public Object c(int i, int i2) {
            return null;
        }
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        int iA = aVar.a();
        int iB = aVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new d(0, iA, 0, iB));
        int iAbs = Math.abs(iA - iB) + iA + iB;
        int i = iAbs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e eVarA = a(aVar, dVar.f1107a, dVar.f1108b, dVar.c, dVar.d, iArr, iArr2, iAbs);
            if (eVarA != null) {
                if (eVarA.c > 0) {
                    arrayList.add(eVarA);
                }
                eVarA.f1109a += dVar.f1107a;
                eVarA.f1110b += dVar.c;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.f1107a = dVar.f1107a;
                dVar2.c = dVar.c;
                if (eVarA.e) {
                    dVar2.f1108b = eVarA.f1109a;
                    dVar2.d = eVarA.f1110b;
                } else if (eVarA.d) {
                    dVar2.f1108b = eVarA.f1109a - 1;
                    dVar2.d = eVarA.f1110b;
                } else {
                    dVar2.f1108b = eVarA.f1109a;
                    dVar2.d = eVarA.f1110b - 1;
                }
                arrayList2.add(dVar2);
                if (eVarA.e) {
                    if (eVarA.d) {
                        dVar.f1107a = eVarA.f1109a + eVarA.c + 1;
                        dVar.c = eVarA.f1110b + eVarA.c;
                    } else {
                        dVar.f1107a = eVarA.f1109a + eVarA.c;
                        dVar.c = eVarA.f1110b + eVarA.c + 1;
                    }
                } else {
                    dVar.f1107a = eVarA.f1109a + eVarA.c;
                    dVar.c = eVarA.f1110b + eVarA.c;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, f1102a);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.recyclerview.widget.f.e a(androidx.recyclerview.widget.f.a r21, int r22, int r23, int r24, int r25, int[] r26, int[] r27, int r28) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.a(androidx.recyclerview.widget.f$a, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.f$e");
    }

    /* compiled from: DiffUtil.java */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        int f1109a;

        /* renamed from: b, reason: collision with root package name */
        int f1110b;
        int c;
        boolean d;
        boolean e;

        e() {
        }
    }

    /* compiled from: DiffUtil.java */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        int f1107a;

        /* renamed from: b, reason: collision with root package name */
        int f1108b;
        int c;
        int d;

        public d() {
        }

        public d(int i, int i2, int i3, int i4) {
            this.f1107a = i;
            this.f1108b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* compiled from: DiffUtil.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<e> f1103a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f1104b;
        private final int[] c;
        private final a d;
        private final int e;
        private final int f;
        private final boolean g;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.f1103a = list;
            this.f1104b = iArr;
            this.c = iArr2;
            Arrays.fill(this.f1104b, 0);
            Arrays.fill(this.c, 0);
            this.d = aVar;
            this.e = aVar.a();
            this.f = aVar.b();
            this.g = z;
            a();
            b();
        }

        private void a() {
            e eVar = this.f1103a.isEmpty() ? null : this.f1103a.get(0);
            if (eVar != null && eVar.f1109a == 0 && eVar.f1110b == 0) {
                return;
            }
            e eVar2 = new e();
            eVar2.f1109a = 0;
            eVar2.f1110b = 0;
            eVar2.d = false;
            eVar2.c = 0;
            eVar2.e = false;
            this.f1103a.add(0, eVar2);
        }

        private void b() {
            int i = this.e;
            int i2 = this.f;
            for (int size = this.f1103a.size() - 1; size >= 0; size--) {
                e eVar = this.f1103a.get(size);
                int i3 = eVar.f1109a + eVar.c;
                int i4 = eVar.f1110b + eVar.c;
                if (this.g) {
                    while (i > i3) {
                        a(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        b(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < eVar.c; i5++) {
                    int i6 = eVar.f1109a + i5;
                    int i7 = eVar.f1110b + i5;
                    int i8 = this.d.b(i6, i7) ? 1 : 2;
                    this.f1104b[i6] = (i7 << 5) | i8;
                    this.c[i7] = (i6 << 5) | i8;
                }
                i = eVar.f1109a;
                i2 = eVar.f1110b;
            }
        }

        private void a(int i, int i2, int i3) {
            if (this.f1104b[i - 1] != 0) {
                return;
            }
            a(i, i2, i3, false);
        }

        private void b(int i, int i2, int i3) {
            if (this.c[i2 - 1] != 0) {
                return;
            }
            a(i, i2, i3, true);
        }

        private boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                e eVar = this.f1103a.get(i3);
                int i7 = eVar.f1109a + eVar.c;
                int i8 = eVar.f1110b + eVar.c;
                if (z) {
                    for (int i9 = i4 - 1; i9 >= i7; i9--) {
                        if (this.d.a(i9, i5)) {
                            i6 = this.d.b(i9, i5) ? 8 : 4;
                            this.c[i5] = (i9 << 5) | 16;
                            this.f1104b[i9] = (i5 << 5) | i6;
                            return true;
                        }
                    }
                } else {
                    for (int i10 = i2 - 1; i10 >= i8; i10--) {
                        if (this.d.a(i5, i10)) {
                            i6 = this.d.b(i5, i10) ? 8 : 4;
                            int i11 = i - 1;
                            this.f1104b[i11] = (i10 << 5) | 16;
                            this.c[i10] = (i11 << 5) | i6;
                            return true;
                        }
                    }
                }
                i4 = eVar.f1109a;
                i2 = eVar.f1110b;
                i3--;
            }
            return false;
        }

        public void a(RecyclerView.a aVar) {
            a(new androidx.recyclerview.widget.b(aVar));
        }

        public void a(j jVar) {
            androidx.recyclerview.widget.c cVar;
            if (jVar instanceof androidx.recyclerview.widget.c) {
                cVar = (androidx.recyclerview.widget.c) jVar;
            } else {
                cVar = new androidx.recyclerview.widget.c(jVar);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.e;
            int i2 = this.f;
            for (int size = this.f1103a.size() - 1; size >= 0; size--) {
                e eVar = this.f1103a.get(size);
                int i3 = eVar.c;
                int i4 = eVar.f1109a + i3;
                int i5 = eVar.f1110b + i3;
                if (i4 < i) {
                    b(arrayList, cVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, cVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.f1104b[eVar.f1109a + i6] & 31) == 2) {
                        cVar.a(eVar.f1109a + i6, 1, this.d.c(eVar.f1109a + i6, eVar.f1110b + i6));
                    }
                }
                i = eVar.f1109a;
                i2 = eVar.f1110b;
            }
            cVar.a();
        }

        private static c a(List<c> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                c cVar = list.get(size);
                if (cVar.f1105a == i && cVar.c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f1106b += z ? 1 : -1;
                        size++;
                    }
                    return cVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<c> list, j jVar, int i, int i2, int i3) {
            if (!this.g) {
                jVar.a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.c[i5] & 31;
                if (i6 == 0) {
                    jVar.a(i, 1);
                    Iterator<c> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f1106b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.c[i5] >> 5;
                    jVar.c(a(list, i7, true).f1106b, i);
                    if (i6 == 4) {
                        jVar.a(i, 1, this.d.c(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new c(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }

        private void b(List<c> list, j jVar, int i, int i2, int i3) {
            if (!this.g) {
                jVar.b(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f1104b[i5] & 31;
                if (i6 == 0) {
                    jVar.b(i + i4, 1);
                    Iterator<c> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f1106b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f1104b[i5] >> 5;
                    c cVarA = a(list, i7, false);
                    jVar.c(i + i4, cVarA.f1106b - 1);
                    if (i6 == 4) {
                        jVar.a(cVarA.f1106b - 1, 1, this.d.c(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new c(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }
    }

    /* compiled from: DiffUtil.java */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        int f1105a;

        /* renamed from: b, reason: collision with root package name */
        int f1106b;
        boolean c;

        public c(int i, int i2, boolean z) {
            this.f1105a = i;
            this.f1106b = i2;
            this.c = z;
        }
    }
}
