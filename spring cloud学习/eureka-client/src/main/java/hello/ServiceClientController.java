package hello;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Description TODO
 * @ClassName ServiceClientController
 * @Author Administrator
 * @Data 2018/12/15 21:16
 * @Version 1.0
 */

@Configuration
@RestController
public class ServiceClientController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable("name") String name) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://ServicePro/sayHello/" + "mjsq1" + name, String.class);
    }
}
