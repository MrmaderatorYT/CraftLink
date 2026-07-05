package com.github.steveice10.mc.v1_9.protocol.packet.status.server;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.v1_9.protocol.data.message.Message;
import com.github.steveice10.mc.v1_9.protocol.data.status.PlayerInfo;
import com.github.steveice10.mc.v1_9.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.v1_9.protocol.data.status.VersionInfo;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.n;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class StatusResponsePacket implements Packet {
    private ServerStatusInfo info;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private StatusResponsePacket() {
    }

    public StatusResponsePacket(ServerStatusInfo serverStatusInfo) {
        this.info = serverStatusInfo;
    }

    public ServerStatusInfo getInfo() {
        return this.info;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        n nVar = (n) new f().a(netInput.readString(), n.class);
        n nVarL = nVar.b("version").l();
        VersionInfo versionInfo = new VersionInfo(nVarL.b("name").c(), nVarL.b("protocol").f());
        n nVarL2 = nVar.b("players").l();
        GameProfile[] gameProfileArr = new GameProfile[0];
        if (nVarL2.a("sample")) {
            i iVarM = nVarL2.b("sample").m();
            if (iVarM.a() > 0) {
                gameProfileArr = new GameProfile[iVarM.a()];
                for (int i = 0; i < iVarM.a(); i++) {
                    n nVarL3 = iVarM.a(i).l();
                    gameProfileArr[i] = new GameProfile(nVarL3.b("id").c(), nVarL3.b("name").c());
                }
            }
        }
        this.info = new ServerStatusInfo(versionInfo, new PlayerInfo(nVarL2.b("max").f(), nVarL2.b("online").f(), gameProfileArr), Message.fromJson(nVar.b("description")), nVar.a("favicon") ? stringToIcon(nVar.b("favicon").c()) : null);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        n nVar = new n();
        n nVar2 = new n();
        nVar2.a("name", this.info.getVersionInfo().getVersionName());
        nVar2.a("protocol", Integer.valueOf(this.info.getVersionInfo().getProtocolVersion()));
        n nVar3 = new n();
        nVar3.a("max", Integer.valueOf(this.info.getPlayerInfo().getMaxPlayers()));
        nVar3.a("online", Integer.valueOf(this.info.getPlayerInfo().getOnlinePlayers()));
        if (this.info.getPlayerInfo().getPlayers().length > 0) {
            i iVar = new i();
            for (GameProfile gameProfile : this.info.getPlayerInfo().getPlayers()) {
                n nVar4 = new n();
                nVar4.a("name", gameProfile.getName());
                nVar4.a("id", gameProfile.getIdAsString());
                iVar.a(nVar4);
            }
            nVar3.a("sample", iVar);
        }
        nVar.a("version", nVar2);
        nVar.a("players", nVar3);
        nVar.a("description", this.info.getDescription().toJson());
        if (this.info.getIcon() != null) {
            nVar.a("favicon", iconToString(this.info.getIcon()));
        }
        netOutput.writeString(nVar.toString());
    }

    private Bitmap stringToIcon(String str) {
        if (str.startsWith("data:image/png;base64,")) {
            str = str.substring("data:image/png;base64,".length());
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String iconToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
