package com.ql.demo.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ql.demo.mybatis.dao")
public class MybatisConfig {
}
