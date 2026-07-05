package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerBlockValuePacket implements Packet {
    private static final int CHEST = 54;
    private static final int ENDER_CHEST = 130;
    private static final int MOB_SPAWNER = 52;
    private static final int NOTE_BLOCK = 25;
    private static final int PISTON = 33;
    private static final int STICKY_PISTON = 29;
    private static final int TRAPPED_CHEST = 146;
    private int blockId;
    private ValueType type;
    private Value value;
    private int x;
    private int y;
    private int z;

    public enum ChestValueType implements ValueType {
        VIEWING_PLAYER_COUNT
    }

    public enum GenericValueType implements ValueType {
        GENERIC
    }

    public enum MobSpawnerValue implements Value {
        VALUE
    }

    public enum MobSpawnerValueType implements ValueType {
        RESET_DELAY
    }

    public enum NoteBlockValueType implements ValueType {
        HARP,
        DOUBLE_BASS,
        SNARE_DRUM,
        HI_HAT,
        BASS_DRUM
    }

    public enum PistonValue implements Value {
        DOWN,
        UP,
        SOUTH,
        WEST,
        NORTH,
        EAST
    }

    public enum PistonValueType implements ValueType {
        PUSHING,
        PULLING
    }

    public interface Value {
    }

    public interface ValueType {
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBlockValuePacket() {
    }

    public ServerBlockValuePacket(int i, int i2, int i3, ValueType valueType, Value value, int i4) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.type = valueType;
        this.value = value;
        this.blockId = i4;
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

    public ValueType getType() {
        return this.type;
    }

    public Value getValue() {
        return this.value;
    }

    public int getBlockId() {
        return this.blockId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        this.type = intToType(netInput.readUnsignedByte());
        this.value = intToValue(netInput.readUnsignedByte());
        this.blockId = netInput.readVarInt() & 4095;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(typeToInt(this.type));
        netOutput.writeByte(valueToInt(this.value));
        netOutput.writeVarInt(this.blockId & 4095);
    }

    private ValueType intToType(int i) throws IOException {
        if (this.blockId == 25) {
            if (i == 0) {
                return NoteBlockValueType.HARP;
            }
            if (i == 1) {
                return NoteBlockValueType.DOUBLE_BASS;
            }
            if (i == 2) {
                return NoteBlockValueType.SNARE_DRUM;
            }
            if (i == 3) {
                return NoteBlockValueType.HI_HAT;
            }
            if (i == 4) {
                return NoteBlockValueType.BASS_DRUM;
            }
        } else if (this.blockId == 29 || this.blockId == 33) {
            if (i == 0) {
                return PistonValueType.PUSHING;
            }
            if (i == 1) {
                return PistonValueType.PULLING;
            }
        } else if (this.blockId == 52) {
            if (i == 1) {
                return MobSpawnerValueType.RESET_DELAY;
            }
        } else {
            if (this.blockId != 54 && this.blockId != ENDER_CHEST && this.blockId != TRAPPED_CHEST) {
                return GenericValueType.GENERIC;
            }
            if (i == 1) {
                return ChestValueType.VIEWING_PLAYER_COUNT;
            }
        }
        throw new IOException("Unknown value type id: " + i + ", " + this.blockId);
    }

    private int typeToInt(ValueType valueType) throws IOException {
        if (valueType == NoteBlockValueType.HARP) {
            return 0;
        }
        if (valueType == NoteBlockValueType.DOUBLE_BASS) {
            return 1;
        }
        if (valueType == NoteBlockValueType.SNARE_DRUM) {
            return 2;
        }
        if (valueType == NoteBlockValueType.HI_HAT) {
            return 3;
        }
        if (valueType == NoteBlockValueType.BASS_DRUM) {
            return 4;
        }
        if (valueType == PistonValueType.PUSHING) {
            return 0;
        }
        if (valueType == PistonValueType.PULLING || valueType == MobSpawnerValueType.RESET_DELAY || valueType == ChestValueType.VIEWING_PLAYER_COUNT) {
            return 1;
        }
        if (valueType == GenericValueType.GENERIC) {
            return 0;
        }
        throw new IOException("Unmapped value type: " + valueType);
    }

    private Value intToValue(int i) throws IOException {
        if (this.blockId == 25) {
            return new NoteBlockValue(i);
        }
        if (this.blockId == 29 || this.blockId == 33) {
            if (i == 0) {
                return PistonValue.DOWN;
            }
            if (i == 1) {
                return PistonValue.UP;
            }
            if (i == 2) {
                return PistonValue.SOUTH;
            }
            if (i == 3) {
                return PistonValue.WEST;
            }
            if (i == 4) {
                return PistonValue.NORTH;
            }
            if (i == 5) {
                return PistonValue.EAST;
            }
        } else {
            if (this.blockId != 52) {
                if (this.blockId == 54 || this.blockId == ENDER_CHEST || this.blockId == TRAPPED_CHEST) {
                    return new ChestValue(i);
                }
                return new GenericValue(i);
            }
            if (i == 0) {
                return MobSpawnerValue.VALUE;
            }
        }
        throw new IOException("Unknown value id: " + i + ", " + this.blockId);
    }

    private int valueToInt(Value value) throws IOException {
        if (value instanceof NoteBlockValue) {
            return ((NoteBlockValue) value).getPitch();
        }
        if (value == PistonValue.DOWN) {
            return 0;
        }
        if (value == PistonValue.UP) {
            return 1;
        }
        if (value == PistonValue.SOUTH) {
            return 2;
        }
        if (value == PistonValue.WEST) {
            return 3;
        }
        if (value == PistonValue.NORTH) {
            return 4;
        }
        if (value == PistonValue.EAST) {
            return 5;
        }
        if (value == MobSpawnerValue.VALUE) {
            return 0;
        }
        if (value instanceof ChestValue) {
            return ((ChestValue) value).getViewers();
        }
        if (value instanceof GenericValue) {
            return ((GenericValue) value).getValue();
        }
        throw new IOException("Unmapped value: " + value);
    }

    public static class GenericValue implements Value {
        private int value;

        public GenericValue(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class NoteBlockValue implements Value {
        private int pitch;

        public NoteBlockValue(int i) {
            if (i < 0 || i > 24) {
                throw new IllegalArgumentException("Pitch must be between 0 and 24.");
            }
            this.pitch = i;
        }

        public int getPitch() {
            return this.pitch;
        }
    }

    public static class ChestValue implements Value {
        private int viewers;

        public ChestValue(int i) {
            this.viewers = i;
        }

        public int getViewers() {
            return this.viewers;
        }
    }
}
