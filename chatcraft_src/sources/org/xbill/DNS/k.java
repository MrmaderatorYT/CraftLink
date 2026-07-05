package org.xbill.DNS;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private a f5415a;

    /* renamed from: b, reason: collision with root package name */
    private int f5416b;
    private int c;
    private int d;

    /* compiled from: Cache.java */
    private interface c {
        int a(int i);

        boolean a();

        int b();
    }

    static int a(long j, long j2) {
        return b(j, j2);
    }

    private static int b(long j, long j2) {
        if (j2 >= 0 && j2 < j) {
            j = j2;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + j;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jCurrentTimeMillis;
    }

    /* compiled from: Cache.java */
    private static class b extends bq implements c {

        /* renamed from: a, reason: collision with root package name */
        int f5418a;

        /* renamed from: b, reason: collision with root package name */
        int f5419b;

        public b(bq bqVar, int i, long j) {
            super(bqVar);
            this.f5418a = i;
            this.f5419b = k.a(bqVar.f(), j);
        }

        @Override // org.xbill.DNS.k.c
        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.f5419b;
        }

        @Override // org.xbill.DNS.k.c
        public final int a(int i) {
            return this.f5418a - i;
        }

        @Override // org.xbill.DNS.bq
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.toString());
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.f5418a);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Cache.java */
    private static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        int f5420a;

        /* renamed from: b, reason: collision with root package name */
        bg f5421b;
        int c;
        int d;

        public d(bg bgVar, int i, cb cbVar, int i2, long j) {
            this.f5421b = bgVar;
            this.f5420a = i;
            long jE = cbVar != null ? cbVar.e() : 0L;
            this.c = i2;
            this.d = k.a(jE, j);
        }

        @Override // org.xbill.DNS.k.c
        public int b() {
            return this.f5420a;
        }

        @Override // org.xbill.DNS.k.c
        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.d;
        }

        @Override // org.xbill.DNS.k.c
        public final int a(int i) {
            return this.c - i;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f5420a == 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("NXDOMAIN ");
                stringBuffer2.append(this.f5421b);
                stringBuffer.append(stringBuffer2.toString());
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("NXRRSET ");
                stringBuffer3.append(this.f5421b);
                stringBuffer3.append(" ");
                stringBuffer3.append(ct.b(this.f5420a));
                stringBuffer.append(stringBuffer3.toString());
            }
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.c);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Cache.java */
    private static class a extends LinkedHashMap {

        /* renamed from: a, reason: collision with root package name */
        private int f5417a;

        a(int i) {
            super(16, 0.75f, true);
            this.f5417a = -1;
            this.f5417a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return this.f5417a >= 0 && size() > this.f5417a;
        }
    }

    public k(int i) {
        this.f5416b = -1;
        this.c = -1;
        this.d = i;
        this.f5415a = new a(50000);
    }

    public k() {
        this(1);
    }

    private synchronized Object a(bg bgVar) {
        return this.f5415a.get(bgVar);
    }

    private synchronized c[] a(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return (c[]) list.toArray(new c[list.size()]);
        }
        return new c[]{(c) obj};
    }

    private synchronized c a(bg bgVar, Object obj, int i, int i2) {
        c cVar;
        c cVar2;
        if (i == 255) {
            throw new IllegalArgumentException("oneElement(ANY)");
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    cVar2 = null;
                    break;
                }
                cVar2 = (c) list.get(i3);
                if (cVar2.b() == i) {
                    break;
                }
                i3++;
            }
            cVar = cVar2;
        } else {
            cVar = (c) obj;
            if (cVar.b() != i) {
                cVar = null;
            }
        }
        if (cVar == null) {
            return null;
        }
        if (cVar.a()) {
            a(bgVar, i);
            return null;
        }
        if (cVar.a(i2) < 0) {
            return null;
        }
        return cVar;
    }

    private synchronized c c(bg bgVar, int i, int i2) {
        Object objA = a(bgVar);
        if (objA == null) {
            return null;
        }
        return a(bgVar, objA, i, i2);
    }

    private synchronized void a(bg bgVar, c cVar) {
        Object obj = this.f5415a.get(bgVar);
        if (obj == null) {
            this.f5415a.put(bgVar, cVar);
            return;
        }
        int iB = cVar.b();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((c) list.get(i)).b() == iB) {
                    list.set(i, cVar);
                    return;
                }
            }
            list.add(cVar);
        } else {
            c cVar2 = (c) obj;
            if (cVar2.b() == iB) {
                this.f5415a.put(bgVar, cVar);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(cVar2);
                linkedList.add(cVar);
                this.f5415a.put(bgVar, linkedList);
            }
        }
    }

    private synchronized void a(bg bgVar, int i) {
        Object obj = this.f5415a.get(bgVar);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((c) list.get(i2)).b() == i) {
                    list.remove(i2);
                    if (list.size() == 0) {
                        this.f5415a.remove(bgVar);
                    }
                    return;
                }
            }
        } else if (((c) obj).b() == i) {
            this.f5415a.remove(bgVar);
        }
    }

    public synchronized void a() {
        this.f5415a.clear();
    }

    public synchronized void a(bq bqVar, int i) {
        b bVar;
        long jF = bqVar.f();
        bg bgVarD = bqVar.d();
        int iB = bqVar.b();
        c cVarC = c(bgVarD, iB, 0);
        if (jF == 0) {
            if (cVarC != null && cVarC.a(i) <= 0) {
                a(bgVarD, iB);
            }
        } else {
            if (cVarC != null && cVarC.a(i) <= 0) {
                cVarC = null;
            }
            if (cVarC == null) {
                if (bqVar instanceof b) {
                    bVar = (b) bqVar;
                } else {
                    bVar = new b(bqVar, i, this.c);
                }
                a(bgVarD, bVar);
            }
        }
    }

    public synchronized void a(bg bgVar, int i, cb cbVar, int i2) {
        long jN;
        if (cbVar != null) {
            try {
                jN = cbVar.n();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            jN = 0;
        }
        c cVarC = c(bgVar, i, 0);
        if (jN == 0) {
            if (cVarC != null && cVarC.a(i2) <= 0) {
                a(bgVar, i);
            }
        } else {
            if (cVarC != null && cVarC.a(i2) <= 0) {
                cVarC = null;
            }
            if (cVarC == null) {
                a(bgVar, new d(bgVar, i, cbVar, i2, this.f5416b));
            }
        }
    }

    protected synchronized ch a(bg bgVar, int i, int i2) {
        bg bgVar2;
        int iC = bgVar.c();
        int i3 = iC;
        while (i3 >= 1) {
            boolean z = i3 == 1;
            boolean z2 = i3 == iC;
            if (z) {
                bgVar2 = bg.f5343a;
            } else {
                bgVar2 = z2 ? bgVar : new bg(bgVar, iC - i3);
            }
            Object obj = this.f5415a.get(bgVar2);
            if (obj != null) {
                if (z2 && i == 255) {
                    ch chVar = new ch(6);
                    int i4 = 0;
                    for (c cVar : a(obj)) {
                        if (cVar.a()) {
                            a(bgVar2, cVar.b());
                        } else if ((cVar instanceof b) && cVar.a(i2) >= 0) {
                            chVar.a((b) cVar);
                            i4++;
                        }
                    }
                    if (i4 > 0) {
                        return chVar;
                    }
                } else if (z2) {
                    c cVarA = a(bgVar2, obj, i, i2);
                    if (cVarA != null && (cVarA instanceof b)) {
                        ch chVar2 = new ch(6);
                        chVar2.a((b) cVarA);
                        return chVar2;
                    }
                    if (cVarA != null) {
                        return new ch(2);
                    }
                    c cVarA2 = a(bgVar2, obj, 5, i2);
                    if (cVarA2 != null && (cVarA2 instanceof b)) {
                        return new ch(4, (b) cVarA2);
                    }
                } else {
                    c cVarA3 = a(bgVar2, obj, 39, i2);
                    if (cVarA3 != null && (cVarA3 instanceof b)) {
                        return new ch(5, (b) cVarA3);
                    }
                }
                c cVarA4 = a(bgVar2, obj, 2, i2);
                if (cVarA4 != null && (cVarA4 instanceof b)) {
                    return new ch(3, (b) cVarA4);
                }
                if (z2 && a(bgVar2, obj, 0, i2) != null) {
                    return ch.a(1);
                }
            }
            i3--;
        }
        return ch.a(0);
    }

    public ch b(bg bgVar, int i, int i2) {
        return a(bgVar, i, i2);
    }

    private final int a(int i, boolean z) {
        if (i == 1) {
            return z ? 4 : 3;
        }
        if (i == 2) {
            return z ? 4 : 3;
        }
        if (i == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    private static void a(bq bqVar, Set set) {
        if (bqVar.g().c() == null) {
            return;
        }
        Iterator itC = bqVar.c();
        while (itC.hasNext()) {
            bg bgVarC = ((bt) itC.next()).c();
            if (bgVarC != null) {
                set.add(bgVarC);
            }
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public org.xbill.DNS.ch a(org.xbill.DNS.au r20) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.k.a(org.xbill.DNS.au):org.xbill.DNS.ch");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this) {
            Iterator it = this.f5415a.values().iterator();
            while (it.hasNext()) {
                for (c cVar : a(it.next())) {
                    stringBuffer.append(cVar);
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }
}
