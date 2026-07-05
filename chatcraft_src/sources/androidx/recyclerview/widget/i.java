package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: b, reason: collision with root package name */
    int f1125b;
    int c;
    int d;
    int e;
    boolean h;
    boolean i;

    /* renamed from: a, reason: collision with root package name */
    boolean f1124a = true;
    int f = 0;
    int g = 0;

    i() {
    }

    boolean a(RecyclerView.u uVar) {
        return this.c >= 0 && this.c < uVar.e();
    }

    View a(RecyclerView.p pVar) {
        View viewC = pVar.c(this.c);
        this.c += this.d;
        return viewC;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1125b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
