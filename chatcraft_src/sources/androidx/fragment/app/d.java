package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.lifecycle.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class d extends androidx.core.app.d implements androidx.lifecycle.s {
    boolean c;
    boolean d;
    boolean f;
    boolean g;
    int h;
    androidx.b.h<String> i;
    private androidx.lifecycle.r j;

    /* renamed from: a, reason: collision with root package name */
    final Handler f722a = new Handler() { // from class: androidx.fragment.app.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                d.this.h();
                d.this.f723b.m();
            } else {
                super.handleMessage(message);
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    final f f723b = f.a(new a());
    boolean e = true;

    public void a(Fragment fragment) {
    }

    public Object i() {
        return null;
    }

    /* compiled from: FragmentActivity.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        Object f726a;

        /* renamed from: b, reason: collision with root package name */
        androidx.lifecycle.r f727b;
        j c;

        b() {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f723b.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String strA = this.i.a(i4);
            this.i.c(i4);
            if (strA == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentA = this.f723b.a(strA);
            if (fragmentA == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strA);
                return;
            }
            fragmentA.a(i & 65535, i2, intent);
            return;
        }
        a.InterfaceC0035a interfaceC0035aA = androidx.core.app.a.a();
        if (interfaceC0035aA == null || !interfaceC0035aA.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h hVarA = this.f723b.a();
        boolean zD = hVarA.d();
        if (!zD || Build.VERSION.SDK_INT > 25) {
            if (zD || !hVarA.b()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f723b.a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f723b.b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f723b.b();
        this.f723b.a(configuration);
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r a_() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.j == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.j = bVar.f727b;
            }
            if (this.j == null) {
                this.j = new androidx.lifecycle.r();
            }
        }
        return this.j;
    }

    @Override // androidx.core.app.d, androidx.lifecycle.g
    public androidx.lifecycle.e g() {
        return super.g();
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f723b.a((Fragment) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null && bVar.f727b != null && this.j == null) {
            this.j = bVar.f727b;
        }
        if (bundle != null) {
            this.f723b.a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.c : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.h = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.i = new androidx.b.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.i.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = new androidx.b.h<>();
            this.h = 0;
        }
        this.f723b.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.f723b.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewA = a(view, str, context, attributeSet);
        return viewA == null ? super.onCreateView(view, str, context, attributeSet) : viewA;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewA = a((View) null, str, context, attributeSet);
        return viewA == null ? super.onCreateView(str, context, attributeSet) : viewA;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f723b.a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.j != null && !isChangingConfigurations()) {
            this.j.a();
        }
        this.f723b.k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f723b.l();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f723b.a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.f723b.b(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f723b.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.f722a.hasMessages(2)) {
            this.f722a.removeMessages(2);
            h();
        }
        this.f723b.i();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f723b.b();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f723b.b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f722a.sendEmptyMessage(2);
        this.d = true;
        this.f723b.m();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.f722a.removeMessages(2);
        h();
        this.f723b.m();
    }

    protected void h() {
        this.f723b.h();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0 && menu != null) {
            return a(view, menu) | this.f723b.a(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object objI = i();
        j jVarD = this.f723b.d();
        if (jVarD == null && this.j == null && objI == null) {
            return null;
        }
        b bVar = new b();
        bVar.f726a = objI;
        bVar.f727b = this.j;
        bVar.c = jVarD;
        return bVar;
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a();
        Parcelable parcelableC = this.f723b.c();
        if (parcelableC != null) {
            bundle.putParcelable("android:support:fragments", parcelableC);
        }
        if (this.i.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.h);
            int[] iArr = new int[this.i.b()];
            String[] strArr = new String[this.i.b()];
            for (int i = 0; i < this.i.b(); i++) {
                iArr[i] = this.i.d(i);
                strArr[i] = this.i.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c) {
            this.c = true;
            this.f723b.f();
        }
        this.f723b.b();
        this.f723b.m();
        this.f723b.g();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.e = true;
        a();
        this.f723b.j();
    }

    @Deprecated
    public void b() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (getApplication() != null) {
            androidx.h.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f723b.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public h j() {
        return this.f723b.a();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.g && i != -1) {
            a(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.g && i != -1) {
            a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.f && i != -1) {
            a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.f && i != -1) {
            a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static void a(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f723b.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strA = this.i.a(i3);
            this.i.c(i3);
            if (strA == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentA = this.f723b.a(strA);
            if (fragmentA == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strA);
                return;
            }
            fragmentA.a(i & 65535, strArr, iArr);
        }
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.g = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intent, -1, bundle);
            } else {
                a(i);
                androidx.core.app.a.a(this, intent, ((b(fragment) + 1) << 16) + (i & 65535), bundle);
            }
        } finally {
            this.g = false;
        }
    }

    private int b(Fragment fragment) {
        if (this.i.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.i.f(this.h) >= 0) {
            this.h = (this.h + 1) % 65534;
        }
        int i = this.h;
        this.i.b(i, fragment.p);
        this.h = (this.h + 1) % 65534;
        return i;
    }

    /* compiled from: FragmentActivity.java */
    class a extends g<d> {
        public a() {
            super(d.this);
        }

        @Override // androidx.fragment.app.g
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.g
        public boolean a(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.g
        public LayoutInflater b() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.g
        public void c() {
            d.this.b();
        }

        @Override // androidx.fragment.app.g
        public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            d.this.a(fragment, intent, i, bundle);
        }

        @Override // androidx.fragment.app.g
        public boolean d() {
            return d.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.g
        public int e() {
            Window window = d.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.g
        public void b(Fragment fragment) {
            d.this.a(fragment);
        }

        @Override // androidx.fragment.app.g, androidx.fragment.app.e
        public View a(int i) {
            return d.this.findViewById(i);
        }

        @Override // androidx.fragment.app.g, androidx.fragment.app.e
        public boolean a() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    private void a() {
        while (a(j(), e.b.CREATED)) {
        }
    }

    private static boolean a(h hVar, e.b bVar) {
        boolean zA = false;
        for (Fragment fragment : hVar.c()) {
            if (fragment != null) {
                if (fragment.g().a().a(e.b.STARTED)) {
                    fragment.ac.a(bVar);
                    zA = true;
                }
                h hVarR = fragment.r();
                if (hVarR != null) {
                    zA |= a(hVarR, bVar);
                }
            }
        }
        return zA;
    }
}
