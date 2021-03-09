package com.ql.mybatis.common.exception;

import com.ql.mybatis.common.api.ResultEnum;

/**
 * @author: wautumnli
 * @date: 2020-12-30 17:55
 **/
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