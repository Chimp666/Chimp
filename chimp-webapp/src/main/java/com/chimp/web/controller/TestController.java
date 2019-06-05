package com.chimp.web.controller;

import com.chimp.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    HelloService helloService;

    @GetMapping("/api/test")
    public String test(){
        return helloService.hiService("liuxing");
    }

}
