package org.yaml.snakeyaml.emitter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.scanner.Constant;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes.dex */
public final class Emitter implements Emitable {
    private static final Pattern ANCHOR_FORMAT;
    private static final Map<String, String> DEFAULT_TAG_PREFIXES;
    private static final Pattern HANDLE_FORMAT;
    public static final int MAX_INDENT = 10;
    public static final int MIN_INDENT = 1;
    private boolean allowUnicode;
    private ScalarAnalysis analysis;
    private int bestIndent;
    private char[] bestLineBreak;
    private int bestWidth;
    private Boolean canonical;
    private DumperOptions options;
    private String preparedAnchor;
    private String preparedTag;
    private Boolean prettyFlow;
    private boolean rootContext;
    private final Writer stream;
    private Character style;
    private Map<String, String> tagPrefixes;
    private static final Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap();
    private static final char[] SPACE = {' '};
    private final ArrayStack<EmitterState> states = new ArrayStack<>(100);
    private EmitterState state = new ExpectStreamStart();
    private final Queue<Event> events = new ArrayBlockingQueue(100);
    private Event event = null;
    private final ArrayStack<Integer> indents = new ArrayStack<>(10);
    private Integer indent = null;
    private int flowLevel = 0;
    private boolean mappingContext = false;
    private boolean simpleKeyContext = false;
    private int column = 0;
    private boolean whitespace = true;
    private boolean indention = true;
    private boolean openEnded = false;

    void writeStreamStart() {
    }

    static /* synthetic */ int access$2010(Emitter emitter) {
        int i = emitter.flowLevel;
        emitter.flowLevel = i - 1;
        return i;
    }

