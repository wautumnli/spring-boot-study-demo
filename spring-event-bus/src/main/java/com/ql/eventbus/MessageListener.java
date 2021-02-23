package com.ql.eventbus;

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
    public void handleEvent(MessageEvent event) {
        log.info("do event info [" + event.getMessage() + "]");
        eventHandled++;
    }

    @Subscribe
    public void eventWarn(MessageEvent event) {
        log.warn("do event warn [" + event.getMessage() + "]");
    }

    public int getEventHandled() {
        return eventHandled;
    }

}
