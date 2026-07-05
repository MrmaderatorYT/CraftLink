package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.ShortTag;

/* loaded from: classes.dex */
public class ShortTagConverter implements TagConverter<ShortTag, Short> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Short convert(ShortTag shortTag) {
        return shortTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public ShortTag convert(String str, Short sh) {
        return new ShortTag(str, sh.shortValue());
    }
}
