package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.github.steveice10.mc.v1_5.util.Constants;
import com.google.android.gms.internal.ads.bbt;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class bct implements bcc {

    /* renamed from: a, reason: collision with root package name */
    private static final bcg f2524a = new bcu();

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f2525b = {49, 10, 48, 48, Constants.MobIds.ENDERMAN, 48, 48, Constants.MobIds.ENDERMAN, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, Constants.MobIds.ENDERMAN, 48, 48, Constants.MobIds.ENDERMAN, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID d = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private bjt F;
    private bjt G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private byte W;
    private int X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private bcf ac;
    private final bcr e;
    private final bcy f;
    private final SparseArray<bcw> g;
    private final boolean h;
    private final bjz i;
    private final bjz j;
    private final bjz k;
    private final bjz l;
    private final bjz m;
    private final bjz n;
    private final bjz o;
    private final bjz p;
    private final bjz q;
    private ByteBuffer r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private bcw x;
    private boolean y;
    private int z;

    public bct() {
        this(0);
    }

    static int a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void c() {
    }

    public bct(int i) {
        this(new bco(), i);
    }

    private bct(bcr bcrVar, int i) {
        this.t = -1L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.e = bcrVar;
        this.e.a(new bcv(this, null));
        this.h = (i & 1) == 0;
        this.f = new bcy();
        this.g = new SparseArray<>();
        this.k = new bjz(4);
        this.l = new bjz(ByteBuffer.allocate(4).putInt(-1).array());
        this.m = new bjz(4);
        this.i = new bjz(bjw.f2746a);
        this.j = new bjz(4);
        this.n = new bjz();
        this.o = new bjz();
        this.p = new bjz(8);
        this.q = new bjz();
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final boolean a(bce bceVar) {
        return new bcx().a(bceVar);
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(bcf bcfVar) {
        this.ac = bcfVar;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(long j, long j2) {
        this.E = -9223372036854775807L;
        this.I = 0;
        this.e.a();
        this.f.a();
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.bcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(com.google.android.gms.internal.ads.bce r9, com.google.android.gms.internal.ads.bcj r10) {
        /*
            r8 = this;
            r0 = 0
            r8.aa = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3c
            boolean r3 = r8.aa
            if (r3 != 0) goto L3c
            com.google.android.gms.internal.ads.bcr r2 = r8.e
            boolean r2 = r2.a(r9)
            if (r2 == 0) goto L5
            long r3 = r9.b()
            boolean r5 = r8.B
            if (r5 == 0) goto L25
            r8.D = r3
            long r3 = r8.C
            r10.f2516a = r3
            r8.B = r0
        L23:
            r3 = 1
            goto L39
        L25:
            boolean r3 = r8.y
            if (r3 == 0) goto L38
            long r3 = r8.D
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L38
            long r3 = r8.D
            r10.f2516a = r3
            r8.D = r5
            goto L23
        L38:
            r3 = 0
        L39:
            if (r3 == 0) goto L5
            return r1
        L3c:
            if (r2 == 0) goto L3f
            return r0
        L3f:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bct.a(com.google.android.gms.internal.ads.bce, com.google.android.gms.internal.ads.bcj):int");
    }

    final void a(int i, long j, long j2) throws zzfx {
        if (i == 160) {
            this.ab = false;
            return;
        }
        if (i == 174) {
            this.x = new bcw(null);
            return;
        }
        if (i == 187) {
            this.H = false;
            return;
        }
        if (i == 19899) {
            this.z = -1;
            this.A = -1L;
            return;
        }
        if (i == 20533) {
            this.x.e = true;
            return;
        }
        if (i == 21968) {
            this.x.q = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                if (this.t != -1 && this.t != j) {
                    throw new zzfx("Multiple Segment elements not supported");
                }
                this.t = j;
                this.s = j2;
                return;
            }
            if (i == 475249515) {
                this.F = new bjt();
                this.G = new bjt();
            } else if (i == 524531317 && !this.y) {
                if (this.h && this.C != -1) {
                    this.B = true;
                } else {
                    this.ac.a(new bcl(this.w));
                    this.y = true;
                }
            }
        }
    }

    final void c(int i) throws zzfx {
        bck bclVar;
        int i2;
        if (i == 160) {
            if (this.I != 2) {
                return;
            }
            if (!this.ab) {
                this.Q |= 1;
            }
            a(this.g.get(this.O), this.J);
            this.I = 0;
            return;
        }
        if (i == 174) {
            String str = this.x.f2527a;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                this.x.a(this.ac, this.x.f2528b);
                this.g.put(this.x.f2528b, this.x);
            }
            this.x = null;
            return;
        }
        if (i == 19899) {
            if (this.z == -1 || this.A == -1) {
                throw new zzfx("Mandatory element SeekID or SeekPosition not found");
            }
            if (this.z == 475249515) {
                this.C = this.A;
                return;
            }
            return;
        }
        if (i == 25152) {
            if (this.x.e) {
                if (this.x.g == null) {
                    throw new zzfx("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.x.i = new bbt(new bbt.a(azo.f2425b, "video/webm", this.x.g.f2519b));
                return;
            }
            return;
        }
        if (i == 28032) {
            if (this.x.e && this.x.f != null) {
                throw new zzfx("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.u == -9223372036854775807L) {
                this.u = 1000000L;
            }
            if (this.v != -9223372036854775807L) {
                this.w = a(this.v);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i == 475249515 && !this.y) {
                bcf bcfVar = this.ac;
                if (this.t == -1 || this.w == -9223372036854775807L || this.F == null || this.F.a() == 0 || this.G == null || this.G.a() != this.F.a()) {
                    this.F = null;
                    this.G = null;
                    bclVar = new bcl(this.w);
                } else {
                    int iA = this.F.a();
                    int[] iArr = new int[iA];
                    long[] jArr = new long[iA];
                    long[] jArr2 = new long[iA];
                    long[] jArr3 = new long[iA];
                    for (int i3 = 0; i3 < iA; i3++) {
                        jArr3[i3] = this.F.a(i3);
                        jArr[i3] = this.t + this.G.a(i3);
                    }
                    while (true) {
                        i2 = iA - 1;
                        if (i >= i2) {
                            break;
                        }
                        int i4 = i + 1;
                        iArr[i] = (int) (jArr[i4] - jArr[i]);
                        jArr2[i] = jArr3[i4] - jArr3[i];
                        i = i4;
                    }
                    iArr[i2] = (int) ((this.t + this.s) - jArr[i2]);
                    jArr2[i2] = this.w - jArr3[i2];
                    this.F = null;
                    this.G = null;
                    bclVar = new bbz(iArr, jArr, jArr2, jArr3);
                }
                bcfVar.a(bclVar);
                this.y = true;
                return;
            }
            return;
        }
        if (this.g.size() == 0) {
            throw new zzfx("No valid tracks were found");
        }
        this.ac.a();
    }

    final void a(int i, long j) throws zzfx {
        switch (i) {
            case 131:
                this.x.c = (int) j;
                return;
            case 136:
                this.x.L = j == 1;
                return;
            case 155:
                this.K = a(j);
                return;
            case 159:
                this.x.G = (int) j;
                return;
            case 176:
                this.x.j = (int) j;
                return;
            case 179:
                this.F.a(a(j));
                return;
            case 186:
                this.x.k = (int) j;
                return;
            case 215:
                this.x.f2528b = (int) j;
                return;
            case 231:
                this.E = a(j);
                return;
            case 241:
                if (this.H) {
                    return;
                }
                this.G.a(j);
                this.H = true;
                return;
            case 251:
                this.ab = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb = new StringBuilder(50);
                sb.append("ContentCompAlgo ");
                sb.append(j);
                sb.append(" not supported");
                throw new zzfx(sb.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzfx(sb2.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("EBMLReadVersion ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzfx(sb3.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(49);
                sb4.append("ContentEncAlgo ");
                sb4.append(j);
                sb4.append(" not supported");
                throw new zzfx(sb4.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(56);
                sb5.append("AESSettingsCipherMode ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzfx(sb5.toString());
            case 20529:
                if (j == 0) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingOrder ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzfx(sb6.toString());
            case 20530:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(55);
                sb7.append("ContentEncodingScope ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzfx(sb7.toString());
            case 21420:
                this.A = j + this.t;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.x.p = 1;
                    return;
                }
                if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.x.p = 0;
                            return;
                        case 1:
                            this.x.p = 2;
                            return;
                        default:
                            return;
                    }
                }
                this.x.p = 3;
                return;
            case 21680:
                this.x.l = (int) j;
                return;
            case 21682:
                this.x.n = (int) j;
                return;
            case 21690:
                this.x.m = (int) j;
                return;
            case 21930:
                this.x.M = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.x.t = 2;
                        return;
                    case 2:
                        this.x.t = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.x.s = 6;
                        return;
                    } else if (i3 == 18) {
                        this.x.s = 7;
                        return;
                    } else {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    }
                }
                this.x.s = 3;
                return;
            case 21947:
                this.x.q = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    this.x.r = 1;
                    return;
                } else {
                    if (i4 != 9) {
                        switch (i4) {
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.x.r = 2;
                                return;
                            default:
                                return;
                        }
                    }
                    this.x.r = 6;
                    return;
                }
            case 21948:
                this.x.u = (int) j;
                return;
            case 21949:
                this.x.v = (int) j;
                return;
            case 22186:
                this.x.J = j;
                return;
            case 22203:
                this.x.K = j;
                return;
            case 25188:
                this.x.H = (int) j;
                return;
            case 2352003:
                this.x.d = (int) j;
                return;
            case 2807729:
                this.u = j;
                return;
            default:
                return;
        }
    }

    final void a(int i, double d2) {
        if (i == 181) {
            this.x.I = (int) d2;
            return;
        }
        if (i == 17545) {
            this.v = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.x.w = (float) d2;
                break;
            case 21970:
                this.x.x = (float) d2;
                break;
            case 21971:
                this.x.y = (float) d2;
                break;
            case 21972:
                this.x.z = (float) d2;
                break;
            case 21973:
                this.x.A = (float) d2;
                break;
            case 21974:
                this.x.B = (float) d2;
                break;
            case 21975:
                this.x.C = (float) d2;
                break;
            case 21976:
                this.x.D = (float) d2;
                break;
            case 21977:
                this.x.E = (float) d2;
                break;
            case 21978:
                this.x.F = (float) d2;
                break;
        }
    }

    final void a(int i, String str) throws zzfx {
        if (i == 134) {
            this.x.f2527a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.x.P = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzfx(sb.toString());
        }
    }

    final void a(int i, int i2, bce bceVar) throws zzfx {
        int i3;
        int i4 = 0;
        int i5 = 1;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                this.x.f = new byte[i2];
                bceVar.b(this.x.f, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr = new byte[i2];
                bceVar.b(bArr, 0, i2);
                this.x.g = new bcn(1, bArr);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.m.f2752a, (byte) 0);
                bceVar.b(this.m.f2752a, 4 - i2, i2);
                this.m.c(0);
                this.z = (int) this.m.j();
                return;
            }
            if (i == 25506) {
                this.x.h = new byte[i2];
                bceVar.b(this.x.h, 0, i2);
                return;
            } else if (i == 30322) {
                this.x.o = new byte[i2];
                bceVar.b(this.x.o, 0, i2);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i);
                throw new zzfx(sb.toString());
            }
        }
        if (this.I == 0) {
            this.O = (int) this.f.a(bceVar, false, true, 8);
            this.P = this.f.b();
            this.K = -9223372036854775807L;
            this.I = 1;
            this.k.a();
        }
        bcw bcwVar = this.g.get(this.O);
        if (bcwVar == null) {
            bceVar.b(i2 - this.P);
            this.I = 0;
            return;
        }
        if (this.I == 1) {
            a(bceVar, 3);
            int i6 = (this.k.f2752a[2] & 6) >> 1;
            byte b2 = Constants.DimensionIds.NETHER;
            if (i6 == 0) {
                this.M = 1;
                this.N = a(this.N, 1);
                this.N[0] = (i2 - this.P) - 3;
            } else {
                if (i != 163) {
                    throw new zzfx("Lacing only supported in SimpleBlocks.");
                }
                a(bceVar, 4);
                this.M = (this.k.f2752a[3] & Constants.DimensionIds.NETHER) + 1;
                this.N = a(this.N, this.M);
                if (i6 == 2) {
                    Arrays.fill(this.N, 0, this.M, ((i2 - this.P) - 4) / this.M);
                } else if (i6 == 1) {
                    int i7 = 4;
                    int i8 = 0;
                    for (int i9 = 0; i9 < this.M - 1; i9++) {
                        this.N[i9] = 0;
                        do {
                            i7++;
                            a(bceVar, i7);
                            i3 = this.k.f2752a[i7 - 1] & Constants.DimensionIds.NETHER;
                            int[] iArr = this.N;
                            iArr[i9] = iArr[i9] + i3;
                        } while (i3 == 255);
                        i8 += this.N[i9];
                    }
                    this.N[this.M - 1] = ((i2 - this.P) - i7) - i8;
                } else if (i6 == 3) {
                    int i10 = 0;
                    int i11 = 4;
                    int i12 = 0;
                    while (i10 < this.M - i5) {
                        this.N[i10] = i4;
                        i11++;
                        a(bceVar, i11);
                        int i13 = i11 - 1;
                        if (this.k.f2752a[i13] == 0) {
                            throw new zzfx("No valid varint length mask found");
                        }
                        long j = 0;
                        int i14 = 0;
                        while (true) {
                            if (i14 >= 8) {
                                break;
                            }
                            int i15 = i5 << (7 - i14);
                            if ((this.k.f2752a[i13] & i15) != 0) {
                                i11 += i14;
                                a(bceVar, i11);
                                long j2 = this.k.f2752a[i13] & b2 & (i15 ^ (-1));
                                int i16 = i13 + 1;
                                while (true) {
                                    j = j2;
                                    if (i16 >= i11) {
                                        break;
                                    }
                                    j2 = (j << 8) | (this.k.f2752a[i16] & b2);
                                    i16++;
                                    b2 = Constants.DimensionIds.NETHER;
                                }
                                if (i10 > 0) {
                                    j -= (1 << ((i14 * 7) + 6)) - 1;
                                }
                            } else {
                                i14++;
                                i5 = 1;
                                b2 = Constants.DimensionIds.NETHER;
                            }
                        }
                        long j3 = j;
                        if (j3 < -2147483648L || j3 > 2147483647L) {
                            throw new zzfx("EBML lacing sample size out of range.");
                        }
                        int i17 = (int) j3;
                        int[] iArr2 = this.N;
                        if (i10 != 0) {
                            i17 += this.N[i10 - 1];
                        }
                        iArr2[i10] = i17;
                        i12 += this.N[i10];
                        i10++;
                        i4 = 0;
                        i5 = 1;
                        b2 = Constants.DimensionIds.NETHER;
                    }
                    this.N[this.M - 1] = ((i2 - this.P) - i11) - i12;
                } else {
                    StringBuilder sb2 = new StringBuilder(36);
                    sb2.append("Unexpected lacing value: ");
                    sb2.append(i6);
                    throw new zzfx(sb2.toString());
                }
            }
            this.J = this.E + a((this.k.f2752a[0] << 8) | (this.k.f2752a[1] & Constants.DimensionIds.NETHER));
            this.Q = ((bcwVar.c == 2 || (i == 163 && (this.k.f2752a[2] & 128) == 128)) ? 1 : 0) | ((this.k.f2752a[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
            this.I = 2;
            this.L = 0;
        }
        if (i == 163) {
            while (this.L < this.M) {
                a(bceVar, bcwVar, this.N[this.L]);
                a(bcwVar, this.J + ((this.L * bcwVar.d) / 1000));
                this.L++;
            }
            this.I = 0;
            return;
        }
        a(bceVar, bcwVar, this.N[0]);
    }

    private final void a(bcw bcwVar, long j) {
        byte[] bArrC;
        if ("S_TEXT/UTF8".equals(bcwVar.f2527a)) {
            byte[] bArr = this.o.f2752a;
            long j2 = this.K;
            if (j2 == -9223372036854775807L) {
                bArrC = c;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                bArrC = bkg.c(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r5)) / 1000))));
            }
            System.arraycopy(bArrC, 0, bArr, 19, 12);
            bcwVar.N.a(this.o, this.o.c());
            this.Z += this.o.c();
        }
        bcwVar.N.a(j, this.Q, this.Z, 0, bcwVar.g);
        this.aa = true;
        b();
    }

    private final void b() {
        this.R = 0;
        this.Z = 0;
        this.Y = 0;
        this.S = false;
        this.T = false;
        this.V = false;
        this.X = 0;
        this.W = (byte) 0;
        this.U = false;
        this.n.a();
    }

    private final void a(bce bceVar, int i) {
        if (this.k.c() >= i) {
            return;
        }
        if (this.k.e() < i) {
            this.k.a(Arrays.copyOf(this.k.f2752a, Math.max(this.k.f2752a.length << 1, i)), this.k.c());
        }
        bceVar.b(this.k.f2752a, this.k.c(), i - this.k.c());
        this.k.b(i);
    }

    private final void a(bce bceVar, bcw bcwVar, int i) throws zzfx {
        if ("S_TEXT/UTF8".equals(bcwVar.f2527a)) {
            int length = f2525b.length + i;
            if (this.o.e() < length) {
                this.o.f2752a = Arrays.copyOf(f2525b, length + i);
            }
            bceVar.b(this.o.f2752a, f2525b.length, i);
            this.o.c(0);
            this.o.b(length);
            return;
        }
        bcm bcmVar = bcwVar.N;
        if (!this.S) {
            if (bcwVar.e) {
                this.Q &= -1073741825;
                if (!this.T) {
                    bceVar.b(this.k.f2752a, 0, 1);
                    this.R++;
                    if ((this.k.f2752a[0] & 128) == 128) {
                        throw new zzfx("Extension bit is set in signal byte");
                    }
                    this.W = this.k.f2752a[0];
                    this.T = true;
                }
                if ((this.W & 1) == 1) {
                    boolean z = (this.W & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.U) {
                        bceVar.b(this.p.f2752a, 0, 8);
                        this.R += 8;
                        this.U = true;
                        this.k.f2752a[0] = (byte) ((z ? 128 : 0) | 8);
                        this.k.c(0);
                        bcmVar.a(this.k, 1);
                        this.Z++;
                        this.p.c(0);
                        bcmVar.a(this.p, 8);
                        this.Z += 8;
                    }
                    if (z) {
                        if (!this.V) {
                            bceVar.b(this.k.f2752a, 0, 1);
                            this.R++;
                            this.k.c(0);
                            this.X = this.k.f();
                            this.V = true;
                        }
                        int i2 = this.X << 2;
                        this.k.a(i2);
                        bceVar.b(this.k.f2752a, 0, i2);
                        this.R += i2;
                        short s = (short) ((this.X / 2) + 1);
                        int i3 = (s * 6) + 2;
                        if (this.r == null || this.r.capacity() < i3) {
                            this.r = ByteBuffer.allocate(i3);
                        }
                        this.r.position(0);
                        this.r.putShort(s);
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < this.X) {
                            int iO = this.k.o();
                            if (i4 % 2 == 0) {
                                this.r.putShort((short) (iO - i5));
                            } else {
                                this.r.putInt(iO - i5);
                            }
                            i4++;
                            i5 = iO;
                        }
                        int i6 = (i - this.R) - i5;
                        if (this.X % 2 == 1) {
                            this.r.putInt(i6);
                        } else {
                            this.r.putShort((short) i6);
                            this.r.putInt(0);
                        }
                        this.q.a(this.r.array(), i3);
                        bcmVar.a(this.q, i3);
                        this.Z += i3;
                    }
                }
            } else if (bcwVar.f != null) {
                this.n.a(bcwVar.f, bcwVar.f.length);
            }
            this.S = true;
        }
        int iC = i + this.n.c();
        if ("V_MPEG4/ISO/AVC".equals(bcwVar.f2527a) || "V_MPEGH/ISO/HEVC".equals(bcwVar.f2527a)) {
            byte[] bArr = this.j.f2752a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i7 = bcwVar.O;
            int i8 = 4 - bcwVar.O;
            while (this.R < iC) {
                if (this.Y == 0) {
                    int iMin = Math.min(i7, this.n.b());
                    bceVar.b(bArr, i8 + iMin, i7 - iMin);
                    if (iMin > 0) {
                        this.n.a(bArr, i8, iMin);
                    }
                    this.R += i7;
                    this.j.c(0);
                    this.Y = this.j.o();
                    this.i.c(0);
                    bcmVar.a(this.i, 4);
                    this.Z += 4;
                } else {
                    this.Y -= a(bceVar, bcmVar, this.Y);
                }
            }
        } else {
            while (this.R < iC) {
                a(bceVar, bcmVar, iC - this.R);
            }
        }
        if ("A_VORBIS".equals(bcwVar.f2527a)) {
            this.l.c(0);
            bcmVar.a(this.l, 4);
            this.Z += 4;
        }
    }

    private final int a(bce bceVar, bcm bcmVar, int i) {
        int iA;
        int iB = this.n.b();
        if (iB > 0) {
            iA = Math.min(i, iB);
            bcmVar.a(this.n, iA);
        } else {
            iA = bcmVar.a(bceVar, i, false);
        }
        this.R += iA;
        this.Z += iA;
        return iA;
    }

    private final long a(long j) throws zzfx {
        if (this.u == -9223372036854775807L) {
            throw new zzfx("Can't scale timecode prior to timecodeScale being set.");
        }
        return bkg.a(j, this.u, 1000L);
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
