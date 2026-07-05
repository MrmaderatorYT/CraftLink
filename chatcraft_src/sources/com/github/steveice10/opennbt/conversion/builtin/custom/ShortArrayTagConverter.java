package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.ShortArrayTag;

/* loaded from: classes.dex */
public class ShortArrayTagConverter implements TagConverter<ShortArrayTag, short[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public short[] convert(ShortArrayTag shortArrayTag) {
        return shortArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public ShortArrayTag convert(String str, short[] sArr) {
        return new ShortArrayTag(str, sArr);
    }
}
