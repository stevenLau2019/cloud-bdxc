package com.bdxc.user.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName PatternProperties
 * @Author StevenLau
 * @Description TODO
 * @Date 2023/2/14 16:07
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
     private String dateformat;
     private String envSharedValue;
     private String name;
}
