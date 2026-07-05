package mattecarra.usavsursschat.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import mattecarra.usavsursschat.ChatCraftActivity;

/* compiled from: ConnectionFragment.java */
/* loaded from: classes.dex */
public class e extends Fragment implements mattecarra.usavsursschat.e {

    /* renamed from: a, reason: collision with root package name */
    private mattecarra.usavsursschat.McClient.a f4955a = new mattecarra.usavsursschat.McClient.a(this);
    private String ag;

    /* renamed from: b, reason: collision with root package name */
    private ChatCraftActivity f4956b;
    private mattecarra.usavsursschat.f c;
    private mattecarra.usavsursschat.i.c d;
    private String e;
    private String f;
    private int g;
    private int h;
    private String i;

    public static e a(String str, String str2, int i, int i2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("server-name", str);
        bundle.putString("host", str2);
        bundle.putInt("port", i);
        bundle.putInt("version", i2);
        bundle.putString("username", str3);
        bundle.putString("cracked-password", str4);
        e eVar = new e();
        eVar.g(bundle);
        return eVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.f4956b = (ChatCraftActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c(true);
        Bundle bundleI = i();
        this.e = bundleI.getString("server-name");
        this.f = bundleI.getString("host");
        this.g = bundleI.getInt("port");
        this.h = bundleI.getInt("version");
        this.i = bundleI.getString("username");
        this.ag = bundleI.getString("cracked-password");
        this.c = new mattecarra.usavsursschat.f(l());
        this.d = new mattecarra.usavsursschat.i.c(l());
        try {
            this.f4955a.a();
        } catch (Exception e) {
            e.printStackTrace();
            com.crashlytics.android.a.a((Throwable) e);
            Intent intent = new Intent();
            intent.putExtra("ip", this.f);
            intent.putExtra("port", this.g);
            intent.putExtra("username", this.i);
            intent.putExtra("server-name", this.e);
            intent.putExtra("KICK_REASON", "An unknown error has occurred. If the problem persist please remove and reinstall!");
            n().setResult(-1, intent);
            n().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x() {
        if (this.f4955a != null && this.f4955a.f()) {
            try {
                this.f4955a.e();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.f4956b != null && !this.f4956b.isFinishing()) {
            this.f4956b.finish();
        }
        super.x();
    }

    @Override // mattecarra.usavsursschat.e
    public String a() {
        return this.f;
    }

    @Override // mattecarra.usavsursschat.e
    public int ae() {
        return this.g;
    }

    @Override // mattecarra.usavsursschat.e
    public String af() {
        return this.i;
    }

    @Override // mattecarra.usavsursschat.e
    public int ag() {
        return this.h;
    }

    @Override // mattecarra.usavsursschat.e
    public String ah() {
        return this.ag;
    }

    @Override // mattecarra.usavsursschat.e
    public void a(com.afollestad.materialdialogs.f fVar) {
        fVar.show();
        if (this.f4956b == null) {
            return;
        }
        this.f4956b.a(fVar);
    }

    @Override // mattecarra.usavsursschat.e
    public mattecarra.usavsursschat.i.c ai() {
        return this.d;
    }

    @Override // mattecarra.usavsursschat.e
    public mattecarra.usavsursschat.f aj() {
        return this.c;
    }

    public mattecarra.usavsursschat.McClient.a ak() {
        return this.f4955a;
    }
}
