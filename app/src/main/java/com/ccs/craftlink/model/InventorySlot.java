package com.ccs.craftlink.model;

import java.io.Serializable;

public class InventorySlot implements Serializable {
    private int slot;
    private int itemId;
    private int count;
    private int damage;
    private String name;
    private boolean clickable;

    public InventorySlot() {}

    public InventorySlot(int slot, int itemId, int count, int damage, String name) {
        this.slot = slot;
        this.itemId = itemId;
        this.count = count;
        this.damage = damage;
        this.name = name;
        this.clickable = true;
    }

    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isClickable() { return clickable; }
    public void setClickable(boolean clickable) { this.clickable = clickable; }

    public boolean isEmpty() {
        return itemId == 0;
    }
}
