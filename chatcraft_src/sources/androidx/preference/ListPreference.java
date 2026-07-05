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
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence[] f944a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence[] f945b;
    private String c;
    private String d;
    private boolean e;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.ListPreference, i, i2);
        this.f944a = androidx.core.a.a.g.d(typedArrayObtainStyledAttributes, m.g.ListPreference_entries, m.g.ListPreference_android_entries);
        this.f945b = androidx.core.a.a.g.d(typedArrayObtainStyledAttributes, m.g.ListPreference_entryValues, m.g.ListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, m.g.Preference, i, i2);
        this.d = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes2, m.g.Preference_summary, m.g.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    public CharSequence[] m() {
        return this.f944a;
    }

    public CharSequence[] n() {
        return this.f945b;
    }

    public void b(String str) {
        boolean z = !TextUtils.equals(this.c, str);
        if (z || !this.e) {
            this.c = str;
            this.e = true;
            e(str);
            if (z) {
                j();
            }
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence o() {
        CharSequence charSequenceQ = q();
        if (this.d == null) {
            return super.o();
        }
        String str = this.d;
        Object[] objArr = new Object[1];
        if (charSequenceQ == null) {
            charSequenceQ = BuildConfig.FLAVOR;
        }
        objArr[0] = charSequenceQ;
        return String.format(str, objArr);
    }

    @Override // androidx.preference.Preference
    public void a(CharSequence charSequence) {
        super.a(charSequence);
        if (charSequence == null && this.d != null) {
            this.d = null;
        } else {
            if (charSequence == null || charSequence.equals(this.d)) {
                return;
            }
            this.d = charSequence.toString();
        }
    }

    public String p() {
        return this.c;
    }

    public CharSequence q() {
        int i = i();
        if (i < 0 || this.f944a == null) {
            return null;
        }
        return this.f944a[i];
    }

    public int c(String str) {
        if (str == null || this.f945b == null) {
            return -1;
        }
        for (int length = this.f945b.length - 1; length >= 0; length--) {
            if (this.f945b[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private int i() {
        return c(this.c);
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        b(f((String) obj));
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        Parcelable parcelableL = super.l();
        if (E()) {
            return parcelableL;
        }
        a aVar = new a(parcelableL);
        aVar.f946a = p();
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
        b(aVar.f946a);
    }

    private static class a extends Preference.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.ListPreference.a.1
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
        String f946a;

        public a(Parcel parcel) {
            super(parcel);
            this.f946a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f946a);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
