package androidx.h.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class a<D> {

    /* renamed from: a, reason: collision with root package name */
    int f797a;

    /* renamed from: b, reason: collision with root package name */
    InterfaceC0050a<D> f798b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* compiled from: Loader.java */
    /* renamed from: androidx.h.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0050a<D> {
    }

    protected void b() {
    }

    protected boolean d() {
        return false;
    }

    protected void f() {
    }

    protected void h() {
    }

    protected void j() {
    }

    public void a(InterfaceC0050a<D> interfaceC0050a) {
        if (this.f798b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f798b != interfaceC0050a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f798b = null;
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    public boolean c() {
        return d();
    }

    public void e() {
        this.c = false;
        f();
    }

    public void g() {
        this.d = true;
        h();
    }

    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.f.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.f797a);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f797a);
        printWriter.print(" mListener=");
        printWriter.println(this.f798b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }
}
