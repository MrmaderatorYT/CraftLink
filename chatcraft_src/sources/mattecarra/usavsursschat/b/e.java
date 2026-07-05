package mattecarra.usavsursschat.b;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: UserProfile.java */
/* loaded from: classes.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: mattecarra.usavsursschat.b.e.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f4930a;

    /* renamed from: b, reason: collision with root package name */
    private String f4931b;
    private boolean c;
    private String d;
    private String e;
    private String f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public e(String str, String str2, boolean z, String str3, String str4, String str5) {
        this.c = false;
        this.f4930a = str;
        this.f4931b = str2;
        this.c = z;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }

    public e() {
        this.c = false;
    }

    public e(String str) {
        this.c = false;
        this.f4930a = str;
    }

    public e(Parcel parcel) {
        this.c = false;
        this.f4930a = parcel.readString();
        this.f4931b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public String a() {
        return this.f4930a;
    }

    public void a(String str) {
        this.f4930a = str;
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public String c() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String e() {
        return this.f;
    }

    public void d(String str) {
        this.f = str;
    }

    public String f() {
        return this.f4931b;
    }

    public void e(String str) {
        this.f4931b = str;
    }

    public String toString() {
        return "UserProfile{username='" + this.f4930a + "', isPremium=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4930a);
        parcel.writeString(this.f4931b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
