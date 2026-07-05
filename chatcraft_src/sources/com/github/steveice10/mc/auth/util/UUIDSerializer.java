package com.github.steveice10.mc.auth.util;

import com.google.gson.stream.a;
import com.google.gson.stream.c;
import com.google.gson.t;
import java.io.IOException;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class UUIDSerializer extends t<UUID> {
    public static String fromUUID(UUID uuid) {
        return uuid == null ? BuildConfig.FLAVOR : uuid.toString().replace("-", BuildConfig.FLAVOR);
    }

    public static UUID fromString(String str) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            return null;
        }
        return UUID.fromString(str.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }

    @Override // com.google.gson.t
    public void write(c cVar, UUID uuid) throws IOException {
        cVar.b(fromUUID(uuid));
    }

    @Override // com.google.gson.t
    public UUID read(a aVar) {
        return fromString(aVar.h());
    }
}
