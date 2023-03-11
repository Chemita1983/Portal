package com.projects.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "portal")
public class PortalConfig {

    @NotNull
    private String timeout;

    @NotNull
    private String httpversion;

    @NotNull
    private String priority;

    @NotNull
    private String redirect;
}
