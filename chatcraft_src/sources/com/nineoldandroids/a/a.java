package com.nineoldandroids.a;

import java.util.ArrayList;

/* compiled from: Animator.java */
/* loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<InterfaceC0092a> f4067a = null;

    /* compiled from: Animator.java */
    /* renamed from: com.nineoldandroids.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0092a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    public void a() {
    }

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            if (this.f4067a != null) {
                ArrayList<InterfaceC0092a> arrayList = this.f4067a;
                aVar.f4067a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    aVar.f4067a.add(arrayList.get(i));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
