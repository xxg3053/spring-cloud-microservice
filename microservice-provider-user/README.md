# eureka服务注册

添加依赖
```
 <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
```

添加注解
```
@EnableEurekaClient
public class ProviderUserApplication{
}
```

添加配置
```
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka 

```

#### 健康检查
添加依赖
```
<dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-actuator</artifactId>
      </dependency>
```

添加配置
```
eureka:
  client:
    healthcheck:
      enabled: true
```
