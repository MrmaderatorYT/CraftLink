package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerPlayEffectPacket implements Packet {
    private boolean broadcast;
    private EffectData data;
    private Effect effect;
    private int x;
    private int y;
    private int z;

    public interface Effect {
    }

    public interface EffectData {
    }

    public enum ParticleEffect implements Effect {
        SMOKE,
        BREAK_BLOCK,
        BREAK_SPLASH_POTION,
        BREAK_EYE_OF_ENDER,
        MOB_SPAWN,
        BONEMEAL_GROW,
        HARD_LANDING_DUST
    }

    public enum SmokeData implements EffectData {
        SOUTH_EAST,
        SOUTH,
        SOUTH_WEST,
        EAST,
        UP,
        WEST,
        NORTH_EAST,
        NORTH,
        NORTH_WEST
    }

    public enum SoundEffect implements Effect {
        CLICK,
        EMPTY_DISPENSER_CLICK,
        FIRE_PROJECTILE,
        DOOR,
        FIZZLE,
        PLAY_RECORD,
        GHAST_CHARGE,
        GHAST_FIRE,
        BLAZE_FIRE,
        POUND_WOODEN_DOOR,
        POUND_METAL_DOOR,
        BREAK_WOODEN_DOOR,
        WITHER_SPAWN,
        WITHER_SHOOT,
        BAT_TAKE_OFF,
        INFECT_VILLAGER,
        DISINFECT_VILLAGER,
        ENDER_DRAGON_DEATH,
        ANVIL_BREAK,
        ANVIL_USE,
        ANVIL_LAND
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayEffectPacket() {
    }

    public ServerPlayEffectPacket(Effect effect, int i, int i2, int i3, EffectData effectData) {
        this(effect, i, i2, i3, effectData, false);
    }

    public ServerPlayEffectPacket(Effect effect, int i, int i2, int i3, EffectData effectData, boolean z) {
        this.effect = effect;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.data = effectData;
        this.broadcast = z;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public EffectData getData() {
        return this.data;
    }

    public boolean getBroadcast() {
        return this.broadcast;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.effect = idToEffect(netInput.readInt());
        this.x = netInput.readInt();
        this.y = netInput.readUnsignedByte();
        this.z = netInput.readInt();
        this.data = valueToData(netInput.readInt());
        this.broadcast = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(effectToId(this.effect));
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeInt(dataToValue(this.data));
        netOutput.writeBoolean(this.broadcast);
    }

    private Effect idToEffect(int i) throws IOException {
        switch (i) {
            case 1000:
                return SoundEffect.CLICK;
            case 1001:
                return SoundEffect.EMPTY_DISPENSER_CLICK;
            case 1002:
                return SoundEffect.FIRE_PROJECTILE;
            case 1003:
                return SoundEffect.DOOR;
            case 1004:
                return SoundEffect.FIZZLE;
            case 1005:
                return SoundEffect.PLAY_RECORD;
            case 1006:
            case 1019:
            default:
                switch (i) {
                    case 2000:
                        return ParticleEffect.SMOKE;
                    case 2001:
                        return ParticleEffect.BREAK_BLOCK;
                    case 2002:
                        return ParticleEffect.BREAK_SPLASH_POTION;
                    case 2003:
                        return ParticleEffect.BREAK_EYE_OF_ENDER;
                    case 2004:
                        return ParticleEffect.MOB_SPAWN;
                    case 2005:
                        return ParticleEffect.BONEMEAL_GROW;
                    case 2006:
                        return ParticleEffect.HARD_LANDING_DUST;
                    default:
                        throw new IOException("Unknown effect id: " + i);
                }
            case 1007:
                return SoundEffect.GHAST_CHARGE;
            case 1008:
                return SoundEffect.GHAST_FIRE;
            case 1009:
                return SoundEffect.BLAZE_FIRE;
            case 1010:
                return SoundEffect.POUND_WOODEN_DOOR;
            case 1011:
                return SoundEffect.POUND_METAL_DOOR;
            case 1012:
                return SoundEffect.BREAK_WOODEN_DOOR;
            case 1013:
                return SoundEffect.WITHER_SPAWN;
            case 1014:
                return SoundEffect.WITHER_SHOOT;
            case 1015:
                return SoundEffect.BAT_TAKE_OFF;
            case 1016:
                return SoundEffect.INFECT_VILLAGER;
            case 1017:
                return SoundEffect.DISINFECT_VILLAGER;
            case 1018:
                return SoundEffect.ENDER_DRAGON_DEATH;
            case 1020:
                return SoundEffect.ANVIL_BREAK;
            case 1021:
                return SoundEffect.ANVIL_USE;
            case 1022:
                return SoundEffect.ANVIL_LAND;
        }
    }

    private int effectToId(Effect effect) throws IOException {
        if (effect == SoundEffect.CLICK) {
            return 1000;
        }
        if (effect == SoundEffect.EMPTY_DISPENSER_CLICK) {
            return 1001;
        }
        if (effect == SoundEffect.FIRE_PROJECTILE) {
            return 1002;
        }
        if (effect == SoundEffect.DOOR) {
            return 1003;
        }
        if (effect == SoundEffect.FIZZLE) {
            return 1004;
        }
        if (effect == SoundEffect.PLAY_RECORD) {
            return 1005;
        }
        if (effect == SoundEffect.GHAST_CHARGE) {
            return 1007;
        }
        if (effect == SoundEffect.GHAST_FIRE) {
            return 1008;
        }
        if (effect == SoundEffect.BLAZE_FIRE) {
            return 1009;
        }
        if (effect == SoundEffect.POUND_WOODEN_DOOR) {
            return 1010;
        }
        if (effect == SoundEffect.POUND_METAL_DOOR) {
            return 1011;
        }
        if (effect == SoundEffect.BREAK_WOODEN_DOOR) {
            return 1012;
        }
        if (effect == SoundEffect.WITHER_SPAWN) {
            return 1013;
        }
        if (effect == SoundEffect.WITHER_SHOOT) {
            return 1014;
        }
        if (effect == SoundEffect.BAT_TAKE_OFF) {
            return 1015;
        }
        if (effect == SoundEffect.INFECT_VILLAGER) {
            return 1016;
        }
        if (effect == SoundEffect.DISINFECT_VILLAGER) {
            return 1017;
        }
        if (effect == SoundEffect.ENDER_DRAGON_DEATH) {
            return 1018;
        }
        if (effect == SoundEffect.ANVIL_BREAK) {
            return 1020;
        }
        if (effect == SoundEffect.ANVIL_USE) {
            return 1021;
        }
        if (effect == SoundEffect.ANVIL_LAND) {
            return 1022;
        }
        if (effect == ParticleEffect.SMOKE) {
            return 2000;
        }
        if (effect == ParticleEffect.BREAK_BLOCK) {
            return 2001;
        }
        if (effect == ParticleEffect.BREAK_SPLASH_POTION) {
            return 2002;
        }
        if (effect == ParticleEffect.BREAK_EYE_OF_ENDER) {
            return 2003;
        }
        if (effect == ParticleEffect.MOB_SPAWN) {
            return 2004;
        }
        if (effect == ParticleEffect.BONEMEAL_GROW) {
            return 2005;
        }
        if (effect == ParticleEffect.HARD_LANDING_DUST) {
            return 2006;
        }
        throw new IOException("Unmapped effect: " + effect);
    }

    private EffectData valueToData(int i) {
        if (this.effect == SoundEffect.PLAY_RECORD) {
            return new RecordData(i);
        }
        if (this.effect != ParticleEffect.SMOKE) {
            if (this.effect == ParticleEffect.BREAK_BLOCK) {
                return new BreakBlockData(i);
            }
            if (this.effect == ParticleEffect.BREAK_SPLASH_POTION) {
                return new BreakPotionData(i);
            }
            if (this.effect == ParticleEffect.HARD_LANDING_DUST) {
                return new HardLandingData(i);
            }
            return null;
        }
        if (i == 0) {
            return SmokeData.SOUTH_EAST;
        }
        if (i == 1) {
            return SmokeData.SOUTH;
        }
        if (i == 2) {
            return SmokeData.SOUTH_WEST;
        }
        if (i == 3) {
            return SmokeData.EAST;
        }
        if (i == 4) {
            return SmokeData.UP;
        }
        if (i == 5) {
            return SmokeData.WEST;
        }
        if (i == 6) {
            return SmokeData.NORTH_EAST;
        }
        if (i == 7) {
            return SmokeData.NORTH;
        }
        if (i == 8) {
            return SmokeData.NORTH_WEST;
        }
        return null;
    }

    private int dataToValue(EffectData effectData) {
        if (effectData instanceof RecordData) {
            return ((RecordData) effectData).getRecordId();
        }
        if (effectData instanceof SmokeData) {
            if (effectData == SmokeData.SOUTH_EAST) {
                return 0;
            }
            if (effectData == SmokeData.SOUTH) {
                return 1;
            }
            if (effectData == SmokeData.SOUTH_WEST) {
                return 2;
            }
            if (effectData == SmokeData.EAST) {
                return 3;
            }
            if (effectData == SmokeData.UP) {
                return 4;
            }
            if (effectData == SmokeData.WEST) {
                return 5;
            }
            if (effectData == SmokeData.NORTH_EAST) {
                return 6;
            }
            if (effectData == SmokeData.NORTH) {
                return 7;
            }
            if (effectData == SmokeData.NORTH_WEST) {
                return 8;
            }
        }
        if (effectData instanceof BreakBlockData) {
            return ((BreakBlockData) effectData).getBlockId();
        }
        if (effectData instanceof BreakPotionData) {
            return ((BreakPotionData) effectData).getPotionId();
        }
        if (effectData instanceof HardLandingData) {
            return ((HardLandingData) effectData).getDamagingDistance();
        }
        return 0;
    }

    public static class RecordData implements EffectData {
        private int recordId;

        public RecordData(int i) {
            this.recordId = i;
        }

        public int getRecordId() {
            return this.recordId;
        }
    }

    public static class BreakBlockData implements EffectData {
        private int blockId;

        public BreakBlockData(int i) {
            this.blockId = i;
        }

        public int getBlockId() {
            return this.blockId;
        }
    }

    public static class BreakPotionData implements EffectData {
        private int potionId;

        public BreakPotionData(int i) {
            this.potionId = i;
        }

        public int getPotionId() {
            return this.potionId;
        }
    }

    public static class HardLandingData implements EffectData {
        private int damagingDistance;

        public HardLandingData(int i) {
            this.damagingDistance = i;
        }

        public int getDamagingDistance() {
            return this.damagingDistance;
        }
    }
}
