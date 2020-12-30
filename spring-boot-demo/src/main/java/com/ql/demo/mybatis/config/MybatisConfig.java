package com.ql.demo.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:03
 **/
@Configuration
@MapperScan("com.ql.demo.mybatis.dao")
public class MybatisConfig {
}
