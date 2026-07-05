package com.github.steveice10.mc.v1_12.protocol.ingame.server.windows;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.UnlockRecipesAction;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ServerUnlockRecipesPacket implements Packet {
    private UnlockRecipesAction action;
    private boolean activateFiltering;
    private List<Integer> alreadyKnownRecipes;
    private boolean openCraftingBook;
    private List<Integer> recipes;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUnlockRecipesPacket() {
    }

    private ServerUnlockRecipesPacket(boolean z, boolean z2, List<Integer> list) {
        this.openCraftingBook = z;
        this.activateFiltering = z2;
        this.recipes = list;
    }

    public ServerUnlockRecipesPacket(boolean z, boolean z2, List<Integer> list, List<Integer> list2) {
        this(z, z2, list);
        this.action = UnlockRecipesAction.INIT;
        this.alreadyKnownRecipes = list2;
    }

    public ServerUnlockRecipesPacket(boolean z, boolean z2, List<Integer> list, UnlockRecipesAction unlockRecipesAction) {
        this(z, z2, list);
        if (unlockRecipesAction != UnlockRecipesAction.ADD && unlockRecipesAction != UnlockRecipesAction.REMOVE) {
            throw new IllegalArgumentException("action must be ADD or REMOVE");
        }
        this.action = unlockRecipesAction;
    }

    public UnlockRecipesAction getAction() {
        return this.action;
    }

    public List<Integer> getRecipes() {
        return this.recipes;
    }

    public List<Integer> getAlreadyKnownRecipes() {
        if (this.action != UnlockRecipesAction.INIT) {
            throw new IllegalStateException("alreadyKnownRecipes is only set if action is " + UnlockRecipesAction.INIT + " but it was " + this.action);
        }
        return this.alreadyKnownRecipes;
    }

    public boolean getOpenCraftingBook() {
        return this.openCraftingBook;
    }

    public boolean getActivateFiltering() {
        return this.activateFiltering;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.action = (UnlockRecipesAction) MagicValues.key(UnlockRecipesAction.class, Integer.valueOf(netInput.readVarInt()));
        this.openCraftingBook = netInput.readBoolean();
        this.activateFiltering = netInput.readBoolean();
        if (this.action == UnlockRecipesAction.INIT) {
            int varInt = netInput.readVarInt();
            this.alreadyKnownRecipes = new ArrayList(varInt);
            for (int i = 0; i < varInt; i++) {
                this.alreadyKnownRecipes.add(Integer.valueOf(netInput.readVarInt()));
            }
        }
        int varInt2 = netInput.readVarInt();
        this.recipes = new ArrayList(varInt2);
        for (int i2 = 0; i2 < varInt2; i2++) {
            this.recipes.add(Integer.valueOf(netInput.readVarInt()));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        netOutput.writeBoolean(this.openCraftingBook);
        netOutput.writeBoolean(this.activateFiltering);
        if (this.action == UnlockRecipesAction.INIT) {
            netOutput.writeVarInt(this.alreadyKnownRecipes.size());
            Iterator<Integer> it = this.alreadyKnownRecipes.iterator();
            while (it.hasNext()) {
                netOutput.writeVarInt(it.next().intValue());
            }
        }
        netOutput.writeVarInt(this.recipes.size());
        Iterator<Integer> it2 = this.recipes.iterator();
        while (it2.hasNext()) {
            netOutput.writeVarInt(it2.next().intValue());
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
