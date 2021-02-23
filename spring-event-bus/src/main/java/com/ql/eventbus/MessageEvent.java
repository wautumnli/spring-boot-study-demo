package com.ql.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/23 17:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEvent {

    private String message;
}
