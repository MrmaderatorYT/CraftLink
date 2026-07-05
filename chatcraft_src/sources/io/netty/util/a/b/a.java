package io.netty.util.a.b;

import io.netty.util.a.p;
import java.io.Serializable;

/* compiled from: AbstractInternalLogger.java */
/* loaded from: classes.dex */
public abstract class a implements c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final String f4645a;

    protected a(String str) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        this.f4645a = str;
    }

    public String a() {
        return this.f4645a;
    }

    public String toString() {
        return p.a(this) + '(' + a() + ')';
    }
}
