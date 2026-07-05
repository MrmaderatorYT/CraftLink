package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@qj
/* loaded from: classes.dex */
public final class ahg extends MutableContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Activity f1975a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1976b;
    private Context c;

    public ahg(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        this.f1976b = context.getApplicationContext();
        this.f1975a = context instanceof Activity ? (Activity) context : null;
        this.c = context;
        super.setBaseContext(this.f1976b);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        if (this.f1975a != null) {
            this.f1975a.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            this.f1976b.startActivity(intent);
        }
    }

    public final Activity a() {
        return this.f1975a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.c.getSystemService(str);
    }

    public final Context b() {
        return this.c;
    }
}
