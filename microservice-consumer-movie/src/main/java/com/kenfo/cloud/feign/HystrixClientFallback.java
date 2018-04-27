package com.kenfo.cloud.feign;

import com.kenfo.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.cloud.feign
 * @Description: feign 支持hystrix
 * @date 2018/4/27 下午10:57
 */
@Component
public class HystrixClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User u = new User();
        u.setId(0L);
        return u;
    }

    @Override
    public User postUser(User user) {
        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }
}
