package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.FloatArrayTag;

/* loaded from: classes.dex */
public class FloatArrayTagConverter implements TagConverter<FloatArrayTag, float[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public float[] convert(FloatArrayTag floatArrayTag) {
        return floatArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public FloatArrayTag convert(String str, float[] fArr) {
        return new FloatArrayTag(str, fArr);
    }
}
