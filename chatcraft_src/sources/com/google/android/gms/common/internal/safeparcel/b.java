package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    private static void b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(i2);
        } else {
            parcel.writeInt(i | (i2 << 16));
        }
    }

    private static int b(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void c(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    public static void a(Parcel parcel, int i) {
        c(parcel, i);
    }

    public static void a(Parcel parcel, int i, boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i, int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void a(Parcel parcel, int i, long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, float f) {
        b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeString(str);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeBundle(bundle);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeByteArray(bArr);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeStringArray(strArr);
            c(parcel, iB);
        }
    }

    public static void a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int iB = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        c(parcel, iB);
    }

    public static void b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int iB = b(parcel, i);
            parcel.writeStringList(list);
            c(parcel, iB);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int iB = b(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, i2);
            }
        }
        c(parcel, iB);
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
