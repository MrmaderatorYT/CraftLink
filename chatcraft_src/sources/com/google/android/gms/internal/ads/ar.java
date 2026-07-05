package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ar extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f2197a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};

    /* renamed from: b, reason: collision with root package name */
    private AnimationDrawable f2198b;

    public ar(Context context, ao aoVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        com.google.android.gms.common.internal.i.a(aoVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f2197a, null, null));
        shapeDrawable.getPaint().setColor(aoVar.d());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.ax.g().a(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(aoVar.a())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(aoVar.a());
            textView.setTextColor(aoVar.e());
            textView.setTextSize(aoVar.f());
            bra.a();
            int iA = aac.a(context, 4);
            bra.a();
            textView.setPadding(iA, 0, aac.a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<at> listC = aoVar.c();
        if (listC != null && listC.size() > 1) {
            this.f2198b = new AnimationDrawable();
            Iterator<at> it = listC.iterator();
            while (it.hasNext()) {
                try {
                    this.f2198b.addFrame((Drawable) com.google.android.gms.dynamic.b.a(it.next().a()), aoVar.g());
                } catch (Exception e) {
                    xe.b("Error while getting drawable.", e);
                }
            }
            com.google.android.gms.ads.internal.ax.g().a(imageView, this.f2198b);
        } else if (listC.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) com.google.android.gms.dynamic.b.a(listC.get(0).a()));
            } catch (Exception e2) {
                xe.b("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        if (this.f2198b != null) {
            this.f2198b.start();
        }
        super.onAttachedToWindow();
    }
}
