package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface b {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f1665a;

        public final a a(int i) {
            this.f1665a = 1;
            return this;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f1665a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
