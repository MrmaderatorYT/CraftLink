package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.InputStream;

/* compiled from: ContentStreamRequestHandler.java */
/* loaded from: classes.dex */
class g extends y {

    /* renamed from: a, reason: collision with root package name */
    final Context f4123a;

    g(Context context) {
        this.f4123a = context;
    }

    @Override // com.squareup.picasso.y
    public boolean a(w wVar) {
        return "content".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a a(w wVar, int i) {
        return new y.a(b.l.a(b(wVar)), t.d.DISK);
    }

    InputStream b(w wVar) {
        return this.f4123a.getContentResolver().openInputStream(wVar.d);
    }
}
