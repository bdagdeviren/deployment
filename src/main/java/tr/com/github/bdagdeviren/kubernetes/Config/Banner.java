package tr.com.github.bdagdeviren.kubernetes.Config;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.io.InputStream;

public class Banner {
  public static String write(String name,String version,String description) throws IOException {
    String resource = "Small.flf";
    InputStream in = Banner.class.getClassLoader().getResourceAsStream(resource);
    String asciiArt1 = FigletFont.convertOneLine(in,name);
    int spaceLength = (asciiArt1.length()/5-2)-description.length()-version.length()-2;
    String padded = ("  "+asciiArt1.trim()+"\n "+"=".repeat(asciiArt1.length()/5-2)+"\n "+description+"-".repeat(spaceLength-1)+">"+"("+version+") \n");
    return padded;
  }
}
