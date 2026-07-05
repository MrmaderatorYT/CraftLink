package io.netty.a;

import io.netty.channel.al;
import io.netty.channel.av;
import io.netty.channel.j;
import io.netty.channel.r;
import io.netty.util.a.p;
import java.util.Map;

/* compiled from: ServerBootstrapConfig.java */
/* loaded from: classes.dex */
public final class g extends b<f, av> {
    g(f fVar) {
        super(fVar);
    }

    public al g() {
        return ((f) this.f4348a).p();
    }

    public j h() {
        return ((f) this.f4348a).q();
    }

    public Map<r<?>, Object> i() {
        return ((f) this.f4348a).r();
    }

    public Map<io.netty.util.c<?>, Object> j() {
        return ((f) this.f4348a).s();
    }

    @Override // io.netty.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", ");
        al alVarG = g();
        if (alVarG != null) {
            sb.append("childGroup: ");
            sb.append(p.a(alVarG));
            sb.append(", ");
        }
        Map<r<?>, Object> mapI = i();
        if (!mapI.isEmpty()) {
            sb.append("childOptions: ");
            sb.append(mapI);
            sb.append(", ");
        }
        Map<io.netty.util.c<?>, Object> mapJ = j();
        if (!mapJ.isEmpty()) {
            sb.append("childAttrs: ");
            sb.append(mapJ);
            sb.append(", ");
        }
        j jVarH = h();
        if (jVarH != null) {
            sb.append("childHandler: ");
            sb.append(jVarH);
            sb.append(", ");
        }
        if (sb.charAt(sb.length() - 1) == '(') {
            sb.append(')');
        } else {
            sb.setCharAt(sb.length() - 2, ')');
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
