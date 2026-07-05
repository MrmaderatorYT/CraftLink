package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.LongTag;

/* loaded from: classes.dex */
public class LongTagConverter implements TagConverter<LongTag, Long> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Long convert(LongTag longTag) {
        return longTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public LongTag convert(String str, Long l) {
        return new LongTag(str, l.longValue());
    }
}
