package com.poissonn.constance;

/**
 * 封装返回结果code，message
 */
public enum ResultCode {

    SUCCESS("0","成功"),
    FAILURE("1","失败");

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
