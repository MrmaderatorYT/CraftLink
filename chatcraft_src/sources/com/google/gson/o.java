package com.google.gson;

import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser.java */
/* loaded from: classes.dex */
public final class o {
    public l a(String str) {
        return a(new StringReader(str));
    }

    public l a(Reader reader) {
        try {
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
            l lVarA = a(aVar);
            if (!lVarA.k() && aVar.f() != com.google.gson.stream.b.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return lVarA;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public l a(com.google.gson.stream.a aVar) {
        boolean zQ = aVar.q();
        aVar.a(true);
        try {
            try {
                try {
                    return com.google.gson.b.l.a(aVar);
                } catch (StackOverflowError e) {
                    throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e);
                }
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e2);
            }
        } finally {
            aVar.a(zQ);
        }
    }
}
