package com.ccs.craftlink.autofeatures;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class PowerSaveManager {
    private static final String TAG = "PowerSaveManager";
    private static PowerSaveManager instance;

    public enum PowerMode {
        BALANCED,
        LOW_POWER,
        ULTRA_POWER_SAVING
    }

    public enum PacketType {
        KEEPALIVE,
        CHAT,
        POSITION,
        HEALTH,
        FOOD_LEVEL,
        INVENTORY,
        CHUNK_DATA,
        PLAYER_INFO,
        ENTITY_VELOCITY,
        TAB_COMPLETE,
        JOIN_GAME,
        DISCONNECT,
        COMBAT_EVENT,
        HEADER_AND_FOOTER
    }

    private PowerMode currentMode = PowerMode.BALANCED;
    private final Set<PacketType> disabledPackets = new HashSet<>();

    public static PowerSaveManager getInstance() {
        if (instance == null) {
            instance = new PowerSaveManager();
        }
        return instance;
    }

    private PowerSaveManager() {
        applyMode(currentMode);
    }

    public PowerMode getCurrentMode() { return currentMode; }

    public void setMode(PowerMode mode) {
        this.currentMode = mode;
        applyMode(mode);
        Log.i(TAG, "Power mode set to: " + mode);
    }

    public boolean isPacketEnabled(PacketType type) {
        return !disabledPackets.contains(type);
    }

    public void setPacketEnabled(PacketType type, boolean enabled) {
        if (enabled) {
            disabledPackets.remove(type);
        } else {
            disabledPackets.add(type);
        }
        Log.d(TAG, "Packet " + type + " " + (enabled ? "enabled" : "disabled"));
    }

    public Set<PacketType> getDisabledPackets() {
        return new HashSet<>(disabledPackets);
    }

    private void applyMode(PowerMode mode) {
        disabledPackets.clear();

        switch (mode) {
            case BALANCED:
                break;

            case LOW_POWER:
                disabledPackets.add(PacketType.HEALTH);
                disabledPackets.add(PacketType.FOOD_LEVEL);
                disabledPackets.add(PacketType.ENTITY_VELOCITY);
                disabledPackets.add(PacketType.TAB_COMPLETE);
                disabledPackets.add(PacketType.PLAYER_INFO);
                disabledPackets.add(PacketType.HEADER_AND_FOOTER);
                break;

            case ULTRA_POWER_SAVING:
                disabledPackets.add(PacketType.HEALTH);
                disabledPackets.add(PacketType.FOOD_LEVEL);
                disabledPackets.add(PacketType.ENTITY_VELOCITY);
                disabledPackets.add(PacketType.TAB_COMPLETE);
                disabledPackets.add(PacketType.PLAYER_INFO);
                disabledPackets.add(PacketType.CHUNK_DATA);
                disabledPackets.add(PacketType.INVENTORY);
                disabledPackets.add(PacketType.COMBAT_EVENT);
                disabledPackets.add(PacketType.HEADER_AND_FOOTER);
                break;
        }

        Log.i(TAG, "Disabled packets: " + disabledPackets);
    }

    public long getPollingIntervalMs() {
        switch (currentMode) {
            case ULTRA_POWER_SAVING: return 500;
            case LOW_POWER: return 200;
            case BALANCED: return 50;
            default: return 50;
        }
    }

    public boolean isPhysicsEnabled() {
        return currentMode == PowerMode.BALANCED;
    }

    public boolean isAutoEatAllowed() {
        return currentMode != PowerMode.ULTRA_POWER_SAVING;
    }
}
