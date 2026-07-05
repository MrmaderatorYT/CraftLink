package mattecarra.usavsursschat.c;

import android.content.ClipboardManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.squareup.a.h;
import mattecarra.usavsursschat.ChatCraftApplication;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: PlayerListFragment.java */
/* loaded from: classes.dex */
public class f extends c implements mattecarra.usavsursschat.e.f {

    /* renamed from: b, reason: collision with root package name */
    private View f4957b;
    private mattecarra.usavsursschat.e.e c;
    private RecyclerView d;
    private LinearLayoutManager e;

    @Override // mattecarra.usavsursschat.c.c
    protected int af() {
        return R.id.ad_view_info;
    }

    public static f ah() {
        return new f();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalAccessException {
        this.f4957b = layoutInflater.inflate(R.layout.fragment_info, viewGroup, false);
        this.d = (RecyclerView) this.f4957b.findViewById(R.id.onlinePlayer);
        if (o().getConfiguration().orientation == 2) {
            this.e = new GridLayoutManager(l(), 2);
        } else {
            this.e = new LinearLayoutManager(l());
        }
        this.c = new mattecarra.usavsursschat.e.e(this);
        this.d.setLayoutManager(this.e);
        this.d.setAdapter(this.c);
        if (bundle != null) {
            this.c.b(bundle);
        }
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (IllegalArgumentException unused) {
        }
        return this.f4957b;
    }

    @Override // androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        this.c.a(bundle);
        super.e(bundle);
    }

    @Override // mattecarra.usavsursschat.c.c, androidx.fragment.app.Fragment
    public void x() {
        try {
            ChatCraftApplication.f4809a.b(this);
        } catch (Throwable unused) {
        }
        this.f4939a = null;
        super.x();
    }

    @Override // mattecarra.usavsursschat.c.c
    protected View ag() {
        return this.f4957b;
    }

    @Override // mattecarra.usavsursschat.e.f
    public void a(int i, View view, boolean z) {
        final mattecarra.usavsursschat.b.b bVarA = this.c.a(i);
        if (bVarA == null) {
            return;
        }
        com.afollestad.materialdialogs.f fVarC = new f.a(l()).a("Choose action").a("Send private message", "Copy to clipboard", "Paste on chat").a(new f.e() { // from class: mattecarra.usavsursschat.c.f.1
            @Override // com.afollestad.materialdialogs.f.e
            public void a(com.afollestad.materialdialogs.f fVar, View view2, int i2, CharSequence charSequence) throws Resources.NotFoundException {
                switch (i2) {
                    case 0:
                        if (f.this.f4939a != null) {
                            f.this.f4939a.b(0);
                        }
                        ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.b("/m " + bVarA.a() + " "));
                        break;
                    case 1:
                        ((ClipboardManager) f.this.l().getSystemService("clipboard")).setText(bVarA.c());
                        Toast.makeText(f.this.l(), "Text copied to clipboard!", 0).show();
                        break;
                    case 2:
                        if (f.this.f4939a != null) {
                            f.this.f4939a.b(0);
                        }
                        ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.a(" " + bVarA.a() + " "));
                        break;
                }
            }
        }).c();
        if (this.f4939a != null) {
            this.f4939a.a(fVarC);
        }
    }

    @h
    public void onPlayerListUpdate(mattecarra.usavsursschat.a.a.a.f fVar) {
        mattecarra.usavsursschat.a.a.a.e eVarA = fVar.a();
        switch (fVar.b()) {
            case 0:
                if (eVarA.b() != null || eVarA.c() != null) {
                    SpannableString spannableStringA = eVarA.c() != null ? mattecarra.usavsursschat.i.e.a(eVarA.c()) : new SpannableString(eVarA.b());
                    if (spannableStringA.length() != 0) {
                        this.c.a(new mattecarra.usavsursschat.b.b(spannableStringA, eVarA.b(), eVarA.a()));
                        break;
                    }
                }
                break;
            case 1:
                if (eVarA.b() != null || eVarA.c() != null) {
                    if ((eVarA.c() != null ? mattecarra.usavsursschat.i.e.a(eVarA.c()) : new SpannableString(eVarA.b())).length() != 0) {
                        this.c.b(new mattecarra.usavsursschat.b.b(eVarA.c() != null ? mattecarra.usavsursschat.i.e.a(eVarA.c()) : new SpannableString(eVarA.b()), eVarA.b(), eVarA.a()));
                        break;
                    }
                }
                break;
            case 2:
                this.c.a(eVarA.a());
                break;
        }
    }
}
