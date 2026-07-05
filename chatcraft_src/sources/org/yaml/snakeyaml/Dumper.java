package org.yaml.snakeyaml;

import org.yaml.snakeyaml.representer.Representer;

/* loaded from: classes.dex */
public final class Dumper {
    protected final DumperOptions options;
    protected final Representer representer;

    public Dumper(Representer representer, DumperOptions dumperOptions) {
        this.representer = representer;
        this.options = dumperOptions;
    }

    public Dumper(DumperOptions dumperOptions) {
        this(new Representer(), dumperOptions);
    }

    public Dumper(Representer representer) {
        this(representer, new DumperOptions());
    }

    public Dumper() {
        this(new Representer(), new DumperOptions());
    }
}
