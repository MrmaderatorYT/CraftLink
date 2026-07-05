package mattecarra.usavsursschat.InAppPurchase.Utils;

/* loaded from: classes.dex */
public class IabException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    b f4811a;

    public IabException(b bVar) {
        this(bVar, (Exception) null);
    }

    public IabException(int i, String str) {
        this(new b(i, str));
    }

    public IabException(b bVar, Exception exc) {
        super(bVar.a(), exc);
        this.f4811a = bVar;
    }

    public IabException(int i, String str, Exception exc) {
        this(new b(i, str), exc);
    }

    public b a() {
        return this.f4811a;
    }
}
