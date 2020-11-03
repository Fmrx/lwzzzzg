package com.zhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fmrx
 * @Date 2020/10/31
 */
@SpringBootApplication
@RestController
public class LwzzzzgCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwzzzzgCoreApplication.class, args);
    }



    @GetMapping(value = "/test")
    public String test() {
        return "hello world";
    }


}
