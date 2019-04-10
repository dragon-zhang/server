package com.sa.server.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuccessZhang
 * @date 2019.1.2
 */
@Component
@Data
@ConfigurationProperties(prefix = "shopanywhere.ip")
public final class IpProperties {

    public String userTokenName;

    public String tokenName;

    private List<String> excludeIPs;

}
