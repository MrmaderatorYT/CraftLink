package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class le implements zh {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, lw> f3235a;

    /* renamed from: b, reason: collision with root package name */
    private long f3236b;
    private final File c;
    private final int d;

    public le(File file, int i) {
        this.f3235a = new LinkedHashMap(16, 0.75f, true);
        this.f3236b = 0L;
        this.c = file;
        this.d = i;
    }

    public le(File file) {
        this(file, 5242880);
    }

    @Override // com.google.android.gms.internal.ads.zh
    public final synchronized awj a(String str) {
        lw lwVar = this.f3235a.get(str);
        if (lwVar == null) {
            return null;
        }
        File fileD = d(str);
        try {
            mw mwVar = new mw(new BufferedInputStream(a(fileD)), fileD.length());
            try {
                lw lwVarA = lw.a(mwVar);
                if (!TextUtils.equals(str, lwVarA.f3260b)) {
                    eb.b("%s: key=%s, found=%s", fileD.getAbsolutePath(), str, lwVarA.f3260b);
                    e(str);
                    return null;
                }
                byte[] bArrA = a(mwVar, mwVar.a());
                awj awjVar = new awj();
                awjVar.f2343a = bArrA;
                awjVar.f2344b = lwVar.c;
                awjVar.c = lwVar.d;
                awjVar.d = lwVar.e;
                awjVar.e = lwVar.f;
                awjVar.f = lwVar.g;
                List<bfd> list = lwVar.h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (bfd bfdVar : list) {
                    treeMap.put(bfdVar.a(), bfdVar.b());
                }
                awjVar.g = treeMap;
                awjVar.h = Collections.unmodifiableList(lwVar.h);
                return awjVar;
            } finally {
                mwVar.close();
            }
        } catch (IOException e) {
            eb.b("%s: %s", fileD.getAbsolutePath(), e.toString());
            b(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zh
    public final synchronized void a() {
        long length;
        mw mwVar;
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                eb.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.c.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                length = file.length();
                mwVar = new mw(new BufferedInputStream(a(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                lw lwVarA = lw.a(mwVar);
                lwVarA.f3259a = length;
                a(lwVarA.f3260b, lwVarA);
                mwVar.close();
            } catch (Throwable th) {
                mwVar.close();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zh
    public final synchronized void a(String str, awj awjVar) {
        long j;
        Iterator<Map.Entry<String, lw>> it;
        if (this.f3236b + awjVar.f2343a.length >= this.d) {
            if (eb.f3057a) {
                eb.a("Pruning old cache entries.", new Object[0]);
            }
            long j2 = this.f3236b;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, lw>> it2 = this.f3235a.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    j = j2;
                    break;
                }
                lw value = it2.next().getValue();
                if (d(value.f3260b).delete()) {
                    j = j2;
                    it = it2;
                    this.f3236b -= value.f3259a;
                } else {
                    j = j2;
                    it = it2;
                    eb.b("Could not delete cache entry for key=%s, filename=%s", value.f3260b, c(value.f3260b));
                }
                it.remove();
                i++;
                if (this.f3236b + r6 < this.d * 0.9f) {
                    break;
                }
                j2 = j;
                it2 = it;
            }
            if (eb.f3057a) {
                eb.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f3236b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
        }
        File fileD = d(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileD));
            lw lwVar = new lw(str, awjVar);
            if (!lwVar.a(bufferedOutputStream)) {
                bufferedOutputStream.close();
                eb.b("Failed to write header for %s", fileD.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(awjVar.f2343a);
            bufferedOutputStream.close();
            a(str, lwVar);
        } catch (IOException unused) {
            if (fileD.delete()) {
                return;
            }
            eb.b("Could not clean up file %s", fileD.getAbsolutePath());
        }
    }

    private final synchronized void b(String str) {
        boolean zDelete = d(str).delete();
        e(str);
        if (!zDelete) {
            eb.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    private static String c(String str) {
        int length = str.length() / 2;
        String strValueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String strValueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private final File d(String str) {
        return new File(this.c, c(str));
    }

    private final void a(String str, lw lwVar) {
        if (!this.f3235a.containsKey(str)) {
            this.f3236b += lwVar.f3259a;
        } else {
            this.f3236b += lwVar.f3259a - this.f3235a.get(str).f3259a;
        }
        this.f3235a.put(str, lwVar);
    }

    private final void e(String str) {
        lw lwVarRemove = this.f3235a.remove(str);
        if (lwVarRemove != null) {
            this.f3236b -= lwVarRemove.f3259a;
        }
    }

    private static byte[] a(mw mwVar, long j) throws IOException {
        long jA = mwVar.a();
        if (j >= 0 && j <= jA) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(mwVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(jA);
        throw new IOException(sb.toString());
    }

    private static InputStream a(File file) {
        return new FileInputStream(file);
    }

    private static int c(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    static void a(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static int a(InputStream inputStream) {
        return (c(inputStream) << 24) | c(inputStream) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long b(InputStream inputStream) {
        return (c(inputStream) & 255) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56);
    }

    static void a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(mw mwVar) {
        return new String(a(mwVar, b((InputStream) mwVar)), "UTF-8");
    }

    static List<bfd> b(mw mwVar) throws IOException {
        int iA = a((InputStream) mwVar);
        if (iA < 0) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("readHeaderList size=");
            sb.append(iA);
            throw new IOException(sb.toString());
        }
        List<bfd> listEmptyList = iA == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < iA; i++) {
            listEmptyList.add(new bfd(a(mwVar).intern(), a(mwVar).intern()));
        }
        return listEmptyList;
    }
}
