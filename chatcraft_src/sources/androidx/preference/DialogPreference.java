package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.preference.m;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f937a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f938b;
    private Drawable c;
    private CharSequence d;
    private CharSequence e;
    private int f;

    public interface a {
        Preference a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.DialogPreference, i, i2);
        this.f937a = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.DialogPreference_dialogTitle, m.g.DialogPreference_android_dialogTitle);
        if (this.f937a == null) {
            this.f937a = y();
        }
        this.f938b = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.DialogPreference_dialogMessage, m.g.DialogPreference_android_dialogMessage);
        this.c = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.DialogPreference_dialogIcon, m.g.DialogPreference_android_dialogIcon);
        this.d = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.DialogPreference_positiveButtonText, m.g.DialogPreference_android_positiveButtonText);
        this.e = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.DialogPreference_negativeButtonText, m.g.DialogPreference_android_negativeButtonText);
        this.f = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.DialogPreference_dialogLayout, m.g.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    public CharSequence b() {
        return this.f937a;
    }

    public CharSequence c() {
        return this.f938b;
    }

    public Drawable d() {
        return this.c;
    }

    public CharSequence e() {
        return this.d;
    }

    public CharSequence f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    @Override // androidx.preference.Preference
    protected void h() {
        K().a(this);
    }
}
