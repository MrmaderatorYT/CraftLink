package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.Achievement;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.BreakBlockStatistic;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.BreakItemStatistic;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.CraftItemStatistic;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.GenericStatistic;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.Statistic;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.statistic.UseItemStatistic;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.HashMap;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ServerStatisticsPacket implements Packet {
    private static final String BREAK_BLOCK_PREFIX = "stats.mineBlock.";
    private static final String BREAK_ITEM_PREFIX = "stats.breakItem.";
    private static final String CRAFT_ITEM_PREFIX = "stats.craftItem.";
    private static final String USE_ITEM_PREFIX = "stats.useItem.";
    private Map<Statistic, Integer> statistics;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerStatisticsPacket() {
        this.statistics = new HashMap();
    }

    public ServerStatisticsPacket(Map<Statistic, Integer> map) {
        this.statistics = new HashMap();
        this.statistics = map;
    }

    public Map<Statistic, Integer> getStatistics() {
        return this.statistics;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        Statistic statistic;
        Statistic breakItemStatistic;
        int varInt = netInput.readVarInt();
        for (int i = 0; i < varInt; i++) {
            String string = netInput.readString();
            if (string.startsWith("achievement.")) {
                statistic = (Statistic) MagicValues.key(Achievement.class, string);
            } else {
                if (string.startsWith(CRAFT_ITEM_PREFIX)) {
                    breakItemStatistic = new CraftItemStatistic(Integer.parseInt(string.substring(string.lastIndexOf(".") + 1)));
                } else if (string.startsWith(BREAK_BLOCK_PREFIX)) {
                    breakItemStatistic = new BreakBlockStatistic(Integer.parseInt(string.substring(string.lastIndexOf(".") + 1)));
                } else if (string.startsWith(USE_ITEM_PREFIX)) {
                    breakItemStatistic = new UseItemStatistic(Integer.parseInt(string.substring(string.lastIndexOf(".") + 1)));
                } else if (string.startsWith(BREAK_ITEM_PREFIX)) {
                    breakItemStatistic = new BreakItemStatistic(Integer.parseInt(string.substring(string.lastIndexOf(".") + 1)));
                } else {
                    statistic = (Statistic) MagicValues.key(GenericStatistic.class, string);
                }
                this.statistics.put(breakItemStatistic, Integer.valueOf(netInput.readVarInt()));
            }
            breakItemStatistic = statistic;
            this.statistics.put(breakItemStatistic, Integer.valueOf(netInput.readVarInt()));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.statistics.size());
        for (Statistic statistic : this.statistics.keySet()) {
            String str = BuildConfig.FLAVOR;
            if (statistic instanceof Achievement) {
                str = (String) MagicValues.value(String.class, (Achievement) statistic);
            } else if (statistic instanceof CraftItemStatistic) {
                str = CRAFT_ITEM_PREFIX + ((CraftItemStatistic) statistic).getId();
            } else if (statistic instanceof BreakBlockStatistic) {
                str = BREAK_BLOCK_PREFIX + ((CraftItemStatistic) statistic).getId();
            } else if (statistic instanceof UseItemStatistic) {
                str = USE_ITEM_PREFIX + ((CraftItemStatistic) statistic).getId();
            } else if (statistic instanceof BreakItemStatistic) {
                str = BREAK_ITEM_PREFIX + ((CraftItemStatistic) statistic).getId();
            } else if (statistic instanceof GenericStatistic) {
                str = (String) MagicValues.value(String.class, (GenericStatistic) statistic);
            }
            netOutput.writeString(str);
            netOutput.writeVarInt(this.statistics.get(statistic).intValue());
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
