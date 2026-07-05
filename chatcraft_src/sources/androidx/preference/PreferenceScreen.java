package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;
import androidx.preference.m;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: b, reason: collision with root package name */
    private boolean f957b;

    @Override // androidx.preference.PreferenceGroup
    protected boolean d() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.a.a.g.a(context, m.a.preferenceScreenStyle, R.attr.preferenceScreenStyle));
        this.f957b = true;
    }

    @Override // androidx.preference.Preference
    protected void h() {
        j.b bVarI;
        if (r() != null || s() != null || c() == 0 || (bVarI = K().i()) == null) {
            return;
        }
        bVarI.b(this);
    }

    public boolean g() {
        return this.f957b;
    }
}
