package org.yaml.snakeyaml.extensions.compactnotation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.constructor.AbstractConstruct;
import org.yaml.snakeyaml.constructor.Construct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;

/* loaded from: classes.dex */
public class CompactConstructor extends Constructor {
    private static final Pattern FIRST_PATTERN = Pattern.compile("(\\p{Alpha}.*)(\\s*)\\((.*?)\\)");
    private static final Pattern PROPERTY_NAME_PATTERN = Pattern.compile("\\s*(\\p{Alpha}\\w*)\\s*=(.+)");

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    protected Object constructScalar(ScalarNode scalarNode) {
        CompactData compactData = getCompactData(scalarNode.getValue());
        if (compactData != null) {
            return constructCompactFormat(scalarNode, compactData);
        }
        return super.constructScalar(scalarNode);
    }

    protected Object constructCompactFormat(ScalarNode scalarNode, CompactData compactData) {
        try {
            Object objCreateInstance = createInstance(scalarNode, compactData);
            setProperties(objCreateInstance, new HashMap(compactData.getProperties()));
            return objCreateInstance;
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    protected Object createInstance(ScalarNode scalarNode, CompactData compactData) throws NoSuchMethodException, SecurityException {
        Class<?> classForName = getClassForName(compactData.getPrefix());
        Class<?>[] clsArr = new Class[compactData.getArguments().size()];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr[i] = String.class;
        }
        java.lang.reflect.Constructor<?> declaredConstructor = classForName.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(compactData.getArguments().toArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setProperties(Object obj, Map<String, Object> map) {
        if (map == null) {
            throw new NullPointerException("Data for Compact Object Notation cannot be null.");
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                getPropertyUtils().getProperty(obj.getClass(), key).set(obj, entry.getValue());
            } catch (IllegalArgumentException unused) {
                throw new YAMLException("Cannot set property='" + key + "' with value='" + map.get(key) + "' (" + map.get(key).getClass() + ") in " + obj);
            }
        }
    }

    public CompactData getCompactData(String str) {
        if (!str.endsWith(")") || str.indexOf(40) < 0) {
            return null;
        }
        Matcher matcher = FIRST_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strTrim = matcher.group(1).trim();
        String strGroup = matcher.group(3);
        CompactData compactData = new CompactData(strTrim);
        if (strGroup.length() == 0) {
            return compactData;
        }
        for (String str2 : strGroup.split("\\s*,\\s*")) {
            if (str2.indexOf(61) < 0) {
                compactData.getArguments().add(str2);
            } else {
                Matcher matcher2 = PROPERTY_NAME_PATTERN.matcher(str2);
                if (!matcher2.matches()) {
                    return null;
                }
                compactData.getProperties().put(matcher2.group(1), matcher2.group(2).trim());
            }
        }
        return compactData;
    }

    @Override // org.yaml.snakeyaml.constructor.BaseConstructor
    protected Construct getConstructor(Node node) {
        if (node instanceof MappingNode) {
            List<NodeTuple> value = ((MappingNode) node).getValue();
            if (value.size() == 1) {
                Node keyNode = value.get(0).getKeyNode();
                if ((keyNode instanceof ScalarNode) && getCompactData(((ScalarNode) keyNode).getValue()) != null) {
                    return new ConstructCompactObject();
                }
            }
        }
        return super.getConstructor(node);
    }

    public class ConstructCompactObject extends AbstractConstruct {
        public ConstructCompactObject() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            Map.Entry entry = (Map.Entry) CompactConstructor.this.constructMapping((MappingNode) node).entrySet().iterator().next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                try {
                    CompactConstructor.this.setProperties(key, (Map) value);
                } catch (Exception e) {
                    throw new YAMLException(e);
                }
            } else {
                CompactConstructor.this.applySequence(key, (List) value);
            }
            return key;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void applySequence(Object obj, List<?> list) {
        try {
            getPropertyUtils().getProperty(obj.getClass(), getSequencePropertyName(obj.getClass())).set(obj, list);
        } catch (Exception e) {
            throw new YAMLException(e);
        }
    }

    protected String getSequencePropertyName(Class<?> cls) {
        Set<Property> properties = getPropertyUtils().getProperties(cls);
        Iterator<Property> it = properties.iterator();
        while (it.hasNext()) {
            if (!List.class.isAssignableFrom(it.next().getType())) {
                it.remove();
            }
        }
        if (properties.size() == 0) {
            throw new YAMLException("No list property found in " + cls);
        }
        if (properties.size() > 1) {
            throw new YAMLException("Many list properties found in " + cls + "; Please override getSequencePropertyName() to specify which property to use.");
        }
        return properties.iterator().next().getName();
    }
}
