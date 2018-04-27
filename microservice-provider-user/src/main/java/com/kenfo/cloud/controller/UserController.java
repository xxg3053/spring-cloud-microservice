package com.kenfo.cloud.controller;

import com.kenfo.cloud.entity.User;
import com.kenfo.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.controller
 * @Description: TODO
 * @date 2018/4/26 下午9:57
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.userRepository.findOne(id);
    }


    @GetMapping("/eureka-instance-info")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    /**
     *
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showinfo() {
        ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
        return instance;
    }


    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return user;
    }

}
