package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class a extends n implements i.h {

    /* renamed from: a, reason: collision with root package name */
    final i f714a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    boolean l;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<C0046a> f715b = new ArrayList<>();
    boolean j = true;
    int m = -1;
    boolean t = false;

    /* compiled from: BackStackRecord.java */
    /* renamed from: androidx.fragment.app.a$a, reason: collision with other inner class name */
    static final class C0046a {

        /* renamed from: a, reason: collision with root package name */
        int f716a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f717b;
        int c;
        int d;
        int e;
        int f;

        C0046a() {
        }

        C0046a(int i, Fragment fragment) {
            this.f716a = i;
            this.f717b = fragment;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.c != 0 || this.d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (this.f715b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f715b.size();
        for (int i = 0; i < size; i++) {
            C0046a c0046a = this.f715b.get(i);
            switch (c0046a.f716a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + c0046a.f716a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0046a.f717b);
            if (z) {
                if (c0046a.c != 0 || c0046a.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0046a.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0046a.d));
                }
                if (c0046a.e != 0 || c0046a.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0046a.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0046a.f));
                }
            }
        }
    }

    public a(i iVar) {
        this.f714a = iVar;
    }

    void a(C0046a c0046a) {
        this.f715b.add(c0046a);
        c0046a.c = this.c;
        c0046a.d = this.d;
        c0046a.e = this.e;
        c0046a.f = this.f;
    }

    @Override // androidx.fragment.app.n
    public n a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // androidx.fragment.app.n
    public n a(int i, Fragment fragment) {
        a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // androidx.fragment.app.n
    public n a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.B = this.f714a;
        if (str != null) {
            if (fragment.J != null && !str.equals(fragment.J)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.J + " now " + str);
            }
            fragment.J = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.H != 0 && fragment.H != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.H + " now " + i);
            }
            fragment.H = i;
            fragment.I = i;
        }
        a(new C0046a(i2, fragment));
    }

    @Override // androidx.fragment.app.n
    public n a(Fragment fragment) {
        a(new C0046a(3, fragment));
        return this;
    }

    public n a() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    void a(int i) {
        if (this.i) {
            if (i.f731a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f715b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0046a c0046a = this.f715b.get(i2);
                if (c0046a.f717b != null) {
                    c0046a.f717b.A += i;
                    if (i.f731a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0046a.f717b + " to " + c0046a.f717b.A);
                    }
                }
            }
        }
    }

    public void b() {
        if (this.u != null) {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    @Override // androidx.fragment.app.n
    public int c() {
        return a(false);
    }

    @Override // androidx.fragment.app.n
    public int d() {
        return a(true);
    }

    @Override // androidx.fragment.app.n
    public void e() {
        a();
        this.f714a.b((i.h) this, true);
    }

    int a(boolean z) {
        if (this.l) {
            throw new IllegalStateException("commit already called");
        }
        if (i.f731a) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
            a("  ", (FileDescriptor) null, printWriter, (String[]) null);
            printWriter.close();
        }
        this.l = true;
        if (this.i) {
            this.m = this.f714a.a(this);
        } else {
            this.m = -1;
        }
        this.f714a.a(this, z);
        return this.m;
    }

    @Override // androidx.fragment.app.i.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (i.f731a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.f714a.b(this);
        return true;
    }

    boolean b(int i) {
        int size = this.f715b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0046a c0046a = this.f715b.get(i2);
            int i3 = c0046a.f717b != null ? c0046a.f717b.I : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f715b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            C0046a c0046a = this.f715b.get(i4);
            int i5 = c0046a.f717b != null ? c0046a.f717b.I : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f715b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        C0046a c0046a2 = aVar.f715b.get(i7);
                        if ((c0046a2.f717b != null ? c0046a2.f717b.I : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    void f() {
        int size = this.f715b.size();
        for (int i = 0; i < size; i++) {
            C0046a c0046a = this.f715b.get(i);
            Fragment fragment = c0046a.f717b;
            if (fragment != null) {
                fragment.a(this.g, this.h);
            }
            int i2 = c0046a.f716a;
            if (i2 == 1) {
                fragment.b(c0046a.c);
                this.f714a.a(fragment, false);
            } else {
                switch (i2) {
                    case 3:
                        fragment.b(c0046a.d);
                        this.f714a.i(fragment);
                        break;
                    case 4:
                        fragment.b(c0046a.d);
                        this.f714a.j(fragment);
                        break;
                    case 5:
                        fragment.b(c0046a.c);
                        this.f714a.k(fragment);
                        break;
                    case 6:
                        fragment.b(c0046a.d);
                        this.f714a.l(fragment);
                        break;
                    case 7:
                        fragment.b(c0046a.c);
                        this.f714a.m(fragment);
                        break;
                    case 8:
                        this.f714a.p(fragment);
                        break;
                    case 9:
                        this.f714a.p(null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0046a.f716a);
                }
            }
            if (!this.t && c0046a.f716a != 1 && fragment != null) {
                this.f714a.f(fragment);
            }
        }
        if (this.t) {
            return;
        }
        this.f714a.a(this.f714a.l, true);
    }

    void b(boolean z) {
        for (int size = this.f715b.size() - 1; size >= 0; size--) {
            C0046a c0046a = this.f715b.get(size);
            Fragment fragment = c0046a.f717b;
            if (fragment != null) {
                fragment.a(i.d(this.g), this.h);
            }
            int i = c0046a.f716a;
            if (i == 1) {
                fragment.b(c0046a.f);
                this.f714a.i(fragment);
            } else {
                switch (i) {
                    case 3:
                        fragment.b(c0046a.e);
                        this.f714a.a(fragment, false);
                        break;
                    case 4:
                        fragment.b(c0046a.e);
                        this.f714a.k(fragment);
                        break;
                    case 5:
                        fragment.b(c0046a.f);
                        this.f714a.j(fragment);
                        break;
                    case 6:
                        fragment.b(c0046a.e);
                        this.f714a.m(fragment);
                        break;
                    case 7:
                        fragment.b(c0046a.f);
                        this.f714a.l(fragment);
                        break;
                    case 8:
                        this.f714a.p(null);
                        break;
                    case 9:
                        this.f714a.p(fragment);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0046a.f716a);
                }
            }
            if (!this.t && c0046a.f716a != 3 && fragment != null) {
                this.f714a.f(fragment);
            }
        }
        if (this.t || !z) {
            return;
        }
        this.f714a.a(this.f714a.l, true);
    }

    Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f715b.size()) {
            C0046a c0046a = this.f715b.get(i);
            switch (c0046a.f716a) {
                case 1:
                case 7:
                    arrayList.add(c0046a.f717b);
                    break;
                case 2:
                    Fragment fragment3 = c0046a.f717b;
                    int i2 = fragment3.I;
                    Fragment fragment4 = fragment2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.I == i2) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f715b.add(i3, new C0046a(9, fragment5));
                                    i3++;
                                    fragment4 = null;
                                }
                                C0046a c0046a2 = new C0046a(3, fragment5);
                                c0046a2.c = c0046a.c;
                                c0046a2.e = c0046a.e;
                                c0046a2.d = c0046a.d;
                                c0046a2.f = c0046a.f;
                                this.f715b.add(i3, c0046a2);
                                arrayList.remove(fragment5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.f715b.remove(i3);
                        i3--;
                    } else {
                        c0046a.f716a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i3;
                    fragment2 = fragment4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0046a.f717b);
                    if (c0046a.f717b == fragment2) {
                        this.f715b.add(i, new C0046a(9, c0046a.f717b));
                        i++;
                        fragment2 = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.f715b.add(i, new C0046a(9, fragment2));
                    i++;
                    fragment2 = c0046a.f717b;
                    break;
            }
            i++;
        }
        return fragment2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment b(java.util.ArrayList<androidx.fragment.app.Fragment> r5, androidx.fragment.app.Fragment r6) {
        /*
            r4 = this;
            r0 = 0
        L1:
            java.util.ArrayList<androidx.fragment.app.a$a> r1 = r4.f715b
            int r1 = r1.size()
            if (r0 >= r1) goto L30
            java.util.ArrayList<androidx.fragment.app.a$a> r1 = r4.f715b
            java.lang.Object r1 = r1.get(r0)
            androidx.fragment.app.a$a r1 = (androidx.fragment.app.a.C0046a) r1
            int r2 = r1.f716a
            r3 = 1
            if (r2 == r3) goto L28
            r3 = 3
            if (r2 == r3) goto L22
            switch(r2) {
                case 6: goto L22;
                case 7: goto L28;
                case 8: goto L20;
                case 9: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L2d
        L1d:
            androidx.fragment.app.Fragment r6 = r1.f717b
            goto L2d
        L20:
            r6 = 0
            goto L2d
        L22:
            androidx.fragment.app.Fragment r1 = r1.f717b
            r5.add(r1)
            goto L2d
        L28:
            androidx.fragment.app.Fragment r1 = r1.f717b
            r5.remove(r1)
        L2d:
            int r0 = r0 + 1
            goto L1
        L30:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.b(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    boolean g() {
        for (int i = 0; i < this.f715b.size(); i++) {
            if (b(this.f715b.get(i))) {
                return true;
            }
        }
        return false;
    }

    void a(Fragment.b bVar) {
        for (int i = 0; i < this.f715b.size(); i++) {
            C0046a c0046a = this.f715b.get(i);
            if (b(c0046a)) {
                c0046a.f717b.a(bVar);
            }
        }
    }

    private static boolean b(C0046a c0046a) {
        Fragment fragment = c0046a.f717b;
        return (fragment == null || !fragment.u || fragment.S == null || fragment.L || fragment.K || !fragment.ac()) ? false : true;
    }

    public String h() {
        return this.k;
    }
}
