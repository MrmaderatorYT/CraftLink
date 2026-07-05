package com.nineoldandroids.a;

import android.view.animation.Interpolator;
import com.nineoldandroids.a.e;
import java.util.ArrayList;

/* compiled from: IntKeyframeSet.java */
/* loaded from: classes.dex */
class d extends f {
    private int g;
    private int h;
    private int i;
    private boolean j;

    public d(e.a... aVarArr) {
        super(aVarArr);
        this.j = true;
    }

    @Override // com.nineoldandroids.a.f
    public Object a(float f) {
        return Integer.valueOf(b(f));
    }

    @Override // com.nineoldandroids.a.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public d clone() {
        ArrayList<e> arrayList = this.e;
        int size = this.e.size();
        e.a[] aVarArr = new e.a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = (e.a) arrayList.get(i).e();
        }
        return new d(aVarArr);
    }

    public int b(float f) {
        if (this.f4070a == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((e.a) this.e.get(0)).f();
                this.h = ((e.a) this.e.get(1)).f();
                this.i = this.h - this.g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            if (this.f == null) {
                return this.g + ((int) (f * this.i));
            }
            return ((Number) this.f.a(f, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
        }
        if (f <= 0.0f) {
            e.a aVar = (e.a) this.e.get(0);
            e.a aVar2 = (e.a) this.e.get(1);
            int iF = aVar.f();
            int iF2 = aVar2.f();
            float fC = aVar.c();
            float fC2 = aVar2.c();
            Interpolator interpolatorD = aVar2.d();
            if (interpolatorD != null) {
                f = interpolatorD.getInterpolation(f);
            }
            float f2 = (f - fC) / (fC2 - fC);
            return this.f == null ? iF + ((int) (f2 * (iF2 - iF))) : ((Number) this.f.a(f2, Integer.valueOf(iF), Integer.valueOf(iF2))).intValue();
        }
        if (f >= 1.0f) {
            e.a aVar3 = (e.a) this.e.get(this.f4070a - 2);
            e.a aVar4 = (e.a) this.e.get(this.f4070a - 1);
            int iF3 = aVar3.f();
            int iF4 = aVar4.f();
            float fC3 = aVar3.c();
            float fC4 = aVar4.c();
            Interpolator interpolatorD2 = aVar4.d();
            if (interpolatorD2 != null) {
                f = interpolatorD2.getInterpolation(f);
            }
            float f3 = (f - fC3) / (fC4 - fC3);
            return this.f == null ? iF3 + ((int) (f3 * (iF4 - iF3))) : ((Number) this.f.a(f3, Integer.valueOf(iF3), Integer.valueOf(iF4))).intValue();
        }
        e.a aVar5 = (e.a) this.e.get(0);
        int i = 1;
        while (i < this.f4070a) {
            e.a aVar6 = (e.a) this.e.get(i);
            if (f < aVar6.c()) {
                Interpolator interpolatorD3 = aVar6.d();
                if (interpolatorD3 != null) {
                    f = interpolatorD3.getInterpolation(f);
                }
                float fC5 = (f - aVar5.c()) / (aVar6.c() - aVar5.c());
                int iF5 = aVar5.f();
                return this.f == null ? iF5 + ((int) (fC5 * (r1 - iF5))) : ((Number) this.f.a(fC5, Integer.valueOf(iF5), Integer.valueOf(aVar6.f()))).intValue();
            }
            i++;
            aVar5 = aVar6;
        }
        return ((Number) this.e.get(this.f4070a - 1).b()).intValue();
    }
}
