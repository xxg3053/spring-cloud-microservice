# 服务消费端


## 添加ribbon支持
注解方式：
```
    @Bean
    @LoadBalanced //添加ribbon支持
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
```

代码自定义配置ribbon
```java
@Configuration
@RibbonClient(name = "foo", configuration = FooConfiguration.class)
public class TestConfiguration {
}
```
配置文件自定义ribbon
```
microservice-privider-user:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule
```

## 添加feign

```
 <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-feign</artifactId>
    </dependency>
```

```
启动类添加
@EnableFeignClients
```

添加接口
```
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    /**
     * 不能使用GetMapping
     * @PathVariable("id") 中value必须设置
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id")  Long id);
}
```


window查看端口进程
netstat -ano|findstr 7900  


## 使用Hystrix保护应用
添加依赖
```
 <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-hystrix</artifactId>
    </dependency>

```

启动类添加注解
```
@EnableCircuitBreaker
```

方法上添加注解
```
@HystrixCommand
```

## feign支持hystrix
配置文件
```
feign.hystrix.enabled=true
```