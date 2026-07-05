package com.github.steveice10.opennbt.tag;

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
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TagRegistry {
    private static final Map<Integer, Class<? extends Tag>> idToTag = new HashMap();
    private static final Map<Class<? extends Tag>, Integer> tagToId = new HashMap();

    static {
        register(1, ByteTag.class);
        register(2, ShortTag.class);
        register(3, IntTag.class);
        register(4, LongTag.class);
        register(5, FloatTag.class);
        register(6, DoubleTag.class);
        register(7, ByteArrayTag.class);
        register(8, StringTag.class);
        register(9, ListTag.class);
        register(10, CompoundTag.class);
        register(11, IntArrayTag.class);
        register(60, DoubleArrayTag.class);
        register(61, FloatArrayTag.class);
        register(62, LongArrayTag.class);
        register(63, SerializableArrayTag.class);
        register(64, SerializableTag.class);
        register(65, ShortArrayTag.class);
        register(66, StringArrayTag.class);
    }

    public static void register(int i, Class<? extends Tag> cls) {
        if (idToTag.containsKey(Integer.valueOf(i))) {
            throw new TagRegisterException("Tag ID \"" + i + "\" is already in use.");
        }
        if (tagToId.containsKey(cls)) {
            throw new TagRegisterException("Tag \"" + cls.getSimpleName() + "\" is already registered.");
        }
        idToTag.put(Integer.valueOf(i), cls);
        tagToId.put(cls, Integer.valueOf(i));
    }

    public static Class<? extends Tag> getClassFor(int i) {
        if (idToTag.containsKey(Integer.valueOf(i))) {
            return idToTag.get(Integer.valueOf(i));
        }
        return null;
    }

    public static int getIdFor(Class<? extends Tag> cls) {
        if (tagToId.containsKey(cls)) {
            return tagToId.get(cls).intValue();
        }
        return -1;
    }

    public static Tag createInstance(int i, String str) throws NoSuchMethodException, SecurityException, TagCreateException {
        Class<? extends Tag> cls = idToTag.get(Integer.valueOf(i));
        if (cls == null) {
            throw new TagCreateException("Could not find tag with ID \"" + i + "\".");
        }
        try {
            Constructor<? extends Tag> declaredConstructor = cls.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(str);
        } catch (Exception e) {
            throw new TagCreateException("Failed to create instance of tag \"" + cls.getSimpleName() + "\".", e);
        }
    }
}
