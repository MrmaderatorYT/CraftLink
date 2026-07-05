package mattecarra.usavsursschat;

import android.app.Application;
import com.squareup.a.i;

/* loaded from: classes.dex */
public class ChatCraftApplication extends Application {

    /* renamed from: a, reason: collision with root package name */
    public static com.squareup.a.b f4809a = new com.squareup.a.b(i.f4096a);

    /* renamed from: b, reason: collision with root package name */
    public static com.squareup.a.b f4810b = new com.squareup.a.b(i.f4096a);

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        io.fabric.sdk.android.c.a(this, new com.crashlytics.android.a());
    }
}
