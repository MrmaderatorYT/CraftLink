package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
class bcz {
    public final int aO;

    /* renamed from: a, reason: collision with root package name */
    public static final int f2533a = bkg.f("ftyp");

    /* renamed from: b, reason: collision with root package name */
    public static final int f2534b = bkg.f("avc1");
    public static final int c = bkg.f("avc3");
    public static final int d = bkg.f("hvc1");
    public static final int e = bkg.f("hev1");
    public static final int f = bkg.f("s263");
    public static final int g = bkg.f("d263");
    public static final int h = bkg.f("mdat");
    public static final int i = bkg.f("mp4a");
    public static final int j = bkg.f(".mp3");
    public static final int k = bkg.f("wave");
    public static final int l = bkg.f("lpcm");
    public static final int m = bkg.f("sowt");
    public static final int n = bkg.f("ac-3");
    public static final int o = bkg.f("dac3");
    public static final int p = bkg.f("ec-3");
    public static final int q = bkg.f("dec3");
    public static final int r = bkg.f("dtsc");
    public static final int s = bkg.f("dtsh");
    public static final int t = bkg.f("dtsl");
    public static final int u = bkg.f("dtse");
    public static final int v = bkg.f("ddts");
    public static final int w = bkg.f("tfdt");
    public static final int x = bkg.f("tfhd");
    public static final int y = bkg.f("trex");
    public static final int z = bkg.f("trun");
    public static final int A = bkg.f("sidx");
    public static final int B = bkg.f("moov");
    public static final int C = bkg.f("mvhd");
    public static final int D = bkg.f("trak");
    public static final int E = bkg.f("mdia");
    public static final int F = bkg.f("minf");
    public static final int G = bkg.f("stbl");
    public static final int H = bkg.f("avcC");
    public static final int I = bkg.f("hvcC");
    public static final int J = bkg.f("esds");
    public static final int K = bkg.f("moof");
    public static final int L = bkg.f("traf");
    public static final int M = bkg.f("mvex");
    public static final int N = bkg.f("mehd");
    public static final int O = bkg.f("tkhd");
    public static final int P = bkg.f("edts");
    public static final int Q = bkg.f("elst");
    public static final int R = bkg.f("mdhd");
    public static final int S = bkg.f("hdlr");
    public static final int T = bkg.f("stsd");
    public static final int U = bkg.f("pssh");
    public static final int V = bkg.f("sinf");
    public static final int W = bkg.f("schm");
    public static final int X = bkg.f("schi");
    public static final int Y = bkg.f("tenc");
    public static final int Z = bkg.f("encv");
    public static final int aa = bkg.f("enca");
    public static final int ab = bkg.f("frma");
    public static final int ac = bkg.f("saiz");
    public static final int ad = bkg.f("saio");
    public static final int ae = bkg.f("sbgp");
    public static final int af = bkg.f("sgpd");
    public static final int ag = bkg.f("uuid");
    public static final int ah = bkg.f("senc");
    public static final int ai = bkg.f("pasp");
    public static final int aj = bkg.f("TTML");
    private static final int aP = bkg.f("vmhd");
    public static final int ak = bkg.f("mp4v");
    public static final int al = bkg.f("stts");
    public static final int am = bkg.f("stss");
    public static final int an = bkg.f("ctts");
    public static final int ao = bkg.f("stsc");
    public static final int ap = bkg.f("stsz");
    public static final int aq = bkg.f("stz2");
    public static final int ar = bkg.f("stco");
    public static final int as = bkg.f("co64");
    public static final int at = bkg.f("tx3g");
    public static final int au = bkg.f("wvtt");
    public static final int av = bkg.f("stpp");
    public static final int aw = bkg.f("c608");
    public static final int ax = bkg.f("samr");
    public static final int ay = bkg.f("sawb");
    public static final int az = bkg.f("udta");
    public static final int aA = bkg.f("meta");
    public static final int aB = bkg.f("ilst");
    public static final int aC = bkg.f("mean");
    public static final int aD = bkg.f("name");
    public static final int aE = bkg.f("data");
    public static final int aF = bkg.f("emsg");
    public static final int aG = bkg.f("st3d");
    public static final int aH = bkg.f("sv3d");
    public static final int aI = bkg.f("proj");
    public static final int aJ = bkg.f("vp08");
    public static final int aK = bkg.f("vp09");
    public static final int aL = bkg.f("vpcC");
    public static final int aM = bkg.f("camm");
    public static final int aN = bkg.f("alac");

    public bcz(int i2) {
        this.aO = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public String toString() {
        return c(this.aO);
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >>> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }
}
