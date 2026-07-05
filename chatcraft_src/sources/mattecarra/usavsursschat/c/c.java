package mattecarra.usavsursschat.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.squareup.a.h;
import mattecarra.usavsursschat.ChatCraftActivity;
import mattecarra.usavsursschat.ChatCraftApplication;

/* compiled from: ChatCraftFragment.java */
/* loaded from: classes.dex */
public abstract class c extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    protected ChatCraftActivity f4939a;

    protected abstract int af();

    protected abstract View ag();

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.f4939a = (ChatCraftActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(View view, Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.a(view, bundle);
        ChatCraftApplication.f4809a.a(new Object() { // from class: mattecarra.usavsursschat.c.c.1
            @h
            public void onRefreshPayments(mattecarra.usavsursschat.a.a.c cVar) {
                System.out.println("Received " + cVar.a());
                if (cVar.a()) {
                    c.this.a();
                }
            }
        });
        ae();
    }

    protected void a() {
        AdView adView;
        try {
            if (ag() == null || af() == -1 || (adView = (AdView) ag().findViewById(af())) == null) {
                return;
            }
            adView.c();
            adView.setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void ae() {
        try {
            if (af() == -1) {
                return;
            }
            AdView adView = (AdView) ag().findViewById(af());
            if (!ChatCraftActivity.u()) {
                com.google.android.gms.ads.c cVarA = new c.a().b("1F29E8B6350064A88A57FF0D26459B2E").a();
                adView.setEnabled(true);
                adView.a(cVarA);
            } else {
                adView.setVisibility(8);
                adView.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void v() {
        AdView adView;
        super.v();
        try {
            if (ChatCraftActivity.u() || (adView = (AdView) ag().findViewById(af())) == null) {
                return;
            }
            adView.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x() {
        AdView adView;
        try {
            if (ag() != null && (adView = (AdView) ag().findViewById(af())) != null) {
                adView.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            super.x();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w() {
        AdView adView;
        try {
            if (!ChatCraftActivity.u() && (adView = (AdView) ag().findViewById(af())) != null) {
                adView.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.w();
    }
}
