package org.yaml.snakeyaml;

import java.util.Map;
import java.util.TimeZone;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
public class DumperOptions {
    private ScalarStyle defaultStyle = ScalarStyle.PLAIN;
    private FlowStyle defaultFlowStyle = FlowStyle.AUTO;
    private boolean canonical = false;
    private boolean allowUnicode = true;
    private boolean allowReadOnlyProperties = false;
    private int indent = 2;
    private int bestWidth = 80;
    private LineBreak lineBreak = LineBreak.UNIX;
    private boolean explicitStart = false;
    private boolean explicitEnd = false;
    private TimeZone timeZone = null;
    private Tag explicitRoot = null;
    private Version version = null;
    private Map<String, String> tags = null;
    private Boolean prettyFlow = false;

    public ScalarStyle calculateScalarStyle(ScalarAnalysis scalarAnalysis, ScalarStyle scalarStyle) {
        return scalarStyle;
    }

    public enum ScalarStyle {
        DOUBLE_QUOTED('\"'),
        SINGLE_QUOTED('\''),
        LITERAL('|'),
        FOLDED('>'),
        PLAIN(null);

        private Character styleChar;

        ScalarStyle(Character ch) {
            this.styleChar = ch;
        }

        public Character getChar() {
            return this.styleChar;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Scalar style: '" + this.styleChar + "'";
        }

        public static ScalarStyle createStyle(Character ch) {
            if (ch == null) {
                return PLAIN;
            }
            char cCharValue = ch.charValue();
            if (cCharValue == '\"') {
                return DOUBLE_QUOTED;
            }
            if (cCharValue == '\'') {
                return SINGLE_QUOTED;
            }
            if (cCharValue == '>') {
                return FOLDED;
            }
            if (cCharValue == '|') {
                return LITERAL;
            }
            throw new YAMLException("Unknown scalar style character: " + ch);
        }
    }

    public enum FlowStyle {
        FLOW(Boolean.TRUE),
        BLOCK(Boolean.FALSE),
        AUTO(null);

        private Boolean styleBoolean;

        FlowStyle(Boolean bool) {
            this.styleBoolean = bool;
        }

        public Boolean getStyleBoolean() {
            return this.styleBoolean;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Flow style: '" + this.styleBoolean + "'";
        }
    }

    public enum LineBreak {
        WIN("\r\n"),
        MAC("\r"),
        UNIX("\n");

        private String lineBreak;

        LineBreak(String str) {
            this.lineBreak = str;
        }

        public String getString() {
            return this.lineBreak;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Line break: " + name();
        }

        public static LineBreak getPlatformLineBreak() {
            String property = System.getProperty("line.separator");
            for (LineBreak lineBreak : values()) {
                if (lineBreak.lineBreak.equals(property)) {
                    return lineBreak;
                }
            }
            return UNIX;
        }
    }

    public enum Version {
        V1_0(new Integer[]{1, 0}),
        V1_1(new Integer[]{1, 1});

        private Integer[] version;

        Version(Integer[] numArr) {
            this.version = numArr;
        }

        public Integer[] getArray() {
            return this.version;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Version: " + this.version[0] + "." + this.version[1];
        }
    }

    public boolean isAllowUnicode() {
        return this.allowUnicode;
    }

    public void setAllowUnicode(boolean z) {
        this.allowUnicode = z;
    }

    public ScalarStyle getDefaultScalarStyle() {
        return this.defaultStyle;
    }

    public void setDefaultScalarStyle(ScalarStyle scalarStyle) {
        if (scalarStyle == null) {
            throw new NullPointerException("Use ScalarStyle enum.");
        }
        this.defaultStyle = scalarStyle;
    }

    public void setIndent(int i) {
        if (i < 1) {
            throw new YAMLException("Indent must be at least 1");
        }
        if (i > 10) {
            throw new YAMLException("Indent must be at most 10");
        }
        this.indent = i;
    }

    public int getIndent() {
        return this.indent;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Version getVersion() {
        return this.version;
    }

    public void setCanonical(boolean z) {
        this.canonical = z;
    }

    public boolean isCanonical() {
        return this.canonical;
    }

    public void setPrettyFlow(boolean z) {
        this.prettyFlow = Boolean.valueOf(z);
    }

    public boolean isPrettyFlow() {
        return this.prettyFlow.booleanValue();
    }

    public void setWidth(int i) {
        this.bestWidth = i;
    }

    public int getWidth() {
        return this.bestWidth;
    }

    public LineBreak getLineBreak() {
        return this.lineBreak;
    }

    public void setDefaultFlowStyle(FlowStyle flowStyle) {
        if (flowStyle == null) {
            throw new NullPointerException("Use FlowStyle enum.");
        }
        this.defaultFlowStyle = flowStyle;
    }

    public FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }

    public Tag getExplicitRoot() {
        return this.explicitRoot;
    }

    public void setExplicitRoot(String str) {
        setExplicitRoot(new Tag(str));
    }

    public void setExplicitRoot(Tag tag) {
        if (tag == null) {
            throw new NullPointerException("Root tag must be specified.");
        }
        this.explicitRoot = tag;
    }

    public void setLineBreak(LineBreak lineBreak) {
        if (lineBreak == null) {
            throw new NullPointerException("Specify line break.");
        }
        this.lineBreak = lineBreak;
    }

    public boolean isExplicitStart() {
        return this.explicitStart;
    }

    public void setExplicitStart(boolean z) {
        this.explicitStart = z;
    }

    public boolean isExplicitEnd() {
        return this.explicitEnd;
    }

    public void setExplicitEnd(boolean z) {
        this.explicitEnd = z;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }

    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }

    public void setAllowReadOnlyProperties(boolean z) {
        this.allowReadOnlyProperties = z;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
