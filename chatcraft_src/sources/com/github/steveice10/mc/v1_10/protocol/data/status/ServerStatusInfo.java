package com.github.steveice10.mc.v1_10.protocol.data.status;

import android.graphics.Bitmap;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;

/* loaded from: classes.dex */
public class ServerStatusInfo {
    private Message description;
    private Bitmap icon;
    private PlayerInfo players;
    private VersionInfo version;

    public ServerStatusInfo(VersionInfo versionInfo, PlayerInfo playerInfo, Message message, Bitmap bitmap) {
        this.version = versionInfo;
        this.players = playerInfo;
        this.description = message;
        this.icon = bitmap;
    }

    public VersionInfo getVersionInfo() {
        return this.version;
    }

    public PlayerInfo getPlayerInfo() {
        return this.players;
    }

    public Message getDescription() {
        return this.description;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ServerStatusInfo) {
            ServerStatusInfo serverStatusInfo = (ServerStatusInfo) obj;
            if (this.version.equals(serverStatusInfo.version) && this.players.equals(serverStatusInfo.players) && this.description.equals(serverStatusInfo.description) && (this.icon == null ? serverStatusInfo.icon == null : this.icon.equals(serverStatusInfo.icon))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.version.hashCode() * 31) + this.players.hashCode()) * 31) + this.description.hashCode()) * 31) + (this.icon != null ? this.icon.hashCode() : 0);
    }
}
