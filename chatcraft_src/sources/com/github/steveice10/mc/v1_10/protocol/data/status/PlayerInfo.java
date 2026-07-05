package com.github.steveice10.mc.v1_10.protocol.data.status;

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
        if (obj instanceof PlayerInfo) {
            PlayerInfo playerInfo = (PlayerInfo) obj;
            if (this.max == playerInfo.max && this.online == playerInfo.online && Arrays.deepEquals(this.players, playerInfo.players)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.max * 31) + this.online) * 31) + Arrays.deepHashCode(this.players);
    }
}
