package tr.com.github.bdagdeviren.kubernetes.server;

import org.tinylog.Logger;
import java.io.IOException;
import fi.iki.elonen.router.RouterNanoHTTPD;
import org.tinylog.jul.JulTinylogBridge;
import tr.com.github.bdagdeviren.kubernetes.config.Banner;
import tr.com.github.bdagdeviren.kubernetes.config.Properties;
import tr.com.github.bdagdeviren.kubernetes.handler.Index;
import tr.com.github.bdagdeviren.kubernetes.handler.impl.NotFound;

import static tr.com.github.bdagdeviren.kubernetes.config.Properties.port;

public class Server extends RouterNanoHTTPD {
    private static Server single_instance = null;

    private Server() {
        super(port);
    }

    public static Server getInstance(){
        if (single_instance == null)
            single_instance = new Server();
        return single_instance;
    }

    @Override
    public void addMappings() {
        Logger.info("Initialize all routes");
        setNotFoundHandler(NotFound.class);

        addRoute("/", Index.class);
        Logger.info("Successfully initialize all routes");
    }

    public void configure(){
        JulTinylogBridge.activate();
        Properties.parseConfig();
        Banner.write();
    }

    public void startServer() {
        try {
            configure();
            addMappings();
            start(SOCKET_READ_TIMEOUT, false);
            Logger.info("Running! Point your browsers to :"+ port);
        } catch (IOException ioe) {
            Logger.error("Couldn't start server -> " + ioe.getMessage());
        }
    }
}
