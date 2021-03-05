package com.ql.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/5 16:11
 */
@Component
public class AccountEventPublish {

    @Resource
    private ApplicationEventPublisher publisher;

    public void publish(String word) {
        publisher.publishEvent(new AccountEvent(this, new AccountData(word)));
    }
}
