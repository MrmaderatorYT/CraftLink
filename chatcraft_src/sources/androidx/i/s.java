package androidx.i;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public View f866b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f865a = new HashMap();
    final ArrayList<m> c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f866b == sVar.f866b && this.f865a.equals(sVar.f865a);
    }

    public int hashCode() {
        return (this.f866b.hashCode() * 31) + this.f865a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f866b + "\n") + "    values:";
        for (String str2 : this.f865a.keySet()) {
            str = str + "    " + str2 + ": " + this.f865a.get(str2) + "\n";
        }
        return str;
    }
}
