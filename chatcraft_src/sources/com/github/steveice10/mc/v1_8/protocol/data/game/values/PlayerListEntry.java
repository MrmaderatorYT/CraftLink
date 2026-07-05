package com.github.steveice10.mc.v1_8.protocol.data.game.values;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.GameMode;
import com.github.steveice10.mc.v1_8.protocol.data.message.Message;

/* loaded from: classes.dex */
public class PlayerListEntry {
    private Message displayName;
    private GameMode gameMode;
    private int ping;
    private GameProfile profile;

    public PlayerListEntry(GameProfile gameProfile, GameMode gameMode, int i, Message message) {
        this.profile = gameProfile;
        this.gameMode = gameMode;
        this.ping = i;
        this.displayName = message;
    }

    public PlayerListEntry(GameProfile gameProfile, GameMode gameMode) {
        this.profile = gameProfile;
        this.gameMode = gameMode;
    }

    public PlayerListEntry(GameProfile gameProfile, int i) {
        this.profile = gameProfile;
        this.ping = i;
    }

    public PlayerListEntry(GameProfile gameProfile, Message message) {
        this.profile = gameProfile;
        this.displayName = message;
    }

    public PlayerListEntry(GameProfile gameProfile) {
        this.profile = gameProfile;
    }

    public GameProfile getProfile() {
        return this.profile;
    }

    public GameMode getGameMode() {
        return this.gameMode;
    }

    public int getPing() {
        return this.ping;
    }

    public Message getDisplayName() {
        return this.displayName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayerListEntry playerListEntry = (PlayerListEntry) obj;
        if (this.ping != playerListEntry.ping) {
            return false;
        }
        if (this.displayName == null ? playerListEntry.displayName == null : this.displayName.equals(playerListEntry.displayName)) {
            return this.gameMode == playerListEntry.gameMode && this.profile.equals(playerListEntry.profile);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.profile.hashCode() * 31) + (this.gameMode != null ? this.gameMode.hashCode() : 0)) * 31) + this.ping) * 31) + (this.displayName != null ? this.displayName.hashCode() : 0);
    }
}
