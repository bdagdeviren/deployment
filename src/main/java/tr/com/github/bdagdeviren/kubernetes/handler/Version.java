package tr.com.github.bdagdeviren.kubernetes.handler;

import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;
import org.json.JSONObject;

import java.util.Locale;

import static tr.com.github.bdagdeviren.kubernetes.config.Properties.artifactID;
import static tr.com.github.bdagdeviren.kubernetes.config.Properties.version;

public class Version extends DefaultHandler {
    @Override
    public String getText() {
        return new JSONObject()
                .put("name",artifactID.substring(0,1).toUpperCase(Locale.ENGLISH)+artifactID.substring(1).toLowerCase(Locale.ENGLISH))
                .put("version",version)
                .toString();
    }

    @Override
    public String getMimeType() {
        return "application/json";
    }

    @Override
    public IStatus getStatus() {
        return Status.OK;
    }
}
