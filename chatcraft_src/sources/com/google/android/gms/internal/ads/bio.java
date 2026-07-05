package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class bio extends biu {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<bgf, biq>> f2708a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final SparseBooleanArray f2709b = new SparseBooleanArray();
    private int c = 0;
    private bip d;

    protected abstract bir[] a(bah[] bahVarArr, bgf[] bgfVarArr, int[][][] iArr);

    public final void a(int i, boolean z) {
        if (this.f2709b.get(i) == z) {
            return;
        }
        this.f2709b.put(i, z);
        a();
    }

    @Override // com.google.android.gms.internal.ads.biu
    public final biw a(bah[] bahVarArr, bgf bgfVar) {
        int[] iArr;
        int[] iArr2 = new int[bahVarArr.length + 1];
        bgd[][] bgdVarArr = new bgd[bahVarArr.length + 1][];
        int[][][] iArr3 = new int[bahVarArr.length + 1][][];
        for (int i = 0; i < bgdVarArr.length; i++) {
            bgdVarArr[i] = new bgd[bgfVar.f2638b];
            iArr3[i] = new int[bgfVar.f2638b][];
        }
        int[] iArr4 = new int[bahVarArr.length];
        for (int i2 = 0; i2 < iArr4.length; i2++) {
            iArr4[i2] = bahVarArr[i2].m();
        }
        for (int i3 = 0; i3 < bgfVar.f2638b; i3++) {
            bgd bgdVarA = bgfVar.a(i3);
            int length = bahVarArr.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= bahVarArr.length) {
                    i4 = length;
                    break;
                }
                bah bahVar = bahVarArr[i4];
                int i6 = length;
                for (int i7 = 0; i7 < bgdVarA.f2635a; i7++) {
                    int iA = bahVar.a(bgdVarA.a(i7)) & 3;
                    if (iA > i5) {
                        if (iA == 3) {
                            break;
                        }
                        i6 = i4;
                        i5 = iA;
                    }
                }
                i4++;
                length = i6;
            }
            if (i4 == bahVarArr.length) {
                iArr = new int[bgdVarA.f2635a];
            } else {
                bah bahVar2 = bahVarArr[i4];
                int[] iArr5 = new int[bgdVarA.f2635a];
                for (int i8 = 0; i8 < bgdVarA.f2635a; i8++) {
                    iArr5[i8] = bahVar2.a(bgdVarA.a(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[i4];
            bgdVarArr[i4][i9] = bgdVarA;
            iArr3[i4][i9] = iArr;
            iArr2[i4] = iArr2[i4] + 1;
        }
        bgf[] bgfVarArr = new bgf[bahVarArr.length];
        int[] iArr6 = new int[bahVarArr.length];
        for (int i10 = 0; i10 < bahVarArr.length; i10++) {
            int i11 = iArr2[i10];
            bgfVarArr[i10] = new bgf((bgd[]) Arrays.copyOf(bgdVarArr[i10], i11));
            iArr3[i10] = (int[][]) Arrays.copyOf(iArr3[i10], i11);
            iArr6[i10] = bahVarArr[i10].a();
        }
        bgf bgfVar2 = new bgf((bgd[]) Arrays.copyOf(bgdVarArr[bahVarArr.length], iArr2[bahVarArr.length]));
        bir[] birVarArrA = a(bahVarArr, bgfVarArr, iArr3);
        int i12 = 0;
        while (true) {
            if (i12 < bahVarArr.length) {
                if (this.f2709b.get(i12)) {
                    birVarArrA[i12] = null;
                } else {
                    bgf bgfVar3 = bgfVarArr[i12];
                    Map<bgf, biq> map = this.f2708a.get(i12);
                    if ((map != null ? map.get(bgfVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i12++;
            } else {
                bip bipVar = new bip(iArr6, bgfVarArr, iArr4, iArr3, bgfVar2);
                bai[] baiVarArr = new bai[bahVarArr.length];
                for (int i13 = 0; i13 < bahVarArr.length; i13++) {
                    baiVarArr[i13] = birVarArrA[i13] != null ? bai.f2447a : null;
                }
                return new biw(bgfVar, new bit(birVarArrA), bipVar, baiVarArr);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.biu
    public final void a(Object obj) {
        this.d = (bip) obj;
    }
}
