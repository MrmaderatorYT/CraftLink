package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.SerializableArrayTag;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SerializableArrayTagConverter implements TagConverter<SerializableArrayTag, Serializable[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Serializable[] convert(SerializableArrayTag serializableArrayTag) {
        return serializableArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public SerializableArrayTag convert(String str, Serializable[] serializableArr) {
        return new SerializableArrayTag(str, serializableArr);
    }
}
