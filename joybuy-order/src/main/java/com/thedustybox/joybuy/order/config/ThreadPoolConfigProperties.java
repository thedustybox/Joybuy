package com.thedustybox.joybuy.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: thedustybox
 * @createTime: 2024-06-23 20:28
 **/

@ConfigurationProperties(prefix = "gulimall.thread")
// @Component
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize = 20;

    private Integer maxSize = 200;

    private Integer keepAliveTime = 10;


}
