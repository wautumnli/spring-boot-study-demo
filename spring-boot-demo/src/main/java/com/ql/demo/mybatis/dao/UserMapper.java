package com.ql.demo.mybatis.dao;

import com.ql.demo.mybatis.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> queryAll();

    public List<User> queryPage(int pageNo, int pageSize);
}
