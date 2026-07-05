package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class xn {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f3583a = new xg(Looper.getMainLooper());

    @GuardedBy("mLock")
    private String d;

    @GuardedBy("this")
    private Pattern g;

    @GuardedBy("this")
    private Pattern h;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3584b = new Object();
    private boolean c = true;
    private boolean e = false;
    private boolean f = false;

    public final void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static boolean a(Context context) {
        boolean z;
        Context contextA = to.a(context);
        Intent intent = new Intent();
        intent.setClassName(contextA, "com.google.android.gms.ads.AdActivity");
        try {
            ResolveInfo resolveInfoResolveActivity = contextA.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null || resolveInfoResolveActivity.activityInfo == null) {
                xe.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
                return false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 16) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
                z = false;
            } else {
                z = true;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 32) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
                z = false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 128) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
                z = false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 256) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
                z = false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 512) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
                z = false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 1024) == 0) {
                xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
                z = false;
            }
            if ((resolveInfoResolveActivity.activityInfo.configChanges & 2048) != 0) {
                return z;
            }
            xe.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
            return false;
        } catch (Exception e) {
            xe.c("Could not verify that com.google.android.gms.ads.AdActivity is declared in AndroidManifest.xml", e);
            com.google.android.gms.ads.internal.ax.i().a(e, "AdUtil.hasAdActivity");
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        Context contextA = to.a(context);
        return com.google.android.gms.common.b.c.a(contextA).a(str, contextA.getPackageName()) == 0;
    }

    public static void a(Context context, String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zq(context, str, it.next()).c();
        }
    }

    public static void a(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        a(context, str, arrayList);
    }

    public final void a(Context context, List<String> list) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (TextUtils.isEmpty(awd.a(activity))) {
                return;
            }
            if (list == null) {
                xe.a("Cannot ping urls: empty list.");
            } else {
                if (!am.a(context)) {
                    xe.a("Cannot ping url because custom tabs is not supported");
                    return;
                }
                am amVar = new am();
                amVar.a(new xq(this, list, amVar, context));
                amVar.b(activity);
            }
        }
    }

    public static String a(InputStreamReader inputStreamReader) {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (i != -1) {
                sb.append(cArr, 0, i);
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean b(Context context) {
        if (this.e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new xu(this, null), intentFilter);
        this.e = true;
        return true;
    }

    public final boolean c(Context context) {
        if (this.f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new xt(this, null), intentFilter);
        this.f = true;
        return true;
    }

    public final void a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(b(context, str));
    }

    private static String d() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[Catch: Exception -> 0x00b6, all -> 0x00d2, TRY_LEAVE, TryCatch #3 {Exception -> 0x00b6, blocks: (B:30:0x009d, B:32:0x00a7), top: B:48:0x009d, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f3584b
            monitor-enter(r0)
            java.lang.String r1 = r4.d     // Catch: java.lang.Throwable -> Ld2
            if (r1 == 0) goto Lb
            java.lang.String r5 = r4.d     // Catch: java.lang.Throwable -> Ld2
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld2
            return r5
        Lb:
            if (r6 != 0) goto L13
            java.lang.String r5 = d()     // Catch: java.lang.Throwable -> Ld2
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld2
            return r5
        L13:
            com.google.android.gms.internal.ads.xv r1 = com.google.android.gms.ads.internal.ax.g()     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> Ld2
            java.lang.String r1 = r1.a(r5)     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> Ld2
            r4.d = r1     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> Ld2
        L1d:
            java.lang.String r1 = r4.d     // Catch: java.lang.Throwable -> Ld2
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ld2
            if (r1 == 0) goto L6e
            com.google.android.gms.internal.ads.bra.a()     // Catch: java.lang.Throwable -> Ld2
            boolean r1 = com.google.android.gms.internal.ads.aac.b()     // Catch: java.lang.Throwable -> Ld2
            if (r1 != 0) goto L68
            r1 = 0
            r4.d = r1     // Catch: java.lang.Throwable -> Ld2
            android.os.Handler r1 = com.google.android.gms.internal.ads.xn.f3583a     // Catch: java.lang.Throwable -> Ld2
            com.google.android.gms.internal.ads.xr r2 = new com.google.android.gms.internal.ads.xr     // Catch: java.lang.Throwable -> Ld2
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> Ld2
            r1.post(r2)     // Catch: java.lang.Throwable -> Ld2
        L3b:
            java.lang.String r1 = r4.d     // Catch: java.lang.Throwable -> Ld2
            if (r1 != 0) goto L6e
            java.lang.Object r1 = r4.f3584b     // Catch: java.lang.InterruptedException -> L45 java.lang.Throwable -> Ld2
            r1.wait()     // Catch: java.lang.InterruptedException -> L45 java.lang.Throwable -> Ld2
            goto L3b
        L45:
            java.lang.String r1 = d()     // Catch: java.lang.Throwable -> Ld2
            r4.d = r1     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r1 = "Interrupted, use default user agent: "
            java.lang.String r2 = r4.d     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Ld2
            int r3 = r2.length()     // Catch: java.lang.Throwable -> Ld2
            if (r3 == 0) goto L5e
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> Ld2
            goto L64
        L5e:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> Ld2
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Ld2
            r1 = r2
        L64:
            com.google.android.gms.internal.ads.xe.e(r1)     // Catch: java.lang.Throwable -> Ld2
            goto L3b
        L68:
            java.lang.String r1 = d(r5)     // Catch: java.lang.Throwable -> Ld2
            r4.d = r1     // Catch: java.lang.Throwable -> Ld2
        L6e:
            java.lang.String r1 = r4.d     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Ld2
            int r2 = r2.length()     // Catch: java.lang.Throwable -> Ld2
            int r2 = r2 + 10
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> Ld2
            int r3 = r3.length()     // Catch: java.lang.Throwable -> Ld2
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2
            r3.<init>(r2)     // Catch: java.lang.Throwable -> Ld2
            r3.append(r1)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r1 = " (Mobile; "
            r3.append(r1)     // Catch: java.lang.Throwable -> Ld2
            r3.append(r6)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> Ld2
            r4.d = r6     // Catch: java.lang.Throwable -> Ld2
            com.google.android.gms.common.b.b r5 = com.google.android.gms.common.b.c.a(r5)     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            boolean r5 = r5.a()     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            if (r5 == 0) goto Lc0
            java.lang.String r5 = r4.d     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            java.lang.String r6 = ";aia"
            java.lang.String r5 = r5.concat(r6)     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            r4.d = r5     // Catch: java.lang.Exception -> Lb6 java.lang.Throwable -> Ld2
            goto Lc0
        Lb6:
            r5 = move-exception
            com.google.android.gms.internal.ads.wp r6 = com.google.android.gms.ads.internal.ax.i()     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.a(r5, r1)     // Catch: java.lang.Throwable -> Ld2
        Lc0:
            java.lang.String r5 = r4.d     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = ")"
            java.lang.String r5 = r5.concat(r6)     // Catch: java.lang.Throwable -> Ld2
            r4.d = r5     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r5 = r4.d     // Catch: java.lang.Throwable -> Ld2
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld2
            return r5
        Ld2:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld2
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.b(android.content.Context, java.lang.String):java.lang.String");
    }

    protected static String d(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return d();
        }
    }

    public static String a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public final JSONObject a(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(e.getMessage());
            throw new JSONException(strValueOf.length() != 0 ? "Could not convert map to JSON: ".concat(strValueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject a(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return a(bundle);
        } catch (JSONException e) {
            xe.b("Error converting Bundle to JSON", e);
            return null;
        }
    }

    private final JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private final JSONArray a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(a((Collection<?>) obj));
            return;
        }
        if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                a(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
            return;
        }
        jSONArray.put(obj);
    }

    private final void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static Map<String, String> a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str : com.google.android.gms.ads.internal.ax.g().a(uri)) {
            map.put(str, uri.getQueryParameter(str));
        }
        return map;
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(strValueOf);
            xe.e(sb.toString());
            return 0;
        }
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] e() {
        return new int[]{0, 0};
    }

    public static int[] a(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        if (window != null && (viewFindViewById = window.findViewById(R.id.content)) != null) {
            return new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
        }
        return e();
    }

    public final int[] b(Activity activity) {
        int[] iArrA = a(activity);
        bra.a();
        bra.a();
        return new int[]{aac.b(activity, iArrA[0]), aac.b(activity, iArrA[1])};
    }

    public final int[] c(Activity activity) {
        int[] iArrE;
        View viewFindViewById;
        Window window = activity.getWindow();
        if (window != null && (viewFindViewById = window.findViewById(R.id.content)) != null) {
            iArrE = new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        } else {
            iArrE = e();
        }
        bra.a();
        bra.a();
        return new int[]{aac.b(activity, iArrE[0]), aac.b(activity, iArrE[1])};
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static AlertDialog.Builder e(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static bue f(Context context) {
        return new bue(context);
    }

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    public static PopupWindow a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    private static String p(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String a(Context context, View view, bqn bqnVar) throws JSONException {
        if (!((Boolean) bra.e().a(o.ab)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", bqnVar.e);
            jSONObject2.put("height", bqnVar.f2975b);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", p(context));
            if (!bqnVar.d) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    Object parent = view.getParent();
                    if (parent != null) {
                        int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", iIndexOfChild);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            xe.c("Fail to get view hierarchy json", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r3.importance != 100) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (q(r6) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(android.content.Context r6) {
        /*
            r0 = 0
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L4b
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Throwable -> L4b
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L4a
            if (r2 != 0) goto L16
            goto L4a
        L16:
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L1d
            return r0
        L1d:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L4b
        L21:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L49
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L4b
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L4b
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L4b
            int r5 = r3.pid     // Catch: java.lang.Throwable -> L4b
            if (r4 != r5) goto L21
            int r1 = r3.importance     // Catch: java.lang.Throwable -> L4b
            r3 = 100
            if (r1 != r3) goto L49
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L49
            boolean r6 = q(r6)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L49
            r6 = 1
            return r6
        L49:
            return r0
        L4a:
            return r0
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.g(android.content.Context):boolean");
    }

    public static boolean h(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    return !q(context);
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean q(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public final void a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.ax.e();
            bundle.putString("device", b());
            bundle.putString("eids", TextUtils.join(",", o.a()));
        }
        bra.a();
        aac.a(context, str, str2, bundle, z, new xs(this, context, str));
    }

    public final void b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) bra.e().a(o.aY)).booleanValue()) {
            a(context, str, str2, bundle, z);
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            xl.a(runnable);
        }
    }

    public static Bitmap b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap bitmapF = f(view);
        return bitmapF == null ? e(view) : bitmapF;
    }

    private static Bitmap e(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return bitmapCreateBitmap;
            }
            xe.e("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            xe.b("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap f(View view) {
        try {
            boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        } catch (RuntimeException e) {
            xe.b("Fail to capture the web view", e);
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap i(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                return f(window.getDecorView().getRootView());
            }
            return null;
        } catch (RuntimeException e) {
            xe.b("Fail to capture screen shot", e);
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static int j(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public final boolean a(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return a(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, r(context));
    }

    private static KeyguardManager r(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.view.View r4, android.os.PowerManager r5, android.app.KeyguardManager r6) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.xn r0 = com.google.android.gms.ads.internal.ax.e()
            boolean r0 = r0.c
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1d
            if (r6 != 0) goto Le
            r6 = 0
            goto L12
        Le:
            boolean r6 = r6.inKeyguardRestrictedInputMode()
        L12:
            if (r6 == 0) goto L1d
            boolean r6 = c(r4)
            if (r6 == 0) goto L1b
            goto L1d
        L1b:
            r6 = 0
            goto L1e
        L1d:
            r6 = 1
        L1e:
            int r0 = r4.getVisibility()
            if (r0 != 0) goto L63
            boolean r0 = r4.isShown()
            if (r0 == 0) goto L63
            if (r5 == 0) goto L35
            boolean r5 = r5.isScreenOn()
            if (r5 == 0) goto L33
            goto L35
        L33:
            r5 = 0
            goto L36
        L35:
            r5 = 1
        L36:
            if (r5 == 0) goto L63
            if (r6 == 0) goto L63
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.o.aV
            com.google.android.gms.internal.ads.l r6 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r5 = r6.a(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L62
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r4.getLocalVisibleRect(r5)
            if (r5 != 0) goto L62
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r4 = r4.getGlobalVisibleRect(r5)
            if (r4 == 0) goto L63
        L62:
            return r1
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.a(android.view.View, android.os.PowerManager, android.app.KeyguardManager):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.c(android.view.View):boolean");
    }

    @TargetApi(16)
    public static boolean k(Context context) {
        KeyguardManager keyguardManagerR;
        return context != null && com.google.android.gms.common.util.j.c() && (keyguardManagerR = r(context)) != null && keyguardManagerR.isKeyguardLocked();
    }

    public static int d(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean l(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            xe.b("Error loading class.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static Bundle c() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) bra.e().a(o.C)).booleanValue()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            Runtime runtime = Runtime.getRuntime();
            bundle.putLong("runtime_free_memory", runtime.freeMemory());
            bundle.putLong("runtime_max_memory", runtime.maxMemory());
            bundle.putLong("runtime_total_memory", runtime.totalMemory());
            bundle.putInt("web_view_count", com.google.android.gms.ads.internal.ax.i().j());
        } catch (Exception e) {
            xe.c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    @TargetApi(18)
    public static void a(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            b(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 26);
            sb.append("Opening ");
            sb.append(string);
            sb.append(" in a new browser.");
            xe.b(sb.toString());
        } catch (ActivityNotFoundException e) {
            xe.b("No browser is found.", e);
        }
    }

    @TargetApi(18)
    public static void b(Context context, Intent intent) {
        if (intent != null && com.google.android.gms.common.util.j.e()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("androidx.browser.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void b(Context context, String str, String str2) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(str2.getBytes("UTF-8"));
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e) {
            xe.b("Error writing to file in internal storage.", e);
        }
    }

    public static String c(Context context, String str) {
        try {
            return new String(com.google.android.gms.common.util.h.a(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            xe.b("Error reading from internal storage.");
            return BuildConfig.FLAVOR;
        }
    }

    @TargetApi(24)
    public static boolean a(Activity activity, Configuration configuration) {
        if (((Boolean) bra.e().a(o.cs)).booleanValue()) {
            return !activity.isInMultiWindowMode();
        }
        bra.a();
        int iA = aac.a(activity, configuration.screenHeightDp);
        int iA2 = aac.a(activity, configuration.screenWidthDp);
        DisplayMetrics displayMetricsA = a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = displayMetricsA.heightPixels;
        int i2 = displayMetricsA.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int iRound = ((int) Math.round(d + 0.5d)) * ((Integer) bra.e().a(o.cp)).intValue();
        return a(i, iA + dimensionPixelSize, iRound) && a(i2, iA2, iRound);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[Catch: all -> 0x0043, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x000d, B:11:0x0037, B:12:0x0041, B:10:0x0025), top: B:18:0x0009, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.g     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.ads.d<java.lang.String> r0 = com.google.android.gms.internal.ads.o.ad     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.g     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.ads.d<java.lang.String> r0 = com.google.android.gms.internal.ads.o.ad     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.g = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.g     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.d(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[Catch: all -> 0x0043, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x000d, B:11:0x0037, B:12:0x0041, B:10:0x0025), top: B:18:0x0009, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.h     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.ads.d<java.lang.String> r0 = com.google.android.gms.internal.ads.o.ae     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.h     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.ads.d<java.lang.String> r0 = com.google.android.gms.internal.ads.o.ae     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.h = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.h     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.e(java.lang.String):boolean");
    }

    private static boolean a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public static Bundle a(bnb bnbVar) {
        String strC;
        String strE;
        String strC2;
        if (bnbVar == null) {
            return null;
        }
        if (com.google.android.gms.ads.internal.ax.i().k().b() && com.google.android.gms.ads.internal.ax.i().k().d()) {
            return null;
        }
        if (bnbVar.d()) {
            bnbVar.c();
        }
        bmv bmvVarB = bnbVar.b();
        if (bmvVarB != null) {
            strC = bmvVarB.b();
            strC2 = bmvVarB.c();
            strE = bmvVarB.d();
            if (strC != null) {
                com.google.android.gms.ads.internal.ax.i().k().a(strC);
            }
            if (strE != null) {
                com.google.android.gms.ads.internal.ax.i().k().b(strE);
            }
        } else {
            strC = com.google.android.gms.ads.internal.ax.i().k().c();
            strE = com.google.android.gms.ads.internal.ax.i().k().e();
            strC2 = null;
        }
        Bundle bundle = new Bundle(1);
        if (strE != null && !com.google.android.gms.ads.internal.ax.i().k().d()) {
            bundle.putString("v_fp_vertical", strE);
        }
        if (strC != null && !com.google.android.gms.ads.internal.ax.i().k().b()) {
            bundle.putString("fingerprint", strC);
            if (!strC.equals(strC2)) {
                bundle.putString("v_fp", strC2);
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static WebResourceResponse c(Context context, String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("User-Agent", com.google.android.gms.ads.internal.ax.e().b(context, str));
            map.put("Cache-Control", "max-stale=3600");
            String str3 = new yz(context).a(str2, map).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            xe.c("Could not fetch MRAID JS.", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.webkit.WebResourceResponse a(java.net.HttpURLConnection r10) {
        /*
            com.google.android.gms.ads.internal.ax.e()
            java.lang.String r0 = r10.getContentType()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L12
            java.lang.String r0 = ""
        L10:
            r4 = r0
            goto L1f
        L12:
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            r0 = r0[r2]
            java.lang.String r0 = r0.trim()
            goto L10
        L1f:
            com.google.android.gms.ads.internal.ax.e()
            java.lang.String r0 = r10.getContentType()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L61
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r3 = 1
            if (r1 == r3) goto L61
            r1 = 1
        L37:
            int r5 = r0.length
            if (r1 >= r5) goto L61
            r5 = r0[r1]
            java.lang.String r5 = r5.trim()
            java.lang.String r6 = "charset"
            boolean r5 = r5.startsWith(r6)
            if (r5 == 0) goto L5e
            r5 = r0[r1]
            java.lang.String r5 = r5.trim()
            java.lang.String r6 = "="
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            if (r6 <= r3) goto L5e
            r0 = r5[r3]
            java.lang.String r0 = r0.trim()
            goto L63
        L5e:
            int r1 = r1 + 1
            goto L37
        L61:
            java.lang.String r0 = ""
        L63:
            r5 = r0
            java.util.Map r0 = r10.getHeaderFields()
            java.util.HashMap r8 = new java.util.HashMap
            int r1 = r0.size()
            r8.<init>(r1)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L79:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb3
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            if (r3 == 0) goto L79
            java.lang.Object r3 = r1.getValue()
            if (r3 == 0) goto L79
            java.lang.Object r3 = r1.getValue()
            java.util.List r3 = (java.util.List) r3
            int r3 = r3.size()
            if (r3 <= 0) goto L79
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r8.put(r3, r1)
            goto L79
        Lb3:
            com.google.android.gms.internal.ads.xv r3 = com.google.android.gms.ads.internal.ax.g()
            int r6 = r10.getResponseCode()
            java.lang.String r7 = r10.getResponseMessage()
            java.io.InputStream r9 = r10.getInputStream()
            android.webkit.WebResourceResponse r10 = r3.a(r4, r5, r6, r7, r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xn.a(java.net.HttpURLConnection):android.webkit.WebResourceResponse");
    }

    public static void a(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) bra.e().a(o.d)).booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (zBooleanValue) {
            com.google.android.gms.common.util.e.a(context, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final String m(final Context context) {
        if (!((Boolean) bra.e().a(o.cO)).booleanValue()) {
            return BuildConfig.FLAVOR;
        }
        try {
            return (String) xl.a(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.xo

                /* renamed from: a, reason: collision with root package name */
                private final xn f3585a;

                /* renamed from: b, reason: collision with root package name */
                private final Context f3586b;

                {
                    this.f3585a = this;
                    this.f3586b = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return !((Boolean) bra.e().a(o.cO)).booleanValue() ? BuildConfig.FLAVOR : this.f3586b.getSharedPreferences("mobileads_consent", 0).getString("consent_string", BuildConfig.FLAVOR);
                }
            }).get();
        } catch (InterruptedException unused) {
            Thread.interrupted();
            return BuildConfig.FLAVOR;
        } catch (ExecutionException unused2) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final Bundle n(final Context context) {
        if (!((Boolean) bra.e().a(o.cP)).booleanValue()) {
            return null;
        }
        try {
            return (Bundle) xl.a(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.xp

                /* renamed from: a, reason: collision with root package name */
                private final xn f3587a;

                /* renamed from: b, reason: collision with root package name */
                private final Context f3588b;

                {
                    this.f3587a = this;
                    this.f3588b = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f3588b;
                    if (!((Boolean) bra.e().a(o.cP)).booleanValue()) {
                        return null;
                    }
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
                    Bundle bundle = new Bundle();
                    if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                        bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
                    }
                    String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
                    for (int i = 0; i < 4; i++) {
                        String str = strArr[i];
                        if (defaultSharedPreferences.contains(str)) {
                            bundle.putString(str, defaultSharedPreferences.getString(str, null));
                        }
                    }
                    return bundle;
                }
            }).get();
        } catch (InterruptedException unused) {
            Thread.interrupted();
            return null;
        } catch (ExecutionException unused2) {
            return null;
        }
    }

    public static boolean o(Context context) {
        Window window;
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public static boolean f(String str) {
        if (!aag.c()) {
            return false;
        }
        if (!((Boolean) bra.e().a(o.cx)).booleanValue()) {
            return false;
        }
        String str2 = (String) bra.e().a(o.cz);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) bra.e().a(o.cy);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
