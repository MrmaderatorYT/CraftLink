package androidx.core.g;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f634a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f635b;
    private final View c;
    private boolean d;
    private int[] e;

    public k(View view) {
        this.c = view;
    }

    public void a(boolean z) {
        if (this.d) {
            q.w(this.c);
        }
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.c;
        for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
            if (t.a(parent, view, this.c, i, i2)) {
                a(i2, parent);
                t.b(parent, view, this.c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent viewParentD = d(i);
        if (viewParentD != null) {
            t.a(viewParentD, this.c, i);
            a(i, (ViewParent) null);
        }
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentD;
        int i6;
        int i7;
        if (!a() || (viewParentD = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        t.a(viewParentD, this.c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentD;
        int i4;
        int i5;
        if (!a() || (viewParentD = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        t.a(viewParentD, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent viewParentD;
        if (!a() || (viewParentD = d(0)) == null) {
            return false;
        }
        return t.a(viewParentD, this.c, f, f2, z);
    }

    public boolean a(float f, float f2) {
        ViewParent viewParentD;
        if (!a() || (viewParentD = d(0)) == null) {
            return false;
        }
        return t.a(viewParentD, this.c, f, f2);
    }

    private ViewParent d(int i) {
        switch (i) {
            case 0:
                return this.f634a;
            case 1:
                return this.f635b;
            default:
                return null;
        }
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f634a = viewParent;
                break;
            case 1:
                this.f635b = viewParent;
                break;
        }
    }
}
