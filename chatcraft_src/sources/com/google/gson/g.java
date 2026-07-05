package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: GsonBuilder.java */
/* loaded from: classes.dex */
public final class g {
    private String h;

    /* renamed from: a, reason: collision with root package name */
    private com.google.gson.b.d f4030a = com.google.gson.b.d.f3992a;

    /* renamed from: b, reason: collision with root package name */
    private s f4031b = s.DEFAULT;
    private e c = d.IDENTITY;
    private final Map<Type, h<?>> d = new HashMap();
    private final List<u> e = new ArrayList();
    private final List<u> f = new ArrayList();
    private boolean g = false;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public g a(Type type, Object obj) {
        boolean z = obj instanceof r;
        com.google.gson.b.a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof t));
        if (obj instanceof h) {
            this.d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.e.add(com.google.gson.b.a.l.a(com.google.gson.c.a.a(type), obj));
        }
        if (obj instanceof t) {
            this.e.add(com.google.gson.b.a.n.a(com.google.gson.c.a.a(type), (t) obj));
        }
        return this;
    }

    public f a() {
        List<u> arrayList = new ArrayList<>(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new f(this.f4030a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.f4031b, this.h, this.i, this.j, this.e, this.f, arrayList);
    }

    private void a(String str, int i, int i2, List<u> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !BuildConfig.FLAVOR.equals(str.trim())) {
            a aVar4 = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
            aVar = aVar4;
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            aVar = new a(Date.class, i, i2);
            a aVar5 = new a(Timestamp.class, i, i2);
            a aVar6 = new a(java.sql.Date.class, i, i2);
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(com.google.gson.b.a.n.a(Date.class, aVar));
        list.add(com.google.gson.b.a.n.a(Timestamp.class, aVar2));
        list.add(com.google.gson.b.a.n.a(java.sql.Date.class, aVar3));
    }
}
