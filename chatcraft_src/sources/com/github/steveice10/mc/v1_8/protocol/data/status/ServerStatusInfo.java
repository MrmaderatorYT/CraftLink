package com.github.steveice10.mc.v1_8.protocol.data.status;

import android.graphics.Bitmap;
import com.github.steveice10.mc.common.Mod;
import com.github.steveice10.mc.v1_8.protocol.data.message.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ServerStatusInfo {
    private Message description;
    private Bitmap icon;
    private PlayerInfo players;
    private VersionInfo version;
    private boolean forge = false;
    private List<Mod> mods = new ArrayList();

    public ServerStatusInfo(VersionInfo versionInfo, PlayerInfo playerInfo, Message message, Bitmap bitmap) {
        this.version = versionInfo;
        this.players = playerInfo;
        this.description = message;
        this.icon = bitmap;
    }

    public void setForgeMods(Mod... modArr) {
        this.mods.clear();
        if (modArr.length == 0) {
            this.forge = false;
        } else {
            addForgeMods(modArr);
        }
    }

    public void addForgeMods(Mod... modArr) {
        this.forge = true;
        Collections.addAll(this.mods, modArr);
    }

    public boolean isForge() {
        return this.forge;
    }

    public List<Mod> getMods() {
        return this.mods;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerStatusInfo serverStatusInfo = (ServerStatusInfo) obj;
        if (!this.description.equals(serverStatusInfo.description)) {
            return false;
        }
        if (this.icon == null ? serverStatusInfo.icon == null : this.icon.equals(serverStatusInfo.icon)) {
            return this.players.equals(serverStatusInfo.players) && this.version.equals(serverStatusInfo.version);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.version.hashCode() * 31) + this.players.hashCode()) * 31) + this.description.hashCode()) * 31) + (this.icon != null ? this.icon.hashCode() : 0);
    }
}
