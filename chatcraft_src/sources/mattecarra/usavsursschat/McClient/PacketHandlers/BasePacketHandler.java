package mattecarra.usavsursschat.McClient.PacketHandlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.github.steveice10.mc.common.message.MessageInterface;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.squareup.a.b;
import mattecarra.usavsursschat.McClient.a;
import mattecarra.usavsursschat.a.a.a.c;
import mattecarra.usavsursschat.a.a.a.d;
import mattecarra.usavsursschat.a.a.a.f;
import mattecarra.usavsursschat.a.a.a.g;
import mattecarra.usavsursschat.a.a.a.h;

/* loaded from: classes.dex */
public abstract class BasePacketHandler {
    protected static final int CORD_UPDATE = 3;
    protected static final int DISCONNECT_EVENT = 5;
    protected static final int MESSAGE = 0;
    protected static final int PLAYER_LIST_ENTRY = 4;
    protected static final int SUCCESSFUL_JOIN = 2;
    protected static final int TAB_RESPONSE = 1;
    private b bus;
    protected a mc_client;
    protected boolean isOnlineMode = false;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            BasePacketHandler.this.bus.c(message.obj);
        }
    };

    public abstract void handle(PacketReceivedEvent packetReceivedEvent);

    public abstract void respawn();

    public abstract void senTabCompletePacket(String str);

    public abstract void sendLookMove(double d, double d2, double d3);

    public abstract void sendMessage(String str);

    public BasePacketHandler(a aVar, b bVar) {
        this.mc_client = aVar;
        this.bus = bVar;
    }

    protected void notifyMessagePacket(MessageInterface messageInterface) {
        this.handler.obtainMessage(0, new d(messageInterface)).sendToTarget();
        this.bus.c(new mattecarra.usavsursschat.a.a.a.a(messageInterface));
    }

    protected void notifyTabResponse(String[] strArr) {
        this.handler.obtainMessage(1, new h(strArr)).sendToTarget();
    }

    protected void notifySuccessfulJoin() {
        this.handler.obtainMessage(2, new g()).sendToTarget();
    }

    protected void notifyPlayerListEntry(f fVar) {
        this.handler.obtainMessage(4, fVar).sendToTarget();
    }

    protected void notifyCoordinatesUpdate(mattecarra.usavsursschat.a.a.a.b bVar) {
        this.handler.obtainMessage(3, bVar).sendToTarget();
    }

    public void notifySyncDisconnect(String str, boolean z) {
        this.handler.obtainMessage(5, new c(str, z)).sendToTarget();
    }

    public boolean isOnlineMode() {
        return this.isOnlineMode;
    }
}
