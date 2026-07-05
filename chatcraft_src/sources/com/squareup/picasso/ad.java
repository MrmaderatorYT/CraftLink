package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
final class ad {

    /* renamed from: a, reason: collision with root package name */
    static final StringBuilder f4109a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private static final b.f f4110b = b.f.a("RIFF");
    private static final b.f c = b.f.a("WEBP");

    static int a(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void a() {
        if (!b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String a(c cVar) {
        return a(cVar, BuildConfig.FLAVOR);
    }

    static String a(c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        com.squareup.picasso.a aVarI = cVar.i();
        if (aVarI != null) {
            sb.append(aVarI.f4100b.a());
        }
        List<com.squareup.picasso.a> listK = cVar.k();
        if (listK != null) {
            int size = listK.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || aVarI != null) {
                    sb.append(", ");
                }
                sb.append(listK.get(i).f4100b.a());
            }
        }
        return sb.toString();
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, BuildConfig.FLAVOR);
    }

    static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    static String a(w wVar) {
        String strA = a(wVar, f4109a);
        f4109a.setLength(0);
        return strA;
    }

    static String a(w wVar, StringBuilder sb) {
        if (wVar.f != null) {
            sb.ensureCapacity(wVar.f.length() + 50);
            sb.append(wVar.f);
        } else if (wVar.d != null) {
            String string = wVar.d.toString();
            sb.ensureCapacity(string.length() + 50);
            sb.append(string);
        } else {
            sb.ensureCapacity(50);
            sb.append(wVar.e);
        }
        sb.append('\n');
        if (wVar.n != 0.0f) {
            sb.append("rotation:");
            sb.append(wVar.n);
            if (wVar.q) {
                sb.append('@');
                sb.append(wVar.o);
                sb.append('x');
                sb.append(wVar.p);
            }
            sb.append('\n');
        }
        if (wVar.d()) {
            sb.append("resize:");
            sb.append(wVar.h);
            sb.append('x');
            sb.append(wVar.i);
            sb.append('\n');
        }
        if (wVar.j) {
            sb.append("centerCrop:");
            sb.append(wVar.k);
            sb.append('\n');
        } else if (wVar.l) {
            sb.append("centerInside");
            sb.append('\n');
        }
        if (wVar.g != null) {
            int size = wVar.g.size();
            for (int i = 0; i < size; i++) {
                sb.append(wVar.g.get(i).a());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    static File a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @TargetApi(18)
    static long a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = ((Build.VERSION.SDK_INT < 18 ? statFs.getBlockCount() : statFs.getBlockCountLong()) * (Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        return (int) ((((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * 1048576) / 7);
    }

    static boolean c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            return Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0 : Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        } catch (SecurityException unused2) {
            return false;
        }
    }

    static <T> T a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static boolean a(b.e eVar) {
        return eVar.a(0L, f4110b) && eVar.a(8L, c);
    }

    static int a(Resources resources, w wVar) throws FileNotFoundException {
        if (wVar.e != 0 || wVar.d == null) {
            return wVar.e;
        }
        String authority = wVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + wVar.d);
        }
        List<String> pathSegments = wVar.d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + wVar.d);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + wVar.d);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + wVar.d);
    }

    static Resources a(Context context, w wVar) throws FileNotFoundException {
        if (wVar.e != 0 || wVar.d == null) {
            return context.getResources();
        }
        String authority = wVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + wVar.d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + wVar.d);
        }
    }

    static void a(Looper looper) {
        Handler handler = new Handler(looper) { // from class: com.squareup.picasso.ad.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    /* compiled from: Utils.java */
    static class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new a(runnable);
        }
    }

    /* compiled from: Utils.java */
    private static class a extends Thread {
        a(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            super.run();
        }
    }
}
