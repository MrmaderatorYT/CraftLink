package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ServerSpawnParticlePacket implements Packet {
    private int amount;
    private float offsetX;
    private float offsetY;
    private float offsetZ;
    private String particle;
    private float velocityOffset;
    private float x;
    private float y;
    private float z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnParticlePacket() {
    }

    public ServerSpawnParticlePacket(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.particle = str;
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.offsetX = f4;
        this.offsetY = f5;
        this.offsetZ = f6;
        this.velocityOffset = f7;
        this.amount = i;
    }

    public String getParticle() {
        return this.particle;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getOffsetZ() {
        return this.offsetZ;
    }

    public float getVelocityOffset() {
        return this.velocityOffset;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.particle = netInput.readString();
        this.x = netInput.readFloat();
        this.y = netInput.readFloat();
        this.z = netInput.readFloat();
        this.offsetX = netInput.readFloat();
        this.offsetY = netInput.readFloat();
        this.offsetZ = netInput.readFloat();
        this.velocityOffset = netInput.readFloat();
        this.amount = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.particle);
        netOutput.writeFloat(this.x);
        netOutput.writeFloat(this.y);
        netOutput.writeFloat(this.z);
        netOutput.writeFloat(this.offsetX);
        netOutput.writeFloat(this.offsetY);
        netOutput.writeFloat(this.offsetZ);
        netOutput.writeFloat(this.velocityOffset);
        netOutput.writeInt(this.amount);
    }

    public static class Particle {
        public static final String ANGRY_VILLAGER = "angryVillager";
        private static final String BLOCK_BREAK_PREFIX = "blockcrack_";
        private static final String BLOCK_IMPACT_PREFIX = "blockdust_";
        public static final String BREAKING_SNOWBALL = "snowballpoof";
        public static final String CLOUD = "cloud";
        public static final String CRITICAL_HIT = "crit";
        public static final String DEPTH_PARTICLES = "depthsuspend";
        public static final String DRIP_LAVA = "dripLava";
        public static final String DRIP_WATER = "dripWater";
        public static final String ENCHANTED_CRITICAL_HIT = "magicCrit";
        public static final String ENCHANTMENT_TABLE_LETTERS = "enchantmenttable";
        public static final String EXPLOSION = "explode";
        public static final String FIREWORKS_SPARK = "fireworksSpark";
        public static final String FISH_HOOK_WAKE = "wake";
        public static final String FLAME = "flame";
        public static final String FOOTSTEP_PARTICLES = "footstep";
        public static final String HAPPY_VILLAGER = "happyVillager";
        public static final String HEART = "heart";
        public static final String HUGE_EXPLOSION = "hugeexplosion";
        public static final String INSTANT_POTION_EFFECT = "instantSpell";
        private static final String ITEM_BREAK_PREFIX = "iconcrack_";
        public static final String LARGE_EXPLOSION = "largeexplode";
        public static final String LARGE_SMOKE = "largesmoke";
        public static final String LAVA_PARTICLES = "lava";
        public static final String LIQUID_PARTICLES = "suspended";
        public static final String MOB_POTION_EFFECT = "mobSpell";
        public static final String MOB_POTION_EFFECT_AMBIENT = "mobSpellAmbient";
        public static final String MYCELIUM_PARTICLES = "townaura";
        public static final String NOTE = "note";
        public static final String PORTAL = "portal";
        public static final String POTION_EFFECT = "spell";
        public static final String REDSTONE_PARTICLES = "reddust";
        public static final String SHOVEL_SNOW = "snowshovel";
        public static final String SLIME = "slime";
        public static final String SMOKE = "smoke";
        public static final String SPLASH = "splash";
        public static final String WITCH_PARTICLES = "witchMagic";

        public static final String ITEM_BREAK_PARTICLES(int i) {
            return ITEM_BREAK_PARTICLES(i, -1);
        }

        public static final String ITEM_BREAK_PARTICLES(int i, int i2) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(ITEM_BREAK_PREFIX);
            sb.append(i);
            if (i2 != -1) {
                str = "_" + i2;
            } else {
                str = BuildConfig.FLAVOR;
            }
            sb.append(str);
            return sb.toString();
        }

        public static final String BLOCK_BREAK_PARTICLES(int i) {
            return BLOCK_BREAK_PARTICLES(i, -1);
        }

        public static final String BLOCK_BREAK_PARTICLES(int i, int i2) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(BLOCK_BREAK_PREFIX);
            sb.append(i);
            if (i2 != -1) {
                str = "_" + i2;
            } else {
                str = BuildConfig.FLAVOR;
            }
            sb.append(str);
            return sb.toString();
        }

        public static final String BLOCK_IMPACT_PARTICLES(int i) {
            return BLOCK_IMPACT_PARTICLES(i, -1);
        }

        public static final String BLOCK_IMPACT_PARTICLES(int i, int i2) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(BLOCK_IMPACT_PREFIX);
            sb.append(i);
            if (i2 != -1) {
                str = "_" + i2;
            } else {
                str = BuildConfig.FLAVOR;
            }
            sb.append(str);
            return sb.toString();
        }
    }
}
