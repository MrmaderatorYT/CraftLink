package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.lifecycle.e;

/* compiled from: ReportFragment.java */
/* loaded from: classes.dex */
public class o extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private a f925a;

    /* compiled from: ReportFragment.java */
    interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new o(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f925a);
        a(e.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        b(this.f925a);
        a(e.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f925a);
        a(e.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(e.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(e.a.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(e.a.ON_DESTROY);
        this.f925a = null;
    }

    private void a(e.a aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof i) {
            ((i) activity).a().a(aVar);
        } else if (activity instanceof g) {
            e eVarG = ((g) activity).g();
            if (eVarG instanceof h) {
                ((h) eVarG).a(aVar);
            }
        }
    }
}
