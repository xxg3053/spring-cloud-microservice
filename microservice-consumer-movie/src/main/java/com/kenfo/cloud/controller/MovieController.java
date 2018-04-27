package com.kenfo.cloud.controller;

import com.kenfo.cloud.feign.UserFeignClient;
import com.kenfo.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.controller
 * @Description: TODO
 * @date 2018/4/26 下午10:31
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

//    @GetMapping("/movie/{id}")
//    public User findById(@PathVariable Long id){
//        return this.restTemplate.getForObject("http://localhost:7900/user/" + id, User.class);
//    }

/**
    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback",
            commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }


    public User findByIdFallback(Long id){
        User u = new User();
        u.setId(0L);
        u.setUsername("fallback");
        return u;
    }**/

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    /**
     * 测试feign的post提交
     *
     * http://localhost:7901/movie/test-post-user?id=1&username=zhangsan&name=zhangshan
     * @param user
     * @return
     */
    @GetMapping("/movie/test-post-user")
    public User postUser(User user){
        return userFeignClient.postUser(user);
    }

}
