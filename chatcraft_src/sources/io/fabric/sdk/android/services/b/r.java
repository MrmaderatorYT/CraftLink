package io.fabric.sdk.android.services.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: IdManager.java */
/* loaded from: classes.dex */
public class r {
    private static final Pattern e = Pattern.compile("[^\\p{Alnum}]");
    private static final String f = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    c f4229a;

    /* renamed from: b, reason: collision with root package name */
    b f4230b;
    boolean c;
    q d;
    private final ReentrantLock g = new ReentrantLock();
    private final s h;
    private final boolean i;
    private final boolean j;
    private final Context k;
    private final String l;
    private final String m;
    private final Collection<io.fabric.sdk.android.h> n;

    /* compiled from: IdManager.java */
    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);

        public final int h;

        a(int i2) {
            this.h = i2;
        }
    }

    public r(Context context, String str, String str2, Collection<io.fabric.sdk.android.h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        }
        this.k = context;
        this.l = str;
        this.m = str2;
        this.n = collection;
        this.h = new s();
        this.f4229a = new c(context);
        this.d = new q();
        this.i = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!this.i) {
            io.fabric.sdk.android.c.g().a("Fabric", "Device ID collection disabled for " + context.getPackageName());
        }
        this.j = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (this.j) {
            return;
        }
        io.fabric.sdk.android.c.g().a("Fabric", "User information collection disabled for " + context.getPackageName());
    }

    public boolean a() {
        return this.j;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return e.matcher(str).replaceAll(BuildConfig.FLAVOR).toLowerCase(Locale.US);
    }

    public String b() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        SharedPreferences sharedPreferencesA = i.a(this.k);
        b(sharedPreferencesA);
        String string = sharedPreferencesA.getString("crashlytics.installation.id", null);
        return string == null ? a(sharedPreferencesA) : string;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return e() + "/" + f();
    }

    public String e() {
        return b(Build.VERSION.RELEASE);
    }

    public String f() {
        return b(Build.VERSION.INCREMENTAL);
    }

    public String g() {
        return String.format(Locale.US, "%s/%s", b(Build.MANUFACTURER), b(Build.MODEL));
    }

    private String b(String str) {
        return str.replaceAll(f, BuildConfig.FLAVOR);
    }

    @SuppressLint({"CommitPrefEdits"})
    private String a(SharedPreferences sharedPreferences) {
        this.g.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.g.unlock();
        }
    }

    private void b(SharedPreferences sharedPreferences) {
        b bVarL = l();
        if (bVarL != null) {
            a(sharedPreferences, bVarL.f4202a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void a(SharedPreferences sharedPreferences, String str) {
        this.g.lock();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String string = sharedPreferences.getString("crashlytics.advertising.id", null);
            if (TextUtils.isEmpty(string)) {
                sharedPreferences.edit().putString("crashlytics.advertising.id", str).commit();
            } else if (!string.equals(str)) {
                sharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str).commit();
            }
        } finally {
            this.g.unlock();
        }
    }

    public Map<a, String> h() {
        HashMap map = new HashMap();
        for (Object obj : this.n) {
            if (obj instanceof m) {
                for (Map.Entry<a, String> entry : ((m) obj).e().entrySet()) {
                    a(map, entry.getKey(), entry.getValue());
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public String i() {
        return this.h.a(this.k);
    }

    public Boolean j() {
        if (k()) {
            return m();
        }
        return null;
    }

    private void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }

    protected boolean k() {
        return this.i && !this.d.b(this.k);
    }

    synchronized b l() {
        if (!this.c) {
            this.f4230b = this.f4229a.a();
            this.c = true;
        }
        return this.f4230b;
    }

    private Boolean m() {
        b bVarL = l();
        if (bVarL != null) {
            return Boolean.valueOf(bVarL.f4203b);
        }
        return null;
    }
}
