package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.preference.m;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: b, reason: collision with root package name */
    private final a f935b;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!CheckBoxPreference.this.b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                CheckBoxPreference.this.e(z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f935b = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.CheckBoxPreference, i, i2);
        e((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.CheckBoxPreference_summaryOn, m.g.CheckBoxPreference_android_summaryOn));
        f((CharSequence) androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.CheckBoxPreference_summaryOff, m.g.CheckBoxPreference_android_summaryOff));
        f(androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.CheckBoxPreference_disableDependentsState, m.g.CheckBoxPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.checkBoxPreferenceStyle, R.attr.checkBoxPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        d(lVar.a(R.id.checkbox));
        b(lVar);
    }

    @Override // androidx.preference.Preference
    protected void a(View view) {
        super.a(view);
        c(view);
    }

    private void c(View view) {
        if (((AccessibilityManager) H().getSystemService("accessibility")).isEnabled()) {
            d(view.findViewById(R.id.checkbox));
            b(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f968a);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f935b);
        }
    }
}
