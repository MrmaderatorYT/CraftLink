package com.github.steveice10.mc.v1_8.protocol.data.status;

import com.github.steveice10.mc.auth.data.GameProfile;
import java.util.Arrays;

/* loaded from: classes.dex */
public class PlayerInfo {
    private int max;
    private int online;
    private GameProfile[] players;

    public PlayerInfo(int i, int i2, GameProfile[] gameProfileArr) {
        this.max = i;
        this.online = i2;
        this.players = gameProfileArr;
    }

    public int getMaxPlayers() {
        return this.max;
    }

    public int getOnlinePlayers() {
        return this.online;
    }

    public GameProfile[] getPlayers() {
        return this.players;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) obj;
        return this.max == playerInfo.max && this.online == playerInfo.online && Arrays.equals(this.players, playerInfo.players);
    }

    public int hashCode() {
        return (((this.max * 31) + this.online) * 31) + Arrays.hashCode(this.players);
    }
}
