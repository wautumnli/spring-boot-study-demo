package com.ql.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/23 17:39
 */
@Slf4j
public class MessageMain {

    public static void main(String[] args) {
        asynEvnetBus();
    }

    // 同步
    public static void syncEventBus() {
        MessageListener listener = new MessageListener();
        final EventBus eventBus = new EventBus();
        eventBus.register(listener);
        eventBus.post(new MessageEvent("message event test"));
        eventBus.post(new MessageEvent("message event test again"));
        log.info("handle event count: {}", listener.getEventHandled());
    }

    // 异步
    public static void asynEvnetBus() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        MessageListener listener = new MessageListener();
        final AsyncEventBus eventBus = new AsyncEventBus("messageEventAsync", threadPoolExecutor);
        eventBus.register(listener);
        eventBus.post(new MessageEvent("message event test"));
        eventBus.post(new MessageEvent("message event test again"));
        log.info("handle event count: {}", listener.getEventHandled());
    }
}
