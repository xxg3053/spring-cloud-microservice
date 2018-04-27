package com.kenfo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient  //只支持eureka
//@EnableDiscoveryClient //支持zk等其他注册中心
public class ProviderUserApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(ProviderUserApplication.class).run(args);

    }
}
