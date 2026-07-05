package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public enum aqr {
    DOUBLE(0, aqt.SCALAR, arg.DOUBLE),
    FLOAT(1, aqt.SCALAR, arg.FLOAT),
    INT64(2, aqt.SCALAR, arg.LONG),
    UINT64(3, aqt.SCALAR, arg.LONG),
    INT32(4, aqt.SCALAR, arg.INT),
    FIXED64(5, aqt.SCALAR, arg.LONG),
    FIXED32(6, aqt.SCALAR, arg.INT),
    BOOL(7, aqt.SCALAR, arg.BOOLEAN),
    STRING(8, aqt.SCALAR, arg.STRING),
    MESSAGE(9, aqt.SCALAR, arg.MESSAGE),
    BYTES(10, aqt.SCALAR, arg.BYTE_STRING),
    UINT32(11, aqt.SCALAR, arg.INT),
    ENUM(12, aqt.SCALAR, arg.ENUM),
    SFIXED32(13, aqt.SCALAR, arg.INT),
    SFIXED64(14, aqt.SCALAR, arg.LONG),
    SINT32(15, aqt.SCALAR, arg.INT),
    SINT64(16, aqt.SCALAR, arg.LONG),
    GROUP(17, aqt.SCALAR, arg.MESSAGE),
    DOUBLE_LIST(18, aqt.VECTOR, arg.DOUBLE),
    FLOAT_LIST(19, aqt.VECTOR, arg.FLOAT),
    INT64_LIST(20, aqt.VECTOR, arg.LONG),
    UINT64_LIST(21, aqt.VECTOR, arg.LONG),
    INT32_LIST(22, aqt.VECTOR, arg.INT),
    FIXED64_LIST(23, aqt.VECTOR, arg.LONG),
    FIXED32_LIST(24, aqt.VECTOR, arg.INT),
    BOOL_LIST(25, aqt.VECTOR, arg.BOOLEAN),
    STRING_LIST(26, aqt.VECTOR, arg.STRING),
    MESSAGE_LIST(27, aqt.VECTOR, arg.MESSAGE),
    BYTES_LIST(28, aqt.VECTOR, arg.BYTE_STRING),
    UINT32_LIST(29, aqt.VECTOR, arg.INT),
    ENUM_LIST(30, aqt.VECTOR, arg.ENUM),
    SFIXED32_LIST(31, aqt.VECTOR, arg.INT),
    SFIXED64_LIST(32, aqt.VECTOR, arg.LONG),
    SINT32_LIST(33, aqt.VECTOR, arg.INT),
    SINT64_LIST(34, aqt.VECTOR, arg.LONG),
    DOUBLE_LIST_PACKED(35, aqt.PACKED_VECTOR, arg.DOUBLE),
    FLOAT_LIST_PACKED(36, aqt.PACKED_VECTOR, arg.FLOAT),
    INT64_LIST_PACKED(37, aqt.PACKED_VECTOR, arg.LONG),
    UINT64_LIST_PACKED(38, aqt.PACKED_VECTOR, arg.LONG),
    INT32_LIST_PACKED(39, aqt.PACKED_VECTOR, arg.INT),
    FIXED64_LIST_PACKED(40, aqt.PACKED_VECTOR, arg.LONG),
    FIXED32_LIST_PACKED(41, aqt.PACKED_VECTOR, arg.INT),
    BOOL_LIST_PACKED(42, aqt.PACKED_VECTOR, arg.BOOLEAN),
    UINT32_LIST_PACKED(43, aqt.PACKED_VECTOR, arg.INT),
    ENUM_LIST_PACKED(44, aqt.PACKED_VECTOR, arg.ENUM),
    SFIXED32_LIST_PACKED(45, aqt.PACKED_VECTOR, arg.INT),
    SFIXED64_LIST_PACKED(46, aqt.PACKED_VECTOR, arg.LONG),
    SINT32_LIST_PACKED(47, aqt.PACKED_VECTOR, arg.INT),
    SINT64_LIST_PACKED(48, aqt.PACKED_VECTOR, arg.LONG),
    GROUP_LIST(49, aqt.VECTOR, arg.MESSAGE),
    MAP(50, aqt.MAP, arg.VOID);

    private static final aqr[] ae;
    private static final Type[] af = new Type[0];
    private final arg Z;
    private final int aa;
    private final aqt ab;
    private final Class<?> ac;
    private final boolean ad;

    aqr(int i, aqt aqtVar, arg argVar) {
        this.aa = i;
        this.ab = aqtVar;
        this.Z = argVar;
        switch (aqtVar) {
            case MAP:
                this.ac = argVar.a();
                break;
            case VECTOR:
                this.ac = argVar.a();
                break;
            default:
                this.ac = null;
                break;
        }
        boolean z = false;
        if (aqtVar == aqt.SCALAR) {
            switch (argVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.ad = z;
    }

    public final int a() {
        return this.aa;
    }

    static {
        aqr[] aqrVarArrValues = values();
        ae = new aqr[aqrVarArrValues.length];
        for (aqr aqrVar : aqrVarArrValues) {
            ae[aqrVar.aa] = aqrVar;
        }
    }
}
