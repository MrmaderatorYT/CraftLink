package mattecarra.usavsursschat;

import a.a.a.f.a;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.f;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.h;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mattecarra.usavsursschat.SingleInputForms.AddAccountForm;
import mattecarra.usavsursschat.SingleInputForms.AddServerForm;
import mattecarra.usavsursschat.activities.LogPickerActivity;
import mattecarra.usavsursschat.activities.Settings;
import mattecarra.usavsursschat.c.a;
import mattecarra.usavsursschat.c.b;
import mattecarra.usavsursschat.e.g;
import mattecarra.usavsursschat.g.b;
import mattecarra.usavsursschat.g.c;
import mattecarra.usavsursschat.g.d;
import mattecarra.usavsursschat.j.a;
import me.relex.circleindicator.CircleIndicator;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class LoginActivity extends b implements a.InterfaceC0113a, a.b, b.a {
    private com.google.android.gms.ads.g B;
    private RecyclerView j;
    private mattecarra.usavsursschat.e.g k;
    private ViewPager l;
    private a v;
    private List<mattecarra.usavsursschat.b.e> w;
    private mattecarra.usavsursschat.j.a y;
    private FloatingActionButton z;
    private ArrayList<mattecarra.usavsursschat.b.d> x = new ArrayList<>();
    private boolean A = false;
    private boolean C = false;
    private d.a D = new d.a() { // from class: mattecarra.usavsursschat.LoginActivity.1
        @Override // mattecarra.usavsursschat.g.d.a
        public void a(mattecarra.usavsursschat.b.d dVar) {
            int iIndexOf = LoginActivity.this.x.indexOf(dVar);
            LoginActivity.this.o.g(dVar.a());
            LoginActivity.this.x.remove(iIndexOf);
            LoginActivity.this.k.f(iIndexOf);
            if (LoginActivity.this.z.isShown()) {
                return;
            }
            LoginActivity.this.z.b();
        }

        @Override // mattecarra.usavsursschat.g.d.a
        public void b(mattecarra.usavsursschat.b.d dVar) {
            mattecarra.usavsursschat.g.c cVar = new mattecarra.usavsursschat.g.c(dVar, LoginActivity.this, new c.a() { // from class: mattecarra.usavsursschat.LoginActivity.1.1
                @Override // mattecarra.usavsursschat.g.c.a
                public void a(String str, mattecarra.usavsursschat.b.c cVar2) {
                    LoginActivity.this.k.a(str, new mattecarra.usavsursschat.b.d(cVar2));
                }
            });
            cVar.b();
            LoginActivity.this.a(cVar.a());
        }

        @Override // mattecarra.usavsursschat.g.d.a
        public void c(mattecarra.usavsursschat.b.d dVar) {
            mattecarra.usavsursschat.j.b.a(LoginActivity.this, dVar);
        }
    };
    private g.a E = new g.a() { // from class: mattecarra.usavsursschat.LoginActivity.5
        @Override // mattecarra.usavsursschat.e.f
        public void a(int i, View view, boolean z) {
            if (!z) {
                if (!LoginActivity.this.w.isEmpty() && LoginActivity.this.l.getCurrentItem() < LoginActivity.this.w.size()) {
                    String strA = ((mattecarra.usavsursschat.b.e) LoginActivity.this.w.get(LoginActivity.this.l.getCurrentItem())).a();
                    LoginActivity.this.n.a(strA);
                    Intent intent = new Intent(LoginActivity.this, (Class<?>) ChatCraftActivity.class);
                    mattecarra.usavsursschat.b.d dVar = (mattecarra.usavsursschat.b.d) LoginActivity.this.x.get(i);
                    if (dVar == null) {
                        return;
                    }
                    intent.putExtra("username", strA);
                    intent.putExtra("serverName", dVar.a());
                    intent.putExtra("ip", dVar.b());
                    intent.putExtra("port", dVar.c());
                    intent.putExtra("version", dVar.d());
                    LoginActivity.this.startActivityForResult(intent, 1999);
                    return;
                }
                AddAccountForm.a(LoginActivity.this, new Object[0][]);
                return;
            }
            if (!((mattecarra.usavsursschat.b.d) LoginActivity.this.x.get(i)).e()) {
                Toast.makeText(LoginActivity.this, R.string.cant_remove_this_server, 0).show();
            } else {
                LoginActivity.this.a(new mattecarra.usavsursschat.g.d((mattecarra.usavsursschat.b.d) LoginActivity.this.x.get(i), LoginActivity.this, LoginActivity.this.D).a());
            }
        }
    };

    public mattecarra.usavsursschat.InAppPurchase.a n() {
        return this;
    }

    @Override // mattecarra.usavsursschat.b
    protected View q() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (u()) {
            return;
        }
        try {
            if (!this.B.b() && !this.B.a()) {
                System.out.println("Loading ad");
                this.B.a(new c.a().b("1F29E8B6350064A88A57FF0D26459B2E").a());
            } else {
                System.out.println("Ad is already loaded or is still loding");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k() {
        if (u()) {
            return;
        }
        try {
            if (this.B == null) {
                return;
            }
            if (this.B.a()) {
                System.out.println("Showing interstitial");
                this.B.c();
            } else {
                System.out.println("Interstial is not loaded. Loading and showing right now!");
                this.C = true;
                o();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // mattecarra.usavsursschat.b, mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        RecyclerView.i linearLayoutManager;
        Parcelable[] parcelableArray;
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        h.a(getApplicationContext(), "ca-app-pub-4499087698213644~2968231019");
        try {
            a((Toolbar) findViewById(R.id.toolbar));
        } catch (Throwable unused) {
        }
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (Exception unused2) {
        }
        this.w = this.o.a();
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("servers")) == null) {
            y();
        } else {
            for (Parcelable parcelable : parcelableArray) {
                if (parcelable != null) {
                    this.x.add((mattecarra.usavsursschat.b.d) parcelable);
                }
            }
        }
        this.j = (RecyclerView) findViewById(R.id.servers_recyclerview);
        this.j.setHasFixedSize(true);
        if (getResources().getConfiguration().orientation == 2) {
            linearLayoutManager = new GridLayoutManager(this, 2);
        } else {
            linearLayoutManager = new LinearLayoutManager(this);
        }
        this.j.setLayoutManager(linearLayoutManager);
        this.k = new mattecarra.usavsursschat.e.g(this.x, this.E);
        this.j.setAdapter(this.k);
        this.l = (ViewPager) findViewById(R.id.accounts_view_pager);
        this.v = new a(j());
        this.l.setAdapter(this.v);
        String strA = this.n.a();
        if (strA != null) {
            int i = 0;
            while (true) {
                if (i >= this.w.size()) {
                    i = -1;
                    break;
                } else if (strA.equals(this.w.get(i).a())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != 0) {
                this.l.a(i, false);
            }
        }
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(this.l);
        this.v.a(circleIndicator.getDataSetObserver());
        this.z = (FloatingActionButton) findViewById(R.id.add_server_button);
        this.z.setOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.LoginActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddServerForm.a(LoginActivity.this, new Object[0][]);
            }
        });
        this.j.a(new mattecarra.usavsursschat.i.d(this.z));
        this.y = new mattecarra.usavsursschat.j.a(new a.InterfaceC0118a() { // from class: mattecarra.usavsursschat.LoginActivity.7
            @Override // mattecarra.usavsursschat.j.a.InterfaceC0118a
            public void a(mattecarra.usavsursschat.b.d dVar) {
                int iIndexOf = LoginActivity.this.x.indexOf(dVar);
                if (iIndexOf != -1) {
                    LoginActivity.this.k.d(iIndexOf);
                }
            }
        }, this);
        this.A = true;
        try {
            new a.C0002a(this).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(true).a(getString(R.string.tutorial_add_account)).a(this.l).b("add_account").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.LoginActivity.8
                @Override // a.a.a.a.c
                public void a(String str) {
                    LoginActivity.this.p();
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
        this.B = new com.google.android.gms.ads.g(this);
        this.B.a("ca-app-pub-4499087698213644/5353181815");
        this.B.a(new com.google.android.gms.ads.a() { // from class: mattecarra.usavsursschat.LoginActivity.9
            @Override // com.google.android.gms.ads.a
            public void c() {
                LoginActivity.this.o();
            }

            @Override // com.google.android.gms.ads.a
            public void a() {
                if (LoginActivity.this.C) {
                    LoginActivity.this.k();
                    LoginActivity.this.C = false;
                }
            }
        });
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        AddAccountForm.a(this, new Object[0][]);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArray("servers", (Parcelable[]) this.x.toArray(new mattecarra.usavsursschat.b.d[this.x.size()]));
    }

    private void y() {
        ArrayList<mattecarra.usavsursschat.b.c> arrayListB = this.o.b();
        this.x.clear();
        for (mattecarra.usavsursschat.b.c cVar : arrayListB) {
            this.x.add(new mattecarra.usavsursschat.b.d(cVar.a(), cVar.b(), cVar.c(), cVar.d()));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_settings) {
            Settings.a(this);
            return true;
        }
        if (itemId == R.id.action_logs) {
            LogPickerActivity.a(this);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        this.y.a();
        super.onStart();
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        this.y.b();
        super.onStop();
    }

    @Override // mattecarra.usavsursschat.b, mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        this.x.clear();
        this.w.clear();
        this.y.b();
        try {
            ChatCraftApplication.f4809a.b(this);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // mattecarra.usavsursschat.c.a.InterfaceC0113a
    public void a(String str) {
        this.o.e(str);
        new mattecarra.usavsursschat.f.b(this).a(str);
        Iterator<mattecarra.usavsursschat.b.e> it = this.w.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            mattecarra.usavsursschat.b.e next = it.next();
            if (str.equals(next.a())) {
                System.out.println("Removed " + str);
                this.w.remove(next);
                break;
            }
        }
        this.v.c();
    }

    @Override // mattecarra.usavsursschat.c.a.b
    public void b(String str) {
        System.out.println("Edit account " + str);
        for (final mattecarra.usavsursschat.b.e eVar : this.w) {
            if (str.equals(eVar.a())) {
                this.m.add(new WeakReference<>(new mattecarra.usavsursschat.g.b(eVar, this, new b.InterfaceC0115b() { // from class: mattecarra.usavsursschat.LoginActivity.10
                    @Override // mattecarra.usavsursschat.g.b.InterfaceC0115b
                    public void a(String str2, mattecarra.usavsursschat.b.e eVar2) throws JSONException {
                        LoginActivity.this.o.a(str2, eVar2);
                        LoginActivity.this.w.remove(eVar);
                        LoginActivity.this.w.add(eVar2);
                        LoginActivity.this.v.c();
                    }

                    @Override // mattecarra.usavsursschat.g.b.InterfaceC0115b
                    public void a() {
                        Toast.makeText(LoginActivity.this, "Failed to edit account! Premium verification failed!", 0).show();
                    }
                }).a()));
                System.out.println("Showed!");
                return;
            }
        }
    }

    @Override // mattecarra.usavsursschat.c.b.a
    public void F_() {
        p();
    }

    private void z() {
        try {
            new a.C0002a(this).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(getString(R.string.tutorial_add_server)).a(this.z).b("add_server").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.LoginActivity.11
                @Override // a.a.a.a.c
                public void a(String str) {
                    AddServerForm.a(LoginActivity.this, new Object[0][]);
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    private void A() {
        try {
            new a.C0002a(this).b(false).c(false).d(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(getString(R.string.tutorial_join_server)).a(this.j).b("join_server").a(-1).a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.LoginActivity.12
                @Override // a.a.a.a.c
                public void a(String str) {
                    LoginActivity.this.B();
                }
            }).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            if (toolbar.getChildCount() > 0) {
                new a.C0002a(this).b(false).c(false).d(true).a(a.a.a.c.c.RIGHT).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(getString(R.string.tutorial_settings)).a(toolbar.getChildAt(toolbar.getChildCount() - 1)).b("settings").a(-1).a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.LoginActivity.2
                    @Override // a.a.a.a.c
                    public void a(String str) {
                    }
                }).b();
            }
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    @Override // mattecarra.usavsursschat.InAppPurchase.a, androidx.fragment.app.d, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4321) {
            if (i2 == -1) {
                if (intent != null && intent.hasExtra("username")) {
                    this.w.add(this.o.c(intent.getStringExtra("username")));
                } else {
                    this.w.clear();
                    this.w = this.o.a();
                }
                this.v.c();
            }
            if (this.A) {
                z();
            }
        } else if (i == 4231) {
            if (i2 == -1) {
                if (intent != null && intent.hasExtra("name")) {
                    System.out.println("Intent add server has name");
                    mattecarra.usavsursschat.b.c cVarH = this.o.h(intent.getStringExtra("name"));
                    System.out.println("Server: " + cVarH);
                    this.k.a(new mattecarra.usavsursschat.b.d(cVarH));
                } else {
                    y();
                    this.k.e();
                }
            }
            if (this.A) {
                A();
            }
        } else if (i == 1999) {
            if (intent != null) {
                if (intent.getBooleanExtra("PREMIUM_ERROR", false) && intent.hasExtra("username")) {
                    mattecarra.usavsursschat.i.f.a(this, intent.getStringExtra("username"));
                    return;
                } else if (intent.hasExtra("KICK_REASON")) {
                    com.afollestad.materialdialogs.f fVarB = new f.a(this).a(R.string.disconnected).b(intent.getStringExtra("KICK_REASON")).c("Ok").b(new f.j() { // from class: mattecarra.usavsursschat.LoginActivity.4
                        @Override // com.afollestad.materialdialogs.f.j
                        public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) {
                            LoginActivity.this.k();
                        }
                    }).a(new DialogInterface.OnCancelListener() { // from class: mattecarra.usavsursschat.LoginActivity.3
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            LoginActivity.this.k();
                        }
                    }).b();
                    a(fVarB);
                    fVarB.show();
                } else {
                    Toast.makeText(this, "Disconnected from the server!", 1).show();
                    k();
                }
            } else {
                k();
            }
        } else if ((i == 2002 || i == 2003) && intent != null && i2 == -1 && intent.hasExtra("buy")) {
            e(intent.getStringExtra("buy"));
        }
        super.onActivityResult(i, i2, intent);
    }

    public List<mattecarra.usavsursschat.b.e> l() {
        return this.w;
    }

    public ArrayList<mattecarra.usavsursschat.b.d> m() {
        return this.x;
    }

    public class a extends m {
        public a(androidx.fragment.app.h hVar) {
            super(hVar);
        }

        @Override // androidx.viewpager.widget.a
        public int b() {
            return LoginActivity.this.w.size() + 1;
        }

        @Override // androidx.viewpager.widget.a
        public int a(Object obj) {
            if (!(obj instanceof mattecarra.usavsursschat.c.a)) {
                return -2;
            }
            int i = 0;
            while (true) {
                if (i >= LoginActivity.this.w.size()) {
                    i = -1;
                    break;
                }
                if (((mattecarra.usavsursschat.b.e) LoginActivity.this.w.get(i)).a().equals(((mattecarra.usavsursschat.c.a) obj).a())) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                return i;
            }
            return -2;
        }

        @Override // androidx.fragment.app.m
        public Fragment a(int i) {
            mattecarra.usavsursschat.b.e eVar;
            if (i == b() - 1 || (eVar = (mattecarra.usavsursschat.b.e) LoginActivity.this.w.get(i)) == null) {
                return new mattecarra.usavsursschat.c.b();
            }
            return mattecarra.usavsursschat.c.a.a(eVar.a(), eVar.f());
        }
    }
}
