package com.github.steveice10.packetlib.event.session;

import com.github.steveice10.packetlib.Session;

/* loaded from: classes.dex */
public class DisconnectedEvent implements SessionEvent {
    private Throwable cause;
    private String reason;
    private Session session;

    public DisconnectedEvent(Session session, String str) {
        this(session, str, null);
    }

    public DisconnectedEvent(Session session, String str, Throwable th) {
        this.session = session;
        this.reason = str;
        this.cause = th;
    }

    public Session getSession() {
        return this.session;
    }

    public String getReason() {
        return this.reason;
    }

    public Throwable getCause() {
        return this.cause;
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionEvent
    public void call(SessionListener sessionListener) {
        sessionListener.disconnected(this);
    }
}
