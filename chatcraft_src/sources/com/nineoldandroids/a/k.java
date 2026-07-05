package com.nineoldandroids.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.nineoldandroids.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ValueAnimator.java */
/* loaded from: classes.dex */
public class k extends com.nineoldandroids.a.a {
    private static ThreadLocal<a> h = new ThreadLocal<>();
    private static final ThreadLocal<ArrayList<k>> i = new ThreadLocal<ArrayList<k>>() { // from class: com.nineoldandroids.a.k.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<k>> j = new ThreadLocal<ArrayList<k>>() { // from class: com.nineoldandroids.a.k.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<k>> k = new ThreadLocal<ArrayList<k>>() { // from class: com.nineoldandroids.a.k.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<k>> l = new ThreadLocal<ArrayList<k>>() { // from class: com.nineoldandroids.a.k.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final ThreadLocal<ArrayList<k>> m = new ThreadLocal<ArrayList<k>>() { // from class: com.nineoldandroids.a.k.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final Interpolator n = new AccelerateDecelerateInterpolator();
    private static final j o = new c();
    private static final j p = new com.nineoldandroids.a.b();
    private static long z = 10;

    /* renamed from: b, reason: collision with root package name */
    long f4076b;
    i[] f;
    HashMap<String, i> g;
    private long u;
    long c = -1;
    private boolean q = false;
    private int r = 0;
    private float s = 0.0f;
    private boolean t = false;
    int d = 0;
    private boolean v = false;
    private boolean w = false;
    boolean e = false;
    private long x = 300;
    private long y = 0;
    private int A = 0;
    private int B = 1;
    private Interpolator C = n;
    private ArrayList<b> D = null;

    /* compiled from: ValueAnimator.java */
    public interface b {
        void a(k kVar);
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (this.f == null || this.f.length == 0) {
            a(i.a(BuildConfig.FLAVOR, iArr));
        } else {
            this.f[0].a(iArr);
        }
        this.e = false;
    }

    public void a(i... iVarArr) {
        int length = iVarArr.length;
        this.f = iVarArr;
        this.g = new HashMap<>(length);
        for (i iVar : iVarArr) {
            this.g.put(iVar.c(), iVar);
        }
        this.e = false;
    }

    void c() {
        if (this.e) {
            return;
        }
        int length = this.f.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f[i2].b();
        }
        this.e = true;
    }

