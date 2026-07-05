package androidx.h.a;

import androidx.lifecycle.g;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.h.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0048a<D> {
        void a(androidx.h.b.a<D> aVar);

        void a(androidx.h.b.a<D> aVar, D d);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends g & s> a a(T t) {
        return new b(t, t.a_());
    }
}
