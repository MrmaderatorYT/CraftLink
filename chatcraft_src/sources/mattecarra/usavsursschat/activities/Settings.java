package mattecarra.usavsursschat.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.h;
import me.zhanghai.android.materialprogressbar.R;

/* loaded from: classes.dex */
public class Settings extends c implements h.b {
    private a j;

    public static void a(Activity activity) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) Settings.class), 2002);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        if (bundle == null) {
            this.j = a.ak();
            j().a().a(R.id.content, this.j, "Settings").c();
        } else {
            this.j = (a) j().a("Settings");
        }
        j().a(this);
        a((Toolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarA = a();
        if (aVarA != null) {
            aVarA.b(true);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.h.b
    public void E_() {
        this.j = (a) j().a("Settings");
    }
}
