package io.fabric.sdk.android.services.c;

import android.content.Context;
import io.fabric.sdk.android.services.b.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager.java */
/* loaded from: classes.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f4246a;

    /* renamed from: b, reason: collision with root package name */
    protected final io.fabric.sdk.android.services.c.a<T> f4247b;
    protected final k c;
    protected final c d;
    protected volatile long e;
    protected final List<d> f = new CopyOnWriteArrayList();
    private final int g;

    protected abstract String a();

    protected int c() {
        return 8000;
    }

    public b(Context context, io.fabric.sdk.android.services.c.a<T> aVar, k kVar, c cVar, int i) {
        this.f4246a = context.getApplicationContext();
        this.f4247b = aVar;
        this.d = cVar;
        this.c = kVar;
        this.e = this.c.a();
        this.g = i;
    }

    public void a(T t) {
        byte[] bArrA = this.f4247b.a(t);
        a(bArrA.length);
        this.d.a(bArrA);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f.add(dVar);
        }
    }

    public boolean d() {
        String strA;
        boolean z = true;
        if (this.d.b()) {
            strA = null;
            z = false;
        } else {
            strA = a();
            this.d.a(strA);
            io.fabric.sdk.android.services.b.i.a(this.f4246a, 4, "Fabric", String.format(Locale.US, "generated new file %s", strA));
            this.e = this.c.a();
        }
        b(strA);
        return z;
    }

    private void a(int i) {
        if (this.d.a(i, c())) {
            return;
        }
        io.fabric.sdk.android.services.b.i.a(this.f4246a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.d.a()), Integer.valueOf(i), Integer.valueOf(c())));
        d();
    }

    protected int b() {
        return this.g;
    }

    private void b(String str) {
        Iterator<d> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(str);
            } catch (Exception e) {
                io.fabric.sdk.android.services.b.i.a(this.f4246a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> e() {
        return this.d.a(1);
    }

    public void a(List<File> list) {
        this.d.a(list);
    }

    public void f() {
        this.d.a(this.d.c());
        this.d.d();
    }

    public void g() {
        List<File> listC = this.d.c();
        int iB = b();
        if (listC.size() <= iB) {
            return;
        }
        int size = listC.size() - iB;
        io.fabric.sdk.android.services.b.i.a(this.f4246a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(listC.size()), Integer.valueOf(iB), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new Comparator<a>() { // from class: io.fabric.sdk.android.services.c.b.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                return (int) (aVar.f4250b - aVar2.f4250b);
            }
        });
        for (File file : listC) {
            treeSet.add(new a(file, a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).f4249a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.d.a(arrayList);
    }

    public long a(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(strArrSplit[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* compiled from: EventsFilesManager.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final File f4249a;

        /* renamed from: b, reason: collision with root package name */
        final long f4250b;

        public a(File file, long j) {
            this.f4249a = file;
            this.f4250b = j;
        }
    }
}
