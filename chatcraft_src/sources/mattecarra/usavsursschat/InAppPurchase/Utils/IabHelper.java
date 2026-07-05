package mattecarra.usavsursschat.InAppPurchase.Utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IabHelper {
    Context j;
    com.a.a.a.a k;
    ServiceConnection l;
    int m;
    String n;
    String o;
    a p;
    private final Object q = new Object();

    /* renamed from: a, reason: collision with root package name */
    boolean f4812a = false;

    /* renamed from: b, reason: collision with root package name */
    String f4813b = "IabHelper";
    boolean c = false;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    String i = BuildConfig.FLAVOR;

    public interface a {
        void a(mattecarra.usavsursschat.InAppPurchase.Utils.b bVar, d dVar);
    }

    public interface b {
        void a(mattecarra.usavsursschat.InAppPurchase.Utils.b bVar);
    }

    public interface c {
        void a(mattecarra.usavsursschat.InAppPurchase.Utils.b bVar, mattecarra.usavsursschat.InAppPurchase.Utils.c cVar);
    }

    public IabHelper(Context context, String str) {
        this.o = null;
        this.j = context.getApplicationContext();
        this.o = str;
        c("IAB helper created.");
    }

    public static String a(int i) {
        String[] strArrSplit = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] strArrSplit2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = (-1000) - i;
            if (i2 >= 0 && i2 < strArrSplit2.length) {
                return strArrSplit2[i2];
            }
            return String.valueOf(i) + ":Unknown IAB Helper Error";
        }
        if (i < 0 || i >= strArrSplit.length) {
            return String.valueOf(i) + ":Unknown";
        }
        return strArrSplit[i];
    }

    public void a(boolean z) {
        d();
        this.f4812a = z;
    }

    public void a(final b bVar) {
        d();
        if (this.c) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        c("Starting in-app billing setup.");
        this.l = new ServiceConnection() { // from class: mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                IabHelper.this.c("Billing service disconnected.");
                IabHelper.this.k = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (IabHelper.this.d) {
                    return;
                }
                IabHelper.this.c("Billing service connected.");
                IabHelper.this.k = a.AbstractBinderC0057a.a(iBinder);
                String packageName = IabHelper.this.j.getPackageName();
                try {
                    IabHelper.this.c("Checking for in-app billing 3 support.");
                    int iA = IabHelper.this.k.a(3, packageName, "inapp");
                    if (iA != 0) {
                        if (bVar != null) {
                            bVar.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(iA, "Error checking for billing v3 support."));
                        }
                        IabHelper.this.f = false;
                        IabHelper.this.g = false;
                        return;
                    }
                    IabHelper.this.c("In-app billing version 3 supported for " + packageName);
                    if (IabHelper.this.k.a(5, packageName, "subs") == 0) {
                        IabHelper.this.c("Subscription re-signup AVAILABLE.");
                        IabHelper.this.g = true;
                    } else {
                        IabHelper.this.c("Subscription re-signup not available.");
                        IabHelper.this.g = false;
                    }
                    if (IabHelper.this.g) {
                        IabHelper.this.f = true;
                    } else {
                        int iA2 = IabHelper.this.k.a(3, packageName, "subs");
                        if (iA2 == 0) {
                            IabHelper.this.c("Subscriptions AVAILABLE.");
                            IabHelper.this.f = true;
                        } else {
                            IabHelper.this.c("Subscriptions NOT AVAILABLE. Response: " + iA2);
                            IabHelper.this.f = false;
                            IabHelper.this.g = false;
                        }
                    }
                    IabHelper.this.c = true;
                    if (bVar != null) {
                        bVar.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(0, "Setup successful."));
                    }
                } catch (RemoteException e) {
                    if (bVar != null) {
                        bVar.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1001, "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.j.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            this.j.bindService(intent, this.l, 1);
        } else if (bVar != null) {
            bVar.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(3, "Billing service unavailable on device."));
        }
    }

    public void a() {
        synchronized (this.q) {
            if (this.h) {
                throw new IabAsyncInProgressException("Can't dispose because an async operation (" + this.i + ") is in progress.");
            }
        }
        c("Disposing.");
        this.c = false;
        if (this.l != null) {
            c("Unbinding from service.");
            if (this.j != null) {
                this.j.unbindService(this.l);
            }
        }
        this.d = true;
        this.j = null;
        this.l = null;
        this.k = null;
        this.p = null;
    }

    public void b() {
        synchronized (this.q) {
            if (this.h) {
                c("Will dispose after async operation finishes.");
                this.e = true;
            } else {
                try {
                    a();
                } catch (IabAsyncInProgressException unused) {
                }
            }
        }
    }

    private void d() {
        if (this.d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public void a(Activity activity, String str, int i, a aVar, String str2) throws IntentSender.SendIntentException {
        a(activity, str, "inapp", null, i, aVar, str2);
    }

    public void a(Activity activity, String str, String str2, List<String> list, int i, a aVar, String str3) throws IntentSender.SendIntentException {
        Bundle bundleA;
        d();
        a("launchPurchaseFlow");
        b("launchPurchaseFlow");
        if (str2.equals("subs") && !this.f) {
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1009, "Subscriptions are not available.");
            c();
            if (aVar != null) {
                aVar.a(bVar, null);
                return;
            }
            return;
        }
        try {
            c("Constructing buy intent for " + str + ", item type: " + str2);
            if (list == null || list.isEmpty()) {
                bundleA = this.k.a(3, this.j.getPackageName(), str, str2, str3);
            } else {
                if (!this.g) {
                    mattecarra.usavsursschat.InAppPurchase.Utils.b bVar2 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1011, "Subscription updates are not available.");
                    c();
                    if (aVar != null) {
                        aVar.a(bVar2, null);
                        return;
                    }
                    return;
                }
                bundleA = this.k.a(5, this.j.getPackageName(), list, str, str2, str3);
            }
            int iA = a(bundleA);
            if (iA != 0) {
                d("Unable to buy item, Error response: " + a(iA));
                c();
                mattecarra.usavsursschat.InAppPurchase.Utils.b bVar3 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(iA, "Unable to buy item");
                if (aVar != null) {
                    aVar.a(bVar3, null);
                    return;
                }
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) bundleA.getParcelable("BUY_INTENT");
            c("Launching buy intent for " + str + ". Request code: " + i);
            this.m = i;
            this.p = aVar;
            this.n = str2;
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intent intent = new Intent();
            Integer num = 0;
            int iIntValue = num.intValue();
            Integer num2 = 0;
            Integer num3 = 0;
            activity.startIntentSenderForResult(intentSender, i, intent, iIntValue, num2.intValue(), num3.intValue());
        } catch (IntentSender.SendIntentException e) {
            d("SendIntentException while launching purchase flow for sku " + str);
            e.printStackTrace();
            c();
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar4 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1004, "Failed to send intent.");
            if (aVar != null) {
                aVar.a(bVar4, null);
            }
        } catch (RemoteException e2) {
            d("RemoteException while launching purchase flow for sku " + str);
            e2.printStackTrace();
            c();
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar5 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1001, "Remote exception while starting purchase flow");
            if (aVar != null) {
                aVar.a(bVar5, null);
            }
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i != this.m) {
            return false;
        }
        d();
        a("handleActivityResult");
        c();
        if (intent == null) {
            d("Null data in IAB activity result.");
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1002, "Null data in IAB result");
            if (this.p != null) {
                this.p.a(bVar, null);
            }
            return true;
        }
        int iA = a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && iA == 0) {
            c("Successful resultcode from purchase activity.");
            c("Purchase data: " + stringExtra);
            c("Data signature: " + stringExtra2);
            c("Extras: " + intent.getExtras());
            c("Expected item type: " + this.n);
            if (stringExtra == null || stringExtra2 == null) {
                d("BUG: either purchaseData or dataSignature is null.");
                c("Extras: " + intent.getExtras().toString());
                mattecarra.usavsursschat.InAppPurchase.Utils.b bVar2 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.p != null) {
                    this.p.a(bVar2, null);
                }
                return true;
            }
            try {
                d dVar = new d(this.n, stringExtra, stringExtra2);
                String strB = dVar.b();
                if (!e.a(this.o, stringExtra, stringExtra2)) {
                    d("Purchase signature verification FAILED for sku " + strB);
                    mattecarra.usavsursschat.InAppPurchase.Utils.b bVar3 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1003, "Signature verification failed for sku " + strB);
                    if (this.p != null) {
                        this.p.a(bVar3, dVar);
                    }
                    return true;
                }
                c("Purchase signature successfully verified.");
                if (this.p != null) {
                    this.p.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(0, "Success"), dVar);
                }
            } catch (JSONException e) {
                d("Failed to parse purchase data.");
                e.printStackTrace();
                mattecarra.usavsursschat.InAppPurchase.Utils.b bVar4 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1002, "Failed to parse purchase data.");
                if (this.p != null) {
                    this.p.a(bVar4, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            c("Result code was OK but in-app billing response was not OK: " + a(iA));
            if (this.p != null) {
                this.p.a(new mattecarra.usavsursschat.InAppPurchase.Utils.b(iA, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            c("Purchase canceled - Response: " + a(iA));
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar5 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1005, "User canceled.");
            if (this.p != null) {
                this.p.a(bVar5, null);
            }
        } else {
            d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + a(iA));
            mattecarra.usavsursschat.InAppPurchase.Utils.b bVar6 = new mattecarra.usavsursschat.InAppPurchase.Utils.b(-1006, "Unknown purchase response.");
            if (this.p != null) {
                this.p.a(bVar6, null);
            }
        }
        return true;
    }

    public mattecarra.usavsursschat.InAppPurchase.Utils.c a(boolean z, List<String> list, List<String> list2) throws IabException {
        int iA;
        int iA2;
        d();
        a("queryInventory");
        try {
            mattecarra.usavsursschat.InAppPurchase.Utils.c cVar = new mattecarra.usavsursschat.InAppPurchase.Utils.c();
            int iA3 = a(cVar, "inapp");
            if (iA3 != 0) {
                throw new IabException(iA3, "Error refreshing inventory (querying owned items).");
            }
            if (z && (iA2 = a("inapp", cVar, list)) != 0) {
                throw new IabException(iA2, "Error refreshing inventory (querying prices of items).");
            }
            if (this.f) {
                int iA4 = a(cVar, "subs");
                if (iA4 != 0) {
                    throw new IabException(iA4, "Error refreshing inventory (querying owned subscriptions).");
                }
                if (z && (iA = a("subs", cVar, list2)) != 0) {
                    throw new IabException(iA, "Error refreshing inventory (querying prices of subscriptions).");
                }
            }
            return cVar;
        } catch (RemoteException e) {
            throw new IabException(-1001, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void a(final boolean z, final List<String> list, final List<String> list2, final c cVar) {
        final Handler handler = new Handler();
        d();
        a("queryInventory");
        b("refresh inventory");
        new Thread(new Runnable() { // from class: mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final mattecarra.usavsursschat.InAppPurchase.Utils.c cVarA;
                final mattecarra.usavsursschat.InAppPurchase.Utils.b bVar = new mattecarra.usavsursschat.InAppPurchase.Utils.b(0, "Inventory refresh successful.");
                try {
                    cVarA = IabHelper.this.a(z, list, list2);
                } catch (IabException e) {
                    bVar = e.a();
                    cVarA = null;
                }
                IabHelper.this.c();
                if (IabHelper.this.d || cVar == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.a(bVar, cVarA);
                    }
                });
            }
        }).start();
    }

    public void a(c cVar) {
        a(false, null, null, cVar);
    }

    void a(String str) {
        if (this.c) {
            return;
        }
        d("Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        d("Unexpected type for bundle response code.");
        d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
    }

    int a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            d("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        d("Unexpected type for intent response code.");
        d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
    }

    void b(String str) {
        synchronized (this.q) {
            if (this.h) {
                throw new IabAsyncInProgressException("Can't start async operation (" + str + ") because another async operation (" + this.i + ") is in progress.");
            }
            this.i = str;
            this.h = true;
            c("Starting async operation: " + str);
        }
    }

    void c() {
        synchronized (this.q) {
            c("Ending async operation: " + this.i);
            this.i = BuildConfig.FLAVOR;
            this.h = false;
            if (this.e) {
                try {
                    a();
                } catch (IabAsyncInProgressException unused) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0171, code lost:
    
        d("Bundle returned from getPurchases() doesn't contain required fields.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0178, code lost:
    
        return -1002;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int a(mattecarra.usavsursschat.InAppPurchase.Utils.c r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mattecarra.usavsursschat.InAppPurchase.Utils.IabHelper.a(mattecarra.usavsursschat.InAppPurchase.Utils.c, java.lang.String):int");
    }

    int a(String str, mattecarra.usavsursschat.InAppPurchase.Utils.c cVar, List<String> list) {
        c("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cVar.c(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size() / 20;
        int size2 = arrayList.size() % 20;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList3 = new ArrayList();
            int i2 = i * 20;
            Iterator it = arrayList.subList(i2, i2 + 20).iterator();
            while (it.hasNext()) {
                arrayList3.add((String) it.next());
            }
            arrayList2.add(arrayList3);
        }
        if (size2 != 0) {
            ArrayList arrayList4 = new ArrayList();
            int i3 = size * 20;
            Iterator it2 = arrayList.subList(i3, size2 + i3).iterator();
            while (it2.hasNext()) {
                arrayList4.add((String) it2.next());
            }
            arrayList2.add(arrayList4);
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ArrayList<String> arrayList5 = (ArrayList) it3.next();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList5);
            Bundle bundleA = this.k.a(3, this.j.getPackageName(), str, bundle);
            if (!bundleA.containsKey("DETAILS_LIST")) {
                int iA = a(bundleA);
                if (iA != 0) {
                    c("getSkuDetails() failed: " + a(iA));
                    return iA;
                }
                d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return -1002;
            }
            Iterator<String> it4 = bundleA.getStringArrayList("DETAILS_LIST").iterator();
            while (it4.hasNext()) {
                f fVar = new f(str, it4.next());
                c("Got sku details: " + fVar);
                cVar.a(fVar);
            }
        }
        return 0;
    }

    void c(String str) {
        if (this.f4812a) {
            Log.d(this.f4813b, str);
        }
    }

    void d(String str) {
        Log.e(this.f4813b, "In-app billing error: " + str);
    }

    void e(String str) {
        Log.w(this.f4813b, "In-app billing warning: " + str);
    }

    public static class IabAsyncInProgressException extends Exception {
        public IabAsyncInProgressException(String str) {
            super(str);
        }
    }
}
