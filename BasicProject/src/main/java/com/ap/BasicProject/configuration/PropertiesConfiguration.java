package com.ap.BasicProject.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("person")
@Setter
@Getter
public class PropertiesConfiguration {

    private String name;
    private int age;
}
