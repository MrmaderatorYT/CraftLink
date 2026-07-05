package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzve extends ar {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3703a = Logger.getLogger(zzve.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3704b = as.a();

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private zzve() {
    }
}
