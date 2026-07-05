package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;

/* loaded from: classes.dex */
public interface Construct {
    Object construct(Node node);

    void construct2ndStep(Node node, Object obj);
}
