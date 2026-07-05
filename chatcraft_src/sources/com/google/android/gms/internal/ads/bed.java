package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes.dex */
public abstract class bed extends azn {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f2577b = bkg.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;

    /* renamed from: a, reason: collision with root package name */
    protected bbr f2578a;
    private final bef c;
    private final bbx<Object> d;
    private final boolean e;
    private final bbs f;
    private final bbs g;
    private final bad h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private bab k;
    private bbw<Object> l;
    private bbw<Object> m;
    private MediaCodec n;
    private bec o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    public bed(int i, bef befVar, bbx<Object> bbxVar, boolean z) {
        super(i);
        bjq.b(bkg.f2760a >= 16);
        this.c = (bef) bjq.a(befVar);
        this.d = bbxVar;
        this.e = z;
        this.f = new bbs(0);
        this.g = new bbs(0);
        this.h = new bad();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.F = 0;
        this.G = 0;
    }

    protected abstract int a(bef befVar, bab babVar);

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(bbs bbsVar) {
    }

    protected abstract void a(bec becVar, MediaCodec mediaCodec, bab babVar, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, bab babVar, bab babVar2) {
        return false;
    }

    protected boolean a(bec becVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.azn, com.google.android.gms.internal.ads.bah
    public final int m() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected void n() {
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected void o() {
    }

    protected void y() {
    }

    @Override // com.google.android.gms.internal.ads.bah
    public final int a(bab babVar) throws zzff {
        try {
            return a(this.c, babVar);
        } catch (zzke e) {
            throw zzff.a(e, r());
        }
    }

    protected bec a(bef befVar, bab babVar, boolean z) {
        return befVar.a(babVar.e, z);
    }

    protected final void z() throws zzff {
        if (this.n != null || this.k == null) {
            return;
        }
        this.l = this.m;
        String str = this.k.e;
        if (this.l != null) {
            int iA = this.l.a();
            if (iA == 0) {
                throw zzff.a(this.l.c(), r());
            }
            if (iA == 3 || iA == 4) {
                this.l.b();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.o == null) {
            try {
                this.o = a(this.c, this.k, false);
            } catch (zzke e) {
                a(new zzjz(this.k, (Throwable) e, false, -49998));
            }
            if (this.o == null) {
                a(new zzjz(this.k, (Throwable) null, false, -49999));
            }
        }
        if (a(this.o)) {
            String str2 = this.o.f2575a;
            this.p = bkg.f2760a < 21 && this.k.g.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.q = bkg.f2760a < 18 || (bkg.f2760a == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (bkg.f2760a == 19 && bkg.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.r = bkg.f2760a < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(bkg.f2761b) || "flounder_lte".equals(bkg.f2761b) || "grouper".equals(bkg.f2761b) || "tilapia".equals(bkg.f2761b));
            this.s = bkg.f2760a <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.t = (bkg.f2760a <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (bkg.f2760a <= 19 && "hb2000".equals(bkg.f2761b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.u = bkg.f2760a == 21 && "OMX.google.aac.decoder".equals(str2);
            this.v = bkg.f2760a <= 18 && this.k.n == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strValueOf = String.valueOf(str2);
                bke.a(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                this.n = MediaCodec.createByCodecName(str2);
                bke.a();
                bke.a("configureCodec");
                a(this.o, this.n, this.k, (MediaCrypto) null);
                bke.a();
                bke.a("startCodec");
                this.n.start();
                bke.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                this.y = this.n.getInputBuffers();
                this.z = this.n.getOutputBuffers();
            } catch (Exception e2) {
                a(new zzjz(this.k, (Throwable) e2, false, str2));
            }
            this.A = d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.f2578a.f2500a++;
        }
    }

    private final void a(zzjz zzjzVar) throws zzff {
        throw zzff.a(zzjzVar, r());
    }

    protected final MediaCodec A() {
        return this.n;
    }

    protected final bec B() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected void a(boolean z) {
        this.f2578a = new bbr();
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected void a(long j, boolean z) {
        this.J = false;
        this.K = false;
        if (this.n != null) {
            this.A = -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.L = false;
            this.D = false;
            this.i.clear();
            this.w = false;
            this.x = false;
            if (this.q || ((this.t && this.I) || this.G != 0)) {
                C();
                z();
            } else {
                this.n.flush();
                this.H = false;
            }
            if (!this.E || this.k == null) {
                return;
            }
            this.F = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.azn
    protected void p() {
        this.k = null;
        try {
            C();
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void C() {
        this.A = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.L = false;
        this.D = false;
        this.i.clear();
        this.y = null;
        this.z = null;
        this.o = null;
        this.E = false;
        this.H = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.I = false;
        this.F = 0;
        this.G = 0;
        this.f.f2503b = null;
        if (this.n != null) {
            this.f2578a.f2501b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                    this.n = null;
                    if (this.l == null || this.m == this.l) {
                        return;
                    }
                    try {
                        this.d.a(this.l);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bag
    public final void a(long j, long j2) throws zzff {
        if (this.K) {
            y();
            return;
        }
        if (this.k == null) {
            this.g.a();
            int iA = a(this.h, this.g, true);
            if (iA != -5) {
                if (iA == -4) {
                    bjq.b(this.g.c());
                    this.J = true;
                    w();
                    return;
                }
                return;
            }
            b(this.h.f2444a);
        }
        z();
        if (this.n != null) {
            bke.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (v()) {
            }
            bke.a();
        } else {
            b(j);
            this.g.a();
            int iA2 = a(this.h, this.g, false);
            if (iA2 == -5) {
                b(this.h.f2444a);
            } else if (iA2 == -4) {
                bjq.b(this.g.c());
                this.J = true;
                w();
            }
        }
        this.f2578a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean v() throws com.google.android.gms.internal.ads.zzff, android.media.MediaCodec.CryptoException {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bed.v():boolean");
    }

    protected void b(bab babVar) {
        bab babVar2 = this.k;
        this.k = babVar;
        if (!bkg.a(this.k.h, babVar2 == null ? null : babVar2.h)) {
            if (this.k.h != null) {
                if (this.d == null) {
                    throw zzff.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
                }
                this.m = this.d.a(Looper.myLooper(), this.k.h);
                if (this.m == this.l) {
                    this.d.a(this.m);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m == this.l && this.n != null && a(this.n, this.o.f2576b, babVar2, this.k)) {
            this.E = true;
            this.F = 1;
            this.w = this.r && this.k.i == babVar2.i && this.k.j == babVar2.j;
        } else if (this.H) {
            this.G = 1;
        } else {
            C();
            z();
        }
    }

    @Override // com.google.android.gms.internal.ads.bag
    public boolean u() {
        return this.K;
    }

    @Override // com.google.android.gms.internal.ads.bag
    public boolean t() {
        if (this.k == null || this.L) {
            return false;
        }
        if (s() || this.C >= 0) {
            return true;
        }
        return this.A != -9223372036854775807L && SystemClock.elapsedRealtime() < this.A;
    }

    private final boolean b(long j, long j2) throws zzff {
        boolean zA;
        boolean z;
        if (this.C < 0) {
            if (this.u && this.I) {
                try {
                    this.C = this.n.dequeueOutputBuffer(this.j, 0L);
                } catch (IllegalStateException unused) {
                    w();
                    if (this.K) {
                        C();
                    }
                    return false;
                }
            } else {
                this.C = this.n.dequeueOutputBuffer(this.j, 0L);
            }
            if (this.C >= 0) {
                if (this.x) {
                    this.x = false;
                    this.n.releaseOutputBuffer(this.C, false);
                    this.C = -1;
                    return true;
                }
                if ((this.j.flags & 4) != 0) {
                    w();
                    this.C = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.z[this.C];
                if (byteBuffer != null) {
                    byteBuffer.position(this.j.offset);
                    byteBuffer.limit(this.j.offset + this.j.size);
                }
                long j3 = this.j.presentationTimeUs;
                int size = this.i.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    if (this.i.get(i).longValue() == j3) {
                        this.i.remove(i);
                        z = true;
                        break;
                    }
                    i++;
                }
                this.D = z;
            } else {
                if (this.C == -2) {
                    MediaFormat outputFormat = this.n.getOutputFormat();
                    if (this.r && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.x = true;
                    } else {
                        if (this.v) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        a(this.n, outputFormat);
                    }
                    return true;
                }
                if (this.C == -3) {
                    this.z = this.n.getOutputBuffers();
                    return true;
                }
                if (this.s && (this.J || this.G == 2)) {
                    w();
                }
                return false;
            }
        }
        if (this.u && this.I) {
            try {
                zA = a(j, j2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
            } catch (IllegalStateException unused2) {
                w();
                if (this.K) {
                    C();
                }
                return false;
            }
        } else {
            zA = a(j, j2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
        }
        if (!zA) {
            return false;
        }
        long j4 = this.j.presentationTimeUs;
        this.C = -1;
        return true;
    }

    private final void w() throws zzff {
        if (this.G == 2) {
            C();
            z();
        } else {
            this.K = true;
            y();
        }
    }
}
