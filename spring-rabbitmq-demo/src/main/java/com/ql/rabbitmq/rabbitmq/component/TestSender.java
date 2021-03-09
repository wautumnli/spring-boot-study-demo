package com.ql.rabbitmq.rabbitmq.component;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:15
 **/
@Component
public class TestSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void simpleSend() {
        rabbitTemplate.convertAndSend("hello", "hello, key");
    }

    public void workSend() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "当前消息编号" + i);
        }
    }

    public void fanoutSend() {
        rabbitTemplate.convertAndSend("fanout.exchange", "", "交换机发送消息");
    }

    public void directSend() {
        rabbitTemplate.convertAndSend("direct.exchange", "info", "info路由获取");
    }

    public void topicSend() {
        rabbitTemplate.convertAndSend("topic.exchange", "user.info", "user消息");
    }

    public void confirmSend() {
        rabbitTemplate.convertAndSend("confirm.exchange", "", "confirm消息我我爱爱你你 ",
                message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                }, new CorrelationData(UUID.randomUUID().toString()));
    }

}

