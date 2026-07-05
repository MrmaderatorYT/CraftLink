package mattecarra.usavsursschat.BroadcastReceiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mattecarra.usavsursschat.ChatCraftApplication;
import mattecarra.usavsursschat.a.a.d;

/* loaded from: classes.dex */
public class NotificationReceivers extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("disconnect")) {
            if (ChatCraftApplication.f4809a != null) {
                ChatCraftApplication.f4809a.c(new d());
            }
            ((NotificationManager) context.getSystemService("notification")).cancel(1);
        }
    }
}
