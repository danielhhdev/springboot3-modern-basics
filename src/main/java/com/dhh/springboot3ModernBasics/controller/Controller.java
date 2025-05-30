package com.dhh.springboot3ModernBasics.controller;

import com.dhh.springboot3ModernBasics.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    private final TestService testService;

    public Controller(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Mundo") String name) {
        return testService.sayHello(name);
    }

    @GetMapping("/virtual-demo")
    public String demoVirtual(@RequestParam(defaultValue = "1000") long millis) throws InterruptedException {
        return testService.doHeavyWork(millis);
    }

}
