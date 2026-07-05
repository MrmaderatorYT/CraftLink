package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.PlayerListEntryAction;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.v1_9_2.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerPlayerListEntryPacket implements Packet {
    private PlayerListEntryAction action;
    private PlayerListEntry[] entries;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerListEntryPacket() {
    }

    public ServerPlayerListEntryPacket(PlayerListEntryAction playerListEntryAction, PlayerListEntry[] playerListEntryArr) {
        this.action = playerListEntryAction;
        this.entries = playerListEntryArr;
    }

    public PlayerListEntryAction getAction() {
        return this.action;
    }

    public PlayerListEntry[] getEntries() {
        return this.entries;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        GameProfile gameProfile;
        this.action = (PlayerListEntryAction) MagicValues.key(PlayerListEntryAction.class, Integer.valueOf(netInput.readVarInt()));
        this.entries = new PlayerListEntry[netInput.readVarInt()];
        for (int i = 0; i < this.entries.length; i++) {
            UUID uuid = netInput.readUUID();
            PlayerListEntry playerListEntry = null;
            if (this.action == PlayerListEntryAction.ADD_PLAYER) {
                gameProfile = new GameProfile(uuid, netInput.readString());
            } else {
                gameProfile = new GameProfile(uuid, (String) null);
            }
            switch (this.action) {
                case ADD_PLAYER:
                    int varInt = netInput.readVarInt();
                    for (int i2 = 0; i2 < varInt; i2++) {
                        gameProfile.getProperties().add(new GameProfile.Property(netInput.readString(), netInput.readString(), netInput.readBoolean() ? netInput.readString() : null));
                    }
                    playerListEntry = new PlayerListEntry(gameProfile, (GameMode) MagicValues.key(GameMode.class, Integer.valueOf(netInput.readVarInt())), netInput.readVarInt(), netInput.readBoolean() ? Message.fromString(netInput.readString()) : null);
                    continue;
                    this.entries[i] = playerListEntry;
                case UPDATE_GAMEMODE:
                    playerListEntry = new PlayerListEntry(gameProfile, (GameMode) MagicValues.key(GameMode.class, Integer.valueOf(netInput.readVarInt())));
                    continue;
                    this.entries[i] = playerListEntry;
                case UPDATE_LATENCY:
                    playerListEntry = new PlayerListEntry(gameProfile, netInput.readVarInt());
                    continue;
                    this.entries[i] = playerListEntry;
                case UPDATE_DISPLAY_NAME:
                    new PlayerListEntry(gameProfile, netInput.readBoolean() ? Message.fromString(netInput.readString()) : null);
                    break;
                case REMOVE_PLAYER:
                    break;
                default:
                    this.entries[i] = playerListEntry;
            }
            playerListEntry = new PlayerListEntry(gameProfile);
            this.entries[i] = playerListEntry;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        netOutput.writeVarInt(this.entries.length);
        for (PlayerListEntry playerListEntry : this.entries) {
            netOutput.writeUUID(playerListEntry.getProfile().getId());
            switch (this.action) {
                case ADD_PLAYER:
                    netOutput.writeString(playerListEntry.getProfile().getName());
                    netOutput.writeVarInt(playerListEntry.getProfile().getProperties().size());
                    for (GameProfile.Property property : playerListEntry.getProfile().getProperties()) {
                        netOutput.writeString(property.getName());
                        netOutput.writeString(property.getValue());
                        netOutput.writeBoolean(property.hasSignature());
                        if (property.hasSignature()) {
                            netOutput.writeString(property.getSignature());
                        }
                    }
                    netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, playerListEntry.getGameMode())).intValue());
                    netOutput.writeVarInt(playerListEntry.getPing());
                    netOutput.writeBoolean(playerListEntry.getDisplayName() != null);
                    if (playerListEntry.getDisplayName() != null) {
                        netOutput.writeString(playerListEntry.getDisplayName().toJsonString());
                        break;
                    } else {
                        break;
                    }
                case UPDATE_GAMEMODE:
                    netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, playerListEntry.getGameMode())).intValue());
                    break;
                case UPDATE_LATENCY:
                    netOutput.writeVarInt(playerListEntry.getPing());
                    break;
                case UPDATE_DISPLAY_NAME:
                    netOutput.writeBoolean(playerListEntry.getDisplayName() != null);
                    if (playerListEntry.getDisplayName() != null) {
                        netOutput.writeString(playerListEntry.getDisplayName().toJsonString());
                        break;
                    } else {
                        break;
                    }
            }
        }
    }
}
