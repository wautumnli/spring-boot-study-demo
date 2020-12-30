package com.ql.demo.rabbitmq.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:18
 **/
@Component
public class CallbackService implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(CallbackService.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            logger.warn("消息异常");
        } else {
            logger.info("发送者已经收到确认，correlationData={} ,ack={}, cause={}",
                    correlationData.getId(), ack, cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.warn("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={}",
                replyCode, replyText, exchange, routingKey);
    }
}