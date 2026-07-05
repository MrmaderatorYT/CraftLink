package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class ak {

    /* renamed from: a, reason: collision with root package name */
    private int f348a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f349b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    ak() {
    }

    public int a() {
        return this.f348a;
    }

    public int b() {
        return this.f349b;
    }

    public int c() {
        return this.g ? this.f349b : this.f348a;
    }

    public int d() {
        return this.g ? this.f348a : this.f349b;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f348a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f349b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f348a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f349b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f348a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f349b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f348a = this.e;
            this.f349b = this.f;
        } else if (z) {
            this.f348a = this.d != Integer.MIN_VALUE ? this.d : this.e;
            this.f349b = this.c != Integer.MIN_VALUE ? this.c : this.f;
        } else {
            this.f348a = this.c != Integer.MIN_VALUE ? this.c : this.e;
            this.f349b = this.d != Integer.MIN_VALUE ? this.d : this.f;
        }
    }
}
