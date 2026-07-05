package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import org.json.JSONException;

/* loaded from: classes.dex */
final class nb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3292a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3293b;
    private final /* synthetic */ na c;

    nb(na naVar, String str, String str2) {
        this.c = naVar;
        this.f3292a = str;
        this.f3293b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) throws JSONException {
        DownloadManager downloadManager = (DownloadManager) this.c.f3291b.getSystemService("download");
        try {
            String str = this.f3292a;
            String str2 = this.f3293b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.ax.g().a(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.c.a("Could not store picture.");
        }
    }
}
