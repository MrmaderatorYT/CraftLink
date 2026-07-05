package com.github.steveice10.mc.OldProtocol;

import com.github.steveice10.packetlib.io.stream.StreamNetInput;
import java.io.DataInputStream;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

/* loaded from: classes.dex */
public class StreamNetInput_Old extends StreamNetInput {
    private DataInputStream dataInputStream;

    public StreamNetInput_Old(InputStream inputStream) {
        super(inputStream);
        this.dataInputStream = new DataInputStream(inputStream);
    }

    @Override // com.github.steveice10.packetlib.io.stream.StreamNetInput, com.github.steveice10.packetlib.io.NetInput
    public String readString() {
        int i = readShort();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = readChar();
        }
        return new String(cArr);
    }

    public DataInputStream getDataInputStream() {
        return this.dataInputStream;
    }

    public void enableEncryption(Cipher cipher) {
        this.in = new CipherInputStream(this.in, cipher);
        this.dataInputStream = new DataInputStream(this.in);
    }
}
