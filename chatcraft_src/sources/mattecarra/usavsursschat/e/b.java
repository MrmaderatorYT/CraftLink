package mattecarra.usavsursschat.e;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: ChatRecyclerViewAdapter.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.a<a> {

    /* renamed from: a, reason: collision with root package name */
    private final f f4976a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<mattecarra.usavsursschat.b.a> f4977b;
    private ArrayList<Integer> c;

    public b(f fVar) {
        this.f4977b = new ArrayList<>();
        this.f4976a = fVar;
        this.c = new ArrayList<>();
    }

    public b(ArrayList<mattecarra.usavsursschat.b.a> arrayList, f fVar) {
        this.f4977b = arrayList;
        this.f4976a = fVar;
        this.c = new ArrayList<>();
    }

    public void a(Bundle bundle) {
        bundle.putParcelableArray("chats", (Parcelable[]) this.f4977b.toArray(new mattecarra.usavsursschat.b.a[this.f4977b.size()]));
    }

    public void b(Bundle bundle) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("chats");
        if (parcelableArray != null) {
            for (Parcelable parcelable : parcelableArray) {
                this.f4977b.add((mattecarra.usavsursschat.b.a) parcelable);
            }
        }
    }

    public void a(mattecarra.usavsursschat.b.a aVar) {
        this.f4977b.add(aVar);
        e(this.f4977b.size() - 1);
    }

    public mattecarra.usavsursschat.b.a a(int i) {
        return this.f4977b.get(i);
    }

    public int a() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(a aVar, int i) {
        aVar.r.setText(this.f4977b.get(i).a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f4977b.size();
    }

    /* compiled from: ChatRecyclerViewAdapter.java */
    public class a extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener {
        View q;
        TextView r;

        public a(View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.q = view;
            this.r = (TextView) view.findViewById(R.id.textViewListNew);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f4976a.a(g(), this.q, true);
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f4976a.a(g(), this.q, false);
        }
    }
}
