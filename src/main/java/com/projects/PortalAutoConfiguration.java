package com.projects;


import com.projects.beans.Portal;
import com.projects.config.PortalConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PortalConfig.class)
public class PortalAutoConfiguration {

    @Bean
    public Portal portal(PortalConfig config) {
        return new Portal(config);
    }
}
