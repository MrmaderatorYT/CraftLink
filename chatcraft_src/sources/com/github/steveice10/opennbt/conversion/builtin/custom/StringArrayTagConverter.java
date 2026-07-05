package com.github.steveice10.opennbt.conversion.builtin.custom;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.custom.StringArrayTag;

/* loaded from: classes.dex */
public class StringArrayTagConverter implements TagConverter<StringArrayTag, String[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public String[] convert(StringArrayTag stringArrayTag) {
        return stringArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public StringArrayTag convert(String str, String[] strArr) {
        return new StringArrayTag(str, strArr);
    }
}
