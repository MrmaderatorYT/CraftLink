package com.google.android.gms.internal.ads;

import android.os.Environment;
import com.google.android.gms.internal.ads.bou;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class bos {

    /* renamed from: a, reason: collision with root package name */
    private final box f2912a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private final bpw f2913b;
    private final boolean c;

    public static bos a() {
        return new bos();
    }

    public bos(box boxVar) {
        this.f2912a = boxVar;
        this.c = ((Boolean) bra.e().a(o.cu)).booleanValue();
        this.f2913b = new bpw();
        b();
    }

    private bos() {
        this.c = false;
        this.f2912a = new box();
        this.f2913b = new bpw();
        b();
    }

    public final synchronized void a(bou.a.b bVar) {
        if (this.c) {
            if (((Boolean) bra.e().a(o.cv)).booleanValue()) {
                c(bVar);
            } else {
                b(bVar);
            }
        }
    }

    private final synchronized void b(bou.a.b bVar) {
        this.f2913b.f2955b = c();
        this.f2912a.a(aus.a(this.f2913b)).b(bVar.a()).a();
        String strValueOf = String.valueOf(Integer.toString(bVar.a(), 10));
        xe.a(strValueOf.length() != 0 ? "Logging Event with event code : ".concat(strValueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void c(bou.a.b bVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(d(bVar).getBytes());
                    fileOutputStream.write(10);
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        xe.a("Could not close Clearcut output stream.");
                    }
                }
            } catch (IOException unused2) {
                xe.a("Could not write Clearcut to file.");
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    xe.a("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            xe.a("Could not find file for Clearcut");
        }
    }

    private final synchronized String d(bou.a.b bVar) {
        return String.format("id=%s,timestamp=%s,event=%s", this.f2913b.f2954a, Long.valueOf(com.google.android.gms.ads.internal.ax.l().b()), Integer.valueOf(bVar.a()));
    }

    public final synchronized void a(bot botVar) {
        if (this.c) {
            try {
                botVar.a(this.f2913b);
            } catch (NullPointerException e) {
                com.google.android.gms.ads.internal.ax.i().a(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private final synchronized void b() {
        this.f2913b.d = new bps();
        this.f2913b.d.f2947b = new bpt();
        this.f2913b.c = new bpu();
    }

    private static long[] c() {
        int i;
        List<String> listB = o.b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listB.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] strArrSplit = it.next().split(",");
            int length = strArrSplit.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(strArrSplit[i]));
                } catch (NumberFormatException unused) {
                    xe.a("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }
}
