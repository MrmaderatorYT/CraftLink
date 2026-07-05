package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.bte;
import com.google.android.gms.internal.ads.btf;
import java.util.Date;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final bte f1482a;

    private c(a aVar) {
        this.f1482a = new bte(aVar.f1483a);
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final btf f1483a = new btf();

        public a() {
            this.f1483a.b("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final a a(String str) {
            this.f1483a.a(str);
            return this;
        }

        public final a a(Class<? extends com.google.android.gms.ads.mediation.b> cls, Bundle bundle) {
            this.f1483a.a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f1483a.c("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public final a b(String str) {
            this.f1483a.b(str);
            return this;
        }

        public final c a() {
            return new c(this);
        }

        @Deprecated
        public final a a(Date date) {
            this.f1483a.a(date);
            return this;
        }

        @Deprecated
        public final a a(int i) {
            this.f1483a.a(i);
            return this;
        }

        public final a a(Location location) {
            this.f1483a.a(location);
            return this;
        }

        public final a a(boolean z) {
            this.f1483a.a(z);
            return this;
        }

        @Deprecated
        public final a b(boolean z) {
            this.f1483a.b(z);
            return this;
        }
    }

    public final bte a() {
        return this.f1482a;
    }
}
