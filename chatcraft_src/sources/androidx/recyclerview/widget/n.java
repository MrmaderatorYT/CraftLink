package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
class n {
    static int a(RecyclerView.u uVar, l lVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int iMax;
        if (iVar.w() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(iVar.d(view), iVar.d(view2));
        int iMax2 = Math.max(iVar.d(view), iVar.d(view2));
        if (z2) {
            iMax = Math.max(0, (uVar.e() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (!z) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(lVar.b(view2) - lVar.a(view)) / (Math.abs(iVar.d(view) - iVar.d(view2)) + 1))) + (lVar.c() - lVar.a(view)));
    }

    static int a(RecyclerView.u uVar, l lVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.w() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.d(view) - iVar.d(view2)) + 1;
        }
        return Math.min(lVar.f(), lVar.b(view2) - lVar.a(view));
    }

    static int b(RecyclerView.u uVar, l lVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.w() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.e();
        }
        return (int) (((lVar.b(view2) - lVar.a(view)) / (Math.abs(iVar.d(view) - iVar.d(view2)) + 1)) * uVar.e());
    }
}
