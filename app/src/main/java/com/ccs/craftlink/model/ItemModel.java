package com.ccs.craftlink.model;

public class ItemModel {
    private final int slotIndex;
    private final int itemId;
    private final int count;
    private final String name;

    public ItemModel(int slotIndex, int itemId, int count, String name) {
        this.name = name;
        this.slotIndex = slotIndex;
        this.itemId = itemId;
        this.count = count;
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public int getItemId() {
        return itemId;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
