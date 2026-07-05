package com.github.steveice10.mc.v1_7_7.protocol.data.status;

import com.github.steveice10.mc.auth.data.GameProfile;

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
}
