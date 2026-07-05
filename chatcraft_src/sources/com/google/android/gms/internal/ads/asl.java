package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class asl<T> implements asx<T> {

    /* renamed from: a, reason: collision with root package name */
    private final asf f2230a;

    /* renamed from: b, reason: collision with root package name */
    private final ato<?, ?> f2231b;
    private final boolean c;
    private final aql<?> d;

    private asl(ato<?, ?> atoVar, aql<?> aqlVar, asf asfVar) {
        this.f2231b = atoVar;
        this.c = aqlVar.a(asfVar);
        this.d = aqlVar;
        this.f2230a = asfVar;
    }

    static <T> asl<T> a(ato<?, ?> atoVar, aql<?> aqlVar, asf asfVar) {
        return new asl<>(atoVar, aqlVar, asfVar);
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final T a() {
        return (T) this.f2230a.p().e();
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final boolean a(T t, T t2) {
        if (!this.f2231b.b(t).equals(this.f2231b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final int a(T t) {
        int iHashCode = this.f2231b.b(t).hashCode();
        return this.c ? (iHashCode * 53) + this.d.a(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final void b(T t, T t2) {
        asz.a(this.f2231b, t, t2);
        if (this.c) {
            asz.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final void a(T t, auk aukVar) {
        Iterator itE = this.d.a(t).e();
        while (itE.hasNext()) {
            Map.Entry entry = (Map.Entry) itE.next();
            aqq aqqVar = (aqq) entry.getKey();
            if (aqqVar.c() != auj.MESSAGE || aqqVar.d() || aqqVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof arj) {
                aukVar.a(aqqVar.a(), (Object) ((arj) entry).a().c());
            } else {
                aukVar.a(aqqVar.a(), entry.getValue());
            }
        }
        ato<?, ?> atoVar = this.f2231b;
        atoVar.b((ato<?, ?>) atoVar.b(t), aukVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x003e. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.apl r11) throws com.google.android.gms.internal.ads.zzbrl {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.aqy r7 = (com.google.android.gms.internal.ads.aqy) r7
            com.google.android.gms.internal.ads.atp r0 = r7.zzfpu
            com.google.android.gms.internal.ads.atp r1 = com.google.android.gms.internal.ads.atp.a()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.ads.atp r0 = com.google.android.gms.internal.ads.atp.b()
            r7.zzfpu = r0
        L10:
            r7 = r0
        L11:
            if (r9 >= r10) goto L69
            int r2 = com.google.android.gms.internal.ads.apk.a(r8, r9, r11)
            int r0 = r11.f2145a
            r9 = 11
            r1 = 2
            if (r0 == r9) goto L30
            r9 = r0 & 7
            if (r9 != r1) goto L2b
            r1 = r8
            r3 = r10
            r4 = r7
            r5 = r11
            int r9 = com.google.android.gms.internal.ads.apk.a(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r9 = com.google.android.gms.internal.ads.apk.a(r0, r8, r2, r10, r11)
            goto L11
        L30:
            r9 = 0
            r0 = 0
        L32:
            if (r2 >= r10) goto L5f
            int r2 = com.google.android.gms.internal.ads.apk.a(r8, r2, r11)
            int r3 = r11.f2145a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            switch(r4) {
                case 2: goto L4d;
                case 3: goto L42;
                default: goto L41;
            }
        L41:
            goto L56
        L42:
            if (r5 != r1) goto L56
            int r2 = com.google.android.gms.internal.ads.apk.e(r8, r2, r11)
            java.lang.Object r0 = r11.c
            com.google.android.gms.internal.ads.apo r0 = (com.google.android.gms.internal.ads.apo) r0
            goto L32
        L4d:
            if (r5 != 0) goto L56
            int r2 = com.google.android.gms.internal.ads.apk.a(r8, r2, r11)
            int r9 = r11.f2145a
            goto L32
        L56:
            r4 = 12
            if (r3 == r4) goto L5f
            int r2 = com.google.android.gms.internal.ads.apk.a(r3, r8, r2, r10, r11)
            goto L32
        L5f:
            if (r0 == 0) goto L67
            int r9 = r9 << 3
            r9 = r9 | r1
            r7.a(r9, r0)
        L67:
            r9 = r2
            goto L11
        L69:
            if (r9 != r10) goto L6c
            return
        L6c:
            com.google.android.gms.internal.ads.zzbrl r7 = com.google.android.gms.internal.ads.zzbrl.h()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asl.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.apl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r11, com.google.android.gms.internal.ads.asw r12, com.google.android.gms.internal.ads.aqk r13) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.ato<?, ?> r0 = r10.f2231b
            com.google.android.gms.internal.ads.aql<?> r1 = r10.d
            java.lang.Object r2 = r0.c(r11)
            com.google.android.gms.internal.ads.aqo r3 = r1.b(r11)
        Lc:
            int r4 = r12.a()     // Catch: java.lang.Throwable -> L8f
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.b(r11, r2)
            return
        L19:
            int r4 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r6 = 11
            if (r4 == r6) goto L3e
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L39
            com.google.android.gms.internal.ads.asf r5 = r10.f2230a     // Catch: java.lang.Throwable -> L8f
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.a(r13, r5, r4)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L34
            r1.a(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L83
        L34:
            boolean r4 = r0.a(r2, r12)     // Catch: java.lang.Throwable -> L8f
            goto L84
        L39:
            boolean r4 = r12.c()     // Catch: java.lang.Throwable -> L8f
            goto L84
        L3e:
            r4 = 0
            r6 = 0
            r4 = r6
            r7 = 0
        L42:
            int r8 = r12.a()     // Catch: java.lang.Throwable -> L8f
            if (r8 == r5) goto L70
            int r8 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r9 = 16
            if (r8 != r9) goto L5b
            int r7 = r12.o()     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.asf r6 = r10.f2230a     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r6 = r1.a(r13, r6, r7)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L5b:
            r9 = 26
            if (r8 != r9) goto L6a
            if (r6 == 0) goto L65
            r1.a(r12, r6, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L65:
            com.google.android.gms.internal.ads.apo r4 = r12.n()     // Catch: java.lang.Throwable -> L8f
            goto L42
        L6a:
            boolean r8 = r12.c()     // Catch: java.lang.Throwable -> L8f
            if (r8 != 0) goto L42
        L70:
            int r5 = r12.b()     // Catch: java.lang.Throwable -> L8f
            r8 = 12
            if (r5 != r8) goto L8a
            if (r4 == 0) goto L83
            if (r6 == 0) goto L80
            r1.a(r4, r6, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L83
        L80:
            r0.a(r2, r7, r4)     // Catch: java.lang.Throwable -> L8f
        L83:
            r4 = 1
        L84:
            if (r4 != 0) goto Lc
            r0.b(r11, r2)
            return
        L8a:
            com.google.android.gms.internal.ads.zzbrl r12 = com.google.android.gms.internal.ads.zzbrl.e()     // Catch: java.lang.Throwable -> L8f
            throw r12     // Catch: java.lang.Throwable -> L8f
        L8f:
            r12 = move-exception
            r0.b(r11, r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asl.a(java.lang.Object, com.google.android.gms.internal.ads.asw, com.google.android.gms.internal.ads.aqk):void");
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final void c(T t) {
        this.f2231b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final boolean d(T t) {
        return this.d.a(t).g();
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final int b(T t) {
        ato<?, ?> atoVar = this.f2231b;
        int iE = atoVar.e(atoVar.b(t)) + 0;
        return this.c ? iE + this.d.a(t).i() : iE;
    }
}
