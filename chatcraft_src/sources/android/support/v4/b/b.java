package android.support.v4.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.b.a;

/* compiled from: ResultReceiver.java */
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: android.support.v4.b.b.1
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
    final boolean f29a = false;

    /* renamed from: b, reason: collision with root package name */
    final Handler f30b = null;
    android.support.v4.b.a c;

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: android.support.v4.b.b$b, reason: collision with other inner class name */
    class RunnableC0010b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f32a;

        /* renamed from: b, reason: collision with root package name */
        final Bundle f33b;

        RunnableC0010b(int i, Bundle bundle) {
            this.f32a = i;
            this.f33b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f32a, this.f33b);
        }
    }

    /* compiled from: ResultReceiver.java */
    class a extends a.AbstractBinderC0008a {
        a() {
        }

        @Override // android.support.v4.b.a
        public void a(int i, Bundle bundle) {
            if (b.this.f30b != null) {
                b.this.f30b.post(b.this.new RunnableC0010b(i, bundle));
            } else {
                b.this.a(i, bundle);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }

    b(Parcel parcel) {
        this.c = a.AbstractBinderC0008a.a(parcel.readStrongBinder());
    }
}
