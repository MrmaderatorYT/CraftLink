package mattecarra.usavsursschat.McClient.PacketHandlers;

import com.github.steveice10.mc.v1_6_4.data.message.TextMessage;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientChat;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientStatus;
import com.github.steveice10.mc.v1_6_4.packet.PacketLogin;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerListItem;
import com.github.steveice10.mc.v1_6_4.packet.PacketServerChat;
import com.github.steveice10.mc.v1_6_4.packet.PacketTabComplete;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.packet.Packet;
import com.squareup.a.b;
import mattecarra.usavsursschat.McClient.a;
import mattecarra.usavsursschat.a.a.a.e;
import mattecarra.usavsursschat.a.a.a.f;

/* loaded from: classes.dex */
public class PacketHandler_v1_6_4 extends BasePacketHandler {
    private double x;
    private double y;
    private double z;

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendLookMove(double d, double d2, double d3) {
    }

    public PacketHandler_v1_6_4(a aVar, b bVar) {
        super(aVar, bVar);
        this.x = -1.0d;
        this.y = -1.0d;
        this.z = -1.0d;
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void senTabCompletePacket(String str) {
        this.mc_client.d().getSession().send(new PacketTabComplete(str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendMessage(String str) {
        this.mc_client.d().getSession().send(new PacketClientChat(str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void handle(PacketReceivedEvent packetReceivedEvent) {
        try {
            Packet packet = packetReceivedEvent.getPacket();
            if (packet instanceof PacketLogin) {
                notifySuccessfulJoin();
            } else if (packet instanceof PacketServerChat) {
                notifyMessagePacket(((PacketServerChat) packet).getMessage());
            } else if (packet instanceof PacketTabComplete) {
                notifyTabResponse(((PacketTabComplete) packet).text.split("\u0000"));
            } else if (packet instanceof PacketPlayerListItem) {
                int i = ((PacketPlayerListItem) packet).online ? 0 : 2;
                String str = ((PacketPlayerListItem) packet).name;
                notifyPlayerListEntry(new f(new e(null, str, new TextMessage(str)), i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void respawn() {
        this.mc_client.d().getSession().send(new PacketClientStatus((byte) 0));
    }
}
