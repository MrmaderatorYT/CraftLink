package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerTeamPacket implements Packet {
    private Action action;
    private String displayName;
    private FriendlyFireMode friendlyFire;
    private String name;
    private String[] players;
    private String prefix;
    private String suffix;

    public enum Action {
        CREATE,
        REMOVE,
        UPDATE,
        ADD_PLAYER,
        REMOVE_PLAYER
    }

    public enum FriendlyFireMode {
        OFF,
        ON,
        FRIENDLY_INVISIBLES_VISIBLE
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerTeamPacket() {
    }

    public ServerTeamPacket(String str) {
        this.name = str;
        this.action = Action.REMOVE;
    }

    public ServerTeamPacket(String str, Action action, String[] strArr) {
        if (action != Action.ADD_PLAYER && action != Action.REMOVE_PLAYER) {
            throw new IllegalArgumentException("(name, action, players) constructor only valid for adding and removing players.");
        }
        this.name = str;
        this.action = action;
        this.players = strArr;
    }

    public ServerTeamPacket(String str, String str2, String str3, String str4, FriendlyFireMode friendlyFireMode) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = friendlyFireMode;
        this.action = Action.UPDATE;
    }

    public ServerTeamPacket(String str, String str2, String str3, String str4, FriendlyFireMode friendlyFireMode, String[] strArr) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = friendlyFireMode;
        this.players = strArr;
        this.action = Action.CREATE;
    }

    public String getTeamName() {
        return this.name;
    }

    public Action getAction() {
        return this.action;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public FriendlyFireMode getFriendlyFire() {
        return this.friendlyFire;
    }

    public String[] getPlayers() {
        return this.players;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.action = Action.values()[netInput.readByte()];
        if (this.action == Action.CREATE || this.action == Action.UPDATE) {
            this.displayName = netInput.readString();
            this.prefix = netInput.readString();
            this.suffix = netInput.readString();
            byte b2 = netInput.readByte();
            this.friendlyFire = b2 == 3 ? FriendlyFireMode.FRIENDLY_INVISIBLES_VISIBLE : FriendlyFireMode.values()[b2];
        }
        if (this.action == Action.CREATE || this.action == Action.ADD_PLAYER || this.action == Action.REMOVE_PLAYER) {
            this.players = new String[netInput.readShort()];
            for (int i = 0; i < this.players.length; i++) {
                this.players[i] = netInput.readString();
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeByte(this.action.ordinal());
        if (this.action == Action.CREATE || this.action == Action.UPDATE) {
            netOutput.writeString(this.displayName);
            netOutput.writeString(this.prefix);
            netOutput.writeString(this.suffix);
            netOutput.writeByte(this.friendlyFire == FriendlyFireMode.FRIENDLY_INVISIBLES_VISIBLE ? 3 : this.friendlyFire.ordinal());
        }
        if (this.action == Action.CREATE || this.action == Action.ADD_PLAYER || this.action == Action.REMOVE_PLAYER) {
            netOutput.writeShort(this.players.length);
            for (String str : this.players) {
                netOutput.writeString(str);
            }
        }
    }
}
