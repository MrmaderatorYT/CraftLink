package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.preference.m;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: b, reason: collision with root package name */
    private final a f964b;
    private CharSequence c;
    private CharSequence d;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.e(z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f964b = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.SwitchPreference, i, i2);
        e((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreference_summaryOn, m.g.SwitchPreference_android_summaryOn));
        f((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreference_summaryOff, m.g.SwitchPreference_android_summaryOff));
        c(androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreference_switchTextOn, m.g.SwitchPreference_android_switchTextOn));
        d((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.SwitchPreference_switchTextOff, m.g.SwitchPreference_android_switchTextOff));
        f(androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.SwitchPreference_disableDependentsState, m.g.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.switchPreferenceStyle, R.attr.switchPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        d(lVar.a(R.id.switch_widget));
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
            d(view.findViewById(R.id.switch_widget));
            b(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f968a);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.c);
            r4.setTextOff(this.d);
            r4.setOnCheckedChangeListener(this.f964b);
        }
    }
}
