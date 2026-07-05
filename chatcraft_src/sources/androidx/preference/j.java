package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceManager.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Context f995a;
    private SharedPreferences c;
    private e d;
    private SharedPreferences.Editor e;
    private boolean f;
    private String g;
    private int h;
    private PreferenceScreen j;
    private d k;
    private c l;
    private a m;
    private b n;

    /* renamed from: b, reason: collision with root package name */
    private long f996b = 0;
    private int i = 0;

    /* compiled from: PreferenceManager.java */
    public interface a {
        void c(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    public interface b {
        void b(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    public interface c {
        boolean b(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    public static abstract class d {
        public abstract boolean a(Preference preference, Preference preference2);

        public abstract boolean b(Preference preference, Preference preference2);
    }

    public j(Context context) {
        this.f995a = context;
        a(a(context));
    }

    public PreferenceScreen a(Context context, int i, PreferenceScreen preferenceScreen) {
        a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).a(i, preferenceScreen);
        preferenceScreen2.a(this);
        a(false);
        return preferenceScreen2;
    }

    long a() {
        long j;
        synchronized (this) {
            j = this.f996b;
            this.f996b = 1 + j;
        }
        return j;
    }

    public void a(String str) {
        this.g = str;
        this.c = null;
    }

    public e b() {
        return this.d;
    }

    public SharedPreferences c() {
        Context contextA;
        if (b() != null) {
            return null;
        }
        if (this.c == null) {
            if (this.i == 1) {
                contextA = androidx.core.a.a.a(this.f995a);
            } else {
                contextA = this.f995a;
            }
            this.c = contextA.getSharedPreferences(this.g, this.h);
        }
        return this.c;
    }

    private static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public PreferenceScreen d() {
        return this.j;
    }

    public boolean a(PreferenceScreen preferenceScreen) {
        if (preferenceScreen == this.j) {
            return false;
        }
        if (this.j != null) {
            this.j.M();
        }
        this.j = preferenceScreen;
        return true;
    }

    public Preference a(CharSequence charSequence) {
        if (this.j == null) {
            return null;
        }
        return this.j.c(charSequence);
    }

    SharedPreferences.Editor e() {
        if (this.d != null) {
            return null;
        }
        if (this.f) {
            if (this.e == null) {
                this.e = c().edit();
            }
            return this.e;
        }
        return c().edit();
    }

    boolean f() {
        return !this.f;
    }

    private void a(boolean z) {
        if (!z && this.e != null) {
            this.e.apply();
        }
        this.f = z;
    }

    public d g() {
        return this.k;
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    public void a(Preference preference) {
        if (this.m != null) {
            this.m.c(preference);
        }
    }

    public void a(c cVar) {
        this.l = cVar;
    }

    public c h() {
        return this.l;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public b i() {
        return this.n;
    }
}
