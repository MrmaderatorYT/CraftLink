package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.StringTag;

/* loaded from: classes.dex */
public class StringTagConverter implements TagConverter<StringTag, String> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public String convert(StringTag stringTag) {
        return stringTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public StringTag convert(String str, String str2) {
        return new StringTag(str, str2);
    }
}
