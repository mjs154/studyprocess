package com.mjs.eurekapro;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @ClassName ServiceProController
 * @Author Administrator
 * @Data 2018/12/19 21:55
 * @Version 1.0
 */
@RestController
public class ServiceProController {
    @RequestMapping(value = "/queryUser/{name}",method = RequestMethod.GET)
    public User getUserbyName(@PathVariable("name") String name){
        User user = new User();
        user.setId("1");
        user.setAge(16);
        user.setName(name);
        return user;
    }
}
