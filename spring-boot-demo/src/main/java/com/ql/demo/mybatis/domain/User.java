package com.ql.demo.mybatis.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String address;
    private Integer deleted;
}
