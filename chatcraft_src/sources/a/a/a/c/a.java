package a.a.a.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/* compiled from: Circle.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private a.a.a.d.a f6a;

    /* renamed from: b, reason: collision with root package name */
    private b f7b;
    private c c;
    private int d;
    private Point e = d();
    private int f;

    public a(a.a.a.d.a aVar, b bVar, c cVar, int i) {
        this.f6a = aVar;
        this.f7b = bVar;
        this.c = cVar;
        this.f = i;
        a(i);
    }

    public void a(Canvas canvas, Paint paint, int i) {
        a(i);
        this.e = d();
        canvas.drawCircle(this.e.x, this.e.y, this.d, paint);
    }

    private Point d() {
        if (this.c == c.LEFT) {
            return new Point(this.f6a.b().left + ((this.f6a.a().x - this.f6a.b().left) / 2), this.f6a.a().y);
        }
        if (this.c == c.RIGHT) {
            return new Point(this.f6a.a().x + ((this.f6a.b().right - this.f6a.a().x) / 2), this.f6a.a().y);
        }
        return this.f6a.a();
    }

    public void a() {
        a(this.f);
        this.e = d();
    }

    private void a(int i) {
        int iMin;
        if (this.f7b == b.MINIMUM) {
            iMin = Math.min(this.f6a.b().width() / 2, this.f6a.b().height() / 2);
        } else if (this.f7b == b.ALL) {
            iMin = Math.max(this.f6a.b().width() / 2, this.f6a.b().height() / 2);
        } else {
            iMin = (Math.min(this.f6a.b().width() / 2, this.f6a.b().height() / 2) + Math.max(this.f6a.b().width() / 2, this.f6a.b().height() / 2)) / 2;
        }
        this.d = iMin + i;
    }

    public int b() {
        return this.d;
    }

    public Point c() {
        return this.e;
    }
}
