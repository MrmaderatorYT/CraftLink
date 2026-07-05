package org.yaml.snakeyaml.scanner;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.BlockMappingStartToken;
import org.yaml.snakeyaml.tokens.BlockSequenceStartToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import org.yaml.snakeyaml.tokens.DocumentStartToken;
import org.yaml.snakeyaml.tokens.FlowEntryToken;
import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
import org.yaml.snakeyaml.tokens.KeyToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.ValueToken;
import org.yaml.snakeyaml.util.ArrayStack;
import org.yaml.snakeyaml.util.UriEncoder;

/* loaded from: classes.dex */
public final class ScannerImpl implements Scanner {
    private final StreamReader reader;
    private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
    public static final Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap();
    public static final Map<Character, Integer> ESCAPE_CODES = new HashMap();
    private boolean done = false;
    private int flowLevel = 0;
    private int tokensTaken = 0;
    private int indent = -1;
    private boolean allowSimpleKey = true;
    private List<Token> tokens = new ArrayList(100);
    private ArrayStack<Integer> indents = new ArrayStack<>(10);
    private Map<Integer, SimpleKey> possibleSimpleKeys = new LinkedHashMap();

    static {
        ESCAPE_REPLACEMENTS.put('0', "\u0000");
        ESCAPE_REPLACEMENTS.put('a', "\u0007");
        ESCAPE_REPLACEMENTS.put('b', "\b");
        ESCAPE_REPLACEMENTS.put('t', "\t");
        ESCAPE_REPLACEMENTS.put('n', "\n");
        ESCAPE_REPLACEMENTS.put('v', "\u000b");
        ESCAPE_REPLACEMENTS.put('f', "\f");
        ESCAPE_REPLACEMENTS.put('r', "\r");
        ESCAPE_REPLACEMENTS.put('e', "\u001b");
        ESCAPE_REPLACEMENTS.put(' ', " ");
        ESCAPE_REPLACEMENTS.put('\"', "\"");
        ESCAPE_REPLACEMENTS.put('\\', "\\");
        ESCAPE_REPLACEMENTS.put('N', "\u0085");
        ESCAPE_REPLACEMENTS.put('_', " ");
        ESCAPE_REPLACEMENTS.put('L', "\u2028");
        ESCAPE_REPLACEMENTS.put('P', "\u2029");
        ESCAPE_CODES.put('x', 2);
        ESCAPE_CODES.put('u', 4);
        ESCAPE_CODES.put('U', 8);
    }

