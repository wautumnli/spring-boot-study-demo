package com.ql.rabbitmq.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2020-12-31 11:08
 * 延时队列 -> 普通队列 + 死信队列
 **/
@Configuration
public class DelayQueueConfig {

    public static final String DELAY_EXCHANGE = "delayed.exchange";
    public static final String DELAY_QUEUE = "delayed.queue";
    public static final String DELAY_ROUTING_KEY = "delayed.routing.key";

    @Bean("delayExchange")
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, args);
    }

    @Bean("delayQueue")
    public Queue delayQueue() {
        return new Queue(DELAY_QUEUE);
    }

    @Bean
    public Binding delayBinding(@Qualifier("delayExchange") CustomExchange customExchange,
                                @Qualifier("delayQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAY_ROUTING_KEY).noargs();
    }

}
