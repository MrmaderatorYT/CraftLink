package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.e;

/* loaded from: classes.dex */
public class a extends e.a {
    public static Account a(e eVar) {
        if (eVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return eVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.e
    public final Account a() {
        throw new NoSuchMethodError();
    }

    public boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }
}
