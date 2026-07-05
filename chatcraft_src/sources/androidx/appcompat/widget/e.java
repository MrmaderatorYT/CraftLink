package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.a;

/* compiled from: AppCompatAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class e extends AutoCompleteTextView implements androidx.core.g.p {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f402a = {R.attr.popupBackground};

    /* renamed from: b, reason: collision with root package name */
    private final f f403b;
    private final w c;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.autoCompleteTextViewStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        as asVarA = as.a(getContext(), attributeSet, f402a, i, 0);
        if (asVarA.g(0)) {
            setDropDownBackgroundDrawable(asVarA.a(0));
        }
        asVarA.a();
        this.f403b = new f(this);
        this.f403b.a(attributeSet, i);
        this.c = new w(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f403b != null) {
            this.f403b.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f403b != null) {
            this.f403b.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f403b != null) {
            this.f403b.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f403b != null) {
            return this.f403b.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f403b != null) {
            this.f403b.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f403b != null) {
            return this.f403b.b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f403b != null) {
            this.f403b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }
}
