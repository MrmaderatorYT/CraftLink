package mattecarra.usavsursschat.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: AccountFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private String f4936a = BuildConfig.FLAVOR;

    /* renamed from: b, reason: collision with root package name */
    private String f4937b = BuildConfig.FLAVOR;
    private Context c;
    private mattecarra.usavsursschat.f d;
    private mattecarra.usavsursschat.h.a e;

    /* compiled from: AccountFragment.java */
    /* renamed from: mattecarra.usavsursschat.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0113a {
        void a(String str);
    }

    /* compiled from: AccountFragment.java */
    public interface b {
        void b(String str);
    }

    public static Fragment a(String str, String str2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("username", str);
        bundle.putString("uuid", str2);
        aVar.g(bundle);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.c = context;
    }

    public String a() {
        return this.f4936a;
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = new mattecarra.usavsursschat.f(l());
        this.e = new mattecarra.usavsursschat.h.a(this.d);
        View viewInflate = layoutInflater.inflate(R.layout.user_detail_fragment, viewGroup, false);
        if (bundle != null && bundle.containsKey("username")) {
            this.f4936a = bundle.getString("username");
        }
        if (i() != null && i().containsKey("username")) {
            this.f4936a = i().getString("username");
        }
        if (i() != null && i().containsKey("uuid")) {
            this.f4937b = i().getString("uuid");
        }
        ((TextView) viewInflate.findViewById(R.id.usernameTextView)).setText(this.f4936a);
        viewInflate.findViewById(R.id.remove).setOnClickListener(this);
        viewInflate.findViewById(R.id.edit).setOnClickListener(this);
        this.e.a((ImageView) viewInflate.findViewById(R.id.skinImageView), this.f4937b);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        bundle.putString("username", this.f4936a);
        super.e(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.remove) {
            if (this.c instanceof InterfaceC0113a) {
                ((InterfaceC0113a) this.c).a(this.f4936a);
            }
        } else if (view.getId() == R.id.edit && (this.c instanceof b)) {
            ((b) this.c).b(this.f4936a);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return "AccountFragment{name='" + this.f4936a + "'}";
    }
}
