package com.github.steveice10.mc.v1_7_7.protocol.data.status;

import android.graphics.Bitmap;
import com.github.steveice10.mc.v1_7_7.protocol.data.message.Message;

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
}
