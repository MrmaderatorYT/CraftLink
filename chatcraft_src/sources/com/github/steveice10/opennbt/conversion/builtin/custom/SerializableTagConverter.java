package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.SerializableTag;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SerializableTagConverter implements TagConverter<SerializableTag, Serializable> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Serializable convert(SerializableTag serializableTag) {
        return serializableTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public SerializableTag convert(String str, Serializable serializable) {
        return new SerializableTag(str, serializable);
    }
}