    public void a(long j2) {
        c();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.d != 1) {
            this.c = j2;
            this.d = 2;
        }
        this.f4076b = jCurrentAnimationTimeMillis - j2;
        b(jCurrentAnimationTimeMillis);
    }

    public long f() {
        if (!this.e || this.d == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f4076b;
    }

    /* compiled from: ValueAnimator.java */
    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) k.i.get();
            ArrayList arrayList2 = (ArrayList) k.k.get();
            switch (message.what) {
                case 0:
                    ArrayList arrayList3 = (ArrayList) k.j.get();
                    z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                    while (arrayList3.size() > 0) {
                        ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                        arrayList3.clear();
                        int size = arrayList4.size();
                        for (int i = 0; i < size; i++) {
                            k kVar = (k) arrayList4.get(i);
                            if (kVar.y == 0) {
                                kVar.m();
                            } else {
                                arrayList2.add(kVar);
                            }
                        }
                    }
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) k.m.get();
            ArrayList arrayList6 = (ArrayList) k.l.get();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                k kVar2 = (k) arrayList2.get(i2);
                if (kVar2.c(jCurrentAnimationTimeMillis)) {
                    arrayList5.add(kVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i3 = 0; i3 < size3; i3++) {
                    k kVar3 = (k) arrayList5.get(i3);
                    kVar3.m();
                    kVar3.v = true;
                    arrayList2.remove(kVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i4 = 0;
            while (i4 < size4) {
                k kVar4 = (k) arrayList.get(i4);
                if (kVar4.b(jCurrentAnimationTimeMillis)) {
                    arrayList6.add(kVar4);
                }
                if (arrayList.size() == size4) {
                    i4++;
                } else {
                    size4--;
                    arrayList6.remove(kVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i5 = 0; i5 < arrayList6.size(); i5++) {
                    ((k) arrayList6.get(i5)).d();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, k.z - (AnimationUtils.currentAnimationTimeMillis() - jCurrentAnimationTimeMillis)));
            }
        }
    }

    private void a(boolean z2) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.q = z2;
        this.r = 0;
        this.d = 0;
        this.w = true;
        this.t = false;
        j.get().add(this);
        if (this.y == 0) {
            a(f());
            this.d = 0;
            this.v = true;
            if (this.f4067a != null) {
                ArrayList arrayList = (ArrayList) this.f4067a.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((a.InterfaceC0092a) arrayList.get(i2)).a(this);
                }
            }
        }
        a aVar = h.get();
        if (aVar == null) {
            aVar = new a();
            h.set(aVar);
        }
        aVar.sendEmptyMessage(0);
    }

    @Override // com.nineoldandroids.a.a
    public void a() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i.get().remove(this);
        j.get().remove(this);
        k.get().remove(this);
        this.d = 0;
        if (this.v && this.f4067a != null) {
            ArrayList arrayList = (ArrayList) this.f4067a.clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.InterfaceC0092a) arrayList.get(i2)).b(this);
            }
        }
        this.v = false;
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        c();
        i.get().add(this);
        if (this.y <= 0 || this.f4067a == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f4067a.clone();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((a.InterfaceC0092a) arrayList.get(i2)).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(long j2) {
        if (!this.t) {
            this.t = true;
            this.u = j2;
            return false;
        }
        long j3 = j2 - this.u;
        if (j3 <= this.y) {
            return false;
        }
        this.f4076b = j2 - (j3 - this.y);
        this.d = 1;
        return true;
    }

    boolean b(long j2) {
        if (this.d == 0) {
            this.d = 1;
            if (this.c < 0) {
                this.f4076b = j2;
            } else {
                this.f4076b = j2 - this.c;
                this.c = -1L;
            }
        }
        boolean z2 = false;
        switch (this.d) {
            case 1:
            case 2:
                float fMin = this.x > 0 ? (j2 - this.f4076b) / this.x : 1.0f;
                if (fMin >= 1.0f) {
                    if (this.r < this.A || this.A == -1) {
                        if (this.f4067a != null) {
                            int size = this.f4067a.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                this.f4067a.get(i2).c(this);
                            }
                        }
                        if (this.B == 2) {
                            this.q = !this.q;
                        }
                        this.r += (int) fMin;
                        fMin %= 1.0f;
                        this.f4076b += this.x;
                    } else {
                        fMin = Math.min(fMin, 1.0f);
                        z2 = true;
                    }
                }
                if (this.q) {
                    fMin = 1.0f - fMin;
                }
                a(fMin);
                break;
            default:
                return z2;
        }
    }

    void a(float f) {
        float interpolation = this.C.getInterpolation(f);
        this.s = interpolation;
        int length = this.f.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f[i2].a(interpolation);
        }
        if (this.D != null) {
            int size = this.D.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.D.get(i3).a(this);
            }
        }
    }

    @Override // com.nineoldandroids.a.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public k clone() {
        k kVar = (k) super.clone();
        if (this.D != null) {
            ArrayList<b> arrayList = this.D;
            kVar.D = new ArrayList<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                kVar.D.add(arrayList.get(i2));
            }
        }
        kVar.c = -1L;
        kVar.q = false;
        kVar.r = 0;
        kVar.e = false;
        kVar.d = 0;
        kVar.t = false;
        i[] iVarArr = this.f;
        if (iVarArr != null) {
            int length = iVarArr.length;
            kVar.f = new i[length];
            kVar.g = new HashMap<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                i iVarClone = iVarArr[i3].clone();
                kVar.f[i3] = iVarClone;
                kVar.g.put(iVarClone.c(), iVarClone);
            }
        }
        return kVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f != null) {
            for (int i2 = 0; i2 < this.f.length; i2++) {
                str = str + "\n    " + this.f[i2].toString();
            }
        }
        return str;
    }
}
