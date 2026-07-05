package org.yaml.snakeyaml.error;

/* loaded from: classes.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private String context;
    private Mark contextMark;
    private String note;
    private String problem;
    private Mark problemMark;

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3) {
        this(str, mark, str2, mark2, str3, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3, Throwable th) {
        super(str + "; " + str2, th);
        this.context = str;
        this.contextMark = mark;
        this.problem = str2;
        this.problemMark = mark2;
        this.note = str3;
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        this(str, mark, str2, mark2, null, th);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.context != null) {
            sb.append(this.context);
            sb.append("\n");
        }
        if (this.contextMark != null && (this.problem == null || this.problemMark == null || this.contextMark.getName().equals(this.problemMark.getName()) || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            sb.append(this.contextMark.toString());
            sb.append("\n");
        }
        if (this.problem != null) {
            sb.append(this.problem);
            sb.append("\n");
        }
        if (this.problemMark != null) {
            sb.append(this.problemMark.toString());
            sb.append("\n");
        }
        if (this.note != null) {
            sb.append(this.note);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getContext() {
        return this.context;
    }

    public Mark getContextMark() {
        return this.contextMark;
    }

    public String getProblem() {
        return this.problem;
    }

    public Mark getProblemMark() {
        return this.problemMark;
    }
}
