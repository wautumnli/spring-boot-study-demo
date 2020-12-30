package com.ql.demo.mybatis.api;

import com.ql.demo.common.api.Result;
import com.ql.demo.mybatis.dao.UserMapper;
import com.ql.demo.mybatis.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:03
 **/
@RestController
public class MybatisController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/mybaits/page")
    public Result page(Integer pageNo, Integer pageSize) {
        List<User> list = userMapper.queryPage(pageNo, pageSize);
        return Result.success(list);
    }
}
