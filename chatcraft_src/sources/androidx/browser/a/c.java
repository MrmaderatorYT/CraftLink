package androidx.browser.a;

import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f489a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f490b;

    c(Intent intent, Bundle bundle) {
        this.f489a = intent;
        this.f490b = bundle;
    }

    /* compiled from: CustomTabsIntent.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f491a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Bundle> f492b;
        private Bundle c;
        private ArrayList<Bundle> d;
        private boolean e;

        public a() {
            this(null);
        }

        public a(e eVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f491a = new Intent("android.intent.action.VIEW");
            this.f492b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            if (eVar != null) {
                this.f491a.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            androidx.core.app.c.a(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            this.f491a.putExtras(bundle);
        }

        public c a() {
            if (this.f492b != null) {
                this.f491a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f492b);
            }
            if (this.d != null) {
                this.f491a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
            }
            this.f491a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            return new c(this.f491a, this.c);
        }
    }
}
