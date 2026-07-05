package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import io.netty.b.af;
import io.netty.b.i;
import io.netty.channel.l;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.a;
import java.util.List;

/* loaded from: classes.dex */
public class TcpPacketSizer extends a<i> {
    private Session session;

    public TcpPacketSizer(Session session) {
        this.session = session;
    }

    @Override // io.netty.handler.codec.a
    public void encode(l lVar, i iVar, i iVar2) {
        int iG = iVar.g();
        iVar2.e(this.session.getPacketProtocol().getPacketHeader().getLengthSize(iG) + iG);
        this.session.getPacketProtocol().getPacketHeader().writeLength(new ByteBufNetOutput(iVar2), iG);
        iVar2.a(iVar);
    }

    @Override // io.netty.handler.codec.a
    protected void decode(l lVar, i iVar, List<Object> list) {
        int lengthSize = this.session.getPacketProtocol().getPacketHeader().getLengthSize();
        if (lengthSize > 0) {
            iVar.j();
            byte[] bArr = new byte[lengthSize];
            for (int i = 0; i < bArr.length; i++) {
                if (!iVar.e()) {
                    iVar.k();
                    return;
                }
                bArr[i] = iVar.n();
                if ((this.session.getPacketProtocol().getPacketHeader().isLengthVariable() && bArr[i] >= 0) || i == lengthSize - 1) {
                    int length = this.session.getPacketProtocol().getPacketHeader().readLength(new ByteBufNetInput(af.a(bArr)), iVar.g());
                    if (iVar.g() < length) {
                        iVar.k();
                        return;
                    } else {
                        list.add(iVar.u(length));
                        return;
                    }
                }
            }
            throw new CorruptedFrameException("Length is too long.");
        }
        list.add(iVar.u(iVar.g()));
    }
}
