package mattecarra.notobfuscated.JsonClasses;

/* loaded from: classes.dex */
public class Version {
    private String name;
    private String protocol;

    public String getName() {
        return this.name;
    }

    public int getProtocol() {
        return Integer.parseInt(this.protocol);
    }
}
