package com.kenfo.cloud.feign;

import com.kenfo.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.cloud.feign
 * @Description: feign支持
 * @date 2018/4/27 下午4:10
 */
@FeignClient(name="microservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    /**
     * 不能使用GetMapping
     * @PathVariable("id") 中value必须设置
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id")  Long id);


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    //请求不会成功，如果请求参数是复杂对象，即使指定了get请求，feign依旧会以post方式提交
    @RequestMapping(value = "/user-test-get", method = RequestMethod.GET)
    public User getUser( User user);
}
