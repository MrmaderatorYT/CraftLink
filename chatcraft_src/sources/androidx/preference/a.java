package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CollapsiblePreferenceGroupController.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    final h f971a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f972b;
    private boolean c = false;

    a(PreferenceGroup preferenceGroup, h hVar) {
        this.f971a = hVar;
        this.f972b = preferenceGroup.H();
    }

    public List<Preference> a(PreferenceGroup preferenceGroup) {
        return b(preferenceGroup);
    }

    private List<Preference> b(PreferenceGroup preferenceGroup) {
        this.c = false;
        boolean z = preferenceGroup.b() != Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iC = preferenceGroup.c();
        int i = 0;
        for (int i2 = 0; i2 < iC; i2++) {
            Preference preferenceH = preferenceGroup.h(i2);
            if (preferenceH.B()) {
                if (!z || i < preferenceGroup.b()) {
                    arrayList.add(preferenceH);
                } else {
                    arrayList2.add(preferenceH);
                }
                if (preferenceH instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceH;
                    if (preferenceGroup2.d()) {
                        List<Preference> listB = b(preferenceGroup2);
                        if (z && this.c) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference : listB) {
                            if (!z || i < preferenceGroup.b()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i++;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i++;
                }
            }
        }
        if (z && i > preferenceGroup.b()) {
            arrayList.add(a(preferenceGroup, arrayList2));
        }
        this.c |= z;
        return arrayList;
    }

    private C0053a a(final PreferenceGroup preferenceGroup, List<Preference> list) {
        C0053a c0053a = new C0053a(this.f972b, list, preferenceGroup.a());
        c0053a.a(new Preference.d() { // from class: androidx.preference.a.1
            @Override // androidx.preference.Preference.d
            public boolean a(Preference preference) {
                preferenceGroup.g(Integer.MAX_VALUE);
                a.this.f971a.b(preference);
                PreferenceGroup.a aVarE = preferenceGroup.e();
                if (aVarE == null) {
                    return true;
                }
                aVarE.a();
                return true;
            }
        });
        return c0053a;
    }

    /* compiled from: CollapsiblePreferenceGroupController.java */
    /* renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    static class C0053a extends Preference {

        /* renamed from: a, reason: collision with root package name */
        private long f975a;

        C0053a(Context context, List<Preference> list, long j) {
            super(context);
            b();
            a(list);
            this.f975a = j + 1000000;
        }

        private void b() {
            a(m.d.expand_button);
            d(m.b.ic_arrow_down_24dp);
            c(m.e.expand_button_title);
            b(999);
        }

        private void a(List<Preference> list) {
            ArrayList arrayList = new ArrayList();
            CharSequence string = null;
            for (Preference preference : list) {
                CharSequence charSequenceY = preference.y();
                boolean z = preference instanceof PreferenceGroup;
                if (z && !TextUtils.isEmpty(charSequenceY)) {
                    arrayList.add((PreferenceGroup) preference);
                }
                if (arrayList.contains(preference.O())) {
                    if (z) {
                        arrayList.add((PreferenceGroup) preference);
                    }
                } else if (!TextUtils.isEmpty(charSequenceY)) {
                    string = string == null ? charSequenceY : H().getString(m.e.summary_collapsed_preference_list, string, charSequenceY);
                }
            }
            a(string);
        }

        @Override // androidx.preference.Preference
        public void a(l lVar) {
            super.a(lVar);
            lVar.a(false);
        }

        @Override // androidx.preference.Preference
        public long a() {
            return this.f975a;
        }
    }
}
