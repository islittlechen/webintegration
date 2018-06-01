# web integration
将目前主流的web开发组件进行集成，便于以后开箱即用。

dubboIntegraion: dubbo集成，使用zookeeper为服务注册中心。

springRedisIntegration：集成Spring redis 集群配置测试。

spring-boot-mybatis-integration：spring boot mybatis集成测试。

spring-cloud-integration-config-server：spring cloud 配置中心服务端集成。

spring-cloud-eureka-server： eureka server，集群模式。

spring-cloud-api-integration： 接口服务提供者，服务注册到eureka server，集成了hystrix 服务降级、熔断配置。

spring-cloud-eureka-consumer： 服务消费者，eureka服务发现，实现了FeignClient，LoadBalanced集成测试。

spring-cloud-zuul-integration：zuul 实现api网关功能，添加了eureka发现、服务限流功能。

spring-cloud-zipkin-server: 分布式服务调用链跟踪服务端。

spring-cloud-turbine: hystrix 服务性能监控。

未完待续。。。