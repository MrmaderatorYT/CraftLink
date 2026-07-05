package androidx.core.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final String f565a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f566b;
    private final CharSequence[] c;
    private final boolean d;
    private final Bundle e;
    private final Set<String> f;

    public String a() {
        return this.f565a;
    }

    public CharSequence b() {
        return this.f566b;
    }

    public CharSequence[] c() {
        return this.c;
    }

    public Set<String> d() {
        return this.f;
    }

    public boolean e() {
        return this.d;
    }

    public Bundle f() {
        return this.e;
    }

    static RemoteInput[] a(k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[kVarArr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            remoteInputArr[i] = a(kVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(k kVar) {
        return new RemoteInput.Builder(kVar.a()).setLabel(kVar.b()).setChoices(kVar.c()).setAllowFreeFormInput(kVar.e()).addExtras(kVar.f()).build();
    }
}
