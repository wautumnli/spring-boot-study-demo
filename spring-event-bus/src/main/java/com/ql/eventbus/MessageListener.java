package com.ql.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/23 17:28
 */
@Slf4j
public class MessageListener {

    private static int eventHandled;

    @Subscribe
    @AllowConcurrentEvents
    public void handleEvent(MessageEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("do event info [" + event.getMessage() + "]");
        eventHandled++;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void eventWarn(MessageEvent event) {
        log.warn("do event warn [" + event.getMessage() + "]");
    }

    public int getEventHandled() {
        return eventHandled;
    }

}
