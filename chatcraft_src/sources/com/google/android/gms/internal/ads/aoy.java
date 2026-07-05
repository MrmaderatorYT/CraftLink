package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class aoy {

    /* renamed from: a, reason: collision with root package name */
    private static final aoz f2130a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2131b;

    static final class a extends aoz {
        a() {
        }

        @Override // com.google.android.gms.internal.ads.aoz
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.android.gms.internal.ads.aoz
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    public static void a(Throwable th) {
        f2130a.a(th);
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        f2130a.a(th, printWriter);
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: Throwable -> 0x0015, TryCatch #1 {Throwable -> 0x0015, blocks: (B:5:0x0007, B:7:0x000f, B:10:0x0017, B:12:0x0020, B:13:0x0026), top: B:27:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = a()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L17
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L15
            r3 = 19
            if (r2 < r3) goto L17
            com.google.android.gms.internal.ads.apd r2 = new com.google.android.gms.internal.ads.apd     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L63
        L15:
            r2 = move-exception
            goto L2e
        L17:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L15
            r2 = r2 ^ r0
            if (r2 == 0) goto L26
            com.google.android.gms.internal.ads.apc r2 = new com.google.android.gms.internal.ads.apc     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L63
        L26:
            com.google.android.gms.internal.ads.aoy$a r2 = new com.google.android.gms.internal.ads.aoy$a     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            goto L63
        L2c:
            r2 = move-exception
            r1 = 0
        L2e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.ads.aoy$a> r4 = com.google.android.gms.internal.ads.aoy.a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 132
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.ads.aoy$a r2 = new com.google.android.gms.internal.ads.aoy$a
            r2.<init>()
        L63:
            com.google.android.gms.internal.ads.aoy.f2130a = r2
            if (r1 != 0) goto L68
            goto L6c
        L68:
            int r0 = r1.intValue()
        L6c:
            com.google.android.gms.internal.ads.aoy.f2131b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aoy.<clinit>():void");
    }
}
