package com.ql.mybatis.common.api;


/**
 * @author: wautumnli
 * @date: 2020-12-30 17:53
 **/
public enum ResultEnum implements ResultInterface{
    SUCCESS(200,"操作成功"),
    FAIL(404,"操作错误");

    private int code;
    private String message;

    private ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
