package tr.com.github.bdagdeviren.kubernetes.config;

import org.tinylog.Logger;
import tr.com.github.bdagdeviren.kubernetes.server.Server;

import java.io.IOException;
import java.util.Locale;

public class Properties {
    public static int port;

    public static String artifactID;
    public static String descriptions;
    public static String version;

    public static void parseConfig(){
        try {
            java.util.Properties prop = new java.util.Properties();
            prop.load(Server.class.getClassLoader().getResourceAsStream("project.properties"));
            port = Integer.parseInt(prop.getProperty("port"));

            artifactID = prop.getProperty("name").toUpperCase(Locale.ENGLISH);
            descriptions = prop.getProperty("descriptions");
            version = prop.getProperty("version");

        } catch (IOException ioe) {
            Logger.error("Couldn't start server -> " + ioe.getMessage());
        }
    }

    public static void writeConfiguration(){
        Logger.info("Name -> "+artifactID);
        Logger.info("Descriptions -> "+descriptions);
        Logger.info("Version -> "+version);
    }
}
