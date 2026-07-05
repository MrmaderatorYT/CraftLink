package mattecarra.usavsursschat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.f;
import java.io.File;
import java.util.ArrayList;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.e.d;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* loaded from: classes.dex */
public class LogPickerActivity extends c implements d.a {
    private RecyclerView j;
    private LinearLayoutManager k;
    private d l;
    private ArrayList<String[]> m = new ArrayList<>();

    public static void a(LoginActivity loginActivity) {
        loginActivity.startActivityForResult(new Intent(loginActivity, (Class<?>) LogPickerActivity.class), 2003);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log_picker);
        try {
            a((Toolbar) findViewById(R.id.toolbar));
            a().b(true);
            a().a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!mattecarra.usavsursschat.InAppPurchase.a.v()) {
            new f.a(this).a(R.string.logs_title).d(R.string.logs_ask_for_premium_features).g(R.string.yes).d("No").a(new f.j() { // from class: mattecarra.usavsursschat.activities.LogPickerActivity.2
                @Override // com.afollestad.materialdialogs.f.j
                public void a(f fVar, b bVar) {
                    Intent intent = new Intent();
                    intent.putExtra("buy", "chatcraft_pro_features");
                    LogPickerActivity.this.setResult(-1, intent);
                    LogPickerActivity.this.finish();
                }
            }).b(new f.j() { // from class: mattecarra.usavsursschat.activities.LogPickerActivity.1
                @Override // com.afollestad.materialdialogs.f.j
                public void a(f fVar, b bVar) {
                    if (bVar != b.POSITIVE) {
                        LogPickerActivity.this.finish();
                    }
                }
            }).c();
            return;
        }
        File[] fileArrListFiles = new File(getFilesDir(), "logs").listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            final mattecarra.usavsursschat.f fVar = new mattecarra.usavsursschat.f(this);
            if (!fVar.c()) {
                new f.a(this).a(R.string.logs_title).d(R.string.ask_activate_log).g(R.string.yes).d("No").b(new f.j() { // from class: mattecarra.usavsursschat.activities.LogPickerActivity.3
                    @Override // com.afollestad.materialdialogs.f.j
                    public void a(f fVar2, b bVar) {
                        if (bVar == b.POSITIVE) {
                            fVar.a(true);
                        }
                        LogPickerActivity.this.finish();
                    }
                }).c();
            } else {
                new f.a(this).a(R.string.logs_title).d(R.string.no_logs).c("Ok").b(new f.j() { // from class: mattecarra.usavsursschat.activities.LogPickerActivity.4
                    @Override // com.afollestad.materialdialogs.f.j
                    public void a(f fVar2, b bVar) {
                        LogPickerActivity.this.finish();
                    }
                }).c();
            }
        } else {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                String strSubstring = BuildConfig.FLAVOR;
                try {
                    String str = name.split(" ")[0];
                    try {
                        strSubstring = name.substring(name.indexOf(32) + 1);
                        name = str;
                    } catch (Exception e2) {
                        e = e2;
                        name = str;
                        e.printStackTrace();
                        this.m.add(new String[]{name, strSubstring});
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                this.m.add(new String[]{name, strSubstring});
            }
        }
        this.j = (RecyclerView) findViewById(R.id.log_recycler);
        this.j.setHasFixedSize(true);
        this.k = new LinearLayoutManager(this);
        this.k.b(true);
        this.k.a(true);
        this.j.setLayoutManager(this.k);
        this.l = new d(this.m, this);
        this.j.setAdapter(this.l);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // mattecarra.usavsursschat.e.d.a
    public void a(int i, View view) {
        String[] strArr = this.m.get(i);
        File file = new File(new File(getFilesDir(), "logs"), strArr[0] + " " + strArr[1]);
        if (file.exists()) {
            file.delete();
            this.l.a(strArr);
        }
    }

    @Override // mattecarra.usavsursschat.e.f
    public void a(int i, View view, boolean z) {
        String[] strArr = this.m.get(i);
        LogViewerActivity.a(strArr[0] + " " + strArr[1], this);
    }
}
