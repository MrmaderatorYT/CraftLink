package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SerializableTag extends Tag {
    private Serializable value;

    public SerializableTag(String str) {
        this(str, 0);
    }

    public SerializableTag(String str, Serializable serializable) {
        super(str);
        this.value = serializable;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Serializable getValue() {
        return this.value;
    }

    public void setValue(Serializable serializable) {
        this.value = serializable;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) throws IOException {
        try {
            this.value = (Serializable) new ObjectInputStream(new DataInputInputStream(dataInput)).readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found while reading SerializableTag!", e);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        new ObjectOutputStream(new DataOutputOutputStream(dataOutput)).writeObject(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public SerializableTag mo12clone() {
        return new SerializableTag(getName(), getValue());
    }

    private static class DataInputInputStream extends InputStream {
        private DataInput in;

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        public DataInputInputStream(DataInput dataInput) {
            this.in = dataInput;
        }

        @Override // java.io.InputStream
        public int read() {
            return this.in.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            this.in.readFully(bArr);
            return bArr.length;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            this.in.readFully(bArr, i, i2);
            return i2;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            return this.in.skipBytes((int) j);
        }

        @Override // java.io.InputStream
        public int available() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }
    }

    private static class DataOutputOutputStream extends OutputStream {
        private DataOutput out;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public DataOutputOutputStream(DataOutput dataOutput) {
            this.out = dataOutput;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
        }
    }
}
