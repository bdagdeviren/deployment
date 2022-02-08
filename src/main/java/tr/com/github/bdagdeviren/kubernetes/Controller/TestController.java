package tr.com.github.bdagdeviren.kubernetes.Controller;

import com.ftpix.sparknnotation.annotations.SparkController;
import com.ftpix.sparknnotation.annotations.SparkGet;
import com.ftpix.sparknnotation.annotations.SparkParam;

@SparkController
public class TestController {

    @SparkGet("/hello/:name")
    public String hello(@SparkParam("name") String name){
        return "Hello "+ name;
    }
}
