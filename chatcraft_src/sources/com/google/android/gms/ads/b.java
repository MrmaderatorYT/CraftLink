package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.b.g;
import com.google.android.gms.ads.b.h;
import com.google.android.gms.ads.b.i;
import com.google.android.gms.ads.b.k;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.bqe;
import com.google.android.gms.internal.ads.bqm;
import com.google.android.gms.internal.ads.br;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.brk;
import com.google.android.gms.internal.ads.brn;
import com.google.android.gms.internal.ads.bte;
import com.google.android.gms.internal.ads.ee;
import com.google.android.gms.internal.ads.ef;
import com.google.android.gms.internal.ads.eg;
import com.google.android.gms.internal.ads.eh;
import com.google.android.gms.internal.ads.ei;
import com.google.android.gms.internal.ads.kj;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final bqm f1466a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1467b;
    private final brk c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1468a;

        /* renamed from: b, reason: collision with root package name */
        private final brn f1469b;

        public a(Context context, String str) {
            this((Context) com.google.android.gms.common.internal.i.a(context, "context cannot be null"), bra.b().a(context, str, new kj()));
        }

        private a(Context context, brn brnVar) {
            this.f1468a = context;
            this.f1469b = brnVar;
        }

        @Deprecated
        public a a(h.a aVar) {
            try {
                this.f1469b.a(new ef(aVar));
            } catch (RemoteException e) {
                aan.c("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public a a(g.a aVar) {
            try {
                this.f1469b.a(new ee(aVar));
            } catch (RemoteException e) {
                aan.c("Failed to add app install ad listener", e);
            }
            return this;
        }

        public a a(k.a aVar) {
            try {
                this.f1469b.a(new ei(aVar));
            } catch (RemoteException e) {
                aan.c("Failed to add google native ad listener", e);
            }
            return this;
        }

        public a a(String str, i.b bVar, i.a aVar) {
            try {
                this.f1469b.a(str, new eh(bVar), aVar == null ? null : new eg(aVar));
            } catch (RemoteException e) {
                aan.c("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public a a(com.google.android.gms.ads.a aVar) {
            try {
                this.f1469b.a(new bqe(aVar));
            } catch (RemoteException e) {
                aan.c("Failed to set AdListener.", e);
            }
            return this;
        }

        public a a(com.google.android.gms.ads.b.d dVar) {
            try {
                this.f1469b.a(new br(dVar));
            } catch (RemoteException e) {
                aan.c("Failed to specify native ad options", e);
            }
            return this;
        }

        public b a() {
            try {
                return new b(this.f1468a, this.f1469b.a());
            } catch (RemoteException e) {
                aan.b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    b(Context context, brk brkVar) {
        this(context, brkVar, bqm.f2973a);
    }

    private b(Context context, brk brkVar, bqm bqmVar) {
        this.f1467b = context;
        this.c = brkVar;
        this.f1466a = bqmVar;
    }

    private final void a(bte bteVar) {
        try {
            this.c.a(bqm.a(this.f1467b, bteVar));
        } catch (RemoteException e) {
            aan.b("Failed to load ad.", e);
        }
    }

    public void a(c cVar) {
        a(cVar.a());
    }
}
