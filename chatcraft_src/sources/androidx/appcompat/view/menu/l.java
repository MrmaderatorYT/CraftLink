package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.k;
import androidx.core.g.b;

/* compiled from: MenuItemWrapperJB.java */
/* loaded from: classes.dex */
class l extends k {
    l(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    @Override // androidx.appcompat.view.menu.k
    k.a a(ActionProvider actionProvider) {
        return new a(this.f219a, actionProvider);
    }

    /* compiled from: MenuItemWrapperJB.java */
    class a extends k.a implements ActionProvider.VisibilityListener {
        b.InterfaceC0041b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.g.b
        public View a(MenuItem menuItem) {
            return this.f243a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.g.b
        public boolean d() {
            return this.f243a.overridesItemVisibility();
        }

        @Override // androidx.core.g.b
        public boolean e() {
            return this.f243a.isVisible();
        }

        @Override // androidx.core.g.b
        public void a(b.InterfaceC0041b interfaceC0041b) {
            this.c = interfaceC0041b;
            this.f243a.setVisibilityListener(interfaceC0041b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }
}
