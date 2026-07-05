package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class aet implements com.google.android.gms.ads.internal.gmsg.ac<adk> {
    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(adk adkVar, Map map) throws NumberFormatException {
        adk adkVar2 = adkVar;
        agj agjVarB = adkVar2.b();
        if (agjVarB == null) {
            try {
                agj agjVar = new agj(adkVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                adkVar2.a(agjVar);
                agjVarB = agjVar;
            } catch (NullPointerException | NumberFormatException e) {
                xe.b("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.ax.i().a(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f2 = Float.parseFloat((String) map.get("currentTime"));
        int i = Integer.parseInt((String) map.get("playbackState"));
        if (i < 0 || 3 < i) {
            i = 0;
        }
        String str = (String) map.get("aspectRatio");
        float f3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (xe.a(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(f2);
            sb.append(" , duration : ");
            sb.append(f);
            sb.append(" , isMuted : ");
            sb.append(zEquals);
            sb.append(" , playbackState : ");
            sb.append(i);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            xe.b(sb.toString());
        }
        agjVarB.a(f2, f, i, zEquals, f3);
    }
}
