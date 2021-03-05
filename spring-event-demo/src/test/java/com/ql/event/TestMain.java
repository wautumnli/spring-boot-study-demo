package com.ql.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/5 17:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMain {

    @Resource
    private AccountEventPublish accountEventPublish;

    @Test
    public void test1() {
        accountEventPublish.publish("01");
    }
}
