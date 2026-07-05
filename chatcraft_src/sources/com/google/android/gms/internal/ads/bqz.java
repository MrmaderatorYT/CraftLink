package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
abstract class bqz<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final bsd f2995a = c();

    bqz() {
    }

    @Nonnull
    protected abstract T a();

    protected abstract T a(bsd bsdVar);

    protected abstract T b();

    private static bsd c() throws IllegalAccessException, InstantiationException {
        try {
            Object objNewInstance = bqr.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (objNewInstance instanceof IBinder) {
                return bse.asInterface((IBinder) objNewInstance);
            }
            aan.e("ClientApi class is not an instance of IBinder.");
            return null;
        } catch (Exception unused) {
            aan.e("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T d() {
        if (f2995a == null) {
            aan.e("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(f2995a);
        } catch (RemoteException e) {
            aan.c("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T e() {
        try {
            return b();
        } catch (RemoteException e) {
            aan.c("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T a(Context context, boolean z) {
        T tD;
        if (!z) {
            bra.a();
            if (!aac.c(context, 12451000)) {
                aan.b("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.b(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        o.a(context);
        if (((Boolean) bra.e().a(o.cA)).booleanValue()) {
            z = false;
        }
        if (z) {
            tD = d();
            if (tD == null) {
                tD = e();
            }
        } else {
            T tE = e();
            int i = tE == null ? 1 : 0;
            if (i != 0) {
                if (bra.h().nextInt(((Integer) bra.e().a(o.cQ)).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    bra.a().a(context, bra.g().f1790a, "gmob-apps", bundle, true);
                }
            }
            tD = tE == null ? d() : tE;
        }
        return tD == null ? a() : tD;
    }
}
