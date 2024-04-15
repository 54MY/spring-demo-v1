package com.example.demo.util.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * PropertyCache
 *
 * @author Elio Arias
 * @since 1.0
 */
@Component
@Configuration
public class PropertyCache {

    private static final Logger logger = LoggerFactory.getLogger(PropertyCache.class);

    @Value("${server.port}")
    private int server_port;

    @Value("${mobarmy.properties.source}")
    private String mobarmy_properties_source;

    @Value("${test.api.properties}")
    public String test_api_properties;

    @Bean
    public void printProperties() {
        log("------------------------------------------------------------------------------------------");
        log("Propiedades con los que trabajara el modulo");
        log("------------------------------------------------------------------------------------------");
        log("server.port: " + server_port);
        log("mobarmy.properties.source: " + mobarmy_properties_source);
        log("test.api.properties: " + test_api_properties);
        log("------------------------------------------------------------------------------------------");
    }

    private void log(String textLog) {
        logger.info(textLog);
    }

}
