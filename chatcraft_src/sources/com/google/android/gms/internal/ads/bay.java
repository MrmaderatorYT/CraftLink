package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class bay {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2473a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f2474b = false;
    private int A;
    private int B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private Method G;
    private int H;
    private long I;
    private long J;
    private int K;
    private long L;
    private long M;
    private int N;
    private int O;
    private long P;
    private long Q;
    private long R;
    private float S;
    private bap[] T;
    private ByteBuffer[] U;
    private ByteBuffer V;
    private ByteBuffer W;
    private byte[] X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private long af;
    private final bbf d;
    private final bbm e;
    private final bap[] f;
    private final bbc g;
    private final long[] i;
    private final bba j;
    private final LinkedList<bbd> k;
    private AudioTrack l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private long t;
    private baf u;
    private baf v;
    private long w;
    private long x;
    private ByteBuffer y;
    private int z;
    private final bao c = null;
    private final ConditionVariable h = new ConditionVariable(true);

    public bay(bao baoVar, bap[] bapVarArr, bbc bbcVar) {
        baz bazVar = null;
        this.g = bbcVar;
        if (bkg.f2760a >= 18) {
            try {
                this.G = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (bkg.f2760a >= 19) {
            this.j = new bbb();
        } else {
            this.j = new bba(bazVar);
        }
        this.d = new bbf();
        this.e = new bbm();
        this.f = new bap[bapVarArr.length + 3];
        this.f[0] = new bbk();
        this.f[1] = this.d;
        System.arraycopy(bapVarArr, 0, this.f, 2, bapVarArr.length);
        this.f[bapVarArr.length + 2] = this.e;
        this.i = new long[10];
        this.S = 1.0f;
        this.O = 0;
        this.q = 3;
        this.ac = 0;
        this.v = baf.f2445a;
        this.Z = -1;
        this.T = new bap[0];
        this.U = new ByteBuffer[0];
        this.k = new LinkedList<>();
    }

    public final boolean a(String str) {
        return this.c != null && this.c.a(b(str));
    }

    public final long a(boolean z) {
        long jC;
        long jB;
        long jA;
        if (!(n() && this.O != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.l.getPlayState() == 3) {
            long jC2 = this.j.c();
            if (jC2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.D >= 30000) {
                    this.i[this.A] = jC2 - jNanoTime;
                    this.A = (this.A + 1) % 10;
                    if (this.B < 10) {
                        this.B++;
                    }
                    this.D = jNanoTime;
                    this.C = 0L;
                    for (int i = 0; i < this.B; i++) {
                        this.C += this.i[i] / this.B;
                    }
                }
                if (!q() && jNanoTime - this.F >= 500000) {
                    this.E = this.j.d();
                    if (this.E) {
                        long jE = this.j.e() / 1000;
                        long jF = this.j.f();
                        if (jE < this.Q) {
                            this.E = false;
                        } else if (Math.abs(jE - jNanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(jF);
                            sb.append(", ");
                            sb.append(jE);
                            sb.append(", ");
                            sb.append(jNanoTime);
                            sb.append(", ");
                            sb.append(jC2);
                            Log.w("AudioTrack", sb.toString());
                            this.E = false;
                        } else if (Math.abs(b(jF) - jC2) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(jF);
                            sb2.append(", ");
                            sb2.append(jE);
                            sb2.append(", ");
                            sb2.append(jNanoTime);
                            sb2.append(", ");
                            sb2.append(jC2);
                            Log.w("AudioTrack", sb2.toString());
                            this.E = false;
                        }
                    }
                    if (this.G != null && !this.r) {
                        try {
                            this.R = (((Integer) this.G.invoke(this.l, null)).intValue() * 1000) - this.t;
                            this.R = Math.max(this.R, 0L);
                            if (this.R > 5000000) {
                                long j = this.R;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j);
                                Log.w("AudioTrack", sb3.toString());
                                this.R = 0L;
                            }
                        } catch (Exception unused) {
                            this.G = null;
                        }
                    }
                    this.F = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        if (this.E) {
            jB = b(this.j.f() + c(jNanoTime2 - (this.j.e() / 1000)));
        } else {
            if (this.B == 0) {
                jC = this.j.c();
            } else {
                jC = jNanoTime2 + this.C;
            }
            jB = jC;
            if (!z) {
                jB -= this.R;
            }
        }
        long j2 = this.P;
        while (!this.k.isEmpty() && jB >= this.k.getFirst().c) {
            bbd bbdVarRemove = this.k.remove();
            this.v = bbdVarRemove.f2482a;
            this.x = bbdVarRemove.c;
            this.w = bbdVarRemove.f2483b - this.P;
        }
        if (this.v.f2446b == 1.0f) {
            jA = (jB + this.w) - this.x;
        } else if (this.k.isEmpty() && this.e.j() >= 1024) {
            jA = bkg.a(jB - this.x, this.e.i(), this.e.j()) + this.w;
        } else {
            long j3 = this.w;
            double d = this.v.f2446b;
            double d2 = jB - this.x;
            Double.isNaN(d);
            Double.isNaN(d2);
            jA = ((long) (d * d2)) + j3;
        }
        return j2 + jA;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzgw, java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bay.a(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void k() {
        ArrayList arrayList = new ArrayList();
        for (bap bapVar : this.f) {
            if (bapVar.a()) {
                arrayList.add(bapVar);
            } else {
                bapVar.g();
            }
        }
        int size = arrayList.size();
        this.T = (bap[]) arrayList.toArray(new bap[size]);
        this.U = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            bap bapVar2 = this.T[i];
            bapVar2.g();
            this.U[i] = bapVar2.e();
        }
    }

    public final void a() throws IllegalStateException {
        this.ab = true;
        if (n()) {
            this.Q = System.nanoTime() / 1000;
            this.l.play();
        }
    }

    public final void b() {
        if (this.O == 1) {
            this.O = 2;
        }
    }

    public final boolean a(ByteBuffer byteBuffer, long j) throws IllegalStateException, zzha, zzgx {
        int i;
        int iA;
        bjq.a(this.V == null || byteBuffer == this.V);
        if (!n()) {
            this.h.block();
            if (this.ad) {
                this.l = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.n).setEncoding(this.p).setSampleRate(this.m).build(), this.s, 1, this.ac);
            } else if (this.ac == 0) {
                this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1);
            } else {
                this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1, this.ac);
            }
            int state = this.l.getState();
            if (state != 1) {
                try {
                    this.l.release();
                } catch (Exception unused) {
                } finally {
                    this.l = null;
                }
                throw new zzgx(state, this.m, this.n, this.s);
            }
            int audioSessionId = this.l.getAudioSessionId();
            if (this.ac != audioSessionId) {
                this.ac = audioSessionId;
                this.g.a(audioSessionId);
            }
            this.j.a(this.l, q());
            m();
            this.ae = false;
            if (this.ab) {
                a();
            }
        }
        if (q()) {
            if (this.l.getPlayState() == 2) {
                this.ae = false;
                return false;
            }
            if (this.l.getPlayState() == 1 && this.j.b() != 0) {
                return false;
            }
        }
        boolean z = this.ae;
        this.ae = e();
        if (z && !this.ae && this.l.getPlayState() != 1) {
            this.g.a(this.s, azo.a(this.t), SystemClock.elapsedRealtime() - this.af);
        }
        if (this.V == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.r && this.N == 0) {
                int i2 = this.p;
                if (i2 == 7 || i2 == 8) {
                    iA = bbg.a(byteBuffer);
                } else if (i2 == 5) {
                    iA = ban.a();
                } else if (i2 == 6) {
                    iA = ban.a(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
                this.N = iA;
            }
            if (this.u != null) {
                if (!l()) {
                    return false;
                }
                this.k.add(new bbd(this.u, Math.max(0L, j), b(o()), null));
                this.u = null;
                k();
            }
            if (this.O == 0) {
                this.P = Math.max(0L, j);
                this.O = 1;
            } else {
                long jB = this.P + b(this.r ? this.J : this.I / this.H);
                if (this.O != 1 || Math.abs(jB - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(jB);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.O = 2;
                }
                if (this.O == i) {
                    this.P += j - jB;
                    this.O = 1;
                    this.g.a();
                }
            }
            if (this.r) {
                this.J += this.N;
            } else {
                this.I += byteBuffer.remaining();
            }
            this.V = byteBuffer;
        }
        if (this.r) {
            b(this.V, j);
        } else {
            a(j);
        }
        if (this.V.hasRemaining()) {
            return false;
        }
        this.V = null;
        return true;
    }

    private final void a(long j) throws zzha {
        ByteBuffer byteBuffer;
        int length = this.T.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.U[i - 1];
            } else {
                byteBuffer = this.V != null ? this.V : bap.f2458a;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                bap bapVar = this.T[i];
                bapVar.a(byteBuffer);
                ByteBuffer byteBufferE = bapVar.e();
                this.U[i] = byteBufferE;
                if (byteBufferE.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean b(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzha {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bay.b(java.nio.ByteBuffer, long):boolean");
    }

    public final void c() {
        if (!this.aa && n() && l()) {
            this.j.a(o());
            this.z = 0;
            this.aa = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0036 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean l() throws com.google.android.gms.internal.ads.zzha {
        /*
            r8 = this;
            int r0 = r8.Z
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r8.r
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.bap[] r0 = r8.T
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r8.Z = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r8.Z
            com.google.android.gms.internal.ads.bap[] r5 = r8.T
            int r5 = r5.length
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r5) goto L3c
            com.google.android.gms.internal.ads.bap[] r4 = r8.T
            int r5 = r8.Z
            r4 = r4[r5]
            if (r0 == 0) goto L2c
            r4.d()
        L2c:
            r8.a(r6)
            boolean r0 = r4.f()
            if (r0 != 0) goto L36
            return r3
        L36:
            int r0 = r8.Z
            int r0 = r0 + r2
            r8.Z = r0
            goto L12
        L3c:
            java.nio.ByteBuffer r0 = r8.W
            if (r0 == 0) goto L4a
            java.nio.ByteBuffer r0 = r8.W
            r8.b(r0, r6)
            java.nio.ByteBuffer r0 = r8.W
            if (r0 == 0) goto L4a
            return r3
        L4a:
            r8.Z = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bay.l():boolean");
    }

    public final boolean d() {
        if (n()) {
            return this.aa && !e();
        }
        return true;
    }

    public final boolean e() {
        if (n()) {
            if (o() <= this.j.b()) {
                if (q() && this.l.getPlayState() == 2 && this.l.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final baf a(baf bafVar) {
        baf bafVar2;
        if (this.r) {
            this.v = baf.f2445a;
            return this.v;
        }
        baf bafVar3 = new baf(this.e.a(bafVar.f2446b), this.e.b(bafVar.c));
        if (this.u != null) {
            bafVar2 = this.u;
        } else if (!this.k.isEmpty()) {
            bafVar2 = this.k.getLast().f2482a;
        } else {
            bafVar2 = this.v;
        }
        if (!bafVar3.equals(bafVar2)) {
            if (n()) {
                this.u = bafVar3;
            } else {
                this.v = bafVar3;
            }
        }
        return this.v;
    }

    public final baf f() {
        return this.v;
    }

    public final void a(int i) throws IllegalStateException {
        if (this.q == i) {
            return;
        }
        this.q = i;
        if (this.ad) {
            return;
        }
        i();
        this.ac = 0;
    }

    public final void b(int i) throws IllegalStateException {
        bjq.b(bkg.f2760a >= 21);
        if (this.ad && this.ac == i) {
            return;
        }
        this.ad = true;
        this.ac = i;
        i();
    }

    public final void g() throws IllegalStateException {
        if (this.ad) {
            this.ad = false;
            this.ac = 0;
            i();
        }
    }

    public final void a(float f) {
        if (this.S != f) {
            this.S = f;
            m();
        }
    }

    private final void m() {
        if (n()) {
            if (bkg.f2760a >= 21) {
                this.l.setVolume(this.S);
                return;
            }
            AudioTrack audioTrack = this.l;
            float f = this.S;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void h() {
        this.ab = false;
        if (n()) {
            p();
            this.j.a();
        }
    }

    public final void i() throws IllegalStateException {
        if (n()) {
            this.I = 0L;
            this.J = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0;
            if (this.u != null) {
                this.v = this.u;
                this.u = null;
            } else if (!this.k.isEmpty()) {
                this.v = this.k.getLast().f2482a;
            }
            this.k.clear();
            this.w = 0L;
            this.x = 0L;
            this.V = null;
            this.W = null;
            for (int i = 0; i < this.T.length; i++) {
                bap bapVar = this.T[i];
                bapVar.g();
                this.U[i] = bapVar.e();
            }
            this.aa = false;
            this.Z = -1;
            this.y = null;
            this.z = 0;
            this.O = 0;
            this.R = 0L;
            p();
            if (this.l.getPlayState() == 3) {
                this.l.pause();
            }
            AudioTrack audioTrack = this.l;
            this.l = null;
            this.j.a(null, false);
            this.h.close();
            new baz(this, audioTrack).start();
        }
    }

    public final void j() throws IllegalStateException {
        i();
        for (bap bapVar : this.f) {
            bapVar.h();
        }
        this.ac = 0;
        this.ab = false;
    }

    private final boolean n() {
        return this.l != null;
    }

    private final long b(long j) {
        return (j * 1000000) / this.m;
    }

    private final long c(long j) {
        return (j * this.m) / 1000000;
    }

    private final long o() {
        return this.r ? this.M : this.L / this.K;
    }

    private final void p() {
        this.C = 0L;
        this.B = 0;
        this.A = 0;
        this.D = 0L;
        this.E = false;
        this.F = 0L;
    }

    private final boolean q() {
        if (bkg.f2760a < 23) {
            return this.p == 5 || this.p == 6;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1095064472(0xffffffffbebaa468, float:-0.36453557)
            r2 = 0
            if (r0 == r1) goto L38
            r1 = 187078296(0xb269698, float:3.208373E-32)
            if (r0 == r1) goto L2e
            r1 = 1504578661(0x59ae0c65, float:6.1237842E15)
            if (r0 == r1) goto L24
            r1 = 1505942594(0x59c2dc42, float:6.8560402E15)
            if (r0 == r1) goto L1a
            goto L42
        L1a:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L42
            r3 = 3
            goto L43
        L24:
            java.lang.String r0 = "audio/eac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L42
            r3 = 1
            goto L43
        L2e:
            java.lang.String r0 = "audio/ac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L42
            r3 = 0
            goto L43
        L38:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L42
            r3 = 2
            goto L43
        L42:
            r3 = -1
        L43:
            switch(r3) {
                case 0: goto L4e;
                case 1: goto L4c;
                case 2: goto L4a;
                case 3: goto L47;
                default: goto L46;
            }
        L46:
            return r2
        L47:
            r3 = 8
            return r3
        L4a:
            r3 = 7
            return r3
        L4c:
            r3 = 6
            return r3
        L4e:
            r3 = 5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bay.b(java.lang.String):int");
    }
}
