package tr.com.github.bdagdeviren.kubernetes.handler.impl;

import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;

public class NotFound extends DefaultHandler {

    public String getText() {
        return "<html><body><div>404 Not Found</div></body></html>";
    }

    public String getMimeType() {
        return "text/html";
    }

    public IStatus getStatus() {
        return Status.NOT_FOUND;
    }
}
