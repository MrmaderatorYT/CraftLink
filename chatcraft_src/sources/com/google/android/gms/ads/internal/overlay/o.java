package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.qj;
import javax.annotation.Nullable;

@qj
/* loaded from: classes.dex */
public final class o extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final ImageButton f1637a;

    /* renamed from: b, reason: collision with root package name */
    private final w f1638b;

    public o(Context context, p pVar, @Nullable w wVar) {
        super(context);
        this.f1638b = wVar;
        setOnClickListener(this);
        this.f1637a = new ImageButton(context);
        this.f1637a.setImageResource(R.drawable.btn_dialog);
        this.f1637a.setBackgroundColor(0);
        this.f1637a.setOnClickListener(this);
        ImageButton imageButton = this.f1637a;
        bra.a();
        int iA = aac.a(context, pVar.f1639a);
        bra.a();
        int iA2 = aac.a(context, 0);
        bra.a();
        int iA3 = aac.a(context, pVar.f1640b);
        bra.a();
        imageButton.setPadding(iA, iA2, iA3, aac.a(context, pVar.d));
        this.f1637a.setContentDescription("Interstitial close button");
        bra.a();
        aac.a(context, pVar.e);
        ImageButton imageButton2 = this.f1637a;
        bra.a();
        int iA4 = aac.a(context, pVar.e + pVar.f1639a + pVar.f1640b);
        bra.a();
        addView(imageButton2, new FrameLayout.LayoutParams(iA4, aac.a(context, pVar.e + pVar.d), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f1638b != null) {
            this.f1638b.c();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f1637a.setVisibility(8);
        } else {
            this.f1637a.setVisibility(0);
        }
    }
}
