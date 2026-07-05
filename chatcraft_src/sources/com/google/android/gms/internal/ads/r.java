package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f3413b;
    private String e;
    private Context f;
    private String g;
    private AtomicBoolean h;
    private File i;

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<ac> f3412a = new ArrayBlockingQueue(100);
    private LinkedHashMap<String, String> c = new LinkedHashMap<>();
    private Map<String, v> d = new HashMap();

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.f = context;
        this.g = str;
        this.e = str2;
        this.h = new AtomicBoolean(false);
        this.h.set(((Boolean) bra.e().a(o.M)).booleanValue());
        if (this.h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.c.put(entry.getKey(), entry.getValue());
        }
        this.f3413b = Executors.newSingleThreadExecutor();
        this.f3413b.execute(new s(this));
        this.d.put("action", v.f3512b);
        this.d.put("ad_format", v.f3512b);
        this.d.put("e", v.c);
    }

    public final void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.c.put("e", TextUtils.join(",", list));
    }

    public final boolean a(ac acVar) {
        return this.f3412a.offer(acVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() throws Throwable {
        FileOutputStream fileOutputStream;
        while (true) {
            try {
                ac acVarTake = this.f3412a.take();
                String strB = acVarTake.b();
                if (!TextUtils.isEmpty(strB)) {
                    Map<String, String> mapA = a(this.c, acVarTake.c());
                    Uri.Builder builderBuildUpon = Uri.parse(this.e).buildUpon();
                    for (Map.Entry<String, String> entry : mapA.entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    String str = builderBuildUpon.build().toString() + "&it=" + strB;
                    if (this.h.get()) {
                        File file = this.i;
                        if (file != null) {
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(file, true);
                                } catch (IOException e) {
                                    e = e;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileOutputStream.write(str.getBytes());
                                fileOutputStream.write(10);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    xe.c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream2 = fileOutputStream;
                                xe.c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e4) {
                                        xe.c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e5) {
                                        xe.c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            xe.e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        com.google.android.gms.ads.internal.ax.e();
                        xn.a(this.f, this.g, str);
                    }
                }
            } catch (InterruptedException e6) {
                xe.c("CsiReporter:reporter interrupted", e6);
                return;
            }
        }
    }

    final Map<String, String> a(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, a(key).a((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public final v a(String str) {
        v vVar = this.d.get(str);
        return vVar != null ? vVar : v.f3511a;
    }
}
