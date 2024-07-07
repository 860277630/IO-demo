package com.gupaoedu.p5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class TestController {

    @GpReference
    IHelloService helloService;

    @GetMapping("/test")
    public String test(){
        return helloService.sayHello("Mic");
    }
}
