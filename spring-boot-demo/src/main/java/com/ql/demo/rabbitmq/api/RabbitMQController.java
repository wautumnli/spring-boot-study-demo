package com.ql.demo.rabbitmq.api;

import com.ql.demo.common.api.Result;
import com.ql.demo.rabbitmq.component.DelaySender;
import com.ql.demo.rabbitmq.component.TestSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:20
 **/
@RestController
public class RabbitMQController {

    @Resource
    private TestSender testSender;

    @Resource
    private DelaySender delaySender;

    @GetMapping("/rabbitmq/test")
    public Result test() {
        return Result.success();
    }

    @GetMapping("/rabbitmq/simpleSend")
    public Result simpleSend() {
        testSender.simpleSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/workSend")
    public Result workSend() {
        testSender.workSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/fanoutSend")
    public Result fanoutSend() {
        testSender.fanoutSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/directSend")
    public Result directSend() {
        testSender.directSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/topicSend")
    public Result topicSend() {
        testSender.topicSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/confirmSend")
    public Result confirmSend() {
        testSender.confirmSend();
        return Result.success();
    }

    @GetMapping("/rabbitmq/delaySend")
    public Result delaySend(@RequestParam Integer delayTime) {
        delaySender.send(delayTime);
        return Result.success();
    }
}
