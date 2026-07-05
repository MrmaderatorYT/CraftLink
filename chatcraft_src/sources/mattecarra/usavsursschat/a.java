package mattecarra.usavsursschat;

import java.util.LinkedList;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Chat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    int f4886b;
    int c = -1;
    boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    LinkedList<String> f4885a = new LinkedList<>();

    public a(int i) {
        this.f4886b = i;
    }

    public void a(String str) {
        if (this.f4885a.isEmpty() || !str.equalsIgnoreCase(this.f4885a.getFirst())) {
            this.f4885a.addFirst(str);
            if (this.d) {
                this.c++;
            }
            if (this.f4885a.size() > this.f4886b) {
                if (this.c == this.f4885a.size()) {
                    this.c--;
                }
                this.f4885a.removeLast();
            }
        }
    }

    public void a() {
        this.d = false;
        this.c = -1;
    }

    public String a(int i) {
        if (this.f4885a.isEmpty()) {
            this.d = false;
            this.c = -1;
            return BuildConfig.FLAVOR;
        }
        if (this.c + i < 0) {
            this.d = false;
            this.c = -1;
            return BuildConfig.FLAVOR;
        }
        this.d = true;
        if (this.c + i >= this.f4885a.size()) {
            this.c = this.f4885a.size() - 1;
            System.out.println("Current pos? " + this.c + " " + (this.f4885a.size() - 1));
            return this.f4885a.get(this.c);
        }
        this.c += i;
        return this.f4885a.get(this.c);
    }
}
