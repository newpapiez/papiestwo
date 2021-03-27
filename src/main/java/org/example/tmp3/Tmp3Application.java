package org.example.tmp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication // TODO - delete exclusion
public class Tmp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tmp3Application.class, args);
    }

}
