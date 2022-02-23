package tr.com.github.bdagdeviren.kubernetes.config;

import com.github.lalyos.jfiglet.FigletFont;
import org.tinylog.Logger;

import java.io.IOException;
import java.io.InputStream;

import static tr.com.github.bdagdeviren.kubernetes.config.Properties.version;
import static tr.com.github.bdagdeviren.kubernetes.config.Properties.artifactID;
import static tr.com.github.bdagdeviren.kubernetes.config.Properties.descriptions;

public class Banner {
    public static void write() {
        try {
            String resource = "Small.flf";
            InputStream in = Banner.class.getClassLoader().getResourceAsStream(resource);
            String asciiArt1 = FigletFont.convertOneLine(in,artifactID);
            int spaceLength = (asciiArt1.length()/5-2)-descriptions.length()-version.length()-2;
            String padded = ("  "+asciiArt1.trim()+"\n "+"=".repeat(asciiArt1.length()/5-2)+"\n "+descriptions+"-".repeat(spaceLength-1)+">"+"("+version+") \n");
            System.out.println(padded);
        } catch (IOException ioe) {
            Logger.error("Cannot loaded font file -> " + ioe.getMessage());
        }
    }
}
