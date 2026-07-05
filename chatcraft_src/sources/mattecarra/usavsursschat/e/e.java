package mattecarra.usavsursschat.e;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: PlayersViewAdapter.java */
/* loaded from: classes.dex */
public class e extends RecyclerView.a<a> {

    /* renamed from: a, reason: collision with root package name */
    private final f f4984a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<mattecarra.usavsursschat.b.b> f4985b = new ArrayList<>();
    private ArrayList<Integer> c = new ArrayList<>();
    private mattecarra.usavsursschat.h.a d;
    private mattecarra.usavsursschat.f e;

    public e(mattecarra.usavsursschat.c.f fVar) {
        this.f4984a = fVar;
        this.e = new mattecarra.usavsursschat.f(fVar.l());
        this.d = new mattecarra.usavsursschat.h.a(this.e);
    }

    public void a(Bundle bundle) {
        bundle.putParcelableArray("players", (Parcelable[]) this.f4985b.toArray(new mattecarra.usavsursschat.b.b[this.f4985b.size()]));
    }

    public void b(Bundle bundle) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("players");
        if (parcelableArray != null) {
            for (Parcelable parcelable : parcelableArray) {
                this.f4985b.add((mattecarra.usavsursschat.b.b) parcelable);
            }
        }
    }

    public void a(mattecarra.usavsursschat.b.b bVar) {
        if (this.f4985b.contains(bVar)) {
            b(bVar);
        } else {
            this.f4985b.add(bVar);
            e(this.f4985b.size() - 1);
        }
    }

    public void b(mattecarra.usavsursschat.b.b bVar) {
        int iIndexOf = this.f4985b.indexOf(bVar);
        if (iIndexOf != -1) {
            this.f4985b.set(iIndexOf, bVar);
            d(iIndexOf);
        }
    }

    public void a(String str) {
        Iterator<mattecarra.usavsursschat.b.b> it = this.f4985b.iterator();
        int i = 0;
        while (it.hasNext()) {
            mattecarra.usavsursschat.b.b next = it.next();
            if (next != null && next.b() != null && next.b().equals(str)) {
                it.remove();
                f(i);
            }
            i++;
        }
    }

    public mattecarra.usavsursschat.b.b a(int i) {
        if (i < 0 || i >= this.f4985b.size()) {
            return null;
        }
        return this.f4985b.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowplayer, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(a aVar, int i) {
        mattecarra.usavsursschat.b.b bVar = this.f4985b.get(i);
        if (bVar == null || aVar == null) {
            return;
        }
        try {
            aVar.r.setText(bVar.c());
            this.d.a(aVar.s, bVar.b());
        } catch (Exception e) {
            e.printStackTrace();
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f4985b.size();
    }

    /* compiled from: PlayersViewAdapter.java */
    class a extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener {
        View q;
        TextView r;
        ImageView s;

        public a(View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.q = view;
            this.r = (TextView) view.findViewById(R.id.textViewListOnP);
            this.s = (ImageView) view.findViewById(R.id.imgOnlineP);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            e.this.f4984a.a(g(), this.q, true);
            return true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f4984a.a(g(), this.q, false);
        }
    }
}
