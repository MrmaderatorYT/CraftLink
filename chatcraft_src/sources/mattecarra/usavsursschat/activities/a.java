package mattecarra.usavsursschat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.d;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.g;
import mattecarra.usavsursschat.ChatCraftActivity;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public class a extends g implements Preference.d {
    public static a ak() {
        Bundle bundle = new Bundle();
        a aVar = new a();
        aVar.g(bundle);
        return aVar;
    }

    @Override // androidx.preference.g
    public void a(Bundle bundle, String str) {
        e(R.xml.settingscreen);
        Preference preferenceA = a("no_ads");
        preferenceA.a(!ChatCraftActivity.u());
        preferenceA.a((Preference.d) this);
        Preference preferenceA2 = a("chatcraft_pro_features");
        preferenceA2.a(!ChatCraftActivity.v());
        preferenceA2.a((Preference.d) this);
        Preference preferenceA3 = a("all_in_one");
        preferenceA3.a((ChatCraftActivity.u() || ChatCraftActivity.v()) ? false : true);
        preferenceA3.a((Preference.d) this);
        ((CheckBoxPreference) a("save_logs")).a(mattecarra.usavsursschat.InAppPurchase.a.v());
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        ah().setFocusable(false);
    }

    @Override // androidx.preference.Preference.d
    public boolean a(Preference preference) {
        Intent intent = new Intent();
        intent.putExtra("buy", preference.C());
        d dVarN = n();
        if (dVarN == null) {
            return true;
        }
        dVarN.setResult(-1, intent);
        dVarN.finish();
        return true;
    }
}
