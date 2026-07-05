package androidx.core.d;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.b.e;
import androidx.b.g;
import androidx.core.a.a.f;
import androidx.core.d.c;
import androidx.core.graphics.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final e<String, Typeface> f571a = new e<>(16);
    private static final androidx.core.d.c d = new androidx.core.d.c("fonts", 10, 10000);

    /* renamed from: b, reason: collision with root package name */
    static final Object f572b = new Object();
    static final g<String, ArrayList<c.a<c>>> c = new g<>();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() { // from class: androidx.core.d.b.4
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    static c a(Context context, androidx.core.d.a aVar, int i) {
        try {
            a aVarA = a(context, (CancellationSignal) null, aVar);
            if (aVarA.a() == 0) {
                Typeface typefaceA = androidx.core.graphics.c.a(context, null, aVarA.b(), i);
                return new c(typefaceA, typefaceA != null ? 0 : -3);
            }
            return new c(null, aVarA.a() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    /* compiled from: FontsContractCompat.java */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f582a;

        /* renamed from: b, reason: collision with root package name */
        final int f583b;

        c(Typeface typeface, int i) {
            this.f582a = typeface;
            this.f583b = i;
        }
    }

    public static Typeface a(final Context context, final androidx.core.d.a aVar, final f.a aVar2, final Handler handler, boolean z, int i, final int i2) {
        final String str = aVar.f() + "-" + i2;
        Typeface typefaceA = f571a.a((e<String, Typeface>) str);
        if (typefaceA != null) {
            if (aVar2 != null) {
                aVar2.a(typefaceA);
            }
            return typefaceA;
        }
        if (z && i == -1) {
            c cVarA = a(context, aVar, i2);
            if (aVar2 != null) {
                if (cVarA.f583b == 0) {
                    aVar2.a(cVarA.f582a, handler);
                } else {
                    aVar2.a(cVarA.f583b, handler);
                }
            }
            return cVarA.f582a;
        }
        Callable<c> callable = new Callable<c>() { // from class: androidx.core.d.b.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c call() {
                c cVarA2 = b.a(context, aVar, i2);
                if (cVarA2.f582a != null) {
                    b.f571a.a(str, cVarA2.f582a);
                }
                return cVarA2;
            }
        };
        if (z) {
            try {
                return ((c) d.a(callable, i)).f582a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        c.a<c> aVar3 = aVar2 == null ? null : new c.a<c>() { // from class: androidx.core.d.b.2
            @Override // androidx.core.d.c.a
            public void a(c cVar) {
                if (cVar == null) {
                    aVar2.a(1, handler);
                } else if (cVar.f583b == 0) {
                    aVar2.a(cVar.f582a, handler);
                } else {
                    aVar2.a(cVar.f583b, handler);
                }
            }
        };
        synchronized (f572b) {
            if (c.containsKey(str)) {
                if (aVar3 != null) {
                    c.get(str).add(aVar3);
                }
                return null;
            }
            if (aVar3 != null) {
                ArrayList<c.a<c>> arrayList = new ArrayList<>();
                arrayList.add(aVar3);
                c.put(str, arrayList);
            }
            d.a(callable, new c.a<c>() { // from class: androidx.core.d.b.3
                @Override // androidx.core.d.c.a
                public void a(c cVar) {
                    synchronized (b.f572b) {
                        ArrayList<c.a<c>> arrayList2 = b.c.get(str);
                        if (arrayList2 == null) {
                            return;
                        }
                        b.c.remove(str);
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            arrayList2.get(i3).a(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.d.b$b, reason: collision with other inner class name */
    public static class C0036b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f580a;

        /* renamed from: b, reason: collision with root package name */
        private final int f581b;
        private final int c;
        private final boolean d;
        private final int e;

        public C0036b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f580a = (Uri) androidx.core.f.e.a(uri);
            this.f581b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.f580a;
        }

        public int b() {
            return this.f581b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f578a;

        /* renamed from: b, reason: collision with root package name */
        private final C0036b[] f579b;

        public a(int i, C0036b[] c0036bArr) {
            this.f578a = i;
            this.f579b = c0036bArr;
        }

        public int a() {
            return this.f578a;
        }

        public C0036b[] b() {
            return this.f579b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0036b[] c0036bArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (C0036b c0036b : c0036bArr) {
            if (c0036b.e() == 0) {
                Uri uriA = c0036b.a();
                if (!map.containsKey(uriA)) {
                    map.put(uriA, i.a(context, cancellationSignal, uriA));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.d.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoA = a(context.getPackageManager(), aVar, context.getResources());
        if (providerInfoA == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, providerInfoA.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, androidx.core.d.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strA = aVar.a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strA, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strA);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(aVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strA + ", but package was not " + aVar.b());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, e);
        List<List<byte[]>> listA2 = a(aVar, resources);
        for (int i = 0; i < listA2.size(); i++) {
            ArrayList arrayList = new ArrayList(listA2.get(i));
            Collections.sort(arrayList, e);
            if (a(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    private static List<List<byte[]>> a(androidx.core.d.a aVar, Resources resources) {
        if (aVar.d() != null) {
            return aVar.d();
        }
        return androidx.core.a.a.c.a(resources, aVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    static C0036b[] a(Context context, androidx.core.d.a aVar, String str, CancellationSignal cancellationSignal) {
        Cursor cursorQuery;
        Uri uriWithAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal);
            } else {
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null);
            }
            cursor = cursorQuery;
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursor.getLong(columnIndex2));
                    } else {
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new C0036b(uriWithAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0036b[]) arrayList.toArray(new C0036b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
