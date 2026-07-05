package com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block;

/* loaded from: classes.dex */
public class BlockState {
    private int data;
    private int id;

    public BlockState(int i, int i2) {
        this.id = i;
        this.data = i2;
    }

    public int getId() {
        return this.id;
    }

    public int getData() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlockState) {
            BlockState blockState = (BlockState) obj;
            if (this.id == blockState.id && this.data == blockState.data) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.id * 31) + this.data;
    }
}
