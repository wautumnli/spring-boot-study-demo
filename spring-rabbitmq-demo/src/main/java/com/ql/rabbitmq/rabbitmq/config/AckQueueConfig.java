package com.ql.rabbitmq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wautumnli
 * @date: 2020-12-30 18:19
 **/
@Configuration
public class AckQueueConfig {

    @Bean(name = "confirmQueue")
    public Queue confirmQueue() {
        return new Queue("confirm.queue", true, false, false);
    }

    @Bean(name = "confirmExchange")
    public FanoutExchange confirmExchange() {
        return new FanoutExchange("confirm.exchange");
    }

    @Bean
    public Binding confirmBinding(@Qualifier("confirmQueue") Queue queue,
                                  @Qualifier("confirmExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
