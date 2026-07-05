package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.AttributeModifier;
import com.github.steveice10.mc.v1_6_4.data.EntityAttribute;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class PacketEntityAttributes1_6_4 extends Packet {
    public List<EntityAttribute> attributes;
    public int entityId;

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

    public PacketEntityAttributes1_6_4() {
    }

    public PacketEntityAttributes1_6_4(int i, List<EntityAttribute> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("Attribute map is empty.");
        }
        this.entityId = i;
        this.attributes = list;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        int i = netInput.readInt();
        this.attributes = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            EntityAttribute entityAttribute = new EntityAttribute(netInput.readString(), netInput.readDouble());
            short s = netInput.readShort();
            for (int i3 = 0; i3 < s; i3++) {
                entityAttribute.addModifier(new AttributeModifier(new UUID(netInput.readLong(), netInput.readLong()), netInput.readDouble(), netInput.readByte()));
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.attributes.size());
        for (EntityAttribute entityAttribute : this.attributes) {
            netOutput.writeString(entityAttribute.getName());
            netOutput.writeDouble(entityAttribute.getValue());
            netOutput.writeShort(entityAttribute.getModifiers().size());
            for (AttributeModifier attributeModifier : entityAttribute.getModifiers()) {
                netOutput.writeLong(attributeModifier.getUID().getMostSignificantBits());
                netOutput.writeLong(attributeModifier.getUID().getLeastSignificantBits());
                netOutput.writeDouble(attributeModifier.getAmount());
                netOutput.writeByte(attributeModifier.getOperation());
            }
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
