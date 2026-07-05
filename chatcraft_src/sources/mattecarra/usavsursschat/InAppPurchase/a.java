package mattecarra.usavsursschat.InAppPurchase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.List;
import mattecarra.usavsursschat.ChatCraftApplication;
import mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper;
import mattecarra.usavsursschat.InAppPurchase.Utils.a;
import mattecarra.usavsursschat.InAppPurchase.Utils.b;
import mattecarra.usavsursschat.InAppPurchase.Utils.d;
import mattecarra.usavsursschat.InAppPurchase.Utils.f;
import mattecarra.usavsursschat.InAppPurchase.exception.QueryInventoryException;
import mattecarra.usavsursschat.g;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: InAppPurchaseActivity.java */
/* loaded from: classes.dex */
public class a extends c implements a.InterfaceC0109a {
    protected IabHelper p;
    protected mattecarra.usavsursschat.InAppPurchase.Utils.a q;
    private final String j = "InAppPurchases";
    private final int k = 10001;
    protected List<mattecarra.usavsursschat.e.a> r = new ArrayList();
    protected List<String> s = new ArrayList();
    IabHelper.a t = new IabHelper.a() { // from class: mattecarra.usavsursschat.InAppPurchase.a.1
        @Override // mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.a
        public void a(b bVar, d dVar) {
            Log.d("InAppPurchases", "Purchase finished: " + bVar + ", purchase: " + dVar);
            if (a.this.p == null) {
                return;
            }
            if (!bVar.c()) {
                if (!a.this.a(dVar)) {
                    a.this.c("Error purchasing. Authenticity verification failed.");
                    return;
                }
                Log.d("InAppPurchases", "Purchase successful.");
                if (dVar.b().equals("no_ads")) {
                    g.f4991a = true;
                    ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.c(a.this.r, a.this.s, g.f4991a, g.f4992b));
                }
                if (dVar.b().equals("chatcraft_pro_features")) {
                    g.f4992b = true;
                    ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.c(a.this.r, a.this.s, g.f4991a, g.f4992b));
                }
                if (dVar.b().equals("chatcraft_pro_features")) {
                    g.f4992b = true;
                    g.f4991a = true;
                    ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.c(a.this.r, a.this.s, g.f4991a, g.f4992b));
                    return;
                }
                return;
            }
            a.this.c("Error purchasing: " + bVar);
        }
    };
    IabHelper.c u = new IabHelper.c() { // from class: mattecarra.usavsursschat.InAppPurchase.a.2
        @Override // mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.c
        public void a(b bVar, mattecarra.usavsursschat.InAppPurchase.Utils.c cVar) {
            Log.d("InAppPurchases", "Query inventory finished.");
            if (a.this.p == null) {
                return;
            }
            if (bVar.c()) {
                com.crashlytics.android.a.a((Throwable) new QueryInventoryException("Failed to query inventory " + bVar));
                return;
            }
            Log.d("InAppPurchases", "Query inventory was successful.");
            a.this.r.clear();
            a.this.s.clear();
            try {
                f fVarA = cVar.a("all_in_one");
                if (fVarA != null) {
                    a.this.r.add(new mattecarra.usavsursschat.e.a(fVarA.c(), fVarA.b(), fVarA.d(), R.drawable.allinone, fVarA.a()));
                } else {
                    a.this.r.add(new mattecarra.usavsursschat.e.a("All in One", "error", "Failed to retrieve data", R.drawable.allinone, "all_in_one"));
                }
                f fVarA2 = cVar.a("no_ads");
                if (fVarA2 != null) {
                    a.this.r.add(new mattecarra.usavsursschat.e.a(fVarA2.c(), fVarA2.b(), fVarA2.d(), R.drawable.no_ads_new, fVarA2.a()));
                } else {
                    a.this.r.add(new mattecarra.usavsursschat.e.a("No Ads", "error", "Failed to retrieve data", R.drawable.no_ads_new, "no_ads"));
                }
                f fVarA3 = cVar.a("chatcraft_pro_features");
                if (fVarA3 != null) {
                    a.this.r.add(new mattecarra.usavsursschat.e.a(fVarA3.c(), fVarA3.b(), fVarA3.d(), R.drawable.pro, fVarA3.a()));
                } else {
                    a.this.r.add(new mattecarra.usavsursschat.e.a("Pro", "error", "Failed to retrieve data", R.drawable.pro, "chatcraft_pro_features"));
                }
            } catch (Exception e) {
                com.crashlytics.android.a.a((Throwable) e);
                e.printStackTrace();
            }
            d dVarB = cVar.b("all_in_one");
            boolean z = dVarB != null && a.this.a(dVarB);
            g.f4992b = z;
            g.f4991a = z;
            d dVarB2 = cVar.b("no_ads");
            g.f4991a = (dVarB2 != null && a.this.a(dVarB2)) | g.f4991a;
            d dVarB3 = cVar.b("chatcraft_pro_features");
            g.f4992b = (dVarB3 != null && a.this.a(dVarB3)) | g.f4992b;
            d dVarB4 = cVar.b("premium_server_access");
            g.f4992b |= dVarB4 != null && a.this.a(dVarB4);
            Log.d("InAppPurchases", "User has no ads = " + g.f4991a);
            Log.d("InAppPurchases", "User has premium features = " + g.f4992b);
            ChatCraftApplication.f4809a.c(new mattecarra.usavsursschat.a.a.c(a.this.r, a.this.s, g.f4991a, g.f4992b));
            Log.d("InAppPurchases", "Initial inventory query finished; enabling main UI.");
        }
    };

    public static boolean t() {
        return v();
    }

    public static boolean u() {
        return g.f4991a;
    }

    public static boolean v() {
        return g.f4992b;
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            unregisterReceiver(this.q);
        }
        Log.d("InAppPurchases", "Destroying helper.");
        if (this.p != null) {
            this.p.b();
            this.p = null;
        }
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            w();
        } catch (Throwable th) {
            th.printStackTrace();
            com.crashlytics.android.a.a(th);
        }
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Log.d("InAppPurchases", "onActivityResult(" + i + "," + i2 + "," + intent);
        if (this.p == null) {
            return;
        }
        if (!this.p.a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        } else {
            Log.d("InAppPurchases", "onActivityResult handled by IABUtil.");
        }
    }

    void c(String str) {
        Log.e("InAppPurchases", "**** TrivialDrive Error: " + str);
        d("Error: " + str);
    }

    void d(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setNeutralButton("OK", (DialogInterface.OnClickListener) null);
        Log.d("InAppPurchases", "Showing alert dialog: " + str);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar) {
        this.s.add(dVar.b());
        return true;
    }

    public void w() {
        Log.d("InAppPurchases", "Creating IAB helper.");
        this.p = new IabHelper(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt6iyQN5uo7OHXaMy32BveV+Aw/n332Xyu+kkhHXxUB0Tqybs60Kqdrk0Xxi36FIlUZuYYCv9o4NajAJKAxZfDHRsnYyOf3JUe4Wij3s5STQHXbzNgSOSHy141crq2gHdiRlcwSuAUuJ7czebLaCzczQczFaND4dPc6adXSXYoAaw2yh4Oc1QW1gmp/jkz42xORltKqLmfbaDmMjX/0CClH3Z72d/RA88irCHrrRKtT7y5z7oxx5erpBnqycVIfKsqI2LJKnhKwpuM31Y9y8G2ce+ZS9Q2pNidntMdIDbaqRz8V8h/2OJkjSeZuPsggRu+8YDm+Jz9JEKbRJqDeXYnQIDAQAB");
        this.p.a(true);
        Log.d("InAppPurchases", "Starting setup.");
        this.p.a(new IabHelper.b() { // from class: mattecarra.usavsursschat.InAppPurchase.a.3
            @Override // mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.b
            public void a(b bVar) {
                Log.d("InAppPurchases", "Setup finished.");
                if (!bVar.b()) {
                    Log.d("InAppPurchases", "Failed to setup up ip-app billing " + bVar);
                    a.this.p = null;
                    a.this.q = null;
                    return;
                }
                if (a.this.p == null) {
                    return;
                }
                a.this.q = new mattecarra.usavsursschat.InAppPurchase.Utils.a(a.this);
                a.this.registerReceiver(a.this.q, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
                Log.d("InAppPurchases", "Setup successful. Querying inventory.");
                try {
                    a.this.p.a(a.this.u);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    com.crashlytics.android.a.a((Throwable) e);
                }
            }
        });
    }

    public void e(String str) {
        try {
            this.p.a(this, str, 10001, this.t, BuildConfig.FLAVOR);
        } catch (Exception e) {
            c("Error launching purchase flow. Please try again later!");
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    @Override // mattecarra.usavsursschat.InAppPurchase.Utils.a.InterfaceC0109a
    public void x() {
        Log.d("InAppPurchases", "Received broadcast notification. Querying inventory.");
        try {
            this.p.a(this.u);
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }
}
