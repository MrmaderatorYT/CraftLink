package com.afollestad.materialdialogs;

import android.R;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.util.ArrayList;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;

/* compiled from: DialogInit.java */
/* loaded from: classes.dex */
class d {
    static int a(f.a aVar) {
        boolean zA = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_dark_theme, aVar.K == i.DARK);
        aVar.K = zA ? i.DARK : i.LIGHT;
        return zA ? g.C0062g.MD_Dark : g.C0062g.MD_Light;
    }

    static int b(f.a aVar) {
        if (aVar.s != null) {
            return g.f.md_dialog_custom;
        }
        if (aVar.l != null || aVar.X != null) {
            if (aVar.aw != null) {
                return g.f.md_dialog_list_check;
            }
            return g.f.md_dialog_list;
        }
        if (aVar.ak > -2) {
            return g.f.md_dialog_progress;
        }
        if (aVar.ai) {
            if (aVar.aB) {
                return g.f.md_dialog_progress_indeterminate_horizontal;
            }
            return g.f.md_dialog_progress_indeterminate;
        }
        if (aVar.ao != null) {
            if (aVar.aw != null) {
                return g.f.md_dialog_input_check;
            }
            return g.f.md_dialog_input;
        }
        if (aVar.aw != null) {
            return g.f.md_dialog_basic_check;
        }
        return g.f.md_dialog_basic;
    }

    static void a(f fVar) {
        boolean zA;
        f.a aVar = fVar.f1209b;
        fVar.setCancelable(aVar.L);
        fVar.setCanceledOnTouchOutside(aVar.M);
        if (aVar.ag == 0) {
            aVar.ag = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_background_color, com.afollestad.materialdialogs.a.a.a(fVar.getContext(), g.a.colorBackgroundFloating));
        }
        if (aVar.ag != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(aVar.f1216a.getResources().getDimension(g.c.md_bg_corner_radius));
            gradientDrawable.setColor(aVar.ag);
            fVar.getWindow().setBackgroundDrawable(gradientDrawable);
        }
        if (!aVar.aF) {
            aVar.v = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_positive_color, aVar.v);
        }
        if (!aVar.aG) {
            aVar.x = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_neutral_color, aVar.x);
        }
        if (!aVar.aH) {
            aVar.w = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_negative_color, aVar.w);
        }
        if (!aVar.aI) {
            aVar.t = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_widget_color, aVar.t);
        }
        if (!aVar.aC) {
            aVar.i = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_title_color, com.afollestad.materialdialogs.a.a.a(fVar.getContext(), R.attr.textColorPrimary));
        }
        if (!aVar.aD) {
            aVar.j = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_content_color, com.afollestad.materialdialogs.a.a.a(fVar.getContext(), R.attr.textColorSecondary));
        }
        if (!aVar.aE) {
            aVar.ah = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_item_color, aVar.j);
        }
        fVar.d = (TextView) fVar.f1204a.findViewById(g.e.md_title);
        fVar.c = (ImageView) fVar.f1204a.findViewById(g.e.md_icon);
        fVar.h = fVar.f1204a.findViewById(g.e.md_titleFrame);
        fVar.e = (TextView) fVar.f1204a.findViewById(g.e.md_content);
        fVar.g = (RecyclerView) fVar.f1204a.findViewById(g.e.md_contentRecyclerView);
        fVar.n = (CheckBox) fVar.f1204a.findViewById(g.e.md_promptCheckbox);
        fVar.o = (MDButton) fVar.f1204a.findViewById(g.e.md_buttonDefaultPositive);
        fVar.p = (MDButton) fVar.f1204a.findViewById(g.e.md_buttonDefaultNeutral);
        fVar.q = (MDButton) fVar.f1204a.findViewById(g.e.md_buttonDefaultNegative);
        if (aVar.ao != null && aVar.m == null) {
            aVar.m = aVar.f1216a.getText(R.string.ok);
        }
        fVar.o.setVisibility(aVar.m != null ? 0 : 8);
        fVar.p.setVisibility(aVar.n != null ? 0 : 8);
        fVar.q.setVisibility(aVar.o != null ? 0 : 8);
        fVar.o.setFocusable(true);
        fVar.p.setFocusable(true);
        fVar.q.setFocusable(true);
        if (aVar.p) {
            fVar.o.requestFocus();
        }
        if (aVar.q) {
            fVar.p.requestFocus();
        }
        if (aVar.r) {
            fVar.q.requestFocus();
        }
        if (aVar.U != null) {
            fVar.c.setVisibility(0);
            fVar.c.setImageDrawable(aVar.U);
        } else {
            Drawable drawableE = com.afollestad.materialdialogs.a.a.e(aVar.f1216a, g.a.md_icon);
            if (drawableE != null) {
                fVar.c.setVisibility(0);
                fVar.c.setImageDrawable(drawableE);
            } else {
                fVar.c.setVisibility(8);
            }
        }
        int dimensionPixelSize = aVar.W;
        if (dimensionPixelSize == -1) {
            dimensionPixelSize = com.afollestad.materialdialogs.a.a.f(aVar.f1216a, g.a.md_icon_max_size);
        }
        if (aVar.V || com.afollestad.materialdialogs.a.a.g(aVar.f1216a, g.a.md_icon_limit_icon_to_default_size)) {
            dimensionPixelSize = aVar.f1216a.getResources().getDimensionPixelSize(g.c.md_icon_max_size);
        }
        if (dimensionPixelSize > -1) {
            fVar.c.setAdjustViewBounds(true);
            fVar.c.setMaxHeight(dimensionPixelSize);
            fVar.c.setMaxWidth(dimensionPixelSize);
            fVar.c.requestLayout();
        }
        if (!aVar.aJ) {
            aVar.af = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.md_divider_color, com.afollestad.materialdialogs.a.a.a(fVar.getContext(), g.a.md_divider));
        }
        fVar.f1204a.setDividerColor(aVar.af);
        if (fVar.d != null) {
            fVar.a(fVar.d, aVar.T);
            fVar.d.setTextColor(aVar.i);
            fVar.d.setGravity(aVar.c.a());
            if (Build.VERSION.SDK_INT >= 17) {
                fVar.d.setTextAlignment(aVar.c.b());
            }
            if (aVar.f1217b == null) {
                fVar.h.setVisibility(8);
            } else {
                fVar.d.setText(aVar.f1217b);
                fVar.h.setVisibility(0);
            }
        }
        if (fVar.e != null) {
            fVar.e.setMovementMethod(new LinkMovementMethod());
            fVar.a(fVar.e, aVar.S);
            fVar.e.setLineSpacing(0.0f, aVar.N);
            if (aVar.y == null) {
                fVar.e.setLinkTextColor(com.afollestad.materialdialogs.a.a.a(fVar.getContext(), R.attr.textColorPrimary));
            } else {
                fVar.e.setLinkTextColor(aVar.y);
            }
            fVar.e.setTextColor(aVar.j);
            fVar.e.setGravity(aVar.d.a());
            if (Build.VERSION.SDK_INT >= 17) {
                fVar.e.setTextAlignment(aVar.d.b());
            }
            if (aVar.k != null) {
                fVar.e.setText(aVar.k);
                fVar.e.setVisibility(0);
            } else {
                fVar.e.setVisibility(8);
            }
        }
        if (fVar.n != null) {
            fVar.n.setText(aVar.aw);
            fVar.n.setChecked(aVar.ax);
            fVar.n.setOnCheckedChangeListener(aVar.ay);
            fVar.a(fVar.n, aVar.S);
            fVar.n.setTextColor(aVar.j);
            com.afollestad.materialdialogs.internal.c.a(fVar.n, aVar.t);
        }
        fVar.f1204a.setButtonGravity(aVar.g);
        fVar.f1204a.setButtonStackedGravity(aVar.e);
        fVar.f1204a.setStackingBehavior(aVar.ad);
        if (Build.VERSION.SDK_INT < 14 || (zA = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, R.attr.textAllCaps, true))) {
            zA = com.afollestad.materialdialogs.a.a.a(aVar.f1216a, g.a.textAllCaps, true);
        }
        MDButton mDButton = fVar.o;
        fVar.a(mDButton, aVar.T);
        mDButton.setAllCapsCompat(zA);
        mDButton.setText(aVar.m);
        mDButton.setTextColor(aVar.v);
        fVar.o.setStackedSelector(fVar.a(b.POSITIVE, true));
        fVar.o.setDefaultSelector(fVar.a(b.POSITIVE, false));
        fVar.o.setTag(b.POSITIVE);
        fVar.o.setOnClickListener(fVar);
        MDButton mDButton2 = fVar.q;
        fVar.a(mDButton2, aVar.T);
        mDButton2.setAllCapsCompat(zA);
        mDButton2.setText(aVar.o);
        mDButton2.setTextColor(aVar.w);
        fVar.q.setStackedSelector(fVar.a(b.NEGATIVE, true));
        fVar.q.setDefaultSelector(fVar.a(b.NEGATIVE, false));
        fVar.q.setTag(b.NEGATIVE);
        fVar.q.setOnClickListener(fVar);
        MDButton mDButton3 = fVar.p;
        fVar.a(mDButton3, aVar.T);
        mDButton3.setAllCapsCompat(zA);
        mDButton3.setText(aVar.n);
        mDButton3.setTextColor(aVar.x);
        fVar.p.setStackedSelector(fVar.a(b.NEUTRAL, true));
        fVar.p.setDefaultSelector(fVar.a(b.NEUTRAL, false));
        fVar.p.setTag(b.NEUTRAL);
        fVar.p.setOnClickListener(fVar);
        if (aVar.H != null) {
            fVar.s = new ArrayList();
        }
        if (fVar.g != null) {
            if (aVar.X == null) {
                if (aVar.G != null) {
                    fVar.r = f.i.SINGLE;
                } else if (aVar.H != null) {
                    fVar.r = f.i.MULTI;
                    if (aVar.P != null) {
                        fVar.s = new ArrayList(Arrays.asList(aVar.P));
                        aVar.P = null;
                    }
                } else {
                    fVar.r = f.i.REGULAR;
                }
                aVar.X = new a(fVar, f.i.a(fVar.r));
            } else if (aVar.X instanceof com.afollestad.materialdialogs.internal.b) {
                ((com.afollestad.materialdialogs.internal.b) aVar.X).a(fVar);
            }
        }
        b(fVar);
        c(fVar);
        if (aVar.s != null) {
            ((MDRootLayout) fVar.f1204a.findViewById(g.e.md_root)).a();
            FrameLayout frameLayout = (FrameLayout) fVar.f1204a.findViewById(g.e.md_customViewFrame);
            fVar.i = frameLayout;
            View view = aVar.s;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (aVar.ae) {
                Resources resources = fVar.getContext().getResources();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(g.c.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(fVar.getContext());
                int dimensionPixelSize3 = resources.getDimensionPixelSize(g.c.md_content_padding_top);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(g.c.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize4);
                    view.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        if (aVar.ac != null) {
            fVar.setOnShowListener(aVar.ac);
        }
        if (aVar.aa != null) {
            fVar.setOnCancelListener(aVar.aa);
        }
        if (aVar.Z != null) {
            fVar.setOnDismissListener(aVar.Z);
        }
        if (aVar.ab != null) {
            fVar.setOnKeyListener(aVar.ab);
        }
        fVar.a();
        fVar.d();
        fVar.a(fVar.f1204a);
        fVar.c();
        Display defaultDisplay = fVar.getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        int dimensionPixelSize5 = aVar.f1216a.getResources().getDimensionPixelSize(g.c.md_dialog_vertical_margin);
        int dimensionPixelSize6 = aVar.f1216a.getResources().getDimensionPixelSize(g.c.md_dialog_horizontal_margin);
        fVar.f1204a.setMaxHeight(i2 - (dimensionPixelSize5 * 2));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(fVar.getWindow().getAttributes());
        layoutParams.width = Math.min(aVar.f1216a.getResources().getDimensionPixelSize(g.c.md_dialog_max_width), i - (dimensionPixelSize6 * 2));
        fVar.getWindow().setAttributes(layoutParams);
    }

    private static void a(ProgressBar progressBar) {
        if (Build.VERSION.SDK_INT >= 18 || !progressBar.isHardwareAccelerated() || progressBar.getLayerType() == 1) {
            return;
        }
        progressBar.setLayerType(1, null);
    }

    private static void b(f fVar) {
        f.a aVar = fVar.f1209b;
        if (aVar.ai || aVar.ak > -2) {
            fVar.j = (ProgressBar) fVar.f1204a.findViewById(R.id.progress);
            if (fVar.j == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                if (aVar.ai) {
                    if (aVar.aB) {
                        IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(aVar.a());
                        indeterminateHorizontalProgressDrawable.setTint(aVar.t);
                        fVar.j.setProgressDrawable(indeterminateHorizontalProgressDrawable);
                        fVar.j.setIndeterminateDrawable(indeterminateHorizontalProgressDrawable);
                    } else {
                        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable(aVar.a());
                        indeterminateCircularProgressDrawable.setTint(aVar.t);
                        fVar.j.setProgressDrawable(indeterminateCircularProgressDrawable);
                        fVar.j.setIndeterminateDrawable(indeterminateCircularProgressDrawable);
                    }
                } else {
                    HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(aVar.a());
                    horizontalProgressDrawable.setTint(aVar.t);
                    fVar.j.setProgressDrawable(horizontalProgressDrawable);
                    fVar.j.setIndeterminateDrawable(horizontalProgressDrawable);
                }
            } else {
                com.afollestad.materialdialogs.internal.c.a(fVar.j, aVar.t);
            }
            if (!aVar.ai || aVar.aB) {
                fVar.j.setIndeterminate(aVar.ai && aVar.aB);
                fVar.j.setProgress(0);
                fVar.j.setMax(aVar.al);
                fVar.k = (TextView) fVar.f1204a.findViewById(g.e.md_label);
                if (fVar.k != null) {
                    fVar.k.setTextColor(aVar.j);
                    fVar.a(fVar.k, aVar.T);
                    fVar.k.setText(aVar.aA.format(0L));
                }
                fVar.l = (TextView) fVar.f1204a.findViewById(g.e.md_minMax);
                if (fVar.l != null) {
                    fVar.l.setTextColor(aVar.j);
                    fVar.a(fVar.l, aVar.S);
                    if (aVar.aj) {
                        fVar.l.setVisibility(0);
                        fVar.l.setText(String.format(aVar.az, 0, Integer.valueOf(aVar.al)));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) fVar.j.getLayoutParams();
                        marginLayoutParams.leftMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    } else {
                        fVar.l.setVisibility(8);
                    }
                } else {
                    aVar.aj = false;
                }
            }
        }
        if (fVar.j != null) {
            a(fVar.j);
        }
    }

    private static void c(f fVar) {
        f.a aVar = fVar.f1209b;
        fVar.f = (EditText) fVar.f1204a.findViewById(R.id.input);
        if (fVar.f == null) {
            return;
        }
        fVar.a(fVar.f, aVar.S);
        if (aVar.am != null) {
            fVar.f.setText(aVar.am);
        }
        fVar.h();
        fVar.f.setHint(aVar.an);
        fVar.f.setSingleLine();
        fVar.f.setTextColor(aVar.j);
        fVar.f.setHintTextColor(com.afollestad.materialdialogs.a.a.a(aVar.j, 0.3f));
        com.afollestad.materialdialogs.internal.c.a(fVar.f, fVar.f1209b.t);
        if (aVar.aq != -1) {
            fVar.f.setInputType(aVar.aq);
            if (aVar.aq != 144 && (aVar.aq & 128) == 128) {
                fVar.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
        fVar.m = (TextView) fVar.f1204a.findViewById(g.e.md_minMax);
        if (aVar.as > 0 || aVar.at > -1) {
            fVar.a(fVar.f.getText().toString().length(), !aVar.ap);
        } else {
            fVar.m.setVisibility(8);
            fVar.m = null;
        }
    }
}
