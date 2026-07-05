package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.CryptUtil;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class PacketKeyRequest extends Packet {
    public PublicKey pubKey;
    public String serverId;
    public byte[] verifyToken;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 253;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketKeyRequest() {
    }

    public PacketKeyRequest(String str, PublicKey publicKey, byte[] bArr) {
        this.serverId = str;
        this.pubKey = publicKey;
        this.verifyToken = bArr;
    }

    private static byte[] encryptBytes(PublicKey publicKey, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public String getServerId() {
        return this.serverId;
    }

    public PublicKey getPublicKey() {
        return this.pubKey;
    }

    public byte[] getVerifyToken() {
        return this.verifyToken;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.serverId = IOUtils.readString(dataInputStream);
        byte[] bArr = new byte[dataInputStream.readShort()];
        dataInputStream.readFully(bArr);
        this.pubKey = CryptUtil.decodePublicKey(bArr);
        byte[] bArr2 = new byte[dataInputStream.readShort()];
        dataInputStream.readFully(bArr2);
        this.verifyToken = bArr2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.serverId);
        byte[] encoded = this.pubKey.getEncoded();
        dataOutputStream.writeShort(encoded.length);
        dataOutputStream.write(encoded);
        dataOutputStream.writeShort(this.verifyToken.length);
        dataOutputStream.write(this.verifyToken);
    }
}
