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

spring-cloud-bus-kafka-config-server: 使用kafka作为事件总线实现应用配置刷新的配置服务端。

spring-cloud-bus-kafka: spring-cloud-bus-kafka-config-server 的客户端，通过访问服务器的bus/refresh刷新各客户端配置。

http-client-util: 常用的http client 请求工具类。有java原生的URLConnector和httpclient开源组件的两种实现。

my-spring-boot-start-by-annotation: 定义spring boot starter,my-spring-boot-module-pfile是一个简单实现。

未完待续。。。