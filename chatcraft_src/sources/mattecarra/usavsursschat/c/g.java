package mattecarra.usavsursschat.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.a.h;
import mattecarra.usavsursschat.ChatCraftActivity;
import mattecarra.usavsursschat.ChatCraftApplication;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: UtilsFragment.java */
/* loaded from: classes.dex */
public class g extends c implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    private View f4960b;
    private TextView c;

    @Override // mattecarra.usavsursschat.c.c
    protected int af() {
        return R.id.ad_view_utils;
    }

    public static g ah() {
        return new g();
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
        return this.f4960b;
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalAccessException {
        this.f4960b = layoutInflater.inflate(R.layout.fragment_utils, viewGroup, false);
        this.f4960b.findViewById(R.id.go_avanti).setOnClickListener(this);
        this.f4960b.findViewById(R.id.go_indietro).setOnClickListener(this);
        this.f4960b.findViewById(R.id.go_left).setOnClickListener(this);
        this.f4960b.findViewById(R.id.go_right).setOnClickListener(this);
        this.f4960b.findViewById(R.id.flyDOWN).setOnClickListener(this);
        this.f4960b.findViewById(R.id.flyUP).setOnClickListener(this);
        this.f4960b.findViewById(R.id.respawnButton).setOnClickListener(this);
        this.c = (TextView) this.f4960b.findViewById(R.id.coordinate);
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (IllegalArgumentException unused) {
        }
        return this.f4960b;
    }

    @h
    public void onCoordinatesUpdate(mattecarra.usavsursschat.a.a.a.b bVar) {
        this.c.setText("X=" + a(bVar.a()) + " Y=" + a(bVar.b()) + " Z=" + a(bVar.c()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.respawnButton && !ChatCraftActivity.v()) {
            System.out.println("Stopping that");
            if (this.f4939a != null) {
                System.out.println("Showing snackbar?");
                this.f4939a.a(R.string.snackbar_premium_features_only, "Buy", -16777216, -1, -65536, new View.OnClickListener() { // from class: mattecarra.usavsursschat.c.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (g.this.f4939a != null) {
                            g.this.f4939a.e("chatcraft_pro_features");
                        }
                    }
                }).e();
                return;
            } else {
                Toast.makeText(l(), R.string.snackbar_premium_features_only, 0).show();
                return;
            }
        }
        int id = view.getId();
        if (id != R.id.respawnButton) {
            switch (id) {
                case R.id.flyDOWN /* 2131230837 */:
                    a(0.0d, -1.0d, 0.0d);
                    break;
                case R.id.flyUP /* 2131230838 */:
                    a(0.0d, 1.0d, 0.0d);
                    break;
                default:
                    switch (id) {
                        case R.id.go_avanti /* 2131230841 */:
                            a(0.0d, 0.0d, 1.0d);
                            break;
                        case R.id.go_indietro /* 2131230842 */:
                            a(0.0d, 0.0d, -1.0d);
                            break;
                        case R.id.go_left /* 2131230843 */:
                            a(-1.0d, 0.0d, 0.0d);
                            break;
                        case R.id.go_right /* 2131230844 */:
                            a(1.0d, 0.0d, 0.0d);
                            break;
                    }
            }
            return;
        }
        ChatCraftApplication.f4810b.c(new mattecarra.usavsursschat.a.b.c());
        Toast.makeText(l(), "Respawn packet has been sent.", 0).show();
    }

    private void a(final double d, final double d2, final double d3) {
        new Thread(new Runnable() { // from class: mattecarra.usavsursschat.c.g.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                for (int i = 0; i < 10; i++) {
                    ChatCraftApplication.f4810b.c(new mattecarra.usavsursschat.a.b.a(d / 10.0d, d2 / 10.0d, d3 / 10.0d));
                    try {
                        Thread.sleep(150L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public double a(double d) {
        double dRound = Math.round(d * 100.0d);
        Double.isNaN(dRound);
        return dRound / 100.0d;
    }
}
