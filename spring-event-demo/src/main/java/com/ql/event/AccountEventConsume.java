package com.ql.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/5 17:17
 */
@Component
public class AccountEventConsume {

    /**
     * @EventLister value可以指定监听事件类
     * @EventLister condition可以指定事件处理条件
     * @param accountEvent
     */
    @EventListener(value = {AccountEvent.class},
            condition = "#accountEvent.accountData.word == '01'")
    public void consume(AccountEvent accountEvent) {
        String data = JSON.toJSONString(accountEvent.getAccountData());
        System.out.println("consume:" + data);
    }

    @EventListener(value = {AccountEvent.class})
    public void error() {
        System.out.println("error");
    }
}
