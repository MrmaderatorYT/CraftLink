package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import io.netty.b.i;
import io.netty.channel.l;
import io.netty.handler.codec.a;
import java.util.List;

/* loaded from: classes.dex */
public class TcpPacketCodec extends a<Packet> {
    private Session session;

    public TcpPacketCodec(Session session) {
        this.session = session;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.a
    public void encode(l lVar, Packet packet, i iVar) {
        ByteBufNetOutput byteBufNetOutput = new ByteBufNetOutput(iVar);
        this.session.getPacketProtocol().getPacketHeader().writePacketId(byteBufNetOutput, this.session.getPacketProtocol().getOutgoingId(packet.getClass()));
        packet.write(byteBufNetOutput);
    }

    @Override // io.netty.handler.codec.a
    protected void decode(l lVar, i iVar, List<Object> list) throws NoSuchMethodException, SecurityException {
        int iB = iVar.b();
        ByteBufNetInput byteBufNetInput = new ByteBufNetInput(iVar);
        int packetId = this.session.getPacketProtocol().getPacketHeader().readPacketId(byteBufNetInput);
        if (packetId == -1) {
            iVar.b(iB);
            return;
        }
        Packet packetCreateIncomingPacket = this.session.getPacketProtocol().createIncomingPacket(packetId);
        try {
            packetCreateIncomingPacket.read(byteBufNetInput);
        } catch (IllegalArgumentException e) {
            if (e.getStackTrace() == null || e.getStackTrace().length <= 0 || !e.getStackTrace()[0].getClassName().endsWith(".MagicValues")) {
                throw e;
            }
            System.out.println("Caught IllegalArgumentException " + e.getMessage());
        }
        if (iVar.g() > 0) {
            try {
                throw new IllegalStateException("Packet \"" + packetCreateIncomingPacket.getClass() + "\" not fully read. " + iVar.g());
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                byteBufNetInput.skipReadableBytes();
            }
        }
        if (packetCreateIncomingPacket.isPriority()) {
            this.session.callEvent(new PacketReceivedEvent(this.session, packetCreateIncomingPacket));
        }
        list.add(packetCreateIncomingPacket);
    }
}
