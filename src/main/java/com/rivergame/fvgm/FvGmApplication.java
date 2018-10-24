package com.rivergame.fvgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.rivergame.fvgm" })
@ServletComponentScan(basePackages = {"com.rivergame.fvgm.controller"})
public class FvGmApplication{

    public static void main(String[] args) {
        SpringApplication.run(FvGmApplication.class, args);
    }
}
