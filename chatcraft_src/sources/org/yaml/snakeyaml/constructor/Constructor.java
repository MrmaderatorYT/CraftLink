package org.yaml.snakeyaml.constructor;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
public class Constructor extends SafeConstructor {
    private final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
    private final Map<Tag, Class<? extends Object>> typeTags;

    public Constructor() {
        this((Class<? extends Object>) Object.class);
    }

    public Constructor(Class<? extends Object> cls) {
        this(new TypeDescription(checkRoot(cls)));
    }

    private static Class<? extends Object> checkRoot(Class<? extends Object> cls) {
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("Root class must be provided.");
    }

    public Constructor(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        this.yamlConstructors.put(null, new ConstructYamlObject());
        if (!Object.class.equals(typeDescription.getType())) {
            this.rootTag = new Tag(typeDescription.getType());
        }
        this.typeTags = new HashMap();
        this.typeDefinitions = new HashMap();
        this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
        this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
        this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
        addTypeDescription(typeDescription);
    }

    public Constructor(String str) {
        this((Class<? extends Object>) Class.forName(check(str)));
    }

    private static final String check(String str) {
        if (str == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        if (str.trim().length() != 0) {
            return str;
        }
        throw new YAMLException("Root type must be provided.");
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        this.typeTags.put(typeDescription.getTag(), typeDescription.getType());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    protected class ConstructMapping implements Construct {
        protected ConstructMapping() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            MappingNode mappingNode = (MappingNode) node;
            if (Properties.class.isAssignableFrom(node.getType())) {
                Properties properties = new Properties();
                if (!node.isTwoStepsConstruction()) {
                    Constructor.this.constructMapping2ndStep(mappingNode, properties);
                    return properties;
                }
                throw new YAMLException("Properties must not be recursive.");
            }
            if (SortedMap.class.isAssignableFrom(node.getType())) {
                TreeMap treeMap = new TreeMap();
                if (!node.isTwoStepsConstruction()) {
                    Constructor.this.constructMapping2ndStep(mappingNode, treeMap);
                }
                return treeMap;
            }
            if (Map.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createDefaultMap();
                }
                return Constructor.this.constructMapping(mappingNode);
            }
            if (SortedSet.class.isAssignableFrom(node.getType())) {
                TreeSet treeSet = new TreeSet();
                Constructor.this.constructSet2ndStep(mappingNode, treeSet);
                return treeSet;
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createDefaultSet();
                }
                return Constructor.this.constructSet(mappingNode);
            }
            if (node.isTwoStepsConstruction()) {
                return createEmptyJavaBean(mappingNode);
            }
            return constructJavaBean2ndStep(mappingNode, createEmptyJavaBean(mappingNode));
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            if (Map.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructMapping2ndStep((MappingNode) node, (Map) obj);
            } else if (Set.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSet2ndStep((MappingNode) node, (Set) obj);
            } else {
                constructJavaBean2ndStep((MappingNode) node, obj);
            }
        }

