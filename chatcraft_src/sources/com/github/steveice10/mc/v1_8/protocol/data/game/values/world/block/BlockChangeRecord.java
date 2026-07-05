package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.block;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;

/* loaded from: classes.dex */
public class BlockChangeRecord {
    private int data;
    private int id;
    private Position position;

    public BlockChangeRecord(Position position, int i, int i2) {
        this.position = position;
        this.id = i;
        this.data = i2;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getId() {
        return this.id;
    }

    public int getData() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BlockChangeRecord blockChangeRecord = (BlockChangeRecord) obj;
        return this.id == blockChangeRecord.id && this.data == blockChangeRecord.data && this.position.equals(blockChangeRecord.position);
    }

    public int hashCode() {
        return (((this.position.hashCode() * 31) + this.id) * 31) + this.data;
    }
}
