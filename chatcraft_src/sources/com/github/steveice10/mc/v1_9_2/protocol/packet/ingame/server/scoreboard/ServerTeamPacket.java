package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.scoreboard;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.scoreboard.CollisionRule;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.scoreboard.NameTagVisibility;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.scoreboard.TeamAction;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.scoreboard.TeamColor;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerTeamPacket implements Packet {
    private TeamAction action;
    private CollisionRule collisionRule;
    private TeamColor color;
    private String displayName;
    private boolean friendlyFire;
    private String name;
    private NameTagVisibility nameTagVisibility;
    private String[] players;
    private String prefix;
    private boolean seeFriendlyInvisibles;
    private String suffix;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerTeamPacket() {
    }

    public ServerTeamPacket(String str) {
        this.name = str;
        this.action = TeamAction.REMOVE;
    }

    public ServerTeamPacket(String str, TeamAction teamAction, String[] strArr) {
        if (teamAction != TeamAction.ADD_PLAYER && teamAction != TeamAction.REMOVE_PLAYER) {
            throw new IllegalArgumentException("(name, action, players) constructor only valid for adding and removing players.");
        }
        this.name = str;
        this.action = teamAction;
        this.players = strArr;
    }

    public ServerTeamPacket(String str, String str2, String str3, String str4, boolean z, boolean z2, NameTagVisibility nameTagVisibility, CollisionRule collisionRule, TeamColor teamColor) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = z;
        this.seeFriendlyInvisibles = z2;
        this.nameTagVisibility = nameTagVisibility;
        this.collisionRule = collisionRule;
        this.color = teamColor;
        this.action = TeamAction.UPDATE;
    }

    public ServerTeamPacket(String str, String str2, String str3, String str4, boolean z, boolean z2, NameTagVisibility nameTagVisibility, CollisionRule collisionRule, TeamColor teamColor, String[] strArr) {
        this.name = str;
        this.displayName = str2;
        this.prefix = str3;
        this.suffix = str4;
        this.friendlyFire = z;
        this.seeFriendlyInvisibles = z2;
        this.nameTagVisibility = nameTagVisibility;
        this.collisionRule = collisionRule;
        this.color = teamColor;
        this.players = strArr;
        this.action = TeamAction.CREATE;
    }

    public String getTeamName() {
        return this.name;
    }

    public TeamAction getAction() {
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

    public boolean getFriendlyFire() {
        return this.friendlyFire;
    }

    public boolean getSeeFriendlyInvisibles() {
        return this.seeFriendlyInvisibles;
    }

    public NameTagVisibility getNameTagVisibility() {
        return this.nameTagVisibility;
    }

    public CollisionRule getCollisionRule() {
        return this.collisionRule;
    }

    public TeamColor getColor() {
        return this.color;
    }

    public String[] getPlayers() {
        return this.players;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.name = netInput.readString();
        this.action = (TeamAction) MagicValues.key(TeamAction.class, Byte.valueOf(netInput.readByte()));
        if (this.action == TeamAction.CREATE || this.action == TeamAction.UPDATE) {
            this.displayName = netInput.readString();
            this.prefix = netInput.readString();
            this.suffix = netInput.readString();
            byte b2 = netInput.readByte();
            this.friendlyFire = (b2 & 1) != 0;
            this.seeFriendlyInvisibles = (b2 & 2) != 0;
            try {
                this.nameTagVisibility = (NameTagVisibility) MagicValues.key(NameTagVisibility.class, netInput.readString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.collisionRule = (CollisionRule) MagicValues.key(CollisionRule.class, netInput.readString());
            this.color = (TeamColor) MagicValues.key(TeamColor.class, Byte.valueOf(netInput.readByte()));
        }
        if (this.action == TeamAction.CREATE || this.action == TeamAction.ADD_PLAYER || this.action == TeamAction.REMOVE_PLAYER) {
            this.players = new String[netInput.readVarInt()];
            for (int i = 0; i < this.players.length; i++) {
                this.players[i] = netInput.readString();
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.name);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        if (this.action == TeamAction.CREATE || this.action == TeamAction.UPDATE) {
            netOutput.writeString(this.displayName);
            netOutput.writeString(this.prefix);
            netOutput.writeString(this.suffix);
            netOutput.writeByte((this.friendlyFire ? 1 : 0) | (this.seeFriendlyInvisibles ? 2 : 0));
            netOutput.writeString((String) MagicValues.value(String.class, this.nameTagVisibility));
            netOutput.writeString((String) MagicValues.value(String.class, this.collisionRule));
            netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.color)).intValue());
        }
        if (this.action == TeamAction.CREATE || this.action == TeamAction.ADD_PLAYER || this.action == TeamAction.REMOVE_PLAYER) {
            netOutput.writeVarInt(this.players.length);
            for (String str : this.players) {
                if (str != null) {
                    netOutput.writeString(str);
                }
            }
        }
    }
}
