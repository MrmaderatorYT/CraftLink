package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.apf;
import com.google.android.gms.internal.ads.apg;

/* loaded from: classes.dex */
public abstract class apg<MessageType extends apf<MessageType, BuilderType>, BuilderType extends apg<MessageType, BuilderType>> implements asg {
    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    protected abstract BuilderType a(MessageType messagetype);

    @Override // com.google.android.gms.internal.ads.asg
    public final /* synthetic */ asg a(asf asfVar) {
        if (!q().getClass().isInstance(asfVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return a((apg<MessageType, BuilderType>) asfVar);
    }
}
