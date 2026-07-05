package mattecarra.usavsursschat.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import mattecarra.usavsursschat.e.c;
import mattecarra.usavsursschat.f.b;
import mattecarra.usavsursschat.i.d;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class CrackedPasswordManagerActivity extends c implements c.b {
    public b j;
    private String k;
    private List<String> l;
    private RecyclerView m;
    private mattecarra.usavsursschat.e.c n;

    @Override // mattecarra.usavsursschat.e.f
    public void a(int i, View view, boolean z) {
    }

    public static void a(Context context, String str) {
        if (str == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) CrackedPasswordManagerActivity.class);
        intent.putExtra("username", str);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cracked_password_manager);
        a((Toolbar) findViewById(R.id.toolbar));
        if (a() != null) {
            a().b(true);
        }
        try {
            this.k = getIntent().getStringExtra("username");
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        this.j = new b(this);
        this.l = this.j.b(this.k);
        if (this.l.isEmpty()) {
            return;
        }
        this.n = new mattecarra.usavsursschat.e.c(this.l, this);
        this.m = (RecyclerView) findViewById(R.id.recycler_view);
        this.m.setLayoutManager(new LinearLayoutManager(this));
        this.m.setAdapter(this.n);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.add_cracked_credentials);
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.activities.CrackedPasswordManagerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new mattecarra.usavsursschat.g.a(CrackedPasswordManagerActivity.this.k, CrackedPasswordManagerActivity.this).a();
            }
        });
        this.m.a(new d(floatingActionButton));
    }

    @Override // mattecarra.usavsursschat.e.c.b
    public void a(String str) {
        this.j.a(str, this.k);
        this.n.a(str);
    }

    @Override // mattecarra.usavsursschat.e.c.b
    public void b(final String str) {
        new f.a(this).a(R.string.cracked_password_edit_title).d(R.string.cracked_password_edit_desc).p(129).a("Password", BuildConfig.FLAVOR, new f.d() { // from class: mattecarra.usavsursschat.activities.CrackedPasswordManagerActivity.2
            @Override // com.afollestad.materialdialogs.f.d
            public void a(f fVar, CharSequence charSequence) throws JSONException {
                CrackedPasswordManagerActivity.this.j.a(str, CrackedPasswordManagerActivity.this.k, charSequence.toString());
            }
        }).c();
    }

    public void k() {
        this.l.clear();
        this.l.addAll(this.j.b(this.k));
        this.n.e();
    }
}
