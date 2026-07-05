package org.yaml.snakeyaml.constructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
public abstract class BaseConstructor {
    private Composer composer;
    private PropertyUtils propertyUtils;
    protected final Map<NodeId, Construct> yamlClassConstructors = new EnumMap(NodeId.class);
    protected final Map<Tag, Construct> yamlConstructors = new HashMap();
    protected final Map<String, Construct> yamlMultiConstructors = new HashMap();
    private final Map<Node, Object> constructedObjects = new HashMap();
    private final Set<Node> recursiveObjects = new HashSet();
    private final ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> maps2fill = new ArrayList<>();
    private final ArrayList<RecursiveTuple<Set<Object>, Object>> sets2fill = new ArrayList<>();
    protected Tag rootTag = null;
    private boolean explicitPropertyUtils = false;

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public boolean checkData() {
        return this.composer.checkNode();
    }

    public Object getData() {
        this.composer.checkNode();
        Node node = this.composer.getNode();
        if (this.rootTag != null) {
            node.setTag(this.rootTag);
        }
        return constructDocument(node);
    }

    public Object getSingleData(Class<?> cls) {
        Node singleNode = this.composer.getSingleNode();
        if (singleNode == null) {
            return null;
        }
        if (Object.class != cls) {
            singleNode.setTag(new Tag((Class<? extends Object>) cls));
        } else if (this.rootTag != null) {
            singleNode.setTag(this.rootTag);
        }
        return constructDocument(singleNode);
    }

    private Object constructDocument(Node node) {
        Object objConstructObject = constructObject(node);
        fillRecursive();
        this.constructedObjects.clear();
        this.recursiveObjects.clear();
        return objConstructObject;
    }

    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            Iterator<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> it = this.maps2fill.iterator();
            while (it.hasNext()) {
                RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> next = it.next();
                RecursiveTuple<Object, Object> recursiveTuple_2 = next._2();
                next._1().put(recursiveTuple_2._1(), recursiveTuple_2._2());
            }
            this.maps2fill.clear();
        }
        if (this.sets2fill.isEmpty()) {
            return;
        }
        Iterator<RecursiveTuple<Set<Object>, Object>> it2 = this.sets2fill.iterator();
        while (it2.hasNext()) {
            RecursiveTuple<Set<Object>, Object> next2 = it2.next();
            next2._1().add(next2._2());
        }
        this.sets2fill.clear();
    }

    protected Object constructObject(Node node) {
        if (this.constructedObjects.containsKey(node)) {
            return this.constructedObjects.get(node);
        }
        if (this.recursiveObjects.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
        }
        this.recursiveObjects.add(node);
        Construct constructor = getConstructor(node);
        Object objConstruct = constructor.construct(node);
        this.constructedObjects.put(node, objConstruct);
        this.recursiveObjects.remove(node);
        if (node.isTwoStepsConstruction()) {
            constructor.construct2ndStep(node, objConstruct);
        }
        return objConstruct;
    }

    protected Construct getConstructor(Node node) {
        if (node.useClassConstructor()) {
            return this.yamlClassConstructors.get(node.getNodeId());
        }
        Construct construct = this.yamlConstructors.get(node.getTag());
        if (construct != null) {
            return construct;
        }
        for (String str : this.yamlMultiConstructors.keySet()) {
            if (node.getTag().startsWith(str)) {
                return this.yamlMultiConstructors.get(str);
            }
        }
        return this.yamlConstructors.get(null);
    }

    protected Object constructScalar(ScalarNode scalarNode) {
        return scalarNode.getValue();
    }

    protected List<Object> createDefaultList(int i) {
        return new ArrayList(i);
    }

    protected Set<Object> createDefaultSet(int i) {
        return new LinkedHashSet(i);
    }

    protected <T> T[] createArray(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i));
    }

    protected List<? extends Object> constructSequence(SequenceNode sequenceNode) {
        List<? extends Object> listCreateDefaultList;
        if (List.class.isAssignableFrom(sequenceNode.getType()) && !sequenceNode.getType().isInterface()) {
            try {
                listCreateDefaultList = (List) sequenceNode.getType().newInstance();
            } catch (Exception e) {
                throw new YAMLException(e);
            }
        } else {
            listCreateDefaultList = createDefaultList(sequenceNode.getValue().size());
        }
        constructSequenceStep2(sequenceNode, listCreateDefaultList);
        return listCreateDefaultList;
    }

    protected Set<? extends Object> constructSet(SequenceNode sequenceNode) {
        Set<Object> setCreateDefaultSet;
        if (!sequenceNode.getType().isInterface()) {
            try {
                setCreateDefaultSet = (Set) sequenceNode.getType().newInstance();
            } catch (Exception e) {
                throw new YAMLException(e);
            }
        } else {
            setCreateDefaultSet = createDefaultSet(sequenceNode.getValue().size());
        }
        constructSequenceStep2(sequenceNode, setCreateDefaultSet);
        return setCreateDefaultSet;
    }

    protected Object constructArray(SequenceNode sequenceNode) {
        return constructArrayStep2(sequenceNode, createArray(sequenceNode.getType(), sequenceNode.getValue().size()));
    }

    protected void constructSequenceStep2(SequenceNode sequenceNode, Collection<Object> collection) {
        Iterator<Node> it = sequenceNode.getValue().iterator();
        while (it.hasNext()) {
            collection.add(constructObject(it.next()));
        }
    }

    protected Object constructArrayStep2(SequenceNode sequenceNode, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Iterator<Node> it = sequenceNode.getValue().iterator();
        int i = 0;
        while (it.hasNext()) {
            Array.set(obj, i, constructObject(it.next()));
            i++;
        }
        return obj;
    }

    protected Map<Object, Object> createDefaultMap() {
        return new LinkedHashMap();
    }

    protected Set<Object> createDefaultSet() {
        return new LinkedHashSet();
    }

    protected Set<Object> constructSet(MappingNode mappingNode) {
        Set<Object> setCreateDefaultSet = createDefaultSet();
        constructSet2ndStep(mappingNode, setCreateDefaultSet);
        return setCreateDefaultSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<Object, Object> constructMapping(MappingNode mappingNode) {
        Map<Object, Object> mapCreateDefaultMap = createDefaultMap();
        constructMapping2ndStep(mappingNode, mapCreateDefaultMap);
        return mapCreateDefaultMap;
    }

    protected void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            Object objConstructObject2 = constructObject(valueNode);
            if (keyNode.isTwoStepsConstruction()) {
                this.maps2fill.add(0, new RecursiveTuple<>(map, new RecursiveTuple(objConstructObject, objConstructObject2)));
            } else {
                map.put(objConstructObject, objConstructObject2);
            }
        }
    }

    protected void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Object objConstructObject = constructObject(keyNode);
            if (objConstructObject != null) {
                try {
                    objConstructObject.hashCode();
                } catch (Exception e) {
                    throw new ConstructorException("while constructing a Set", mappingNode.getStartMark(), "found unacceptable key " + objConstructObject, nodeTuple.getKeyNode().getStartMark(), e);
                }
            }
            if (keyNode.isTwoStepsConstruction()) {
                this.sets2fill.add(0, new RecursiveTuple<>(set, objConstructObject));
            } else {
                set.add(objConstructObject);
            }
        }
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    private static class RecursiveTuple<T, K> {
        private final T _1;
        private final K _2;

        public RecursiveTuple(T t, K k) {
            this._1 = t;
            this._2 = k;
        }

        public K _2() {
            return this._2;
        }

        public T _1() {
            return this._1;
        }
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }
}
