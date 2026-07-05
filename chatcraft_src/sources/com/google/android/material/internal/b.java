package com.google.android.material.internal;

import android.graphics.Outline;

/* compiled from: CircularBorderDrawableLollipop.java */
/* loaded from: classes.dex */
public class b extends a {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f3821b);
        outline.setOval(this.f3821b);
    }
}
