package mattecarra.usavsursschat.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: ServersRecyclerViewAdapter.java */
/* loaded from: classes.dex */
public class g extends RecyclerView.a<b> {

    /* renamed from: a, reason: collision with root package name */
    private final a f4986a;

    /* renamed from: b, reason: collision with root package name */
    private List<mattecarra.usavsursschat.b.d> f4987b;

    /* compiled from: ServersRecyclerViewAdapter.java */
    public interface a extends f {
    }

    public g(ArrayList<mattecarra.usavsursschat.b.d> arrayList, a aVar) {
        this.f4987b = arrayList;
        this.f4986a = aVar;
    }

    public void a(mattecarra.usavsursschat.b.d dVar) {
        this.f4987b.add(dVar);
        e(this.f4987b.size() - 1);
    }

    public void a(String str, mattecarra.usavsursschat.b.d dVar) {
        int i = 0;
        while (true) {
            if (i >= this.f4987b.size()) {
                i = -1;
                break;
            } else if (this.f4987b.get(i).a().equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.f4987b.set(i, dVar);
            d(i);
        } else {
            System.out.println("Fuck. Index = -1");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.server_listitem, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(b bVar, int i) {
        try {
            mattecarra.usavsursschat.b.d dVar = this.f4987b.get(i);
            if (dVar != null && bVar != null) {
                bVar.r.setText(dVar.a());
                bVar.t.setText(dVar.f + "/" + dVar.e);
                bVar.s.setText("Ping " + dVar.g + "ms");
                bVar.u.setText(dVar.h);
                bVar.v.setImageBitmap(dVar.i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f4987b.size();
    }

    /* compiled from: ServersRecyclerViewAdapter.java */
    public class b extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener {
        View q;
        TextView r;
        TextView s;
        TextView t;
        TextView u;
        ImageView v;

        public b(View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.q = view;
            this.r = (TextView) view.findViewById(R.id.server_name);
            this.v = (ImageView) view.findViewById(R.id.server_icon);
            this.s = (TextView) view.findViewById(R.id.ping_time);
            this.t = (TextView) view.findViewById(R.id.server_on_player);
            this.u = (TextView) view.findViewById(R.id.server_motd);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            g.this.f4986a.a(g(), this.q, true);
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f4986a.a(g(), this.q, false);
        }
    }
}
