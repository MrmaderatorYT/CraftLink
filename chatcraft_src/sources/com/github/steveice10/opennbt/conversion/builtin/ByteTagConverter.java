package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.ByteTag;

/* loaded from: classes.dex */
public class ByteTagConverter implements TagConverter<ByteTag, Byte> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Byte convert(ByteTag byteTag) {
        return byteTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public ByteTag convert(String str, Byte b2) {
        return new ByteTag(str, b2.byteValue());
    }
}
