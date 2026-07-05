package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.data.game.attribute.Attribute;
import com.github.steveice10.mc.v1_8.protocol.data.game.attribute.AttributeModifier;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.AttributeType;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ModifierOperation;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.util.ArrayList;
import java.util.List;

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
        this.entityId = netInput.readVarInt();
        this.attributes = new ArrayList();
        int i = netInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            String string = netInput.readString();
            double d = netInput.readDouble();
            ArrayList arrayList = new ArrayList();
            int varInt = netInput.readVarInt();
            for (int i3 = 0; i3 < varInt; i3++) {
                arrayList.add(new AttributeModifier(netInput.readUUID(), netInput.readDouble(), (ModifierOperation) MagicValues.key(ModifierOperation.class, Byte.valueOf(netInput.readByte()))));
            }
            this.attributes.add(new Attribute((AttributeType) MagicValues.key(AttributeType.class, string), d, arrayList));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeInt(this.attributes.size());
        for (Attribute attribute : this.attributes) {
            netOutput.writeString((String) MagicValues.value(String.class, attribute.getType()));
            netOutput.writeDouble(attribute.getValue());
            netOutput.writeVarInt(attribute.getModifiers().size());
            for (AttributeModifier attributeModifier : attribute.getModifiers()) {
                netOutput.writeUUID(attributeModifier.getUUID());
                netOutput.writeDouble(attributeModifier.getAmount());
                netOutput.writeByte(((Integer) MagicValues.value(Integer.class, attributeModifier.getOperation())).intValue());
            }
        }
    }
}
