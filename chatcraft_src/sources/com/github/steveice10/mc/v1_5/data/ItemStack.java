package com.github.steveice10.mc.v1_5.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ItemStack {
    private short damage;
    private short item;
    private byte[] nbt;
    private byte stackSize;

    public ItemStack() {
    }

    public ItemStack(short s) {
        this(s, (byte) 1);
    }

    public ItemStack(short s, byte b2) {
        this(s, b2, (short) 0);
    }

    public ItemStack(short s, byte b2, short s2) {
        this(s, b2, s2, null);
    }

    public ItemStack(short s, byte b2, short s2, byte[] bArr) {
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

    public void read(DataInputStream dataInputStream) throws IOException {
        this.item = dataInputStream.readShort();
        if (this.item > -1) {
            this.stackSize = dataInputStream.readByte();
            this.damage = dataInputStream.readShort();
            int i = dataInputStream.readShort();
            if (i > -1) {
                this.nbt = new byte[i];
                dataInputStream.readFully(this.nbt);
            }
        }
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.item);
        if (this.item != -1) {
            dataOutputStream.writeByte(this.stackSize);
            dataOutputStream.writeShort(this.damage);
            if (this.nbt != null) {
                dataOutputStream.writeShort(this.nbt.length);
                dataOutputStream.write(this.nbt);
            }
        }
    }
}