        protected Object createEmptyJavaBean(MappingNode mappingNode) throws NoSuchMethodException, SecurityException {
            try {
                java.lang.reflect.Constructor<? extends Object> declaredConstructor = mappingNode.getType().getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new YAMLException(e);
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0063. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        protected Object constructJavaBean2ndStep(MappingNode mappingNode, Object obj) {
            boolean z;
            Class<?>[] actualTypeArguments;
            Constructor.this.flattenMapping(mappingNode);
            Class<? extends Object> type = mappingNode.getType();
            for (NodeTuple nodeTuple : mappingNode.getValue()) {
                if (nodeTuple.getKeyNode() instanceof ScalarNode) {
                    ScalarNode scalarNode = (ScalarNode) nodeTuple.getKeyNode();
                    Node valueNode = nodeTuple.getValueNode();
                    scalarNode.setType(String.class);
                    String str = (String) Constructor.this.constructObject(scalarNode);
                    try {
                        Property property = getProperty(type, str);
                        valueNode.setType(property.getType());
                        TypeDescription typeDescription = (TypeDescription) Constructor.this.typeDefinitions.get(type);
                        if (typeDescription != null) {
                            switch (valueNode.getNodeId()) {
                                case sequence:
                                    SequenceNode sequenceNode = (SequenceNode) valueNode;
                                    Class<? extends Object> listPropertyType = typeDescription.getListPropertyType(str);
                                    if (listPropertyType != null) {
                                        sequenceNode.setListType(listPropertyType);
                                    } else {
                                        if (property.getType().isArray()) {
                                            sequenceNode.setListType(property.getType().getComponentType());
                                        }
                                        z = false;
                                        break;
                                    }
                                    z = true;
                                    break;
                                case mapping:
                                    MappingNode mappingNode2 = (MappingNode) valueNode;
                                    Class<? extends Object> mapKeyType = typeDescription.getMapKeyType(str);
                                    if (mapKeyType != null) {
                                        mappingNode2.setTypes(mapKeyType, typeDescription.getMapValueType(str));
                                        z = true;
                                        break;
                                    }
                                    z = false;
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                        } else {
                            z = false;
                        }
                        if (!z && valueNode.getNodeId() != NodeId.scalar && (actualTypeArguments = property.getActualTypeArguments()) != null) {
                            if (valueNode.getNodeId() == NodeId.sequence) {
                                ((SequenceNode) valueNode).setListType(actualTypeArguments[0]);
                            } else if (valueNode.getTag().equals(Tag.SET)) {
                                MappingNode mappingNode3 = (MappingNode) valueNode;
                                mappingNode3.setOnlyKeyType(actualTypeArguments[0]);
                                mappingNode3.setUseClassConstructor(true);
                            } else if (property.getType().isAssignableFrom(Map.class)) {
                                MappingNode mappingNode4 = (MappingNode) valueNode;
                                mappingNode4.setTypes(actualTypeArguments[0], actualTypeArguments[1]);
                                mappingNode4.setUseClassConstructor(true);
                            }
                        }
                        property.set(obj, Constructor.this.constructObject(valueNode));
                    } catch (Exception e) {
                        throw new YAMLException("Cannot create property=" + str + " for JavaBean=" + obj + "; " + e.getMessage(), e);
                    }
                } else {
                    throw new YAMLException("Keys must be scalars but found: " + nodeTuple.getKeyNode());
                }
            }
            return obj;
        }

        protected Property getProperty(Class<? extends Object> cls, String str) {
            return Constructor.this.getPropertyUtils().getProperty(cls, str);
        }
    }

    protected class ConstructYamlObject implements Construct {
        protected ConstructYamlObject() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Construct getConstructor(Node node) {
            node.setType(Constructor.this.getClassForNode(node));
            return Constructor.this.yamlClassConstructors.get(node.getNodeId());
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            try {
                return getConstructor(node).construct(node);
            } catch (Exception e) {
                throw new ConstructorException(null, null, "Can't construct a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
            }
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            try {
                getConstructor(node).construct2ndStep(node, obj);
            } catch (Exception e) {
                throw new ConstructorException(null, null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
            }
        }
    }

    protected class ConstructScalar extends AbstractConstruct {
        protected ConstructScalar() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Object objConstructStandardJavaInstance;
            ScalarNode scalarNode = (ScalarNode) node;
            Class<? extends Object> type = scalarNode.getType();
            if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || Tag.BINARY.equals(scalarNode.getTag()) || Calendar.class.isAssignableFrom(type)) {
                return constructStandardJavaInstance(type, scalarNode);
            }
            java.lang.reflect.Constructor<?> constructor = null;
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor2 : type.getConstructors()) {
                if (constructor2.getParameterTypes().length == 1) {
                    i++;
                    constructor = constructor2;
                }
            }
            if (constructor == null) {
                throw new YAMLException("No single argument constructor found for " + type);
            }
            if (i == 1) {
                objConstructStandardJavaInstance = constructStandardJavaInstance(constructor.getParameterTypes()[0], scalarNode);
            } else {
                Object objConstructScalar = Constructor.this.constructScalar(scalarNode);
                try {
                    constructor = type.getConstructor(String.class);
                    objConstructStandardJavaInstance = objConstructScalar;
                } catch (Exception e) {
                    throw new ConstructorException(null, null, "Can't construct a java object for scalar " + scalarNode.getTag() + "; No String constructor found. Exception=" + e.getMessage(), scalarNode.getStartMark(), e);
                }
            }
            try {
                return constructor.newInstance(objConstructStandardJavaInstance);
            } catch (Exception e2) {
                throw new ConstructorException(null, null, "Can't construct a java object for scalar " + scalarNode.getTag() + "; exception=" + e2.getMessage(), scalarNode.getStartMark(), e2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:97:0x01b5, code lost:
        
            if (r6 == java.lang.Float.TYPE) goto L98;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.Object constructStandardJavaInstance(java.lang.Class r6, org.yaml.snakeyaml.nodes.ScalarNode r7) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                Method dump skipped, instructions count: 544
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.constructor.Constructor.ConstructScalar.constructStandardJavaInstance(java.lang.Class, org.yaml.snakeyaml.nodes.ScalarNode):java.lang.Object");
        }
    }

    protected class ConstructSequence implements Construct {
        protected ConstructSequence() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) throws SecurityException {
            boolean z;
            SequenceNode sequenceNode = (SequenceNode) node;
            if (Set.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.constructSet(sequenceNode);
            }
            if (Collection.class.isAssignableFrom(node.getType())) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createDefaultList(sequenceNode.getValue().size());
                }
                return Constructor.this.constructSequence(sequenceNode);
            }
            if (node.getType().isArray()) {
                if (node.isTwoStepsConstruction()) {
                    return Constructor.this.createArray(node.getType(), sequenceNode.getValue().size());
                }
                return Constructor.this.constructArray(sequenceNode);
            }
            ArrayList<java.lang.reflect.Constructor> arrayList = new ArrayList(sequenceNode.getValue().size());
            int i = 0;
            for (java.lang.reflect.Constructor<?> constructor : node.getType().getConstructors()) {
                if (sequenceNode.getValue().size() == constructor.getParameterTypes().length) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    Object[] objArr = new Object[sequenceNode.getValue().size()];
                    java.lang.reflect.Constructor constructor2 = (java.lang.reflect.Constructor) arrayList.get(0);
                    for (Node node2 : sequenceNode.getValue()) {
                        node2.setType(constructor2.getParameterTypes()[i]);
                        objArr[i] = Constructor.this.constructObject(node2);
                        i++;
                    }
                    try {
                        return constructor2.newInstance(objArr);
                    } catch (Exception e) {
                        throw new YAMLException(e);
                    }
                }
                List<? extends Object> listConstructSequence = Constructor.this.constructSequence(sequenceNode);
                Class<?>[] clsArr = new Class[listConstructSequence.size()];
                Iterator<? extends Object> it = listConstructSequence.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    clsArr[i2] = it.next().getClass();
                    i2++;
                }
                for (java.lang.reflect.Constructor constructor3 : arrayList) {
                    Class<?>[] parameterTypes = constructor3.getParameterTypes();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= parameterTypes.length) {
                            z = true;
                            break;
                        }
                        if (!wrapIfPrimitive(parameterTypes[i3]).isAssignableFrom(clsArr[i3])) {
                            z = false;
                            break;
                        }
                        i3++;
                    }
                    if (z) {
                        try {
                            return constructor3.newInstance(listConstructSequence.toArray());
                        } catch (Exception e2) {
                            throw new YAMLException(e2);
                        }
                    }
                }
            }
            throw new YAMLException("No suitable constructor with " + String.valueOf(sequenceNode.getValue().size()) + " arguments found for " + node.getType());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Class<? extends Object> wrapIfPrimitive(Class<?> cls) {
            if (!cls.isPrimitive()) {
                return cls;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            throw new YAMLException("Unexpected primitive " + cls);
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public void construct2ndStep(Node node, Object obj) {
            SequenceNode sequenceNode = (SequenceNode) node;
            if (List.class.isAssignableFrom(node.getType())) {
                Constructor.this.constructSequenceStep2(sequenceNode, (List) obj);
            } else {
                if (node.getType().isArray()) {
                    Constructor.this.constructArrayStep2(sequenceNode, obj);
                    return;
                }
                throw new YAMLException("Immutable objects cannot be recursive.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Class<?> getClassForNode(Node node) {
        Class<? extends Object> cls = this.typeTags.get(node.getTag());
        if (cls != null) {
            return cls;
        }
        String className = node.getTag().getClassName();
        try {
            Class<?> classForName = getClassForName(className);
            this.typeTags.put(node.getTag(), classForName);
            return classForName;
        } catch (ClassNotFoundException unused) {
            throw new YAMLException("Class not found: " + className);
        }
    }

    protected Class<?> getClassForName(String str) {
        return Class.forName(str);
    }
}
