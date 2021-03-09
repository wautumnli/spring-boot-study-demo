package com.ql.mybatis.mybatis.dao;

import com.ql.mybatis.mybatis.domain.User;

import java.util.List;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:02
 **/
public interface UserMapper {

    public List<User> queryPage(int pageNo, int pageSize);
}

