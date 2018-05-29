package org.cxj.eureka.consumer.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("API-INTEGRATION")
public interface HelloApiClient {

    @RequestMapping("api/configInfo")
    String apiConfigInfo();

}
