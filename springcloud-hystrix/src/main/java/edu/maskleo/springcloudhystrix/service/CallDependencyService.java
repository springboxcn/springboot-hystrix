package edu.maskleo.springcloudhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 调用依赖服务，通过hystrix包装调用服务
 */
@Component
public class CallDependencyService {

    private Random random = new Random();

    public static AtomicInteger count = new AtomicInteger();

    /**
     * 模拟获取用户信息(通过网络调用)
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String mockGetUserInfo() {
        count.getAndIncrement();
        int randomInt = random.nextInt(10);
        if (randomInt < 8) {  //模拟调用失败情况
            throw new RuntimeException("call dependency service fail.");
        } else {
            return "UserName:liaokailin;number:" + randomInt;
        }
    }

    public String fallback() {
        return "some exception occur call fallback method.";
    }
}
