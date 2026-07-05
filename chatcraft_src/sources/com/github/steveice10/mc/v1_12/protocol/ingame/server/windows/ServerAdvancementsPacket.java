package com.github.steveice10.mc.v1_12.protocol.ingame.server.windows;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.advancement.Advancement;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ServerAdvancementsPacket implements Packet {
    private List<Advancement> advancements;
    private Map<String, Map<String, Long>> progress;
    private List<String> removedAdvancements;
    private boolean reset;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerAdvancementsPacket() {
    }

    public ServerAdvancementsPacket(boolean z, List<Advancement> list, List<String> list2, Map<String, Map<String, Long>> map) {
        this.reset = z;
        this.advancements = list;
        this.removedAdvancements = list2;
        this.progress = map;
    }

    public boolean doesReset() {
        return this.reset;
    }

    public List<Advancement> getAdvancements() {
        return this.advancements;
    }

    public List<String> getRemovedAdvancements() {
        return this.removedAdvancements;
    }

    public Map<String, Map<String, Long>> getProgress() {
        return this.progress;
    }

    public Map<String, Long> getProgress(String str) {
        return getProgress().get(str);
    }

    public Long getAchievedDate(String str, String str2) {
        return getProgress(str).get(str2);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        Advancement.DisplayData displayData;
        this.reset = netInput.readBoolean();
        this.advancements = new ArrayList();
        int varInt = netInput.readVarInt();
        while (true) {
            if (varInt <= 0) {
                break;
            }
            String string = netInput.readString();
            String string2 = netInput.readBoolean() ? netInput.readString() : null;
            if (netInput.readBoolean()) {
                Message messageFromString = Message.fromString(netInput.readString());
                Message messageFromString2 = Message.fromString(netInput.readString());
                ItemStack item = NetUtil.readItem(netInput);
                Advancement.DisplayData.FrameType frameType = (Advancement.DisplayData.FrameType) MagicValues.key(Advancement.DisplayData.FrameType.class, Integer.valueOf(netInput.readVarInt()));
                int i = netInput.readInt();
                displayData = new Advancement.DisplayData(messageFromString, messageFromString2, item, frameType, (i & 2) != 0, (i & 4) != 0, netInput.readFloat(), netInput.readFloat(), (i & 1) != 0 ? netInput.readString() : null);
            } else {
                displayData = null;
            }
            ArrayList arrayList = new ArrayList();
            for (int varInt2 = netInput.readVarInt(); varInt2 > 0; varInt2--) {
                arrayList.add(netInput.readString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (int varInt3 = netInput.readVarInt(); varInt3 > 0; varInt3--) {
                ArrayList arrayList3 = new ArrayList();
                for (int varInt4 = netInput.readVarInt(); varInt4 > 0; varInt4--) {
                    arrayList3.add(netInput.readString());
                }
                arrayList2.add(arrayList3);
            }
            this.advancements.add(new Advancement(string, string2, arrayList, arrayList2, displayData));
            varInt--;
        }
        this.removedAdvancements = new ArrayList();
        for (int varInt5 = netInput.readVarInt(); varInt5 > 0; varInt5--) {
            this.removedAdvancements.add(netInput.readString());
        }
        this.progress = new HashMap();
        for (int varInt6 = netInput.readVarInt(); varInt6 > 0; varInt6--) {
            String string3 = netInput.readString();
            HashMap map = new HashMap();
            for (int varInt7 = netInput.readVarInt(); varInt7 > 0; varInt7--) {
                map.put(netInput.readString(), netInput.readBoolean() ? Long.valueOf(netInput.readLong()) : null);
            }
            this.progress.put(string3, map);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeBoolean(this.reset);
        netOutput.writeVarInt(this.advancements.size());
        Iterator<Advancement> it = this.advancements.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Advancement next = it.next();
            netOutput.writeString(next.getId());
            if (next.getParentId() != null) {
                netOutput.writeBoolean(true);
                netOutput.writeString(next.getParentId());
            } else {
                netOutput.writeBoolean(false);
            }
            Advancement.DisplayData displayData = next.getDisplayData();
            if (displayData != null) {
                netOutput.writeBoolean(true);
                netOutput.writeString(displayData.getTitle().toJsonString());
                netOutput.writeString(displayData.getDescription().toJsonString());
                NetUtil.writeItem(netOutput, displayData.getIcon());
                netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, displayData.getFrameType())).intValue());
                String backgroundTexture = displayData.getBackgroundTexture();
                int i = backgroundTexture != null ? 1 : 0;
                if (displayData.doesShowToast()) {
                    i |= 2;
                }
                if (displayData.isHidden()) {
                    i |= 4;
                }
                netOutput.writeInt(i);
                if (backgroundTexture != null) {
                    netOutput.writeString(backgroundTexture);
                }
                netOutput.writeFloat(displayData.getPosX());
                netOutput.writeFloat(displayData.getPosY());
            } else {
                netOutput.writeBoolean(false);
            }
            netOutput.writeVarInt(next.getCriteria().size());
            Iterator<String> it2 = next.getCriteria().iterator();
            while (it2.hasNext()) {
                netOutput.writeString(it2.next());
            }
            netOutput.writeVarInt(next.getRequirements().size());
            for (List<String> list : next.getRequirements()) {
                netOutput.writeVarInt(list.size());
                Iterator<String> it3 = list.iterator();
                while (it3.hasNext()) {
                    netOutput.writeString(it3.next());
                }
            }
        }
        netOutput.writeVarInt(this.removedAdvancements.size());
        Iterator<String> it4 = this.removedAdvancements.iterator();
        while (it4.hasNext()) {
            netOutput.writeString(it4.next());
        }
        netOutput.writeVarInt(this.progress.size());
        for (Map.Entry<String, Map<String, Long>> entry : this.progress.entrySet()) {
            netOutput.writeString(entry.getKey());
            Map<String, Long> value = entry.getValue();
            netOutput.writeVarInt(value.size());
            for (Map.Entry<String, Long> entry2 : value.entrySet()) {
                netOutput.writeString(entry2.getKey());
                if (entry2.getValue() != null) {
                    netOutput.writeBoolean(true);
                    netOutput.writeLong(entry2.getValue().longValue());
                } else {
                    netOutput.writeBoolean(false);
                }
            }
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
