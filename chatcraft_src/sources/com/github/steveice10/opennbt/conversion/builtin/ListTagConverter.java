package com.github.steveice10.opennbt.conversion.builtin;

import com.github.steveice10.opennbt.conversion.ConverterRegistry;
import com.github.steveice10.opennbt.conversion.TagConverter;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ListTagConverter implements TagConverter<ListTag, List> {
    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public List convert(ListTag listTag) {
        ArrayList arrayList = new ArrayList();
        Iterator<Tag> it = listTag.getValue().iterator();
        while (it.hasNext()) {
            arrayList.add(ConverterRegistry.convertToValue(it.next()));
        }
        return arrayList;
    }

    @Override // com.github.steveice10.opennbt.conversion.TagConverter
    public ListTag convert(String str, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ConverterRegistry.convertToTag(BuildConfig.FLAVOR, it.next()));
        }
        return new ListTag(str, arrayList);
    }
}
