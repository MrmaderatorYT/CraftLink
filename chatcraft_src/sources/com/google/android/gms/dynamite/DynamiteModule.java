package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class DynamiteModule {

    @GuardedBy("DynamiteModule.class")
    private static Boolean e = null;

    @GuardedBy("DynamiteModule.class")
    private static i f = null;

    @GuardedBy("DynamiteModule.class")
    private static k g = null;

    @GuardedBy("DynamiteModule.class")
    private static String h = null;

    @GuardedBy("DynamiteModule.class")
    private static int i = -1;
    private final Context n;
    private static final ThreadLocal<b> j = new ThreadLocal<>();
    private static final a.InterfaceC0071a k = new com.google.android.gms.dynamite.a();

    /* renamed from: a, reason: collision with root package name */
    public static final a f1761a = new com.google.android.gms.dynamite.b();
    private static final a l = new com.google.android.gms.dynamite.c();

    /* renamed from: b, reason: collision with root package name */
    public static final a f1762b = new d();
    public static final a c = new e();
    public static final a d = new f();
    private static final a m = new g();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a, reason: collision with other inner class name */
        public interface InterfaceC0071a {
            int a(Context context, String str);

            int a(Context context, String str, boolean z);
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f1763a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f1764b = 0;
            public int c = 0;
        }

        b a(Context context, String str, InterfaceC0071a interfaceC0071a);
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public Cursor f1765a;

        private b() {
        }

        /* synthetic */ b(com.google.android.gms.dynamite.a aVar) {
            this();
        }
    }

    public static DynamiteModule a(Context context, a aVar, String str) {
        b bVar = j.get();
        com.google.android.gms.dynamite.a aVar2 = null;
        b bVar2 = new b(aVar2);
        j.set(bVar2);
        try {
            a.b bVarA = aVar.a(context, str, k);
            int i2 = bVarA.f1763a;
            int i3 = bVarA.f1764b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            if (bVarA.c == 0 || ((bVarA.c == -1 && bVarA.f1763a == 0) || (bVarA.c == 1 && bVarA.f1764b == 0))) {
                int i4 = bVarA.f1763a;
                int i5 = bVarA.f1764b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), aVar2);
            }
            if (bVarA.c == -1) {
                DynamiteModule dynamiteModuleC = c(context, str);
                if (bVar2.f1765a != null) {
                    bVar2.f1765a.close();
                }
                j.set(bVar);
                return dynamiteModuleC;
            }
            if (bVarA.c != 1) {
                int i6 = bVarA.c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new LoadingException(sb3.toString(), aVar2);
            }
            try {
                DynamiteModule dynamiteModuleA = a(context, str, bVarA.f1764b);
                if (bVar2.f1765a != null) {
                    bVar2.f1765a.close();
                }
                j.set(bVar);
                return dynamiteModuleA;
            } catch (LoadingException e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to load remote module: ".concat(strValueOf) : new String("Failed to load remote module: "));
                if (bVarA.f1763a == 0 || aVar.a(context, str, new c(bVarA.f1763a, 0)).c != -1) {
                    throw new LoadingException("Remote load failed. No local fallback found.", e2, aVar2);
                }
                DynamiteModule dynamiteModuleC2 = c(context, str);
                if (bVar2.f1765a != null) {
                    bVar2.f1765a.close();
                }
                j.set(bVar);
                return dynamiteModuleC2;
            }
        } catch (Throwable th) {
            if (bVar2.f1765a != null) {
                bVar2.f1765a.close();
            }
            j.set(bVar);
            throw th;
        }
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.a aVar) {
            this(str, th);
        }
    }

    private static class c implements a.InterfaceC0071a {

        /* renamed from: a, reason: collision with root package name */
        private final int f1766a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1767b = 0;

        public c(int i, int i2) {
            this.f1766a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.InterfaceC0071a
        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.InterfaceC0071a
        public final int a(Context context, String str) {
            return this.f1766a;
        }
    }

    public static int a(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String strValueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(strValueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", strValueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(strValueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int a(Context context, String str, boolean z) {
        Class<?> clsLoadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = e;
                if (bool2 == null) {
                    try {
                        clsLoadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = clsLoadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String strValueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(strValueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (clsLoadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    a(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int iC = c(context, str, z);
                                if (h != null && !h.isEmpty()) {
                                    h hVar = new h(h, ClassLoader.getSystemClassLoader());
                                    a(hVar);
                                    declaredField.set(null, hVar);
                                    e = Boolean.TRUE;
                                    return iC;
                                }
                                return iC;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        e = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return c(context, str, z);
                    } catch (LoadingException e3) {
                        String strValueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", strValueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return b(context, str, z);
            }
        } catch (Throwable th) {
            com.google.android.gms.common.util.e.a(context, th);
            throw th;
        }
    }

    private static int b(Context context, String str, boolean z) {
        i iVarA = a(context);
        if (iVarA == null) {
            return 0;
        }
        try {
            if (iVarA.a() >= 2) {
                return iVarA.b(com.google.android.gms.dynamic.b.a(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return iVarA.a(com.google.android.gms.dynamic.b.a(context), str, z);
        } catch (RemoteException e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", strValueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(strValueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(android.content.Context r8, java.lang.String r9, boolean r10) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10.length()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.append(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r2.append(r9)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            if (r8 == 0) goto L90
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            if (r9 == 0) goto L90
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            if (r9 <= 0) goto L81
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.dynamite.DynamiteModule.h = r1     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7e
            if (r1 < 0) goto L6b
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.dynamite.DynamiteModule.i = r1     // Catch: java.lang.Throwable -> L7e
        L6b:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r10 = com.google.android.gms.dynamite.DynamiteModule.j     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            com.google.android.gms.dynamite.DynamiteModule$b r10 = (com.google.android.gms.dynamite.DynamiteModule.b) r10     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            if (r10 == 0) goto L81
            android.database.Cursor r1 = r10.f1765a     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            if (r1 != 0) goto L81
            r10.f1765a = r8     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            r8 = r0
            goto L81
        L7e:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            throw r9     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
        L81:
            if (r8 == 0) goto L86
            r8.close()
        L86:
            return r9
        L87:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lb2
        L8b:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto La3
        L90:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
            throw r9     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8b
        L9f:
            r8 = move-exception
            goto Lb2
        La1:
            r8 = move-exception
            r9 = r0
        La3:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lb0
            if (r10 == 0) goto La8
            throw r8     // Catch: java.lang.Throwable -> Lb0
        La8:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lb0
            throw r10     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r8 = move-exception
            r0 = r9
        Lb2:
            if (r0 == 0) goto Lb7
            r0.close()
        Lb7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, java.lang.String, boolean):int");
    }

    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    private static DynamiteModule c(Context context, String str) {
        String strValueOf = String.valueOf(str);
        Log.i("DynamiteModule", strValueOf.length() != 0 ? "Selected local version of ".concat(strValueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule a(Context context, String str, int i2) {
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                bool = e;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.a) null);
            }
            if (bool.booleanValue()) {
                return c(context, str, i2);
            }
            return b(context, str, i2);
        } catch (Throwable th) {
            com.google.android.gms.common.util.e.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule b(Context context, String str, int i2) throws LoadingException {
        com.google.android.gms.dynamic.a aVarA;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        i iVarA = a(context);
        com.google.android.gms.dynamite.a aVar = null;
        if (iVarA == null) {
            throw new LoadingException("Failed to create IDynamiteLoader.", aVar);
        }
        try {
            if (iVarA.a() >= 2) {
                aVarA = iVarA.b(com.google.android.gms.dynamic.b.a(context), str, i2);
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                aVarA = iVarA.a(com.google.android.gms.dynamic.b.a(context), str, i2);
            }
            if (com.google.android.gms.dynamic.b.a(aVarA) == null) {
                throw new LoadingException("Failed to load remote module.", aVar);
            }
            return new DynamiteModule((Context) com.google.android.gms.dynamic.b.a(aVarA));
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, aVar);
        }
    }

    private static i a(Context context) {
        i jVar;
        synchronized (DynamiteModule.class) {
            if (f != null) {
                return f;
            }
            if (com.google.android.gms.common.d.a().a(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    jVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (iInterfaceQueryLocalInterface instanceof i) {
                        jVar = (i) iInterfaceQueryLocalInterface;
                    } else {
                        jVar = new j(iBinder);
                    }
                }
                if (jVar != null) {
                    f = jVar;
                    return jVar;
                }
            } catch (Exception e2) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(strValueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public final Context a() {
        return this.n;
    }

    private static DynamiteModule c(Context context, String str, int i2) throws LoadingException {
        k kVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            kVar = g;
        }
        com.google.android.gms.dynamite.a aVar = null;
        if (kVar == null) {
            throw new LoadingException("DynamiteLoaderV2 was not cached.", aVar);
        }
        b bVar = j.get();
        if (bVar == null || bVar.f1765a == null) {
            throw new LoadingException("No result cursor", aVar);
        }
        Context contextA = a(context.getApplicationContext(), str, i2, bVar.f1765a, kVar);
        if (contextA == null) {
            throw new LoadingException("Failed to get module context", aVar);
        }
        return new DynamiteModule(contextA);
    }

    private static Boolean b() {
        Boolean boolValueOf;
        synchronized (DynamiteModule.class) {
            boolValueOf = Boolean.valueOf(i >= 2);
        }
        return boolValueOf;
    }

    private static Context a(Context context, String str, int i2, Cursor cursor, k kVar) {
        com.google.android.gms.dynamic.a aVarA;
        try {
            com.google.android.gms.dynamic.b.a((Object) null);
            if (b().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                aVarA = kVar.b(com.google.android.gms.dynamic.b.a(context), str, i2, com.google.android.gms.dynamic.b.a(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                aVarA = kVar.a(com.google.android.gms.dynamic.b.a(context), str, i2, com.google.android.gms.dynamic.b.a(cursor));
            }
            return (Context) com.google.android.gms.dynamic.b.a(aVarA);
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.toString());
            Log.e("DynamiteModule", strValueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(strValueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void a(ClassLoader classLoader) throws LoadingException {
        k lVar;
        com.google.android.gms.dynamite.a aVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (iInterfaceQueryLocalInterface instanceof k) {
                    lVar = (k) iInterfaceQueryLocalInterface;
                } else {
                    lVar = new l(iBinder);
                }
            }
            g = lVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, aVar);
        }
    }

    public final IBinder a(String str) throws LoadingException {
        try {
            return (IBinder) this.n.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String strValueOf = String.valueOf(str);
            throw new LoadingException(strValueOf.length() != 0 ? "Failed to instantiate module class: ".concat(strValueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }

    private DynamiteModule(Context context) {
        this.n = (Context) com.google.android.gms.common.internal.i.a(context);
    }
}
