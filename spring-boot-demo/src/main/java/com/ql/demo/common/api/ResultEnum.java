package com.ql.demo.common.api;

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
