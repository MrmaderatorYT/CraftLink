package com.github.steveice10.opennbt.conversion;

import com.github.steveice10.opennbt.conversion.builtin.ByteArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.ByteTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.CompoundTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.DoubleTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.FloatTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.IntArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.IntTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.ListTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.LongTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.ShortTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.StringTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.DoubleArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.FloatArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.LongArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.SerializableArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.SerializableTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.ShortArrayTagConverter;
import com.github.steveice10.opennbt.conversion.builtin.custom.StringArrayTagConverter;
import com.github.steveice10.opennbt.tag.TagRegisterException;
import com.github.steveice10.opennbt.tag.builtin.ByteArrayTag;
import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.DoubleTag;
import com.github.steveice10.opennbt.tag.builtin.FloatTag;
import com.github.steveice10.opennbt.tag.builtin.IntArrayTag;
import com.github.steveice10.opennbt.tag.builtin.IntTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.LongTag;
import com.github.steveice10.opennbt.tag.builtin.ShortTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import com.github.steveice10.opennbt.tag.builtin.custom.DoubleArrayTag;
import com.github.steveice10.opennbt.tag.builtin.custom.FloatArrayTag;
import com.github.steveice10.opennbt.tag.builtin.custom.LongArrayTag;
import com.github.steveice10.opennbt.tag.builtin.custom.SerializableArrayTag;
import com.github.steveice10.opennbt.tag.builtin.custom.SerializableTag;
import com.github.steveice10.opennbt.tag.builtin.custom.ShortArrayTag;
import com.github.steveice10.opennbt.tag.builtin.custom.StringArrayTag;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ConverterRegistry {
    private static final Map<Class<? extends Tag>, TagConverter<? extends Tag, ?>> tagToConverter = new HashMap();
    private static final Map<Class<?>, TagConverter<? extends Tag, ?>> typeToConverter = new HashMap();

    static {
        register(ByteTag.class, Byte.class, new ByteTagConverter());
        register(ShortTag.class, Short.class, new ShortTagConverter());
        register(IntTag.class, Integer.class, new IntTagConverter());
        register(LongTag.class, Long.class, new LongTagConverter());
        register(FloatTag.class, Float.class, new FloatTagConverter());
        register(DoubleTag.class, Double.class, new DoubleTagConverter());
        register(ByteArrayTag.class, byte[].class, new ByteArrayTagConverter());
        register(StringTag.class, String.class, new StringTagConverter());
        register(ListTag.class, List.class, new ListTagConverter());
        register(CompoundTag.class, Map.class, new CompoundTagConverter());
        register(IntArrayTag.class, int[].class, new IntArrayTagConverter());
        register(DoubleArrayTag.class, double[].class, new DoubleArrayTagConverter());
        register(FloatArrayTag.class, float[].class, new FloatArrayTagConverter());
        register(LongArrayTag.class, long[].class, new LongArrayTagConverter());
        register(SerializableArrayTag.class, Serializable[].class, new SerializableArrayTagConverter());
        register(SerializableTag.class, Serializable.class, new SerializableTagConverter());
        register(ShortArrayTag.class, short[].class, new ShortArrayTagConverter());
        register(StringArrayTag.class, String[].class, new StringArrayTagConverter());
    }

    public static <T extends Tag, V> void register(Class<T> cls, Class<V> cls2, TagConverter<T, V> tagConverter) {
        if (tagToConverter.containsKey(cls)) {
            throw new TagRegisterException("Type conversion to tag " + cls.getName() + " is already registered.");
        }
        if (typeToConverter.containsKey(cls2)) {
            throw new TagRegisterException("Tag conversion to type " + cls2.getName() + " is already registered.");
        }
        tagToConverter.put(cls, tagConverter);
        typeToConverter.put(cls2, tagConverter);
    }

    public static <T extends Tag, V> V convertToValue(T t) {
        if (t == null || t.getValue() == null) {
            return null;
        }
        if (!tagToConverter.containsKey(t.getClass())) {
            throw new ConversionException("Tag type " + t.getClass().getName() + " has no converter.");
        }
        return (V) tagToConverter.get(t.getClass()).convert(t);
    }

    public static <V, T extends Tag> T convertToTag(String str, V v) {
        if (v == null) {
            return null;
        }
        TagConverter<? extends Tag, ?> tagConverter = typeToConverter.get(v.getClass());
        if (tagConverter == null) {
            Iterator<Class<?>> it = getAllClasses(v.getClass()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Class<?> next = it.next();
                if (typeToConverter.containsKey(next)) {
                    try {
                        tagConverter = typeToConverter.get(next);
                        break;
                    } catch (ClassCastException unused) {
                        continue;
                    }
                }
            }
        }
        if (tagConverter == null) {
            throw new ConversionException("Value type " + v.getClass().getName() + " has no converter.");
        }
        return (T) tagConverter.convert(str, v);
    }

    private static Set<Class<?>> getAllClasses(Class<?> cls) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (cls != null) {
            linkedHashSet.add(cls);
            linkedHashSet.addAll(getAllSuperInterfaces(cls));
            cls = cls.getSuperclass();
        }
        if (linkedHashSet.contains(Serializable.class)) {
            linkedHashSet.remove(Serializable.class);
            linkedHashSet.add(Serializable.class);
        }
        return linkedHashSet;
    }

    private static Set<Class<?>> getAllSuperInterfaces(Class<?> cls) {
        HashSet hashSet = new HashSet();
        for (Class<?> cls2 : cls.getInterfaces()) {
            hashSet.add(cls2);
            hashSet.addAll(getAllSuperInterfaces(cls2));
        }
        return hashSet;
    }
}
