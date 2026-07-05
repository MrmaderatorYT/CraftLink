package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: FragmentManager.java */
    public static abstract class a {
        public void a(h hVar, Fragment fragment) {
        }

        public void a(h hVar, Fragment fragment, Context context) {
        }

        public void a(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void a(h hVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void b(h hVar, Fragment fragment) {
        }

        public void b(h hVar, Fragment fragment, Context context) {
        }

        public void b(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void c(h hVar, Fragment fragment) {
        }

        public void c(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void d(h hVar, Fragment fragment) {
        }

        public void d(h hVar, Fragment fragment, Bundle bundle) {
        }

        public void e(h hVar, Fragment fragment) {
        }

        public void f(h hVar, Fragment fragment) {
        }

        public void g(h hVar, Fragment fragment) {
        }
    }

    /* compiled from: FragmentManager.java */
    public interface b {
        void E_();
    }

    public abstract Fragment.c a(Fragment fragment);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract n a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(b bVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract List<Fragment> c();

    public abstract boolean d();
}
