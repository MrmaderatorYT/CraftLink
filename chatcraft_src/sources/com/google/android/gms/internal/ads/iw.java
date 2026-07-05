package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class iw implements he, iv {

    /* renamed from: a, reason: collision with root package name */
    private final iu f3183a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.ac<? super iu>>> f3184b = new HashSet<>();

    public iw(iu iuVar) {
        this.f3183a = iuVar;
    }

    @Override // com.google.android.gms.internal.ads.he
    public final void a(String str, String str2) {
        hf.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, Map map) {
        hf.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.he, com.google.android.gms.internal.ads.gv
    public final void a(String str, JSONObject jSONObject) {
        hf.b(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void b(String str, JSONObject jSONObject) {
        hf.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.he, com.google.android.gms.internal.ads.hu
    public final void d(String str) {
        this.f3183a.d(str);
    }

    @Override // com.google.android.gms.internal.ads.iu
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super iu> acVar) {
        this.f3183a.a(str, acVar);
        this.f3184b.add(new AbstractMap.SimpleEntry<>(str, acVar));
    }

    @Override // com.google.android.gms.internal.ads.iu
    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super iu> acVar) {
        this.f3183a.b(str, acVar);
        this.f3184b.remove(new AbstractMap.SimpleEntry(str, acVar));
    }

    @Override // com.google.android.gms.internal.ads.iv
    public final void a() {
        Iterator<AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.ac<? super iu>>> it = this.f3184b.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, com.google.android.gms.ads.internal.gmsg.ac<? super iu>> next = it.next();
            String strValueOf = String.valueOf(next.getValue().toString());
            xe.a(strValueOf.length() != 0 ? "Unregistering eventhandler: ".concat(strValueOf) : new String("Unregistering eventhandler: "));
            this.f3183a.b(next.getKey(), next.getValue());
        }
        this.f3184b.clear();
    }
}
