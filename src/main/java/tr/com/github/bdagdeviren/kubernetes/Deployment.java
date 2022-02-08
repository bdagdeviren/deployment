package tr.com.github.bdagdeviren.kubernetes;

import com.ftpix.sparknnotation.Sparknotation;
import org.apache.log4j.MDC;
import tr.com.github.bdagdeviren.kubernetes.Config.Banner;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Locale;
import java.util.Properties;

public class Deployment {
    public static void main(String[] args) throws IOException {
        RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
        long pid = rt.getPid();
        MDC.put("PID", pid);

        Properties prop = new Properties();
        prop.load(Deployment.class.getClassLoader().getResourceAsStream("project.properties"));
        String name = prop.getProperty("name").toUpperCase(Locale.ROOT);
        String description = prop.getProperty("descriptions");
        String version = prop.getProperty("version");

        System.out.println(Banner.write(name,version,description));

        Sparknotation.init();
    }
}
