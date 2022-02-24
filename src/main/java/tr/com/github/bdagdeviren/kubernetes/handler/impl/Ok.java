package tr.com.github.bdagdeviren.kubernetes.handler.impl;

import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.router.RouterNanoHTTPD;

import static fi.iki.elonen.NanoHTTPD.MIME_PLAINTEXT;

public class Ok extends RouterNanoHTTPD.Error404UriHandler {
    String message;

    public Ok(String message){
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
        return Status.OK;
    }
}
