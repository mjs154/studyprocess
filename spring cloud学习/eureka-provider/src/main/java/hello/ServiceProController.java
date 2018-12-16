package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @ClassName ServiceProController
 * @Author Administrator
 * @Data 2018/12/15 21:06
 * @Version 1.0
 */
@RestController
public class ServiceProController {
    @RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name) {
        return "{'msg': 'hello, " + name + "'}";
    }
}
