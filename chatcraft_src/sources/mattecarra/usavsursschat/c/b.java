package mattecarra.usavsursschat.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: AddAccountFragment.java */
/* loaded from: classes.dex */
public class b extends Fragment implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private a f4938a;

    /* compiled from: AddAccountFragment.java */
    public interface a {
        void F_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        if (context instanceof a) {
            this.f4938a = (a) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.add_user_fragment, viewGroup, false);
        viewInflate.setClickable(true);
        viewInflate.setOnClickListener(this);
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        System.out.println("on click " + this.f4938a);
        if (this.f4938a != null) {
            this.f4938a.F_();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return "AddAccountFragment{callback=" + this.f4938a + '}';
    }
}
