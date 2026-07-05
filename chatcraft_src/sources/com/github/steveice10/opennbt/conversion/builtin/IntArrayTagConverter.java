package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.IntArrayTag;

/* loaded from: classes.dex */
public class IntArrayTagConverter implements TagConverter<IntArrayTag, int[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public int[] convert(IntArrayTag intArrayTag) {
        return intArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public IntArrayTag convert(String str, int[] iArr) {
        return new IntArrayTag(str, iArr);
    }
}
