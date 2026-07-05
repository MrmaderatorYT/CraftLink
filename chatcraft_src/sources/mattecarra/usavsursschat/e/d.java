package mattecarra.usavsursschat.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: LogListRecyclerViewAdapter.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.a<b> {

    /* renamed from: a, reason: collision with root package name */
    private final a f4980a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String[]> f4981b;

    /* compiled from: LogListRecyclerViewAdapter.java */
    public interface a extends f {
        void a(int i, View view);
    }

    public d(ArrayList<String[]> arrayList, a aVar) {
        this.f4980a = aVar;
        this.f4981b = arrayList;
    }

    public void a(String[] strArr) {
        int iIndexOf = this.f4981b.indexOf(strArr);
        if (iIndexOf != -1) {
            this.f4981b.remove(iIndexOf);
            f(iIndexOf);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.log_row_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(b bVar, int i) {
        String[] strArr = this.f4981b.get(i);
        bVar.r.setText(strArr[0]);
        bVar.s.setText(strArr[1]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f4981b.size();
    }

    /* compiled from: LogListRecyclerViewAdapter.java */
    public class b extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener {
        View q;
        TextView r;
        TextView s;

        public b(View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.q = view;
            this.r = (TextView) view.findViewById(R.id.text1);
            this.s = (TextView) view.findViewById(R.id.text2);
            view.findViewById(R.id.img_delete).setOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.e.d.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.f4980a.a(b.this.g(), b.this.q);
                }
            });
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            d.this.f4980a.a(g(), this.q, true);
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f4980a.a(g(), this.q, false);
        }
    }
}
