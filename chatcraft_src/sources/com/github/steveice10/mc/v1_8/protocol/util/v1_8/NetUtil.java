package com.github.steveice10.mc.v1_8.protocol.util.v1_8;

import com.github.steveice10.mc.v1_8.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_8.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_8.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_8.protocol.data.game.NibbleArray3d;
import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.Rotation;
import com.github.steveice10.mc.v1_8.protocol.data.game.ShortArray3d;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.MetadataType;
import com.github.steveice10.opennbt.NBTIO;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;

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

    public static Position readPosition(NetInput netInput) {
        long j = netInput.readLong();
        return new Position((int) (j >> 38), (int) ((j >> 26) & 4095), (int) ((j << 38) >> 38));
    }

    public static void writePosition(NetOutput netOutput, Position position) {
        netOutput.writeLong((position.getZ() & POSITION_WRITE_SHIFT) | ((position.getX() & POSITION_WRITE_SHIFT) << 38) | ((position.getY() & POSITION_Y_SHIFT) << 26));
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

    public static EntityMetadata[] readEntityMetadata(NetInput netInput) throws IOException {
        Object objValueOf;
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte b2 = netInput.readByte();
            if (b2 != 127) {
                int i = (b2 & 224) >> 5;
                int i2 = b2 & 31;
                MetadataType metadataType = (MetadataType) MagicValues.key(MetadataType.class, Integer.valueOf(i));
                switch (metadataType) {
                    case BYTE:
                        objValueOf = Byte.valueOf(netInput.readByte());
                        break;
                    case SHORT:
                        objValueOf = Short.valueOf(netInput.readShort());
                        break;
                    case INT:
                        objValueOf = Integer.valueOf(netInput.readInt());
                        break;
                    case FLOAT:
                        objValueOf = Float.valueOf(netInput.readFloat());
                        break;
                    case STRING:
                        objValueOf = netInput.readString();
                        break;
                    case ITEM:
                        objValueOf = readItem(netInput);
                        break;
                    case POSITION:
                        objValueOf = new Position(netInput.readInt(), netInput.readInt(), netInput.readInt());
                        break;
                    case ROTATION:
                        objValueOf = new Rotation(netInput.readFloat(), netInput.readFloat(), netInput.readFloat());
                        break;
                    default:
                        throw new IOException("Unknown metadata type id: " + i);
                }
                arrayList.add(new EntityMetadata(i2, metadataType, objValueOf));
            } else {
                return (EntityMetadata[]) arrayList.toArray(new EntityMetadata[arrayList.size()]);
            }
        }
    }

    public static void writeEntityMetadata(NetOutput netOutput, EntityMetadata[] entityMetadataArr) throws IOException {
        for (EntityMetadata entityMetadata : entityMetadataArr) {
            netOutput.writeByte((((Integer) MagicValues.value(Integer.class, entityMetadata.getType())).intValue() << 5) | (entityMetadata.getId() & 31));
            switch (entityMetadata.getType()) {
                case BYTE:
                    netOutput.writeByte(((Byte) entityMetadata.getValue()).byteValue());
                    break;
                case SHORT:
                    netOutput.writeShort(((Short) entityMetadata.getValue()).shortValue());
                    break;
                case INT:
                    netOutput.writeInt(((Integer) entityMetadata.getValue()).intValue());
                    break;
                case FLOAT:
                    netOutput.writeFloat(((Float) entityMetadata.getValue()).floatValue());
                    break;
                case STRING:
                    netOutput.writeString((String) entityMetadata.getValue());
                    break;
                case ITEM:
                    writeItem(netOutput, (ItemStack) entityMetadata.getValue());
                    break;
                case POSITION:
                    Position position = (Position) entityMetadata.getValue();
                    netOutput.writeInt(position.getX());
                    netOutput.writeInt(position.getY());
                    netOutput.writeInt(position.getZ());
                    break;
                case ROTATION:
                    Rotation rotation = (Rotation) entityMetadata.getValue();
                    netOutput.writeFloat(rotation.getPitch());
                    netOutput.writeFloat(rotation.getYaw());
                    netOutput.writeFloat(rotation.getRoll());
                    break;
                default:
                    throw new IOException("Unmapped metadata type: " + entityMetadata.getType());
            }
        }
        netOutput.writeByte(127);
    }

    public static ParsedChunkData dataToChunks(NetworkChunkData networkChunkData, boolean z) {
        Chunk[] chunkArr = new Chunk[16];
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.wrap(networkChunkData.getData()).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        while (i < 4) {
            int length = i2;
            for (int i4 = 0; i4 < 16; i4++) {
                boolean z3 = true;
                if ((networkChunkData.getMask() & (1 << i4)) != 0) {
                    if (i == 0) {
                        i3 += 10240;
                    }
                    if (i == 1) {
                        if (!z2 && !networkChunkData.hasSkyLight()) {
                            z3 = false;
                        }
                        chunkArr[i4] = new Chunk(z3);
                        ShortArray3d blocks = chunkArr[i4].getBlocks();
                        shortBufferAsShortBuffer.position(length / 2);
                        shortBufferAsShortBuffer.get(blocks.getData(), 0, blocks.getData().length);
                        length += blocks.getData().length * 2;
                    }
                    if (i == 2) {
                        NibbleArray3d blockLight = chunkArr[i4].getBlockLight();
                        System.arraycopy(networkChunkData.getData(), length, blockLight.getData(), 0, blockLight.getData().length);
                        length += blockLight.getData().length;
                    }
                    if (i == 3 && (z2 || networkChunkData.hasSkyLight())) {
                        NibbleArray3d skyLight = chunkArr[i4].getSkyLight();
                        System.arraycopy(networkChunkData.getData(), length, skyLight.getData(), 0, skyLight.getData().length);
                        length += skyLight.getData().length;
                    }
                }
            }
            if (i == 0 && networkChunkData.getData().length > i3) {
                z2 = z;
            }
            i++;
            i2 = length;
        }
        byte[] bArr = null;
        if (networkChunkData.isFullChunk()) {
            bArr = new byte[256];
            System.arraycopy(networkChunkData.getData(), i2, bArr, 0, bArr.length);
            int length2 = bArr.length;
        }
        return new ParsedChunkData(chunkArr, bArr);
    }

    public static NetworkChunkData chunksToData(ParsedChunkData parsedChunkData) {
        boolean z = parsedChunkData.getBiomes() != null;
        byte[] bArr = null;
        int length = z ? parsedChunkData.getBiomes().length : 0;
        ShortBuffer shortBufferAsShortBuffer = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        while (i < 4) {
            boolean z3 = z2;
            int i4 = i3;
            int length2 = i2;
            for (int i5 = 0; i5 < parsedChunkData.getChunks().length; i5++) {
                Chunk chunk = parsedChunkData.getChunks()[i5];
                if (chunk != null && (!z || !chunk.isEmpty())) {
                    if (i == 0) {
                        i4 |= 1 << i5;
                        length = length + (chunk.getBlocks().getData().length * 2) + chunk.getBlockLight().getData().length;
                        if (chunk.getSkyLight() != null) {
                            length += chunk.getSkyLight().getData().length;
                        }
                    }
                    if (i == 1) {
                        short[] data = chunk.getBlocks().getData();
                        shortBufferAsShortBuffer.position(length2 / 2);
                        shortBufferAsShortBuffer.put(data, 0, data.length);
                        length2 += data.length * 2;
                    }
                    if (i == 2) {
                        byte[] data2 = chunk.getBlockLight().getData();
                        System.arraycopy(data2, 0, bArr, length2, data2.length);
                        length2 += data2.length;
                    }
                    if (i == 3 && chunk.getSkyLight() != null) {
                        byte[] data3 = chunk.getSkyLight().getData();
                        System.arraycopy(data3, 0, bArr, length2, data3.length);
                        length2 += data3.length;
                        z3 = true;
                    }
                }
            }
            if (i == 0) {
                bArr = new byte[length];
                shortBufferAsShortBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
            }
            i++;
            i2 = length2;
            i3 = i4;
            z2 = z3;
        }
        if (z) {
            System.arraycopy(parsedChunkData.getBiomes(), 0, bArr, i2, parsedChunkData.getBiomes().length);
            int length3 = parsedChunkData.getBiomes().length;
        }
        return new NetworkChunkData(i3, z, z2, bArr);
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
