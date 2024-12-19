package com.shj.restfulgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.shj.restfulgraphql.entity")
@EnableJpaRepositories(basePackages = "com.shj.restfulgraphql.repositories")
public class RestfulGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulGraphqlApplication.class, args);
    }

}


