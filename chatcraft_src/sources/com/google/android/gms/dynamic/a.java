package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0069a extends com.google.android.gms.internal.b.b implements a {

        /* renamed from: com.google.android.gms.dynamic.a$a$a, reason: collision with other inner class name */
        public static class C0070a extends com.google.android.gms.internal.b.a implements a {
            C0070a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0069a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (iInterfaceQueryLocalInterface instanceof a) {
                return (a) iInterfaceQueryLocalInterface;
            }
            return new C0070a(iBinder);
        }
    }
}
