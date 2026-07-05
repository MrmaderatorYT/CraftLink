package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerNotifyClientPacket implements Packet {
    private Notification notification;
    private NotificationValue value;

    public enum DemoMessageValue implements NotificationValue {
        WELCOME,
        MOVEMENT_CONTROLS,
        JUMP_CONTROL,
        INVENTORY_CONTROL
    }

    public enum GameModeValue implements NotificationValue {
        SURVIVAL,
        CREATIVE,
        ADVENTURE
    }

    public enum Notification {
        INVALID_BED,
        START_RAIN,
        STOP_RAIN,
        CHANGE_GAMEMODE,
        ENTER_CREDITS,
        DEMO_MESSAGE,
        ARROW_HIT_PLAYER,
        RAIN_STRENGTH,
        THUNDER_STRENGTH
    }

    public interface NotificationValue {
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerNotifyClientPacket() {
    }

    public ServerNotifyClientPacket(Notification notification, NotificationValue notificationValue) {
        this.notification = notification;
        this.value = notificationValue;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public NotificationValue getValue() {
        return this.value;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.notification = Notification.values()[netInput.readUnsignedByte()];
        this.value = floatToValue(netInput.readFloat());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.notification.ordinal());
        netOutput.writeFloat(valueToFloat(this.value));
    }

    private NotificationValue floatToValue(float f) {
        if (this.notification == Notification.CHANGE_GAMEMODE) {
            if (f == 0.0f) {
                return GameModeValue.SURVIVAL;
            }
            if (f == 1.0f) {
                return GameModeValue.CREATIVE;
            }
            if (f == 2.0f) {
                return GameModeValue.ADVENTURE;
            }
            return null;
        }
        if (this.notification != Notification.DEMO_MESSAGE) {
            if (this.notification == Notification.RAIN_STRENGTH) {
                return new RainStrengthValue((int) f);
            }
            if (this.notification == Notification.THUNDER_STRENGTH) {
                return new ThunderStrengthValue((int) f);
            }
            return null;
        }
        if (f == 0.0f) {
            return DemoMessageValue.WELCOME;
        }
        if (f == 101.0f) {
            return DemoMessageValue.MOVEMENT_CONTROLS;
        }
        if (f == 102.0f) {
            return DemoMessageValue.JUMP_CONTROL;
        }
        if (f == 103.0f) {
            return DemoMessageValue.INVENTORY_CONTROL;
        }
        return null;
    }

    private float valueToFloat(NotificationValue notificationValue) {
        if (notificationValue == GameModeValue.SURVIVAL) {
            return 0.0f;
        }
        if (notificationValue == GameModeValue.CREATIVE) {
            return 1.0f;
        }
        if (notificationValue == GameModeValue.ADVENTURE) {
            return 2.0f;
        }
        if (notificationValue == DemoMessageValue.WELCOME) {
            return 0.0f;
        }
        if (notificationValue == DemoMessageValue.MOVEMENT_CONTROLS) {
            return 101.0f;
        }
        if (notificationValue == DemoMessageValue.JUMP_CONTROL) {
            return 102.0f;
        }
        if (notificationValue == DemoMessageValue.INVENTORY_CONTROL) {
            return 103.0f;
        }
        if (notificationValue instanceof RainStrengthValue) {
            return ((RainStrengthValue) notificationValue).getStrength();
        }
        if (notificationValue instanceof ThunderStrengthValue) {
            return ((ThunderStrengthValue) notificationValue).getStrength();
        }
        return 0.0f;
    }

    public static class RainStrengthValue implements NotificationValue {
        private float strength;

        public RainStrengthValue(float f) {
            f = f > 1.0f ? 1.0f : f;
            this.strength = f < 0.0f ? 0.0f : f;
        }

        public float getStrength() {
            return this.strength;
        }
    }

    public static class ThunderStrengthValue implements NotificationValue {
        private float strength;

        public ThunderStrengthValue(float f) {
            f = f > 1.0f ? 1.0f : f;
            this.strength = f < 0.0f ? 0.0f : f;
        }

        public float getStrength() {
            return this.strength;
        }
    }
}
