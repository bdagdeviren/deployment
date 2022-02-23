package tr.com.github.bdagdeviren.kubernetes.handler;

import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;

import static fi.iki.elonen.NanoHTTPD.MIME_PLAINTEXT;

public class Index extends DefaultHandler {
    @Override
    public String getText() {
        return "UserA, UserB, UserC";
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
