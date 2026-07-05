package androidx.i;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class ak implements al {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f818a;

    ak(View view) {
        this.f818a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ak) && ((ak) obj).f818a.equals(this.f818a);
    }

    public int hashCode() {
        return this.f818a.hashCode();
    }
}
