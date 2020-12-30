package com.ql.demo.common.exception;

import com.ql.demo.common.api.ResultEnum;

public class BaseException extends RuntimeException {

    private int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code=" + code +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
