package tr.com.github.bdagdeviren.kubernetes.server;

import org.tinylog.Logger;
import java.io.IOException;
import fi.iki.elonen.router.RouterNanoHTTPD;
import tr.com.github.bdagdeviren.kubernetes.handler.Index;
import tr.com.github.bdagdeviren.kubernetes.handler.impl.NotFound;

public class Server extends RouterNanoHTTPD {
    private final int port;

    public Server(int port) {
        super(port);
        this.port = port;
    }

    @Override
    public void addMappings() {
        Logger.info("Initialize all routes");
        setNotFoundHandler(NotFound.class);

        addRoute("/", Index.class);
        Logger.info("Successfully initialize all routes");
    }

    public void startServer() {
        try {
            addMappings();
            start(SOCKET_READ_TIMEOUT, false);
            Logger.info("Running! Point your browsers to :"+ port);
        } catch (IOException ioe) {
            Logger.error("Couldn't start server -> " + ioe.getMessage());
        }
    }
}
