package org.cxj.integration.api.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "setting")
public class ApiConfiguration {

    private String apiName;

    private int maxExec;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public int getMaxExec() {
        return maxExec;
    }

    public void setMaxExec(int maxExec) {
        this.maxExec = maxExec;
    }
}
