package org.yaml.snakeyaml;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.reader.UnicodeReader;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes.dex */
public class JavaBeanLoader<T> {
    private Yaml loader;

    public JavaBeanLoader(TypeDescription typeDescription) {
        this(typeDescription, BeanAccess.DEFAULT);
    }

    public JavaBeanLoader(TypeDescription typeDescription, BeanAccess beanAccess) {
        this(new LoaderOptions(typeDescription), beanAccess);
    }

    public JavaBeanLoader(LoaderOptions loaderOptions, BeanAccess beanAccess) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        if (loaderOptions.getRootTypeDescription() == null) {
            throw new NullPointerException("TypeDescription must be provided.");
        }
        this.loader = new Yaml(new Constructor(loaderOptions.getRootTypeDescription()), loaderOptions, new Representer(), new DumperOptions(), new Resolver());
        this.loader.setBeanAccess(beanAccess);
    }

    public <S extends T> JavaBeanLoader(Class<S> cls, BeanAccess beanAccess) {
        this(new TypeDescription(cls), beanAccess);
    }

    public <S extends T> JavaBeanLoader(Class<S> cls) {
        this(cls, BeanAccess.DEFAULT);
    }

    public T load(String str) {
        return (T) this.loader.load(new StringReader(str));
    }

    public T load(InputStream inputStream) {
        return (T) this.loader.load(new UnicodeReader(inputStream));
    }

    public T load(Reader reader) {
        return (T) this.loader.load(reader);
    }
}
