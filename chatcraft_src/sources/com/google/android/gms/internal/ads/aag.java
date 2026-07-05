package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@qj
/* loaded from: classes.dex */
public final class aag {

    /* renamed from: a, reason: collision with root package name */
    private static Object f1781a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1782b = false;
    private static boolean c = false;
    private static com.google.android.gms.common.util.c d = com.google.android.gms.common.util.f.d();
    private static final Set<String> e = new HashSet(Arrays.asList(new String[0]));
    private final List<String> f;

    public aag() {
        this(null);
    }

    public aag(String str) {
        List<String> listAsList;
        if (!c()) {
            listAsList = new ArrayList<>();
        } else {
            String string = UUID.randomUUID().toString();
            if (str == null) {
                String[] strArr = new String[1];
                String strValueOf = String.valueOf(string);
                strArr[0] = strValueOf.length() != 0 ? "network_request_".concat(strValueOf) : new String("network_request_");
                listAsList = Arrays.asList(strArr);
            } else {
                String[] strArr2 = new String[2];
                String strValueOf2 = String.valueOf(str);
                strArr2[0] = strValueOf2.length() != 0 ? "ad_request_".concat(strValueOf2) : new String("ad_request_");
                String strValueOf3 = String.valueOf(string);
                strArr2[1] = strValueOf3.length() != 0 ? "network_request_".concat(strValueOf3) : new String("network_request_");
                listAsList = Arrays.asList(strArr2);
            }
        }
        this.f = listAsList;
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (c()) {
            b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void a(String str, String str2, Map<String, ?> map, byte[] bArr) throws IOException {
        if (c()) {
            b(str, str2, map, bArr);
        }
    }

    private final void b(final String str, final String str2, final Map<String, ?> map, final byte[] bArr) throws IOException {
        a("onNetworkRequest", new aam(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.aah

            /* renamed from: a, reason: collision with root package name */
            private final String f1783a;

            /* renamed from: b, reason: collision with root package name */
            private final String f1784b;
            private final Map c;
            private final byte[] d;

            {
                this.f1783a = str;
                this.f1784b = str2;
                this.c = map;
                this.d = bArr;
            }

            @Override // com.google.android.gms.internal.ads.aam
            public final void a(JsonWriter jsonWriter) throws IOException {
                aag.a(this.f1783a, this.f1784b, this.c, this.d, jsonWriter);
            }
        });
    }

    public final void a(HttpURLConnection httpURLConnection, int i) {
        String responseMessage;
        if (c()) {
            b(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String strValueOf = String.valueOf(e2.getMessage());
                    aan.e(strValueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(strValueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                    responseMessage = null;
                }
                b(responseMessage);
            }
        }
    }

    public final void a(Map<String, ?> map, int i) throws IOException {
        if (c()) {
            b(map, i);
            if (i < 200 || i >= 300) {
                b(null);
            }
        }
    }

    private final void b(final Map<String, ?> map, final int i) throws IOException {
        a("onNetworkResponse", new aam(i, map) { // from class: com.google.android.gms.internal.ads.aai

            /* renamed from: a, reason: collision with root package name */
            private final int f1785a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f1786b;

            {
                this.f1785a = i;
                this.f1786b = map;
            }

            @Override // com.google.android.gms.internal.ads.aam
            public final void a(JsonWriter jsonWriter) throws IOException {
                aag.a(this.f1785a, this.f1786b, jsonWriter);
            }
        });
    }

    public final void a(String str) throws IOException {
        if (c() && str != null) {
            a(str.getBytes());
        }
    }

    public final void a(final byte[] bArr) throws IOException {
        a("onNetworkResponseBody", new aam(bArr) { // from class: com.google.android.gms.internal.ads.aak

            /* renamed from: a, reason: collision with root package name */
            private final byte[] f1787a;

            {
                this.f1787a = bArr;
            }

            @Override // com.google.android.gms.internal.ads.aam
            public final void a(JsonWriter jsonWriter) throws NoSuchAlgorithmException, IOException {
                aag.a(this.f1787a, jsonWriter);
            }
        });
    }

    private final void b(final String str) throws IOException {
        a("onNetworkRequestError", new aam(str) { // from class: com.google.android.gms.internal.ads.aal

            /* renamed from: a, reason: collision with root package name */
            private final String f1788a;

            {
                this.f1788a = str;
            }

            @Override // com.google.android.gms.internal.ads.aam
            public final void a(JsonWriter jsonWriter) throws IOException {
                aag.a(this.f1788a, jsonWriter);
            }
        });
    }

    private static void a(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!e.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    aan.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void a(String str, aam aamVar) throws IOException {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(d.a());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.f.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            aamVar.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            aan.b("unable to log", e2);
        }
        c(stringWriter.toString());
    }

    private static synchronized void c(String str) {
        aan.d("GMA Debug BEGIN");
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 4000;
            String strValueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
            aan.d(strValueOf.length() != 0 ? "GMA Debug CONTENT ".concat(strValueOf) : new String("GMA Debug CONTENT "));
            i = i2;
        }
        aan.d("GMA Debug FINISH");
    }

    public static void a() {
        synchronized (f1781a) {
            f1782b = false;
            c = false;
            aan.e("Ad debug logging enablement is out of date.");
        }
    }

    public static void a(boolean z) {
        synchronized (f1781a) {
            f1782b = true;
            c = z;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f1781a) {
            z = f1782b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (f1781a) {
            z = f1782b && c;
        }
        return z;
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) bra.e().a(o.aQ)).booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e2) {
            aan.c("Fail to determine debug setting.", e2);
            return false;
        }
    }

    static final /* synthetic */ void a(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(byte[] bArr, JsonWriter jsonWriter) throws NoSuchAlgorithmException, IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String strA = com.google.android.gms.common.util.a.a(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(strA);
        } else {
            String strA2 = aac.a(strA);
            if (strA2 != null) {
                jsonWriter.name("bodydigest").value(strA2);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        a(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(com.google.android.gms.common.util.a.a(bArr));
        }
        jsonWriter.endObject();
    }
}
