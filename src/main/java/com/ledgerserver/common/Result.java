/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2023/10/13
 */
package com.ledgerserver.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6308315887056661996L;
    private Integer code;
    private String message;
    private T data;

    public Result<T> setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public Result<T> setResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.setData(data);
        return this;
    }
}
