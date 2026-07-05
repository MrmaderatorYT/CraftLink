package com.github.steveice10.opennbt.tag.builtin;

import com.github.steveice10.opennbt.NBTIO;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class CompoundTag extends Tag implements Iterable<Tag> {
    private Map<String, Tag> value;

    public CompoundTag(String str) {
        this(str, new LinkedHashMap());
    }

    public CompoundTag(String str, Map<String, Tag> map) {
        super(str);
        this.value = new LinkedHashMap(map);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Map<String, Tag> getValue() {
        return new LinkedHashMap(this.value);
    }

    public void setValue(Map<String, Tag> map) {
        this.value = new LinkedHashMap(map);
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public boolean contains(String str) {
        return this.value.containsKey(str);
    }

    public <T extends Tag> T get(String str) {
        return (T) this.value.get(str);
    }

    public <T extends Tag> T put(T t) {
        return (T) this.value.put(t.getName(), t);
    }

    public <T extends Tag> T remove(String str) {
        return (T) this.value.remove(str);
    }

    public Set<String> keySet() {
        return this.value.keySet();
    }

    public Collection<Tag> values() {
        return this.value.values();
    }

    public int size() {
        return this.value.size();
    }

    public void clear() {
        this.value.clear();
    }

    @Override // java.lang.Iterable
    public Iterator<Tag> iterator() {
        return values().iterator();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                Tag tag = NBTIO.readTag(dataInput);
                if (tag == null) {
                    break;
                } else {
                    arrayList.add(tag);
                }
            } catch (EOFException unused) {
                throw new IOException("Closing EndTag was not found!");
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            put((Tag) it.next());
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        Iterator<Tag> it = this.value.values().iterator();
        while (it.hasNext()) {
            NBTIO.writeTag(dataOutput, it.next());
        }
        dataOutput.writeByte(0);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public CompoundTag mo12clone() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Tag> entry : this.value.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().mo12clone());
        }
        return new CompoundTag(getName(), linkedHashMap);
    }
}
