package edu.maskleo.springcloudhystrix.controller;

import edu.maskleo.springcloudhystrix.service.CallDependencyService;
import edu.maskleo.springcloudhystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixService service;

    /**
     * 调用依赖的服务
     */
    @RequestMapping("/call")
    public String callDependencyService() {
        return service.callDependencyService();
    }

    @RequestMapping("/count")
    public String count() {
        return String.valueOf(CallDependencyService.count);
    }


    @RequestMapping("/invoke")
    public String invoke() {
        for (int i = 0; i < 100000; i++) {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/call", String.class);
            System.out.println(responseEntity.getBody());
        }
        return "OK!";
    }

}
