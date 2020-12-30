package com.ql.demo.rabbitmq.component;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:16
 * receive1 直连队列方式
 * receive2 receive3 work模式
 * receive4 receive5 fanout模式
 * receive6 direct模式
 * receive7 receive8 topic模式
 * receive9 ack确认 保证消息安全不丢失
 * 若暂时使用不到RabbitMQ 请注释@Component
 **/
@Component
public class TestReceiver {

    private static final Logger logger = LoggerFactory.getLogger(TestReceiver.class);

    @RabbitListener(queuesToDeclare = @Queue(value = "hello"))
    public void receive1(String message) {
        logger.info("receive1 message: {}", message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receive2(String message) {
        logger.info("receive2 message: {}", message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receive3(String message) {
        logger.info("receive3 message: {}", message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(value = "fanout.exchange", type = "fanout")
            )
    })
    public void receive4(String message) {
        logger.info("receive4 message: {}", message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(value = "fanout.exchange", type = "fanout")
            )
    })
    public void receive5(String message) {
        logger.info("receive5 message: {}", message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(value = "direct.exchange", type = "direct"), //默认类型就是direct
                    key = {"info", "warn", "error"}
            )
    })
    public void receive6(String message) {
        logger.info("receive6 message: {}", message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic.exchange", type = "topic"),
                    key = {"user.*"}
            )
    })
    public void receive7(String message) {
        logger.info("receive7 message: {}", message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic.exchange", type = "topic"),
                    key = {"admin.info", "admin.warn"}
            )
    })
    public void receive8(String message) {
        logger.info("receive8 message: {}", message);
    }

    @RabbitListener(queues = "confirm.queue")
    public void receive9(String msg, Channel channel, Message message) throws IOException {
        try {
            logger.info("收到消息: {}", msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e) {
            if (message.getMessageProperties().isRedelivered()) {
                logger.info("消息重复处理失败,已拒绝");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                logger.info("消息再次返回消息队列");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
}
