package mattecarra.usavsursschat.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: CrackedPasswordViewAdapter.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.a<a> {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f4978a;

    /* renamed from: b, reason: collision with root package name */
    private b f4979b;

    /* compiled from: CrackedPasswordViewAdapter.java */
    public interface b extends f {
        void a(String str);

        void b(String str);
    }

    public c(List<String> list, b bVar) {
        this.f4978a = list;
        this.f4979b = bVar;
    }

    public void a(String str) {
        int iIndexOf = this.f4978a.indexOf(str);
        if (iIndexOf != -1) {
            this.f4978a.remove(iIndexOf);
            f(iIndexOf);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cracked_password_row_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(a aVar, int i) {
        String str = this.f4978a.get(i);
        if (str == null) {
            return;
        }
        aVar.q.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f4978a.size();
    }

    /* compiled from: CrackedPasswordViewAdapter.java */
    class a extends RecyclerView.x implements View.OnClickListener {
        TextView q;

        a(View view) {
            super(view);
            this.q = (TextView) view.findViewById(R.id.cracked_server);
            view.findViewById(R.id.change_cracked_password).setOnClickListener(this);
            view.findViewById(R.id.delete_cracked_password).setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            System.out.println("ON CLICK?!?!?! " + view.getId() + " " + R.id.change_cracked_password);
            int id = view.getId();
            if (id == R.id.change_cracked_password) {
                c.this.f4979b.b(this.q.getText().toString());
            } else {
                if (id != R.id.delete_cracked_password) {
                    return;
                }
                c.this.f4979b.a(this.q.getText().toString());
            }
        }
    }
}
