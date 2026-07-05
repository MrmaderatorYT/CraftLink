package a.a.a.d;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private View f12a;

    public b(View view) {
        this.f12a = view;
    }

    @Override // a.a.a.d.a
    public Point a() {
        int[] iArr = new int[2];
        this.f12a.getLocationInWindow(iArr);
        return new Point(iArr[0] + (this.f12a.getWidth() / 2), iArr[1] + (this.f12a.getHeight() / 2));
    }

    @Override // a.a.a.d.a
    public Rect b() {
        int[] iArr = new int[2];
        this.f12a.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + this.f12a.getWidth(), iArr[1] + this.f12a.getHeight());
    }

    @Override // a.a.a.d.a
    public View c() {
        return this.f12a;
    }
}
