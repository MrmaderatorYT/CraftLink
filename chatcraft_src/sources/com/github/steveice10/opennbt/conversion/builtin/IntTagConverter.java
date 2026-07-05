package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.IntTag;

/* loaded from: classes.dex */
public class IntTagConverter implements TagConverter<IntTag, Integer> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Integer convert(IntTag intTag) {
        return intTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public IntTag convert(String str, Integer num) {
        return new IntTag(str, num.intValue());
    }
}
