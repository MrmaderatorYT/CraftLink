package io.netty.handler.ssl;

import javax.net.ssl.SSLException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class NotSslRecordException extends SSLException {
    public NotSslRecordException() {
        super(BuildConfig.FLAVOR);
    }
}
