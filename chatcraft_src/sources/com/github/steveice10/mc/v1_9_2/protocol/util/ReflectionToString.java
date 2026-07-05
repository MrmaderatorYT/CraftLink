package com.github.steveice10.mc.v1_9_2.protocol.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ReflectionToString {
    private ReflectionToString() {
    }

    private static String memberToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (length > 20) {
                return obj.getClass().getSimpleName() + "(length=" + length + ')';
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(memberToString(Array.get(obj, i)));
            }
            sb.append(']');
            return sb.toString();
        }
        return obj.toString();
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName());
            sb.append('(');
            List<Field> allDeclaredFields = getAllDeclaredFields(obj.getClass());
            for (int i = 0; i < allDeclaredFields.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                Field field = allDeclaredFields.get(i);
                field.setAccessible(true);
                sb.append(field.getName());
                sb.append('=');
                sb.append(memberToString(field.get(obj)));
            }
            sb.append(')');
            return sb.toString();
        } catch (Throwable th) {
            return obj.getClass().getSimpleName() + '@' + Integer.toHexString(obj.hashCode()) + '(' + th.toString() + ')';
        }
    }

    private static List<Field> getAllDeclaredFields(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }
}
