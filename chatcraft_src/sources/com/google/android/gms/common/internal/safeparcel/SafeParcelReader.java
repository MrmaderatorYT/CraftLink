package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            int iDataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(iDataPosition);
            sb.append(" size=");
            sb.append(iDataSize);
            super(sb.toString());
        }
    }

    public static int a(int i) {
        return i & 65535;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void b(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i));
    }

    private static void a(Parcel parcel, int i, int i2) {
        int iA = a(parcel, i);
        if (iA == i2) {
            return;
        }
        String hexString = Integer.toHexString(iA);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iA);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }

    public static int b(Parcel parcel) {
        int iA = a(parcel);
        int iA2 = a(parcel, iA);
        int iDataPosition = parcel.dataPosition();
        if (a(iA) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(iA));
            throw new ParseException(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = iA2 + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }

    public static boolean c(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int d(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long e(Parcel parcel, int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    public static float f(Parcel parcel, int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static String g(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iA);
        return string;
    }

    public static IBinder h(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iA);
        return strongBinder;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iA);
        return tCreateFromParcel;
    }

    public static Bundle i(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iA);
        return bundle;
    }

    public static byte[] j(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iA);
        return bArrCreateByteArray;
    }

    public static String[] k(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iA);
        return strArrCreateStringArray;
    }

    public static ArrayList<Integer> l(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iA);
        return arrayList;
    }

    public static ArrayList<String> m(Parcel parcel, int i) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iA);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iA = a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iA == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iA);
        return tArr;
    }

    public static void n(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new ParseException(sb.toString(), parcel);
    }
}
