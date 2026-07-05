package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.sound.BuiltinSound;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.sound.CustomSound;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.sound.Sound;
import com.github.steveice10.mc.v1_10.protocol.data.game.world.sound.SoundCategory;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ServerPlaySoundPacket implements Packet {
    private SoundCategory category;
    private float pitch;
    private Sound sound;
    private float volume;
    private double x;
    private double y;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlaySoundPacket() {
    }

    public ServerPlaySoundPacket(Sound sound, SoundCategory soundCategory, double d, double d2, double d3, float f, float f2) {
        this.sound = sound;
        this.category = soundCategory;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.volume = f;
        this.pitch = f2;
    }

    public Sound getSound() {
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
        String string = netInput.readString();
        try {
            this.sound = (Sound) MagicValues.key(BuiltinSound.class, string);
        } catch (IllegalArgumentException unused) {
            this.sound = new CustomSound(string);
        }
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
        this.pitch = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        String name = BuildConfig.FLAVOR;
        if (this.sound instanceof CustomSound) {
            name = ((CustomSound) this.sound).getName();
        } else if (this.sound instanceof BuiltinSound) {
            name = (String) MagicValues.value(String.class, this.sound);
        }
        netOutput.writeString(name);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.category)).intValue());
        netOutput.writeInt((int) (this.x * 8.0d));
        netOutput.writeInt((int) (this.y * 8.0d));
        netOutput.writeInt((int) (this.z * 8.0d));
        netOutput.writeFloat(this.volume);
        netOutput.writeFloat(this.pitch);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
