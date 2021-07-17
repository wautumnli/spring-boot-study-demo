package com.demo.ql;

import com.demo.ql.service.TranscationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscationTest {

    @Resource
    private TranscationService transcationService;

    @Test
    public void test1() {
        transcationService.insert();
    }
}
