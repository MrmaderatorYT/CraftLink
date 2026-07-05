package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ActivityLifecycleManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Application f4176a;

    /* renamed from: b, reason: collision with root package name */
    private C0094a f4177b;

    /* compiled from: ActivityLifecycleManager.java */
    public static abstract class b {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }
    }

    public a(Context context) {
        this.f4176a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f4177b = new C0094a(this.f4176a);
        }
    }

    public boolean a(b bVar) {
        return this.f4177b != null && this.f4177b.a(bVar);
    }

    public void a() {
        if (this.f4177b != null) {
            this.f4177b.a();
        }
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: io.fabric.sdk.android.a$a, reason: collision with other inner class name */
    private static class C0094a {

        /* renamed from: a, reason: collision with root package name */
        private final Set<Application.ActivityLifecycleCallbacks> f4178a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        private final Application f4179b;

        C0094a(Application application) {
            this.f4179b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public void a() {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.f4178a.iterator();
            while (it.hasNext()) {
                this.f4179b.unregisterActivityLifecycleCallbacks(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public boolean a(final b bVar) {
            if (this.f4179b == null) {
                return false;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: io.fabric.sdk.android.a.a.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    bVar.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    bVar.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    bVar.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    bVar.d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    bVar.e(activity);
                }
            };
            this.f4179b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f4178a.add(activityLifecycleCallbacks);
            return true;
        }
    }
}
