package tr.com.github.bdagdeviren.kubernetes.handler.impl;

import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.router.RouterNanoHTTPD.Error404UriHandler;

import static fi.iki.elonen.NanoHTTPD.MIME_PLAINTEXT;

public class BadRequest extends Error404UriHandler {
    String message;

    public BadRequest(String message){
        this.message = message;
    }

    @Override
    public String getText() {
        return message;
    }

    @Override
    public String getMimeType() {
        return MIME_PLAINTEXT;
    }

    @Override
    public IStatus getStatus() {
        return Status.BAD_REQUEST;
    }
}
