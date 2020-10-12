package com.qiang.feign.client;


import org.springframework.stereotype.Component;

@Component
public class ServiceFallback implements ServiceFeignClient{
    @Override
    public void hello1() {
        System.out.println("服务错误！");
        throw new RuntimeException();
    }
}
