package org.yaml.snakeyaml.serializer;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.emitter.Emitable;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes.dex */
public final class Serializer {
    private Map<Node, String> anchors;
    private Boolean closed;
    private final Emitable emitter;
    private boolean explicitEnd;
    private Tag explicitRoot;
    private boolean explicitStart;
    private int lastAnchorId;
    private final Resolver resolver;
    private Set<Node> serializedNodes;
    private Map<String, String> useTags;
    private Integer[] useVersion;

    public Serializer(Emitable emitable, Resolver resolver, DumperOptions dumperOptions, Tag tag) {
        this.emitter = emitable;
        this.resolver = resolver;
        this.explicitStart = dumperOptions.isExplicitStart();
        this.explicitEnd = dumperOptions.isExplicitEnd();
        if (dumperOptions.getVersion() != null) {
            this.useVersion = dumperOptions.getVersion().getArray();
        }
        this.useTags = dumperOptions.getTags();
        this.serializedNodes = new HashSet();
        this.anchors = new HashMap();
        this.lastAnchorId = 0;
        this.closed = null;
        this.explicitRoot = tag;
    }

    public void open() {
        if (this.closed == null) {
            this.emitter.emit(new StreamStartEvent(null, null));
            this.closed = Boolean.FALSE;
        } else {
            if (Boolean.TRUE.equals(this.closed)) {
                throw new SerializerException("serializer is closed");
            }
            throw new SerializerException("serializer is already opened");
        }
    }

    public void close() {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (Boolean.TRUE.equals(this.closed)) {
            return;
        }
        this.emitter.emit(new StreamEndEvent(null, null));
        this.closed = Boolean.TRUE;
    }

    public void serialize(Node node) {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (this.closed.booleanValue()) {
            throw new SerializerException("serializer is closed");
        }
        this.emitter.emit(new DocumentStartEvent(null, null, this.explicitStart, this.useVersion, this.useTags));
        anchorNode(node);
        if (this.explicitRoot != null) {
            node.setTag(this.explicitRoot);
        }
        serializeNode(node, null);
        this.emitter.emit(new DocumentEndEvent(null, null, this.explicitEnd));
        this.serializedNodes.clear();
        this.anchors.clear();
        this.lastAnchorId = 0;
    }

    private void anchorNode(Node node) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.anchors.containsKey(node)) {
            if (this.anchors.get(node) == null) {
                this.anchors.put(node, generateAnchor());
                return;
            }
        }
        this.anchors.put(node, null);
        switch (node.getNodeId()) {
            case sequence:
                Iterator<Node> it = ((SequenceNode) node).getValue().iterator();
                while (it.hasNext()) {
                    anchorNode(it.next());
                }
                break;
            case mapping:
                for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                    Node keyNode = nodeTuple.getKeyNode();
                    Node valueNode = nodeTuple.getValueNode();
                    anchorNode(keyNode);
                    anchorNode(valueNode);
                }
                break;
        }
    }

    private String generateAnchor() {
        this.lastAnchorId++;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(3);
        numberInstance.setGroupingUsed(false);
        return "id" + numberInstance.format(this.lastAnchorId);
    }

    private void serializeNode(Node node, Node node2) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        String str = this.anchors.get(node);
        if (this.serializedNodes.contains(node)) {
            this.emitter.emit(new AliasEvent(str, null, null));
            return;
        }
        this.serializedNodes.add(node);
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[node.getNodeId().ordinal()];
        if (i == 1) {
            SequenceNode sequenceNode = (SequenceNode) node;
            this.emitter.emit(new SequenceStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.sequence, null, true)), null, null, sequenceNode.getFlowStyle()));
            Iterator<Node> it = sequenceNode.getValue().iterator();
            while (it.hasNext()) {
                serializeNode(it.next(), node);
            }
            this.emitter.emit(new SequenceEndEvent(null, null));
            return;
        }
        if (i == 3) {
            ScalarNode scalarNode = (ScalarNode) node;
            this.emitter.emit(new ScalarEvent(str, node.getTag().getValue(), new ImplicitTuple(node.getTag().equals(this.resolver.resolve(NodeId.scalar, scalarNode.getValue(), true)), node.getTag().equals(this.resolver.resolve(NodeId.scalar, scalarNode.getValue(), false))), scalarNode.getValue(), null, null, scalarNode.getStyle()));
            return;
        }
        this.emitter.emit(new MappingStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.mapping, null, true)), null, null, ((CollectionNode) node).getFlowStyle()));
        MappingNode mappingNode = (MappingNode) node;
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            serializeNode(keyNode, mappingNode);
            serializeNode(valueNode, mappingNode);
        }
        this.emitter.emit(new MappingEndEvent(null, null));
    }
}
