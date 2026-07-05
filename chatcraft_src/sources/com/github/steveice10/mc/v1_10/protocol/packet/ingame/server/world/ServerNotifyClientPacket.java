package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.ClientNotification;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.ClientNotificationValue;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.DemoMessageValue;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.EnterCreditsValue;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.RainStrengthValue;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.notify.ThunderStrengthValue;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerNotifyClientPacket implements Packet {
    private ClientNotification notification;
    private ClientNotificationValue value;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerNotifyClientPacket() {
    }

    public ServerNotifyClientPacket(ClientNotification clientNotification, ClientNotificationValue clientNotificationValue) {
        this.notification = clientNotification;
        this.value = clientNotificationValue;
    }

    public ClientNotification getNotification() {
        return this.notification;
    }

    public ClientNotificationValue getValue() {
        return this.value;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.notification = (ClientNotification) MagicValues.key(ClientNotification.class, Integer.valueOf(netInput.readUnsignedByte()));
        float f = netInput.readFloat();
        if (this.notification == ClientNotification.CHANGE_GAMEMODE) {
            this.value = (ClientNotificationValue) MagicValues.key(GameMode.class, Integer.valueOf((int) f));
            return;
        }
        if (this.notification == ClientNotification.DEMO_MESSAGE) {
            this.value = (ClientNotificationValue) MagicValues.key(DemoMessageValue.class, Integer.valueOf((int) f));
            return;
        }
        if (this.notification == ClientNotification.ENTER_CREDITS) {
            this.value = (ClientNotificationValue) MagicValues.key(EnterCreditsValue.class, Integer.valueOf((int) f));
        } else if (this.notification == ClientNotification.RAIN_STRENGTH) {
            this.value = new RainStrengthValue(f);
        } else if (this.notification == ClientNotification.THUNDER_STRENGTH) {
            this.value = new ThunderStrengthValue(f);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        float strength;
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.notification)).intValue());
        if (this.value instanceof Enum) {
            strength = ((Integer) MagicValues.value(Integer.class, (Enum) this.value)).intValue();
        } else if (this.value instanceof RainStrengthValue) {
            strength = ((RainStrengthValue) this.value).getStrength();
        } else {
            strength = this.value instanceof ThunderStrengthValue ? ((ThunderStrengthValue) this.value).getStrength() : 0.0f;
        }
        netOutput.writeFloat(strength);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
