package com.ccs.craftlink.network;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;

public class WorldTracker {
    private static final String TAG = "WorldTracker";
    public static String lastError = null;
    
    public static class ChunkInfo {
        public int[] colors;
        public short[] heights;
        public ChunkInfo(int[] colors, short[] heights) {
            this.colors = colors;
            this.heights = heights;
        }
    }
    
    // Key: ChunkX + ChunkZ << 32
    private final ConcurrentHashMap<Long, ChunkInfo> chunkDataMap = new ConcurrentHashMap<>();
    
    public void parseChunkData(int chunkX, int chunkZ, byte[] chunkData) {
        if (chunkData == null || chunkData.length == 0) return;
        
        try {
            ByteBuffer buf = ByteBuffer.wrap(chunkData);
            
            // In 1.20, chunks have 24 sections (-4 to 19).
            // We need to parse all sections to build a full vertical column map.
            StringBuilder trace = new StringBuilder();
            int[] colors = new int[256];
            short[] heights = new short[256];
            int sectionY = -4; // Assuming 1.20 starts at -64 (section -4)
            
            while (buf.hasRemaining()) {
                trace.append(" sec=").append(sectionY).append(" pos=").append(buf.position());
                // Read Block count
                if (buf.remaining() < 2) break;
                short blockCount = buf.getShort();
                trace.append(" bc=").append(blockCount);
                
                // Block States Paletted Container
                if (buf.remaining() < 1) break;
                byte bitsPerEntry = buf.get();
                trace.append(" bpe=").append(bitsPerEntry);
                
                if (bitsPerEntry == 0) {
                    // Single value
                    int stateId = readVarIntFromBuf(buf);
                    // Data Array Length is still written (usually 0)
                    readVarIntFromBuf(buf);
                    
                    int color = BlockColors.getColor(stateId);
                    if ((color >>> 24) != 0) { // If not completely transparent
                        // Overwrite entire section footprint
                        for (int i = 0; i < 256; i++) {
                            colors[i] = color;
                            heights[i] = (short) (sectionY * 16);
                        }
                    }
                } else if (bitsPerEntry >= 1 && bitsPerEntry <= 8) {
                    // Indirect palette
                    int paletteLen = readVarIntFromBuf(buf);
                    int[] palette = new int[paletteLen];
                    for (int i = 0; i < paletteLen; i++) {
                        palette[i] = readVarIntFromBuf(buf);
                    }
                    
                    int dataArrayLen = readVarIntFromBuf(buf);
                    long[] dataArray = new long[dataArrayLen];
                    for (int i = 0; i < dataArrayLen; i++) {
                        dataArray[i] = buf.getLong();
                    }
                    
                    int valuesPerLong = 64 / bitsPerEntry;
                    long mask = (1L << bitsPerEntry) - 1;
                    
                    for (int y = 0; y < 16; y++) {
                        for (int z = 0; z < 16; z++) {
                            for (int x = 0; x < 16; x++) {
                                int index = (y << 8) | (z << 4) | x;
                                int startLong = index / valuesPerLong;
                                int bitOffset = (index % valuesPerLong) * bitsPerEntry;
                                
                                if (startLong < dataArray.length) {
                                    long val = dataArray[startLong] >>> bitOffset;
                                    int paletteIndex = (int) (val & mask);
                                    if (paletteIndex < palette.length) {
                                        int stateId = palette[paletteIndex];
                                        int color = BlockColors.getColor(stateId);
                                        if ((color >>> 24) != 0) { // Not transparent
                                            colors[x + z * 16] = color;
                                            heights[x + z * 16] = (short) (sectionY * 16 + y);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // Direct palette (15+ bits)
                    int dataArrayLen = readVarIntFromBuf(buf);
                    long[] dataArray = new long[dataArrayLen];
                    for (int i = 0; i < dataArrayLen; i++) {
                        dataArray[i] = buf.getLong();
                    }
                    
                    int valuesPerLong = 64 / bitsPerEntry;
                    if (valuesPerLong == 0) {
                        throw new RuntimeException(trace.toString() + " CRASH: bpe=" + bitsPerEntry + " pos=" + buf.position() + " size=" + chunkData.length);
                    }
                    long mask = (1L << bitsPerEntry) - 1;
                    
                    for (int y = 0; y < 16; y++) {
                        for (int z = 0; z < 16; z++) {
                            for (int x = 0; x < 16; x++) {
                                int index = (y << 8) | (z << 4) | x;
                                int startLong = index / valuesPerLong;
                                int bitOffset = (index % valuesPerLong) * bitsPerEntry;
                                
                                if (startLong < dataArray.length) {
                                    long val = dataArray[startLong] >>> bitOffset;
                                    int stateId = (int) (val & mask);
                                    int color = BlockColors.getColor(stateId);
                                    if ((color >>> 24) != 0) { // Not transparent
                                        colors[x + z * 16] = color;
                                        heights[x + z * 16] = (short) (sectionY * 16 + y);
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Biomes Paletted Container
                if (buf.remaining() < 1) break;
                byte biomeBitsPerEntry = buf.get();
                trace.append(" bioBpe=").append(biomeBitsPerEntry);
                
                if (biomeBitsPerEntry == 0) {
                    readVarIntFromBuf(buf); // biome ID
                    // Data Array Length is still written
                    readVarIntFromBuf(buf);
                } else if (biomeBitsPerEntry >= 1 && biomeBitsPerEntry <= 3) {
                    int paletteLen = readVarIntFromBuf(buf);
                    for (int i = 0; i < paletteLen; i++) readVarIntFromBuf(buf);
                    int dataArrayLen = readVarIntFromBuf(buf);
                    buf.position(buf.position() + dataArrayLen * 8);
                } else {
                    int dataArrayLen = readVarIntFromBuf(buf);
                    buf.position(buf.position() + dataArrayLen * 8);
                }
                sectionY++;
            }
            
            long key = ((long) chunkX & 0xFFFFFFFFL) | (((long) chunkZ & 0xFFFFFFFFL) << 32);
            chunkDataMap.put(key, new ChunkInfo(colors, heights));
        } catch (Exception e) {
            if (e instanceof RuntimeException && e.getMessage() != null) {
                lastError = "ERR: " + e.getMessage();
            } else {
                lastError = "ERR: " + e.getClass().getSimpleName() + " at " + e.getStackTrace()[0].getLineNumber();
            }
            Log.e(TAG, "Failed to parse chunk section data", e);
        }
    }
    
    private static int readVarIntFromBuf(ByteBuffer buf) {
        int value = 0;
        int shift = 0;
        byte b;
        do {
            if (!buf.hasRemaining()) break;
            b = buf.get();
            value |= (b & 0x7F) << shift;
            shift += 7;
            if (shift > 35) throw new RuntimeException("VarInt too big");
        } while ((b & 0x80) != 0);
        return value;
    }
    
    public int[] getChunkColors(int chunkX, int chunkZ) {
        long key = ((long) chunkX & 0xFFFFFFFFL) | (((long) chunkZ & 0xFFFFFFFFL) << 32);
        ChunkInfo info = chunkDataMap.get(key);
        return info != null ? info.colors : null;
    }
    
    public Double getHeightAt(double x, double z) {
        int chunkX = (int) Math.floor(x) >> 4;
        int chunkZ = (int) Math.floor(z) >> 4;
        long key = ((long) chunkX & 0xFFFFFFFFL) | (((long) chunkZ & 0xFFFFFFFFL) << 32);
        ChunkInfo info = chunkDataMap.get(key);
        if (info == null) return null;
        
        int localX = (int) Math.floor(x) & 15;
        int localZ = (int) Math.floor(z) & 15;
        int index = localX + localZ * 16;
        return (double) info.heights[index];
    }
    
    public void clear() {
        chunkDataMap.clear();
    }
}
