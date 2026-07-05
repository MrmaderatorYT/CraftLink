package com.github.steveice10.mc.v1_9.protocol.data.game.chunk;

import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.BlockState;
import com.github.steveice10.mc.v1_9.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BlockStorage {
    private static final BlockState AIR = new BlockState(0, 0);
    private int bitsPerEntry;
    private List<BlockState> states;
    private FlexibleStorage storage;

    private static int index(int i, int i2, int i3) {
        return i | (i2 << 8) | (i3 << 4);
    }

    public BlockStorage() {
        this.bitsPerEntry = 4;
        this.states = new ArrayList();
        this.states.add(AIR);
        this.storage = new FlexibleStorage(this.bitsPerEntry, 4096);
    }

    public BlockStorage(NetInput netInput) {
        this.bitsPerEntry = netInput.readUnsignedByte();
        this.states = new ArrayList();
        int varInt = netInput.readVarInt();
        for (int i = 0; i < varInt; i++) {
            this.states.add(NetUtil.readBlockState(netInput));
        }
        this.storage = new FlexibleStorage(this.bitsPerEntry, netInput.readLongs(netInput.readVarInt()));
    }

    private static BlockState rawToState(int i) {
        return new BlockState(i >> 4, i & 15);
    }

    private static int stateToRaw(BlockState blockState) {
        return (blockState.getData() & 15) | (blockState.getId() << 4);
    }

    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.bitsPerEntry);
        netOutput.writeVarInt(this.states.size());
        Iterator<BlockState> it = this.states.iterator();
        while (it.hasNext()) {
            NetUtil.writeBlockState(netOutput, it.next());
        }
        long[] data = this.storage.getData();
        netOutput.writeVarInt(data.length);
        netOutput.writeLongs(data);
    }

    public int getBitsPerEntry() {
        return this.bitsPerEntry;
    }

    public List<BlockState> getStates() {
        return Collections.unmodifiableList(this.states);
    }

    public FlexibleStorage getStorage() {
        return this.storage;
    }

    public BlockState get(int i, int i2, int i3) {
        int i4 = this.storage.get(index(i, i2, i3));
        return this.bitsPerEntry <= 8 ? (i4 < 0 || i4 >= this.states.size()) ? AIR : this.states.get(i4) : rawToState(i4);
    }

    public void set(int i, int i2, int i3, BlockState blockState) {
        int iIndexOf = this.bitsPerEntry <= 8 ? this.states.indexOf(blockState) : stateToRaw(blockState);
        if (iIndexOf == -1) {
            this.states.add(blockState);
            if (this.states.size() > (1 << this.bitsPerEntry)) {
                this.bitsPerEntry++;
                List arrayList = this.states;
                if (this.bitsPerEntry > 8) {
                    arrayList = new ArrayList(this.states);
                    this.states.clear();
                    this.bitsPerEntry = 13;
                }
                FlexibleStorage flexibleStorage = this.storage;
                this.storage = new FlexibleStorage(this.bitsPerEntry, this.storage.getSize());
                for (int i4 = 0; i4 < this.storage.getSize(); i4++) {
                    this.storage.set(i4, this.bitsPerEntry <= 8 ? flexibleStorage.get(i4) : stateToRaw((BlockState) arrayList.get(i4)));
                }
            }
            iIndexOf = this.bitsPerEntry <= 8 ? this.states.indexOf(blockState) : stateToRaw(blockState);
        }
        this.storage.set(index(i, i2, i3), iIndexOf);
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.storage.getSize(); i++) {
            if (this.storage.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlockStorage) {
            BlockStorage blockStorage = (BlockStorage) obj;
            if (this.bitsPerEntry == blockStorage.bitsPerEntry && this.states.equals(blockStorage.states) && this.storage.equals(blockStorage.storage)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.bitsPerEntry * 31) + this.states.hashCode()) * 31) + this.storage.hashCode();
    }
}
