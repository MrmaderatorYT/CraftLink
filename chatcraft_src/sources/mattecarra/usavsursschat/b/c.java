package mattecarra.usavsursschat.b;

/* compiled from: Server.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected String f4928a;

    /* renamed from: b, reason: collision with root package name */
    protected String f4929b;
    protected int c;
    protected int d;

    public c(String str, String str2, int i, int i2) {
        this.c = 25565;
        this.d = mattecarra.usavsursschat.i.e.a();
        this.f4928a = str;
        this.f4929b = str2;
        this.c = i;
        this.d = i2;
        if (this.d == 0) {
            this.d = mattecarra.usavsursschat.i.e.a();
        }
    }

    public c() {
        this.c = 25565;
        this.d = mattecarra.usavsursschat.i.e.a();
    }

    public String a() {
        return this.f4928a;
    }

    public void a(String str) {
        this.f4928a = str;
    }

    public String b() {
        return this.f4929b;
    }

    public void b(String str) {
        this.f4929b = str;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }
}
