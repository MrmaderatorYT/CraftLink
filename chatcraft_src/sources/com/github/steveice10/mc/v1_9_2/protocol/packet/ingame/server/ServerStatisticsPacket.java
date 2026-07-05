package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Achievement;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakBlockStatistic;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakItemStatistic;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.CraftItemStatistic;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.GenericStatistic;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.UseItemStatistic;
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5 A[SYNTHETIC] */
    @Override // com.github.steveice10.packetlib.packet.Packet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void read(com.github.steveice10.packetlib.io.NetInput r7) {
        /*
            r6 = this;
            int r0 = r7.readVarInt()
            r1 = 0
        L5:
            if (r1 >= r0) goto Lb9
            java.lang.String r2 = r7.readString()
            r3 = 0
            java.lang.String r4 = "achievement."
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Exception -> La2
            if (r4 == 0) goto L1f
            java.lang.Class<com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Achievement> r4 = com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Achievement.class
            java.lang.Object r2 = com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues.key(r4, r2)     // Catch: java.lang.Exception -> La2
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic r2 = (com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic) r2     // Catch: java.lang.Exception -> La2
        L1c:
            r3 = r2
            goto La6
        L1f:
            java.lang.String r4 = "stats.craftItem."
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Exception -> La2
            if (r4 == 0) goto L3e
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.CraftItemStatistic r4 = new com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.CraftItemStatistic     // Catch: java.lang.Exception -> La2
            java.lang.String r5 = "."
            int r5 = r2.lastIndexOf(r5)     // Catch: java.lang.Exception -> La2
            int r5 = r5 + 1
            java.lang.String r2 = r2.substring(r5)     // Catch: java.lang.Exception -> La2
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> La2
            r4.<init>(r2)     // Catch: java.lang.Exception -> La2
        L3c:
            r3 = r4
            goto La6
        L3e:
            java.lang.String r4 = "stats.mineBlock."
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Exception -> La2
            if (r4 == 0) goto L5c
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakBlockStatistic r4 = new com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakBlockStatistic     // Catch: java.lang.Exception -> La2
            java.lang.String r5 = "."
            int r5 = r2.lastIndexOf(r5)     // Catch: java.lang.Exception -> La2
            int r5 = r5 + 1
            java.lang.String r2 = r2.substring(r5)     // Catch: java.lang.Exception -> La2
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> La2
            r4.<init>(r2)     // Catch: java.lang.Exception -> La2
            goto L3c
        L5c:
            java.lang.String r4 = "stats.useItem."
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Exception -> La2
            if (r4 == 0) goto L7a
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.UseItemStatistic r4 = new com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.UseItemStatistic     // Catch: java.lang.Exception -> La2
            java.lang.String r5 = "."
            int r5 = r2.lastIndexOf(r5)     // Catch: java.lang.Exception -> La2
            int r5 = r5 + 1
            java.lang.String r2 = r2.substring(r5)     // Catch: java.lang.Exception -> La2
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> La2
            r4.<init>(r2)     // Catch: java.lang.Exception -> La2
            goto L3c
        L7a:
            java.lang.String r4 = "stats.breakItem."
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Exception -> La2
            if (r4 == 0) goto L98
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakItemStatistic r4 = new com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.BreakItemStatistic     // Catch: java.lang.Exception -> La2
            java.lang.String r5 = "."
            int r5 = r2.lastIndexOf(r5)     // Catch: java.lang.Exception -> La2
            int r5 = r5 + 1
            java.lang.String r2 = r2.substring(r5)     // Catch: java.lang.Exception -> La2
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> La2
            r4.<init>(r2)     // Catch: java.lang.Exception -> La2
            goto L3c
        L98:
            java.lang.Class<com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.GenericStatistic> r4 = com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.GenericStatistic.class
            java.lang.Object r2 = com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues.key(r4, r2)     // Catch: java.lang.Exception -> La2
            com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic r2 = (com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic) r2     // Catch: java.lang.Exception -> La2
            goto L1c
        La2:
            r2 = move-exception
            r2.printStackTrace()
        La6:
            int r2 = r7.readVarInt()
            if (r3 == 0) goto Lb5
            java.util.Map<com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic.Statistic, java.lang.Integer> r4 = r6.statistics
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.put(r3, r2)
        Lb5:
            int r1 = r1 + 1
            goto L5
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.ServerStatisticsPacket.read(com.github.steveice10.packetlib.io.NetInput):void");
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
}
