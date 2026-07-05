package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class c implements j {

    /* renamed from: a, reason: collision with root package name */
    final j f1074a;

    /* renamed from: b, reason: collision with root package name */
    int f1075b = 0;
    int c = -1;
    int d = -1;
    Object e = null;

    public c(j jVar) {
        this.f1074a = jVar;
    }

    public void a() {
        if (this.f1075b == 0) {
            return;
        }
        switch (this.f1075b) {
            case 1:
                this.f1074a.a(this.c, this.d);
                break;
            case 2:
                this.f1074a.b(this.c, this.d);
                break;
            case 3:
                this.f1074a.a(this.c, this.d, this.e);
                break;
        }
        this.e = null;
        this.f1075b = 0;
    }

    @Override // androidx.recyclerview.widget.j
    public void a(int i, int i2) {
        if (this.f1075b == 1 && i >= this.c && i <= this.c + this.d) {
            this.d += i2;
            this.c = Math.min(i, this.c);
        } else {
            a();
            this.c = i;
            this.d = i2;
            this.f1075b = 1;
        }
    }

    @Override // androidx.recyclerview.widget.j
    public void b(int i, int i2) {
        if (this.f1075b == 2 && this.c >= i && this.c <= i + i2) {
            this.d += i2;
            this.c = i;
        } else {
            a();
            this.c = i;
            this.d = i2;
            this.f1075b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.j
    public void c(int i, int i2) {
        a();
        this.f1074a.c(i, i2);
    }

    @Override // androidx.recyclerview.widget.j
    public void a(int i, int i2, Object obj) {
        int i3;
        if (this.f1075b == 3 && i <= this.c + this.d && (i3 = i + i2) >= this.c && this.e == obj) {
            int i4 = this.c + this.d;
            this.c = Math.min(i, this.c);
            this.d = Math.max(i4, i3) - this.c;
        } else {
            a();
            this.c = i;
            this.d = i2;
            this.e = obj;
            this.f1075b = 3;
        }
    }
}
