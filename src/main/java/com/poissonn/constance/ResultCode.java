package com.poissonn.constance;

/**
 * 封装返回结果code，message
 */
public enum ResultCode {

    SUCCESS(0,"成功"),
    FAILURE(1,"失败");

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
