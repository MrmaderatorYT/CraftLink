package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.OldProtocol.StreamNetInput_Old;
import com.github.steveice10.mc.OldProtocol.StreamNetOutput_Old;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* loaded from: classes.dex */
public abstract class Packet implements com.github.steveice10.packetlib.packet.Packet {
    public abstract int getId();

    protected void handleClient(Client client) {
    }

    protected void handleServer(ServerConnection serverConnection) {
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    public abstract void read(DataInputStream dataInputStream);

    public abstract void write(DataOutputStream dataOutputStream);

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        write(((StreamNetOutput_Old) netOutput).getDataOutputStream());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        read(((StreamNetInput_Old) netInput).getDataInputStream());
    }
}
