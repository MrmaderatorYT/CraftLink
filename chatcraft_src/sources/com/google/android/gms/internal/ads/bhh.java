package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
final class bhh implements bjo<Long> {
    private bhh() {
    }

    @Override // com.google.android.gms.internal.ads.bjo
    public final /* synthetic */ Long a(Uri uri, InputStream inputStream) {
        return Long.valueOf(bkg.e(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }

    /* synthetic */ bhh(bgz bgzVar) {
        this();
    }
}
