package mattecarra.usavsursschat.d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: InetAddressValidator.java */
/* loaded from: classes.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final b f4969a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final c f4970b = new c("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public static b a() {
        return f4969a;
    }

    public boolean a(String str) {
        return b(str) || c(str);
    }

    public boolean b(String str) {
        String[] strArrB = this.f4970b.b(str);
        if (strArrB == null) {
            return false;
        }
        for (int i = 0; i <= 3; i++) {
            String str2 = strArrB[i];
            if (str2 == null || str2.length() == 0) {
                return false;
            }
            try {
                if (Integer.parseInt(str2) > 255) {
                    return false;
                }
                if (str2.length() > 1 && str2.startsWith("0")) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }

    public boolean c(String str) {
        boolean z = str.indexOf("::") > -1;
        if (z && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if ((str.startsWith(":") && !str.startsWith("::")) || (str.endsWith(":") && !str.endsWith("::"))) {
            return false;
        }
        Object[] objArrSplit = str.split(":");
        if (z) {
            ArrayList arrayList = new ArrayList(Arrays.asList(objArrSplit));
            if (str.endsWith("::")) {
                arrayList.add(BuildConfig.FLAVOR);
            } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            objArrSplit = arrayList.toArray();
        }
        if (objArrSplit.length > 8) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < objArrSplit.length; i3++) {
            String str2 = (String) objArrSplit[i3];
            if (str2.length() == 0) {
                i2++;
                if (i2 > 1) {
                    return false;
                }
            } else if (str2.indexOf(".") > -1) {
                if (!str.endsWith(str2) || i3 > objArrSplit.length - 1 || i3 > 6 || !b(str2)) {
                    return false;
                }
                i += 2;
                i2 = 0;
            } else {
                if (str2.length() > 4) {
                    return false;
                }
                try {
                    int iIntValue = Integer.valueOf(str2, 16).intValue();
                    if (iIntValue < 0 || iIntValue > 65535) {
                        return false;
                    }
                    i2 = 0;
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            i++;
        }
        return i >= 8 || z;
    }
}
