package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class axt {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2386b = "axt";

    /* renamed from: a, reason: collision with root package name */
    protected Context f2387a;
    private ExecutorService c;
    private DexClassLoader d;
    private axf e;
    private byte[] f;
    private boolean j;
    private awy m;
    private Map<Pair<String, String>, azb> p;
    private volatile AdvertisingIdClient g = null;
    private volatile boolean h = false;
    private Future i = null;
    private volatile akp k = null;
    private Future l = null;
    private boolean n = false;
    private boolean o = false;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;

    final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                axt.this.r = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                axt.this.r = false;
            }
        }

        /* synthetic */ a(axt axtVar, axu axuVar) {
            this();
        }
    }

    public static axt a(Context context, String str, String str2, boolean z) throws Throwable {
        axu axuVar;
        File cacheDir;
        File file;
        axt axtVar = new axt(context);
        try {
            axtVar.c = Executors.newCachedThreadPool(new axu());
            axtVar.h = z;
            if (z) {
                axtVar.i = axtVar.c.submit(new axv(axtVar));
            }
            axtVar.c.execute(new axx(axtVar));
            try {
                com.google.android.gms.common.d dVarA = com.google.android.gms.common.d.a();
                axtVar.n = dVarA.b(axtVar.f2387a) > 0;
                axtVar.o = dVarA.a(axtVar.f2387a) == 0;
            } catch (Throwable unused) {
            }
            axtVar.a(0, true);
            if (aya.a() && ((Boolean) bra.e().a(o.bo)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            axuVar = null;
            axtVar.e = new axf(null);
            try {
                axtVar.f = axtVar.e.a(str);
                try {
                    try {
                        try {
                            try {
                                cacheDir = axtVar.f2387a.getCacheDir();
                                if (cacheDir == null && (cacheDir = axtVar.f2387a.getDir("dex", 0)) == null) {
                                    throw new zzdi();
                                }
                                file = new File(String.format("%s/%s.jar", cacheDir, "1529567361524"));
                                if (!file.exists()) {
                                    byte[] bArrA = axtVar.e.a(axtVar.f, str2);
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    fileOutputStream.write(bArrA, 0, bArrA.length);
                                    fileOutputStream.close();
                                }
                                axtVar.b(cacheDir, "1529567361524");
                            } catch (IOException e) {
                                throw new zzdi(e);
                            }
                        } catch (zzcx e2) {
                            throw new zzdi(e2);
                        }
                    } catch (NullPointerException e3) {
                        throw new zzdi(e3);
                    }
                } catch (FileNotFoundException e4) {
                    throw new zzdi(e4);
                }
            } catch (zzcx e5) {
                throw new zzdi(e5);
            }
        } catch (zzdi unused2) {
        }
        try {
            axtVar.d = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, axtVar.f2387a.getClassLoader());
            a(file);
            axtVar.a(cacheDir, "1529567361524");
            a(String.format("%s/%s.dex", cacheDir, "1529567361524"));
            if (!axtVar.s) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                axtVar.f2387a.registerReceiver(new a(axtVar, axuVar), intentFilter);
                axtVar.s = true;
            }
            axtVar.m = new awy(axtVar);
            axtVar.q = true;
            return axtVar;
        } catch (Throwable th) {
            a(file);
            axtVar.a(cacheDir, "1529567361524");
            a(String.format("%s/%s.dex", cacheDir, "1529567361524"));
            throw th;
        }
    }

    public final Context a() {
        return this.f2387a;
    }

    public final boolean b() {
        return this.q;
    }

    public final ExecutorService c() {
        return this.c;
    }

    public final DexClassLoader d() {
        return this.d;
    }

    public final axf e() {
        return this.e;
    }

    public final byte[] f() {
        return this.f;
    }

    public final boolean g() {
        return this.n;
    }

    public final awy h() {
        return this.m;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.r;
    }

    public final akp k() {
        return this.k;
    }

    public final Future l() {
        return this.l;
    }

    private axt(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext != null;
        this.f2387a = this.j ? applicationContext : context;
        this.p = new HashMap();
    }

    private final void a(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        a(file3);
                        return;
                    }
                    aot aotVar = new aot();
                    aotVar.d = Build.VERSION.SDK.getBytes();
                    aotVar.c = str.getBytes();
                    byte[] bytes = this.e.a(this.f, bArr).getBytes();
                    aotVar.f2122a = bytes;
                    aotVar.f2123b = avu.a(bytes);
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] bArrA = aus.a(aotVar);
                        fileOutputStream2.write(bArrA, 0, bArrA.length);
                        fileOutputStream2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        a(file3);
                    } catch (zzcx | IOException | NoSuchAlgorithmException unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        a(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        a(file3);
                        throw th;
                    }
                } catch (zzcx | IOException | NoSuchAlgorithmException unused9) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzcx | IOException | NoSuchAlgorithmException unused10) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static void a(File file) {
        if (!file.exists()) {
            Log.d(f2386b, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private final boolean b(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                a(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        Log.d(f2386b, "Cannot read the cache data.");
                        a(file2);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    aot aotVar = (aot) aus.a(new aot(), bArr);
                    if (str.equals(new String(aotVar.c)) && Arrays.equals(aotVar.f2123b, avu.a(aotVar.f2122a)) && Arrays.equals(aotVar.d, Build.VERSION.SDK.getBytes())) {
                        byte[] bArrA = this.e.a(this.f, new String(aotVar.f2122a));
                        file3.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(bArrA, 0, bArrA.length);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzcx | IOException | NoSuchAlgorithmException unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    a(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (zzcx | IOException | NoSuchAlgorithmException unused10) {
            }
        } catch (zzcx | IOException | NoSuchAlgorithmException unused11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public final boolean a(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair<>(str, str2), new azb(this, str, str2, clsArr));
        return true;
    }

    public final Method a(String str, String str2) {
        azb azbVar = this.p.get(new Pair(str, str2));
        if (azbVar == null) {
            return null;
        }
        return azbVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        try {
            if (this.g == null && this.j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f2387a);
                advertisingIdClient.start();
                this.g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.g = null;
        }
    }

    final void a(int i, boolean z) {
        if (this.o) {
            Future<?> futureSubmit = this.c.submit(new axw(this, i, z));
            if (i == 0) {
                this.l = futureSubmit;
            }
        }
    }

    final akp b(int i, boolean z) throws InterruptedException {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, akp akpVar) {
        if (i >= 4) {
            return false;
        }
        if (akpVar == null) {
            return true;
        }
        if (((Boolean) bra.e().a(o.br)).booleanValue() && (akpVar.n == null || akpVar.n.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
            return true;
        }
        if (((Boolean) bra.e().a(o.bs)).booleanValue()) {
            return akpVar.Y == null || akpVar.Y.f2153a == null || akpVar.Y.f2153a.longValue() == -2;
        }
        return false;
    }

    private final akp p() {
        try {
            return air.a(this.f2387a, this.f2387a.getPackageName(), Integer.toString(this.f2387a.getPackageManager().getPackageInfo(this.f2387a.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient m() throws ExecutionException, InterruptedException, TimeoutException {
        if (!this.h) {
            return null;
        }
        if (this.g != null) {
            return this.g;
        }
        if (this.i != null) {
            try {
                this.i.get(2000L, TimeUnit.MILLISECONDS);
                this.i = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.i.cancel(true);
            }
        }
        return this.g;
    }

    public final int n() {
        if (this.m != null) {
            return awy.a();
        }
        return Integer.MIN_VALUE;
    }
}
