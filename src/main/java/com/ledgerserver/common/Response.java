/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2023/10/13
 */
package com.ledgerserver.common;

public class Response {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result success() {
        return new Result().setResult(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setResult(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode) {
        return new Result().setResult(resultCode);
    }

    public static Result failure(ResultCode resultCode, Object data) {
        return new Result().setResult(resultCode, data);
    }
}
