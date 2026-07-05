package mattecarra.usavsursschat.j;

import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.List;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.McClient.Exceptions.UnsupportedMinecraftVersion;
import mattecarra.usavsursschat.McClient.c;
import mattecarra.usavsursschat.b.d;

/* compiled from: ServerUpdaterWorker.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private List<d> f5029a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f5030b;
    private InterfaceC0118a c;
    private Thread d;

    /* compiled from: ServerUpdaterWorker.java */
    /* renamed from: mattecarra.usavsursschat.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0118a {
        void a(d dVar);
    }

    public a(InterfaceC0118a interfaceC0118a, LoginActivity loginActivity) {
        this.f5029a = loginActivity.m();
        this.c = interfaceC0118a;
        this.f5030b = new Handler(loginActivity.getMainLooper()) { // from class: mattecarra.usavsursschat.j.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                a.this.c.a((d) message.obj);
            }
        };
    }

    public void a() {
        b();
        this.d = new Thread(this);
        this.d.start();
    }

    public void b() {
        if (this.d == null || !this.d.isAlive()) {
            return;
        }
        this.d.interrupt();
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        c cVar = new c();
        System.out.println("Starting server updater worker!");
        while (true) {
            try {
                Thread.sleep(2000L);
                try {
                    for (d dVar : this.f5029a) {
                        if (dVar != null) {
                            try {
                                try {
                                    mattecarra.usavsursschat.McClient.b bVarB = cVar.b(dVar.b(), dVar.c(), dVar.d());
                                    if (bVarB != null) {
                                        dVar.g = bVarB.a();
                                        dVar.e = bVarB.b();
                                        dVar.f = bVarB.c();
                                        dVar.h = bVarB.e();
                                        try {
                                            if (bVarB.d() != null) {
                                                dVar.i = bVarB.d();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        this.f5030b.obtainMessage(1, dVar).sendToTarget();
                                    }
                                } catch (InterruptedException unused) {
                                    return;
                                }
                            } catch (IOException | UnsupportedMinecraftVersion e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (ConcurrentModificationException unused2) {
                    System.out.println("Concurrent modification while updating servers. No matter.");
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.crashlytics.android.a.a(th);
                }
            } catch (InterruptedException unused3) {
                System.out.println("Server updater worker interrupted!");
                return;
            }
        }
    }
}
