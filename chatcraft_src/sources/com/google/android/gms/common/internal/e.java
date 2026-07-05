package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface e extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.b.b implements e {

        /* renamed from: com.google.android.gms.common.internal.e$a$a, reason: collision with other inner class name */
        public static class C0067a extends com.google.android.gms.internal.b.a implements e {
            C0067a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.e
            public final Account a() {
                Parcel parcelA = a(2, b());
                Account account = (Account) com.google.android.gms.internal.b.c.a(parcelA, Account.CREATOR);
                parcelA.recycle();
                return account;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (iInterfaceQueryLocalInterface instanceof e) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new C0067a(iBinder);
        }

        @Override // com.google.android.gms.internal.b.b
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 2) {
                return false;
            }
            Account accountA = a();
            parcel2.writeNoException();
            com.google.android.gms.internal.b.c.b(parcel2, accountA);
            return true;
        }
    }

    Account a();
}
