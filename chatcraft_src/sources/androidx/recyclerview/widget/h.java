package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    static final ThreadLocal<h> f1118a = new ThreadLocal<>();
    static Comparator<b> e = new Comparator<b>() { // from class: androidx.recyclerview.widget.h.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if ((bVar.d == null) != (bVar2.d == null)) {
                return bVar.d == null ? 1 : -1;
            }
            if (bVar.f1122a != bVar2.f1122a) {
                return bVar.f1122a ? -1 : 1;
            }
            int i = bVar2.f1123b - bVar.f1123b;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.c - bVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long c;
    long d;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f1119b = new ArrayList<>();
    private ArrayList<b> f = new ArrayList<>();

    h() {
    }

    /* compiled from: GapWorker.java */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1122a;

        /* renamed from: b, reason: collision with root package name */
        public int f1123b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f1122a = false;
            this.f1123b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    /* compiled from: GapWorker.java */
    static class a implements RecyclerView.i.a {

        /* renamed from: a, reason: collision with root package name */
        int f1120a;

        /* renamed from: b, reason: collision with root package name */
        int f1121b;
        int[] c;
        int d;

        a() {
        }

        void a(int i, int i2) {
            this.f1120a = i;
            this.f1121b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            RecyclerView.i iVar = recyclerView.n;
            if (recyclerView.m == null || iVar == null || !iVar.q()) {
                return;
            }
            if (z) {
                if (!recyclerView.f.d()) {
                    iVar.a(recyclerView.m.b(), this);
                }
            } else if (!recyclerView.w()) {
                iVar.a(this.f1120a, this.f1121b, recyclerView.D, this);
            }
            if (this.d > iVar.x) {
                iVar.x = this.d;
                iVar.y = z;
                recyclerView.e.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i.a
        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            if (this.c == null) {
                this.c = new int[4];
                Arrays.fill(this.c, -1);
            } else if (i3 >= this.c.length) {
                int[] iArr = this.c;
                this.c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.c, 0, iArr.length);
            }
            this.c[i3] = i;
            this.c[i3 + 1] = i2;
            this.d++;
        }

        boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1119b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f1119b.remove(recyclerView);
    }

    void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.C.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f1119b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f1119b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.C.a(recyclerView, false);
                i += recyclerView.C.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f1119b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.C;
                int iAbs = Math.abs(aVar.f1120a) + Math.abs(aVar.f1121b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f1122a = i7 <= iAbs;
                    bVar.f1123b = iAbs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int iC = recyclerView.g.c();
        for (int i2 = 0; i2 < iC; i2++) {
            RecyclerView.x xVarE = RecyclerView.e(recyclerView.g.d(i2));
            if (xVarE.c == i && !xVarE.p()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.x a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.e;
        try {
            recyclerView.l();
            RecyclerView.x xVarA = pVar.a(i, false, j);
            if (xVarA != null) {
                if (xVarA.r() && !xVarA.p()) {
                    pVar.a(xVarA.f1052a);
                } else {
                    pVar.a(xVarA, false);
                }
            }
            return xVarA;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.x && recyclerView.g.c() != 0) {
            recyclerView.c();
        }
        a aVar = recyclerView.C;
        aVar.a(recyclerView, true);
        if (aVar.d != 0) {
            try {
                androidx.core.os.a.a("RV Nested Prefetch");
                recyclerView.D.a(recyclerView.m);
                for (int i = 0; i < aVar.d * 2; i += 2) {
                    a(recyclerView, aVar.c[i], j);
                }
            } finally {
                androidx.core.os.a.a();
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.x xVarA = a(bVar.d, bVar.e, bVar.f1122a ? Long.MAX_VALUE : j);
        if (xVarA == null || xVarA.f1053b == null || !xVarA.r() || xVarA.p()) {
            return;
        }
        a(xVarA.f1053b.get(), j);
    }

    private void b(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (bVar.d == null) {
                return;
            }
            a(bVar, j);
            bVar.a();
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.a.a("RV Prefetch");
            if (this.f1119b.isEmpty()) {
                return;
            }
            int size = this.f1119b.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.f1119b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
        } finally {
            this.c = 0L;
            androidx.core.os.a.a();
        }
    }
}