    public ScannerImpl(StreamReader streamReader) {
        this.reader = streamReader;
        fetchStreamStart();
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public boolean checkToken(Token.ID... idArr) throws IOException, NumberFormatException {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        if (!this.tokens.isEmpty()) {
            if (idArr.length == 0) {
                return true;
            }
            Token.ID tokenId = this.tokens.get(0).getTokenId();
            for (Token.ID id : idArr) {
                if (tokenId == id) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token peekToken() throws IOException, NumberFormatException {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return this.tokens.get(0);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token getToken() {
        if (this.tokens.isEmpty()) {
            return null;
        }
        this.tokensTaken++;
        return this.tokens.remove(0);
    }

    private boolean needMoreTokens() {
        if (this.done) {
            return false;
        }
        if (this.tokens.isEmpty()) {
            return true;
        }
        stalePossibleSimpleKeys();
        return nextPossibleSimpleKey() == this.tokensTaken;
    }

    private void fetchMoreTokens() throws IOException, NumberFormatException {
        scanToNextToken();
        stalePossibleSimpleKeys();
        unwindIndent(this.reader.getColumn());
        char cPeek = this.reader.peek();
        switch (cPeek) {
            case 0:
                fetchStreamEnd();
                return;
            case '!':
                fetchTag();
                return;
            case '\"':
                fetchDouble();
                return;
            case '%':
                if (checkDirective()) {
                    fetchDirective();
                    return;
                }
                break;
            case '&':
                fetchAnchor();
                return;
            case '\'':
                fetchSingle();
                return;
            case '*':
                fetchAlias();
                return;
            case ',':
                fetchFlowEntry();
                return;
            case '-':
                if (checkDocumentStart()) {
                    fetchDocumentStart();
                    return;
                } else if (checkBlockEntry()) {
                    fetchBlockEntry();
                    return;
                }
                break;
            case '.':
                if (checkDocumentEnd()) {
                    fetchDocumentEnd();
                    return;
                }
                break;
            case ':':
                if (checkValue()) {
                    fetchValue();
                    return;
                }
                break;
            case '>':
                if (this.flowLevel == 0) {
                    fetchFolded();
                    return;
                }
                break;
            case '?':
                if (checkKey()) {
                    fetchKey();
                    return;
                }
                break;
            case '[':
                fetchFlowSequenceStart();
                return;
            case ']':
                fetchFlowSequenceEnd();
                return;
            case '{':
                fetchFlowMappingStart();
                return;
            case '|':
                if (this.flowLevel == 0) {
                    fetchLiteral();
                    return;
                }
                break;
            case '}':
                fetchFlowMappingEnd();
                return;
        }
        if (checkPlain()) {
            fetchPlain();
            return;
        }
        String strValueOf = String.valueOf(cPeek);
        Iterator<Character> it = ESCAPE_REPLACEMENTS.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Character next = it.next();
                if (ESCAPE_REPLACEMENTS.get(next).equals(strValueOf)) {
                    strValueOf = "\\" + next;
                }
            }
        }
        throw new ScannerException("while scanning for the next token", null, "found character " + cPeek + "'" + strValueOf + "' that cannot start any token", this.reader.getMark());
    }

    private int nextPossibleSimpleKey() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return -1;
        }
        return this.possibleSimpleKeys.values().iterator().next().getTokenNumber();
    }

    private void stalePossibleSimpleKeys() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return;
        }
        Iterator<SimpleKey> it = this.possibleSimpleKeys.values().iterator();
        while (it.hasNext()) {
            SimpleKey next = it.next();
            if (next.getLine() != this.reader.getLine() || this.reader.getIndex() - next.getIndex() > 1024) {
                if (next.isRequired()) {
                    throw new ScannerException("while scanning a simple key", next.getMark(), "could not found expected ':'", this.reader.getMark());
                }
                it.remove();
            }
        }
    }

    private void savePossibleSimpleKey() {
        boolean z = this.flowLevel == 0 && this.indent == this.reader.getColumn();
        if (!this.allowSimpleKey && z) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (this.allowSimpleKey) {
            removePossibleSimpleKey();
            this.possibleSimpleKeys.put(Integer.valueOf(this.flowLevel), new SimpleKey(this.tokensTaken + this.tokens.size(), z, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark()));
        }
    }

    private void removePossibleSimpleKey() {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null && simpleKeyRemove.isRequired()) {
            throw new ScannerException("while scanning a simple key", simpleKeyRemove.getMark(), "could not found expected ':'", this.reader.getMark());
        }
    }

    private void unwindIndent(int i) {
        if (this.flowLevel != 0) {
            return;
        }
        while (this.indent > i) {
            Mark mark = this.reader.getMark();
            this.indent = this.indents.pop().intValue();
            this.tokens.add(new BlockEndToken(mark, mark));
        }
    }

    private boolean addIndent(int i) {
        if (this.indent >= i) {
            return false;
        }
        this.indents.push(Integer.valueOf(this.indent));
        this.indent = i;
        return true;
    }

    private void fetchStreamStart() {
        Mark mark = this.reader.getMark();
        this.tokens.add(new StreamStartToken(mark, mark));
    }

    private void fetchStreamEnd() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.possibleSimpleKeys.clear();
        Mark mark = this.reader.getMark();
        this.tokens.add(new StreamEndToken(mark, mark));
        this.done = true;
    }

    private void fetchDirective() throws IOException {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanDirective());
    }

    private void fetchDocumentStart() throws IOException {
        fetchDocumentIndicator(true);
    }

    private void fetchDocumentEnd() throws IOException {
        fetchDocumentIndicator(false);
    }

    private void fetchDocumentIndicator(boolean z) throws IOException {
        Token documentEndToken;
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward(3);
        Mark mark2 = this.reader.getMark();
        if (z) {
            documentEndToken = new DocumentStartToken(mark, mark2);
        } else {
            documentEndToken = new DocumentEndToken(mark, mark2);
        }
        this.tokens.add(documentEndToken);
    }

    private void fetchFlowSequenceStart() throws IOException {
        fetchFlowCollectionStart(false);
    }

    private void fetchFlowMappingStart() throws IOException {
        fetchFlowCollectionStart(true);
    }

    private void fetchFlowCollectionStart(boolean z) throws IOException {
        Token flowSequenceStartToken;
        savePossibleSimpleKey();
        this.flowLevel++;
        this.allowSimpleKey = true;
        Mark mark = this.reader.getMark();
        this.reader.forward(1);
        Mark mark2 = this.reader.getMark();
        if (z) {
            flowSequenceStartToken = new FlowMappingStartToken(mark, mark2);
        } else {
            flowSequenceStartToken = new FlowSequenceStartToken(mark, mark2);
        }
        this.tokens.add(flowSequenceStartToken);
    }

    private void fetchFlowSequenceEnd() throws IOException {
        fetchFlowCollectionEnd(false);
    }

    private void fetchFlowMappingEnd() throws IOException {
        fetchFlowCollectionEnd(true);
    }

    private void fetchFlowCollectionEnd(boolean z) throws IOException {
        Token flowSequenceEndToken;
        removePossibleSimpleKey();
        this.flowLevel--;
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward();
        Mark mark2 = this.reader.getMark();
        if (z) {
            flowSequenceEndToken = new FlowMappingEndToken(mark, mark2);
        } else {
            flowSequenceEndToken = new FlowSequenceEndToken(mark, mark2);
        }
        this.tokens.add(flowSequenceEndToken);
    }

    private void fetchFlowEntry() throws IOException {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark = this.reader.getMark();
        this.reader.forward();
        this.tokens.add(new FlowEntryToken(mark, this.reader.getMark()));
    }

    private void fetchBlockEntry() throws IOException {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                this.tokens.add(new BlockSequenceStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        this.tokens.add(new BlockEntryToken(mark2, this.reader.getMark()));
    }

    private void fetchKey() throws IOException {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                this.tokens.add(new BlockMappingStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = this.flowLevel == 0;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        this.tokens.add(new KeyToken(mark2, this.reader.getMark()));
    }

    private void fetchValue() throws IOException {
        SimpleKey simpleKeyRemove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (simpleKeyRemove != null) {
            this.tokens.add(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new KeyToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            if (this.flowLevel == 0 && addIndent(simpleKeyRemove.getColumn())) {
                this.tokens.add(simpleKeyRemove.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(simpleKeyRemove.getMark(), simpleKeyRemove.getMark()));
            }
            this.allowSimpleKey = false;
        } else {
            if (this.flowLevel == 0 && !this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
            }
            if (this.flowLevel == 0 && addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                this.tokens.add(new BlockMappingStartToken(mark, mark));
            }
            this.allowSimpleKey = this.flowLevel == 0;
            removePossibleSimpleKey();
        }
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        this.tokens.add(new ValueToken(mark2, this.reader.getMark()));
    }

    private void fetchAlias() throws IOException {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanAnchor(false));
    }

    private void fetchAnchor() throws IOException {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanAnchor(true));
    }

    private void fetchTag() throws IOException {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanTag());
    }

    private void fetchLiteral() throws IOException, NumberFormatException {
        fetchBlockScalar('|');
    }

    private void fetchFolded() throws IOException, NumberFormatException {
        fetchBlockScalar('>');
    }

    private void fetchBlockScalar(char c) throws IOException, NumberFormatException {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        this.tokens.add(scanBlockScalar(c));
    }

    private void fetchSingle() throws IOException {
        fetchFlowScalar('\'');
    }

    private void fetchDouble() throws IOException {
        fetchFlowScalar('\"');
    }

    private void fetchFlowScalar(char c) throws IOException {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanFlowScalar(c));
    }

    private void fetchPlain() throws IOException {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.tokens.add(scanPlain());
    }

    private boolean checkDirective() {
        return this.reader.getColumn() == 0;
    }

    private boolean checkDocumentStart() {
        return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkDocumentEnd() {
        return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkBlockEntry() {
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkKey() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkValue() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkPlain() {
        char cPeek = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(cPeek, "-?:,[]{}#&*!|>'\"%@`")) {
            return true;
        }
        if (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1))) {
            if (cPeek == '-') {
                return true;
            }
            if (this.flowLevel == 0 && "?:".indexOf(cPeek) != -1) {
                return true;
            }
        }
        return false;
    }

    private void scanToNextToken() throws IOException {
        if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
            this.reader.forward();
        }
        boolean z = false;
        while (!z) {
            int i = 0;
            while (this.reader.peek(i) == ' ') {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
            if (this.reader.peek() == '#') {
                int i2 = 0;
                while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i2))) {
                    i2++;
                }
                if (i2 > 0) {
                    this.reader.forward(i2);
                }
            }
            if (scanLineBreak().length() == 0) {
                z = true;
            } else if (this.flowLevel == 0) {
                this.allowSimpleKey = true;
            }
        }
    }

    private Token scanDirective() throws IOException {
        Mark mark;
        List listScanTagDirectiveValue;
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        String strScanDirectiveName = scanDirectiveName(mark2);
        if ("YAML".equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanYamlDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else if ("TAG".equals(strScanDirectiveName)) {
            listScanTagDirectiveValue = scanTagDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else {
            mark = this.reader.getMark();
            int i = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
            listScanTagDirectiveValue = null;
        }
        scanDirectiveIgnoredLine(mark2);
        return new DirectiveToken(strScanDirectiveName, listScanTagDirectiveValue, mark2, mark);
    }

    private String scanDirectiveName(Mark mark) throws IOException {
        int i = 0;
        char cPeek = this.reader.peek(0);
        while (Constant.ALPHA.has(cPeek)) {
            i++;
            cPeek = this.reader.peek(i);
        }
        if (i == 0) {
            throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + cPeek + "(" + ((int) cPeek) + ")", this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i);
        char cPeek2 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(cPeek2)) {
            return strPrefixForward;
        }
        throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + cPeek2 + "(" + ((int) cPeek2) + ")", this.reader.getMark());
    }

    private List<Integer> scanYamlDirectiveValue(Mark mark) throws IOException {
        while (this.reader.peek() == ' ') {
            this.reader.forward();
        }
        Integer numScanYamlDirectiveNumber = scanYamlDirectiveNumber(mark);
        if (this.reader.peek() != '.') {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or '.', but found " + this.reader.peek() + "(" + ((int) this.reader.peek()) + ")", this.reader.getMark());
        }
        this.reader.forward();
        Integer numScanYamlDirectiveNumber2 = scanYamlDirectiveNumber(mark);
        if (Constant.NULL_BL_LINEBR.hasNo(this.reader.peek())) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or ' ', but found " + this.reader.peek() + "(" + ((int) this.reader.peek()) + ")", this.reader.getMark());
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(numScanYamlDirectiveNumber);
        arrayList.add(numScanYamlDirectiveNumber2);
        return arrayList;
    }

    private Integer scanYamlDirectiveNumber(Mark mark) {
        char cPeek = this.reader.peek();
        if (!Character.isDigit(cPeek)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit, but found " + cPeek + "(" + ((int) cPeek) + ")", this.reader.getMark());
        }
        int i = 0;
        while (Character.isDigit(this.reader.peek(i))) {
            i++;
        }
        return Integer.valueOf(Integer.parseInt(this.reader.prefixForward(i)));
    }

    private List<String> scanTagDirectiveValue(Mark mark) throws IOException {
        while (this.reader.peek() == ' ') {
            this.reader.forward();
        }
        String strScanTagDirectiveHandle = scanTagDirectiveHandle(mark);
        while (this.reader.peek() == ' ') {
            this.reader.forward();
        }
        String strScanTagDirectivePrefix = scanTagDirectivePrefix(mark);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(strScanTagDirectiveHandle);
        arrayList.add(strScanTagDirectivePrefix);
        return arrayList;
    }

    private String scanTagDirectiveHandle(Mark mark) throws IOException {
        String strScanTagHandle = scanTagHandle("directive", mark);
        char cPeek = this.reader.peek();
        if (cPeek == ' ') {
            return strScanTagHandle;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + this.reader.peek() + "(" + cPeek + ")", this.reader.getMark());
    }

    private String scanTagDirectivePrefix(Mark mark) throws IOException {
        String strScanTagUri = scanTagUri("directive", mark);
        if (!Constant.NULL_BL_LINEBR.hasNo(this.reader.peek())) {
            return strScanTagUri;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + this.reader.peek() + "(" + ((int) this.reader.peek()) + ")", this.reader.getMark());
    }

    private String scanDirectiveIgnoredLine(Mark mark) throws IOException {
        int i = 0;
        int i2 = 0;
        while (this.reader.peek(i2) == ' ') {
            i2++;
        }
        if (i2 > 0) {
            this.reader.forward(i2);
        }
        if (this.reader.peek() == '#') {
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
                i++;
            }
            this.reader.forward(i);
        }
        char cPeek = this.reader.peek();
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.length() != 0 || cPeek == 0) {
            return strScanLineBreak;
        }
        throw new ScannerException("while scanning a directive", mark, "expected a comment or a line break, but found " + cPeek + "(" + ((int) cPeek) + ")", this.reader.getMark());
    }

    private Token scanAnchor(boolean z) throws IOException {
        Mark mark = this.reader.getMark();
        String str = this.reader.peek() == '*' ? "alias" : "anchor";
        this.reader.forward();
        int i = 0;
        char cPeek = this.reader.peek(0);
        while (Constant.ALPHA.has(cPeek)) {
            i++;
            cPeek = this.reader.peek(i);
        }
        if (i == 0) {
            throw new ScannerException("while scanning an " + str, mark, "expected alphabetic or numeric character, but found but found " + cPeek, this.reader.getMark());
        }
        String strPrefixForward = this.reader.prefixForward(i);
        char cPeek2 = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(cPeek2, "?:,]}%@`")) {
            throw new ScannerException("while scanning an " + str, mark, "expected alphabetic or numeric character, but found " + cPeek2 + "(" + ((int) this.reader.peek()) + ")", this.reader.getMark());
        }
        Mark mark2 = this.reader.getMark();
        if (z) {
            return new AnchorToken(strPrefixForward, mark, mark2);
        }
        return new AliasToken(strPrefixForward, mark, mark2);
    }

    private Token scanTag() throws IOException {
        String strScanTagHandle;
        String strScanTagUri;
        Mark mark = this.reader.getMark();
        boolean z = true;
        char cPeek = this.reader.peek(1);
        String str = null;
        if (cPeek == '<') {
            this.reader.forward(2);
            strScanTagUri = scanTagUri("tag", mark);
            if (this.reader.peek() != '>') {
                throw new ScannerException("while scanning a tag", mark, "expected '>', but found '" + this.reader.peek() + "' (" + ((int) this.reader.peek()) + ")", this.reader.getMark());
            }
            this.reader.forward();
        } else if (Constant.NULL_BL_T_LINEBR.has(cPeek)) {
            strScanTagUri = "!";
            this.reader.forward();
        } else {
            int i = 1;
            while (true) {
                if (!Constant.NULL_BL_LINEBR.hasNo(cPeek)) {
                    z = false;
                    break;
                }
                if (cPeek == '!') {
                    break;
                }
                i++;
                cPeek = this.reader.peek(i);
            }
            if (z) {
                strScanTagHandle = scanTagHandle("tag", mark);
            } else {
                strScanTagHandle = "!";
                this.reader.forward();
            }
            str = strScanTagHandle;
            strScanTagUri = scanTagUri("tag", mark);
        }
        char cPeek2 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(cPeek2)) {
            throw new ScannerException("while scanning a tag", mark, "expected ' ', but found '" + cPeek2 + "' (" + ((int) cPeek2) + ")", this.reader.getMark());
        }
        return new TagToken(new TagTuple(str, strScanTagUri), mark, this.reader.getMark());
    }

    private Token scanBlockScalar(char c) throws IOException, NumberFormatException {
        int iMax;
        String str;
        Mark mark;
        Mark mark2;
        boolean z = c == '>';
        StringBuilder sb = new StringBuilder();
        Mark mark3 = this.reader.getMark();
        this.reader.forward();
        Chomping chompingScanBlockScalarIndicators = scanBlockScalarIndicators(mark3);
        int increment = chompingScanBlockScalarIndicators.getIncrement();
        scanBlockScalarIgnoredLine(mark3);
        int i = this.indent + 1;
        if (i < 1) {
            i = 1;
        }
        if (increment == -1) {
            Object[] objArrScanBlockScalarIndentation = scanBlockScalarIndentation();
            str = (String) objArrScanBlockScalarIndentation[0];
            int iIntValue = ((Integer) objArrScanBlockScalarIndentation[1]).intValue();
            mark = (Mark) objArrScanBlockScalarIndentation[2];
            iMax = Math.max(i, iIntValue);
        } else {
            iMax = (i + increment) - 1;
            Object[] objArrScanBlockScalarBreaks = scanBlockScalarBreaks(iMax);
            str = (String) objArrScanBlockScalarBreaks[0];
            mark = (Mark) objArrScanBlockScalarBreaks[1];
        }
        String strScanLineBreak = BuildConfig.FLAVOR;
        while (this.reader.getColumn() == iMax && this.reader.peek() != 0) {
            sb.append(str);
            boolean z2 = " \t".indexOf(this.reader.peek()) == -1;
            int i2 = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i2))) {
                i2++;
            }
            sb.append(this.reader.prefixForward(i2));
            strScanLineBreak = scanLineBreak();
            Object[] objArrScanBlockScalarBreaks2 = scanBlockScalarBreaks(iMax);
            String str2 = (String) objArrScanBlockScalarBreaks2[0];
            Mark mark4 = (Mark) objArrScanBlockScalarBreaks2[1];
            if (this.reader.getColumn() != iMax || this.reader.peek() == 0) {
                mark2 = mark4;
                str = str2;
                break;
            }
            if (z && "\n".equals(strScanLineBreak) && z2 && " \t".indexOf(this.reader.peek()) == -1) {
                if (str2.length() == 0) {
                    sb.append(" ");
                }
            } else {
                sb.append(strScanLineBreak);
            }
            mark = mark4;
            str = str2;
        }
        mark2 = mark;
        if (chompingScanBlockScalarIndicators.chompTailIsNotFalse()) {
            sb.append(strScanLineBreak);
        }
        if (chompingScanBlockScalarIndicators.chompTailIsTrue()) {
            sb.append(str);
        }
        return new ScalarToken(sb.toString(), false, mark3, mark2, c);
    }

    private Chomping scanBlockScalarIndicators(Mark mark) throws NumberFormatException, IOException {
        Boolean bool;
        Boolean bool2;
        char cPeek = this.reader.peek();
        Boolean bool3 = null;
        int i = -1;
        if (cPeek == '-' || cPeek == '+') {
            if (cPeek == '+') {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            bool3 = bool;
            this.reader.forward();
            char cPeek2 = this.reader.peek();
            if (Character.isDigit(cPeek2)) {
                i = Integer.parseInt(String.valueOf(cPeek2));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
            }
        } else if (Character.isDigit(cPeek)) {
            i = Integer.parseInt(String.valueOf(cPeek));
            if (i == 0) {
                throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
            }
            this.reader.forward();
            char cPeek3 = this.reader.peek();
            if (cPeek3 == '-' || cPeek3 == '+') {
                if (cPeek3 == '+') {
                    bool2 = Boolean.TRUE;
                } else {
                    bool2 = Boolean.FALSE;
                }
                bool3 = bool2;
                this.reader.forward();
            }
        }
        char cPeek4 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(cPeek4)) {
            throw new ScannerException("while scanning a block scalar", mark, "expected chomping or indentation indicators, but found " + cPeek4, this.reader.getMark());
        }
        return new Chomping(bool3, i);
    }

    private String scanBlockScalarIgnoredLine(Mark mark) throws IOException {
        int i = 0;
        int i2 = 0;
        while (this.reader.peek(i2) == ' ') {
            i2++;
        }
        if (i2 > 0) {
            this.reader.forward(i2);
        }
        if (this.reader.peek() == '#') {
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
        }
        char cPeek = this.reader.peek();
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.length() != 0 || cPeek == 0) {
            return strScanLineBreak;
        }
        throw new ScannerException("while scanning a block scalar", mark, "expected a comment or a line break, but found " + cPeek, this.reader.getMark());
    }

    private Object[] scanBlockScalarIndentation() throws IOException {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int column = 0;
        while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
            if (this.reader.peek() != ' ') {
                sb.append(scanLineBreak());
                mark = this.reader.getMark();
            } else {
                this.reader.forward();
                if (this.reader.getColumn() > column) {
                    column = this.reader.getColumn();
                }
            }
        }
        return new Object[]{sb.toString(), Integer.valueOf(column), mark};
    }

    private Object[] scanBlockScalarBreaks(int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int i2 = 0;
        for (int column = this.reader.getColumn(); column < i && this.reader.peek(i2) == ' '; column++) {
            i2++;
        }
        if (i2 > 0) {
            this.reader.forward(i2);
        }
        while (true) {
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.length() != 0) {
                sb.append(strScanLineBreak);
                mark = this.reader.getMark();
                int i3 = 0;
                for (int column2 = this.reader.getColumn(); column2 < i && this.reader.peek(i3) == ' '; column2++) {
                    i3++;
                }
                if (i3 > 0) {
                    this.reader.forward(i3);
                }
            } else {
                return new Object[]{sb.toString(), mark};
            }
        }
    }

    private Token scanFlowScalar(char c) throws IOException {
        boolean z = c == '\"';
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        char cPeek = this.reader.peek();
        this.reader.forward();
        sb.append(scanFlowScalarNonSpaces(z, mark));
        while (this.reader.peek() != cPeek) {
            sb.append(scanFlowScalarSpaces(mark));
            sb.append(scanFlowScalarNonSpaces(z, mark));
        }
        this.reader.forward();
        return new ScalarToken(sb.toString(), false, mark, this.reader.getMark(), c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0146, code lost:
    
        return r0.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String scanFlowScalarNonSpaces(boolean r6, org.yaml.snakeyaml.error.Mark r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.scanFlowScalarNonSpaces(boolean, org.yaml.snakeyaml.error.Mark):java.lang.String");
    }

    private String scanFlowScalarSpaces(Mark mark) throws IOException {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (" \t".indexOf(this.reader.peek(i)) != -1) {
            i++;
        }
        String strPrefixForward = this.reader.prefixForward(i);
        if (this.reader.peek() == 0) {
            throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", this.reader.getMark());
        }
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.length() != 0) {
            String strScanFlowScalarBreaks = scanFlowScalarBreaks(mark);
            if (!"\n".equals(strScanLineBreak)) {
                sb.append(strScanLineBreak);
            } else if (strScanFlowScalarBreaks.length() == 0) {
                sb.append(" ");
            }
            sb.append(strScanFlowScalarBreaks);
        } else {
            sb.append(strPrefixForward);
        }
        return sb.toString();
    }

    private String scanFlowScalarBreaks(Mark mark) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String strPrefix = this.reader.prefix(3);
            if (("---".equals(strPrefix) || "...".equals(strPrefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", this.reader.getMark());
            }
            while (" \t".indexOf(this.reader.peek()) != -1) {
                this.reader.forward();
            }
            String strScanLineBreak = scanLineBreak();
            if (strScanLineBreak.length() != 0) {
                sb.append(strScanLineBreak);
            } else {
                return sb.toString();
            }
        }
    }

    private Token scanPlain() throws IOException {
        char cPeek;
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int i = this.indent + 1;
        String strScanPlainSpaces = BuildConfig.FLAVOR;
        Mark mark2 = mark;
        while (this.reader.peek() != '#') {
            int i2 = 0;
            while (true) {
                cPeek = this.reader.peek(i2);
                if (Constant.NULL_BL_T_LINEBR.has(cPeek) || ((this.flowLevel == 0 && cPeek == ':' && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(i2 + 1))) || !(this.flowLevel == 0 || ",:?[]{}".indexOf(cPeek) == -1))) {
                    break;
                }
                i2++;
            }
            if (this.flowLevel != 0 && cPeek == ':' && Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(i2 + 1), ",[]{}")) {
                this.reader.forward(i2);
                throw new ScannerException("while scanning a plain scalar", mark, "found unexpected ':'", this.reader.getMark(), "Please check http://pyyaml.org/wiki/YAMLColonInFlowContext for details.");
            }
            if (i2 == 0) {
                break;
            }
            this.allowSimpleKey = false;
            sb.append(strScanPlainSpaces);
            sb.append(this.reader.prefixForward(i2));
            mark2 = this.reader.getMark();
            strScanPlainSpaces = scanPlainSpaces();
            if (strScanPlainSpaces.length() == 0 || this.reader.peek() == '#' || (this.flowLevel == 0 && this.reader.getColumn() < i)) {
                break;
            }
        }
        return new ScalarToken(sb.toString(), mark, mark2, true);
    }

    private String scanPlainSpaces() throws IOException {
        int i = 0;
        while (true) {
            if (this.reader.peek(i) != ' ' && this.reader.peek(i) != '\t') {
                break;
            }
            i++;
        }
        String strPrefixForward = this.reader.prefixForward(i);
        String strScanLineBreak = scanLineBreak();
        if (strScanLineBreak.length() == 0) {
            return strPrefixForward;
        }
        this.allowSimpleKey = true;
        String strPrefix = this.reader.prefix(3);
        if ("---".equals(strPrefix)) {
            return BuildConfig.FLAVOR;
        }
        if ("...".equals(strPrefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.reader.peek() == ' ') {
                this.reader.forward();
            } else {
                String strScanLineBreak2 = scanLineBreak();
                if (strScanLineBreak2.length() != 0) {
                    sb.append(strScanLineBreak2);
                    String strPrefix2 = this.reader.prefix(3);
                    if ("---".equals(strPrefix2)) {
                        return BuildConfig.FLAVOR;
                    }
                    if ("...".equals(strPrefix2) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                        return BuildConfig.FLAVOR;
                    }
                } else {
                    if ("\n".equals(strScanLineBreak)) {
                        return sb.length() == 0 ? " " : sb.toString();
                    }
                    return strScanLineBreak + ((Object) sb);
                }
            }
        }
    }

    private String scanTagHandle(String str, Mark mark) throws IOException {
        char cPeek = this.reader.peek();
        if (cPeek != '!') {
            throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + cPeek + "(" + ((int) cPeek) + ")", this.reader.getMark());
        }
        int i = 1;
        char cPeek2 = this.reader.peek(1);
        if (cPeek2 != ' ') {
            int i2 = 1;
            while (Constant.ALPHA.has(cPeek2)) {
                i2++;
                cPeek2 = this.reader.peek(i2);
            }
            if (cPeek2 != '!') {
                this.reader.forward(i2);
                throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + cPeek2 + "(" + ((int) cPeek2) + ")", this.reader.getMark());
            }
            i = 1 + i2;
        }
        return this.reader.prefixForward(i);
    }

    private String scanTagUri(String str, Mark mark) throws IOException {
        StringBuilder sb = new StringBuilder();
        char cPeek = this.reader.peek(0);
        int i = 0;
        while (Constant.URI_CHARS.has(cPeek)) {
            if (cPeek == '%') {
                sb.append(this.reader.prefixForward(i));
                sb.append(scanUriEscapes(str, mark));
                i = 0;
            } else {
                i++;
            }
            cPeek = this.reader.peek(i);
        }
        if (i != 0) {
            sb.append(this.reader.prefixForward(i));
        }
        if (sb.length() == 0) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI, but found " + cPeek + "(" + ((int) cPeek) + ")", this.reader.getMark());
        }
        return sb.toString();
    }

    private String scanUriEscapes(String str, Mark mark) throws IOException {
        int i = 1;
        while (this.reader.peek(i * 3) == '%') {
            i++;
        }
        Mark mark2 = this.reader.getMark();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        while (this.reader.peek() == '%') {
            this.reader.forward();
            try {
                byteBufferAllocate.put((byte) Integer.parseInt(this.reader.prefix(2), 16));
                this.reader.forward(2);
            } catch (NumberFormatException unused) {
                throw new ScannerException("while scanning a " + str, mark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + this.reader.peek() + "(" + ((int) this.reader.peek()) + ") and " + this.reader.peek(1) + "(" + ((int) this.reader.peek(1)) + ")", this.reader.getMark());
            }
        }
        byteBufferAllocate.flip();
        try {
            return UriEncoder.decode(byteBufferAllocate);
        } catch (CharacterCodingException e) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI in UTF-8: " + e.getMessage(), mark2);
        }
    }

    private String scanLineBreak() throws IOException {
        char cPeek = this.reader.peek();
        if (cPeek != '\r' && cPeek != '\n' && cPeek != 133) {
            if (cPeek != 8232 && cPeek != 8233) {
                return BuildConfig.FLAVOR;
            }
            this.reader.forward();
            return String.valueOf(cPeek);
        }
        if (cPeek == '\r' && '\n' == this.reader.peek(1)) {
            this.reader.forward(2);
            return "\n";
        }
        this.reader.forward();
        return "\n";
    }

    private static class Chomping {
        private final int increment;
        private final Boolean value;

        public Chomping(Boolean bool, int i) {
            this.value = bool;
            this.increment = i;
        }

        public boolean chompTailIsNotFalse() {
            return this.value == null || this.value.booleanValue();
        }

        public boolean chompTailIsTrue() {
            return this.value != null && this.value.booleanValue();
        }

        public int getIncrement() {
            return this.increment;
        }
    }
}
