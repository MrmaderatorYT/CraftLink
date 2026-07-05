package com.github.steveice10.mc.v1_6_4.data;

/* loaded from: classes.dex */
public class StandardItemStack {
    private short damage;
    private short item;
    private byte[] nbt;
    private byte stackSize;

    public StandardItemStack(short s) {
        this(s, (byte) 1);
    }

    public StandardItemStack(short s, byte b2) {
        this(s, b2, (short) 0);
    }

    public StandardItemStack(short s, byte b2, short s2) {
        this(s, b2, s2, null);
    }

    public StandardItemStack(short s, byte b2, short s2, byte[] bArr) {
        this.item = s;
        this.stackSize = b2;
        this.damage = s2;
        this.nbt = bArr;
    }

    public short getItem() {
        return this.item;
    }

    public void setItem(short s) {
        this.item = s;
    }

    public byte getStackSize() {
        return this.stackSize;
    }

    public void setStackSize(byte b2) {
        this.stackSize = b2;
    }

    public short getDamage() {
        return this.damage;
    }

    public void setDamage(short s) {
        this.damage = s;
    }

    public byte[] getNBT() {
        return this.nbt;
    }

    public void setNBT(byte[] bArr) {
        this.nbt = bArr;
    }
}
