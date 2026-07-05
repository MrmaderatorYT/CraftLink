package com.github.steveice10.packetlib;

/* loaded from: classes.dex */
public interface ConnectionListener {
    void bind();

    void bind(boolean z);

    void bind(boolean z, Runnable runnable);

    void close();

    void close(boolean z);

    void close(boolean z, Runnable runnable);

    String getHost();

    int getPort();

    boolean isListening();
}
