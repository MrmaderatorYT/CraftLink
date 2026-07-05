package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.axe;
import com.google.android.gms.internal.ads.bra;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class av extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ar f1531a;

    private av(ar arVar) {
        this.f1531a = arVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        try {
            this.f1531a.h = (axe) this.f1531a.c.get(((Long) bra.e().a(com.google.android.gms.internal.ads.o.bS)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            aan.c(BuildConfig.FLAVOR, e);
        }
        return this.f1531a.c();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        if (this.f1531a.f == null || str2 == null) {
            return;
        }
        this.f1531a.f.loadUrl(str2);
    }

    /* synthetic */ av(ar arVar, as asVar) {
        this(arVar);
    }
}
