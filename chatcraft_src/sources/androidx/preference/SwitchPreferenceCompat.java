package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.m;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: b, reason: collision with root package name */
    private final a f966b;
    private CharSequence c;
    private CharSequence d;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.e(z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f966b = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.SwitchPreferenceCompat, i, i2);
        e((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreferenceCompat_summaryOn, m.g.SwitchPreferenceCompat_android_summaryOn));
        f((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreferenceCompat_summaryOff, m.g.SwitchPreferenceCompat_android_summaryOff));
        c(androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreferenceCompat_switchTextOn, m.g.SwitchPreferenceCompat_android_switchTextOn));
        d((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreferenceCompat_switchTextOff, m.g.SwitchPreferenceCompat_android_switchTextOff));
        f(androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.SwitchPreferenceCompat_disableDependentsState, m.g.SwitchPreferenceCompat_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.a.switchPreferenceCompatStyle);
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        d(lVar.a(m.c.switchWidget));
        b(lVar);
    }

    public void c(CharSequence charSequence) {
        this.c = charSequence;
        j();
    }

    public void d(CharSequence charSequence) {
        this.d = charSequence;
        j();
    }

    @Override // androidx.preference.Preference
    protected void a(View view) {
        super.a(view);
        c(view);
    }

    private void c(View view) {
        if (((AccessibilityManager) H().getSystemService("accessibility")).isEnabled()) {
            d(view.findViewById(m.c.switchWidget));
            b(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f968a);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.c);
            switchCompat.setTextOff(this.d);
            switchCompat.setOnCheckedChangeListener(this.f966b);
        }
    }
}
