package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes.dex */
public final class bkq extends bed {
    private static final int[] c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int A;
    private int B;
    private int C;
    private float D;
    private boolean E;
    private int F;
    private long G;
    private int H;

    /* renamed from: b, reason: collision with root package name */
    bkt f2773b;
    private final Context d;
    private final bku e;
    private final bkx f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private bab[] k;
    private bks l;
    private Surface m;
    private Surface n;
    private int o;
    private boolean p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private float v;
    private int w;
    private int x;
    private int y;
    private float z;

    public bkq(Context context, bef befVar, long j, Handler handler, bkw bkwVar, int i) {
        this(context, befVar, 0L, null, false, handler, bkwVar, -1);
    }

    private static boolean c(long j) {
        return j < -30000;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private bkq(Context context, bef befVar, long j, bbx<Object> bbxVar, boolean z, Handler handler, bkw bkwVar, int i) {
        super(2, befVar, null, false);
        boolean z2 = false;
        this.g = 0L;
        this.h = -1;
        this.d = context.getApplicationContext();
        this.e = new bku(context);
        this.f = new bkx(handler, bkwVar);
        if (bkg.f2760a <= 22 && "foster".equals(bkg.f2761b) && "NVIDIA".equals(bkg.c)) {
            z2 = true;
        }
        this.i = z2;
        this.j = new long[10];
        this.G = -9223372036854775807L;
        this.q = -9223372036854775807L;
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.o = 1;
        D();
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final int a(bef befVar, bab babVar) {
        boolean z;
        String str = babVar.e;
        if (!bjv.b(str)) {
            return 0;
        }
        bbt bbtVar = babVar.h;
        if (bbtVar != null) {
            z = false;
            for (int i = 0; i < bbtVar.f2504a; i++) {
                z |= bbtVar.a(i).f2506a;
            }
        } else {
            z = false;
        }
        bec becVarA = befVar.a(str, z);
        if (becVarA == null) {
            return 1;
        }
        boolean zB = becVarA.b(babVar.c);
        if (zB && babVar.i > 0 && babVar.j > 0) {
            if (bkg.f2760a >= 21) {
                zB = becVarA.a(babVar.i, babVar.j, babVar.k);
            } else {
                zB = babVar.i * babVar.j <= beh.b();
                if (!zB) {
                    int i2 = babVar.i;
                    int i3 = babVar.j;
                    String str2 = bkg.e;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(i3);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (zB ? 3 : 2) | (becVarA.f2576b ? 8 : 4) | (becVarA.c ? 16 : 0);
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void a(boolean z) {
        super.a(z);
        this.F = q().f2448b;
        this.E = this.F != 0;
        this.f.a(this.f2578a);
        this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected final void a(bab[] babVarArr, long j) {
        this.k = babVarArr;
        if (this.G == -9223372036854775807L) {
            this.G = j;
        } else {
            if (this.H == this.j.length) {
                long j2 = this.j[this.H - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.H++;
            }
            this.j[this.H - 1] = j;
        }
        super.a(babVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void a(long j, boolean z) {
        super.a(j, z);
        x();
        this.t = 0;
        if (this.H != 0) {
            this.G = this.j[this.H - 1];
            this.H = 0;
        }
        if (z) {
            w();
        } else {
            this.q = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.bag
    public final boolean t() {
        if (super.t() && (this.p || ((this.n != null && this.m == this.n) || A() == null))) {
            this.q = -9223372036854775807L;
            return true;
        }
        if (this.q == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.q) {
            return true;
        }
        this.q = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void n() {
        super.n();
        this.s = 0;
        this.r = SystemClock.elapsedRealtime();
        this.q = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void o() {
        G();
        super.o();
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void p() {
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.G = -9223372036854775807L;
        this.H = 0;
        D();
        x();
        this.e.b();
        this.f2773b = null;
        this.E = false;
        try {
            super.p();
        } finally {
            this.f2578a.a();
            this.f.b(this.f2578a);
        }
    }

    @Override // com.google.android.gms.internal.ads.azn, com.google.android.gms.internal.ads.azr
    public final void a(int i, Object obj) throws zzff {
        if (i != 1) {
            if (i == 4) {
                this.o = ((Integer) obj).intValue();
                MediaCodec mediaCodecA = A();
                if (mediaCodecA != null) {
                    mediaCodecA.setVideoScalingMode(this.o);
                    return;
                }
                return;
            }
            super.a(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            if (this.n != null) {
                surface = this.n;
            } else {
                bec becVarB = B();
                if (becVarB != null && b(becVarB.d)) {
                    this.n = bkm.a(this.d, becVarB.d);
                    surface = this.n;
                }
            }
        }
        if (this.m != surface) {
            this.m = surface;
            int iD = d();
            if (iD == 1 || iD == 2) {
                MediaCodec mediaCodecA2 = A();
                if (bkg.f2760a >= 23 && mediaCodecA2 != null && surface != null) {
                    mediaCodecA2.setOutputSurface(surface);
                } else {
                    C();
                    z();
                }
            }
            if (surface != null && surface != this.n) {
                F();
                x();
                if (iD == 2) {
                    w();
                    return;
                }
                return;
            }
            D();
            x();
            return;
        }
        if (surface == null || surface == this.n) {
            return;
        }
        F();
        if (this.p) {
            this.f.a(this.m);
        }
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final boolean a(bec becVar) {
        return this.m != null || b(becVar.d);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(bec becVar, MediaCodec mediaCodec, bab babVar, MediaCrypto mediaCrypto) {
        bks bksVar;
        Point point;
        bab[] babVarArr = this.k;
        int i = babVar.i;
        int i2 = babVar.j;
        int iC = c(babVar);
        if (babVarArr.length == 1) {
            bksVar = new bks(i, i2, iC);
        } else {
            int iMax = i2;
            int iMax2 = iC;
            boolean z = false;
            int iMax3 = i;
            for (bab babVar2 : babVarArr) {
                if (a(becVar.f2576b, babVar, babVar2)) {
                    z |= babVar2.i == -1 || babVar2.j == -1;
                    iMax3 = Math.max(iMax3, babVar2.i);
                    int iMax4 = Math.max(iMax, babVar2.j);
                    iMax2 = Math.max(iMax2, c(babVar2));
                    iMax = iMax4;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax3);
                sb.append("x");
                sb.append(iMax);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = babVar.j > babVar.i;
                int i3 = z2 ? babVar.j : babVar.i;
                int i4 = z2 ? babVar.i : babVar.j;
                float f = i4 / i3;
                int[] iArr = c;
                int length = iArr.length;
                int i5 = 0;
                while (i5 < length) {
                    int i6 = iArr[i5];
                    int i7 = (int) (i6 * f);
                    if (i6 <= i3 || i7 <= i4) {
                        break;
                    }
                    int i8 = i3;
                    int i9 = i4;
                    if (bkg.f2760a >= 21) {
                        int i10 = z2 ? i7 : i6;
                        if (!z2) {
                            i6 = i7;
                        }
                        Point pointA = becVar.a(i10, i6);
                        if (becVar.a(pointA.x, pointA.y, babVar.k)) {
                            point = pointA;
                            break;
                        } else {
                            i5++;
                            i3 = i8;
                            i4 = i9;
                        }
                    } else {
                        int iA = bkg.a(i6, 16) << 4;
                        int iA2 = bkg.a(i7, 16) << 4;
                        if (iA * iA2 <= beh.b()) {
                            int i11 = z2 ? iA2 : iA;
                            if (z2) {
                                iA2 = iA;
                            }
                            point = new Point(i11, iA2);
                        } else {
                            i5++;
                            i3 = i8;
                            i4 = i9;
                        }
                    }
                }
                point = null;
                if (point != null) {
                    iMax3 = Math.max(iMax3, point.x);
                    iMax = Math.max(iMax, point.y);
                    iMax2 = Math.max(iMax2, a(babVar.e, iMax3, iMax));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax3);
                    sb2.append("x");
                    sb2.append(iMax);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            bksVar = new bks(iMax3, iMax, iMax2);
        }
        this.l = bksVar;
        bks bksVar2 = this.l;
        boolean z3 = this.i;
        int i12 = this.F;
        MediaFormat mediaFormatB = babVar.b();
        mediaFormatB.setInteger("max-width", bksVar2.f2774a);
        mediaFormatB.setInteger("max-height", bksVar2.f2775b);
        if (bksVar2.c != -1) {
            mediaFormatB.setInteger("max-input-size", bksVar2.c);
        }
        if (z3) {
            mediaFormatB.setInteger("auto-frc", 0);
        }
        if (i12 != 0) {
            mediaFormatB.setFeatureEnabled("tunneled-playback", true);
            mediaFormatB.setInteger("audio-session-id", i12);
        }
        if (this.m == null) {
            bjq.b(b(becVar.d));
            if (this.n == null) {
                this.n = bkm.a(this.d, becVar.d);
            }
            this.m = this.n;
        }
        mediaCodec.configure(mediaFormatB, this.m, (MediaCrypto) null, 0);
        if (bkg.f2760a < 23 || !this.E) {
            return;
        }
        this.f2773b = new bkt(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void C() {
        try {
            super.C();
        } finally {
            if (this.n != null) {
                if (this.m == this.n) {
                    this.m = null;
                }
                this.n.release();
                this.n = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(String str, long j, long j2) {
        this.f.a(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void b(bab babVar) {
        super.b(babVar);
        this.f.a(babVar);
        this.v = babVar.m == -1.0f ? 1.0f : babVar.m;
        this.u = d(babVar);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(bbs bbsVar) {
        if (bkg.f2760a >= 23 || !this.E) {
            return;
        }
        v();
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.w = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.x = integer2;
        this.z = this.v;
        if (bkg.f2760a >= 21) {
            if (this.u == 90 || this.u == 270) {
                int i = this.w;
                this.w = this.x;
                this.x = i;
                this.z = 1.0f / this.z;
            }
        } else {
            this.y = this.u;
        }
        mediaCodec.setVideoScalingMode(this.o);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final boolean a(MediaCodec mediaCodec, boolean z, bab babVar, bab babVar2) {
        return a(z, babVar, babVar2) && babVar2.i <= this.l.f2774a && babVar2.j <= this.l.f2775b && babVar2.f <= this.l.c;
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws InterruptedException {
        while (this.H != 0 && j3 >= this.j[0]) {
            this.G = this.j[0];
            this.H--;
            System.arraycopy(this.j, 1, this.j, 0, this.H);
        }
        long j4 = j3 - this.G;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.m == this.n) {
            if (!c(j5)) {
                return false;
            }
            a(mediaCodec, i, j4);
            return true;
        }
        if (!this.p) {
            if (bkg.f2760a >= 21) {
                a(mediaCodec, i, j4, System.nanoTime());
            } else {
                b(mediaCodec, i, j4);
            }
            return true;
        }
        if (d() != 2) {
            return false;
        }
        long jElapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long jNanoTime = System.nanoTime();
        long jA = this.e.a(j3, (jElapsedRealtime * 1000) + jNanoTime);
        long j6 = (jA - jNanoTime) / 1000;
        if (c(j6)) {
            bke.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            bke.a();
            this.f2578a.f++;
            this.s++;
            this.t++;
            this.f2578a.g = Math.max(this.t, this.f2578a.g);
            if (this.s == this.h) {
                G();
            }
            return true;
        }
        if (bkg.f2760a >= 21) {
            if (j6 < 50000) {
                a(mediaCodec, i, j4, jA);
                return true;
            }
        } else if (j6 < 30000) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            b(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    private final void a(MediaCodec mediaCodec, int i, long j) {
        bke.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        bke.a();
        this.f2578a.e++;
    }

    private final void b(MediaCodec mediaCodec, int i, long j) {
        E();
        bke.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        bke.a();
        this.f2578a.d++;
        this.t = 0;
        v();
    }

    @TargetApi(21)
    private final void a(MediaCodec mediaCodec, int i, long j, long j2) {
        E();
        bke.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        bke.a();
        this.f2578a.d++;
        this.t = 0;
        v();
    }

    private final boolean b(boolean z) {
        if (bkg.f2760a < 23 || this.E) {
            return false;
        }
        return !z || bkm.a(this.d);
    }

    private final void w() {
        this.q = this.g > 0 ? SystemClock.elapsedRealtime() + this.g : -9223372036854775807L;
    }

    private final void x() {
        MediaCodec mediaCodecA;
        this.p = false;
        if (bkg.f2760a < 23 || !this.E || (mediaCodecA = A()) == null) {
            return;
        }
        this.f2773b = new bkt(this, mediaCodecA);
    }

    final void v() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.f.a(this.m);
    }

    private final void D() {
        this.A = -1;
        this.B = -1;
        this.D = -1.0f;
        this.C = -1;
    }

    private final void E() {
        if (this.A == this.w && this.B == this.x && this.C == this.y && this.D == this.z) {
            return;
        }
        this.f.a(this.w, this.x, this.y, this.z);
        this.A = this.w;
        this.B = this.x;
        this.C = this.y;
        this.D = this.z;
    }

    private final void F() {
        if (this.A == -1 && this.B == -1) {
            return;
        }
        this.f.a(this.w, this.x, this.y, this.z);
    }

    private final void G() {
        if (this.s > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(this.s, jElapsedRealtime - this.r);
            this.s = 0;
            this.r = jElapsedRealtime;
        }
    }

    private static int c(bab babVar) {
        if (babVar.f != -1) {
            return babVar.f;
        }
        return a(babVar.e, babVar.i, babVar.j);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.lang.String r5, int r6, int r7) {
        /*
            r0 = -1
            if (r6 == r0) goto L7e
            if (r7 != r0) goto L7
            goto L7e
        L7:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 4
            r4 = 2
            switch(r1) {
                case -1664118616: goto L44;
                case -1662541442: goto L3a;
                case 1187890754: goto L30;
                case 1331836730: goto L26;
                case 1599127256: goto L1c;
                case 1599127257: goto L12;
                default: goto L11;
            }
        L11:
            goto L4e
        L12:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 5
            goto L4f
        L1c:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 3
            goto L4f
        L26:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 2
            goto L4f
        L30:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 1
            goto L4f
        L3a:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 4
            goto L4f
        L44:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L4e
            r5 = 0
            goto L4f
        L4e:
            r5 = -1
        L4f:
            switch(r5) {
                case 0: goto L75;
                case 1: goto L75;
                case 2: goto L59;
                case 3: goto L56;
                case 4: goto L53;
                case 5: goto L53;
                default: goto L52;
            }
        L52:
            return r0
        L53:
            int r6 = r6 * r7
            goto L78
        L56:
            int r6 = r6 * r7
            goto L77
        L59:
            java.lang.String r5 = "BRAVIA 4K 2015"
            java.lang.String r1 = com.google.android.gms.internal.ads.bkg.d
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L64
            return r0
        L64:
            r5 = 16
            int r6 = com.google.android.gms.internal.ads.bkg.a(r6, r5)
            int r5 = com.google.android.gms.internal.ads.bkg.a(r7, r5)
            int r6 = r6 * r5
            int r5 = r6 << 4
            int r6 = r5 << 4
            goto L77
        L75:
            int r6 = r6 * r7
        L77:
            r3 = 2
        L78:
            int r6 = r6 * 3
            int r3 = r3 * 2
            int r6 = r6 / r3
            return r6
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bkq.a(java.lang.String, int, int):int");
    }

    private static boolean a(boolean z, bab babVar, bab babVar2) {
        if (!babVar.e.equals(babVar2.e) || d(babVar) != d(babVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return babVar.i == babVar2.i && babVar.j == babVar2.j;
    }

    private static int d(bab babVar) {
        if (babVar.l == -1) {
            return 0;
        }
        return babVar.l;
    }
}
