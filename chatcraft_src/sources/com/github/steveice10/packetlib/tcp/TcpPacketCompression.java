package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import io.netty.b.af;
import io.netty.b.i;
import io.netty.channel.l;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.a;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class TcpPacketCompression extends a<i> {
    private static final int MAX_COMPRESSED_SIZE = 2097152;
    private Session session;
    private Deflater deflater = new Deflater();
    private Inflater inflater = new Inflater();
    private byte[] buf = new byte[8192];

    public TcpPacketCompression(Session session) {
        this.session = session;
    }

    @Override // io.netty.handler.codec.a
    public void encode(l lVar, i iVar, i iVar2) {
        int iG = iVar.g();
        ByteBufNetOutput byteBufNetOutput = new ByteBufNetOutput(iVar2);
        if (iG < this.session.getCompressionThreshold()) {
            byteBufNetOutput.writeVarInt(0);
            iVar2.a(iVar);
            return;
        }
        byte[] bArr = new byte[iG];
        iVar.a(bArr);
        byteBufNetOutput.writeVarInt(bArr.length);
        this.deflater.setInput(bArr, 0, iG);
        this.deflater.finish();
        while (!this.deflater.finished()) {
            byteBufNetOutput.writeBytes(this.buf, this.deflater.deflate(this.buf));
        }
        this.deflater.reset();
    }

    @Override // io.netty.handler.codec.a
    protected void decode(l lVar, i iVar, List<Object> list) throws DataFormatException, IOException {
        if (iVar.g() != 0) {
            ByteBufNetInput byteBufNetInput = new ByteBufNetInput(iVar);
            int varInt = byteBufNetInput.readVarInt();
            if (varInt == 0) {
                list.add(iVar.u(iVar.g()));
                return;
            }
            if (varInt < this.session.getCompressionThreshold()) {
                throw new DecoderException("Badly compressed packet: size of " + varInt + " is below threshold of " + this.session.getCompressionThreshold() + ".");
            }
            if (varInt > MAX_COMPRESSED_SIZE) {
                throw new DecoderException("Badly compressed packet: size of " + varInt + " is larger than protocol maximum of " + MAX_COMPRESSED_SIZE + ".");
            }
            byte[] bArr = new byte[iVar.g()];
            byteBufNetInput.readBytes(bArr);
            this.inflater.setInput(bArr);
            byte[] bArr2 = new byte[varInt];
            this.inflater.inflate(bArr2);
            list.add(af.a(bArr2));
            this.inflater.reset();
        }
    }
}
