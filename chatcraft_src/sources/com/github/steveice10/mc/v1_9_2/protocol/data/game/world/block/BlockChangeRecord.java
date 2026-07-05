package com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block;

import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.Position;

/* loaded from: classes.dex */
public class BlockChangeRecord {
    private BlockState block;
    private Position position;

    public BlockChangeRecord(Position position, BlockState blockState) {
        this.position = position;
        this.block = blockState;
    }

    public Position getPosition() {
        return this.position;
    }

    public BlockState getBlock() {
        return this.block;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlockChangeRecord) {
            BlockChangeRecord blockChangeRecord = (BlockChangeRecord) obj;
            if (this.position.equals(blockChangeRecord.position) && this.block.equals(blockChangeRecord.block)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.position.hashCode() * 31) + this.block.hashCode();
    }
}
