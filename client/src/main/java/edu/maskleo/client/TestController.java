package edu.maskleo.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/")
public class TestController {

    AtomicInteger count = new AtomicInteger();

    @RequestMapping("/hello")
    public String sayHello() {
        try {
            // 模拟业务处理
            Thread.sleep(50L);
        } catch (Exception e) {
        }
        count.decrementAndGet();
        return "hello world:" + count.get();
    }

}
