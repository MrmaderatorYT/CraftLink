package com.crashlytics.android.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProcMapEntryParser.java */
/* loaded from: classes.dex */
final class al {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f1309a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    public static ak a(String str) {
        Matcher matcher = f1309a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long jLongValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new ak(jLongValue, Long.valueOf(matcher.group(2), 16).longValue() - jLongValue, matcher.group(3), matcher.group(4));
        } catch (Exception unused) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not parse map entry: " + str);
            return null;
        }
    }
}
