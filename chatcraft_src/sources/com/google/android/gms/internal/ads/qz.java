package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class qz extends hb {

    /* renamed from: a, reason: collision with root package name */
    private final tb f3410a;

    /* renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f3411b;

    public qz() {
        this(null);
    }

    private qz(tb tbVar) {
        this(null, null);
    }

    private qz(tb tbVar, SSLSocketFactory sSLSocketFactory) {
        this.f3410a = null;
        this.f3411b = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2 A[Catch: all -> 0x0127, TryCatch #1 {all -> 0x0127, blocks: (B:14:0x006a, B:15:0x0072, B:17:0x0078, B:18:0x0088, B:19:0x008c, B:20:0x008f, B:53:0x0121, B:54:0x0126, B:21:0x0093, B:22:0x009c, B:23:0x00a2, B:24:0x00a8, B:25:0x00ae, B:26:0x00b4, B:27:0x00bd, B:28:0x00c6, B:29:0x00cb, B:31:0x00d2, B:44:0x00ee, B:51:0x0119, B:52:0x0120), top: B:61:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0119 A[Catch: all -> 0x0127, TRY_ENTER, TryCatch #1 {all -> 0x0127, blocks: (B:14:0x006a, B:15:0x0072, B:17:0x0078, B:18:0x0088, B:19:0x008c, B:20:0x008f, B:53:0x0121, B:54:0x0126, B:21:0x0093, B:22:0x009c, B:23:0x00a2, B:24:0x00a8, B:25:0x00ae, B:26:0x00b4, B:27:0x00bd, B:28:0x00c6, B:29:0x00cb, B:31:0x00d2, B:44:0x00ee, B:51:0x0119, B:52:0x0120), top: B:61:0x006a }] */
    @Override // com.google.android.gms.internal.ads.hb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.ox a(com.google.android.gms.internal.ads.blc<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qz.a(com.google.android.gms.internal.ads.blc, java.util.Map):com.google.android.gms.internal.ads.ox");
    }

    private static List<bfd> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new bfd(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void a(HttpURLConnection httpURLConnection, blc<?> blcVar) {
        byte[] bArrA = blcVar.a();
        if (bArrA != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                String strValueOf = String.valueOf("UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", strValueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(strValueOf) : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrA);
            dataOutputStream.close();
        }
    }
}
