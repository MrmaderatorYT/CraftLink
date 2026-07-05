package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.DecoderException;

/* loaded from: classes.dex */
public class HttpPostRequestDecoder {

    public static class EndOfDataDecoderException extends DecoderException {
    }

    public static class ErrorDataDecoderException extends DecoderException {
    }

    public static class NotEnoughDataDecoderException extends DecoderException {
    }
}
