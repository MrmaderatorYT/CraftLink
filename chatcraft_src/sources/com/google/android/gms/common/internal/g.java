package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface g extends IInterface {
    void a(f fVar, c cVar);

    public static abstract class a extends Binder implements g {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.common.internal.g$a$a, reason: collision with other inner class name */
        static class C0068a implements g {

            /* renamed from: a, reason: collision with root package name */
            private final IBinder f1729a;

            C0068a(IBinder iBinder) {
                this.f1729a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1729a;
            }

            @Override // com.google.android.gms.common.internal.g
            public final void a(f fVar, c cVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    parcelObtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (cVar != null) {
                        parcelObtain.writeInt(1);
                        cVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f1729a.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00e7 A[FALL_THROUGH] */
        @Override // android.os.Binder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.g.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }
}
