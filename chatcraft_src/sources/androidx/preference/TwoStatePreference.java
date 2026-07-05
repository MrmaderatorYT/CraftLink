package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f968a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f969b;
    private CharSequence c;
    private boolean d;
    private boolean e;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.preference.Preference
    protected void h() {
        super.h();
        boolean z = !b();
        if (b(Boolean.valueOf(z))) {
            e(z);
        }
    }

    public void e(boolean z) {
        boolean z2 = this.f968a != z;
        if (z2 || !this.d) {
            this.f968a = z;
            this.d = true;
            c(z);
            if (z2) {
                b(k());
                j();
            }
        }
    }

    public boolean b() {
        return this.f968a;
    }

    @Override // androidx.preference.Preference
    public boolean k() {
        return (this.e ? this.f968a : !this.f968a) || super.k();
    }

    public void e(CharSequence charSequence) {
        this.f969b = charSequence;
        if (b()) {
            j();
        }
    }

    public void f(CharSequence charSequence) {
        this.c = charSequence;
        if (b()) {
            return;
        }
        j();
    }

    public void f(boolean z) {
        this.e = z;
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        if (obj == null) {
            obj = false;
        }
        e(d(((Boolean) obj).booleanValue()));
    }

    protected void b(l lVar) {
        b(lVar.a(R.id.summary));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.f968a
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r4.f969b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r4.f969b
            r5.setText(r0)
        L1a:
            r0 = 0
            goto L2e
        L1c:
            boolean r1 = r4.f968a
            if (r1 != 0) goto L2e
            java.lang.CharSequence r1 = r4.c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2e
            java.lang.CharSequence r0 = r4.c
            r5.setText(r0)
            goto L1a
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r1 = r4.o()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L3e
            r5.setText(r1)
            r0 = 0
        L3e:
            r1 = 8
            if (r0 != 0) goto L43
            r1 = 0
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.b(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        Parcelable parcelableL = super.l();
        if (E()) {
            return parcelableL;
        }
        a aVar = new a(parcelableL);
        aVar.f970a = b();
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
        e(aVar.f970a);
    }

    static class a extends Preference.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.TwoStatePreference.a.1
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
        boolean f970a;

        public a(Parcel parcel) {
            super(parcel);
            this.f970a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f970a ? 1 : 0);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
