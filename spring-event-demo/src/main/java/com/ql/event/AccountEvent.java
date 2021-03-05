package com.ql.event;

import org.springframework.context.ApplicationEvent;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/5 16:01
 */
public class AccountEvent extends ApplicationEvent {

    private AccountData accountData;

    public AccountEvent(Object source, AccountData accountData) {
        super(source);
        this.accountData = accountData;
    }

    public AccountData getAccountData() {
        return accountData;
    }
}
