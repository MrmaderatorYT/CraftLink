package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.g;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1732a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1733b;

    public j(Context context) {
        i.a(context);
        this.f1732a = context.getResources();
        this.f1733b = this.f1732a.getResourcePackageName(g.a.common_google_play_services_unknown_issue);
    }

    @Nullable
    public String a(String str) {
        int identifier = this.f1732a.getIdentifier(str, "string", this.f1733b);
        if (identifier == 0) {
            return null;
        }
        return this.f1732a.getString(identifier);
    }
}
