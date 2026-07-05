package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_7_7.protocol.data.game.Attribute;
import com.github.steveice10.mc.v1_7_7.protocol.data.game.AttributeModifier;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ServerEntityPropertiesPacket implements Packet {
    private List<Attribute> attributes;
    private int entityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityPropertiesPacket() {
    }

    public ServerEntityPropertiesPacket(int i, List<Attribute> list) {
        this.entityId = i;
        this.attributes = list;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.attributes = new ArrayList();
        int i = netInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            String string = netInput.readString();
            double d = netInput.readDouble();
            ArrayList arrayList = new ArrayList();
            short s = netInput.readShort();
            for (int i3 = 0; i3 < s; i3++) {
                arrayList.add(new AttributeModifier(new UUID(netInput.readLong(), netInput.readLong()), netInput.readDouble(), netInput.readByte()));
            }
            this.attributes.add(new Attribute(string, d, arrayList));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.attributes.size());
        for (Attribute attribute : this.attributes) {
            netOutput.writeString(attribute.getKey());
            netOutput.writeDouble(attribute.getValue());
            netOutput.writeShort(attribute.getModifiers().size());
            for (AttributeModifier attributeModifier : attribute.getModifiers()) {
                netOutput.writeLong(attributeModifier.getUUID().getMostSignificantBits());
                netOutput.writeLong(attributeModifier.getUUID().getLeastSignificantBits());
                netOutput.writeDouble(attributeModifier.getAmount());
                netOutput.writeByte(attributeModifier.getOperation());
            }
        }
    }
}
