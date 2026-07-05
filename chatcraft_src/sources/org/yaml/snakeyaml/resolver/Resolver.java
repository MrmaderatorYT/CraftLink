package org.yaml.snakeyaml.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
public class Resolver {
    protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers;
    public static final Pattern BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern FLOAT = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern INT = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern MERGE = Pattern.compile("^(?:<<)$");
    public static final Pattern NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern EMPTY = Pattern.compile("^$");
    public static final Pattern TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern VALUE = Pattern.compile("^(?:=)$");
    public static final Pattern YAML = Pattern.compile("^(?:!|&|\\*)$");

    public Resolver(boolean z) {
        this.yamlImplicitResolvers = new HashMap();
        if (z) {
            addImplicitResolvers();
        }
    }

    protected void addImplicitResolvers() {
        addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO");
        addImplicitResolver(Tag.INT, INT, "-+0123456789");
        addImplicitResolver(Tag.FLOAT, FLOAT, "-+0123456789.");
        addImplicitResolver(Tag.MERGE, MERGE, "<");
        addImplicitResolver(Tag.NULL, NULL, "~nN\u0000");
        addImplicitResolver(Tag.NULL, EMPTY, null);
        addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789");
        addImplicitResolver(Tag.VALUE, VALUE, "=");
        addImplicitResolver(Tag.YAML, YAML, "!&*");
    }

    public Resolver() {
        this(true);
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        if (str == null) {
            List<ResolverTuple> arrayList = this.yamlImplicitResolvers.get(null);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.yamlImplicitResolvers.put(null, arrayList);
            }
            arrayList.add(new ResolverTuple(tag, pattern));
            return;
        }
        for (char c : str.toCharArray()) {
            Character chValueOf = Character.valueOf(c);
            if (chValueOf.charValue() == 0) {
                chValueOf = null;
            }
            List<ResolverTuple> arrayList2 = this.yamlImplicitResolvers.get(chValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.yamlImplicitResolvers.put(chValueOf, arrayList2);
            }
            arrayList2.add(new ResolverTuple(tag, pattern));
        }
    }

    public Tag resolve(NodeId nodeId, String str, boolean z) {
        List<ResolverTuple> list;
        if (nodeId == NodeId.scalar && z) {
            if (str.length() == 0) {
                list = this.yamlImplicitResolvers.get((char) 0);
            } else {
                list = this.yamlImplicitResolvers.get(Character.valueOf(str.charAt(0)));
            }
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.getTag();
                    if (resolverTuple.getRegexp().matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.yamlImplicitResolvers.get(null)) {
                    Tag tag2 = resolverTuple2.getTag();
                    if (resolverTuple2.getRegexp().matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        switch (nodeId) {
            case scalar:
                return Tag.STR;
            case sequence:
                return Tag.SEQ;
            default:
                return Tag.MAP;
        }
    }
}
