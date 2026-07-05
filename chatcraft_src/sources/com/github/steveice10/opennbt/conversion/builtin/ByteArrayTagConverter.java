package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.ByteArrayTag;

/* loaded from: classes.dex */
public class ByteArrayTagConverter implements TagConverter<ByteArrayTag, byte[]> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public byte[] convert(ByteArrayTag byteArrayTag) {
        return byteArrayTag.getValue();
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public ByteArrayTag convert(String str, byte[] bArr) {
        return new ByteArrayTag(str, bArr);
    }
}
