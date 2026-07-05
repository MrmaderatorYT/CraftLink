package b;

import javax.annotation.Nullable;

/* compiled from: Segment.java */
/* loaded from: classes.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f1187a;

    /* renamed from: b, reason: collision with root package name */
    int f1188b;
    int c;
    boolean d;
    boolean e;
    o f;
    o g;

    o() {
        this.f1187a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f1187a = bArr;
        this.f1188b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    o a() {
        this.d = true;
        return new o(this.f1187a, this.f1188b, this.c, true, false);
    }

    @Nullable
    public o b() {
        o oVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return oVar;
    }

    public o a(o oVar) {
        oVar.g = this;
        oVar.f = this.f;
        this.f.g = oVar;
        this.f = oVar;
        return oVar;
    }

    public o a(int i) {
        o oVarA;
        if (i <= 0 || i > this.c - this.f1188b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            oVarA = a();
        } else {
            oVarA = p.a();
            System.arraycopy(this.f1187a, this.f1188b, oVarA.f1187a, 0, i);
        }
        oVarA.c = oVarA.f1188b + i;
        this.f1188b += i;
        this.g.a(oVarA);
        return oVarA;
    }

    public void c() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.e) {
            int i = this.c - this.f1188b;
            if (i > (8192 - this.g.c) + (this.g.d ? 0 : this.g.f1188b)) {
                return;
            }
            a(this.g, i);
            b();
            p.a(this);
        }
    }

    public void a(o oVar, int i) {
        if (!oVar.e) {
            throw new IllegalArgumentException();
        }
        if (oVar.c + i > 8192) {
            if (oVar.d) {
                throw new IllegalArgumentException();
            }
            if ((oVar.c + i) - oVar.f1188b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f1187a, oVar.f1188b, oVar.f1187a, 0, oVar.c - oVar.f1188b);
            oVar.c -= oVar.f1188b;
            oVar.f1188b = 0;
        }
        System.arraycopy(this.f1187a, this.f1188b, oVar.f1187a, oVar.c, i);
        oVar.c += i;
        this.f1188b += i;
    }
}
