package com.github.steveice10.mc.v1_6_4.protocol;

import com.github.steveice10.mc.OldProtocol.MinecraftSession;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.exception.request.ServiceUnavailableException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientStatus;
import com.github.steveice10.mc.v1_6_4.packet.PacketDisconnect;
import com.github.steveice10.mc.v1_6_4.packet.PacketHandshake;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeepAlive;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeyRequest;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeyResponse;
import com.github.steveice10.mc.v1_6_4.util.CryptUtil;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.packet.Packet;
import java.math.BigInteger;
import javax.crypto.SecretKey;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class MC_1_6_4 extends MinecraftSession {
    private SecretKey key;

    @Override // com.github.steveice10.mc.OldProtocol.MinecraftSession
    protected void onPacketSent(Packet packet) {
    }

    public MC_1_6_4(String str, int i, MinecraftPacketProtocol minecraftPacketProtocol, GameProfile gameProfile) {
        super(str, i, minecraftPacketProtocol, gameProfile, "1.6.4", 78);
        ((MinecraftProtocol) getPacketProtocol()).setMode(ProtocolMode.LOGIN, true);
        ((MinecraftProtocol) getPacketProtocol()).setVersionCode(78);
    }

    public MC_1_6_4(String str, int i, MinecraftPacketProtocol minecraftPacketProtocol, GameProfile gameProfile, String str2, int i2) {
        super(str, i, minecraftPacketProtocol, gameProfile, str2, i2);
        System.out.println("Version: " + str2 + " code " + i2);
        ((MinecraftProtocol) getPacketProtocol()).setMode(ProtocolMode.LOGIN, true);
        ((MinecraftProtocol) getPacketProtocol()).setVersionCode(i2);
    }

    @Override // com.github.steveice10.mc.OldProtocol.MinecraftSession
    protected boolean receiveAndElaboratePackets(Packet packet) {
        if (packet instanceof PacketKeyRequest) {
            PacketKeyRequest packetKeyRequest = (PacketKeyRequest) packet;
            System.out.println("Encryption request starting!");
            System.out.println("Working with keys");
            this.key = CryptUtil.generateSharedKey();
            String string = new BigInteger(CryptUtil.getServerIdHash(packetKeyRequest.getServerId(), packetKeyRequest.getPublicKey(), this.key)).toString(16);
            String accessToken = ((MinecraftProtocol) this.minecraft_protcol).getAccessToken();
            boolean z = (accessToken == null || accessToken.equals(BuildConfig.FLAVOR)) ? false : true;
            if (z) {
                System.out.println("End working with keys");
                try {
                    System.out.println("Http request");
                    new SessionService().joinServer(this.profile, accessToken, string);
                    System.out.println("Second http request");
                    sendPacket(new PacketKeyResponse(this.key, packetKeyRequest.getPublicKey(), packetKeyRequest.getVerifyToken()));
                } catch (InvalidCredentialsException unused) {
                    callEvent(new DisconnectedEvent(this, "Login failed: Invalid login session."));
                    return false;
                } catch (ServiceUnavailableException unused2) {
                    callEvent(new DisconnectedEvent(this, "Login failed: Authentication service unavailable."));
                    return false;
                } catch (RequestException e) {
                    callEvent(new DisconnectedEvent(this, "Login failed: Authentication error: " + e.getMessage()));
                    return false;
                }
            } else {
                sendPacket(new PacketClientStatus((byte) 0));
            }
            System.out.println("Premium login: " + z);
            return z;
        }
        if (packet instanceof PacketKeepAlive) {
            sendPacket(new PacketKeepAlive(((PacketKeepAlive) packet).getId()));
        } else if (packet instanceof PacketDisconnect) {
            System.out.println("Sending disconnect event!");
            callEvent(new DisconnectedEvent(this, "Disconnected: " + ((PacketDisconnect) packet).getReason()));
        } else if (packet instanceof PacketKeyResponse) {
            System.out.println("Encryption response!");
            enableEncryption(this.key);
            sendPacket(new PacketClientStatus((byte) 0));
        }
        return true;
    }

    @Override // com.github.steveice10.mc.OldProtocol.MinecraftSession
    protected void login() {
        sendPacket(new PacketHandshake(this.username, this.host, this.port, this.MINECRAFT_VERSION_NUMBER));
    }
}
