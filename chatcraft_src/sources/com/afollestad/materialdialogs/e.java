package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;

/* compiled from: GravityEnum.java */
/* loaded from: classes.dex */
public enum e {
    START,
    CENTER,
    END;

    private static final boolean d;

    static {
        d = Build.VERSION.SDK_INT >= 17;
    }

    @SuppressLint({"RtlHardcoded"})
    public int a() {
        switch (this) {
            case START:
                return d ? 8388611 : 3;
            case CENTER:
                return 1;
            case END:
                return d ? 8388613 : 5;
            default:
                throw new IllegalStateException("Invalid gravity constant");
        }
    }

    @TargetApi(17)
    public int b() {
        switch (this) {
            case CENTER:
                return 4;
            case END:
                return 6;
            default:
                return 5;
        }
    }
}
