package tr.com.github.bdagdeviren.kubernetes;

import org.tinylog.jul.JulTinylogBridge;
import tr.com.github.bdagdeviren.kubernetes.config.Banner;
import tr.com.github.bdagdeviren.kubernetes.config.Properties;
import tr.com.github.bdagdeviren.kubernetes.server.Server;

import static tr.com.github.bdagdeviren.kubernetes.config.Properties.*;

public class Services {

    public static void main(String[] args) {
        JulTinylogBridge.activate();
        Properties.parseConfig();
        Banner.write();
        Server server = new Server(port);
        server.startServer();
    }
}
