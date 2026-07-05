package com.crashlytics.android.c;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;

/* compiled from: CrashPromptDialog.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private final b f1349a;

    /* renamed from: b, reason: collision with root package name */
    private final AlertDialog.Builder f1350b;

    /* compiled from: CrashPromptDialog.java */
    interface a {
        void a(boolean z);
    }

    private static int a(float f, int i) {
        return (int) (f * i);
    }

    /* compiled from: CrashPromptDialog.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1355a;

        /* renamed from: b, reason: collision with root package name */
        private final CountDownLatch f1356b;

        private b() {
            this.f1355a = false;
            this.f1356b = new CountDownLatch(1);
        }

        void a(boolean z) {
            this.f1355a = z;
            this.f1356b.countDown();
        }

        boolean a() {
            return this.f1355a;
        }

        void b() throws InterruptedException {
            try {
                this.f1356b.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public static i a(Activity activity, io.fabric.sdk.android.services.e.o oVar, final a aVar) {
        final b bVar = new b();
        x xVar = new x(activity, oVar);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView scrollViewA = a(activity, xVar.b());
        builder.setView(scrollViewA).setTitle(xVar.a()).setCancelable(false).setNeutralButton(xVar.c(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.c.i.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                bVar.a(true);
                dialogInterface.dismiss();
            }
        });
        if (oVar.d) {
            builder.setNegativeButton(xVar.e(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.c.i.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    bVar.a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (oVar.f) {
            builder.setPositiveButton(xVar.d(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.c.i.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    aVar.a(true);
                    bVar.a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new i(builder, bVar);
    }

    private static ScrollView a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int iA = a(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, R.style.TextAppearance.Medium);
        textView.setPadding(iA, iA, iA, iA);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(a(f, 14), a(f, 2), a(f, 10), a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private i(AlertDialog.Builder builder, b bVar) {
        this.f1349a = bVar;
        this.f1350b = builder;
    }

    public void a() {
        this.f1350b.show();
    }

    public void b() throws InterruptedException {
        this.f1349a.b();
    }

    public boolean c() {
        return this.f1349a.a();
    }
}
