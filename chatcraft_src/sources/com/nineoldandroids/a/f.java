package com.nineoldandroids.a;

import android.view.animation.Interpolator;
import com.nineoldandroids.a.e;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: KeyframeSet.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    int f4070a;

    /* renamed from: b, reason: collision with root package name */
    e f4071b;
    e c;
    Interpolator d;
    ArrayList<e> e = new ArrayList<>();
    j f;

    public f(e... eVarArr) {
        this.f4070a = eVarArr.length;
        this.e.addAll(Arrays.asList(eVarArr));
        this.f4071b = this.e.get(0);
        this.c = this.e.get(this.f4070a - 1);
        this.d = this.c.d();
    }

    public static f a(int... iArr) {
        int length = iArr.length;
        e.a[] aVarArr = new e.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (e.a) e.a(0.0f);
            aVarArr[1] = (e.a) e.a(1.0f, iArr[0]);
        } else {
            aVarArr[0] = (e.a) e.a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                aVarArr[i] = (e.a) e.a(i / (length - 1), iArr[i]);
            }
        }
        return new d(aVarArr);
    }

    public void a(j jVar) {
        this.f = jVar;
    }

    @Override // 
    /* renamed from: b */
    public f clone() {
        ArrayList<e> arrayList = this.e;
        int size = this.e.size();
        e[] eVarArr = new e[size];
        for (int i = 0; i < size; i++) {
            eVarArr[i] = arrayList.get(i).e();
        }
        return new f(eVarArr);
    }

    public Object a(float f) {
        if (this.f4070a == 2) {
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            return this.f.a(f, this.f4071b.b(), this.c.b());
        }
        int i = 1;
        if (f <= 0.0f) {
            e eVar = this.e.get(1);
            Interpolator interpolatorD = eVar.d();
            if (interpolatorD != null) {
                f = interpolatorD.getInterpolation(f);
            }
            float fC = this.f4071b.c();
            return this.f.a((f - fC) / (eVar.c() - fC), this.f4071b.b(), eVar.b());
        }
        if (f >= 1.0f) {
            e eVar2 = this.e.get(this.f4070a - 2);
            Interpolator interpolatorD2 = this.c.d();
            if (interpolatorD2 != null) {
                f = interpolatorD2.getInterpolation(f);
            }
            float fC2 = eVar2.c();
            return this.f.a((f - fC2) / (this.c.c() - fC2), eVar2.b(), this.c.b());
        }
        e eVar3 = this.f4071b;
        while (i < this.f4070a) {
            e eVar4 = this.e.get(i);
            if (f < eVar4.c()) {
                Interpolator interpolatorD3 = eVar4.d();
                if (interpolatorD3 != null) {
                    f = interpolatorD3.getInterpolation(f);
                }
                float fC3 = eVar3.c();
                return this.f.a((f - fC3) / (eVar4.c() - fC3), eVar3.b(), eVar4.b());
            }
            i++;
            eVar3 = eVar4;
        }
        return this.c.b();
    }

    public String toString() {
        String str = " ";
        for (int i = 0; i < this.f4070a; i++) {
            str = str + this.e.get(i).b() + "  ";
        }
        return str;
    }
}
