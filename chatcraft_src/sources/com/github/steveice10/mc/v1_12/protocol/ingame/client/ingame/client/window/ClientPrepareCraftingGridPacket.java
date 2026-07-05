package com.github.steveice10.mc.v1_12.protocol.ingame.client.ingame.client.window;

import com.github.steveice10.mc.v1_10.protocol.data.game.window.PrepareCraftingGridEntry;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ClientPrepareCraftingGridPacket implements Packet {
    private int actionId;
    private List<PrepareCraftingGridEntry> prepareEntries;
    private List<PrepareCraftingGridEntry> returnEntries;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPrepareCraftingGridPacket() {
    }

    public ClientPrepareCraftingGridPacket(int i, int i2, List<PrepareCraftingGridEntry> list, List<PrepareCraftingGridEntry> list2) {
        this.windowId = i;
        this.actionId = i2;
        this.returnEntries = list;
        this.prepareEntries = list2;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getActionId() {
        return this.actionId;
    }

    public List<PrepareCraftingGridEntry> getReturnEntries() {
        return this.returnEntries;
    }

    public List<PrepareCraftingGridEntry> getPrepareEntries() {
        return this.prepareEntries;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.actionId = netInput.readShort();
        this.returnEntries = readEntries(netInput);
        this.prepareEntries = readEntries(netInput);
    }

    private static List<PrepareCraftingGridEntry> readEntries(NetInput netInput) {
        ArrayList arrayList = new ArrayList();
        for (int i = netInput.readShort(); i > 0; i--) {
            arrayList.add(new PrepareCraftingGridEntry(NetUtil.readItem(netInput), netInput.readByte(), netInput.readByte()));
        }
        return arrayList;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.actionId);
        writeEntries(netOutput, this.returnEntries);
        writeEntries(netOutput, this.prepareEntries);
    }

    private static void writeEntries(NetOutput netOutput, List<PrepareCraftingGridEntry> list) {
        netOutput.writeShort(list.size());
        for (PrepareCraftingGridEntry prepareCraftingGridEntry : list) {
            NetUtil.writeItem(netOutput, prepareCraftingGridEntry.getItem());
            netOutput.writeByte(prepareCraftingGridEntry.getCraftingGridSlot());
            netOutput.writeByte(prepareCraftingGridEntry.getPlayerInventorySlot());
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
