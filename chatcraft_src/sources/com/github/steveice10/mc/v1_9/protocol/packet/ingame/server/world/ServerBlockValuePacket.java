package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.BlockValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.BlockValueType;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.ChestValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.ChestValueType;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.GenericBlockValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.GenericBlockValueType;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.MobSpawnerValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.MobSpawnerValueType;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.NoteBlockValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.NoteBlockValueType;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.PistonValue;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value.PistonValueType;
import com.github.steveice10.mc.v1_9.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

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
    private Position position;
    private BlockValueType type;
    private BlockValue value;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBlockValuePacket() {
    }

    public ServerBlockValuePacket(Position position, BlockValueType blockValueType, BlockValue blockValue, int i) {
        this.position = position;
        this.type = blockValueType;
        this.value = blockValue;
        this.blockId = i;
    }

    public Position getPosition() {
        return this.position;
    }

    public BlockValueType getType() {
        return this.type;
    }

    public BlockValue getValue() {
        return this.value;
    }

    public int getBlockId() {
        return this.blockId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = NetUtil.readPosition(netInput);
        int unsignedByte = netInput.readUnsignedByte();
        try {
            if (this.blockId == 25) {
                this.type = (BlockValueType) MagicValues.key(NoteBlockValueType.class, Integer.valueOf(unsignedByte));
            } else if (this.blockId == 29 || this.blockId == 33) {
                this.type = (BlockValueType) MagicValues.key(PistonValueType.class, Integer.valueOf(unsignedByte));
            } else if (this.blockId == 52) {
                this.type = (BlockValueType) MagicValues.key(MobSpawnerValueType.class, Integer.valueOf(unsignedByte));
            } else if (this.blockId == 54 || this.blockId == ENDER_CHEST || this.blockId == TRAPPED_CHEST) {
                this.type = (BlockValueType) MagicValues.key(ChestValueType.class, Integer.valueOf(unsignedByte));
            } else {
                this.type = (BlockValueType) MagicValues.key(GenericBlockValueType.class, Integer.valueOf(unsignedByte));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int unsignedByte2 = netInput.readUnsignedByte();
        try {
            if (this.blockId == 25) {
                this.value = new NoteBlockValue(unsignedByte2);
            } else if (this.blockId == 29 || this.blockId == 33) {
                this.value = (BlockValue) MagicValues.key(PistonValue.class, Integer.valueOf(unsignedByte2));
            } else if (this.blockId == 52) {
                this.value = new MobSpawnerValue();
            } else if (this.blockId == 54 || this.blockId == ENDER_CHEST || this.blockId == TRAPPED_CHEST) {
                this.value = new ChestValue(unsignedByte2);
            } else {
                this.value = new GenericBlockValue(unsignedByte2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.blockId = netInput.readVarInt() & 4095;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int iIntValue;
        NetUtil.writePosition(netOutput, this.position);
        int value = 0;
        if (this.type instanceof NoteBlockValueType) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (NoteBlockValueType) this.type)).intValue();
        } else if (this.type instanceof PistonValueType) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (PistonValueType) this.type)).intValue();
        } else if (this.type instanceof MobSpawnerValueType) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (MobSpawnerValueType) this.type)).intValue();
        } else if (this.type instanceof ChestValueType) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (ChestValueType) this.type)).intValue();
        } else {
            iIntValue = this.type instanceof GenericBlockValueType ? ((Integer) MagicValues.value(Integer.class, (GenericBlockValueType) this.type)).intValue() : 0;
        }
        netOutput.writeByte(iIntValue);
        if (this.value instanceof NoteBlockValue) {
            value = ((NoteBlockValue) this.value).getPitch();
        } else if (this.value instanceof PistonValue) {
            value = ((Integer) MagicValues.value(Integer.class, (PistonValue) this.value)).intValue();
        } else if (!(this.value instanceof MobSpawnerValue)) {
            if (this.value instanceof ChestValue) {
                value = ((ChestValue) this.value).getViewers();
            } else if (this.value instanceof GenericBlockValue) {
                value = ((GenericBlockValue) this.value).getValue();
            }
        }
        netOutput.writeByte(value);
        netOutput.writeVarInt(this.blockId & 4095);
    }
}
