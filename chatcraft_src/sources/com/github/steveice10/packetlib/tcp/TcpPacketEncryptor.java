package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Session;
import io.netty.b.i;
import io.netty.channel.l;
import io.netty.handler.codec.a;
import java.util.List;

/* loaded from: classes.dex */
public class TcpPacketEncryptor extends a<i> {
    private byte[] decryptedArray = new byte[0];
    private byte[] encryptedArray = new byte[0];
    private Session session;

    public TcpPacketEncryptor(Session session) {
        this.session = session;
    }

    @Override // io.netty.handler.codec.a
    public void encode(l lVar, i iVar, i iVar2) {
        if (this.session.getPacketProtocol().getEncryption() != null) {
            int iG = iVar.g();
            byte[] bytes = getBytes(iVar);
            int encryptOutputSize = this.session.getPacketProtocol().getEncryption().getEncryptOutputSize(iG);
            if (this.encryptedArray.length < encryptOutputSize) {
                this.encryptedArray = new byte[encryptOutputSize];
            }
            iVar2.b(this.encryptedArray, 0, this.session.getPacketProtocol().getEncryption().encrypt(bytes, 0, iG, this.encryptedArray, 0));
            return;
        }
        iVar2.a(iVar);
    }

    @Override // io.netty.handler.codec.a
    protected void decode(l lVar, i iVar, List<Object> list) {
        if (this.session.getPacketProtocol().getEncryption() != null) {
            int iG = iVar.g();
            byte[] bytes = getBytes(iVar);
            i iVarC = lVar.c().c(this.session.getPacketProtocol().getEncryption().getDecryptOutputSize(iG));
            iVarC.c(this.session.getPacketProtocol().getEncryption().decrypt(bytes, 0, iG, iVarC.J(), iVarC.K()));
            list.add(iVarC);
            return;
        }
        list.add(iVar.u(iVar.g()));
    }

    private byte[] getBytes(i iVar) {
        int iG = iVar.g();
        if (this.decryptedArray.length < iG) {
            this.decryptedArray = new byte[iG];
        }
        iVar.a(this.decryptedArray, 0, iG);
        return this.decryptedArray;
    }
}
