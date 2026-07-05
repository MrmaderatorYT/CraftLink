package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<d<?>> f3187a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Collection<d<String>> f3188b = new ArrayList();
    private final Collection<d<String>> c = new ArrayList();

    public final void a(d dVar) {
        this.f3187a.add(dVar);
    }

    public final void b(d<String> dVar) {
        this.f3188b.add(dVar);
    }

    public final void c(d<String> dVar) {
        this.c.add(dVar);
    }

    public final void a(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (d<?> dVar : this.f3187a) {
            if (dVar.c() == 1) {
                dVar.a(editor, (SharedPreferences.Editor) dVar.a(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            aan.c("Flag Json is null.");
        }
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<d<String>> it = this.f3188b.iterator();
        while (it.hasNext()) {
            String str = (String) bra.e().a(it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> b() {
        List<String> listA = a();
        Iterator<d<String>> it = this.c.iterator();
        while (it.hasNext()) {
            String str = (String) bra.e().a(it.next());
            if (str != null) {
                listA.add(str);
            }
        }
        return listA;
    }
}
