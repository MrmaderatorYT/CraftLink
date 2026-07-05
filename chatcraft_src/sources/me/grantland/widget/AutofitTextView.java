package me.grantland.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import me.grantland.widget.a;

/* loaded from: classes.dex */
public class AutofitTextView extends TextView implements a.c {

    /* renamed from: a, reason: collision with root package name */
    private a f5034a;

    @Override // me.grantland.widget.a.c
    public void a(float f, float f2) {
    }

    public AutofitTextView(Context context) {
        super(context);
        a(context, null, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f5034a = a.a(this, attributeSet, i).a((a.c) this);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.f5034a != null) {
            this.f5034a.c(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        if (this.f5034a != null) {
            this.f5034a.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.f5034a != null) {
            this.f5034a.a(i);
        }
    }

    public a getAutofitHelper() {
        return this.f5034a;
    }

    public void setSizeToFit(boolean z) {
        this.f5034a.a(z);
    }

    public float getMaxTextSize() {
        return this.f5034a.c();
    }

    public void setMaxTextSize(float f) {
        this.f5034a.b(f);
    }

    public float getMinTextSize() {
        return this.f5034a.b();
    }

    public void setMinTextSize(int i) {
        this.f5034a.a(2, i);
    }

    public float getPrecision() {
        return this.f5034a.a();
    }

    public void setPrecision(float f) {
        this.f5034a.a(f);
    }
}
