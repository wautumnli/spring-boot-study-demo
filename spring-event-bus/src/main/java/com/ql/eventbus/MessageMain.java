package com.ql.eventbus;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/23 17:39
 */
@Slf4j
public class MessageMain {

    public static void main(String[] args) {
        MessageListener listener = new MessageListener();
        final EventBus eventBus = new EventBus();
        eventBus.register(listener);
        eventBus.post(new MessageEvent("message event test"));
        eventBus.post(new MessageEvent("message event test again"));
        log.info("handle event count: {}", listener.getEventHandled());
    }
}
