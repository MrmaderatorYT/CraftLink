package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.bem;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class bch {
    private static final bes c = new bci();
    private static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f2514a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f2515b = -1;

    public final boolean a(bem bemVar) {
        for (int i = 0; i < bemVar.a(); i++) {
            bem.a aVarA = bemVar.a(i);
            if (aVarA instanceof beq) {
                beq beqVar = (beq) aVarA;
                if (a(beqVar.f2591a, beqVar.f2592b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean a(String str, String str2) throws NumberFormatException {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = d.matcher(str2);
        if (matcher.find()) {
            try {
                int i = Integer.parseInt(matcher.group(1), 16);
                int i2 = Integer.parseInt(matcher.group(2), 16);
                if (i > 0 || i2 > 0) {
                    this.f2514a = i;
                    this.f2515b = i2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean a() {
        return (this.f2514a == -1 || this.f2515b == -1) ? false : true;
    }
}
