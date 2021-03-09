package com.ql.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Test
    public void test2() {
        Integer[] array = new Integer[10];
        System.out.println(array.length);
        List<Integer> integers = Arrays.asList(array);
    }
}
