package io.fabric.sdk.android.services.b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: CommonUtils.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f4214b;
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long d = -1;

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<File> f4213a = new Comparator<File>() { // from class: io.fabric.sdk.android.services.b.i.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    public static String b(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r2[1];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            boolean r0 = r6.exists()
            r1 = 0
            if (r0 == 0) goto L63
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r3 = 1024(0x400, float:1.435E-42)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
        L13:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r2 == 0) goto L34
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r4 = 2
            java.lang.String[] r2 = r3.split(r2, r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            int r3 = r2.length     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r4 = 1
            if (r3 <= r4) goto L13
            r3 = 0
            r3 = r2[r3]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            boolean r3 = r3.equals(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r3 == 0) goto L13
            r7 = r2[r4]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r1 = r7
        L34:
            java.lang.String r6 = "Failed to close system file reader."
            a(r0, r6)
            goto L63
        L3a:
            r7 = move-exception
            goto L41
        L3c:
            r6 = move-exception
            r0 = r1
            goto L5d
        L3f:
            r7 = move-exception
            r0 = r1
        L41:
            io.fabric.sdk.android.k r2 = io.fabric.sdk.android.c.g()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = "Error parsing "
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            r4.append(r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            r2.e(r3, r6, r7)     // Catch: java.lang.Throwable -> L5c
            goto L34
        L5c:
            r6 = move-exception
        L5d:
            java.lang.String r7 = "Failed to close system file reader."
            a(r0, r7)
            throw r6
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.b.i.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static int a() {
        return a.a().ordinal();
    }

    /* compiled from: CommonUtils.java */
    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, a> k = new HashMap(4);

        static {
            k.put("armeabi-v7a", ARMV7);
            k.put("armeabi", ARMV6);
            k.put("arm64-v8a", ARM64);
            k.put("x86", X86_32);
        }

        static a a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                io.fabric.sdk.android.c.g().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = k.get(str.toLowerCase(Locale.US));
            return aVar == null ? UNKNOWN : aVar;
        }
    }

    public static synchronized long b() {
        long jA;
        if (d == -1) {
            long j = 0;
            String strA = a(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty(strA)) {
                String upperCase = strA.toUpperCase(Locale.US);
                try {
                    if (upperCase.endsWith("KB")) {
                        jA = a(upperCase, "KB", 1024);
                    } else if (upperCase.endsWith("MB")) {
                        jA = a(upperCase, "MB", 1048576);
                    } else if (upperCase.endsWith("GB")) {
                        jA = a(upperCase, "GB", 1073741824);
                    } else {
                        io.fabric.sdk.android.c.g().a("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                    }
                    j = jA;
                } catch (NumberFormatException e) {
                    io.fabric.sdk.android.c.g().e("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                }
            }
            d = j;
        }
        return d;
    }

    static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    public static ActivityManager.RunningAppProcessInfo a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : BuildConfig.FLAVOR;
    }

    public static String a(String str) {
        return a(str, "SHA-1");
    }

    public static String b(String str) {
        return a(str, "SHA-256");
    }

    public static String b(InputStream inputStream) {
        return a(inputStream, "SHA-1");
    }

    private static String a(String str, String str2) {
        return a(str.getBytes(), str2);
    }

    private static String a(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Fabric", "Could not calculate hash for app icon.", e);
            return BuildConfig.FLAVOR;
        }
    }

    private static String a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            io.fabric.sdk.android.c.g().e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return BuildConfig.FLAVOR;
        }
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", BuildConfig.FLAVOR).toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        if (string.length() > 0) {
            return a(string);
        }
        return null;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long c(String str) {
        long blockSize = new StatFs(str).getBlockSize();
        return (r0.getBlockCount() * blockSize) - (blockSize * r0.getAvailableBlocks());
    }

    public static Float c(Context context) {
        if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return null;
        }
        return Float.valueOf(r3.getIntExtra("level", -1) / r3.getIntExtra("scale", -1));
    }

    public static boolean d(Context context) {
        return (f(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static void a(Context context, String str) {
        if (e(context)) {
            io.fabric.sdk.android.c.g().a("Fabric", str);
        }
    }

    public static void a(Context context, String str, Throwable th) {
        if (e(context)) {
            io.fabric.sdk.android.c.g().e("Fabric", str);
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        if (e(context)) {
            io.fabric.sdk.android.c.g().a(i, "Fabric", str2);
        }
    }

    public static boolean e(Context context) {
        if (f4214b == null) {
            f4214b = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return f4214b.booleanValue();
    }

    public static boolean a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iA = a(context, str, "bool");
            if (iA > 0) {
                return resources.getBoolean(iA);
            }
            int iA2 = a(context, str, "string");
            if (iA2 > 0) {
                return Boolean.parseBoolean(context.getString(iA2));
            }
        }
        return z;
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, j(context));
    }

    public static boolean f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean g(Context context) {
        boolean zF = f(context);
        String str = Build.TAGS;
        if ((zF || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zF && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int h(Context context) {
        int i = f(context) ? 1 : 0;
        if (g(context)) {
            i |= 2;
        }
        return c() ? i | 4 : i;
    }

    public static int a(Context context, boolean z) {
        Float fC = c(context);
        if (!z || fC == null) {
            return 1;
        }
        if (fC.floatValue() >= 99.0d) {
            return 3;
        }
        return ((double) fC.floatValue()) < 99.0d ? 2 : 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.DimensionIds.NETHER;
            int i3 = i * 2;
            cArr[i3] = c[i2 >>> 4];
            cArr[i3 + 1] = c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String b(Context context, String str) {
        int iA = a(context, str, "string");
        return iA > 0 ? context.getString(iA) : BuildConfig.FLAVOR;
    }

    public static void a(Closeable closeable, String str) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                io.fabric.sdk.android.c.g().e("Fabric", str, e);
            }
        }
    }

    public static void a(Flushable flushable, String str) throws IOException {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                io.fabric.sdk.android.c.g().e("Fabric", str, e);
            }
        }
    }

    public static boolean d(String str) {
        return str == null || str.length() == 0;
    }

    public static String a(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static String k(Context context) throws Throwable {
        Throwable th;
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(l(context));
            try {
                try {
                    String strB = b(inputStreamOpenRawResource);
                    String str = d(strB) ? null : strB;
                    a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Exception e) {
                    e = e;
                    io.fabric.sdk.android.c.g().e("Fabric", "Could not calculate hash for app icon.", e);
                    a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamOpenRawResource = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenRawResource = null;
            a((Closeable) inputStreamOpenRawResource, "Failed to close icon input stream.");
            throw th;
        }
    }

    public static int l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m(Context context) throws Resources.NotFoundException {
        int iA = a(context, "io.fabric.android.build_id", "string");
        if (iA == 0) {
            iA = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (iA == 0) {
            return null;
        }
        String string = context.getResources().getString(iA);
        io.fabric.sdk.android.c.g().a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static String n(Context context) throws Resources.NotFoundException {
        int iA = a(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (iA == 0) {
            return null;
        }
        String string = context.getResources().getString(iA);
        io.fabric.sdk.android.c.g().a("Fabric", "Unity Editor version is: " + string);
        return string;
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean o(Context context) {
        if (!c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
