package com.ql.demo.rabbitmq.component;

import com.ql.demo.rabbitmq.config.DelayQueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2020-12-31 13:37
 **/
@Component
public class DelaySender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DelaySender.class);

    public void send(Integer delayTime) {
        rabbitTemplate.convertAndSend(DelayQueueConfig.DELAY_EXCHANGE, DelayQueueConfig.DELAY_ROUTING_KEY,"延时队列消息", message -> {
            message.getMessageProperties().setDelay(delayTime);
            return message;
        });
        logger.info("当前时间: {}, 消息发送", new Date());
    }
}
