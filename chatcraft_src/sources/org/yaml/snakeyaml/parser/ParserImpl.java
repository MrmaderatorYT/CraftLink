package org.yaml.snakeyaml.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes.dex */
public final class ParserImpl implements Parser {
    private static final Map<String, String> DEFAULT_TAGS = new HashMap();
    private final Scanner scanner;
    private Event currentEvent = null;
    private List<Integer> yamlVersion = null;
    private Map<String, String> tagHandles = new HashMap();
    private final ArrayStack<Production> states = new ArrayStack<>(100);
    private final ArrayStack<Mark> marks = new ArrayStack<>(10);
    private Production state = new ParseStreamStart();

    static {
        DEFAULT_TAGS.put("!", "!");
        DEFAULT_TAGS.put("!!", Tag.PREFIX);
    }

    public ParserImpl(StreamReader streamReader) {
        this.scanner = new ScannerImpl(streamReader);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public boolean checkEvent(Event.ID id) {
        peekEvent();
        return this.currentEvent != null && this.currentEvent.is(id);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event peekEvent() {
        if (this.currentEvent == null && this.state != null) {
            this.currentEvent = this.state.produce();
        }
        return this.currentEvent;
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event getEvent() {
        peekEvent();
        Event event = this.currentEvent;
        this.currentEvent = null;
        return event;
    }

    private class ParseStreamStart implements Production {
        private ParseStreamStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            StreamStartToken streamStartToken = (StreamStartToken) ParserImpl.this.scanner.getToken();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.getStartMark(), streamStartToken.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return streamStartEvent;
        }
    }

    private class ParseImplicitDocumentStart implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                ParserImpl.this.tagHandles = ParserImpl.DEFAULT_TAGS;
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, startMark, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return documentStartEvent;
            }
            return new ParseDocumentStart().produce();
        }
    }

    private class ParseDocumentStart implements Production {
        private ParseDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                StreamEndToken streamEndToken = (StreamEndToken) ParserImpl.this.scanner.getToken();
                StreamEndEvent streamEndEvent = new StreamEndEvent(streamEndToken.getStartMark(), streamEndToken.getEndMark());
                if (ParserImpl.this.states.isEmpty()) {
                    if (ParserImpl.this.marks.isEmpty()) {
                        ParserImpl.this.state = null;
                        return streamEndEvent;
                    }
                    throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
                }
                throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
            }
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            List listProcessDirectives = ParserImpl.this.processDirectives();
            List list = (List) listProcessDirectives.get(0);
            Map map = (Map) listProcessDirectives.get(1);
            if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                throw new ParserException(null, null, "expected '<document start>', but found " + ParserImpl.this.scanner.peekToken().getTokenId(), ParserImpl.this.scanner.peekToken().getStartMark());
            }
            DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, ParserImpl.this.scanner.getToken().getEndMark(), true, list != null ? (Integer[]) list.toArray(new Integer[2]) : null, map);
            ParserImpl.this.states.push(new ParseDocumentEnd());
            ParserImpl.this.state = new ParseDocumentContent();
            return documentStartEvent;
        }
    }

    private class ParseDocumentEnd implements Production {
        private ParseDocumentEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Mark endMark;
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            boolean z = true;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                endMark = ParserImpl.this.scanner.getToken().getEndMark();
            } else {
                endMark = startMark;
                z = false;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(startMark, endMark, z);
            ParserImpl.this.state = new ParseDocumentStart();
            return documentEndEvent;
        }
    }

    private class ParseDocumentContent implements Production {
        private ParseDocumentContent() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                Event eventProcessEmptyScalar = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
                return eventProcessEmptyScalar;
            }
            return new ParseBlockNode().produce();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> processDirectives() {
        this.yamlVersion = null;
        this.tagHandles = new HashMap();
        while (this.scanner.checkToken(Token.ID.Directive)) {
            DirectiveToken directiveToken = (DirectiveToken) this.scanner.getToken();
            if (directiveToken.getName().equals("YAML")) {
                if (this.yamlVersion != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", directiveToken.getStartMark());
                }
                if (((Integer) directiveToken.getValue().get(0)).intValue() != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", directiveToken.getStartMark());
                }
                this.yamlVersion = directiveToken.getValue();
            } else if (directiveToken.getName().equals("TAG")) {
                List value = directiveToken.getValue();
                String str = (String) value.get(0);
                String str2 = (String) value.get(1);
                if (this.tagHandles.containsKey(str)) {
                    throw new ParserException(null, null, "duplicate tag handle " + str, directiveToken.getStartMark());
                }
                this.tagHandles.put(str, str2);
            } else {
                continue;
            }
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.yamlVersion);
        if (!this.tagHandles.isEmpty()) {
            arrayList.add(new HashMap(this.tagHandles));
        } else {
            arrayList.add(new HashMap());
        }
        for (String str3 : DEFAULT_TAGS.keySet()) {
            if (!this.tagHandles.containsKey(str3)) {
                this.tagHandles.put(str3, DEFAULT_TAGS.get(str3));
            }
        }
        return arrayList;
    }

    private class ParseBlockNode implements Production {
        private ParseBlockNode() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseFlowNode() {
        return parseNode(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseBlockNodeOrIndentlessSequence() {
        return parseNode(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseNode(boolean z, boolean z2) {
        TagTuple value;
        Mark startMark;
        Mark endMark;
        Mark startMark2;
        String value2;
        String str;
        Mark startMark3;
        Mark mark;
        ImplicitTuple implicitTuple;
        Mark endMark2;
        TagTuple value3;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken aliasToken = (AliasToken) this.scanner.getToken();
            AliasEvent aliasEvent = new AliasEvent(aliasToken.getValue(), aliasToken.getStartMark(), aliasToken.getEndMark());
            this.state = this.states.pop();
            return aliasEvent;
        }
        if (this.scanner.checkToken(Token.ID.Anchor)) {
            AnchorToken anchorToken = (AnchorToken) this.scanner.getToken();
            startMark = anchorToken.getStartMark();
            Mark endMark3 = anchorToken.getEndMark();
            String value4 = anchorToken.getValue();
            if (this.scanner.checkToken(Token.ID.Tag)) {
                TagToken tagToken = (TagToken) this.scanner.getToken();
                startMark2 = tagToken.getStartMark();
                endMark2 = tagToken.getEndMark();
                value3 = tagToken.getValue();
            } else {
                startMark2 = null;
                endMark2 = endMark3;
                value3 = null;
            }
            value2 = value4;
            value = value3;
            endMark = endMark2;
        } else if (this.scanner.checkToken(Token.ID.Tag)) {
            TagToken tagToken2 = (TagToken) this.scanner.getToken();
            startMark = tagToken2.getStartMark();
            endMark = tagToken2.getEndMark();
            value = tagToken2.getValue();
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                AnchorToken anchorToken2 = (AnchorToken) this.scanner.getToken();
                Mark endMark4 = anchorToken2.getEndMark();
                value2 = anchorToken2.getValue();
                endMark = endMark4;
            } else {
                value2 = null;
            }
            startMark2 = startMark;
        } else {
            value = null;
            startMark = null;
            endMark = null;
            startMark2 = null;
            value2 = null;
        }
        if (value != null) {
            String handle = value.getHandle();
            String suffix = value.getSuffix();
            if (handle != null) {
                if (!this.tagHandles.containsKey(handle)) {
                    throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, startMark2);
                }
                suffix = this.tagHandles.get(handle) + suffix;
            }
            str = suffix;
        } else {
            str = null;
        }
        if (startMark == null) {
            startMark3 = this.scanner.peekToken().getStartMark();
            mark = startMark3;
        } else {
            startMark3 = startMark;
            mark = endMark;
        }
        boolean z3 = str == null || str.equals("!");
        if (z2 && this.scanner.checkToken(Token.ID.BlockEntry)) {
            SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), Boolean.FALSE);
            this.state = new ParseIndentlessSequenceEntry();
            return sequenceStartEvent;
        }
        if (this.scanner.checkToken(Token.ID.Scalar)) {
            ScalarToken scalarToken = (ScalarToken) this.scanner.getToken();
            Mark endMark5 = scalarToken.getEndMark();
            if ((scalarToken.getPlain() && str == null) || "!".equals(str)) {
                implicitTuple = new ImplicitTuple(true, false);
            } else if (str == null) {
                implicitTuple = new ImplicitTuple(false, true);
            } else {
                implicitTuple = new ImplicitTuple(false, false);
            }
            ScalarEvent scalarEvent = new ScalarEvent(value2, str, implicitTuple, scalarToken.getValue(), startMark3, endMark5, Character.valueOf(scalarToken.getStyle()));
            this.state = this.states.pop();
            return scalarEvent;
        }
        if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
            SequenceStartEvent sequenceStartEvent2 = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), Boolean.TRUE);
            this.state = new ParseFlowSequenceFirstEntry();
            return sequenceStartEvent2;
        }
        if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
            MappingStartEvent mappingStartEvent = new MappingStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), Boolean.TRUE);
            this.state = new ParseFlowMappingFirstKey();
            return mappingStartEvent;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
            SequenceStartEvent sequenceStartEvent3 = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getStartMark(), Boolean.FALSE);
            this.state = new ParseBlockSequenceFirstEntry();
            return sequenceStartEvent3;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
            MappingStartEvent mappingStartEvent2 = new MappingStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getStartMark(), Boolean.FALSE);
            this.state = new ParseBlockMappingFirstKey();
            return mappingStartEvent2;
        }
        if (value2 != null || str != null) {
            ScalarEvent scalarEvent2 = new ScalarEvent(value2, str, new ImplicitTuple(z3, false), BuildConfig.FLAVOR, startMark3, mark, (char) 0);
            this.state = this.states.pop();
            return scalarEvent2;
        }
        String str2 = z ? "block" : "flow";
        Token tokenPeekToken = this.scanner.peekToken();
        throw new ParserException("while parsing a " + str2 + " node", startMark3, "expected the node content, but found " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
    }

    private class ParseBlockSequenceFirstEntry implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockSequenceEntry().produce();
        }
    }

    private class ParseBlockSequenceEntry implements Production {
        private ParseBlockSequenceEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                BlockEntryToken blockEntryToken = (BlockEntryToken) ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseBlockSequenceEntry());
                    return new ParseBlockNode().produce();
                }
                ParserImpl.this.state = ParserImpl.this.new ParseBlockSequenceEntry();
                return ParserImpl.this.processEmptyScalar(blockEntryToken.getEndMark());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token = ParserImpl.this.scanner.getToken();
                SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
                ParserImpl.this.marks.pop();
                return sequenceEndEvent;
            }
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            throw new ParserException("while parsing a block collection", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
        }
    }

    private class ParseIndentlessSequenceEntry implements Production {
        private ParseIndentlessSequenceEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseIndentlessSequenceEntry());
                    return new ParseBlockNode().produce();
                }
                ParserImpl.this.state = ParserImpl.this.new ParseIndentlessSequenceEntry();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseBlockMappingFirstKey implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseBlockMappingKey implements Production {
        private ParseBlockMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token token2 = ParserImpl.this.scanner.getToken();
                MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
                ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
                ParserImpl.this.marks.pop();
                return mappingEndEvent;
            }
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            throw new ParserException("while parsing a block mapping", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
        }
    }

    private class ParseBlockMappingValue implements Production {
        private ParseBlockMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseFlowSequenceFirstEntry implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowSequenceEntry(true).produce();
        }
    }

    private class ParseFlowSequenceEntry implements Production {
        private boolean first;

        public ParseFlowSequenceEntry(boolean z) {
            this.first = false;
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                    } else {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark) ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token tokenPeekToken2 = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, tokenPeekToken2.getStartMark(), tokenPeekToken2.getEndMark(), Boolean.TRUE);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return mappingStartEvent;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseFlowSequenceEntryMappingKey implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseFlowSequenceEntryMappingValue implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseFlowSequenceEntryMappingEnd implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowSequenceEntry(false);
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
        }
    }

    private class ParseFlowMappingFirstKey implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowMappingKey(true).produce();
        }
    }

    private class ParseFlowMappingKey implements Production {
        private boolean first;

        public ParseFlowMappingKey(boolean z) {
            this.first = false;
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                    } else {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark) ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(token.getEndMark());
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.state = (Production) ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return mappingEndEvent;
        }
    }

    private class ParseFlowMappingValue implements Production {
        private ParseFlowMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseFlowMappingKey(false));
                    return ParserImpl.this.parseFlowNode();
                }
                ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    private class ParseFlowMappingEmptyValue implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event processEmptyScalar(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), BuildConfig.FLAVOR, mark, mark, (char) 0);
    }
}
