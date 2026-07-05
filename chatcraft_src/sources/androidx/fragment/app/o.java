package androidx.fragment.app;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f764a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b, reason: collision with root package name */
    private static final q f765b;
    private static final q c;

    static {
        f765b = Build.VERSION.SDK_INT >= 21 ? new p() : null;
        c = a();
    }

    private static q a() {
        try {
            return (q) Class.forName("androidx.i.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(i iVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (iVar.l < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar, (SparseArray<a>) sparseArray, z);
            } else {
                a(aVar, (SparseArray<a>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(iVar.m.g());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                androidx.b.a<String, String> aVarA = a(iKeyAt, arrayList, arrayList2, i, i2);
                a aVar2 = (a) sparseArray.valueAt(i4);
                if (z) {
                    a(iVar, iKeyAt, aVar2, view, aVarA);
                } else {
                    b(iVar, iKeyAt, aVar2, view, aVarA);
                }
            }
        }
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.r != null) {
                    int size = aVar2.r.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.r;
                        arrayList4 = aVar2.s;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.r;
                        arrayList3 = aVar2.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static void a(i iVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        Fragment fragment;
        Fragment fragment2;
        q qVarA;
        Object obj;
        ViewGroup viewGroup = iVar.n.a() ? (ViewGroup) iVar.n.a(i) : null;
        if (viewGroup == null || (qVarA = a((fragment2 = aVar.d), (fragment = aVar.f773a))) == null) {
            return;
        }
        boolean z = aVar.f774b;
        boolean z2 = aVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objA = a(qVarA, fragment, z);
        Object objB = b(qVarA, fragment2, z2);
        Object objA2 = a(qVarA, viewGroup, view, aVar2, aVar, arrayList2, arrayList, objA, objB);
        if (objA == null && objA2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(qVarA, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListA2 = a(qVarA, objA, fragment, arrayList, view);
        a(arrayListA2, 4);
        Object objA3 = a(qVarA, objA, obj, objA2, fragment, z);
        if (objA3 != null) {
            a(qVarA, obj, fragment2, arrayListA);
            ArrayList<String> arrayListA3 = qVarA.a(arrayList);
            qVarA.a(objA3, objA, arrayListA2, obj, arrayListA, objA2, arrayList);
            qVarA.a(viewGroup, objA3);
            qVarA.a(viewGroup, arrayList2, arrayList, arrayListA3, aVar2);
            a(arrayListA2, 0);
            qVarA.a(objA2, arrayList2, arrayList);
        }
    }

    private static void a(q qVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.u && fragment.K && fragment.Y) {
            fragment.j(true);
            qVar.b(obj, fragment.u(), arrayList);
            r.a(fragment.R, new Runnable() { // from class: androidx.fragment.app.o.1
                @Override // java.lang.Runnable
                public void run() {
                    o.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void b(i iVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        Fragment fragment;
        Fragment fragment2;
        q qVarA;
        Object obj;
        ViewGroup viewGroup = iVar.n.a() ? (ViewGroup) iVar.n.a(i) : null;
        if (viewGroup == null || (qVarA = a((fragment2 = aVar.d), (fragment = aVar.f773a))) == null) {
            return;
        }
        boolean z = aVar.f774b;
        boolean z2 = aVar.e;
        Object objA = a(qVarA, fragment, z);
        Object objB = b(qVarA, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objB2 = b(qVarA, viewGroup, view, aVar2, aVar, arrayList, arrayList2, objA, objB);
        if (objA == null && objB2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(qVarA, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (arrayListA == null || arrayListA.isEmpty()) ? null : obj;
        qVarA.b(objA, view);
        Object objA2 = a(qVarA, objA, obj2, objB2, fragment, aVar.f774b);
        if (objA2 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            qVarA.a(objA2, objA, arrayList3, obj2, arrayListA, objB2, arrayList2);
            a(qVarA, viewGroup, fragment, view, arrayList2, objA, arrayList3, obj2, arrayListA);
            qVarA.a((View) viewGroup, arrayList2, (Map<String, String>) aVar2);
            qVarA.a(viewGroup, objA2);
            qVarA.a(viewGroup, arrayList2, (Map<String, String>) aVar2);
        }
    }

    private static void a(final q qVar, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        r.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    qVar.c(obj, view);
                    arrayList2.addAll(o.a(qVar, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        qVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static q a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objC = fragment.C();
            if (objC != null) {
                arrayList.add(objC);
            }
            Object objB = fragment.B();
            if (objB != null) {
                arrayList.add(objB);
            }
            Object objF = fragment.F();
            if (objF != null) {
                arrayList.add(objF);
            }
        }
        if (fragment2 != null) {
            Object objA = fragment2.A();
            if (objA != null) {
                arrayList.add(objA);
            }
            Object objD = fragment2.D();
            if (objD != null) {
                arrayList.add(objD);
            }
            Object objE = fragment2.E();
            if (objE != null) {
                arrayList.add(objE);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f765b != null && a(f765b, arrayList)) {
            return f765b;
        }
        if (c != null && a(c, arrayList)) {
            return c;
        }
        if (f765b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(q qVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!qVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(q qVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object objE;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            objE = fragment2.F();
        } else {
            objE = fragment.E();
        }
        return qVar.c(qVar.b(objE));
    }

    private static Object a(q qVar, Fragment fragment, boolean z) {
        Object objA;
        if (fragment == null) {
            return null;
        }
        if (z) {
            objA = fragment.D();
        } else {
            objA = fragment.A();
        }
        return qVar.b(objA);
    }

    private static Object b(q qVar, Fragment fragment, boolean z) {
        Object objC;
        if (fragment == null) {
            return null;
        }
        if (z) {
            objC = fragment.B();
        } else {
            objC = fragment.C();
        }
        return qVar.b(objC);
    }

    private static Object a(final q qVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final Fragment fragment = aVar2.f773a;
        final Fragment fragment2 = aVar2.d;
        if (fragment != null) {
            fragment.u().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar2.f774b;
        Object objA = aVar.isEmpty() ? null : a(qVar, fragment, fragment2, z);
        androidx.b.a<String, View> aVarB = b(qVar, aVar, objA, aVar2);
        final androidx.b.a<String, View> aVarA = a(qVar, aVar, objA, aVar2);
        if (aVar.isEmpty()) {
            if (aVarB != null) {
                aVarB.clear();
            }
            if (aVarA != null) {
                aVarA.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarB, aVar.keySet());
            a(arrayList2, aVarA, aVar.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, aVarB, true);
        if (obj3 != null) {
            arrayList2.add(view);
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, aVarB, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View viewA = a(aVarA, aVar2, obj, z);
            if (viewA != null) {
                qVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = viewA;
        } else {
            view2 = null;
            rect = null;
        }
        r.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.3
            @Override // java.lang.Runnable
            public void run() {
                o.a(fragment, fragment2, z, (androidx.b.a<String, View>) aVarA, false);
                if (view2 != null) {
                    qVar.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewC = aVar.c(size);
            if (collection.contains(androidx.core.g.q.n(viewC))) {
                arrayList.add(viewC);
            }
        }
    }

    private static Object b(final q qVar, ViewGroup viewGroup, final View view, final androidx.b.a<String, String> aVar, final a aVar2, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object objA;
        androidx.b.a<String, String> aVar3;
        Object obj3;
        Rect rect;
        final Fragment fragment = aVar2.f773a;
        final Fragment fragment2 = aVar2.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar2.f774b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            objA = null;
        } else {
            objA = a(qVar, fragment, fragment2, z);
            aVar3 = aVar;
        }
        androidx.b.a<String, View> aVarB = b(qVar, aVar3, objA, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarB.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, aVarB, true);
        if (obj3 != null) {
            rect = new Rect();
            qVar.a(obj3, view, arrayList);
            a(qVar, obj3, obj2, aVarB, aVar2.e, aVar2.f);
            if (obj != null) {
                qVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        r.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.o.4
            @Override // java.lang.Runnable
            public void run() {
                androidx.b.a<String, View> aVarA = o.a(qVar, (androidx.b.a<String, String>) aVar, obj4, aVar2);
                if (aVarA != null) {
                    arrayList2.addAll(aVarA.values());
                    arrayList2.add(view);
                }
                o.a(fragment, fragment2, z, aVarA, false);
                if (obj4 != null) {
                    qVar.a(obj4, arrayList, arrayList2);
                    View viewA = o.a(aVarA, aVar2, obj, z);
                    if (viewA != null) {
                        qVar.a(viewA, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static androidx.b.a<String, View> b(q qVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.l lVarY;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = aVar2.d;
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar3, fragment.u());
        androidx.fragment.app.a aVar4 = aVar2.f;
        if (aVar2.e) {
            lVarY = fragment.X();
            arrayList = aVar4.s;
        } else {
            lVarY = fragment.Y();
            arrayList = aVar4.r;
        }
        aVar3.a((Collection<?>) arrayList);
        if (lVarY != null) {
            lVarY.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(androidx.core.g.q.n(view))) {
                    aVar.put(androidx.core.g.q.n(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar3.keySet());
        }
        return aVar3;
    }

    static androidx.b.a<String, View> a(q qVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.l lVarX;
        ArrayList<String> arrayList;
        String strA;
        Fragment fragment = aVar2.f773a;
        View viewU = fragment.u();
        if (aVar.isEmpty() || obj == null || viewU == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        qVar.a((Map<String, View>) aVar3, viewU);
        androidx.fragment.app.a aVar4 = aVar2.c;
        if (aVar2.f774b) {
            lVarX = fragment.Y();
            arrayList = aVar4.r;
        } else {
            lVarX = fragment.X();
            arrayList = aVar4.s;
        }
        if (arrayList != null) {
            aVar3.a((Collection<?>) arrayList);
            aVar3.a((Collection<?>) aVar.values());
        }
        if (lVarX != null) {
            lVarX.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    String strA2 = a(aVar, str);
                    if (strA2 != null) {
                        aVar.remove(strA2);
                    }
                } else if (!str.equals(androidx.core.g.q.n(view)) && (strA = a(aVar, str)) != null) {
                    aVar.put(strA, androidx.core.g.q.n(view));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }

    private static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static View a(androidx.b.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        String str;
        androidx.fragment.app.a aVar3 = aVar2.c;
        if (obj == null || aVar == null || aVar3.r == null || aVar3.r.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar3.r.get(0);
        } else {
            str = aVar3.s.get(0);
        }
        return aVar.get(str);
    }

    private static void a(q qVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        if (aVar2.r == null || aVar2.r.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.s.get(0);
        } else {
            str = aVar2.r.get(0);
        }
        View view = aVar.get(str);
        qVar.a(obj, view);
        if (obj2 != null) {
            qVar.a(obj2, view);
        }
    }

    private static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        androidx.core.app.l lVarX;
        if (z) {
            lVarX = fragment2.X();
        } else {
            lVarX = fragment.X();
        }
        if (lVarX != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                lVarX.a(arrayList2, arrayList, null);
            } else {
                lVarX.b(arrayList2, arrayList, null);
            }
        }
    }

    static ArrayList<View> a(q qVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewU = fragment.u();
        if (viewU != null) {
            qVar.a(arrayList2, viewU);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        qVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(q qVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean zG;
        if (obj == null || obj2 == null || fragment == null) {
            zG = true;
        } else if (z) {
            zG = fragment.H();
        } else {
            zG = fragment.G();
        }
        if (zG) {
            return qVar.a(obj2, obj, obj3);
        }
        return qVar.b(obj2, obj, obj3);
    }

    public static void a(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) throws Resources.NotFoundException {
        int size = aVar.f715b.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.f715b.get(i), sparseArray, false, z);
        }
    }

    public static void b(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) throws Resources.NotFoundException {
        if (aVar.f714a.n.a()) {
            for (int size = aVar.f715b.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f715b.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(androidx.fragment.app.a r15, androidx.fragment.app.a.C0046a r16, android.util.SparseArray<androidx.fragment.app.o.a> r17, boolean r18, boolean r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.o.a(androidx.fragment.app.a, androidx.fragment.app.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    /* compiled from: FragmentTransition.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f773a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f774b;
        public androidx.fragment.app.a c;
        public Fragment d;
        public boolean e;
        public androidx.fragment.app.a f;

        a() {
        }
    }
}
