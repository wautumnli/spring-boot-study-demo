package com.ql.demo.mybatis.domain;

import lombok.Data;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:01
 **/
@Data
public class User {

    private Integer id;
    private String name;
    private String address;
    private Integer deleted;
}
