package com.github.steveice10.opennbt;

import com.github.steveice10.opennbt.tag.TagCreateException;
import com.github.steveice10.opennbt.tag.TagRegistry;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class NBTIO {
    public static CompoundTag readFile(String str) {
        return readFile(new File(str));
    }

    public static CompoundTag readFile(File file) {
        return readFile(file, true, false);
    }

    public static CompoundTag readFile(String str, boolean z, boolean z2) {
        return readFile(new File(str), z, z2);
    }

    public static CompoundTag readFile(File file, boolean z, boolean z2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Tag tag = readTag(z ? new GZIPInputStream(fileInputStream) : fileInputStream, z2);
        if (!(tag instanceof CompoundTag)) {
            throw new IOException("Root tag is not a CompoundTag!");
        }
        return (CompoundTag) tag;
    }

    public static void writeFile(CompoundTag compoundTag, String str) throws IOException {
        writeFile(compoundTag, new File(str));
    }

    public static void writeFile(CompoundTag compoundTag, File file) throws IOException {
        writeFile(compoundTag, file, true, false);
    }

    public static void writeFile(CompoundTag compoundTag, String str, boolean z, boolean z2) throws IOException {
        writeFile(compoundTag, new File(str), z, z2);
    }

    public static void writeFile(CompoundTag compoundTag, File file, boolean z, boolean z2) throws IOException {
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStream gZIPOutputStream = z ? new GZIPOutputStream(fileOutputStream) : fileOutputStream;
        writeTag(gZIPOutputStream, compoundTag, z2);
        gZIPOutputStream.close();
    }

    public static Tag readTag(InputStream inputStream) {
        return readTag(inputStream, false);
    }

    public static Tag readTag(InputStream inputStream, boolean z) {
        return readTag(z ? new LittleEndianDataInputStream(inputStream) : new DataInputStream(inputStream));
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static Tag readTag(DataInput dataInput) {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte == 0) {
            return null;
        }
        try {
            Tag tagCreateInstance = TagRegistry.createInstance(unsignedByte, dataInput.readUTF());
            tagCreateInstance.read(dataInput);
            return tagCreateInstance;
        } catch (TagCreateException e) {
            throw new IOException("Failed to create tag.", e);
        }
    }

    public static void writeTag(OutputStream outputStream, Tag tag) {
        writeTag(outputStream, tag, false);
    }

    public static void writeTag(OutputStream outputStream, Tag tag, boolean z) {
        writeTag(z ? new LittleEndianDataOutputStream(outputStream) : new DataOutputStream(outputStream), tag);
    }

    public static void writeTag(DataOutput dataOutput, Tag tag) {
        dataOutput.writeByte(TagRegistry.getIdFor(tag.getClass()));
        dataOutput.writeUTF(tag.getName());
        tag.write(dataOutput);
    }

    private static class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
        public LittleEndianDataInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) {
            return this.in.read(bArr, 0, bArr.length);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return this.in.read(bArr, i, i2);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            readFully(bArr, 0, bArr.length);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = 0;
            while (i3 < i2) {
                int i4 = this.in.read(bArr, i + i3, i2 - i3);
                if (i4 < 0) {
                    throw new EOFException();
                }
                i3 += i4;
            }
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int i2 = 0;
            while (i2 < i) {
                int iSkip = (int) this.in.skip(i - i2);
                if (iSkip <= 0) {
                    break;
                }
                i2 += iSkip;
            }
            return i2;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            int i = this.in.read();
            if (i >= 0) {
                return i != 0;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.in.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            int i = this.in.read();
            if (i >= 0) {
                return i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.in.read();
            int i2 = this.in.read();
            if ((i | i2) >= 0) {
                return (short) (i | (i2 << 8));
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.in.read();
            int i2 = this.in.read();
            if ((i | i2) >= 0) {
                return i | (i2 << 8);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            int i = this.in.read();
            int i2 = this.in.read();
            if ((i | i2) >= 0) {
                return (char) (i | (i2 << 8));
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.in.read();
            int i2 = this.in.read();
            int i3 = this.in.read();
            int i4 = this.in.read();
            if ((i | i2 | i3 | i4) >= 0) {
                return i | (i2 << 8) | (i3 << 16) | (i4 << 24);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public long readLong() throws EOFException {
            long j = this.in.read();
            long j2 = this.in.read();
            long j3 = this.in.read();
            long j4 = this.in.read();
            long j5 = this.in.read();
            long j6 = this.in.read();
            long j7 = this.in.read();
            long j8 = this.in.read();
            if ((j | j2 | j3 | j4 | j5 | j6 | j7 | j8) >= 0) {
                return j | (j2 << 8) | (j3 << 16) | (j4 << 24) | (j5 << 32) | (j6 << 40) | (j7 << 48) | (j8 << 56);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public String readLine() {
            throw new UnsupportedOperationException("Use readUTF.");
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            byte[] bArr = new byte[readUnsignedShort()];
            readFully(bArr);
            return new String(bArr, "UTF-8");
        }
    }

    private static class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
        public LittleEndianDataOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public synchronized void write(int i) {
            this.out.write(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public synchronized void write(byte[] bArr, int i, int i2) {
            this.out.write(bArr, i, i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.out.flush();
        }

        @Override // java.io.DataOutput
        public void writeBoolean(boolean z) throws IOException {
            this.out.write(z ? 1 : 0);
        }

        @Override // java.io.DataOutput
        public void writeByte(int i) throws IOException {
            this.out.write(i);
        }

        @Override // java.io.DataOutput
        public void writeShort(int i) throws IOException {
            this.out.write(i & 255);
            this.out.write((i >>> 8) & 255);
        }

        @Override // java.io.DataOutput
        public void writeChar(int i) throws IOException {
            this.out.write(i & 255);
            this.out.write((i >>> 8) & 255);
        }

        @Override // java.io.DataOutput
        public void writeInt(int i) throws IOException {
            this.out.write(i & 255);
            this.out.write((i >>> 8) & 255);
            this.out.write((i >>> 16) & 255);
            this.out.write((i >>> 24) & 255);
        }

        @Override // java.io.DataOutput
        public void writeLong(long j) throws IOException {
            this.out.write((int) (j & 255));
            this.out.write((int) ((j >>> 8) & 255));
            this.out.write((int) ((j >>> 16) & 255));
            this.out.write((int) ((j >>> 24) & 255));
            this.out.write((int) ((j >>> 32) & 255));
            this.out.write((int) ((j >>> 40) & 255));
            this.out.write((int) ((j >>> 48) & 255));
            this.out.write((int) ((j >>> 56) & 255));
        }

        @Override // java.io.DataOutput
        public void writeFloat(float f) throws IOException {
            writeInt(Float.floatToIntBits(f));
        }

        @Override // java.io.DataOutput
        public void writeDouble(double d) throws IOException {
            writeLong(Double.doubleToLongBits(d));
        }

        @Override // java.io.DataOutput
        public void writeBytes(String str) throws IOException {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                this.out.write((byte) str.charAt(i));
            }
        }

        @Override // java.io.DataOutput
        public void writeChars(String str) throws IOException {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                this.out.write(cCharAt & 255);
                this.out.write((cCharAt >>> '\b') & 255);
            }
        }

        @Override // java.io.DataOutput
        public void writeUTF(String str) throws IOException {
            byte[] bytes = str.getBytes("UTF-8");
            writeShort(bytes.length);
            write(bytes);
        }
    }
}
