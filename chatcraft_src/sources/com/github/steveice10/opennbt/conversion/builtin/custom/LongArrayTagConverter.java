package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.LongArrayTag;

/* loaded from: classes.dex */
public class LongArrayTagConverter implements TagConverter<LongArrayTag, long[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public long[] convert(LongArrayTag longArrayTag) {
        return longArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public LongArrayTag convert(String str, long[] jArr) {
        return new LongArrayTag(str, jArr);
    }
}
