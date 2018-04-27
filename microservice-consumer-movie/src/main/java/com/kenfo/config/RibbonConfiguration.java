package com.kenfo.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.config
 * @Description: 通过代码自定义ribbon负载均衡规则
 * @date 2018/4/27 下午2:31
 */
@Configuration
public class RibbonConfiguration {

    @Autowired
    IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }
}
