package com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;

/* loaded from: classes.dex */
public class ItemStack {
    private int amount;
    private int data;
    private int id;
    private CompoundTag nbt;

    public ItemStack(int i) {
        this(i, 1);
    }

    public ItemStack(int i, int i2) {
        this(i, i2, 0);
    }

    public ItemStack(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public ItemStack(int i, int i2, int i3, CompoundTag compoundTag) {
        this.id = i;
        this.amount = i2;
        this.data = i3;
        this.nbt = compoundTag;
    }

    public int getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getData() {
        return this.data;
    }

    public CompoundTag getNBT() {
        return this.nbt;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ItemStack) {
                ItemStack itemStack = (ItemStack) obj;
                if (this.id != itemStack.id || this.amount != itemStack.amount || this.data != itemStack.data || ((this.nbt == null || itemStack.nbt == null) && (this.nbt == null || !this.nbt.equals(itemStack.nbt)))) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.amount) * 31) + this.data) * 31) + (this.nbt != null ? this.nbt.hashCode() : 0);
    }
}
