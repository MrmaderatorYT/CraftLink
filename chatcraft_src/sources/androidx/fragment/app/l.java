package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* compiled from: FragmentState.java */
/* loaded from: classes.dex */
final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: androidx.fragment.app.l.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final String f760a;

    /* renamed from: b, reason: collision with root package name */
    final int f761b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    Fragment l;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    l(Fragment fragment) {
        this.f760a = fragment.getClass().getName();
        this.f761b = fragment.o;
        this.c = fragment.w;
        this.d = fragment.H;
        this.e = fragment.I;
        this.f = fragment.J;
        this.g = fragment.M;
        this.h = fragment.L;
        this.i = fragment.q;
        this.j = fragment.K;
    }

    l(Parcel parcel) {
        this.f760a = parcel.readString();
        this.f761b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
    }

    public Fragment a(g gVar, e eVar, Fragment fragment, j jVar, androidx.lifecycle.r rVar) {
        if (this.l == null) {
            Context contextG = gVar.g();
            if (this.i != null) {
                this.i.setClassLoader(contextG.getClassLoader());
            }
            if (eVar != null) {
                this.l = eVar.a(contextG, this.f760a, this.i);
            } else {
                this.l = Fragment.a(contextG, this.f760a, this.i);
            }
            if (this.k != null) {
                this.k.setClassLoader(contextG.getClassLoader());
                this.l.l = this.k;
            }
            this.l.a(this.f761b, fragment);
            this.l.w = this.c;
            this.l.y = true;
            this.l.H = this.d;
            this.l.I = this.e;
            this.l.J = this.f;
            this.l.M = this.g;
            this.l.L = this.h;
            this.l.K = this.j;
            this.l.B = gVar.f730b;
            if (i.f731a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.E = jVar;
        this.l.F = rVar;
        return this.l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f760a);
        parcel.writeInt(this.f761b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }
}
