package com.csc3402.security.formlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityException.class, ReactiveManagementWebSecurityAutoConfiguration.class})
public class FormLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormLoginApplication.class, args);
    }

}
