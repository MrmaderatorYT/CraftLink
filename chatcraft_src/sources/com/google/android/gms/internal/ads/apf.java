package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.apf;
import com.google.android.gms.internal.ads.apg;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class apf<MessageType extends apf<MessageType, BuilderType>, BuilderType extends apg<MessageType, BuilderType>> implements asf {
    private static boolean zzfky = false;
    protected int zzfkx = 0;

    @Override // com.google.android.gms.internal.ads.asf
    public final apo h() {
        try {
            apw apwVarB = apo.b(l());
            a(apwVarB.b());
            return apwVarB.a();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.asf
    public final byte[] i() {
        try {
            byte[] bArr = new byte[l()];
            zzbqk zzbqkVarA = zzbqk.a(bArr);
            a(zzbqkVarA);
            zzbqkVarA.c();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int j() {
        throw new UnsupportedOperationException();
    }

    void a(int i) {
        throw new UnsupportedOperationException();
    }
}
