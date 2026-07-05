package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.DoubleArrayTag;

/* loaded from: classes.dex */
public class DoubleArrayTagConverter implements TagConverter<DoubleArrayTag, double[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public double[] convert(DoubleArrayTag doubleArrayTag) {
        return doubleArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public DoubleArrayTag convert(String str, double[] dArr) {
        return new DoubleArrayTag(str, dArr);
    }
}
