package com.heinrichreimersoftware.singleinputform.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* loaded from: classes.dex */
public class CheckBoxCompat extends CheckBox {
    public CheckBoxCompat(Context context) {
        super(context);
    }

    public CheckBoxCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CheckBoxCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        return super.getCompoundPaddingLeft() + ((int) ((getResources().getDisplayMetrics().density * 10.0f) + 0.5f));
    }
}
