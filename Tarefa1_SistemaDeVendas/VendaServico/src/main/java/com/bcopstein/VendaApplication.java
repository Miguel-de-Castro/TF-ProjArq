package com.bcopstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.bcopstein"})
@EnableJpaRepositories(basePackages = {"com.bcopstein"})
@EntityScan(basePackages = {"com.bcopstein"}) 
public class VendaApplication {
  public static void main(String[] args) {
    SpringApplication.run(VendaApplication.class, args);
  }
}
