package com.github.steveice10.mc.v1_8.protocol.data.game;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.MetadataType;

/* loaded from: classes.dex */
public class EntityMetadata {
    private int id;
    private MetadataType type;
    private Object value;

    public EntityMetadata(int i, MetadataType metadataType, Object obj) {
        this.id = i;
        this.type = metadataType;
        this.value = obj;
    }

    public int getId() {
        return this.id;
    }

    public MetadataType getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EntityMetadata entityMetadata = (EntityMetadata) obj;
        return this.id == entityMetadata.id && this.type == entityMetadata.type && this.value.equals(entityMetadata.value);
    }

    public int hashCode() {
        return (((this.id * 31) + this.type.hashCode()) * 31) + this.value.hashCode();
    }
}
