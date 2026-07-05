package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.preference.m;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceViewHolder.java */
/* loaded from: classes.dex */
public class l extends RecyclerView.x {
    private final SparseArray<View> q;
    private boolean r;
    private boolean s;

    l(View view) {
        super(view);
        this.q = new SparseArray<>(4);
        this.q.put(R.id.title, view.findViewById(R.id.title));
        this.q.put(R.id.summary, view.findViewById(R.id.summary));
        this.q.put(R.id.icon, view.findViewById(R.id.icon));
        this.q.put(m.c.icon_frame, view.findViewById(m.c.icon_frame));
        this.q.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View a(int i) {
        View view = this.q.get(i);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f1052a.findViewById(i);
        if (viewFindViewById != null) {
            this.q.put(i, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean a() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean b() {
        return this.s;
    }

    public void b(boolean z) {
        this.s = z;
    }
}
