package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ActivityChooserModel.java */
/* loaded from: classes.dex */
class d extends DataSetObservable {

    /* renamed from: a, reason: collision with root package name */
    static final String f395a = "d";
    private static final Object e = new Object();
    private static final Map<String, d> f = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    final Context f396b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private InterfaceC0027d p;

    /* compiled from: ActivityChooserModel.java */
    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$d, reason: collision with other inner class name */
    public interface InterfaceC0027d {
        boolean a(d dVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = this.h.get(i).f397a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List<a> list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f397a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.f397a.activityInfo.packageName, aVar.f397a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            return this.h.get(0).f397a;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = this.h.get(i);
            a aVar2 = this.h.get(0);
            a(new c(new ComponentName(aVar.f397a.activityInfo.packageName, aVar.f397a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f398b - aVar.f398b) + 5.0f : 1.0f));
        }
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.c);
        }
    }

    private void d() {
        boolean zF = f() | g();
        h();
        if (zF) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f396b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean g() throws IOException {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private boolean a(c cVar) {
        boolean zAdd = this.i.add(cVar);
        if (zAdd) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return zAdd;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.i.remove(0);
        }
    }

    /* compiled from: ActivityChooserModel.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f399a;

        /* renamed from: b, reason: collision with root package name */
        public final long f400b;
        public final float c;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.f399a = componentName;
            this.f400b = j;
            this.c = f;
        }

        public int hashCode() {
            return (((((this.f399a == null ? 0 : this.f399a.hashCode()) + 31) * 31) + ((int) (this.f400b ^ (this.f400b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f399a == null) {
                if (cVar.f399a != null) {
                    return false;
                }
            } else if (!this.f399a.equals(cVar.f399a)) {
                return false;
            }
            return this.f400b == cVar.f400b && Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
        }

        public String toString() {
            return "[; activity:" + this.f399a + "; time:" + this.f400b + "; weight:" + new BigDecimal(this.c) + "]";
        }
    }

    /* compiled from: ActivityChooserModel.java */
    public static final class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public final ResolveInfo f397a;

        /* renamed from: b, reason: collision with root package name */
        public float f398b;

        public a(ResolveInfo resolveInfo) {
            this.f397a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f398b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f398b) == Float.floatToIntBits(((a) obj).f398b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f398b) - Float.floatToIntBits(this.f398b);
        }

        public String toString() {
            return "[resolveInfo:" + this.f397a.toString() + "; weight:" + new BigDecimal(this.f398b) + "]";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() throws java.io.IOException {
        /*
            r9 = this;
            android.content.Context r0 = r9.f396b     // Catch: java.io.FileNotFoundException -> Lc4
            java.lang.String r1 = r9.c     // Catch: java.io.FileNotFoundException -> Lc4
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch: java.io.FileNotFoundException -> Lc4
            org.xmlpull.v1.XmlPullParser r1 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "UTF-8"
            r1.setInput(r0, r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2 = 0
        L12:
            r3 = 1
            if (r2 == r3) goto L1d
            r4 = 2
            if (r2 == r4) goto L1d
            int r2 = r1.next()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            goto L12
        L1d:
            java.lang.String r2 = "historical-records"
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r2 == 0) goto L7a
            java.util.List<androidx.appcompat.widget.d$c> r2 = r9.i     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2.clear()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L2e:
            int r4 = r1.next()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r4 != r3) goto L3b
            if (r0 == 0) goto Lbd
        L36:
            r0.close()     // Catch: java.io.IOException -> Lbd
            goto Lbd
        L3b:
            r5 = 3
            if (r4 == r5) goto L2e
            r5 = 4
            if (r4 != r5) goto L42
            goto L2e
        L42:
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r5 = "historical-record"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r4 == 0) goto L72
            java.lang.String r4 = "activity"
            r5 = 0
            java.lang.String r4 = r1.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r6 = "time"
            java.lang.String r6 = r1.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r8 = "weight"
            java.lang.String r5 = r1.getAttributeValue(r5, r8)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            float r5 = java.lang.Float.parseFloat(r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            androidx.appcompat.widget.d$c r8 = new androidx.appcompat.widget.d$c     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r8.<init>(r4, r6, r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2.add(r8)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            goto L2e
        L72:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "Share records file not well-formed."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            throw r1     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L7a:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "Share records file does not start with historical-records tag."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            throw r1     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L82:
            r1 = move-exception
            goto Lbe
        L84:
            r1 = move-exception
            java.lang.String r2 = androidx.appcompat.widget.d.f395a     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r9.c     // Catch: java.lang.Throwable -> L82
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto Lbd
            goto L36
        La0:
            r1 = move-exception
            java.lang.String r2 = androidx.appcompat.widget.d.f395a     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r9.c     // Catch: java.lang.Throwable -> L82
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto Lbd
            goto L36
        Lbd:
            return
        Lbe:
            if (r0 == 0) goto Lc3
            r0.close()     // Catch: java.io.IOException -> Lc3
        Lc3:
            throw r1
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d.i():void");
    }

    /* compiled from: ActivityChooserModel.java */
    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) throws IOException {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = d.this.f396b.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                            xmlSerializerNewSerializer.startDocument("UTF-8", true);
                            xmlSerializerNewSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                c cVar = (c) list.remove(0);
                                xmlSerializerNewSerializer.startTag(null, "historical-record");
                                xmlSerializerNewSerializer.attribute(null, "activity", cVar.f399a.flattenToString());
                                xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(cVar.f400b));
                                xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(cVar.c));
                                xmlSerializerNewSerializer.endTag(null, "historical-record");
                            }
                            xmlSerializerNewSerializer.endTag(null, "historical-records");
                            xmlSerializerNewSerializer.endDocument();
                            d.this.d = true;
                        } catch (Throwable th) {
                            d.this.d = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IllegalStateException e) {
                        Log.e(d.f395a, "Error writing historical record file: " + d.this.c, e);
                        d.this.d = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                } catch (IOException e2) {
                    Log.e(d.f395a, "Error writing historical record file: " + d.this.c, e2);
                    d.this.d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                } catch (IllegalArgumentException e3) {
                    Log.e(d.f395a, "Error writing historical record file: " + d.this.c, e3);
                    d.this.d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            } catch (FileNotFoundException e4) {
                Log.e(d.f395a, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }
}
