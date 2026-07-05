package org.yaml.snakeyaml.composer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes.dex */
public class Composer {
    private final Parser parser;
    private final Resolver resolver;
    private final Map<String, Node> anchors = new HashMap();
    private final Set<Node> recursiveNodes = new HashSet();

    public Composer(Parser parser, Resolver resolver) {
        this.parser = parser;
        this.resolver = resolver;
    }

    public boolean checkNode() {
        if (this.parser.checkEvent(Event.ID.StreamStart)) {
            this.parser.getEvent();
        }
        return !this.parser.checkEvent(Event.ID.StreamEnd);
    }

    public Node getNode() {
        if (this.parser.checkEvent(Event.ID.StreamEnd)) {
            return null;
        }
        return composeDocument();
    }

    public Node getSingleNode() {
        this.parser.getEvent();
        Node nodeComposeDocument = !this.parser.checkEvent(Event.ID.StreamEnd) ? composeDocument() : null;
        if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
            throw new ComposerException("expected a single document in the stream", nodeComposeDocument.getStartMark(), "but found another document", this.parser.getEvent().getStartMark());
        }
        this.parser.getEvent();
        return nodeComposeDocument;
    }

    private Node composeDocument() {
        this.parser.getEvent();
        Node nodeComposeNode = composeNode(null);
        this.parser.getEvent();
        this.anchors.clear();
        this.recursiveNodes.clear();
        return nodeComposeNode;
    }

    private Node composeNode(Node node) {
        Node nodeComposeMappingNode;
        this.recursiveNodes.add(node);
        if (this.parser.checkEvent(Event.ID.Alias)) {
            AliasEvent aliasEvent = (AliasEvent) this.parser.getEvent();
            String anchor = aliasEvent.getAnchor();
            if (!this.anchors.containsKey(anchor)) {
                throw new ComposerException(null, null, "found undefined alias " + anchor, aliasEvent.getStartMark());
            }
            Node node2 = this.anchors.get(anchor);
            if (this.recursiveNodes.remove(node2)) {
                node2.setTwoStepsConstruction(true);
            }
            return node2;
        }
        NodeEvent nodeEvent = (NodeEvent) this.parser.peekEvent();
        String anchor2 = nodeEvent.getAnchor();
        if (anchor2 != null && this.anchors.containsKey(anchor2)) {
            throw new ComposerException("found duplicate anchor " + anchor2 + "; first occurence", this.anchors.get(anchor2).getStartMark(), "second occurence", nodeEvent.getStartMark());
        }
        if (this.parser.checkEvent(Event.ID.Scalar)) {
            nodeComposeMappingNode = composeScalarNode(anchor2);
        } else if (this.parser.checkEvent(Event.ID.SequenceStart)) {
            nodeComposeMappingNode = composeSequenceNode(anchor2);
        } else {
            nodeComposeMappingNode = composeMappingNode(anchor2);
        }
        this.recursiveNodes.remove(node);
        return nodeComposeMappingNode;
    }

    private Node composeScalarNode(String str) {
        Tag tagResolve;
        boolean z;
        ScalarEvent scalarEvent = (ScalarEvent) this.parser.getEvent();
        String tag = scalarEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.scalar, scalarEvent.getValue(), scalarEvent.getImplicit().canOmitTagInPlainScalar());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            z = false;
        }
        ScalarNode scalarNode = new ScalarNode(tagResolve, z, scalarEvent.getValue(), scalarEvent.getStartMark(), scalarEvent.getEndMark(), scalarEvent.getStyle());
        if (str != null) {
            this.anchors.put(str, scalarNode);
        }
        return scalarNode;
    }

    private Node composeSequenceNode(String str) {
        Tag tagResolve;
        boolean z;
        SequenceStartEvent sequenceStartEvent = (SequenceStartEvent) this.parser.getEvent();
        String tag = sequenceStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.sequence, null, sequenceStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        SequenceNode sequenceNode = new SequenceNode(tagResolve, z, arrayList, sequenceStartEvent.getStartMark(), null, sequenceStartEvent.getFlowStyle());
        if (str != null) {
            this.anchors.put(str, sequenceNode);
        }
        while (!this.parser.checkEvent(Event.ID.SequenceEnd)) {
            arrayList.add(composeNode(sequenceNode));
        }
        sequenceNode.setEndMark(this.parser.getEvent().getEndMark());
        return sequenceNode;
    }

    private Node composeMappingNode(String str) {
        Tag tagResolve;
        boolean z;
        MappingStartEvent mappingStartEvent = (MappingStartEvent) this.parser.getEvent();
        String tag = mappingStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.mapping, null, mappingStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        MappingNode mappingNode = new MappingNode(tagResolve, z, arrayList, mappingStartEvent.getStartMark(), null, mappingStartEvent.getFlowStyle());
        if (str != null) {
            this.anchors.put(str, mappingNode);
        }
        while (!this.parser.checkEvent(Event.ID.MappingEnd)) {
            Node nodeComposeNode = composeNode(mappingNode);
            if (nodeComposeNode.getTag().equals(Tag.MERGE)) {
                mappingNode.setMerged(true);
            } else if (nodeComposeNode.getTag().equals(Tag.VALUE)) {
                nodeComposeNode.setTag(Tag.STR);
            }
            arrayList.add(new NodeTuple(nodeComposeNode, composeNode(mappingNode)));
        }
        mappingNode.setEndMark(this.parser.getEvent().getEndMark());
        return mappingNode;
    }
}
