package com.github.steveice10.mc.v1_12.protocol.ingame.client.ingame.client.window;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.window.CraftingBookDataType;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ClientCraftingBookDataPacket implements Packet {
    private boolean craftingBookOpen;
    private boolean filterActive;
    private int recipeId;
    private CraftingBookDataType type;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientCraftingBookDataPacket() {
    }

    public ClientCraftingBookDataPacket(int i) {
        this.type = CraftingBookDataType.DISPLAYED_RECIPE;
        this.recipeId = i;
    }

    public ClientCraftingBookDataPacket(boolean z, boolean z2) {
        this.type = CraftingBookDataType.CRAFTING_BOOK_STATUS;
        this.craftingBookOpen = z;
        this.filterActive = z2;
    }

    public CraftingBookDataType getType() {
        return this.type;
    }

    private void ensureType(CraftingBookDataType craftingBookDataType, String str) {
        if (this.type == craftingBookDataType) {
            return;
        }
        throw new IllegalStateException(str + " is only set when type is " + craftingBookDataType + " but it is " + this.type);
    }

    public int getRecipeId() {
        ensureType(CraftingBookDataType.DISPLAYED_RECIPE, "recipeId");
        return this.recipeId;
    }

    public boolean isCraftingBookOpen() {
        ensureType(CraftingBookDataType.CRAFTING_BOOK_STATUS, "craftingBookOpen");
        return this.craftingBookOpen;
    }

    public boolean isFilterActive() {
        ensureType(CraftingBookDataType.CRAFTING_BOOK_STATUS, "filterActive");
        return this.filterActive;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) throws IOException {
        int[] iArr = AnonymousClass1.$SwitchMap$com$github$steveice10$mc$v1_10$protocol$data$game$window$CraftingBookDataType;
        CraftingBookDataType craftingBookDataType = (CraftingBookDataType) MagicValues.key(CraftingBookDataType.class, Integer.valueOf(netInput.readVarInt()));
        this.type = craftingBookDataType;
        switch (iArr[craftingBookDataType.ordinal()]) {
            case 1:
                this.recipeId = netInput.readInt();
                return;
            case 2:
                this.craftingBookOpen = netInput.readBoolean();
                this.filterActive = netInput.readBoolean();
                return;
            default:
                throw new IOException("Unknown crafting book data type: " + this.type);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        switch (this.type) {
            case DISPLAYED_RECIPE:
                netOutput.writeInt(this.recipeId);
                return;
            case CRAFTING_BOOK_STATUS:
                netOutput.writeBoolean(this.craftingBookOpen);
                netOutput.writeBoolean(this.filterActive);
                return;
            default:
                throw new IOException("Unknown crafting book data type: " + this.type);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
