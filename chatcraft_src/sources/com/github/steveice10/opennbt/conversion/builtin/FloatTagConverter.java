package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.FloatTag;

/* loaded from: classes.dex */
public class FloatTagConverter implements TagConverter<FloatTag, Float> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Float convert(FloatTag floatTag) {
        return floatTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public FloatTag convert(String str, Float f) {
        return new FloatTag(str, f.floatValue());
    }
}
