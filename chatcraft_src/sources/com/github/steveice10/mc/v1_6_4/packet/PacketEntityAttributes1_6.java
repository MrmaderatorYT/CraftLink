package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PacketEntityAttributes1_6 extends Packet {
    public int entityId;
    public Map<String, Double> properties;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 44;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityAttributes1_6() {
    }

    public PacketEntityAttributes1_6(int i, Map<String, Double> map) {
        if (map.size() == 0) {
            throw new IllegalArgumentException("Properties map is empty.");
        }
        this.entityId = i;
        this.properties = map;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        int i = netInput.readInt();
        this.properties = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            this.properties.put(netInput.readString(), Double.valueOf(netInput.readDouble()));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.properties.size());
        for (String str : this.properties.keySet()) {
            netOutput.writeString(str);
            netOutput.writeDouble(this.properties.get(str).doubleValue());
        }
    }
}
