package androidx.h.a;

import android.os.Bundle;
import android.util.Log;
import androidx.b.h;
import androidx.h.a.a;
import androidx.h.b.a;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
class b extends androidx.h.a.a {

    /* renamed from: a, reason: collision with root package name */
    static boolean f791a = false;

    /* renamed from: b, reason: collision with root package name */
    private final g f792b;
    private final c c;

    /* compiled from: LoaderManagerImpl.java */
    public static class a<D> extends l<D> implements a.InterfaceC0050a<D> {
        private final int e;
        private final Bundle f;
        private final androidx.h.b.a<D> g;
        private g h;
        private C0049b<D> i;
        private androidx.h.b.a<D> j;

        androidx.h.b.a<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b.f791a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.a();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.f791a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.e();
        }

        void f() {
            g gVar = this.h;
            C0049b<D> c0049b = this.i;
            if (gVar == null || c0049b == null) {
                return;
            }
            super.a((m) c0049b);
            a(gVar, c0049b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(m<? super D> mVar) {
            super.a((m) mVar);
            this.h = null;
            this.i = null;
        }

        androidx.h.b.a<D> a(boolean z) {
            if (b.f791a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.c();
            this.g.g();
            C0049b<D> c0049b = this.i;
            if (c0049b != null) {
                a((m) c0049b);
                if (z) {
                    c0049b.b();
                }
            }
            this.g.a((a.InterfaceC0050a) this);
            if ((c0049b != null && !c0049b.a()) || z) {
                this.g.i();
                return this.j;
            }
            return this.g;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
            if (this.j != null) {
                this.j.i();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            androidx.core.f.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            this.g.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                this.i.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a((androidx.h.b.a<D>) a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.h.a.b$b, reason: collision with other inner class name */
    static class C0049b<D> implements m<D> {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.h.b.a<D> f793a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0048a<D> f794b;
        private boolean c;

        @Override // androidx.lifecycle.m
        public void a(D d) {
            if (b.f791a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f793a + ": " + this.f793a.a((androidx.h.b.a<D>) d));
            }
            this.f794b.a(this.f793a, d);
            this.c = true;
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (b.f791a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f793a);
                }
                this.f794b.a(this.f793a);
            }
        }

        public String toString() {
            return this.f794b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    static class c extends p {

        /* renamed from: a, reason: collision with root package name */
        private static final q.a f795a = new q.a() { // from class: androidx.h.a.b.c.1
            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b, reason: collision with root package name */
        private h<a> f796b = new h<>();
        private boolean c = false;

        c() {
        }

        static c a(r rVar) {
            return (c) new q(rVar, f795a).a(c.class);
        }

        void b() {
            int iB = this.f796b.b();
            for (int i = 0; i < iB; i++) {
                this.f796b.e(i).f();
            }
        }

        @Override // androidx.lifecycle.p
        protected void a() {
            super.a();
            int iB = this.f796b.b();
            for (int i = 0; i < iB; i++) {
                this.f796b.e(i).a(true);
            }
            this.f796b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f796b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f796b.b(); i++) {
                    a aVarE = this.f796b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f796b.d(i));
                    printWriter.print(": ");
                    printWriter.println(aVarE.toString());
                    aVarE.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b(g gVar, r rVar) {
        this.f792b = gVar;
        this.c = c.a(rVar);
    }

    @Override // androidx.h.a.a
    public void a() {
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.f.a.a(this.f792b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.h.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
