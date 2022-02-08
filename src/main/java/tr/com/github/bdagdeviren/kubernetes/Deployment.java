package tr.com.github.bdagdeviren.kubernetes;

import com.ftpix.sparknnotation.Sparknotation;
import com.github.lalyos.jfiglet.FigletFont;
import org.apache.log4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Deployment {
    public static void main(String[] args) throws IOException {
        RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
        long pid = rt.getPid();
        MDC.put("PID", pid);

        ClassLoader classLoader = Deployment.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("small.flf");

        String asciiArt1 = FigletFont.convertOneLine(inputStream, "K8S");
        System.out.print(asciiArt1);

        Sparknotation.init();
    }
}
