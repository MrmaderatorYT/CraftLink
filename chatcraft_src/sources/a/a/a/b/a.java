package a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferencesManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f5a;

    public a(Context context) {
        this.f5a = context.getSharedPreferences("material_intro_preferences", 0);
    }

    public boolean a(String str) {
        return this.f5a.getBoolean(str, false);
    }

    public void b(String str) {
        this.f5a.edit().putBoolean(str, true).apply();
    }
}
