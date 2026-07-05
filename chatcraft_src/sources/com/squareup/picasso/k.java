package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* compiled from: FileRequestHandler.java */
/* loaded from: classes.dex */
class k extends g {
    k(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public boolean a(w wVar) {
        return "file".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.g, com.squareup.picasso.y
    public y.a a(w wVar, int i) {
        return new y.a(null, b.l.a(b(wVar)), t.d.DISK, a(wVar.d));
    }

    static int a(Uri uri) {
        return new androidx.e.a.a(uri.getPath()).a("Orientation", 1);
    }
}
