package androidx.preference;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.g.a.c;
import androidx.preference.m;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    @Override // androidx.preference.Preference
    public boolean z() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.preferenceCategoryStyle, R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public boolean k() {
        return !super.z();
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        if (Build.VERSION.SDK_INT >= 28) {
            lVar.f1052a.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public void a(androidx.core.g.a.c cVar) {
        c.b bVarR;
        super.a(cVar);
        if (Build.VERSION.SDK_INT >= 28 || (bVarR = cVar.r()) == null) {
            return;
        }
        cVar.b(c.b.a(bVarR.c(), bVarR.d(), bVarR.a(), bVarR.b(), true, bVarR.e()));
    }
}