    static {
        ESCAPE_REPLACEMENTS.put((char) 0, "0");
        ESCAPE_REPLACEMENTS.put((char) 7, "a");
        ESCAPE_REPLACEMENTS.put('\b', "b");
        ESCAPE_REPLACEMENTS.put('\t', "t");
        ESCAPE_REPLACEMENTS.put('\n', "n");
        ESCAPE_REPLACEMENTS.put((char) 11, "v");
        ESCAPE_REPLACEMENTS.put('\f', "f");
        ESCAPE_REPLACEMENTS.put('\r', "r");
        ESCAPE_REPLACEMENTS.put((char) 27, "e");
        ESCAPE_REPLACEMENTS.put('\"', "\"");
        ESCAPE_REPLACEMENTS.put('\\', "\\");
        ESCAPE_REPLACEMENTS.put((char) 133, "N");
        ESCAPE_REPLACEMENTS.put((char) 160, "_");
        ESCAPE_REPLACEMENTS.put((char) 8232, "L");
        ESCAPE_REPLACEMENTS.put((char) 8233, "P");
        DEFAULT_TAG_PREFIXES = new LinkedHashMap();
        DEFAULT_TAG_PREFIXES.put("!", "!");
        DEFAULT_TAG_PREFIXES.put(Tag.PREFIX, "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
        ANCHOR_FORMAT = Pattern.compile("^[-_\\w]*$");
    }

    public Emitter(Writer writer, DumperOptions dumperOptions) {
        this.stream = writer;
        this.canonical = Boolean.valueOf(dumperOptions.isCanonical());
        this.prettyFlow = Boolean.valueOf(dumperOptions.isPrettyFlow());
        this.allowUnicode = dumperOptions.isAllowUnicode();
        this.bestIndent = 2;
        if (dumperOptions.getIndent() > 1 && dumperOptions.getIndent() < 10) {
            this.bestIndent = dumperOptions.getIndent();
        }
        this.bestWidth = 80;
        if (dumperOptions.getWidth() > this.bestIndent * 2) {
            this.bestWidth = dumperOptions.getWidth();
        }
        this.bestLineBreak = dumperOptions.getLineBreak().getString().toCharArray();
        this.tagPrefixes = new LinkedHashMap();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
        this.options = dumperOptions;
    }

    @Override // org.yaml.snakeyaml.emitter.Emitable
    public void emit(Event event) {
        this.events.add(event);
        while (!needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }

    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        Event eventPeek = this.events.peek();
        if (eventPeek instanceof DocumentStartEvent) {
            return needEvents(1);
        }
        if (eventPeek instanceof SequenceStartEvent) {
            return needEvents(2);
        }
        if (eventPeek instanceof MappingStartEvent) {
            return needEvents(3);
        }
        return false;
    }

    private boolean needEvents(int i) {
        Iterator<Event> it = this.events.iterator();
        it.next();
        int i2 = 0;
        while (it.hasNext()) {
            Event next = it.next();
            if ((next instanceof DocumentStartEvent) || (next instanceof CollectionStartEvent)) {
                i2++;
            } else if ((next instanceof DocumentEndEvent) || (next instanceof CollectionEndEvent)) {
                i2--;
            } else if (next instanceof StreamEndEvent) {
                i2 = -1;
            }
            if (i2 < 0) {
                return false;
            }
        }
        return this.events.size() < i + 1;
    }

    private void increaseIndent(boolean z, boolean z2) {
        this.indents.push(this.indent);
        if (this.indent != null) {
            if (z2) {
                return;
            }
            this.indent = Integer.valueOf(this.indent.intValue() + this.bestIndent);
        } else if (z) {
            this.indent = Integer.valueOf(this.bestIndent);
        } else {
            this.indent = 0;
        }
    }

    private class ExpectStreamStart implements EmitterState {
        private ExpectStreamStart() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() {
            if (!(Emitter.this.event instanceof StreamStartEvent)) {
                throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeStreamStart();
            Emitter.this.state = new ExpectFirstDocumentStart();
        }
    }

    private class ExpectNothing implements EmitterState {
        private ExpectNothing() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() {
            throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
        }
    }

    private class ExpectFirstDocumentStart implements EmitterState {
        private ExpectFirstDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectDocumentStart(true).expect();
        }
    }

    private class ExpectDocumentStart implements EmitterState {
        private boolean first;

        public ExpectDocumentStart(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof DocumentStartEvent) {
                DocumentStartEvent documentStartEvent = (DocumentStartEvent) Emitter.this.event;
                if ((documentStartEvent.getVersion() != null || documentStartEvent.getTags() != null) && Emitter.this.openEnded) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                if (documentStartEvent.getVersion() != null) {
                    Emitter.this.writeVersionDirective(Emitter.this.prepareVersion(documentStartEvent.getVersion()));
                }
                Emitter.this.tagPrefixes = new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
                if (documentStartEvent.getTags() != null) {
                    for (String str : new TreeSet(documentStartEvent.getTags().keySet())) {
                        String str2 = documentStartEvent.getTags().get(str);
                        Emitter.this.tagPrefixes.put(str2, str);
                        Emitter.this.writeTagDirective(Emitter.this.prepareTagHandle(str), Emitter.this.prepareTagPrefix(str2));
                    }
                }
                if (!(this.first && !documentStartEvent.getExplicit() && !Emitter.this.canonical.booleanValue() && documentStartEvent.getVersion() == null && documentStartEvent.getTags() == null && !Emitter.this.checkEmptyDocument())) {
                    Emitter.this.writeIndent();
                    Emitter.this.writeIndicator("---", true, false, false);
                    if (Emitter.this.canonical.booleanValue()) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter.this.state = new ExpectDocumentRoot();
                return;
            }
            if (!(Emitter.this.event instanceof StreamEndEvent)) {
                throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeStreamEnd();
            Emitter.this.state = new ExpectNothing();
        }
    }

    private class ExpectDocumentEnd implements EmitterState {
        private ExpectDocumentEnd() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof DocumentEndEvent)) {
                throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeIndent();
            if (((DocumentEndEvent) Emitter.this.event).getExplicit()) {
                Emitter.this.writeIndicator("...", true, false, false);
                Emitter.this.writeIndent();
            }
            Emitter.this.flushStream();
            Emitter.this.state = Emitter.this.new ExpectDocumentStart(false);
        }
    }

