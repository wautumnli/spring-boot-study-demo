package com.ql.demo.mybatis.api;

import com.ql.demo.common.api.Result;
import com.ql.demo.mybatis.dao.UserMapper;
import com.ql.demo.mybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MybatisController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/mybatis/all")
    public Result all() {
        List<User> list = userMapper.queryAll();
        return Result.success(list);
    }

    @GetMapping("/mybaits/page")
    public Result page(Integer pageNo, Integer pageSize) {
        List<User> list = userMapper.queryPage(pageNo, pageSize);
        return Result.success(list);
    }
}
