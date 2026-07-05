package com.github.steveice10.mc.v1_9_2.protocol.util;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk.BlockStorage;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk.Chunk;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk.Column;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.chunk.NibbleArray3d;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.EntityMetadata;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.MetadataType;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.Rotation;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block.BlockFace;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block.BlockState;
import com.github.steveice10.mc.v1_9_2.protocol.data.message.Message;
import com.github.steveice10.opennbt.NBTIO;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.io.stream.StreamNetInput;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public class NetUtil {
    private static final int POSITION_WRITE_SHIFT = 67108863;
    private static final int POSITION_X_SIZE = 38;
    private static final int POSITION_Y_SHIFT = 4095;
    private static final int POSITION_Y_SIZE = 26;
    private static final int POSITION_Z_SIZE = 38;

    public static CompoundTag readNBT(NetInput netInput) {
        byte b2 = netInput.readByte();
        if (b2 == 0) {
            return null;
        }
        return (CompoundTag) NBTIO.readTag(new NetInputStream(netInput, b2));
    }

    public static void writeNBT(NetOutput netOutput, CompoundTag compoundTag) {
        if (compoundTag == null) {
            netOutput.writeByte(0);
        } else {
            NBTIO.writeTag(new NetOutputStream(netOutput), compoundTag);
        }
    }

    public static BlockState readBlockState(NetInput netInput) {
        int varInt = netInput.readVarInt();
        return new BlockState(varInt >> 4, varInt & 15);
    }

    public static void writeBlockState(NetOutput netOutput, BlockState blockState) {
        netOutput.writeVarInt((blockState.getData() & 15) | (blockState.getId() << 4));
    }

    public static ItemStack readItem(NetInput netInput) {
        short s = netInput.readShort();
        if (s < 0) {
            return null;
        }
        return new ItemStack(s, netInput.readByte(), netInput.readShort(), readNBT(netInput));
    }

    public static void writeItem(NetOutput netOutput, ItemStack itemStack) {
        if (itemStack == null) {
            netOutput.writeShort(-1);
            return;
        }
        netOutput.writeShort(itemStack.getId());
        netOutput.writeByte(itemStack.getAmount());
        netOutput.writeShort(itemStack.getData());
        writeNBT(netOutput, itemStack.getNBT());
    }

    public static Position readPosition(NetInput netInput) {
        long j = netInput.readLong();
        return new Position((int) (j >> 38), (int) ((j >> 26) & 4095), (int) ((j << 38) >> 38));
    }

    public static void writePosition(NetOutput netOutput, Position position) {
        netOutput.writeLong((position.getZ() & POSITION_WRITE_SHIFT) | ((position.getX() & POSITION_WRITE_SHIFT) << 38) | ((position.getY() & POSITION_Y_SHIFT) << 26));
    }

    public static Rotation readRotation(NetInput netInput) {
        return new Rotation(netInput.readFloat(), netInput.readFloat(), netInput.readFloat());
    }

    public static void writeRotation(NetOutput netOutput, Rotation rotation) {
        netOutput.writeFloat(rotation.getPitch());
        netOutput.writeFloat(rotation.getYaw());
        netOutput.writeFloat(rotation.getRoll());
    }

    public static EntityMetadata[] readEntityMetadata(NetInput netInput) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int unsignedByte = netInput.readUnsignedByte();
            if (unsignedByte != 255) {
                int varInt = netInput.readVarInt();
                MetadataType metadataType = (MetadataType) MagicValues.key(MetadataType.class, Integer.valueOf(varInt));
                Object objValueOf = null;
                switch (metadataType) {
                    case BYTE:
                        objValueOf = Byte.valueOf(netInput.readByte());
                        break;
                    case INT:
                        objValueOf = Integer.valueOf(netInput.readVarInt());
                        break;
                    case FLOAT:
                        objValueOf = Float.valueOf(netInput.readFloat());
                        break;
                    case STRING:
                        objValueOf = netInput.readString();
                        break;
                    case CHAT:
                        objValueOf = Message.fromString(netInput.readString());
                        break;
                    case ITEM:
                        objValueOf = readItem(netInput);
                        break;
                    case BOOLEAN:
                        objValueOf = Boolean.valueOf(netInput.readBoolean());
                        break;
                    case ROTATION:
                        objValueOf = readRotation(netInput);
                        break;
                    case POSITION:
                        objValueOf = readPosition(netInput);
                        break;
                    case OPTIONAL_POSITION:
                        if (!netInput.readBoolean()) {
                            break;
                        } else {
                            objValueOf = readPosition(netInput);
                            break;
                        }
                    case BLOCK_FACE:
                        objValueOf = MagicValues.key(BlockFace.class, Integer.valueOf(netInput.readVarInt()));
                        break;
                    case OPTIONAL_UUID:
                        if (!netInput.readBoolean()) {
                            break;
                        } else {
                            objValueOf = netInput.readUUID();
                            break;
                        }
                    case BLOCK_STATE:
                        objValueOf = readBlockState(netInput);
                        break;
                    default:
                        throw new IOException("Unknown metadata type id: " + varInt);
                }
                arrayList.add(new EntityMetadata(unsignedByte, metadataType, objValueOf));
            } else {
                return (EntityMetadata[]) arrayList.toArray(new EntityMetadata[arrayList.size()]);
            }
        }
    }

    public static void writeEntityMetadata(NetOutput netOutput, EntityMetadata[] entityMetadataArr) throws IOException {
        for (EntityMetadata entityMetadata : entityMetadataArr) {
            netOutput.writeByte(entityMetadata.getId());
            netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, entityMetadata.getType())).intValue());
            switch (entityMetadata.getType()) {
                case BYTE:
                    netOutput.writeByte(((Byte) entityMetadata.getValue()).byteValue());
                    break;
                case INT:
                    netOutput.writeVarInt(((Integer) entityMetadata.getValue()).intValue());
                    break;
                case FLOAT:
                    netOutput.writeFloat(((Float) entityMetadata.getValue()).floatValue());
                    break;
                case STRING:
                    netOutput.writeString((String) entityMetadata.getValue());
                    break;
                case CHAT:
                    netOutput.writeString(((Message) entityMetadata.getValue()).toJsonString());
                    break;
                case ITEM:
                    writeItem(netOutput, (ItemStack) entityMetadata.getValue());
                    break;
                case BOOLEAN:
                    netOutput.writeBoolean(((Boolean) entityMetadata.getValue()).booleanValue());
                    break;
                case ROTATION:
                    writeRotation(netOutput, (Rotation) entityMetadata.getValue());
                    break;
                case POSITION:
                    writePosition(netOutput, (Position) entityMetadata.getValue());
                    break;
                case OPTIONAL_POSITION:
                    netOutput.writeBoolean(entityMetadata.getValue() != null);
                    if (entityMetadata.getValue() != null) {
                        writePosition(netOutput, (Position) entityMetadata.getValue());
                        break;
                    } else {
                        break;
                    }
                case BLOCK_FACE:
                    netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, (BlockFace) entityMetadata.getValue())).intValue());
                    break;
                case OPTIONAL_UUID:
                    netOutput.writeBoolean(entityMetadata.getValue() != null);
                    if (entityMetadata.getValue() != null) {
                        netOutput.writeUUID((UUID) entityMetadata.getValue());
                        break;
                    } else {
                        break;
                    }
                case BLOCK_STATE:
                    writeBlockState(netOutput, (BlockState) entityMetadata.getValue());
                    break;
                default:
                    throw new IOException("Unknown metadata type: " + entityMetadata.getType());
            }
        }
        netOutput.writeByte(255);
    }

    public static Column readColumn(byte[] bArr, int i, int i2, boolean z, boolean z2, int i3) throws IOException {
        StreamNetInput streamNetInput = new StreamNetInput(new ByteArrayInputStream(bArr));
        Column column = null;
        try {
            Chunk[] chunkArr = new Chunk[16];
            for (int i4 = 0; i4 < chunkArr.length; i4++) {
                if (((1 << i4) & i3) != 0) {
                    chunkArr[i4] = new Chunk(new BlockStorage(streamNetInput), new NibbleArray3d(streamNetInput, 2048), z2 ? new NibbleArray3d(streamNetInput, 2048) : null);
                }
            }
            Column column2 = new Column(i, i2, chunkArr, z ? streamNetInput.readBytes(256) : null);
            e = null;
            column = column2;
        } catch (Exception e) {
            e = e;
        }
        if ((streamNetInput.available() > 0 || e != null) && !z2) {
            return readColumn(bArr, i, i2, z, true, i3);
        }
        if (e == null) {
            return column;
        }
        throw new IOException("Failed to read chunk data.", e);
    }

    public static int writeColumn(NetOutput netOutput, Column column, boolean z, boolean z2) {
        Chunk[] chunks = column.getChunks();
        int i = 0;
        for (int i2 = 0; i2 < chunks.length; i2++) {
            Chunk chunk = chunks[i2];
            if (chunk != null && (!z || !chunk.isEmpty())) {
                i |= 1 << i2;
                chunk.getBlocks().write(netOutput);
                chunk.getBlockLight().write(netOutput);
                if (z2) {
                    chunk.getSkyLight().write(netOutput);
                }
            }
        }
        if (z) {
            netOutput.writeBytes(column.getBiomeData());
        }
        return i;
    }

    private static class NetInputStream extends InputStream {
        private byte firstByte;
        private NetInput in;
        private boolean readFirst;

        public NetInputStream(NetInput netInput, byte b2) {
            this.in = netInput;
            this.firstByte = b2;
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.readFirst) {
                this.readFirst = true;
                return this.firstByte;
            }
            return this.in.readUnsignedByte();
        }
    }

    private static class NetOutputStream extends OutputStream {
        private NetOutput out;

        public NetOutputStream(NetOutput netOutput) {
            this.out = netOutput;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.out.writeByte(i);
        }
    }
}
