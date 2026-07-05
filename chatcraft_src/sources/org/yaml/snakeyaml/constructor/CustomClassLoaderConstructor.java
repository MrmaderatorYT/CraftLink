package org.yaml.snakeyaml.constructor;

/* loaded from: classes.dex */
public class CustomClassLoaderConstructor extends Constructor {
    private ClassLoader loader;

    public CustomClassLoaderConstructor(ClassLoader classLoader) {
        this(Object.class, classLoader);
    }

    public CustomClassLoaderConstructor(Class<? extends Object> cls, ClassLoader classLoader) {
        super(cls);
        this.loader = CustomClassLoaderConstructor.class.getClassLoader();
        if (classLoader == null) {
            throw new NullPointerException("Loader must be provided.");
        }
        this.loader = classLoader;
    }

    @Override // org.yaml.snakeyaml.constructor.Constructor
    protected Class<?> getClassForName(String str) {
        return Class.forName(str, true, this.loader);
    }
}
