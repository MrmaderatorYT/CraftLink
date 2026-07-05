package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import androidx.preference.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: a, reason: collision with root package name */
    final androidx.b.g<String, Long> f953a;

    /* renamed from: b, reason: collision with root package name */
    private List<Preference> f954b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private a g;
    private final Handler h;
    private final Runnable i;

    public interface a {
        void a();
    }

    protected boolean d() {
        return true;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = true;
        this.d = 0;
        this.e = false;
        this.f = Integer.MAX_VALUE;
        this.g = null;
        this.f953a = new androidx.b.g<>();
        this.h = new Handler();
        this.i = new Runnable() { // from class: androidx.preference.PreferenceGroup.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.f953a.clear();
                }
            }
        };
        this.f954b = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.PreferenceGroup, i, i2);
        this.c = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.PreferenceGroup_orderingFromXml, m.g.PreferenceGroup_orderingFromXml, true);
        if (typedArrayObtainStyledAttributes.hasValue(m.g.PreferenceGroup_initialExpandedChildrenCount)) {
            g(androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.PreferenceGroup_initialExpandedChildrenCount, m.g.PreferenceGroup_initialExpandedChildrenCount, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void g(int i) {
        if (i != Integer.MAX_VALUE && !D()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f = i;
    }

    public int b() {
        return this.f;
    }

    public void b(Preference preference) {
        c(preference);
    }

    public int c() {
        return this.f954b.size();
    }

    public Preference h(int i) {
        return this.f954b.get(i);
    }

    public boolean c(Preference preference) {
        long jA;
        if (this.f954b.contains(preference)) {
            return true;
        }
        if (preference.C() != null) {
            PreferenceGroup preferenceGroupO = this;
            while (preferenceGroupO.O() != null) {
                preferenceGroupO = preferenceGroupO.O();
            }
            String strC = preference.C();
            if (preferenceGroupO.c(strC) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + strC + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.x() == Integer.MAX_VALUE) {
            if (this.c) {
                int i = this.d;
                this.d = i + 1;
                preference.b(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).e(this.c);
            }
        }
        int iBinarySearch = Collections.binarySearch(this.f954b, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        if (!d(preference)) {
            return false;
        }
        synchronized (this) {
            this.f954b.add(iBinarySearch, preference);
        }
        j jVarK = K();
        String strC2 = preference.C();
        if (strC2 != null && this.f953a.containsKey(strC2)) {
            jA = this.f953a.get(strC2).longValue();
            this.f953a.remove(strC2);
        } else {
            jA = jVarK.a();
        }
        preference.a(jVarK, jA);
        preference.a(this);
        if (this.e) {
            preference.L();
        }
        J();
        return true;
    }

    protected boolean d(Preference preference) {
        preference.b(this, k());
        return true;
    }

    public Preference c(CharSequence charSequence) {
        Preference preferenceC;
        if (TextUtils.equals(C(), charSequence)) {
            return this;
        }
        int iC = c();
        for (int i = 0; i < iC; i++) {
            Preference preferenceH = h(i);
            String strC = preferenceH.C();
            if (strC != null && strC.equals(charSequence)) {
                return preferenceH;
            }
            if ((preferenceH instanceof PreferenceGroup) && (preferenceC = ((PreferenceGroup) preferenceH).c(charSequence)) != null) {
                return preferenceC;
            }
        }
        return null;
    }

    public a e() {
        return this.g;
    }

    @Override // androidx.preference.Preference
    public void L() {
        super.L();
        this.e = true;
        int iC = c();
        for (int i = 0; i < iC; i++) {
            h(i).L();
        }
    }

    @Override // androidx.preference.Preference
    public void M() {
        super.M();
        this.e = false;
        int iC = c();
        for (int i = 0; i < iC; i++) {
            h(i).M();
        }
    }

    @Override // androidx.preference.Preference
    public void b(boolean z) {
        super.b(z);
        int iC = c();
        for (int i = 0; i < iC; i++) {
            h(i).b(this, z);
        }
    }

    void f() {
        synchronized (this) {
            Collections.sort(this.f954b);
        }
    }

    @Override // androidx.preference.Preference
    protected void b(Bundle bundle) {
        super.b(bundle);
        int iC = c();
        for (int i = 0; i < iC; i++) {
            h(i).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void d(Bundle bundle) {
        super.d(bundle);
        int iC = c();
        for (int i = 0; i < iC; i++) {
            h(i).d(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        return new b(super.l(), this.f);
    }

    @Override // androidx.preference.Preference
    protected void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(b.class)) {
            super.a(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        this.f = bVar.f956a;
        super.a(bVar.getSuperState());
    }

    static class b extends Preference.a {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: androidx.preference.PreferenceGroup.b.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f956a;

        b(Parcel parcel) {
            super(parcel);
            this.f956a = parcel.readInt();
        }

        b(Parcelable parcelable, int i) {
            super(parcelable);
            this.f956a = i;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f956a);
        }
    }
}
