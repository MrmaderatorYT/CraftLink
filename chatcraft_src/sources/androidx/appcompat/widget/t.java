package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class t extends SeekBar {

    /* renamed from: a, reason: collision with root package name */
    private final u f429a;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.seekBarStyle);
    }

    public t(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i);
        this.f429a = new u(this);
        this.f429a.a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f429a.a(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f429a.c();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f429a.b();
    }
}
