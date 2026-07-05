package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import androidx.preference.m;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends AbstractMultiSelectListPreference {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence[] f947a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence[] f948b;
    private Set<String> c;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.MultiSelectListPreference, i, i2);
        this.f947a = androidx.core.a.a.g.d(typedArrayObtainStyledAttributes, m.g.MultiSelectListPreference_entries, m.g.MultiSelectListPreference_android_entries);
        this.f948b = androidx.core.a.a.g.d(typedArrayObtainStyledAttributes, m.g.MultiSelectListPreference_entryValues, m.g.MultiSelectListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] i() {
        return this.f947a;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] m() {
        return this.f948b;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public void a(Set<String> set) {
        this.c.clear();
        this.c.addAll(set);
        b(set);
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public Set<String> n() {
        return this.c;
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        a(c((Set<String>) obj));
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        Parcelable parcelableL = super.l();
        if (E()) {
            return parcelableL;
        }
        a aVar = new a(parcelableL);
        aVar.f949a = n();
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
        a(aVar.f949a);
    }

    private static class a extends Preference.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.MultiSelectListPreference.a.1
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
        Set<String> f949a;

        a(Parcel parcel) {
            super(parcel);
            int i = parcel.readInt();
            this.f949a = new HashSet();
            String[] strArr = new String[i];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f949a, strArr);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f949a.size());
            parcel.writeStringArray((String[]) this.f949a.toArray(new String[this.f949a.size()]));
        }
    }
}
