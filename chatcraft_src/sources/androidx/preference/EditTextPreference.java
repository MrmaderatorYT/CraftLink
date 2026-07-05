package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.m;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: a, reason: collision with root package name */
    private String f942a;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.editTextPreferenceStyle, R.attr.editTextPreferenceStyle));
    }

    public void a(String str) {
        boolean zK = k();
        this.f942a = str;
        e(str);
        boolean zK2 = k();
        if (zK2 != zK) {
            b(zK2);
        }
    }

    public String i() {
        return this.f942a;
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        a(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public boolean k() {
        return TextUtils.isEmpty(this.f942a) || super.k();
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        Parcelable parcelableL = super.l();
        if (E()) {
            return parcelableL;
        }
        a aVar = new a(parcelableL);
        aVar.f943a = i();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.a(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.a(aVar.getSuperState());
        a(aVar.f943a);
    }

    private static class a extends Preference.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.EditTextPreference.a.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        String f943a;

        public a(Parcel parcel) {
            super(parcel);
            this.f943a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f943a);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
