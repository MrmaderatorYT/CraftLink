package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
final class bhc implements bjo<Long> {
    private bhc() {
    }

    private static Long b(Uri uri, InputStream inputStream) throws IOException {
        String line = new BufferedReader(new InputStreamReader(inputStream)).readLine();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return Long.valueOf(simpleDateFormat.parse(line).getTime());
        } catch (ParseException e) {
            throw new zzfx(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.bjo
    public final /* synthetic */ Long a(Uri uri, InputStream inputStream) {
        return b(uri, inputStream);
    }

    /* synthetic */ bhc(bgz bgzVar) {
        this();
    }
}
