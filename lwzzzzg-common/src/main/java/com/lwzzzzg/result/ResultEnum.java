package com.lwzzzzg.result;

import lombok.Getter;

@Getter
public enum  ResultEnum implements ErrorCode{

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),

    TOKEN_ERROR(10001, "token不存在或者token格式不正确");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
