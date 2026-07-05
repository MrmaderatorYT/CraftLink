package mattecarra.usavsursschat.InAppPurchase.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: IabBroadcastReceiver.java */
/* loaded from: classes.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0109a f4820a;

    /* compiled from: IabBroadcastReceiver.java */
    /* renamed from: mattecarra.usavsursschat.InAppPurchase.Utils.a$a, reason: collision with other inner class name */
    public interface InterfaceC0109a {
        void x();
    }

    public a(InterfaceC0109a interfaceC0109a) {
        this.f4820a = interfaceC0109a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f4820a != null) {
            this.f4820a.x();
        }
    }
}
