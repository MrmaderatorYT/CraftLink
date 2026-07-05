package androidx.core.e;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.core.e.c f601a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.core.e.c f602b = new e(null, true);
    public static final androidx.core.e.c c = new e(b.f605a, false);
    public static final androidx.core.e.c d = new e(b.f605a, true);
    public static final androidx.core.e.c e = new e(a.f603a, false);
    public static final androidx.core.e.c f = f.f608a;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.e.d$d, reason: collision with other inner class name */
    private static abstract class AbstractC0038d implements androidx.core.e.c {

        /* renamed from: a, reason: collision with root package name */
        private final c f606a;

        protected abstract boolean a();

        AbstractC0038d(c cVar) {
            this.f606a = cVar;
        }

        @Override // androidx.core.e.c
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            if (this.f606a == null) {
                return a();
            }
            return b(charSequence, i, i2);
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.f606a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class e extends AbstractC0038d {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f607a;

        e(c cVar, boolean z) {
            super(cVar);
            this.f607a = z;
        }

        @Override // androidx.core.e.d.AbstractC0038d
        protected boolean a() {
            return this.f607a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f605a = new b();

        @Override // androidx.core.e.d.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iB = 2;
            while (i < i3 && iB == 2) {
                iB = d.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iB;
        }

        private b() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        static final a f603a = new a(true);

        /* renamed from: b, reason: collision with root package name */
        static final a f604b = new a(false);
        private final boolean c;

        @Override // androidx.core.e.d.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (d.a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.c) {
                            return 0;
                        }
                        z = true;
                        i++;
                    case 1:
                        if (!this.c) {
                            return 1;
                        }
                        z = true;
                        i++;
                    default:
                        i++;
                }
            }
            if (z) {
                return this.c ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.c = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    private static class f extends AbstractC0038d {

        /* renamed from: a, reason: collision with root package name */
        static final f f608a = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.e.d.AbstractC0038d
        protected boolean a() {
            return androidx.core.e.e.a(Locale.getDefault()) == 1;
        }
    }
}
