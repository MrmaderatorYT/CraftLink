package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.sound.BuiltinSound;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.sound.SoundCategory;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayBuiltinSoundPacket implements Packet {
    private SoundCategory category;
    private float pitch;
    private BuiltinSound sound;
    private float volume;
    private double x;
    private double y;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayBuiltinSoundPacket() {
    }

    public ServerPlayBuiltinSoundPacket(BuiltinSound builtinSound, SoundCategory soundCategory, double d, double d2, double d3, float f, float f2) {
        this.sound = builtinSound;
        this.category = soundCategory;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.volume = f;
        this.pitch = f2;
    }

    public BuiltinSound getSound() {
        return this.sound;
    }

    public SoundCategory getCategory() {
        return this.category;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getVolume() {
        return this.volume;
    }

    public float getPitch() {
        return this.pitch;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.sound = (BuiltinSound) MagicValues.key(BuiltinSound.class, Integer.valueOf(netInput.readVarInt()));
        this.category = (SoundCategory) MagicValues.key(SoundCategory.class, Integer.valueOf(netInput.readVarInt()));
        double d = netInput.readInt();
        Double.isNaN(d);
        this.x = d / 8.0d;
        double d2 = netInput.readInt();
        Double.isNaN(d2);
        this.y = d2 / 8.0d;
        double d3 = netInput.readInt();
        Double.isNaN(d3);
        this.z = d3 / 8.0d;
        this.volume = netInput.readFloat();
        this.pitch = netInput.readUnsignedByte() / 63.5f;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.sound)).intValue());
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.category)).intValue());
        netOutput.writeInt((int) (this.x * 8.0d));
        netOutput.writeInt((int) (this.y * 8.0d));
        netOutput.writeInt((int) (this.z * 8.0d));
        netOutput.writeFloat(this.volume);
        int i = (int) (this.pitch * 63.5f);
        if (i > 255) {
            i = 255;
        }
        if (i < 0) {
            i = 0;
        }
        netOutput.writeByte(i);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
