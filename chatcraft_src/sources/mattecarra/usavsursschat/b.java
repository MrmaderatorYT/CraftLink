package mattecarra.usavsursschat;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.google.android.material.snackbar.Snackbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: ChatCraftBaseActivity.java */
/* loaded from: classes.dex */
public abstract class b extends mattecarra.usavsursschat.InAppPurchase.a {
    protected List<WeakReference<Dialog>> m = new ArrayList();
    protected f n;
    protected mattecarra.usavsursschat.i.c o;

    protected abstract View q();

    @Override // mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = new mattecarra.usavsursschat.i.c(this);
        this.n = new f(this);
    }

    @Override // mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        Iterator<WeakReference<Dialog>> it = this.m.iterator();
        while (it.hasNext()) {
            try {
                Dialog dialog = it.next().get();
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Throwable th) {
                System.out.println("Error closing dialog: " + th.getMessage());
            }
        }
        this.m.clear();
        super.onDestroy();
    }

    public Snackbar a(String str, String str2, int i, int i2, int i3, View.OnClickListener onClickListener) {
        View viewQ = q();
        if (viewQ == null) {
            return null;
        }
        Snackbar snackbarA = Snackbar.a(viewQ, str, -1);
        if (!str2.equals(BuildConfig.FLAVOR)) {
            snackbarA.a(str2, onClickListener);
        }
        if (i != -1) {
            snackbarA.d().setBackgroundColor(i);
        }
        if (i2 != -1) {
            ((TextView) snackbarA.d().findViewById(R.id.snackbar_text)).setTextColor(i2);
        }
        if (i3 != -1) {
            snackbarA.e(i3);
        }
        return snackbarA;
    }

    public Snackbar a(int i, String str, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        View viewQ = q();
        if (viewQ == null) {
            return null;
        }
        Snackbar snackbarA = Snackbar.a(viewQ, i, -1);
        if (!str.equals(BuildConfig.FLAVOR)) {
            snackbarA.a(str, onClickListener);
        }
        if (i2 != -1) {
            snackbarA.d().setBackgroundColor(i2);
        }
        if (i3 != -1) {
            ((TextView) snackbarA.d().findViewById(R.id.snackbar_text)).setTextColor(i3);
        }
        if (i4 != -1) {
            snackbarA.e(i4);
        }
        return snackbarA;
    }

    public boolean r() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a(com.afollestad.materialdialogs.f fVar) {
        this.m.add(new WeakReference<>(fVar));
    }

    public void b(final com.afollestad.materialdialogs.f fVar) {
        try {
            if (!r()) {
                runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.b(fVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (isFinishing()) {
                System.out.println("Instance == null or finishing. Not showing Material Dialog");
            } else {
                fVar.show();
                this.m.add(new WeakReference<>(fVar));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final f.a aVar) {
        try {
            if (!r()) {
                runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a(aVar);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (isFinishing()) {
                System.out.println("Instance == null or finishing. Not showing Material Dialog");
            } else {
                this.m.add(new WeakReference<>(aVar.c()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public mattecarra.usavsursschat.i.c s() {
        return this.o;
    }
}
