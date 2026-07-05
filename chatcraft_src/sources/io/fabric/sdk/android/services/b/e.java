package io.fabric.sdk.android.services.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: AdvertisingInfoServiceStrategy.java */
/* loaded from: classes.dex */
class e implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4209a;

    public e(Context context) {
        this.f4209a = context.getApplicationContext();
    }

    @Override // io.fabric.sdk.android.services.b.f
    public io.fabric.sdk.android.services.b.b a() throws PackageManager.NameNotFoundException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            io.fabric.sdk.android.c.g().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f4209a.getPackageManager().getPackageInfo("com.android.vending", 0);
            a aVar = new a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f4209a.bindService(intent, aVar, 1)) {
                    try {
                        try {
                            b bVar = new b(aVar.a());
                            return new io.fabric.sdk.android.services.b.b(bVar.a(), bVar.b());
                        } catch (Exception e) {
                            io.fabric.sdk.android.c.g().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                            this.f4209a.unbindService(aVar);
                        }
                    } finally {
                        this.f4209a.unbindService(aVar);
                    }
                } else {
                    io.fabric.sdk.android.c.g().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                }
            } catch (Throwable th) {
                io.fabric.sdk.android.c.g().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            io.fabric.sdk.android.c.g().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            io.fabric.sdk.android.c.g().a("Fabric", "Unable to determine if Google Play Services is available", e2);
            return null;
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    private static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4210a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f4211b;

        private a() {
            this.f4210a = false;
            this.f4211b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f4211b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f4211b.clear();
        }

        public IBinder a() {
            if (this.f4210a) {
                io.fabric.sdk.android.c.g().e("Fabric", "getBinder already called");
            }
            this.f4210a = true;
            try {
                return this.f4211b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    private static final class b implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f4212a;

        public b(IBinder iBinder) {
            this.f4212a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f4212a;
        }

        public String a() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f4212a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Exception unused) {
                    io.fabric.sdk.android.c.g().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(1);
                    this.f4212a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                    io.fabric.sdk.android.c.g().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                }
                return z;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
