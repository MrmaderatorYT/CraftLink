package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BinaryImagesConverter.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1336a;

    /* renamed from: b, reason: collision with root package name */
    private final a f1337b;

    /* compiled from: BinaryImagesConverter.java */
    interface a {
        String a(File file);
    }

    c(Context context, a aVar) {
        this.f1336a = context;
        this.f1337b = aVar;
    }

    byte[] a(String str) {
        return a(b(str));
    }

    byte[] a(BufferedReader bufferedReader) {
        return a(b(bufferedReader));
    }

    private JSONArray b(BufferedReader bufferedReader) throws IOException {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return jSONArray;
            }
            JSONObject jSONObjectC = c(line);
            if (jSONObjectC != null) {
                jSONArray.put(jSONObjectC);
            }
        }
    }

    private JSONArray b(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str2 : b(new JSONObject(str).getJSONArray("maps")).split("\\|")) {
                JSONObject jSONObjectC = c(str2);
                if (jSONObjectC != null) {
                    jSONArray.put(jSONObjectC);
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Unable to parse proc maps string", e);
            return jSONArray;
        }
    }

    private JSONObject c(String str) {
        ak akVarA = al.a(str);
        if (akVarA == null || !a(akVarA)) {
            return null;
        }
        try {
            try {
                return a(this.f1337b.a(d(akVarA.d)), akVarA);
            } catch (JSONException e) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not create a binary image json string", e);
                return null;
            }
        } catch (IOException e2) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not generate ID for file " + akVarA.d, e2);
            return null;
        }
    }

    private File d(String str) {
        File file = new File(str);
        return !file.exists() ? a(file) : file;
    }

    private File a(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith("/data")) {
            return file;
        }
        try {
            return new File(this.f1336a.getPackageManager().getApplicationInfo(this.f1336a.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error getting ApplicationInfo", e);
            return file;
        }
    }

    private static byte[] a(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Binary images string is null", e);
            return new byte[0];
        }
    }

    private static JSONObject a(String str, ak akVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", akVar.f1307a);
        jSONObject.put("size", akVar.f1308b);
        jSONObject.put("name", akVar.d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static String b(JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    private static boolean a(ak akVar) {
        return (akVar.c.indexOf(120) == -1 || akVar.d.indexOf(47) == -1) ? false : true;
    }
}
