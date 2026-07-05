package mattecarra.usavsursschat.a.a.a;

import com.github.steveice10.mc.common.message.MessageInterface;
import java.util.UUID;

/* compiled from: PlayerEntryObject.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private UUID f4894a;

    /* renamed from: b, reason: collision with root package name */
    private String f4895b;
    private MessageInterface c;

    public e(UUID uuid, String str, MessageInterface messageInterface) {
        this.f4894a = uuid;
        this.f4895b = str;
        this.c = messageInterface;
    }

    public String a() {
        return this.f4894a != null ? this.f4894a.toString() : this.f4895b;
    }

    public String b() {
        return this.f4895b;
    }

    public MessageInterface c() {
        return this.c;
    }
}
