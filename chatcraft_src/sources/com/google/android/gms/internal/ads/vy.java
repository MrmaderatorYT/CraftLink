package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
@TargetApi(21)
/* loaded from: classes.dex */
final class vy {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f3530a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3531b;
    private final List<String> c;
    private final vk d;

    vy(Context context, List<String> list, vk vkVar) {
        this.f3531b = context;
        this.c = list;
        this.d = vkVar;
    }

    final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        String strValueOf;
        String strValueOf2;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.c.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    break;
                }
                strValueOf = String.valueOf("android.webkit.resource.");
                strValueOf2 = String.valueOf(next);
            } while (!(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).equals(str));
            z2 = true;
            if (z2) {
                if (f3530a.containsKey(str)) {
                    com.google.android.gms.ads.internal.ax.e();
                    if (!xn.a(this.f3531b, f3530a.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.d.c(str);
                }
            } else {
                this.d.b(str);
            }
        }
        return arrayList;
    }

    static {
        HashMap map = new HashMap();
        if (com.google.android.gms.common.util.j.h()) {
            map.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            map.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f3530a = map;
    }
}
