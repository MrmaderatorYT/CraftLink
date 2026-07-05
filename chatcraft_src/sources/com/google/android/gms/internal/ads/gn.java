package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class gn {

    /* renamed from: a, reason: collision with root package name */
    private final Map<go, gp> f3102a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList<go> f3103b = new LinkedList<>();
    private fi c;

    final void a(fi fiVar) {
        if (this.c == null) {
            this.c = fiVar.b();
            if (this.c != null) {
                SharedPreferences sharedPreferences = this.c.a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.f3103b.size() > 0) {
                    go goVarRemove = this.f3103b.remove();
                    gp gpVar = this.f3102a.get(goVarRemove);
                    a("Flushing interstitial queue for %s.", goVarRemove);
                    while (gpVar.d() > 0) {
                        gpVar.a((bqj) null).f3107a.I();
                    }
                    this.f3102a.remove(goVarRemove);
                }
                try {
                    HashMap map = new HashMap();
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        if (!entry.getKey().equals("PoolKeys")) {
                            gt gtVarA = gt.a((String) entry.getValue());
                            go goVar = new go(gtVarA.f3113a, gtVarA.f3114b, gtVarA.c);
                            if (!this.f3102a.containsKey(goVar)) {
                                this.f3102a.put(goVar, new gp(gtVarA.f3113a, gtVarA.f3114b, gtVarA.c));
                                map.put(goVar.toString(), goVar);
                                a("Restored interstitial queue for %s.", goVar);
                            }
                        }
                    }
                    for (String str : a(sharedPreferences.getString("PoolKeys", BuildConfig.FLAVOR))) {
                        go goVar2 = (go) map.get(str);
                        if (this.f3102a.containsKey(goVar2)) {
                            this.f3103b.add(goVar2);
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    com.google.android.gms.ads.internal.ax.i().a(e, "InterstitialAdPool.restore");
                    xe.c("Malformed preferences value for InterstitialAdPool.", e);
                    this.f3102a.clear();
                    this.f3103b.clear();
                }
            }
        }
    }

    final gq a(bqj bqjVar, String str) {
        if (b(str)) {
            return null;
        }
        int i = new tc(this.c.a()).a().o;
        bqj bqjVarC = c(bqjVar);
        String strC = c(str);
        go goVar = new go(bqjVarC, strC, i);
        gp gpVar = this.f3102a.get(goVar);
        if (gpVar == null) {
            a("Interstitial pool created at %s.", goVar);
            gpVar = new gp(bqjVarC, strC, i);
            this.f3102a.put(goVar, gpVar);
        }
        this.f3103b.remove(goVar);
        this.f3103b.add(goVar);
        gpVar.g();
        while (this.f3103b.size() > ((Integer) bra.e().a(o.aG)).intValue()) {
            go goVarRemove = this.f3103b.remove();
            gp gpVar2 = this.f3102a.get(goVarRemove);
            a("Evicting interstitial queue for %s.", goVarRemove);
            while (gpVar2.d() > 0) {
                gq gqVarA = gpVar2.a((bqj) null);
                if (gqVarA.e) {
                    gr.a().c();
                }
                gqVarA.f3107a.I();
            }
            this.f3102a.remove(goVarRemove);
        }
        while (gpVar.d() > 0) {
            gq gqVarA2 = gpVar.a(bqjVarC);
            if (gqVarA2.e) {
                if (com.google.android.gms.ads.internal.ax.l().a() - gqVarA2.d > ((Integer) bra.e().a(o.aI)).intValue() * 1000) {
                    a("Expired interstitial at %s.", goVar);
                    gr.a().b();
                }
            }
            String str2 = gqVarA2.f3108b != null ? " (inline) " : " ";
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 34);
            sb.append("Pooled interstitial");
            sb.append(str2);
            sb.append("returned at %s.");
            a(sb.toString(), goVar);
            return gqVarA2;
        }
        return null;
    }

    final void b(bqj bqjVar, String str) {
        if (this.c == null) {
            return;
        }
        int i = new tc(this.c.a()).a().o;
        bqj bqjVarC = c(bqjVar);
        String strC = c(str);
        go goVar = new go(bqjVarC, strC, i);
        gp gpVar = this.f3102a.get(goVar);
        if (gpVar == null) {
            a("Interstitial pool created at %s.", goVar);
            gpVar = new gp(bqjVarC, strC, i);
            this.f3102a.put(goVar, gpVar);
        }
        gpVar.a(this.c, bqjVar);
        gpVar.g();
        a("Inline entry added to the queue at %s.", goVar);
    }

    final void a() {
        int iD;
        int iE;
        if (this.c == null) {
            return;
        }
        for (Map.Entry<go, gp> entry : this.f3102a.entrySet()) {
            go key = entry.getKey();
            gp value = entry.getValue();
            if (xe.a(2) && (iE = value.e()) < (iD = value.d())) {
                xe.a(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(iD - iE), Integer.valueOf(iD), key));
            }
            int iF = value.f() + 0;
            while (value.d() < ((Integer) bra.e().a(o.aH)).intValue()) {
                a("Pooling and loading one new interstitial for %s.", key);
                if (value.a(this.c)) {
                    iF++;
                }
            }
            gr.a().a(iF);
        }
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            editorEdit.clear();
            for (Map.Entry<go, gp> entry2 : this.f3102a.entrySet()) {
                go key2 = entry2.getKey();
                gp value2 = entry2.getValue();
                if (value2.h()) {
                    editorEdit.putString(key2.toString(), new gt(value2).a());
                    a("Saved interstitial queue for %s.", key2);
                }
            }
            editorEdit.putString("PoolKeys", b());
            editorEdit.apply();
        }
    }

    private final String b() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<go> it = this.f3103b.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException unused) {
            return BuildConfig.FLAVOR;
        }
    }

    private static String[] a(String str) {
        try {
            String[] strArrSplit = str.split("\u0000");
            for (int i = 0; i < strArrSplit.length; i++) {
                strArrSplit[i] = new String(Base64.decode(strArrSplit[i], 0), "UTF-8");
            }
            return strArrSplit;
        } catch (UnsupportedEncodingException unused) {
            return new String[0];
        }
    }

    private static boolean b(String str) {
        try {
            return Pattern.matches((String) bra.e().a(o.aJ), str);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static Set<String> a(bqj bqjVar) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(bqjVar.c.keySet());
        Bundle bundle = bqjVar.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    static bqj b(bqj bqjVar) {
        bqj bqjVarD = d(bqjVar);
        Bundle bundle = bqjVarD.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        bqjVarD.c.putBoolean("_skipMediation", true);
        return bqjVarD;
    }

    private static bqj c(bqj bqjVar) {
        bqj bqjVarD = d(bqjVar);
        for (String str : ((String) bra.e().a(o.aF)).split(",")) {
            a(bqjVarD.m, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                a(bqjVarD.c, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", BuildConfig.FLAVOR));
            }
        }
        return bqjVarD;
    }

    private static String c(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        } catch (RuntimeException unused) {
        }
        return str;
    }

    private static bqj d(bqj bqjVar) {
        Parcel parcelObtain = Parcel.obtain();
        bqjVar.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        bqj bqjVarCreateFromParcel = bqj.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return bqjVarCreateFromParcel.a();
    }

    private static void a(Bundle bundle, String str) {
        while (true) {
            String[] strArrSplit = str.split("/", 2);
            if (strArrSplit.length == 0) {
                return;
            }
            String str2 = strArrSplit[0];
            if (strArrSplit.length == 1) {
                bundle.remove(str2);
                return;
            }
            bundle = bundle.getBundle(str2);
            if (bundle == null) {
                return;
            } else {
                str = strArrSplit[1];
            }
        }
    }

    private static void a(String str, go goVar) {
        if (xe.a(2)) {
            xe.a(String.format(str, goVar));
        }
    }
}
