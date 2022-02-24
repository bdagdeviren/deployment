package tr.com.github.bdagdeviren.kubernetes;

import tr.com.github.bdagdeviren.kubernetes.server.Server;

public class Services {
    public static void main(String[] args) {
        Server.configure();
        Server.getInstance().startServer();
    }
}
