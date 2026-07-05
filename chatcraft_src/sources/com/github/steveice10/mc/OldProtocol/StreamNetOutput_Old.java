package com.github.steveice10.mc.OldProtocol;

import com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

/* loaded from: classes.dex */
public class StreamNetOutput_Old extends StreamNetOutput {
    private DataOutputStream dataOutputStream;

    public StreamNetOutput_Old(OutputStream outputStream) {
        super(outputStream);
        this.dataOutputStream = new DataOutputStream(outputStream);
    }

    @Override // com.github.steveice10.packetlib.io.stream.StreamNetOutput, com.github.steveice10.packetlib.io.NetOutput
    public void writeString(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null!");
        }
        int length = str.length();
        if (length > 65536) {
            throw new IOException("String too big (was " + str.length() + " bytes encoded, max 65536)");
        }
        writeShort(length);
        for (int i = 0; i < length; i++) {
            writeChar(str.charAt(i));
        }
    }

    public DataOutputStream getDataOutputStream() {
        return this.dataOutputStream;
    }

    public void enableEncryption(Cipher cipher) {
        this.out = new CipherOutputStream(this.out, cipher);
        this.dataOutputStream = new DataOutputStream(this.out);
    }
}
