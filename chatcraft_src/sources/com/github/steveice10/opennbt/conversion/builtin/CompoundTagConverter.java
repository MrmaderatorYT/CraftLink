package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.ConverterRegistry;
import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class CompoundTagConverter implements TagConverter<CompoundTag, Map> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public Map convert(CompoundTag compoundTag) {
        HashMap map = new HashMap();
        Map<String, Tag> value = compoundTag.getValue();
        Iterator<String> it = value.keySet().iterator();
        while (it.hasNext()) {
            Tag tag = value.get(it.next());
            map.put(tag.getName(), ConverterRegistry.convertToValue(tag));
        }
        return map;
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public CompoundTag convert(String str, Map map) {
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            map2.put(str2, ConverterRegistry.convertToTag(str2, map.get(str2)));
        }
        return new CompoundTag(str, map2);
    }
}
