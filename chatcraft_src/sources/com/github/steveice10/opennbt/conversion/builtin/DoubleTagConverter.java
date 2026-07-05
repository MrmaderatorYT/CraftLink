package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.DoubleTag;

/* loaded from: classes.dex */
public class DoubleTagConverter implements TagConverter<DoubleTag, Double> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Double convert(DoubleTag doubleTag) {
        return doubleTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public DoubleTag convert(String str, Double d) {
        return new DoubleTag(str, d.doubleValue());
    }
}
