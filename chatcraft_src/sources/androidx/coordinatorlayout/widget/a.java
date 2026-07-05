package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.f.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final d.a<ArrayList<T>> f522a = new d.b(10);

    /* renamed from: b, reason: collision with root package name */
    private final g<T, ArrayList<T>> f523b = new g<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (this.f523b.containsKey(t)) {
            return;
        }
        this.f523b.put(t, null);
    }

    public boolean b(T t) {
        return this.f523b.containsKey(t);
    }

    public void a(T t, T t2) {
        if (!this.f523b.containsKey(t) || !this.f523b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListC = this.f523b.get(t);
        if (arrayListC == null) {
            arrayListC = c();
            this.f523b.put(t, arrayListC);
        }
        arrayListC.add(t2);
    }

    public List c(T t) {
        return this.f523b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f523b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.f523b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f523b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f523b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.f523b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        int size = this.f523b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.f523b.c(i);
            if (arrayListC != null) {
                a((ArrayList) arrayListC);
            }
        }
        this.f523b.clear();
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.f523b.size();
        for (int i = 0; i < size; i++) {
            a(this.f523b.b(i), this.c, this.d);
        }
        return this.c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f523b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private ArrayList<T> c() {
        ArrayList<T> arrayListA = this.f522a.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f522a.a(arrayList);
    }
}
