package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.bem;

/* loaded from: classes.dex */
final class bdr {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2558a = bkg.f("nam");

    /* renamed from: b, reason: collision with root package name */
    private static final int f2559b = bkg.f("trk");
    private static final int c = bkg.f("cmt");
    private static final int d = bkg.f("day");
    private static final int e = bkg.f("ART");
    private static final int f = bkg.f("too");
    private static final int g = bkg.f("alb");
    private static final int h = bkg.f("com");
    private static final int i = bkg.f("wrt");
    private static final int j = bkg.f("lyr");
    private static final int k = bkg.f("gen");
    private static final int l = bkg.f("covr");
    private static final int m = bkg.f("gnre");
    private static final int n = bkg.f("grp");
    private static final int o = bkg.f("disk");
    private static final int p = bkg.f("trkn");
    private static final int q = bkg.f("tmpo");
    private static final int r = bkg.f("cpil");
    private static final int s = bkg.f("aART");
    private static final int t = bkg.f("sonm");
    private static final int u = bkg.f("soal");
    private static final int v = bkg.f("soar");
    private static final int w = bkg.f("soaa");
    private static final int x = bkg.f("soco");
    private static final int y = bkg.f("rtng");
    private static final int z = bkg.f("pgap");
    private static final int A = bkg.f("sosn");
    private static final int B = bkg.f("tvsh");
    private static final int C = bkg.f("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static bem.a a(bjz bjzVar) {
        beu beuVar;
        int iD = bjzVar.d() + bjzVar.l();
        int iL = bjzVar.l();
        int i2 = iL >>> 24;
        bet beqVar = null;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & iL;
                if (i3 == c) {
                    int iL2 = bjzVar.l();
                    if (bjzVar.l() == bcz.aE) {
                        bjzVar.d(8);
                        String strE = bjzVar.e(iL2 - 16);
                        beqVar = new beq("und", strE, strE);
                    } else {
                        String strValueOf = String.valueOf(bcz.c(iL));
                        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(strValueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return beqVar;
                }
                if (i3 != f2558a && i3 != f2559b) {
                    if (i3 != h && i3 != i) {
                        if (i3 == d) {
                            return a(iL, "TDRC", bjzVar);
                        }
                        if (i3 == e) {
                            return a(iL, "TPE1", bjzVar);
                        }
                        if (i3 == f) {
                            return a(iL, "TSSE", bjzVar);
                        }
                        if (i3 == g) {
                            return a(iL, "TALB", bjzVar);
                        }
                        if (i3 == j) {
                            return a(iL, "USLT", bjzVar);
                        }
                        if (i3 == k) {
                            return a(iL, "TCON", bjzVar);
                        }
                        if (i3 == n) {
                            return a(iL, "TIT1", bjzVar);
                        }
                    }
                    return a(iL, "TCOM", bjzVar);
                }
                return a(iL, "TIT2", bjzVar);
            }
            if (iL == m) {
                int iB = b(bjzVar);
                String str = (iB <= 0 || iB > D.length) ? null : D[iB - 1];
                if (str != null) {
                    beuVar = new beu("TCON", null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    beuVar = null;
                }
                return beuVar;
            }
            if (iL == o) {
                return b(iL, "TPOS", bjzVar);
            }
            if (iL == p) {
                return b(iL, "TRCK", bjzVar);
            }
            if (iL == q) {
                return a(iL, "TBPM", bjzVar, true, false);
            }
            if (iL == r) {
                return a(iL, "TCMP", bjzVar, true, true);
            }
            if (iL == l) {
                int iL3 = bjzVar.l();
                if (bjzVar.l() == bcz.aE) {
                    int iB2 = bcz.b(bjzVar.l());
                    String str2 = iB2 == 13 ? "image/jpeg" : iB2 == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(iB2);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        bjzVar.d(4);
                        byte[] bArr = new byte[iL3 - 16];
                        bjzVar.a(bArr, 0, bArr.length);
                        beqVar = new beo(str2, null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                return beqVar;
            }
            if (iL == s) {
                return a(iL, "TPE2", bjzVar);
            }
            if (iL == t) {
                return a(iL, "TSOT", bjzVar);
            }
            if (iL == u) {
                return a(iL, "TSO2", bjzVar);
            }
            if (iL == v) {
                return a(iL, "TSOA", bjzVar);
            }
            if (iL == w) {
                return a(iL, "TSOP", bjzVar);
            }
            if (iL == x) {
                return a(iL, "TSOC", bjzVar);
            }
            if (iL == y) {
                return a(iL, "ITUNESADVISORY", bjzVar, false, false);
            }
            if (iL == z) {
                return a(iL, "ITUNESGAPLESS", bjzVar, false, true);
            }
            if (iL == A) {
                return a(iL, "TVSHOWSORT", bjzVar);
            }
            if (iL == B) {
                return a(iL, "TVSHOW", bjzVar);
            }
            if (iL == C) {
                String strE2 = null;
                String strE3 = null;
                int i4 = -1;
                int i5 = -1;
                while (bjzVar.d() < iD) {
                    int iD2 = bjzVar.d();
                    int iL4 = bjzVar.l();
                    int iL5 = bjzVar.l();
                    bjzVar.d(4);
                    if (iL5 == bcz.aC) {
                        strE2 = bjzVar.e(iL4 - 12);
                    } else if (iL5 == bcz.aD) {
                        strE3 = bjzVar.e(iL4 - 12);
                    } else {
                        if (iL5 == bcz.aE) {
                            i4 = iD2;
                            i5 = iL4;
                        }
                        bjzVar.d(iL4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(strE2) && "iTunSMPB".equals(strE3) && i4 != -1) {
                    bjzVar.c(i4);
                    bjzVar.d(16);
                    beqVar = new beq("und", strE3, bjzVar.e(i5 - 16));
                }
                return beqVar;
            }
            String strValueOf2 = String.valueOf(bcz.c(iL));
            Log.d("MetadataUtil", strValueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(strValueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            bjzVar.c(iD);
        }
    }

    private static beu a(int i2, String str, bjz bjzVar) {
        int iL = bjzVar.l();
        if (bjzVar.l() == bcz.aE) {
            bjzVar.d(8);
            return new beu(str, null, bjzVar.e(iL - 16));
        }
        String strValueOf = String.valueOf(bcz.c(i2));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse text attribute: ".concat(strValueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static bet a(int i2, String str, bjz bjzVar, boolean z2, boolean z3) {
        int iB = b(bjzVar);
        if (z3) {
            iB = Math.min(1, iB);
        }
        if (iB >= 0) {
            if (z2) {
                return new beu(str, null, Integer.toString(iB));
            }
            return new beq("und", str, Integer.toString(iB));
        }
        String strValueOf = String.valueOf(bcz.c(i2));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(strValueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static beu b(int i2, String str, bjz bjzVar) {
        int iL = bjzVar.l();
        if (bjzVar.l() == bcz.aE && iL >= 22) {
            bjzVar.d(10);
            int iG = bjzVar.g();
            if (iG > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(iG);
                String string = sb.toString();
                int iG2 = bjzVar.g();
                if (iG2 > 0) {
                    String strValueOf = String.valueOf(string);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 12);
                    sb2.append(strValueOf);
                    sb2.append("/");
                    sb2.append(iG2);
                    string = sb2.toString();
                }
                return new beu(str, null, string);
            }
        }
        String strValueOf2 = String.valueOf(bcz.c(i2));
        Log.w("MetadataUtil", strValueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(strValueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int b(bjz bjzVar) {
        bjzVar.d(4);
        if (bjzVar.l() == bcz.aE) {
            bjzVar.d(8);
            return bjzVar.f();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
