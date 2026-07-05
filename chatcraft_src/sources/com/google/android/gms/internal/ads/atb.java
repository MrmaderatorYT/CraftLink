package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes.dex */
final class atb<FieldDescriptorType> extends ata<FieldDescriptorType, Object> {
    atb(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.ata
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryB = b(i);
                if (((aqq) entryB.getKey()).d()) {
                    entryB.setValue(Collections.unmodifiableList((List) entryB.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((aqq) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
