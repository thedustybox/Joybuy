package com.thedustybox.joybuy.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author thedustybox
 */
@ConfigurationProperties(prefix = "joybuy.thread")
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize = 20;

    private Integer maxSize = 200;

    private Integer keepAliveTime = 10;


}
