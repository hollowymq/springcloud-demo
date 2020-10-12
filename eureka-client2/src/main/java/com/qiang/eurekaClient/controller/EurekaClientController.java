package com.qiang.eurekaClient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 重要，如果用Controller会404
@RequestMapping(value = "service")
public class EurekaClientController {

    @RequestMapping(value = "hello1")
    public void hello1() {
        System.out.println("EurekaClient2!");
    }
}
