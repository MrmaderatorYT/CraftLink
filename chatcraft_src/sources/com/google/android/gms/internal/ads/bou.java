package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
public final class bou {

    public static final class a extends aqy<a, C0079a> implements ash {
        private static final a zzcar = new a();
        private static volatile asq<a> zzcas;

        public enum b implements arb {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(10002);

            private static final arc<b> E = new bow();
            private final int F;

            @Override // com.google.android.gms.internal.ads.arb
            public final int a() {
                return this.F;
            }

            b(int i) {
                this.F = i;
            }
        }

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.ads.bou$a$a, reason: collision with other inner class name */
        public static final class C0079a extends aqy.a<a, C0079a> implements ash {
            private C0079a() {
                super(a.zzcar);
            }

            /* synthetic */ C0079a(bov bovVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.aqy
        protected final Object a(int i, Object obj, Object obj2) {
            bov bovVar = null;
            switch (bov.f2916a[i - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0079a(bovVar);
                case 3:
                    return a(zzcar, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzcar;
                case 5:
                    asq<a> bVar = zzcas;
                    if (bVar == null) {
                        synchronized (a.class) {
                            bVar = zzcas;
                            if (bVar == null) {
                                bVar = new aqy.b<>(zzcar);
                                zzcas = bVar;
                            }
                        }
                    }
                    return bVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            aqy.a((Class<a>) a.class, zzcar);
        }
    }
}
