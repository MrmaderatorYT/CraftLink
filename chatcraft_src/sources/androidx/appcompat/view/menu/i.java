package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.a;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.o;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a {

    /* renamed from: a, reason: collision with root package name */
    f f238a;

    /* renamed from: b, reason: collision with root package name */
    private h f239b;
    private androidx.appcompat.app.b c;
    private o.a d;

    public i(h hVar) {
        this.f239b = hVar;
    }

    public void a(IBinder iBinder) {
        h hVar = this.f239b;
        b.a aVar = new b.a(hVar.f());
        this.f238a = new f(aVar.a(), a.g.abc_list_menu_item_layout);
        this.f238a.a(this);
        this.f239b.a(this.f238a);
        aVar.a(this.f238a.a(), this);
        View viewP = hVar.p();
        if (viewP != null) {
            aVar.a(viewP);
        } else {
            aVar.a(hVar.o()).a(hVar.n());
        }
        aVar.a(this);
        this.c = aVar.b();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f239b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f239b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f238a.a(this.f239b, true);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void a(h hVar, boolean z) {
        if (z || hVar == this.f239b) {
            a();
        }
        if (this.d != null) {
            this.d.a(hVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean a(h hVar) {
        if (this.d != null) {
            return this.d.a(hVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f239b.a((j) this.f238a.a().getItem(i), 0);
    }
}
