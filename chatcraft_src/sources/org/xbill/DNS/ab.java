package org.xbill.DNS;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: FormattedTime.java */
/* loaded from: classes.dex */
final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static NumberFormat f5305a = new DecimalFormat();

    /* renamed from: b, reason: collision with root package name */
    private static NumberFormat f5306b;

    static {
        f5305a.setMinimumIntegerDigits(2);
        f5306b = new DecimalFormat();
        f5306b.setMinimumIntegerDigits(4);
        f5306b.setGroupingUsed(false);
    }

    public static String a(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        StringBuffer stringBuffer = new StringBuffer();
        gregorianCalendar.setTime(date);
        stringBuffer.append(f5306b.format(gregorianCalendar.get(1)));
        stringBuffer.append(f5305a.format(gregorianCalendar.get(2) + 1));
        stringBuffer.append(f5305a.format(gregorianCalendar.get(5)));
        stringBuffer.append(f5305a.format(gregorianCalendar.get(11)));
        stringBuffer.append(f5305a.format(gregorianCalendar.get(12)));
        stringBuffer.append(f5305a.format(gregorianCalendar.get(13)));
        return stringBuffer.toString();
    }
}
