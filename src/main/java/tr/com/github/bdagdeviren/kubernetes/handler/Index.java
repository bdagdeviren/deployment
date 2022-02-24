package tr.com.github.bdagdeviren.kubernetes.handler;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.router.RouterNanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;
import org.tinylog.Logger;
import tr.com.github.bdagdeviren.kubernetes.handler.impl.NotFound;

import java.io.*;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.MIME_PLAINTEXT;

public class Index extends DefaultHandler {
    public String getText() {
        throw new IllegalStateException("this method should not be called");
    }

    public String getMimeType() {
        throw new IllegalStateException("this method should not be called");
    }

    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        String baseUri = uriResource.getUri();
        String realUri = RouterNanoHTTPD.normalizeUri(session.getUri());

        for(int index = 0; index < Math.min(baseUri.length(), realUri.length()); ++index) {
            if (baseUri.charAt(index) != realUri.charAt(index)) {
                realUri = RouterNanoHTTPD.normalizeUri(realUri.substring(index));
                break;
            }
        }

        if (realUri.equals("")) {
            realUri = "ui/index.html";
        }else {
            realUri = "ui/"+baseUri.replaceAll(":name",realUri);
        }

        InputStream in = Index.class.getClassLoader().getResourceAsStream(realUri);

        if (in != null) {
            Logger.debug("Getting file to path -> " + realUri);
            return NanoHTTPD.newChunkedResponse(this.getStatus(), NanoHTTPD.getMimeTypeForFile(realUri), in);
        } else {
            return new NotFound().get(uriResource, urlParams, session);
        }

    }

    protected BufferedInputStream fileToInputStream(File fileOrdirectory) throws IOException {
        return new BufferedInputStream(new FileInputStream(fileOrdirectory));
    }
}
