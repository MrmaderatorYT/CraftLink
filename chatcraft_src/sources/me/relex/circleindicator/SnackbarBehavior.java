package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

/* loaded from: classes.dex */
public class SnackbarBehavior extends CoordinatorLayout.b<a> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, a aVar, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, a aVar, View view) {
        aVar.setTranslationY(a(coordinatorLayout, aVar));
        return true;
    }

    private float a(CoordinatorLayout coordinatorLayout, a aVar) {
        List<View> listC = coordinatorLayout.c(aVar);
        int size = listC.size();
        float fMin = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = listC.get(i);
            if ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.a(aVar, view)) {
                fMin = Math.min(fMin, view.getTranslationY() - view.getHeight());
            }
        }
        return fMin;
    }
}
