package com.github.steveice10.opennbt.tag.builtin;

import com.github.steveice10.opennbt.tag.TagCreateException;
import com.github.steveice10.opennbt.tag.TagRegistry;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ListTag extends Tag implements Iterable<Tag> {
    private Class<? extends Tag> type;
    private List<Tag> value;

    public ListTag(String str) {
        super(str);
        this.type = null;
        this.value = new ArrayList();
    }

    public ListTag(String str, Class<? extends Tag> cls) {
        this(str);
        this.type = cls;
    }

    public ListTag(String str, List<Tag> list) {
        this(str);
        setValue(list);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public List<Tag> getValue() {
        return new ArrayList(this.value);
    }

    public void setValue(List<Tag> list) {
        this.type = null;
        this.value.clear();
        Iterator<Tag> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public Class<? extends Tag> getElementType() {
        return this.type;
    }

    public boolean add(Tag tag) {
        if (tag == null) {
            return false;
        }
        if (this.type == null) {
            this.type = tag.getClass();
        } else if (tag.getClass() != this.type) {
            throw new IllegalArgumentException("Tag type cannot differ from ListTag type.");
        }
        return this.value.add(tag);
    }

    public boolean remove(Tag tag) {
        return this.value.remove(tag);
    }

    public <T extends Tag> T get(int i) {
        return (T) this.value.get(i);
    }

    public int size() {
        return this.value.size();
    }

    @Override // java.lang.Iterable
    public Iterator<Tag> iterator() {
        return this.value.iterator();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) throws NoSuchMethodException, IOException, SecurityException {
        this.type = null;
        this.value.clear();
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != 0) {
            this.type = TagRegistry.getClassFor(unsignedByte);
            if (this.type == null) {
                throw new IOException("Unknown tag ID in ListTag: " + unsignedByte);
            }
        }
        int i = dataInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            try {
                Tag tagCreateInstance = TagRegistry.createInstance(unsignedByte, BuildConfig.FLAVOR);
                tagCreateInstance.read(dataInput);
                add(tagCreateInstance);
            } catch (TagCreateException e) {
                throw new IOException("Failed to create tag.", e);
            }
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        if (this.type == null) {
            dataOutput.writeByte(0);
        } else {
            int idFor = TagRegistry.getIdFor(this.type);
            if (idFor == -1) {
                throw new IOException("ListTag contains unregistered tag class.");
            }
            dataOutput.writeByte(idFor);
        }
        dataOutput.writeInt(this.value.size());
        Iterator<Tag> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().write(dataOutput);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public ListTag mo12clone() {
        ArrayList arrayList = new ArrayList();
        Iterator<Tag> it = this.value.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mo12clone());
        }
        return new ListTag(getName(), arrayList);
    }
}
