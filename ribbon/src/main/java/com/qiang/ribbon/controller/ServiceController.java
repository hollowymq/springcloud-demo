package com.qiang.ribbon.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    // 调用：localhost:6007/consumerServiceRibbon?token=1
    @RequestMapping("/consumerServiceRibbon")
    @HystrixCommand(fallbackMethod="consumerServiceRibbonFallback")
    public Object consumerServiceRibbon(){
        Object result = this.restTemplate.getForObject("http://springbootService:6003/service/hello1",Object.class);

        return result;
    }

    public String consumerServiceRibbonFallback(){
        return "consumerServiceRibbon异常，端口：" + port;
    }
}
