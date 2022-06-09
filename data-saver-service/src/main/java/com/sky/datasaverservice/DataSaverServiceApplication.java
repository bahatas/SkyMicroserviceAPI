package com.sky.datasaverservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@ComponentScan("com.sky")
public class DataSaverServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSaverServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
