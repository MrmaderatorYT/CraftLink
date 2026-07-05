package com.github.steveice10.mc.v1_7.protocol.util;

import com.github.steveice10.mc.v1_7.protocol.data.game.ByteArray3d;
import com.github.steveice10.mc.v1_7.protocol.data.game.Chunk;
import com.github.steveice10.mc.v1_7.protocol.data.game.Coordinates;
import com.github.steveice10.mc.v1_7.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_7.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_7.protocol.data.game.NibbleArray3d;
import com.github.steveice10.opennbt.NBTIO;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class NetUtil {
    public static CompoundTag readNBT(NetInput netInput) {
        short s = netInput.readShort();
        if (s < 0) {
            return null;
        }
        return (CompoundTag) NBTIO.readTag(new GZIPInputStream(new ByteArrayInputStream(netInput.readBytes(s))));
    }

    public static void writeNBT(NetOutput netOutput, CompoundTag compoundTag) throws IOException {
        if (compoundTag == null) {
            netOutput.writeShort(-1);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        NBTIO.writeTag(gZIPOutputStream, compoundTag);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        netOutput.writeShort((short) byteArray.length);
        netOutput.writeBytes(byteArray);
    }

    public static ItemStack readItem(NetInput netInput) {
        short s = netInput.readShort();
        if (s < 0) {
            return null;
        }
        return new ItemStack(s, netInput.readByte(), netInput.readShort(), readNBT(netInput));
    }

    public static void writeItem(NetOutput netOutput, ItemStack itemStack) throws IOException {
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
                EntityMetadata.Type type = EntityMetadata.Type.values()[i];
                switch (type) {
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
                    case COORDINATES:
                        objValueOf = new Coordinates(netInput.readInt(), netInput.readInt(), netInput.readInt());
                        break;
                    default:
                        throw new IOException("Unknown metadata type id: " + i);
                }
                arrayList.add(new EntityMetadata(i2, type, objValueOf));
            } else {
                return (EntityMetadata[]) arrayList.toArray(new EntityMetadata[arrayList.size()]);
            }
        }
    }

    public static void writeEntityMetadata(NetOutput netOutput, EntityMetadata[] entityMetadataArr) throws IOException {
        for (EntityMetadata entityMetadata : entityMetadataArr) {
            netOutput.writeByte((entityMetadata.getType().ordinal() << 5) | (entityMetadata.getId() & 31));
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
                case COORDINATES:
                    Coordinates coordinates = (Coordinates) entityMetadata.getValue();
                    netOutput.writeInt(coordinates.getX());
                    netOutput.writeInt(coordinates.getY());
                    netOutput.writeInt(coordinates.getZ());
                    break;
                default:
                    throw new IOException("Unmapped metadata type: " + entityMetadata.getType());
            }
        }
        netOutput.writeByte(127);
    }

    public static ParsedChunkData dataToChunks(NetworkChunkData networkChunkData) {
        Chunk[] chunkArr = new Chunk[16];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i < 5) {
            int length = i2;
            int i4 = 0;
            while (true) {
                if (i4 >= 16) {
                    break;
                }
                int i5 = 1 << i4;
                if ((networkChunkData.getMask() & i5) != 0) {
                    if (i == 0) {
                        i3 += 10240;
                        if ((networkChunkData.getExtendedMask() & i5) != 0) {
                            i3 += 2048;
                        }
                    }
                    if (i == 1) {
                        chunkArr[i4] = new Chunk(z || networkChunkData.hasSkyLight(), (networkChunkData.getExtendedMask() & i5) != 0);
                        ByteArray3d blocks = chunkArr[i4].getBlocks();
                        System.arraycopy(networkChunkData.getData(), length, blocks.getData(), 0, blocks.getData().length);
                        length += blocks.getData().length;
                    }
                    if (i == 2) {
                        NibbleArray3d metadata = chunkArr[i4].getMetadata();
                        System.arraycopy(networkChunkData.getData(), length, metadata.getData(), 0, metadata.getData().length);
                        length += metadata.getData().length;
                    }
                    if (i == 3) {
                        NibbleArray3d blockLight = chunkArr[i4].getBlockLight();
                        System.arraycopy(networkChunkData.getData(), length, blockLight.getData(), 0, blockLight.getData().length);
                        length += blockLight.getData().length;
                    }
                    if (i == 4 && (z || networkChunkData.hasSkyLight())) {
                        NibbleArray3d skyLight = chunkArr[i4].getSkyLight();
                        System.arraycopy(networkChunkData.getData(), length, skyLight.getData(), 0, skyLight.getData().length);
                        length += skyLight.getData().length;
                    }
                }
                if (i == 5 && (networkChunkData.getExtendedMask() & i5) != 0) {
                    if (chunkArr[i4] == null) {
                        length += 2048;
                    } else {
                        NibbleArray3d extendedBlocks = chunkArr[i4].getExtendedBlocks();
                        System.arraycopy(networkChunkData.getData(), length, extendedBlocks.getData(), 0, extendedBlocks.getData().length);
                        length += extendedBlocks.getData().length;
                    }
                }
                i4++;
            }
            if (i == 0 && networkChunkData.getData().length >= i3) {
                z = true;
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
        int length = z ? parsedChunkData.getBiomes().length : 0;
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (i < 6) {
            int i5 = i4;
            int i6 = i3;
            int length2 = i2;
            for (int i7 = 0; i7 < parsedChunkData.getChunks().length; i7++) {
                Chunk chunk = parsedChunkData.getChunks()[i7];
                if (chunk != null && (!z || !chunk.isEmpty())) {
                    if (i == 0) {
                        int i8 = 1 << i7;
                        i6 |= i8;
                        if (chunk.getExtendedBlocks() != null) {
                            i5 |= i8;
                        }
                        length = length + chunk.getBlocks().getData().length + chunk.getMetadata().getData().length + chunk.getBlockLight().getData().length;
                        if (chunk.getSkyLight() != null) {
                            length += chunk.getSkyLight().getData().length;
                        }
                        if (chunk.getExtendedBlocks() != null) {
                            length += chunk.getExtendedBlocks().getData().length;
                        }
                    }
                    if (i == 1) {
                        ByteArray3d blocks = chunk.getBlocks();
                        System.arraycopy(blocks.getData(), 0, bArr, length2, blocks.getData().length);
                        length2 += blocks.getData().length;
                    }
                    if (i == 2) {
                        byte[] data = chunk.getMetadata().getData();
                        System.arraycopy(data, 0, bArr, length2, data.length);
                        length2 += data.length;
                    }
                    if (i == 3) {
                        byte[] data2 = chunk.getBlockLight().getData();
                        System.arraycopy(data2, 0, bArr, length2, data2.length);
                        length2 += data2.length;
                    }
                    if (i == 4 && chunk.getSkyLight() != null) {
                        byte[] data3 = chunk.getSkyLight().getData();
                        System.arraycopy(data3, 0, bArr, length2, data3.length);
                        length2 += data3.length;
                        z2 = true;
                    }
                    if (i == 5 && chunk.getExtendedBlocks() != null) {
                        byte[] data4 = chunk.getExtendedBlocks().getData();
                        System.arraycopy(data4, 0, bArr, length2, data4.length);
                        length2 += data4.length;
                    }
                }
            }
            if (i == 0) {
                bArr = new byte[length];
            }
            i++;
            i2 = length2;
            i3 = i6;
            i4 = i5;
        }
        if (z) {
            System.arraycopy(parsedChunkData.getBiomes(), 0, bArr, i2, parsedChunkData.getBiomes().length);
            int length3 = parsedChunkData.getBiomes().length;
        }
        return new NetworkChunkData(i3, i4, z, z2, bArr);
    }
}
