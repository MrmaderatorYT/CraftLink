package com.github.steveice10.mc.v1_10.protocol.data.game.world.effect;

import com.github.steveice10.mc.v1_10.protocol.data.game.world.block.BlockState;

/* loaded from: classes.dex */
public class BreakBlockEffectData implements WorldEffectData {
    private BlockState blockState;

    public BreakBlockEffectData(BlockState blockState) {
        this.blockState = blockState;
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BreakBlockEffectData) && this.blockState.equals(((BreakBlockEffectData) obj).blockState);
    }

    public int hashCode() {
        return this.blockState.hashCode();
    }
}
