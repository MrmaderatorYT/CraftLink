package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.internal.a.e;
import com.google.android.gms.internal.a.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class AdvertisingIdClient {

    @GuardedBy("this")
    private final Context mContext;

    @GuardedBy("this")
    private com.google.android.gms.common.a zze;

    @GuardedBy("this")
    private e zzf;

    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;

    @GuardedBy("mAutoDisconnectTaskLock")
    private a zzi;
    private final boolean zzj;
    private final long zzk;

    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            boolean z = this.zzr;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        CountDownLatch f1492a = new CountDownLatch(1);

        /* renamed from: b, reason: collision with root package name */
        boolean f1493b = false;
        private WeakReference<AdvertisingIdClient> c;
        private long d;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.c = new WeakReference<>(advertisingIdClient);
            this.d = j;
            start();
        }

        private final void a() {
            AdvertisingIdClient advertisingIdClient = this.c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f1493b = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f1492a.await(this.d, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzh = new Object();
        i.a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = j;
        this.zzj = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        b bVar = new b(context);
        boolean zA = bVar.a("gads:ad_id_app_context:enabled", false);
        float fA = bVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String strA = bVar.a("gads:ad_id_use_shared_preference:experiment_id", BuildConfig.FLAVOR);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zA, bVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                advertisingIdClient.zza(false);
                Info info = advertisingIdClient.getInfo();
                advertisingIdClient.zza(info, zA, fA, SystemClock.elapsedRealtime() - jElapsedRealtime, strA, null);
                return info;
            } finally {
            }
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        b bVar = new b(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, bVar.a("gads:ad_id_app_context:enabled", false), bVar.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            return advertisingIdClient.zzb();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static com.google.android.gms.common.a zza(Context context, boolean z) throws GooglePlayServicesNotAvailableException, PackageManager.NameNotFoundException, IOException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int iA = d.a().a(context, 12451000);
            if (iA != 0 && iA != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.a.a.a().a(context, intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    private static e zza(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return f.a(aVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final void zza() {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                this.zzi.f1492a.countDown();
                try {
                    this.zzi.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzk > 0) {
                this.zzi = new a(this, this.zzk);
            }
        }
    }

    private final void zza(boolean z) {
        i.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            this.zze = zza(this.mContext, this.zzj);
            this.zzf = zza(this.mContext, this.zze);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", z ? "1" : "0");
        if (info != null) {
            map.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            map.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            map.put("experiment_id", str);
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j));
        new com.google.android.gms.ads.identifier.a(this, map).start();
        return true;
    }

    private final boolean zzb() {
        boolean zB;
        i.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                i.a(this.zze);
                i.a(this.zzf);
                zB = this.zzf.b();
            } else {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f1493b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    i.a(this.zze);
                    i.a(this.zzf);
                    try {
                        zB = this.zzf.b();
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
        }
        zza();
        return zB;
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public final void finish() {
        i.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zze == null) {
                return;
            }
            try {
                if (this.zzg) {
                    com.google.android.gms.common.a.a.a().a(this.mContext, this.zze);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.zzg = false;
            this.zzf = null;
            this.zze = null;
        }
    }

    public Info getInfo() {
        Info info;
        i.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                i.a(this.zze);
                i.a(this.zzf);
                info = new Info(this.zzf.a(), this.zzf.a(true));
            } else {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f1493b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    i.a(this.zze);
                    i.a(this.zzf);
                    try {
                        info = new Info(this.zzf.a(), this.zzf.a(true));
                    } catch (RemoteException e) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
        }
        zza();
        return info;
    }

    public void start() {
        zza(true);
    }
}
