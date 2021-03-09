package com.ql.rabbitmq.rabbitmq.component;

import com.ql.demo.rabbitmq.config.DelayQueueConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2020-12-31 13:39
 **/
@Component
public class DelayReceiver {

    private static final Logger logger = LoggerFactory.getLogger(DelayReceiver.class);

    @RabbitListener(queues = DelayQueueConfig.DELAY_QUEUE)
    public void handle(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        logger.info("接受到消息:{},时间:{}", msg, new Date());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
