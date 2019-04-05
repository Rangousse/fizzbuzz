package com.fizzbuzz.backend;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Spring config parsing components and reading properties
 */
@Configuration
@ComponentScan("com.fizzbuzz.backend")
@PropertySource("classpath:application.properties")
public class SpringMainConfig implements EnvironmentAware {
    private static Environment env;

    @Override
    public void setEnvironment(final Environment env) {
        this.env = env;
    }

    public static String getProperty(String property) {
        return env.getProperty(property);
    }

    public static int getIntProperty(String property) {
        return Integer.valueOf(env.getProperty(property));
    }
}
