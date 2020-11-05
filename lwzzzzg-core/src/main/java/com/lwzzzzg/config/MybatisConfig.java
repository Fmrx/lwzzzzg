package com.lwzzzzg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lwzzzzg.mapper")
public class MybatisConfig {
}
