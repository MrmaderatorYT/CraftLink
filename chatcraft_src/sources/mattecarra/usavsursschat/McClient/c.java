package mattecarra.usavsursschat.McClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.common.Mod;
import com.github.steveice10.mc.v1_8.protocol.MinecraftProtocol;
import com.github.steveice10.mc.v1_8.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_8.protocol.data.message.Message;
import com.github.steveice10.mc.v1_8.protocol.data.status.PlayerInfo;
import com.github.steveice10.mc.v1_8.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.v1_8.protocol.data.status.VersionInfo;
import com.github.steveice10.mc.v1_8.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.mc.v1_8.protocol.data.status.handler.ServerPingTimeHandler;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import mattecarra.usavsursschat.i.e;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.xbill.DNS.am;
import org.xbill.DNS.bt;
import org.xbill.DNS.cd;

/* compiled from: StatusBot.java */
/* loaded from: classes.dex */
public class c {
    private static Object[] a(String str) {
        try {
            bt[] btVarArrD = new am("_minecraft._tcp." + str, 33).d();
            if (btVarArrD == null) {
                return null;
            }
            for (bt btVar : btVarArrD) {
                if (btVar instanceof cd) {
                    return new Object[]{((cd) btVar).e().toString().replaceFirst("\\.$", BuildConfig.FLAVOR), Integer.valueOf(((cd) btVar).d())};
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public b a(String str, int i, int i2) {
        final Object obj = new Object();
        final b bVar = new b();
        final boolean[] zArr = {false, false};
        if (i2 < 47) {
            Client client = new Client(str, i, new MinecraftProtocol(SubProtocol.STATUS), new TcpSessionFactory());
            client.getSession().setFlag("server-info-handler", new ServerInfoHandler() { // from class: mattecarra.usavsursschat.McClient.c.1
                @Override // com.github.steveice10.mc.v1_8.protocol.data.status.handler.ServerInfoHandler
                public void handle(Session session, ServerStatusInfo serverStatusInfo) {
                    bVar.f4857b = serverStatusInfo.getPlayerInfo().getMaxPlayers();
                    bVar.c = serverStatusInfo.getPlayerInfo().getOnlinePlayers();
                    bVar.e = e.a(serverStatusInfo.getDescription());
                    bVar.d = serverStatusInfo.getIcon();
                    bVar.f = serverStatusInfo.getVersionInfo().getProtocolVersion();
                    bVar.g = serverStatusInfo.getVersionInfo().getVersionName();
                    zArr[0] = true;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            client.getSession().setFlag("server-ping-time-handler", new ServerPingTimeHandler() { // from class: mattecarra.usavsursschat.McClient.c.2
                @Override // com.github.steveice10.mc.v1_8.protocol.data.status.handler.ServerPingTimeHandler
                public void handle(Session session, long j) {
                    bVar.f4856a = j;
                    zArr[1] = true;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            client.getSession().connect();
        } else {
            Client client2 = new Client(str, i, new com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol(com.github.steveice10.mc.v1_10.protocol.data.SubProtocol.STATUS), new TcpSessionFactory());
            client2.getSession().setFlag("server-info-handler", new com.github.steveice10.mc.v1_10.protocol.data.status.handler.ServerInfoHandler() { // from class: mattecarra.usavsursschat.McClient.c.3
                @Override // com.github.steveice10.mc.v1_10.protocol.data.status.handler.ServerInfoHandler
                public void handle(Session session, com.github.steveice10.mc.v1_10.protocol.data.status.ServerStatusInfo serverStatusInfo) {
                    bVar.f4857b = serverStatusInfo.getPlayerInfo().getMaxPlayers();
                    bVar.c = serverStatusInfo.getPlayerInfo().getOnlinePlayers();
                    bVar.e = e.a(serverStatusInfo.getDescription());
                    bVar.d = serverStatusInfo.getIcon();
                    bVar.f = serverStatusInfo.getVersionInfo().getProtocolVersion();
                    bVar.g = serverStatusInfo.getVersionInfo().getVersionName();
                    zArr[0] = true;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            client2.getSession().setFlag("server-ping-time-handler", new com.github.steveice10.mc.v1_10.protocol.data.status.handler.ServerPingTimeHandler() { // from class: mattecarra.usavsursschat.McClient.c.4
                @Override // com.github.steveice10.mc.v1_10.protocol.data.status.handler.ServerPingTimeHandler
                public void handle(Session session, long j) {
                    bVar.f4856a = j;
                    zArr[1] = true;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            client2.getSession().connect();
        }
        synchronized (obj) {
            int i3 = 0;
            while (true) {
                if (!zArr[0] || !zArr[1]) {
                    obj.wait(100L);
                    if ((zArr[0] && zArr[1]) || i3 > 20) {
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
        }
        if (!zArr[0]) {
            return null;
        }
        if (!zArr[1]) {
            bVar.f4856a = -1L;
        }
        return bVar;
    }

    public int a(DataInputStream dataInputStream) throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte b2 = dataInputStream.readByte();
            int i3 = i2 + 1;
            i |= (b2 & 127) << (i2 * 7);
            if (i3 > 5) {
                throw new RuntimeException("VarInt too big");
            }
            if ((b2 & 128) != 128) {
                return i;
            }
            i2 = i3;
        }
    }

    public void a(DataOutputStream dataOutputStream, int i) throws IOException {
        while ((i & (-128)) != 0) {
            dataOutputStream.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        dataOutputStream.writeByte(i);
    }

    private void a(String str, DataOutput dataOutput) throws IOException {
        if (str.length() > 32767) {
            throw new IOException("String too big");
        }
        dataOutput.writeShort(str.length());
        dataOutput.writeChars(str);
    }

    public String a(DataInput dataInput, int i) throws IOException {
        short s = dataInput.readShort();
        if (s > i) {
            throw new IOException("Received string length longer than maximum allowed (" + ((int) s) + " > " + i + ")");
        }
        if (s < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < s; i2++) {
            sb.append(dataInput.readChar());
        }
        return sb.toString();
    }

    public int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private mattecarra.usavsursschat.McClient.b c(java.lang.String r12, int r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mattecarra.usavsursschat.McClient.c.c(java.lang.String, int, int):mattecarra.usavsursschat.McClient.b");
    }

    private ServerStatusInfo b(String str) {
        n nVar = (n) new f().a(str, n.class);
        n nVarL = nVar.b("version").l();
        VersionInfo versionInfo = new VersionInfo(nVarL.b("name").c(), nVarL.b("protocol").f());
        n nVarL2 = nVar.b("players").l();
        GameProfile[] gameProfileArr = new GameProfile[0];
        if (nVarL2.a("sample")) {
            i iVarM = nVarL2.b("sample").m();
            if (iVarM.a() > 0) {
                gameProfileArr = new GameProfile[iVarM.a()];
                for (int i = 0; i < iVarM.a(); i++) {
                    n nVarL3 = iVarM.a(i).l();
                    gameProfileArr[i] = new GameProfile(nVarL3.b("id").c(), nVarL3.b("name").c());
                }
            }
        }
        ServerStatusInfo serverStatusInfo = new ServerStatusInfo(versionInfo, new PlayerInfo(nVarL2.b("max").f(), nVarL2.b("online").f(), gameProfileArr), Message.fromJson(nVar.b("description")), nVar.a("favicon") ? c(nVar.b("favicon").c()) : null);
        try {
            if (nVar.a("modinfo") && nVar.d("modinfo").a("modList")) {
                Iterator<l> it = nVar.c("modList").iterator();
                while (it.hasNext()) {
                    n nVar2 = (n) it.next();
                    if (nVar2.a("modid")) {
                        if (nVar2.a("version")) {
                            serverStatusInfo.addForgeMods(new Mod(nVar2.b("modid").c(), nVar2.b("version").c()));
                        } else {
                            serverStatusInfo.addForgeMods(new Mod(nVar2.b("modid").c(), nVar2.b("version").c()));
                        }
                        System.out.println("Added mod " + nVar2.b("modid").c());
                    }
                }
            }
        } catch (Exception unused) {
        }
        return serverStatusInfo;
    }

    public b b(String str, int i, int i2) throws InterruptedException, IOException {
        String str2;
        int iIntValue;
        try {
            if (i2 < 0) {
                return c(str, i, i2);
            }
            if (i2 > 47) {
                return a(str, i, i2);
            }
            Object[] objArrA = a(str);
            if (objArrA != null) {
                str2 = (String) objArrA[0];
                iIntValue = ((Integer) objArrA[1]).intValue();
            } else {
                str2 = str;
                iIntValue = i;
            }
            Socket socket = new Socket();
            socket.setSoTimeout(3000);
            socket.setTcpNoDelay(true);
            socket.setTrafficClass(18);
            long jCurrentTimeMillis = System.currentTimeMillis();
            socket.connect(new InetSocketAddress(str2, iIntValue), 10000);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream2.writeByte(0);
            a(dataOutputStream2, i2);
            a(dataOutputStream2, socket.getInetAddress().getHostName().length());
            dataOutputStream2.writeBytes(socket.getInetAddress().getHostName());
            dataOutputStream2.writeShort(i);
            a(dataOutputStream2, 1);
            a(dataOutputStream, byteArrayOutputStream.size());
            dataOutputStream.write(byteArrayOutputStream.toByteArray());
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(0);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            a(dataInputStream);
            int iA = a(dataInputStream);
            if (iA == -1) {
                throw new IOException("Premature end of stream.");
            }
            if (iA != 0) {
                throw new IOException("Invalid packetID");
            }
            int iA2 = a(dataInputStream);
            if (iA2 == -1) {
                throw new IOException("Premature end of stream.");
            }
            if (iA2 == 0) {
                throw new IOException("Invalid string length.");
            }
            byte[] bArr = new byte[iA2];
            dataInputStream.readFully(bArr);
            String str3 = new String(bArr, mattecarra.usavsursschat.i.a.f5015a);
            dataOutputStream.writeByte(9);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeLong(System.currentTimeMillis());
            a(dataInputStream);
            int iA3 = a(dataInputStream);
            if (iA3 == -1) {
                throw new IOException("Premature end of stream.");
            }
            if (iA3 != 1) {
                throw new IOException("Invalid packetID");
            }
            dataInputStream.readLong();
            ServerStatusInfo serverStatusInfoB = b(str3);
            dataOutputStream.close();
            outputStream.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            b bVar = new b();
            bVar.f4857b = serverStatusInfoB.getPlayerInfo().getMaxPlayers();
            bVar.c = serverStatusInfoB.getPlayerInfo().getOnlinePlayers();
            bVar.d = serverStatusInfoB.getIcon();
            bVar.f4856a = jCurrentTimeMillis2;
            bVar.g = serverStatusInfoB.getVersionInfo().getVersionName();
            bVar.e = e.a(serverStatusInfoB.getDescription());
            bVar.f = serverStatusInfoB.getVersionInfo().getProtocolVersion();
            return bVar;
        } catch (InterruptedException e) {
            throw e;
        } catch (UnknownHostException unused) {
            return a(str, i, i2);
        } catch (Exception e2) {
            System.out.println("Problem fetching server status from " + str + " " + e2.getMessage());
            e2.printStackTrace();
            return a(str, i, i2);
        }
    }

    public int b(String str, int i) {
        try {
            return b(str, i, e.a()).f();
        } catch (Exception unused) {
            try {
                try {
                    return c(str, i, 78).f();
                } catch (Exception unused2) {
                    return a(str, i, e.a()).f();
                }
            } catch (Exception unused3) {
                return 0;
            }
        }
    }

    private Bitmap c(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.startsWith("data:image/png;base64,")) {
                str = str.substring("data:image/png;base64,".length());
            }
            try {
                byte[] bArrDecode = Base64.decode(str, 0);
                return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
