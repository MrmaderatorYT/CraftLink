package mattecarra.usavsursschat;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Arrays;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Preferences.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f4988a;

    public f(Context context) {
        this.f4988a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String a() {
        return this.f4988a.getString("ACTIVE_ACCOUNT", null);
    }

    public void a(String str) {
        SharedPreferences.Editor editorEdit = this.f4988a.edit();
        editorEdit.putString("ACTIVE_ACCOUNT", str);
        editorEdit.apply();
    }

    public boolean b() {
        return this.f4988a.getBoolean("auto_teleport", true);
    }

    public boolean c() {
        return this.f4988a.getBoolean("save_logs", false);
    }

    public void a(boolean z) {
        SharedPreferences.Editor editorEdit = this.f4988a.edit();
        editorEdit.putBoolean("save_logs", z);
        editorEdit.apply();
    }

    public boolean d() {
        return this.f4988a.getBoolean("skin_download", true);
    }

    public boolean e() {
        return this.f4988a.getBoolean("auto_login", true);
    }

    public List<String> f() {
        return Arrays.asList(this.f4988a.getString("commands", BuildConfig.FLAVOR).split("\\r?\\n"));
    }
}
