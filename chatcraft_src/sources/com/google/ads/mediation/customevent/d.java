package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class d extends MediationServerParameters {

    /* renamed from: a, reason: collision with root package name */
    @MediationServerParameters.a(a = "label", b = true)
    public String f1458a;

    /* renamed from: b, reason: collision with root package name */
    @MediationServerParameters.a(a = "class_name", b = true)
    public String f1459b;

    @MediationServerParameters.a(a = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, b = BuildConfig.DEBUG)
    public String c = null;
}
