package com.lwzzzzg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Author fmrx
 * @Date 2020/10/31
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.lwzzzzg.mapper")
public class LwzzzzgCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwzzzzgCoreApplication.class, args);
    }


}
