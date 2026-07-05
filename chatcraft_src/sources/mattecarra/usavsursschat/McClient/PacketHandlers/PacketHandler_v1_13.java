package mattecarra.usavsursschat.McClient.PacketHandlers;

import com.github.steveice10.mc.v1_10.protocol.data.game.ClientRequest;
import com.github.steveice10.mc.v1_10.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.v1_10.protocol.data.game.PlayerListEntryAction;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_13.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_13.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.packet.Packet;
import com.squareup.a.b;
import java.util.Random;
import java.util.UUID;
import mattecarra.usavsursschat.McClient.a;
import mattecarra.usavsursschat.a.a.a.e;
import mattecarra.usavsursschat.a.a.a.f;

/* loaded from: classes.dex */
public class PacketHandler_v1_13 extends BasePacketHandler {
    int tabRequests;
    private double x;
    private double y;
    private double z;

    public PacketHandler_v1_13(a aVar, b bVar) {
        super(aVar, bVar);
        this.x = -1.0d;
        this.y = -1.0d;
        this.z = -1.0d;
        this.tabRequests = 0;
        System.out.println("Version 1.13 running");
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendLookMove(double d, double d2, double d3) {
        if (this.x != -1.0d || this.y != -1.0d || this.z != -1.0d) {
            this.x += d;
            this.z += d3;
            this.y += d2;
            this.mc_client.d().getSession().send(new ClientPlayerPositionPacket(true, this.x, this.y, this.z));
            this.mc_client.d().getSession().send(new ClientPlayerPositionPacket(false, this.x, this.y, this.z));
        } else {
            Random random = new Random();
            this.mc_client.d().getSession().send(new ClientPlayerRotationPacket(true, random.nextInt(120) - 60, random.nextInt(360) - 180));
            this.mc_client.d().getSession().send(new ClientPlayerRotationPacket(false, random.nextInt(120) - 60, random.nextInt(360) - 180));
        }
        notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void senTabCompletePacket(String str) {
        Session session = this.mc_client.d().getSession();
        int i = this.tabRequests;
        this.tabRequests = i + 1;
        session.send(new ClientTabCompletePacket(i, str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void sendMessage(String str) {
        this.mc_client.d().getSession().send(new ClientChatPacket(str));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void respawn() {
        this.mc_client.d().getSession().send(new ClientRequestPacket(ClientRequest.RESPAWN));
    }

    @Override // mattecarra.usavsursschat.McClient.PacketHandlers.BasePacketHandler
    public void handle(PacketReceivedEvent packetReceivedEvent) {
        try {
            Packet packet = packetReceivedEvent.getPacket();
            if (packet instanceof ServerJoinGamePacket) {
                notifySuccessfulJoin();
                return;
            }
            if (packet instanceof ServerChatPacket) {
                notifyMessagePacket(((ServerChatPacket) packet).getMessage());
                return;
            }
            if (packet instanceof ServerTabCompletePacket) {
                System.out.println("Received tab complete response: " + ((ServerTabCompletePacket) packet).getTransactionId() + " " + ((ServerTabCompletePacket) packet).getMatches().length);
                notifyTabResponse(((ServerTabCompletePacket) packet).getMatches());
                return;
            }
            if (packet instanceof ServerPlayerListEntryPacket) {
                int i = ((ServerPlayerListEntryPacket) packet).getAction() == PlayerListEntryAction.REMOVE_PLAYER ? 2 : 1;
                if (((ServerPlayerListEntryPacket) packet).getAction() == PlayerListEntryAction.ADD_PLAYER) {
                    i = 0;
                }
                for (PlayerListEntry playerListEntry : ((ServerPlayerListEntryPacket) packet).getEntries()) {
                    if (playerListEntry != null) {
                        String name = null;
                        UUID id = playerListEntry.getProfile() == null ? null : playerListEntry.getProfile().getId();
                        if (playerListEntry.getProfile() != null) {
                            name = playerListEntry.getProfile().getName();
                        }
                        notifyPlayerListEntry(new f(new e(id, name, playerListEntry.getDisplayName()), i));
                    }
                }
                return;
            }
            if (packet instanceof ServerSpawnPositionPacket) {
                this.x = ((ServerSpawnPositionPacket) packet).getPosition().getX();
                this.y = ((ServerSpawnPositionPacket) packet).getPosition().getY();
                this.z = ((ServerSpawnPositionPacket) packet).getPosition().getZ();
                notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
                return;
            }
            if (packet instanceof ServerPlayerPositionRotationPacket) {
                this.x = ((ServerPlayerPositionRotationPacket) packet).getX();
                this.y = ((ServerPlayerPositionRotationPacket) packet).getY();
                this.z = ((ServerPlayerPositionRotationPacket) packet).getZ();
                notifyCoordinatesUpdate(new mattecarra.usavsursschat.a.a.a.b(this.x, this.y, this.z));
                return;
            }
            if (packet instanceof EncryptionRequestPacket) {
                this.isOnlineMode = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
