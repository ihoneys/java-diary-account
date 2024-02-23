package com.ledgerserver.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "认证失败"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "系统繁忙"),

    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空"),
    PARAMS_USER_IS_BLANK(1002, "用户名密码不能为空"),

    // 其他错误
    USER_ERROR(9999, "已存在用户名"),
    TOKEN_ERROR(9999,"token 生成错误"),
    USER_OR_PASSWORD_ERROR(9999,"用户名或密码错误");

    private final String message;
    private final Integer code;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