    private class ExpectDocumentRoot implements EmitterState {
        private ExpectDocumentRoot() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.states.push(new ExpectDocumentEnd());
            Emitter.this.expectNode(true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expectNode(boolean z, boolean z2, boolean z3) throws IOException {
        this.rootContext = z;
        this.mappingContext = z2;
        this.simpleKeyContext = z3;
        if (this.event instanceof AliasEvent) {
            expectAlias();
            return;
        }
        if ((this.event instanceof ScalarEvent) || (this.event instanceof CollectionStartEvent)) {
            processAnchor("&");
            processTag();
            if (this.event instanceof ScalarEvent) {
                expectScalar();
                return;
            }
            if (this.event instanceof SequenceStartEvent) {
                if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent) this.event).getFlowStyle().booleanValue() || checkEmptySequence()) {
                    expectFlowSequence();
                    return;
                } else {
                    expectBlockSequence();
                    return;
                }
            }
            if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent) this.event).getFlowStyle().booleanValue() || checkEmptyMapping()) {
                expectFlowMapping();
                return;
            } else {
                expectBlockMapping();
                return;
            }
        }
        throw new EmitterException("expected NodeEvent, but got " + this.event);
    }

    private void expectAlias() throws IOException {
        if (((NodeEvent) this.event).getAnchor() == null) {
            throw new EmitterException("anchor is not specified for alias");
        }
        processAnchor("*");
        this.state = this.states.pop();
    }

    private void expectScalar() throws IOException {
        increaseIndent(true, false);
        processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }

    private void expectFlowSequence() throws IOException {
        writeIndicator("[", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem();
    }

    private class ExpectFirstFlowSequenceItem implements EmitterState {
        private ExpectFirstFlowSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem());
                Emitter.this.expectNode(false, false, false);
                return;
            }
            Emitter.this.indent = (Integer) Emitter.this.indents.pop();
            Emitter.access$2010(Emitter.this);
            Emitter.this.writeIndicator("]", false, false, false);
            Emitter.this.state = (EmitterState) Emitter.this.states.pop();
        }
    }

    private class ExpectFlowSequenceItem implements EmitterState {
        private ExpectFlowSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2010(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("]", false, false, false);
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.states.push(Emitter.this.new ExpectFlowSequenceItem());
            Emitter.this.expectNode(false, false, false);
        }
    }

    private void expectFlowMapping() throws IOException {
        writeIndicator("{", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey();
    }

    private class ExpectFirstFlowMappingKey implements EmitterState {
        private ExpectFirstFlowMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof MappingEndEvent)) {
                if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                    Emitter.this.expectNode(false, true, true);
                    return;
                } else {
                    Emitter.this.writeIndicator("?", true, false, false);
                    Emitter.this.states.push(new ExpectFlowMappingValue());
                    Emitter.this.expectNode(false, true, false);
                    return;
                }
            }
            Emitter.this.indent = (Integer) Emitter.this.indents.pop();
            Emitter.access$2010(Emitter.this);
            Emitter.this.writeIndicator("}", false, false, false);
            Emitter.this.state = (EmitterState) Emitter.this.states.pop();
        }
    }

    private class ExpectFlowMappingKey implements EmitterState {
        private ExpectFlowMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.access$2010(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue());
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    private class ExpectFlowMappingSimpleValue implements EmitterState {
        private ExpectFlowMappingSimpleValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
        }
    }

    private class ExpectFlowMappingValue implements EmitterState {
        private ExpectFlowMappingValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(":", true, false, false);
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
        }
    }

    private void expectBlockSequence() {
        increaseIndent(false, this.mappingContext && !this.indention);
        this.state = new ExpectFirstBlockSequenceItem();
    }

    private class ExpectFirstBlockSequenceItem implements EmitterState {
        private ExpectFirstBlockSequenceItem() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockSequenceItem(true).expect();
        }
    }

    private class ExpectBlockSequenceItem implements EmitterState {
        private boolean first;

        public ExpectBlockSequenceItem(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!this.first && (Emitter.this.event instanceof SequenceEndEvent)) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator("-", true, false, true);
            Emitter.this.states.push(Emitter.this.new ExpectBlockSequenceItem(false));
            Emitter.this.expectNode(false, false, false);
        }
    }

    private void expectBlockMapping() {
        increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey();
    }

    private class ExpectFirstBlockMappingKey implements EmitterState {
        private ExpectFirstBlockMappingKey() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockMappingKey(true).expect();
        }
    }

    private class ExpectBlockMappingKey implements EmitterState {
        private boolean first;

        public ExpectBlockMappingKey(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!this.first && (Emitter.this.event instanceof MappingEndEvent)) {
                Emitter.this.indent = (Integer) Emitter.this.indents.pop();
                Emitter.this.state = (EmitterState) Emitter.this.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            if (Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectBlockMappingSimpleValue());
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, true);
                Emitter.this.states.push(new ExpectBlockMappingValue());
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    private class ExpectBlockMappingSimpleValue implements EmitterState {
        private ExpectBlockMappingSimpleValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
        }
    }

    private class ExpectBlockMappingValue implements EmitterState {
        private ExpectBlockMappingValue() {
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(":", true, false, true);
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
        }
    }

    private boolean checkEmptySequence() {
        return (this.event instanceof SequenceStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof SequenceEndEvent);
    }

    private boolean checkEmptyMapping() {
        return (this.event instanceof MappingStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof MappingEndEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmptyDocument() {
        if (!(this.event instanceof DocumentStartEvent) || this.events.isEmpty()) {
            return false;
        }
        Event eventPeek = this.events.peek();
        if (!(eventPeek instanceof ScalarEvent)) {
            return false;
        }
        ScalarEvent scalarEvent = (ScalarEvent) eventPeek;
        return scalarEvent.getAnchor() == null && scalarEvent.getTag() == null && scalarEvent.getImplicit() != null && scalarEvent.getValue().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSimpleKey() {
        int length;
        if (!(this.event instanceof NodeEvent) || ((NodeEvent) this.event).getAnchor() == null) {
            length = 0;
        } else {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent) this.event).getAnchor());
            }
            length = this.preparedAnchor.length() + 0;
        }
        String tag = null;
        if (this.event instanceof ScalarEvent) {
            tag = ((ScalarEvent) this.event).getTag();
        } else if (this.event instanceof CollectionStartEvent) {
            tag = ((CollectionStartEvent) this.event).getTag();
        }
        if (tag != null) {
            if (this.preparedTag == null) {
                this.preparedTag = prepareTag(tag);
            }
            length += this.preparedTag.length();
        }
        if (this.event instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = analyzeScalar(((ScalarEvent) this.event).getValue());
            }
            length += this.analysis.scalar.length();
        }
        if (length < 128) {
            return (this.event instanceof AliasEvent) || !(!(this.event instanceof ScalarEvent) || this.analysis.empty || this.analysis.multiline) || checkEmptySequence() || checkEmptyMapping();
        }
        return false;
    }

    private void processAnchor(String str) throws IOException {
        NodeEvent nodeEvent = (NodeEvent) this.event;
        if (nodeEvent.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(nodeEvent.getAnchor());
        }
        writeIndicator(str + this.preparedAnchor, true, false, false);
        this.preparedAnchor = null;
    }

    private void processTag() throws IOException {
        String tag;
        if (this.event instanceof ScalarEvent) {
            ScalarEvent scalarEvent = (ScalarEvent) this.event;
            tag = scalarEvent.getTag();
            if (this.style == null) {
                this.style = chooseScalarStyle();
            }
            if ((!this.canonical.booleanValue() || tag == null) && ((this.style == null && scalarEvent.getImplicit().canOmitTagInPlainScalar()) || (this.style != null && scalarEvent.getImplicit().canOmitTagInNonPlainScalar()))) {
                this.preparedTag = null;
                return;
            } else if (scalarEvent.getImplicit().canOmitTagInPlainScalar() && tag == null) {
                tag = "!";
                this.preparedTag = null;
            }
        } else {
            CollectionStartEvent collectionStartEvent = (CollectionStartEvent) this.event;
            tag = collectionStartEvent.getTag();
            if ((!this.canonical.booleanValue() || tag == null) && collectionStartEvent.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (tag == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = prepareTag(tag);
        }
        writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }

    private Character chooseScalarStyle() {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if ((scalarEvent.getStyle() != null && scalarEvent.getStyle().charValue() == '\"') || this.canonical.booleanValue()) {
            return '\"';
        }
        if (scalarEvent.getStyle() == null && scalarEvent.getImplicit().canOmitTagInPlainScalar() && (!this.simpleKeyContext || (!this.analysis.empty && !this.analysis.multiline))) {
            if (this.flowLevel != 0 && this.analysis.allowFlowPlain) {
                return null;
            }
            if (this.flowLevel == 0 && this.analysis.allowBlockPlain) {
                return null;
            }
        }
        if (scalarEvent.getStyle() != null && ((scalarEvent.getStyle().charValue() == '|' || scalarEvent.getStyle().charValue() == '>') && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.allowBlock)) {
            return scalarEvent.getStyle();
        }
        if ((scalarEvent.getStyle() == null || scalarEvent.getStyle().charValue() == '\'') && this.analysis.allowSingleQuoted && (!this.simpleKeyContext || !this.analysis.multiline)) {
            return '\'';
        }
        return '\"';
    }

    private void processScalar() throws IOException {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if (this.style == null) {
            this.style = chooseScalarStyle();
        }
        this.style = this.options.calculateScalarStyle(this.analysis, DumperOptions.ScalarStyle.createStyle(this.style)).getChar();
        boolean z = !this.simpleKeyContext;
        if (this.style == null) {
            writePlain(this.analysis.scalar, z);
        } else {
            char cCharValue = this.style.charValue();
            if (cCharValue == '\"') {
                writeDoubleQuoted(this.analysis.scalar, z);
            } else if (cCharValue == '\'') {
                writeSingleQuoted(this.analysis.scalar, z);
            } else if (cCharValue == '>') {
                writeFolded(this.analysis.scalar);
            } else if (cCharValue == '|') {
                writeLiteral(this.analysis.scalar);
            } else {
                throw new YAMLException("Unexpected style: " + this.style);
            }
        }
        this.analysis = null;
        this.style = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareVersion(Integer[] numArr) {
        Integer num = numArr[0];
        Integer num2 = numArr[1];
        if (num.intValue() != 1) {
            throw new EmitterException("unsupported YAML version: " + numArr[0] + "." + numArr[1]);
        }
        return num.toString() + "." + num2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagHandle(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (str.charAt(0) != '!' || str.charAt(str.length() - 1) != '!') {
            throw new EmitterException("tag handle must start and end with '!': " + str);
        }
        if ("!".equals(str) || HANDLE_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the tag handle: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagPrefix(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag prefix must not be empty");
        }
        StringBuilder sb = new StringBuilder();
        int i = str.charAt(0) == '!' ? 1 : 0;
        while (i < str.length()) {
            i++;
        }
        if (i > 0) {
            sb.append(str.substring(0, i));
        }
        return sb.toString();
    }

    private String prepareTag(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.tagPrefixes.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = this.tagPrefixes.get(str2);
        }
        int length = str.length();
        String strSubstring = length > 0 ? str.substring(0, length) : BuildConfig.FLAVOR;
        if (str2 != null) {
            return str2 + strSubstring;
        }
        return "!<" + strSubstring + ">";
    }

    static String prepareAnchor(String str) {
        if (str.length() == 0) {
            throw new EmitterException("anchor must not be empty");
        }
        if (ANCHOR_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the anchor: " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.yaml.snakeyaml.emitter.ScalarAnalysis analyzeScalar(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.emitter.Emitter.analyzeScalar(java.lang.String):org.yaml.snakeyaml.emitter.ScalarAnalysis");
    }

    void flushStream() throws IOException {
        this.stream.flush();
    }

    void writeStreamEnd() throws IOException {
        flushStream();
    }

    void writeIndicator(String str, boolean z, boolean z2, boolean z3) throws IOException {
        if (!this.whitespace && z) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = z2;
        this.indention = this.indention && z3;
        this.column += str.length();
        this.openEnded = false;
        this.stream.write(str);
    }

    void writeIndent() throws IOException {
        int iIntValue = this.indent != null ? this.indent.intValue() : 0;
        if (!this.indention || this.column > iIntValue || (this.column == iIntValue && !this.whitespace)) {
            writeLineBreak(null);
        }
        if (this.column < iIntValue) {
            this.whitespace = true;
            char[] cArr = new char[iIntValue - this.column];
            for (int i = 0; i < cArr.length; i++) {
                cArr[i] = ' ';
            }
            this.column = iIntValue;
            this.stream.write(cArr);
        }
    }

    private void writeLineBreak(String str) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (str == null) {
            this.stream.write(this.bestLineBreak);
        } else {
            this.stream.write(str);
        }
    }

    void writeVersionDirective(String str) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(str);
        writeLineBreak(null);
    }

    void writeTagDirective(String str, String str2) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(str);
        this.stream.write(SPACE);
        this.stream.write(str2);
        writeLineBreak(null);
    }

    private void writeSingleQuoted(String str, boolean z) throws IOException {
        writeIndicator("'", true, false, false);
        int i = 0;
        boolean z2 = false;
        boolean zHas = false;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (cCharAt == 0 || cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z && i2 != 0 && i != str.length()) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 '") && i2 < i) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                i2 = i;
            }
            if (cCharAt == '\'') {
                this.column += 2;
                this.stream.write("''");
                i2 = i + 1;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
        writeIndicator("'", false, false, false);
    }

    private void writeDoubleQuoted(String str, boolean z) throws IOException {
        String strValueOf;
        String str2;
        writeIndicator("\"", true, false, false);
        int i = 0;
        int i2 = 0;
        while (i <= str.length()) {
            Character chValueOf = i < str.length() ? Character.valueOf(str.charAt(i)) : null;
            if (chValueOf == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(chValueOf.charValue()) != -1 || ' ' > chValueOf.charValue() || chValueOf.charValue() > '~') {
                if (i2 < i) {
                    int i3 = i - i2;
                    this.column += i3;
                    this.stream.write(str, i2, i3);
                    i2 = i;
                }
                if (chValueOf != null) {
                    if (ESCAPE_REPLACEMENTS.containsKey(chValueOf)) {
                        strValueOf = "\\" + ESCAPE_REPLACEMENTS.get(chValueOf);
                    } else if (!this.allowUnicode) {
                        if (chValueOf.charValue() <= 255) {
                            strValueOf = "\\x" + ("0" + Integer.toString(chValueOf.charValue(), 16)).substring(r3.length() - 2);
                        } else {
                            strValueOf = "\\u" + ("000" + Integer.toString(chValueOf.charValue(), 16)).substring(r3.length() - 4);
                        }
                    } else {
                        strValueOf = String.valueOf(chValueOf);
                    }
                    this.column += strValueOf.length();
                    this.stream.write(strValueOf);
                    i2 = i + 1;
                }
            }
            if (i > 0 && i < str.length() - 1 && ((chValueOf.charValue() == ' ' || i2 >= i) && this.column + (i - i2) > this.bestWidth && z)) {
                if (i2 >= i) {
                    str2 = "\\";
                } else {
                    str2 = str.substring(i2, i) + "\\";
                }
                if (i2 < i) {
                    i2 = i;
                }
                this.column += str2.length();
                this.stream.write(str2);
                writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (str.charAt(i2) == ' ') {
                    this.column += "\\".length();
                    this.stream.write("\\");
                }
            }
            i++;
        }
        writeIndicator("\"", false, false, false);
    }

    private String determineBlockHints(String str) {
        StringBuilder sb = new StringBuilder();
        if (Constant.LINEBR.has(str.charAt(0), " ")) {
            sb.append(this.bestIndent);
        }
        if (Constant.LINEBR.hasNo(str.charAt(str.length() - 1))) {
            sb.append("-");
        } else if (str.length() == 1 || Constant.LINEBR.has(str.charAt(str.length() - 2))) {
            sb.append("+");
        }
        return sb.toString();
    }

    void writeFolded(String str) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        writeIndicator(">" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        writeLineBreak(null);
        int i = 0;
        boolean zHas = true;
        boolean z = false;
        boolean z2 = true;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (!z2 && cCharAt != 0 && cCharAt != ' ' && str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    z2 = cCharAt == ' ';
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (z) {
                if (cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
                z = cCharAt == ' ';
            }
            i++;
        }
    }

    void writeLiteral(String str) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        boolean zHas = true;
        writeIndicator("|" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        writeLineBreak(null);
        int i = 0;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (cCharAt == 0 || Constant.LINEBR.has(cCharAt)) {
                this.stream.write(str, i2, i - i2);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
    }

    void writePlain(String str, boolean z) throws IOException {
        if (this.rootContext) {
            this.openEnded = true;
        }
        if (str.length() == 0) {
            return;
        }
        if (!this.whitespace) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = false;
        this.indention = false;
        int i = 0;
        boolean z2 = false;
        boolean zHas = false;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z) {
                        writeIndent();
                        this.whitespace = false;
                        this.indention = false;
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (zHas) {
                if (Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    this.whitespace = false;
                    this.indention = false;
                    i2 = i;
                }
            } else if (cCharAt == 0 || Constant.LINEBR.has(cCharAt)) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                i2 = i;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
    }
}
