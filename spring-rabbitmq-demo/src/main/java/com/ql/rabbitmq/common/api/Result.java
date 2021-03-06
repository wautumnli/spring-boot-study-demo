package com.ql.rabbitmq.common.api;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: wautumnli
 * @date: 2020-12-30 17:53
 * 结果统一返回类型
 **/
@Data
@Accessors(chain = true)
public class Result {

    private int code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode()).setMessage(ResultEnum.SUCCESS.getMessage())
                .setData(data);
        return result;
    }

    public static Result success() {
        return success("null");
    }

    public static Result error(int code, String message, Object data) {
        Result result = new Result();
        result.setCode(code).setMessage(message).setData(data);
        return result;
    }

    public static Result error(int code, String message) {
        return error(code, message, null);
    }

    public static Result error() {
        return error(404, "操作失败");
    }
}
