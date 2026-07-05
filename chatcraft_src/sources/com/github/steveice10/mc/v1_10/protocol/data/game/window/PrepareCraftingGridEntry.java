package com.github.steveice10.mc.v1_10.protocol.data.game.window;

import android.os.Build;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import java.util.Objects;

/* loaded from: classes.dex */
public class PrepareCraftingGridEntry {
    private byte craftingGridSlot;
    private ItemStack item;
    private byte playerInventorySlot;

    public PrepareCraftingGridEntry(ItemStack itemStack, byte b2, byte b3) {
        this.item = itemStack;
        this.craftingGridSlot = b2;
        this.playerInventorySlot = b3;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public byte getCraftingGridSlot() {
        return this.craftingGridSlot;
    }

    public byte getPlayerInventorySlot() {
        return this.playerInventorySlot;
    }

    private static boolean objectEquals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrepareCraftingGridEntry)) {
            return false;
        }
        PrepareCraftingGridEntry prepareCraftingGridEntry = (PrepareCraftingGridEntry) obj;
        return this.craftingGridSlot == prepareCraftingGridEntry.craftingGridSlot && this.playerInventorySlot == prepareCraftingGridEntry.playerInventorySlot && objectEquals(this.item, prepareCraftingGridEntry.item);
    }

    public int hashCode() {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.item, Byte.valueOf(this.craftingGridSlot), Byte.valueOf(this.playerInventorySlot)) : this.item.hashCode();
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
