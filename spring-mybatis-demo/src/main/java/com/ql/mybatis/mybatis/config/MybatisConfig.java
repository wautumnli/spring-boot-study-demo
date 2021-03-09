package com.ql.mybatis.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:03
 **/
@Configuration
@MapperScan("com.ql.mybatis.mybatis.dao")
public class MybatisConfig {
}
