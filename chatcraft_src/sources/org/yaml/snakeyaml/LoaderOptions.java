package org.yaml.snakeyaml;

/* loaded from: classes.dex */
public class LoaderOptions {
    private TypeDescription rootTypeDescription;

    public LoaderOptions() {
        this(new TypeDescription(Object.class));
    }

    public LoaderOptions(TypeDescription typeDescription) {
        this.rootTypeDescription = typeDescription;
    }

    public TypeDescription getRootTypeDescription() {
        return this.rootTypeDescription;
    }

    public void setRootTypeDescription(TypeDescription typeDescription) {
        this.rootTypeDescription = typeDescription;
    }
}
