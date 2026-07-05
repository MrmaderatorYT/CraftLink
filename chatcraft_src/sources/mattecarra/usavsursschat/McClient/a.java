package mattecarra.usavsursschat.McClient;

import com.afollestad.materialdialogs.f;
import com.github.steveice10.mc.OldProtocol.MinecraftVersion;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.v1_5.protocol.MC_1_5;
import com.github.steveice10.mc.v1_6_4.protocol.MC_1_6_4;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import com.squareup.a.h;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mattecarra.usavsursschat.ChatCraftApplication;
import mattecarra.usavsursschat.McClient.Exceptions.UnsupportedMinecraftVersion;
import mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler;
import mattecarra.usavsursschat.a.a.a.g;
import mattecarra.usavsursschat.a.b.d;
import mattecarra.usavsursschat.i.e;
import org.json.JSONException;

/* compiled from: MinecraftClient.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected SessionAdapter f4847a = new SessionAdapter() { // from class: mattecarra.usavsursschat.McClient.a.1
        @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
        public void packetReceived(PacketReceivedEvent packetReceivedEvent) {
            a.this.n.handle(packetReceivedEvent);
        }

        @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
        public void disconnected(DisconnectedEvent disconnectedEvent) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Disconnect by the game ");
            sb.append(disconnectedEvent.getReason());
            sb.append(" ");
            sb.append(disconnectedEvent.getCause() != null);
            printStream.println(sb.toString());
            try {
                ChatCraftApplication.f4809a.b(this);
                ChatCraftApplication.f4810b.b(this);
            } catch (Throwable unused) {
            }
            if (disconnectedEvent.getCause() == null) {
                a.this.b(e.e(disconnectedEvent.getReason()));
                return;
            }
            disconnectedEvent.getCause().printStackTrace();
            if (disconnectedEvent.getReason() == null || !disconnectedEvent.getReason().startsWith("Login failed: ") || disconnectedEvent.getReason().startsWith("Login failed: Authentication service unavailable.")) {
                a.this.b(e.e(disconnectedEvent.getReason()));
                com.crashlytics.android.a.a(disconnectedEvent.getCause());
                return;
            }
            GameProfile gameProfile = (GameProfile) disconnectedEvent.getSession().getFlag("profile");
            if (a.this.e) {
                a.this.a((String) null, true);
                System.out.println("Disconnected " + gameProfile.getName());
                System.out.println("Done!");
                return;
            }
            a.this.b("You need a Minecraft Premium account (minecraft.net) to access premium servers!");
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private mattecarra.usavsursschat.e f4848b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private Client l;
    private mattecarra.usavsursschat.b.e m;
    private BasePacketHandler n;
    private f o;
    private boolean p;

    public a(mattecarra.usavsursschat.e eVar) {
        this.f4848b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        System.out.println("onDisconnection called");
        this.n.notifySyncDisconnect(str, z);
    }

    private void h() {
        this.c = this.f4848b.a();
        this.j = this.f4848b.ae();
        this.d = this.f4848b.af();
        this.k = this.f4848b.ag();
        System.out.println("Initilized version = " + this.k);
        this.i = this.f4848b.ah();
        this.m = this.f4848b.ai().c(this.d);
        this.p = this.f4848b.aj().e() ^ true;
        this.e = this.m.b();
        if (this.e) {
            this.f = this.m.c();
            this.g = this.m.d();
            this.h = this.m.e();
        }
    }

    public void a() {
        h();
        mattecarra.usavsursschat.e eVar = this.f4848b;
        f fVarB = new f.a(this.f4848b.l()).a("Connecting").b("Connecting to server! Please wait!").a(true, 0).b();
        this.o = fVarB;
        eVar.a(fVarB);
        new Thread(new Runnable() { // from class: mattecarra.usavsursschat.McClient.a.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    System.out.println("Connecting!");
                    a.this.i();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws IllegalAccessException {
        Session mc_1_5;
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (IllegalArgumentException unused) {
        }
        try {
            ChatCraftApplication.f4810b.a(this);
        } catch (IllegalArgumentException unused2) {
        }
        try {
            this.n = c();
            try {
                MinecraftPacketProtocol minecraftPacketProtocolB = b();
                System.out.println("It's ok");
                if (this.k > 0) {
                    this.l = new Client(this.c, this.j, minecraftPacketProtocolB, new TcpSessionFactory());
                } else {
                    int iAbs = Math.abs(this.k);
                    if (iAbs <= 78 && iAbs >= 63) {
                        mc_1_5 = new MC_1_6_4(this.c, this.j, minecraftPacketProtocolB, minecraftPacketProtocolB.getProfile(), e.a(-iAbs), iAbs);
                    } else {
                        mc_1_5 = iAbs < 63 ? new MC_1_5(this.c, this.j, minecraftPacketProtocolB, minecraftPacketProtocolB.getProfile(), e.a(-iAbs), iAbs) : null;
                    }
                    if (mc_1_5 == null) {
                        b("Disconnected: Could not find selected version");
                        return;
                    }
                    this.l = new MinecraftVersion(this.c, this.j, minecraftPacketProtocolB, mc_1_5);
                }
                this.l.getSession().addListener(this.f4847a);
                this.l.getSession().connect();
                System.out.println("Connecting");
            } catch (InvalidCredentialsException e) {
                e.printStackTrace();
                a("There's a problem with credentials!", true);
            } catch (Exception e2) {
                e2.printStackTrace();
                com.crashlytics.android.a.a((Throwable) e2);
                b("Disconnected: " + e2.getMessage());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            com.crashlytics.android.a.a((Throwable) e3);
            b("Failed to start connection: " + e3.getMessage() + ". Error has been automatically reported to dev!");
        }
    }

    @h
    public void onServerMessagePacket(mattecarra.usavsursschat.a.b.b bVar) {
        if (this.n == null || this.l == null) {
            return;
        }
        this.n.sendMessage(bVar.a());
    }

    @h
    public void onServerMessagePacket(d dVar) {
        if (this.n == null || this.l == null) {
            return;
        }
        this.n.senTabCompletePacket(dVar.a());
    }

    @h
    public void onServerUpdateCoordinates(mattecarra.usavsursschat.a.b.a aVar) {
        if (this.n == null || this.l == null) {
            return;
        }
        this.n.sendLookMove(aVar.a(), aVar.b(), aVar.c());
    }

    @h
    public void onServerRespawnPacket(mattecarra.usavsursschat.a.b.c cVar) {
        if (this.n == null || this.l == null) {
            return;
        }
        this.n.respawn();
    }

    @h
    public void onRequestDisconnection(mattecarra.usavsursschat.a.a.d dVar) {
        if (this.n == null || this.l == null) {
            return;
        }
        e();
    }

    @h
    public void onConnection(g gVar) {
        if (this.o != null && this.o.isShowing()) {
            this.o.dismiss();
        }
        if (this.n != null && !this.n.isOnlineMode()) {
            if (this.i != null) {
                new Timer().schedule(new TimerTask() { // from class: mattecarra.usavsursschat.McClient.a.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (a.this.f()) {
                            a.this.n.sendMessage("/login " + a.this.i);
                            a.this.p = true;
                            if (a.this.f4848b.aj().b()) {
                                a.this.j();
                            } else {
                                a.this.k();
                            }
                        }
                    }
                }, 2000L);
                return;
            } else {
                a(20000L);
                return;
            }
        }
        if (this.f4848b.aj().b()) {
            j();
        } else {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a(2000L);
    }

    private void a(long j) {
        new Timer().schedule(new TimerTask() { // from class: mattecarra.usavsursschat.McClient.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.f()) {
                    a.this.n.sendMessage("/spawn");
                    a.this.k();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (mattecarra.usavsursschat.InAppPurchase.a.u()) {
            l();
        } else {
            new Timer().schedule(new TimerTask() { // from class: mattecarra.usavsursschat.McClient.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.f()) {
                        a.this.n.sendMessage("I joined from my android device with ChatCraft! Don't miss the new update!");
                        a.this.l();
                    }
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        List<String> listF = this.f4848b.aj().f();
        if (listF == null || listF.isEmpty()) {
            return;
        }
        final Iterator<String> it = listF.iterator();
        new Timer().schedule(new TimerTask() { // from class: mattecarra.usavsursschat.McClient.a.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null && !str.isEmpty()) {
                        a.this.n.sendMessage(str);
                    }
                    if (it.hasNext()) {
                        return;
                    }
                    cancel();
                    return;
                }
                cancel();
            }
        }, 2000L, 2000L);
    }

    public MinecraftPacketProtocol b() throws JSONException {
        if (this.e) {
            AuthenticationService authenticationService = new AuthenticationService(this.h);
            authenticationService.setUsername(this.f);
            authenticationService.setAccessToken(this.g);
            authenticationService.login();
            if (authenticationService.getSelectedProfile() != null) {
                this.d = authenticationService.getSelectedProfile().getName();
            } else if (authenticationService.getAvailableProfiles() != null && authenticationService.getAvailableProfiles().size() >= 1) {
                this.d = authenticationService.getAvailableProfiles().get(0).getName();
            }
            GameProfile selectedProfile = authenticationService.getSelectedProfile();
            this.g = authenticationService.getAccessToken();
            this.h = authenticationService.getClientToken();
            this.m.c(this.g);
            this.m.d(this.h);
            this.f4848b.ai().a(this.m);
            return (MinecraftPacketProtocol) Class.forName("com.github.steveice10.mc." + m() + ".protocol.MinecraftProtocol").getDeclaredConstructor(GameProfile.class, String.class).newInstance(selectedProfile, this.g);
        }
        return (MinecraftPacketProtocol) Class.forName("com.github.steveice10.mc." + m() + ".protocol.MinecraftProtocol").getDeclaredConstructor(String.class).newInstance(this.d);
    }

    public BasePacketHandler c() {
        return (BasePacketHandler) Class.forName("mattecarra.usavsursschat.McClient.PacketHandlers.PacketHandler_" + m()).getDeclaredConstructor(a.class, com.squareup.a.b.class).newInstance(this, ChatCraftApplication.f4809a);
    }

    private String m() throws UnsupportedMinecraftVersion {
        if (this.k < 0) {
            int iAbs = Math.abs(this.k);
            return (iAbs > 78 || iAbs < 63) ? "v1_5" : "v1_6_4";
        }
        if (this.k >= 404) {
            return "v1_13_2";
        }
        if (this.k >= 401) {
            return "v1_13_1";
        }
        if (this.k >= 393) {
            return "v1_13";
        }
        if (this.k >= 340) {
            return "v1_12_2";
        }
        if (this.k >= 338) {
            return "v1_12_1";
        }
        if (this.k >= 335) {
            return "v1_12";
        }
        if (this.k >= 316) {
            return "v1_11_2";
        }
        if (this.k >= 315) {
            return "v1_11";
        }
        if (this.k >= 210) {
            return "v1_10";
        }
        if (this.k >= 110) {
            return "v1_9_4";
        }
        if (this.k >= 109) {
            return "v1_9_2";
        }
        if (this.k >= 107) {
            return "v1_9";
        }
        if (this.k >= 47) {
            return "v1_8";
        }
        if (this.k >= 5) {
            return "v1_7_7";
        }
        if (this.k >= 4) {
            return "v1_7";
        }
        throw new UnsupportedMinecraftVersion(this.k + " version is not yet supported.");
    }

    public Client d() {
        return this.l;
    }

    public void e() {
        this.l.getSession().disconnect("Disconnected");
    }

    public boolean f() {
        return this.l != null && this.l.getSession().isConnected();
    }

    public boolean g() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void a(String str) {
        this.n.sendMessage(str);
    }
}
