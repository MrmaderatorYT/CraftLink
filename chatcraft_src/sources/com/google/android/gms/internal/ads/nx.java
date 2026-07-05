package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class nx {
    public static awj a(bje bjeVar) throws NumberFormatException {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = bjeVar.c;
        String str = map.get("Date");
        long jA = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long jA2 = str3 != null ? a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jA3 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = jCurrentTimeMillis + (j * 1000);
            j4 = i != 0 ? j3 : (j2 * 1000) + j3;
        } else if (jA <= 0 || jA2 < jA) {
            j3 = 0;
        } else {
            j4 = (jA2 - jA) + jCurrentTimeMillis;
            j3 = j4;
        }
        awj awjVar = new awj();
        awjVar.f2343a = bjeVar.f2728b;
        awjVar.f2344b = str5;
        awjVar.f = j3;
        awjVar.e = j4;
        awjVar.c = jA;
        awjVar.d = jA3;
        awjVar.g = map;
        awjVar.h = bjeVar.d;
        return awjVar;
    }

    private static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e) {
            eb.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String a(long j) {
        return a().format(new Date(j));
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
