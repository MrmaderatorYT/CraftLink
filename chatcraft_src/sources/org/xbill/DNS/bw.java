package org.xbill.DNS;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ResolverConfig.java */
/* loaded from: classes.dex */
public class bw {

    /* renamed from: a, reason: collision with root package name */
    static Class f5360a;

    /* renamed from: b, reason: collision with root package name */
    static Class f5361b;
    private static bw f;
    private String[] c = null;
    private bg[] d = null;
    private int e = -1;

    static {
        f();
    }

    public bw() throws Throwable {
        if (g() || h()) {
            return;
        }
        if (this.c == null || this.d == null) {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("java.vendor");
            if (property.indexOf("Windows") != -1) {
                if (property.indexOf("95") != -1 || property.indexOf("98") != -1 || property.indexOf("ME") != -1) {
                    k();
                    return;
                } else {
                    l();
                    return;
                }
            }
            if (property.indexOf("NetWare") != -1) {
                j();
            } else if (property2.indexOf("Android") != -1) {
                m();
            } else {
                i();
            }
        }
    }

    private void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        if (bk.b("verbose")) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("adding server ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
        list.add(str);
    }

    private void b(String str, List list) {
        if (bk.b("verbose")) {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("adding search ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
        try {
            bg bgVarA = bg.a(str, bg.f5343a);
            if (list.contains(bgVarA)) {
                return;
            }
            list.add(bgVarA);
        } catch (TextParseException unused) {
        }
    }

    private int b(String str) throws NumberFormatException {
        String strSubstring = str.substring(6);
        try {
            int i = Integer.parseInt(strSubstring);
            if (i < 0) {
                return -1;
            }
            if (bk.b("verbose")) {
                PrintStream printStream = System.out;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("setting ndots ");
                stringBuffer.append(strSubstring);
                printStream.println(stringBuffer.toString());
            }
            return i;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(List list, List list2) {
        if (this.c == null && list.size() > 0) {
            this.c = (String[]) list.toArray(new String[0]);
        }
        if (this.d != null || list2.size() <= 0) {
            return;
        }
        this.d = (bg[]) list2.toArray(new bg[0]);
    }

    private void a(int i) {
        if (this.e >= 0 || i <= 0) {
            return;
        }
        this.e = i;
    }

    private boolean g() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.c == null || this.d == null) ? false : true;
    }

    private boolean h() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object objInvoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List list = (List) cls.getMethod("nameservers", clsArr).invoke(objInvoke, objArr);
            List list2 = (List) cls.getMethod("searchlist", clsArr).invoke(objInvoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a((String) it.next(), arrayList);
                }
            }
            if (list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    b((String) it2.next(), arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void c(String str) throws IOException, NumberFormatException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int iB = -1;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (line.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(line);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(line);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(line);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String strNextToken = stringTokenizer4.nextToken();
                            if (strNextToken.startsWith("ndots:")) {
                                iB = b(strNextToken);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            a(iB);
        } catch (FileNotFoundException unused2) {
        }
    }

    private void i() throws IOException, NumberFormatException {
        c("/etc/resolv.conf");
    }

    private void j() throws IOException, NumberFormatException {
        c("sys:/etc/resolv.cfg");
    }

    static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a(InputStream inputStream, Locale locale) throws Throwable {
        Class clsA;
        ResourceBundle bundle;
        if (f5360a == null) {
            clsA = a("org.xbill.DNS.bw");
            f5360a = clsA;
        } else {
            clsA = f5360a;
        }
        String name = clsA.getPackage().getName();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        stringBuffer.append(".windows.DNSServer");
        String string = stringBuffer.toString();
        if (locale != null) {
            bundle = ResourceBundle.getBundle(string, locale);
        } else {
            bundle = ResourceBundle.getBundle(string);
        }
        String string2 = bundle.getString("host_name");
        String string3 = bundle.getString("primary_dns_suffix");
        String string4 = bundle.getString("dns_suffix");
        String string5 = bundle.getString("dns_servers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        if (!stringTokenizer.hasMoreTokens()) {
                            break;
                        }
                        String strNextToken = stringTokenizer.nextToken();
                        if (line.indexOf(":") != -1) {
                            z = false;
                            z2 = false;
                        }
                        if (line.indexOf(string2) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            try {
                                if (bg.a(strNextToken, (bg) null).c() != 1) {
                                    b(strNextToken, arrayList2);
                                }
                            } catch (TextParseException unused) {
                            }
                        } else if (line.indexOf(string3) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            if (!strNextToken.equals(":")) {
                                b(strNextToken, arrayList2);
                                z = true;
                            }
                        } else if (z || line.indexOf(string4) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            if (!strNextToken.equals(":")) {
                                b(strNextToken, arrayList2);
                                z = true;
                            }
                        } else if (z2 || line.indexOf(string5) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                strNextToken = stringTokenizer.nextToken();
                            }
                            if (!strNextToken.equals(":")) {
                                a(strNextToken, arrayList);
                                z2 = true;
                            }
                        }
                    } else {
                        a(arrayList, arrayList2);
                        return;
                    }
                }
            }
        } catch (IOException unused2) {
        }
    }

    private void a(InputStream inputStream) throws Throwable {
        int iIntValue = Integer.getInteger("org.xbill.DNS.windows.parse.buffer", 8192).intValue();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, iIntValue);
        bufferedInputStream.mark(iIntValue);
        a(bufferedInputStream, (Locale) null);
        if (this.c == null) {
            try {
                bufferedInputStream.reset();
                a(bufferedInputStream, new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR));
            } catch (IOException unused) {
            }
        }
    }

    private void k() throws Throwable {
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("winipcfg /all /batch ");
            stringBuffer.append("winipcfg.out");
            runtime.exec(stringBuffer.toString()).waitFor();
            a(new FileInputStream(new File("winipcfg.out")));
            new File("winipcfg.out").delete();
        } catch (Exception unused) {
        }
    }

    private void l() throws Throwable {
        try {
            Process processExec = Runtime.getRuntime().exec("ipconfig /all");
            a(processExec.getInputStream());
            processExec.destroy();
        } catch (Exception unused) {
        }
    }

    private void m() throws Throwable {
        Class<?> clsA;
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<?>[] clsArr = new Class[1];
            if (f5361b == null) {
                clsA = a("java.lang.String");
                f5361b = clsA;
            } else {
                clsA = f5361b;
            }
            clsArr[0] = clsA;
            Method method = cls.getMethod("get", clsArr);
            for (String str : new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}) {
                String str2 = (String) method.invoke(null, str);
                if (str2 != null && ((str2.matches("^\\d+(\\.\\d+){3}$") || str2.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str2))) {
                    arrayList.add(str2);
                }
            }
        } catch (Exception unused) {
        }
        a(arrayList, arrayList2);
    }

    public String[] a() {
        return this.c;
    }

    public String b() {
        if (this.c == null) {
            return null;
        }
        return this.c[0];
    }

    public bg[] c() {
        return this.d;
    }

    public int d() {
        if (this.e < 0) {
            return 1;
        }
        return this.e;
    }

    public static synchronized bw e() {
        return f;
    }

    public static void f() throws Throwable {
        Class clsA;
        bw bwVar = new bw();
        if (f5360a == null) {
            clsA = a("org.xbill.DNS.bw");
            f5360a = clsA;
        } else {
            clsA = f5360a;
        }
        synchronized (clsA) {
            f = bwVar;
        }
    }
}
