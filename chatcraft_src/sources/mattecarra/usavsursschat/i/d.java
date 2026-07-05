package mattecarra.usavsursschat.i;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: FloatingActionButtonScrollListener.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    private FloatingActionButton f5020a;

    public d(FloatingActionButton floatingActionButton) {
        this.f5020a = floatingActionButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (i2 > 0 && this.f5020a.getVisibility() == 0) {
            this.f5020a.c();
        } else {
            if (i2 >= 0 || this.f5020a.getVisibility() == 0) {
                return;
            }
            this.f5020a.b();
        }
    }
}
