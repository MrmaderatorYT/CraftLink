package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f384a;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f384a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f384a.d) {
            if (this.f384a.c != null) {
                this.f384a.c.draw(canvas);
            }
        } else {
            if (this.f384a.f256a != null) {
                this.f384a.f256a.draw(canvas);
            }
            if (this.f384a.f257b == null || !this.f384a.e) {
                return;
            }
            this.f384a.f257b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f384a.d) {
            if (this.f384a.c != null) {
                this.f384a.c.getOutline(outline);
            }
        } else if (this.f384a.f256a != null) {
            this.f384a.f256a.getOutline(outline);
        }
    }
}
