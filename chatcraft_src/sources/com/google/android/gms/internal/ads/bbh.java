package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes.dex */
public final class bbh extends bed implements bju {

    /* renamed from: b, reason: collision with root package name */
    private final bar f2489b;
    private final bay c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private long i;
    private boolean j;

    public bbh(bef befVar) {
        this(befVar, null, true);
    }

    protected static void a(int i, long j, long j2) {
    }

    protected static void b(int i) {
    }

    protected static void v() {
    }

    @Override // com.google.android.gms.internal.ads.azn, com.google.android.gms.internal.ads.bag
    public final bju c() {
        return this;
    }

    private bbh(bef befVar, bbx<Object> bbxVar, boolean z) {
        this(befVar, null, true, null, null);
    }

    private bbh(bef befVar, bbx<Object> bbxVar, boolean z, Handler handler, baq baqVar) {
        this(befVar, null, true, null, null, null, new bap[0]);
    }

    private bbh(bef befVar, bbx<Object> bbxVar, boolean z, Handler handler, baq baqVar, bao baoVar, bap... bapVarArr) {
        super(1, befVar, bbxVar, z);
        this.c = new bay(null, bapVarArr, new bbj(this));
        this.f2489b = new bar(null, null);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final int a(bef befVar, bab babVar) {
        String str = babVar.e;
        if (!bjv.a(str)) {
            return 0;
        }
        int i = bkg.f2760a >= 21 ? 16 : 0;
        if (a(str) && befVar.a() != null) {
            return i | 4 | 3;
        }
        bec becVarA = befVar.a(str, false);
        boolean z = true;
        if (becVarA == null) {
            return 1;
        }
        if (bkg.f2760a >= 21 && ((babVar.o != -1 && !becVarA.a(babVar.o)) || (babVar.n != -1 && !becVarA.b(babVar.n)))) {
            z = false;
        }
        return i | 4 | (z ? 3 : 2);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final bec a(bef befVar, bab babVar, boolean z) {
        bec becVarA;
        if (a(babVar.e) && (becVarA = befVar.a()) != null) {
            this.d = true;
            return becVarA;
        }
        this.d = false;
        return super.a(befVar, babVar, z);
    }

    private final boolean a(String str) {
        return this.c.a(str);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(bec becVar, MediaCodec mediaCodec, bab babVar, MediaCrypto mediaCrypto) {
        this.e = bkg.f2760a < 24 && "OMX.SEC.aac.dec".equals(becVar.f2575a) && "samsung".equals(bkg.c) && (bkg.f2761b.startsWith("zeroflte") || bkg.f2761b.startsWith("herolte") || bkg.f2761b.startsWith("heroqlte"));
        if (this.d) {
            this.f = babVar.b();
            this.f.setString("mime", "audio/raw");
            mediaCodec.configure(this.f, (Surface) null, (MediaCrypto) null, 0);
            this.f.setString("mime", babVar.e);
            return;
        }
        mediaCodec.configure(babVar.b(), (Surface) null, (MediaCrypto) null, 0);
        this.f = null;
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(String str, long j, long j2) {
        this.f2489b.a(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void b(bab babVar) {
        super.b(babVar);
        this.f2489b.a(babVar);
        this.g = "audio/raw".equals(babVar.e) ? babVar.p : 2;
        this.h = babVar.n;
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws IllegalStateException, zzff {
        int[] iArr;
        boolean z = this.f != null;
        String string = z ? this.f.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.f;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.e && integer == 6 && this.h < 6) {
            iArr = new int[this.h];
            for (int i = 0; i < this.h; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.c.a(string, integer, integer2, this.g, 0, iArr);
        } catch (zzgw e) {
            throw zzff.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void a(boolean z) throws IllegalStateException {
        super.a(z);
        this.f2489b.a(this.f2578a);
        int i = q().f2448b;
        if (i != 0) {
            this.c.b(i);
        } else {
            this.c.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void a(long j, boolean z) throws IllegalStateException {
        super.a(j, z);
        this.c.i();
        this.i = j;
        this.j = true;
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void n() throws IllegalStateException {
        super.n();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void o() {
        this.c.h();
        super.o();
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.azn
    protected final void p() {
        try {
            this.c.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.bag
    public final boolean u() {
        return super.u() && this.c.d();
    }

    @Override // com.google.android.gms.internal.ads.bed, com.google.android.gms.internal.ads.bag
    public final boolean t() {
        return this.c.e() || super.t();
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final long w() {
        long jA = this.c.a(u());
        if (jA != Long.MIN_VALUE) {
            if (!this.j) {
                jA = Math.max(this.i, jA);
            }
            this.i = jA;
            this.j = false;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final baf a(baf bafVar) {
        return this.c.a(bafVar);
    }

    @Override // com.google.android.gms.internal.ads.bju
    public final baf x() {
        return this.c.f();
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzff {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.f2578a.e++;
            this.c.b();
            return true;
        }
        try {
            if (!this.c.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.f2578a.d++;
            return true;
        } catch (zzgx | zzha e) {
            throw zzff.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.bed
    protected final void y() throws zzff {
        try {
            this.c.c();
        } catch (zzha e) {
            throw zzff.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.azn, com.google.android.gms.internal.ads.azr
    public final void a(int i, Object obj) throws IllegalStateException {
        switch (i) {
            case 2:
                this.c.a(((Float) obj).floatValue());
                break;
            case 3:
                this.c.a(((Integer) obj).intValue());
                break;
            default:
                super.a(i, obj);
                break;
        }
    }

    static /* synthetic */ boolean a(bbh bbhVar, boolean z) {
        bbhVar.j = true;
        return true;
    }
}
