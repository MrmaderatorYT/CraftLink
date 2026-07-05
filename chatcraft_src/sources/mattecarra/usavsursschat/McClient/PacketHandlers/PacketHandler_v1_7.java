package mattecarra.usavsursschat.McClient.PacketHandlers;

import com.github.steveice10.mc.v1_7.protocol.data.message.TextMessage;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.packet.Packet;
import com.squareup.a.b;
import java.util.Random;
import mattecarra.usavsursschat.McClient.a;
import mattecarra.usavsursschat.a.a.a.e;
import mattecarra.usavsursschat.a.a.a.f;

/* loaded from: classes.dex */
public class PacketHandler_v1_7 extends BasePacketHandler {
    private double x;
    private double y;
    private double z;

    public PacketHandler_v1_7(a aVar, b bVar) {
        super(aVar, bVar);
        this.x = -1.0d;
        this.y = -1.0d;
        this.z = -1.0d;
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendLookMove(double d, double d2, double d3) {
        if (this.x != -1.0d || this.y != -1.0d || this.z != -1.0d) {
            this.x += d;
            this.z += d3;
            this.y += d2;
            this.mc_client.d().getSession().send(new ClientPlayerPositionPacket(true, this.x, this.y - 1.62d, this.y, this.z));
            this.mc_client.d().getSession().send(new ClientPlayerPositionPacket(false, this.x, this.y - 1.62d, this.y, this.z));
        }
        notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
        Random random = new Random();
        this.mc_client.d().getSession().send(new ClientPlayerRotationPacket(true, random.nextInt(120) - 60, random.nextInt(360) - 180));
        this.mc_client.d().getSession().send(new ClientPlayerRotationPacket(false, random.nextInt(120) - 60, random.nextInt(360) - 180));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void senTabCompletePacket(String str) {
        this.mc_client.d().getSession().send(new ClientTabCompletePacket(str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendMessage(String str) {
        this.mc_client.d().getSession().send(new ClientChatPacket(str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void handle(PacketReceivedEvent packetReceivedEvent) {
        try {
            Packet packet = packetReceivedEvent.getPacket();
            if (packet instanceof ServerJoinGamePacket) {
                notifySuccessfulJoin();
            } else if (packet instanceof ServerChatPacket) {
                notifyMessagePacket(((ServerChatPacket) packet).getMessage());
            } else if (packet instanceof ServerTabCompletePacket) {
                notifyTabResponse(((ServerTabCompletePacket) packet).getMatches());
            } else if (packet instanceof ServerPlayerListEntryPacket) {
                int i = ((ServerPlayerListEntryPacket) packet).getOnline() ? 0 : 2;
                String name = ((ServerPlayerListEntryPacket) packet).getName();
                notifyPlayerListEntry(new f(new e(null, name, new TextMessage(name)), i));
            } else if (packet instanceof ServerSpawnPositionPacket) {
                this.x = ((ServerSpawnPositionPacket) packet).getX();
                this.y = ((ServerSpawnPositionPacket) packet).getY();
                this.z = ((ServerSpawnPositionPacket) packet).getZ();
                notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
            } else if (packet instanceof ServerPlayerPositionRotationPacket) {
                this.x = ((ServerPlayerPositionRotationPacket) packet).getX();
                this.y = ((ServerPlayerPositionRotationPacket) packet).getY();
                this.z = ((ServerPlayerPositionRotationPacket) packet).getZ();
                notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
            } else if (packet instanceof EncryptionRequestPacket) {
                this.isOnlineMode = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void respawn() {
        this.mc_client.d().getSession().send(new ClientRequestPacket(ClientRequestPacket.Request.RESPAWN));
    }
}
