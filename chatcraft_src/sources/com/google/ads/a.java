package com.google.ads;

@Deprecated
/* loaded from: classes.dex */
public final class a {

    public enum b {
        UNKNOWN,
        MALE,
        FEMALE
    }

    /* renamed from: com.google.ads.a$a, reason: collision with other inner class name */
    public enum EnumC0064a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");

        private final String e;

        EnumC0064a(String str) {
            this.e = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.e;
        }
    }
}
